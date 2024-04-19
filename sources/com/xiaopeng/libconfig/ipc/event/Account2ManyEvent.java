package com.xiaopeng.libconfig.ipc.event;
/* loaded from: classes.dex */
public class Account2ManyEvent {
    public static final int CODE_SHOW_BIG_WINDOW = 1;
    public static final int TYPE_CHANGE_ACCOUNT = 2;
    public static final int TYPE_ONLINE_ACCOUNT = 1;
    public int code;
    public int msgType;
    public String msgValue;

    public int getCode() {
        return this.code;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getMsgValue() {
        return this.msgValue;
    }

    public void setCode(int i) {
        this.code = i;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setMsgValue(String str) {
        this.msgValue = str;
    }

    public String toString() {
        StringBuilder a = jg.a("Account2ManyEvent{msgType=");
        a.append(this.msgType);
        a.append(", msgValue='");
        jg.a(a, this.msgValue, '\'', ", code=");
        a.append(this.code);
        a.append('}');
        return a.toString();
    }
}
