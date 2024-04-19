package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;
/* loaded from: classes.dex */
public interface IRxWebSocket {
    void close(String url);

    IWebSocketConfig config();

    ah0<IWebSocketInfo> get(String url);

    ah0<IWebSocketInfo> get(String url, long timeout);

    IRxWebSocket header(String key, String value);

    void send(String url, cl0 byteString);

    void send(String url, String msg);
}
