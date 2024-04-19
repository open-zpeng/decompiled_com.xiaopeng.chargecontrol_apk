package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IIpuController extends ILifeCycle {

    /* loaded from: classes.dex */
    public static class CtrlCurrEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CtrlTempEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CtrlVoltEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IpuFailStInfoEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IpuKl15VoltageEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IpuVendorCodeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class MotorStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class MotorTempEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class RollSpeedEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class TorqueEventMsg extends AbstractEventMsg<Float> {
    }

    int getCtrlCurr();

    int getCtrlTemp();

    int getCtrlVolt();

    int getIpuFailStInfo();

    int getIpuInvtOverTempFault();

    int getIpuInvtOverTempFlag();

    int getIpuInvtOverTempWarn();

    int getIpuKl15Voltage();

    int getIpuMotOverTempFault();

    int getIpuMotOverTempFlag();

    int getIpuMotOverTempWarn();

    int getIpuMotorOverTempFault();

    int getIpuMotorOverTempWarn();

    int getIpuNtcOverTempFault();

    int getIpuNtcOverTempWarn();

    int getIpuVendorCode();

    int getMotorStatus();

    int getMotorTemp();

    int getRollSpeed();

    float getTorque();
}
