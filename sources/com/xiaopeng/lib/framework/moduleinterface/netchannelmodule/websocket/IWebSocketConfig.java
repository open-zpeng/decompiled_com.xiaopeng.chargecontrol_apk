package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;

import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
/* loaded from: classes.dex */
public interface IWebSocketConfig {
    void apply();

    IWebSocketConfig client(rk0 client);

    IWebSocketConfig disableLog();

    IWebSocketConfig pingInterval(long interval);

    IWebSocketConfig reconnectInterval(long interval);

    IWebSocketConfig showLog();

    IWebSocketConfig showLog(String logTag);

    IWebSocketConfig sslSocketFactory(SSLSocketFactory sslSocketFactory, X509TrustManager trustManager);
}
