package com.xiaopeng.ipc;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
/* loaded from: classes.dex */
public class IpcMessage implements Parcelable {
    public static final Parcelable.Creator<IpcMessage> CREATOR = new Parcelable.Creator<IpcMessage>() { // from class: com.xiaopeng.ipc.IpcMessage.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage createFromParcel(Parcel parcel) {
            return new IpcMessage(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public IpcMessage[] newArray(int i) {
            return new IpcMessage[i];
        }
    };
    public int msgId;
    public String packageName;
    public Bundle payloadData;

    public IpcMessage() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int getMsgId() {
        return this.msgId;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public Bundle getPayloadData() {
        return this.payloadData;
    }

    public void readFromParcel(Parcel parcel) {
        this.packageName = parcel.readString();
        this.msgId = parcel.readInt();
        this.payloadData = parcel.readBundle();
    }

    public void setMsgId(int i) {
        this.msgId = i;
    }

    public void setPackageName(String str) {
        this.packageName = str;
    }

    public void setPayloadData(Bundle bundle) {
        this.payloadData = bundle;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.packageName);
        parcel.writeInt(this.msgId);
        parcel.writeBundle(this.payloadData);
    }

    public IpcMessage(Parcel parcel) {
        this.packageName = parcel.readString();
        this.msgId = parcel.readInt();
        this.payloadData = parcel.readBundle();
    }
}
