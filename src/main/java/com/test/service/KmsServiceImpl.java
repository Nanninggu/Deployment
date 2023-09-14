package com.test.service;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;
import com.amazonaws.services.kms.model.EncryptionAlgorithmSpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
public class KmsServiceImpl {
    @Value("${aws.kms.keyId}")
    private String KEY_ID;

    @Autowired KmsService kmsService;

    public String encrypt(String staff_email, String name) {
        try {
            AWSKMS kmsClient = AWSKMSClientBuilder.standard()
                    .withRegion(Regions.AP_NORTHEAST_2)
                    .build();

            EncryptRequest request = new EncryptRequest();
            request.withKeyId(KEY_ID);
            request.withPlaintext(ByteBuffer.wrap(staff_email.getBytes(StandardCharsets.UTF_8)));
            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);

            EncryptResult result = kmsClient.encrypt(request);
            ByteBuffer ciphertextBlob = result.getCiphertextBlob();

            // 암호화 값을 가져와서 String으로 담는다.
            String result_encrypt = new String(Base64.encodeBase64(ciphertextBlob.array()));

            // 암호화 값 log로 확인하기
            log.info("result_encrypt :: " + result_encrypt);

            // DB INSERT
            kmsService.encrypt_insert_email(result_encrypt, name);

            return new String(Base64.encodeBase64(ciphertextBlob.array()));
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }

    public String decrypt(String name) {
        try {
            AWSKMS kmsClient = AWSKMSClientBuilder.standard()
                    .withRegion(Regions.AP_NORTHEAST_2)
                    .build();

            // 암호화된 값을 DB에서 가져온다.
            String encrypted_value = kmsService.get_encrypt_value(name);

            DecryptRequest request = new DecryptRequest();
            request.withCiphertextBlob(ByteBuffer.wrap(Base64.decodeBase64(encrypted_value)));
            request.withKeyId(KEY_ID);
            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);
            ByteBuffer plainText = kmsClient.decrypt(request).getPlaintext();

            // 암호화 값을 가져와서 String에 담는다.
            String result_decrypt = new String(plainText.array());

            // 복호화된 값을 화면에 출력한다.
            log.info("복호화된 값 ::" + result_decrypt);
            return new String(plainText.array());
        } catch (Exception e) {
            log.error(e.getMessage());
            return null;
        }
    }
}
