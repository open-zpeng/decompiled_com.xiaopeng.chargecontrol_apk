package com.xiaopeng.lib.framework.moduleinterface.aiassistantmodule.sensor;

import java.lang.reflect.Field;
/* loaded from: classes.dex */
public abstract class BaseSensor {
    public ISensorCallback mSensorCallback;
    public ISensorListener mSensorListener;

    public BaseSensor() {
        initField();
    }

    private Field getFieldByClasss(String fieldName, Object object) {
        Field field = null;
        for (Class<?> cls = object.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            try {
                field = cls.getDeclaredField(fieldName);
            } catch (Exception unused) {
            }
        }
        return field;
    }

    public void doExtra(String extra) {
    }

    public ISensorCallback getSensorCallback() {
        return this.mSensorCallback;
    }

    public ISensorListener getSensorListener() {
        return this.mSensorListener;
    }

    public abstract void initField();

    public String onRequestSensorValue(String fieldName) {
        String str;
        try {
            Field fieldByClasss = getFieldByClasss(fieldName, this);
            refreshField(fieldName);
            fieldByClasss.setAccessible(true);
            str = String.valueOf(fieldByClasss.get(this));
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        if (getSensorCallback() != null) {
            getSensorCallback().onSensorReponse(sensorName(), fieldName, str);
        }
        return str;
    }

    public void refreshField(String field) {
    }

    public void sensing(String field, String value) {
        if (getSensorListener() != null) {
            getSensorListener().onSensorChange(sensorName(), field, value);
        }
    }

    public abstract String sensorName();

    public void setSensorCallback(ISensorCallback sensorCallback) {
        this.mSensorCallback = sensorCallback;
    }

    public void setSensorListener(ISensorListener sensorListener) {
        this.mSensorListener = sensorListener;
    }

    public abstract void startSensing();

    public abstract void stopSensing();

    public void sensing(String field, Object value) {
        sensing(field, String.valueOf(value));
    }
}
