package com.weh.websocket;

import com.weh.websocket.request.Request;
import com.weh.websocket.response.Response;

/**
 * {@link WebSocketWrapper} 监听器
 */
public interface SocketWrapperListener {

    /**
     * 连接成功
     */
    void onConnected();

    /**
     * 连接失败
     */
    void onConnectFailed(Throwable e);

    /**
     * 连接断开
     */
    void onDisconnect();

    /**
     * 数据发送失败
     *
     * @param request 发送的请求
     * @param type    失败类型：{@link com.weh.websocket.response.ErrorResponse#ERROR_NO_CONNECT} 未连接、
     *                {@link com.weh.websocket.response.ErrorResponse#ERROR_UNKNOWN} 未知错误、
     *                {@link com.weh.websocket.response.ErrorResponse#ERROR_UN_INIT} 初始化未完成
     */
    void onSendDataError(Request request, int type, Throwable tr);

    /**
     * 接收到消息
     */
    void onMessage(Response message);
}
