package com.spring.seata.tx.common.interceptor;

import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;

import java.io.IOException;

/**
 * 设置请求的头部xid
 *
 * <p>
 *
 * @author cs12110 create at 2020-03-29 12:02
 * <p>
 * @since 1.0.0
 */
@Slf4j
public class SeataRestTemplateInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper wrapper = new HttpRequestWrapper(request);

        String xid = RootContext.getXID();

        if (StringUtils.isNotEmpty(xid)) {
            log.info("Function[interceptor] wrapper xid:{}", xid);
            wrapper.getHeaders().add(RootContext.KEY_XID, xid);
        }

        return execution.execute(wrapper, body);
    }

}
