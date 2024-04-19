package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.websocket;
/* loaded from: classes.dex */
public abstract class WebSocketSubscriber implements ch0<IWebSocketInfo> {
    public kh0 disposable;
    public boolean hasOpened;

    public final void dispose() {
        kh0 kh0Var = this.disposable;
        if (kh0Var != null) {
            kh0Var.a();
        }
    }

    public void onClose() {
    }

    public void onClosed(int code, String reason) {
    }

    @Override // defpackage.ch0
    public final void onComplete() {
        if (this.hasOpened) {
            onClose();
        }
    }

    @Override // defpackage.ch0
    public void onError(Throwable e) {
        e.printStackTrace();
    }

    public void onMessage(cl0 byteString) {
    }

    public void onMessage(String text) {
    }

    public void onOpen() {
    }

    public void onReconnect() {
    }

    @Override // defpackage.ch0
    public final void onSubscribe(kh0 disposable) {
        this.disposable = disposable;
    }

    @Override // defpackage.ch0
    public final void onNext(IWebSocketInfo webSocketInfo) {
        if (webSocketInfo.isOnOpen()) {
            this.hasOpened = true;
            onOpen();
        } else if (webSocketInfo.isClosed()) {
            this.hasOpened = false;
            onClosed(webSocketInfo.closedReasonCode(), webSocketInfo.closedReason());
        } else if (webSocketInfo.stringMessage() != null) {
            onMessage(webSocketInfo.stringMessage());
        } else if (webSocketInfo.byteStringMessage() != null) {
            onMessage(webSocketInfo.byteStringMessage());
        } else if (webSocketInfo.isOnReconnect()) {
            onReconnect();
        }
    }
}
