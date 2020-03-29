package com.spring.seata.tx.business.component;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 17:58
 * <p>
 * @since 1.0.0
 */
@Component
@Data
@ConfigurationProperties(prefix = "service")
public class ServiceUrlComponent {

    private String accountUrl;
    private String orderUrl;
    private String storageUrl;

}