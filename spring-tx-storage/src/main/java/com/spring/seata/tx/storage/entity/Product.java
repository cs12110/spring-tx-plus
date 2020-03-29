package com.spring.seata.tx.storage.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author HelloWood
 */
@Data
@TableName(value = "product")
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private Double price;

    private Integer stock;

    private Date lastUpdateTime;
}
