package com.spring.seata.tx.common.conf.properties;

import lombok.Data;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-28 12:14
 * <p>
 * @since 1.0.0
 */
@Data
public class BasicDataSourceProperties {

    protected String url;
    protected String username;
    protected String password;
    protected String driver;
}
