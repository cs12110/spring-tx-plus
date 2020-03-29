package com.spring.seata.tx.storage.service;

import com.spring.seata.tx.common.exception.BizException;
import com.spring.seata.tx.common.model.response.BizResponse;
import com.spring.seata.tx.storage.entity.Product;
import com.spring.seata.tx.storage.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 19:09
 * <p>
 * @since 1.0.0
 */
@Service
@Slf4j
public class StorageService {

    @Resource
    private ProductMapper productMapper;

    public BizResponse handleWithStorage(boolean commit) {
        Product product = new Product();
        product.setLastUpdateTime(new Date());
        product.setPrice(100.95);
        product.setStock(1900);

        productMapper.insert(product);

        if (!commit) {
            throw new BizException("storage rollback");
        }

        return BizResponse.createSuccessResponse(product);
    }
}
