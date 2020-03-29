package com.spring.seata.tx.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;


/**
 * @author seata
 */
@Data
@TableName(value = "orders")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Long userId;

    private Long productId;

    private Integer status;

    private Integer payAmount;
}
