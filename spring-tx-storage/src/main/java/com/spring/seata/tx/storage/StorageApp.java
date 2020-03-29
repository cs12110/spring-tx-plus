package com.spring.seata.tx.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 00:33
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.spring.seata.tx"
})
public class StorageApp {

    public static void main(String[] args) {
        SpringApplication.run(StorageApp.class, args);
    }
}
