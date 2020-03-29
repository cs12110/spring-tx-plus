package com.spring.seata.tx.common.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 00:40
 * <p>
 * @since 1.0.0
 */
@AllArgsConstructor
@Getter
public enum BizCode {
    /**
     * 成功:1
     */
    SUCCESS(1, "成功"),
    /**
     * 失败:0
     */
    FAILURE(0, "失败");

    private final Integer code;
    private final String desc;
}
