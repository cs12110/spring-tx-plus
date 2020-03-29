package com.spring.seata.tx.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 19:04
 * <p>
 * @since 1.0.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }

    private Integer code;

}
