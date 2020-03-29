package com.spring.seata.tx.common.conf;

import com.spring.seata.tx.common.interceptor.SeataRestTemplateInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 11:55
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Configuration
public class SeataRestTemplateAutoConfiguration {

    @Autowired(required = false)
    private Collection<RestTemplate> restTemplates;


    @Resource
    private SeataRestTemplateInterceptor seataRestTemplateInterceptor;


    @Bean(name = "seataRestTemplateInterceptor")
    public SeataRestTemplateInterceptor createSeataRestTemplateInterceptor() {
        return new SeataRestTemplateInterceptor();
    }


    /**
     * 初始化,添加restTemplate的拦截器
     */
    @PostConstruct
    public void init() {
        if (null != restTemplates && !restTemplates.isEmpty()) {
            for (RestTemplate rt : restTemplates) {
                // 添加seata拦截器
                List<ClientHttpRequestInterceptor> interceptors = rt.getInterceptors();
                interceptors.add(seataRestTemplateInterceptor);

                rt.setInterceptors(interceptors);
            }
        }
    }
}
