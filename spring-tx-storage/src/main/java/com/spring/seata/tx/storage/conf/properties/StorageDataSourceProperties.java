package com.spring.seata.tx.storage.conf.properties;

import com.alibaba.fastjson.JSON;
import com.spring.seata.tx.common.conf.properties.BasicDataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:12
 * <p>
 * @since 1.0.0
 */
@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class StorageDataSourceProperties extends BasicDataSourceProperties {

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
