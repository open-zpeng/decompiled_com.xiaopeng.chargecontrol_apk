package com.xiaopeng.libconfig.ipc.event;
/* loaded from: classes.dex */
public class OTA2ManyEvent {
    public static final int STATE_DOWNLOADING = 1;
    public static final int STATE_DOWNLOAD_FAIL = 4;
    public static final int STATE_DOWNLOAD_FINISHED = 2;
    public static final int STATE_DOWNLOAD_STOP = 3;
    public static final int STATE_FULL_CHECKING = 9;
    public static final int STATE_FULL_CHECK_FAIL = 8;
    public static final int STATE_HAS_NEW_VERSION = 5;
    public static final int STATE_NEWEST = 0;
    public static final int STATE_PRE_CHECKING = 6;
    public static final int STATE_PRE_CHECK_FAIL = 7;
    public static final int STATE_SERVER_CHECKING = 12;
    public static final int STATE_UPGRADE_FAIL = 11;
    public static final int STATE_UPGRADE_MCU_READY = 15;
    public static final int STATE_UPGRADE_REBOOT = 10;
    public static final int STATE_UPGRADE_REBOOT_CHECK_FAIL = 13;
    public static final int STATE_UPGRADE_TIP = 14;
    public String detail;
    public float progress;
    public boolean show;
    public int state;
    public boolean updateFlag;
    public String version;

    public OTA2ManyEvent() {
    }

    public String getDetail() {
        return this.detail;
    }

    public float getProgress() {
        return this.progress;
    }

    public int getState() {
        return this.state;
    }

    public String getVersion() {
        return this.version;
    }

    public boolean isShow() {
        return this.show;
    }

    public boolean isUpdateFlag() {
        return this.updateFlag;
    }

    public void setDetail(String str) {
        this.detail = str;
    }

    public void setProgress(float f) {
        this.progress = f;
    }

    public void setShow(boolean z) {
        this.show = z;
    }

    public void setState(int i) {
        this.state = i;
    }

    public void setUpdateFlag(boolean z) {
        this.updateFlag = z;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public OTA2ManyEvent(int i) {
        this.state = i;
    }

    public OTA2ManyEvent(int i, float f) {
        this.state = i;
        this.progress = f;
    }
}
