package com.weh.websocket.response;

import com.weh.websocket.dispatcher.IResponseDispatcher;
import com.weh.websocket.dispatcher.ResponseDelivery;

import org.java_websocket.framing.Framedata;

/**
 * 接收到 Ping 数据
 */
public class PingResponse implements Response<Framedata> {

    private Framedata framedata;

    PingResponse() {
    }

    @Override
    public Framedata getResponseData() {
        return framedata;
    }

    @Override
    public void setResponseData(Framedata responseData) {
        this.framedata = responseData;
    }

    @Override
    public void onResponse(IResponseDispatcher dispatcher, ResponseDelivery delivery) {
        dispatcher.onPing(framedata, delivery);
    }

    @Override
    public void release() {
        framedata = null;
        ResponseFactory.releasePingResponse(this);
    }

    @Override
    public String toString() {
        return String.format("[@PingResponse%s->Framedata:%s]",
                hashCode(),
                framedata == null ?
                        "null" :
                        framedata.toString());
    }
}
