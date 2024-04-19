package com.xiaopeng.lib.framework.moduleinterface.carcontroller;

import java.util.HashMap;
import java.util.LinkedList;
/* loaded from: classes.dex */
public interface IIcmController extends ILifeCycle, com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IIcmController {
    public static final int DISTRACTION_LEVEL_L1 = 1;
    public static final int DISTRACTION_LEVEL_NONE = 0;
    public static final int DMS_MODE_EXTENDED = 1;
    public static final int DMS_MODE_NORMAL = 0;
    public static final int FATIGUE_LEVEL_L1 = 1;
    public static final int FATIGUE_LEVEL_L2 = 2;
    public static final int FATIGUE_LEVEL_NONE = 0;
    public static final int ICM_ALARM_STATUS_VOLUME_POWER = 2;
    public static final int ICM_ALARM_STATUS_VOLUME_SOFT = 0;
    public static final int ICM_ALARM_STATUS_VOLUME_STANDARD = 1;
    @Deprecated
    public static final int ICM_DAY_NIGHT_MODE_DAY = 0;
    @Deprecated
    public static final int ICM_DAY_NIGHT_MODE_NIGHT = 1;
    public static final int ICM_METER_ALARM_VOLUME_POWER = 2;
    public static final int ICM_METER_ALARM_VOLUME_SOFT = 0;
    public static final int ICM_METER_ALARM_VOLUME_STANDARD = 1;
    public static final int ICM_METER_TIME_FORMAT_12_HOUR = 2;
    public static final int ICM_METER_TIME_FORMAT_24_HOUR = 1;

    /* loaded from: classes.dex */
    public static class AlarmVolumeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ICMBTContactsEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ICMDriverTempValueEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class ICMLightChangeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ICMSystemTimeValueEventMsg extends AbstractEventMsg<Integer> {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class ICMWindBlowModeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ICMWindLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IcmConnectEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmDayNightEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmDriveTotalMileageEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IcmFeedbackEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IcmLastChargeMileageEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IcmMediaSourceEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmMileageAEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IcmMileageBEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IcmNavigationEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmScreenLightEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmSendResultEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class IcmStartUpMileageEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IcmTemperatureEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmWindModeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class IcmWindPowerEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class SpeedLimitWarningSwitchEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class SpeedLimitWarningValueEventMsg extends AbstractEventMsg<Integer> {
    }

    int getContacts();

    float getDriveTotalMileage();

    float getICMDriverTempValue();

    int[] getICMSystemTimeValue();

    @Deprecated
    int getICMWindBlowMode();

    int getICMWindLevel();

    int getIcmAlarmVolume();

    boolean getIcmConnectionState();

    boolean getIcmDayNightSwitch();

    int getIcmFeedback();

    boolean getIcmMediaSource();

    boolean getIcmNavigation();

    boolean getIcmScreenLight();

    boolean getIcmTemperature();

    boolean getIcmWindMode();

    boolean getIcmWindPower();

    float getLastChargeMileage();

    float getLastStartUpMileage();

    float getMeterMileageA();

    float getMeterMileageB();

    boolean getSpeedLimitWarningSwitch();

    int getSpeedLimitWarningValue();

    int getWheelEvent();

    void resetMeterMileageA();

    void resetMeterMileageB();

    void sendBinMsg(int rpcNum, byte[] bjson, byte[] bbin);

    void sendContacts(byte[] contactsJson);

    @Deprecated
    void sendRomBinMsgNew(byte[] bytes);

    void sendSpeechStateInfo(byte[] info);

    void setBtStateMessage(byte[] json);

    void setICMDriverTempValue(float value);

    void setICMSystemTimeValue(int hours, int minutes);

    void setICMWindBlowMode(int mode);

    void setICMWindLevel(int level);

    void setIcmAccount(byte[] account);

    void setIcmAlarmVolume(int volumeLevel);

    @Deprecated
    void setIcmDayNightMode(int icmDayNightMode);

    void setIcmDayNightSwitch(boolean enable);

    void setIcmDistractionLevel(int level);

    void setIcmDmsMode(int mode);

    void setIcmFatigueLevel(int level);

    void setIcmMediaSource(boolean enable);

    void setIcmMultiProperty(LinkedList<HashMap<Integer, Object>> propertyHashMap);

    void setIcmNavigation(boolean enable);

    void setIcmScreenLight(boolean enable);

    void setIcmTemperature(boolean enable);

    void setIcmTimeFormat(int index);

    void setIcmWindMode(boolean enable);

    void setIcmWindPower(boolean enable);

    void setMeterBackLightLevel(int level);

    void setMeterSoundState(int type, int volume, boolean mute);

    void setMusicInfo(byte[] json, byte[] image);

    void setNavigationInfo(byte[] json);

    void setNetRadioInfo(byte[] json, byte[] image);

    void setRadioInfo(byte[] json);

    void setSpeedLimitWarningSwitch(boolean enable);

    void setSpeedLimitWarningValue(int value);

    void setWeatherInfo(byte[] json);
}
