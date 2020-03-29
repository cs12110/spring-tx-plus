package com.spring.seata.tx.order.ctrl;

import com.spring.seata.tx.common.model.response.BizResponse;
import com.spring.seata.tx.order.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 01:02
 * <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/order")
public class OrderCtrl {

    @Resource
    private OrderService orderService;

    @RequestMapping("/handleWithOrder")
    @ResponseBody
    public BizResponse handleWithOrder(boolean commit) {
        return orderService.handleWithOrder(commit);
    }
}
