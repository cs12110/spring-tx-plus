package com.spring.seata.tx.business.service;

import com.spring.seata.tx.business.component.ServiceUrlComponent;
import com.spring.seata.tx.common.exception.BizException;
import com.spring.seata.tx.common.model.response.BizResponse;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 17:46
 * <p>
 * @since 1.0.0
 */
@Slf4j
@Service
public class BusinessService {

    @Resource
    private ServiceUrlComponent serviceUrlComponent;

    @Resource
    private RestTemplate restTemplate;

    /**
     * 使用分布式事务,commitOrder && commitStorage == true时,全局事务才会提交,如果其中一个是false,全局事务回滚.
     *
     * @param commitOrder   提交订单
     * @param commitStorage 提交库存
     * @return BizResponse
     */
    @GlobalTransactional
    public BizResponse doBusiness(boolean commitOrder, boolean commitStorage) {
        log.info("doBusiness,commitOrder:{},commitStorage:{}", commitOrder, commitStorage);
        try {
            callOrderService(commitOrder);
            callStorageService(commitStorage);
        } catch (Exception e) {
            log.error("doBusiness,commitOrder:" + commitOrder + ",commitStorage:" + commitStorage, e);
            throw new BizException("error:" + e.getMessage());
        }

        return BizResponse.createSuccessResponse(commitStorage);
    }

    /**
     * 不使用全局事务
     *
     * @param commitOrder   提交订单
     * @param commitStorage 提交库存
     * @return BizResponse
     */
    public BizResponse doBusinessWithoutTx(boolean commitOrder, boolean commitStorage) {
        log.info("doBusinessWithoutTx,commitOrder:{},commitStorage:{}", commitOrder, commitStorage);
        try {
            callOrderService(commitOrder);
            callStorageService(commitStorage);
        } catch (Exception e) {
            log.error("doBusinessWithoutTx,commitOrder:" + commitOrder + ",commitStorage:" + commitStorage, e);
            throw new BizException("error:" + e.getMessage());
        }

        return BizResponse.createSuccessResponse(commitStorage);
    }


    private void callOrderService(boolean commit) {
        String url = serviceUrlComponent.getOrderUrl() + "/api/order/handleWithOrder?commit=" + commit;

        ResponseEntity<BizResponse> result = restTemplate.getForEntity(url, BizResponse.class);

        log.info("Function[callOrderService] result:{}", result.getBody());
    }

    private void callStorageService(boolean commit) {
        String url = serviceUrlComponent.getStorageUrl() + "/api/storage/handleWithStorage?commit=" + commit;

        ResponseEntity<BizResponse> result = restTemplate.getForEntity(url, BizResponse.class);

        log.info("Function[callStorageService] result:{}", result.getBody());
    }

}
