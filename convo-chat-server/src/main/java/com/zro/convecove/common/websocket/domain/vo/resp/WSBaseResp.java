package com.zro.convecove.common.websocket.domain.vo.resp;

/**
 * @Author: zro
 * @CreateTime: 2024-05-30
 * @Description:
 * @Version: 1.0
 */
public class WSBaseResp<T> {

    /**
     * @see com.zro.convecove.common.websocket.domain.enums.WSRespTypeEnum
     */
    private Integer type;
    private T data;
}
