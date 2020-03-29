package com.spring.seata.tx.order;

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
@ComponentScan(value = {
        "com.spring.seata.tx",
})
public class OrderApp {

    public static void main(String[] args) {
        SpringApplication.run(OrderApp.class, args);
    }
}
