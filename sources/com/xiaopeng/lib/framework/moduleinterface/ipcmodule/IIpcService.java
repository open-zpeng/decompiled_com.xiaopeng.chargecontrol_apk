package com.xiaopeng.lib.framework.moduleinterface.ipcmodule;

import android.os.Bundle;
/* loaded from: classes.dex */
public interface IIpcService {

    /* loaded from: classes.dex */
    public static class IpcMessageEvent {
        public int mMsgID;
        public Bundle mPayloadData;
        public String mSenderPackageName;

        public int getMsgID() {
            return this.mMsgID;
        }

        public Bundle getPayloadData() {
            return this.mPayloadData;
        }

        public String getSenderPackageName() {
            return this.mSenderPackageName;
        }

        public void setMsgID(int msgID) {
            this.mMsgID = msgID;
        }

        public void setPayloadData(Bundle payloadData) {
            this.mPayloadData = payloadData;
        }

        public void setSenderPackageName(String senderPackageName) {
            this.mSenderPackageName = senderPackageName;
        }

        public String toString() {
            StringBuilder a = jg.a("IpcMessageEvent{mSenderPackageName='");
            jg.a(a, this.mSenderPackageName, '\'', ", mMsgID=");
            a.append(this.mMsgID);
            a.append(", mPayloadData=");
            a.append(this.mPayloadData);
            a.append('}');
            return a.toString();
        }
    }

    void init();

    void sendData(int msgId, Bundle payloadData, String... appIds);
}
