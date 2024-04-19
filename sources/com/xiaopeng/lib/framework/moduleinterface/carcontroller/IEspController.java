package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IEspController extends ILifeCycle {

    /* loaded from: classes.dex */
    public static class AVHEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class AVHFaultEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class ESPEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class ESPFaultEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class EpbWarningLampOnEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class EpsWarningLampOnEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class EspEbdFaultStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class EspHbbFaultStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HDCEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HDCFaultEventMsg extends AbstractEventMsg<Boolean> {
    }

    boolean getAVH();

    boolean getAvhFault();

    boolean getESP();

    int getEspEbdFaultStatus();

    boolean getEspFault();

    int getEspHbbFaultStatus();

    boolean getHDC();

    boolean getHdcFault();

    boolean isAbsFault();

    boolean isAvhFault();

    boolean isEpbWarningLampOn();

    boolean isEpsWarningLampOn();

    boolean isEspFault();

    boolean isHdcFault();

    void setAVH(boolean enable);

    void setESP(boolean enable);

    void setHDC(boolean enable);
}
