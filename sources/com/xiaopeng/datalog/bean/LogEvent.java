package com.xiaopeng.datalog.bean;

import android.os.Build;
import android.os.SystemProperties;
import android.text.TextUtils;
import androidx.annotation.Keep;
import java.util.List;
@Keep
/* loaded from: classes.dex */
public class LogEvent {
    public String dbcVer;
    public String device;
    public String iccid;
    public String model;
    public List<Object> msg;
    public int packageId;
    public int ref;
    public String sid;
    public String sysVer;
    public long t;
    public long uid;
    public int v = 3;
    public int vid;
    public String vin;

    /* loaded from: classes.dex */
    public enum a {
        CAN(2),
        CDU(1);
        
        public int c;

        a(int i) {
            this.c = i;
        }
    }

    /* loaded from: classes.dex */
    public enum b {
        XMART_ROM(1),
        XMART_APP(2),
        XMART_THIRD_APP(3),
        ANDROID_APP(4);

        b(int i) {
        }
    }

    public static LogEvent create(a aVar) {
        LogEvent logEvent = new LogEvent();
        logEvent.setDevice(hb0.c());
        String str = SystemProperties.get("persist.sys.xiaopeng.vin", "");
        if (TextUtils.isEmpty(str)) {
            str = SystemProperties.get("sys.xiaopeng.vin", "");
        }
        logEvent.setVin(str);
        logEvent.setSysVer(getSystemVersion());
        logEvent.setSid(hb0.d());
        logEvent.setUid(hb0.a());
        logEvent.setT(System.currentTimeMillis());
        logEvent.setRef(aVar.c);
        logEvent.setModel(SystemProperties.get("ro.product.model", ""));
        logEvent.setDbcVer(hb0.b());
        int i = Build.VERSION.SDK_INT;
        logEvent.setIccid(SystemProperties.get("sys.xiaopeng.iccid", ""));
        return logEvent;
    }

    public static b from(int i) {
        if (i != 1) {
            if (i != 2) {
                if (i != 3) {
                    if (i == 4) {
                        return b.ANDROID_APP;
                    }
                    throw new IllegalArgumentException("invalid type " + i + ", must be [1, 4]");
                }
                return b.XMART_THIRD_APP;
            }
            return b.XMART_APP;
        }
        return b.XMART_ROM;
    }

    public static String getSystemVersion() {
        String[] split = hb0.d().split("_");
        return split.length > 1 ? split[1] : "unknown";
    }

    public String getDbcVer() {
        return this.dbcVer;
    }

    public String getDevice() {
        return this.device;
    }

    public String getIccid() {
        return this.iccid;
    }

    public String getModel() {
        return this.model;
    }

    public List<Object> getMsg() {
        return this.msg;
    }

    public int getPackageId() {
        return this.packageId;
    }

    public int getRef() {
        return this.ref;
    }

    public String getSid() {
        return this.sid;
    }

    public String getSysVer() {
        return this.sysVer;
    }

    public long getT() {
        return this.t;
    }

    public long getUid() {
        return this.uid;
    }

    public int getV() {
        return this.v;
    }

    public int getVid() {
        return this.vid;
    }

    public String getVin() {
        return this.vin;
    }

    public void setDbcVer(String str) {
        this.dbcVer = str;
    }

    public void setDevice(String str) {
        this.device = str;
    }

    public void setIccid(String str) {
        this.iccid = str;
    }

    public void setModel(String str) {
        this.model = str;
    }

    public void setMsg(List<Object> list) {
        this.msg = list;
    }

    public void setPackageId(int i) {
        this.packageId = i;
    }

    public void setRef(int i) {
        this.ref = i;
    }

    public void setSid(String str) {
        this.sid = str;
    }

    public void setSysVer(String str) {
        this.sysVer = str;
    }

    public void setT(long j) {
        this.t = j;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public void setV(int i) {
        this.v = i;
    }

    public void setVid(int i) {
        this.vid = i;
    }

    public void setVin(String str) {
        this.vin = str;
    }
}
