package com.xiaopeng.libconfig.ipc.wheel;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class WheelEventValue {
    public int eventCode;
    public int eventValue;
    public int keyCode;
    public int keyMode;

    public WheelEventValue() {
    }

    public int getEventCode() {
        return this.eventCode;
    }

    public int getEventValue() {
        return this.eventValue;
    }

    public int getKeyCode() {
        return this.keyCode;
    }

    public int getKeyMode() {
        return this.keyMode;
    }

    public void setEventCode(int i) {
        this.eventCode = i;
    }

    public void setEventValue(int i) {
        this.eventValue = i;
    }

    public void setKeyCode(int i) {
        this.keyCode = i;
    }

    public void setKeyMode(int i) {
        this.keyMode = i;
    }

    public String toString() {
        StringBuilder a = jg.a("WheelEventValue{keyCode=");
        a.append(this.keyCode);
        a.append(", eventCode=");
        a.append(this.eventCode);
        a.append(", eventValue=");
        a.append(this.eventValue);
        a.append(", keyMode=");
        a.append(this.keyMode);
        a.append('}');
        return a.toString();
    }

    public WheelEventValue(int i, int i2, int i3, int i4) {
        this.keyCode = i;
        this.eventCode = i2;
        this.eventValue = i3;
        this.keyMode = i4;
    }

    public WheelEventValue(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.keyCode = jSONObject.getInt(WheelEvent.KEY_ACTION_KEY_CODE);
            this.eventCode = jSONObject.getInt(WheelEvent.KEY_ACTION_EVENT_CODE);
            this.eventValue = jSONObject.getInt(WheelEvent.KEY_ACTION_EVENT_VALUE);
            this.keyMode = jSONObject.getInt(WheelEvent.KEY_ACTION_KEY_MODE);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
