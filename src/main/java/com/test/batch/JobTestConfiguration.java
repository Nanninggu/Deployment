package com.test.batch;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
@Slf4j
@RequiredArgsConstructor
@Configuration
public class JobTestConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job simpleJob() {
        return jobBuilderFactory.get("@SpringBootApplication_simpleJob")
                .start(simpleStep1())
                .build();
    }

    @Bean
    public Step simpleStep1() {
        return stepBuilderFactory.get("@SpringBootApplication_simpleStep1")
                .tasklet(((contribution, chunkContext) -> {
                    log.info(">>>> This is Step1 of simplejob_@SpringBootApplication");
                    log.info("------------------END of SimpleJob----------------");
                    return RepeatStatus.FINISHED;
                }))
                .build();
    }
}
