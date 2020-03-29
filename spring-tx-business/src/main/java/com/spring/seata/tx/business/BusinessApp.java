package com.spring.seata.tx.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 17:24
 * <p>
 * @since 1.0.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {
        "com.spring.seata.tx"
})
public class BusinessApp {


    public static void main(String[] args) {
        SpringApplication.run(BusinessApp.class, args);
    }
}
