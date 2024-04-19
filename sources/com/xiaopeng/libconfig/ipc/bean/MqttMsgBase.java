package com.xiaopeng.libconfig.ipc.bean;
/* loaded from: classes.dex */
public class MqttMsgBase<T> {
    public static final int CONTROL_MSG = 2;
    public static final int HEART_BEAT_MSG = 4;
    public static final int OPERATION_FEEDBACK_MSG = 1;
    public static final int SERVER_MSG = 3;
    public static final int UNREAD_MSG = 0;
    public T msg_content;
    public String msg_id;
    public String msg_ref;
    public int msg_type;
    public int service_type = -1;

    public MqttMsgBase(int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(20);
        sb.append(i);
        sb.append(System.currentTimeMillis());
        sb.append((int) (Math.random() * 10.0d));
        sb.append((int) (Math.random() * 10.0d));
        this.msg_id = sb.toString();
    }

    public T getMsgContent() {
        return this.msg_content;
    }

    public String getMsgId() {
        return this.msg_id;
    }

    public String getMsgRef() {
        return this.msg_ref;
    }

    public int getMsgType() {
        return this.msg_type;
    }

    public int getServiceType() {
        return this.service_type;
    }

    public void setMsgContent(T t) {
        this.msg_content = t;
    }

    public void setMsgId(String str) {
        this.msg_id = str;
    }

    public void setMsgRef(String str) {
        this.msg_ref = str;
    }

    public void setMsgType(int i) {
        this.msg_type = i;
    }

    public void setServiceType(int i) {
        this.service_type = i;
    }

    public String toString() {
        StringBuilder a = jg.a("MqttMsgBase{msg_id='");
        jg.a(a, this.msg_id, '\'', ", msg_ref='");
        jg.a(a, this.msg_ref, '\'', ", msg_type=");
        a.append(this.msg_type);
        a.append(", service_type=");
        a.append(this.service_type);
        a.append(", msg_content=");
        a.append(this.msg_content);
        a.append('}');
        return a.toString();
    }

    public MqttMsgBase(String str) {
        this.msg_id = 20 + str + System.currentTimeMillis() + ((int) (Math.random() * 10.0d)) + ((int) (Math.random() * 10.0d));
    }
}
