package com.zro.convecove.common.websocket.domain.vo.req;

import lombok.Data;

/**
 * @Author: zro
 * @CreateTime: 2024-05-30
 * @Description:
 * @Version: 1.0
 */


@Data
public class WSBaseReq {

    /**
     * @see com.zro.convecove.common.websocket.domain.enums.WSReqTypeEnum
     */
    private Integer type;
    private String data;
}
