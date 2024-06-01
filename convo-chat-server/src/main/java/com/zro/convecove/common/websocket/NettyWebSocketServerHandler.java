package com.zro.convecove.common.websocket;

import cn.hutool.json.JSONUtil;
import com.zro.convecove.common.websocket.domain.enums.WSReqTypeEnum;
import com.zro.convecove.common.websocket.domain.enums.WSRespTypeEnum;
import com.zro.convecove.common.websocket.domain.vo.req.WSBaseReq;
import io.github.classgraph.json.JSONUtils;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: zro
 * @CreateTime: 2024-05-28
 * @Description:
 * @Version: 1.0
 */

@Slf4j
@ChannelHandler.Sharable
public class NettyWebSocketServerHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {



    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof WebSocketServerProtocolHandler.HandshakeComplete) {
            log.info("握手成功");
        }else if (evt instanceof IdleStateHandler){
            IdleStateEvent event = (IdleStateEvent) evt;
            if (event.state() == IdleState.READER_IDLE) {
                log.info("心跳检测");
            }
        }
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, TextWebSocketFrame textWebSocketFrame) throws Exception {
        String text = textWebSocketFrame.text();
        log.info("收到消息: " + text);
        WSBaseReq wsBaseReq = JSONUtil.toBean(text, WSBaseReq.class);
        switch (WSReqTypeEnum.of(wsBaseReq.getType())) {
            case LOGIN ->{
                log.info("登录请求");
                channelHandlerContext.channel().writeAndFlush(new TextWebSocketFrame("213"));
            }
            case AUTHORIZE ->{
                log.info("认证请求");
            }
            case HEARTBEAT -> {
                log.info("心跳请求");
            }
            default ->{
                log.info("未知请求");
            }
        }
    }
}
