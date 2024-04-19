package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;
/* loaded from: classes.dex */
public interface IWebSocketInfo {
    public static final int CODE_NORMAL = 0;

    /* loaded from: classes.dex */
    public enum STATE {
        OPEN,
        CLOSED
    }

    cl0 byteStringMessage();

    String closedReason();

    int closedReasonCode();

    boolean isClosed();

    boolean isOnOpen();

    boolean isOnReconnect();

    String stringMessage();
}
