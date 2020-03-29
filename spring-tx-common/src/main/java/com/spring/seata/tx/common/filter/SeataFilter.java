package com.spring.seata.tx.common.filter;

import com.alibaba.fastjson.JSON;
import io.seata.core.context.RootContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 01:21
 * <p>
 * @since 1.0.0
 */
@Component
@Slf4j
public class SeataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        displayHeader(httpServletRequest);


        // 获取请求头部的xid
        boolean isBind = false;
        String xid = httpServletRequest.getHeader(RootContext.KEY_XID.toLowerCase());

        if (StringUtils.isNotEmpty(xid)) {
            RootContext.bind(xid);
            isBind = true;
        }

        try {
            // 不进行异常捕抓
            chain.doFilter(request, response);
        } finally {
            if (isBind) {
                RootContext.unbind();
            }
        }
    }


    /**
     * 打印请求头部
     *
     * @param httpServletRequest {@link HttpServletRequest}
     */
    private void displayHeader(HttpServletRequest httpServletRequest) {
        Map<String, Object> headerMap = new HashMap<>(16);

        Enumeration<String> headerNames = httpServletRequest.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String element = headerNames.nextElement();
            headerMap.put(element, httpServletRequest.getHeader(element));
        }

        log.info("Function[displayHeader] request header:{}", JSON.toJSONString(headerMap, true));
    }

    @Override
    public void destroy() {

    }
}
