package com.test.kms;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.kms.AWSKMS;
import com.amazonaws.services.kms.AWSKMSClientBuilder;
import com.amazonaws.services.kms.model.DecryptRequest;
import com.amazonaws.services.kms.model.EncryptRequest;
import com.amazonaws.services.kms.model.EncryptResult;
import com.amazonaws.services.kms.model.EncryptionAlgorithmSpec;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Component
public class AWSCipher {
    private static String keyId;

    @Value("${aws.kms.keyId}")
    private void setPrvKeyValue(String key) {
        keyId = key;
    }

    /**
     * 암호화
     *
     * @param plaintext
     * @return
     */
    public static String encrypt(String plaintext) {

        if (null == plaintext) {
            return null;
        } else if ("".equals(plaintext)) {
            return "";
        }

        try {

            AWSKMS kmsClient = AWSKMSClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_2).build();

            EncryptRequest request = new EncryptRequest();
            request.withKeyId(keyId);
            request.withPlaintext(ByteBuffer.wrap(plaintext.getBytes(StandardCharsets.UTF_8)));
            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);

            EncryptResult result = kmsClient.encrypt(request);
            ByteBuffer ciphertextBlob = result.getCiphertextBlob();

            return new String(Base64.encodeBase64(ciphertextBlob.array()));

        } catch (RuntimeException e) {
            log.error("Encrypt Error");
        }

        return plaintext;
    }

    /**
     * 복호화
     *
     * @param encryptText
     * @return
     */
    public static String decrypt(String encryptText) {

        if (null == encryptText) {
            return null;
        } else if ("".equals(encryptText)) {
            return "";
        }

        try {

            AWSKMS kmsClient = AWSKMSClientBuilder.standard().withRegion(Regions.AP_NORTHEAST_2).build();

            DecryptRequest request = new DecryptRequest();
            request.withKeyId(keyId);
            request.withEncryptionAlgorithm(EncryptionAlgorithmSpec.RSAES_OAEP_SHA_256);
            request.withCiphertextBlob(ByteBuffer.wrap(Base64.decodeBase64(encryptText)));

            ByteBuffer plaintext = kmsClient.decrypt(request).getPlaintext();

            return new String(plaintext.array());

        } catch (RuntimeException e) {
            log.error("Decrypt Error");
        }

        return encryptText;
    }
}

