package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IHVACController extends ILifeCycle {

    /* loaded from: classes.dex */
    public static class HVACAutoModeBlowLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACAutoModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACCirculationModeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACEconEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACFrontDefrostModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACInnerTempEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class HVACPowerModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACQualityInnerPM25ValueEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACQualityOutsideLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACQualityOutsideStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACQualityPurgeModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACTempACModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACTempDriverValueEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class HVACTempPTCStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACTempPsnValueEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class HVACTempSyncModEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class HVACWindBlowModeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HVACWindSpeedLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class OutsideAirTempEventMsg extends AbstractEventMsg<Float> {
    }

    int[] getCompressorErrorInfo();

    boolean getHVACAutoMode();

    int getHVACAutoModeBlowLevel();

    int getHVACCirculationMode();

    boolean getHVACEcon();

    boolean getHVACFrontDefrostMode();

    float getHVACInnerTemp();

    boolean getHVACPowerMode();

    int getHVACQualityInnerPM25Value();

    int getHVACQualityOutsideLevel();

    int getHVACQualityOutsideStatus();

    boolean getHVACQualityPurgeMode();

    boolean getHVACTempACMode();

    float getHVACTempDriverValue();

    float getHVACTempPsnValue();

    boolean getHVACTempSyncMode();

    int getHVACWindBlowMode();

    int getHVACWindSpeedLevel();

    float getOutsideAirTemp();

    int getPtcError();

    int getTempPTCStatus();

    boolean isError();

    void setHVACAutoMode();

    void setHVACAutoMode(boolean enable);

    void setHVACAutoModeBlowLevel(int level);

    void setHVACCirculationMode();

    void setHVACCirculationMode(int mode);

    void setHVACEcon(boolean isOpen);

    void setHVACFrontDefrostMode();

    void setHVACFrontDefrostMode(boolean enable);

    @Deprecated
    void setHVACPowerMode();

    void setHVACPowerMode(boolean enable);

    void setHVACQualityPurgeMode();

    void setHVACQualityPurgeMode(boolean enable);

    void setHVACTempACMode();

    void setHVACTempACMode(boolean enable);

    void setHVACTempDriverDown();

    void setHVACTempDriverDown(float value);

    void setHVACTempDriverUp();

    void setHVACTempDriverUp(float value);

    void setHVACTempDriverValue(float level);

    void setHVACTempPsnDown();

    void setHVACTempPsnDown(float value);

    void setHVACTempPsnUp();

    void setHVACTempPsnUp(float value);

    void setHVACTempPsnValue(float level);

    void setHVACTempSyncMode();

    void setHVACTempSyncMode(boolean enable);

    void setHVACWindBlowMode(int mode);

    void setHVACWindSpeedDown();

    void setHVACWindSpeedDown(int value);

    void setHVACWindSpeedLevel(int level);

    void setHVACWindSpeedUp();

    void setHVACWindSpeedUp(int value);

    void setTempPTCStatus(int status);
}
