package com.xiaopeng.libconfig.ipc.event;
/* loaded from: classes.dex */
public class Account2MqttEvent {
    public int msgType;
    public String value;

    public Account2MqttEvent(int i) {
        this.msgType = i;
    }

    public int getMsgType() {
        return this.msgType;
    }

    public String getValue() {
        return this.value;
    }

    public void setMsgType(int i) {
        this.msgType = i;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public String toString() {
        StringBuilder a = jg.a("Account2MqttEvent{msgType=");
        a.append(this.msgType);
        a.append(", value='");
        a.append(this.value);
        a.append('\'');
        a.append('}');
        return a.toString();
    }
}
