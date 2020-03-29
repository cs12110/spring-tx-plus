package com.spring.seata.tx.order.service;

import com.spring.seata.tx.common.exception.BizException;
import com.spring.seata.tx.common.model.response.BizResponse;
import com.spring.seata.tx.order.entity.Order;
import com.spring.seata.tx.order.mapper.OrderMapper;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 00:59
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;

    public BizResponse handleWithOrder(boolean commit) {
        log.info("Function[handleWithOrder] xid:{}", RootContext.getXID());


        Order order = new Order();
        order.setPayAmount(10);
        order.setProductId(1L);
        order.setStatus(1);
        order.setUserId(1L);

        orderMapper.insert(order);

        if(!commit){
            throw  new BizException("Order rollback");
        }

        return BizResponse.createSuccessResponse(order);
    }
}
