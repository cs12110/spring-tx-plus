package com.spring.seata.tx.storage.ctrl;

import com.spring.seata.tx.common.model.response.BizResponse;
import com.spring.seata.tx.storage.service.StorageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 19:09
 * <p>
 * @since 1.0.0
 */
@Controller
@RequestMapping("/api/storage")
public class StorageCtrl {

    @Resource
    private StorageService storageService;

    @RequestMapping("/handleWithStorage")
    @ResponseBody
    public BizResponse handleWithStorage(boolean commit) {
        return storageService.handleWithStorage(commit);
    }
}
