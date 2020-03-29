package com.spring.seata.tx.business.ctrl;

import com.spring.seata.tx.business.service.BusinessService;
import com.spring.seata.tx.common.model.response.BizResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 17:45
 * <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/business/")
public class BusinessCtrl {

    @Resource
    private BusinessService businessService;

    @RequestMapping("/deal")
    @ResponseBody
    public BizResponse business(boolean commitOrder,boolean commitStorage) {
        return businessService.doBusiness(commitOrder,commitStorage);
    }
}
