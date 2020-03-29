package com.spring.seata.tx.common.model.response;

import com.alibaba.fastjson.JSON;
import com.spring.seata.tx.common.model.enums.BizCode;
import lombok.Data;

import java.util.List;

/**
 * <p>
 *
 * @author cs12110 create at 2020-03-29 00:41
 * <p>
 * @since 1.0.0
 */
@Data
public class BizResponse {

    private Integer code;
    private String message;
    private Object data;
    private List<Object> list;


    public static <T> BizResponse createSuccessResponse(T data) {
        BizResponse response = new BizResponse();
        response.setCode(BizCode.SUCCESS.getCode());
        response.setData(data);
        response.setList(null);

        return response;
    }


    public static <T> BizResponse createFailureResponse(String message) {
        BizResponse response = new BizResponse();
        response.setCode(BizCode.FAILURE.getCode());
        response.setData(null);
        response.setList(null);
        response.setMessage(message);

        return response;
    }


    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
