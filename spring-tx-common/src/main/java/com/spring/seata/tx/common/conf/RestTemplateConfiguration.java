package com.spring.seata.tx.common.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 00:23
 * <p>
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class RestTemplateConfiguration {

    private static final int TIME_OUT_SEC = 30;


    /**
     * 构建 RestTemplate
     *
     * @return RestTemplate
     */
    @Bean(name = "restTemplate")
    public RestTemplate createRestTemplate() {
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplateBuilder.setReadTimeout(TIME_OUT_SEC);
        restTemplateBuilder.setConnectTimeout(TIME_OUT_SEC);

        log.info("Function[createRestTemplate] timeout:{}s", TIME_OUT_SEC);

        return restTemplateBuilder.build();
    }
}
