package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IVcuController extends ILifeCycle {
    public static final int BATTERY_NORMAL = 0;
    public static final int BATTERY_TOO_COLD = 1;
    public static final int BATTERY_WARMING_START = 1;
    public static final int BATTERY_WARMING_STOP = 0;
    public static final int CHARGE_ERROR_GAIN = 1;
    public static final int CHARGE_ERROR_NONE = 0;
    public static final int CHARGE_GUN_AC_LINK = 1;
    public static final int CHARGE_GUN_DC_LINK = 2;
    public static final int CHARGE_GUN_NO_LINK = 0;
    public static final int CHARGE_SPEED_SLOW = 1;
    public static final int CHARGE_SPEED_SLOW_INVALID = 0;
    public static final int CHARGE_STATUS_APPOINTMENT = 1;
    public static final int CHARGE_STATUS_CHARGING = 2;
    public static final int CHARGE_STATUS_DONE = 8;
    public static final int CHARGE_STATUS_ERROR = 6;
    public static final int CHARGE_STATUS_FULLY_CHARGE = 3;
    public static final int CHARGE_STATUS_PREPARE = 0;
    public static final int CHARGE_STATUS_REMOVE_CHAGRE_CONNECTOR = 4;
    public static final int CHARGE_STATUS_STOPPING = 7;
    public static final int CHARGE_STATUS_WRONG_OPERATION = 5;
    public static final int DRIVE_MODE_FB_AUTO = 1;
    public static final int DRIVE_MODE_FB_MANUAL = 0;
    public static final int DRIVE_MODE_FB_NOT_MANUAL = 3;
    public static final int DRIVE_MODE_FB_REMOTE_CONTROL = 2;
    public static final int DRIVING_STATUS_MODE_ANTISICKNESS = 4;
    public static final int DRIVING_STATUS_MODE_COMFORT = 0;
    public static final int DRIVING_STATUS_MODE_ECO = 1;
    public static final int DRIVING_STATUS_MODE_SPORT = 2;
    public static final int ENERGY_STATUS_RECOVERY_HIGH = 2;
    public static final int ENERGY_STATUS_RECOVERY_LOW = 0;
    public static final int ENERGY_STATUS_RECOVERY_MIDDLE = 1;
    public static final int GEAR_LEVEL_D = 1;
    public static final int GEAR_LEVEL_INVALID = 0;
    public static final int GEAR_LEVEL_N = 2;
    public static final int GEAR_LEVEL_P = 4;
    public static final int GEAR_LEVEL_R = 3;
    public static final int VCU_ENERGY_RECOVERY_HIGH = 2;
    public static final int VCU_ENERGY_RECOVERY_LOW = 0;
    public static final int VCU_ENERGY_RECOVERY_MIDDLE = 1;

    /* loaded from: classes.dex */
    public static class AcChargeCurrentEvengMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class AcChargeVoltEvengMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class AcInputStatusEvnetMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class AvailableDrivingDistanceEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class AverageVehConusme100kmEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class AverageVehConusmeEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class BatteryCoolStatusEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class BatteryMinTemperatureEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class BatteryOverheatingEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class BatteryWarmmingEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class BmsCurrentBatterySocDispEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class BreakTravelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class BrkPedalStVDEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CarGearLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CarSpeedEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class ChargeCompleteTimeEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class ChargeErrorEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ChargeGunEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ChargeLimitEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class ChargeSpeedSlowEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ChargeStatusEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ColdWarningTipsEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class DcChargeCurrentEvengMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class DcChargeVoltEvengMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class DriveTravelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class DriveTravelValidateFlagEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class DriverOverrideEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class DrivingModeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class DtcPageAndEdvBhvilopEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class EbsBatterySocEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ElectriPercentEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class EnergyRecycleLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ErhDebugInfoEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class HvacConsumeEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class IpuStateGearLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IsLowBatteryVoltagelEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class MainPowerRelayStateEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class MainRelayCloseRequestEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class PowerSystemErrorLampOnEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class PureDriveModeFeedbackEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class RawCarSpeedEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class RealGearLevelEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class SohEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class SupDebugInfoEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class SystemReadyEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class onEvReadyStatusChange extends AbstractEventMsg<Integer> {
    }

    float getACChargingCurrent();

    float getACChargingVolt();

    boolean getACInputStatus();

    float getAverageVehConsume();

    float getAverageVehConsume100km();

    boolean getBatteryCoolStatus();

    float getBatteryMinTemperature();

    int[] getBatteryPtcErrorInfo();

    boolean getBatteryWarmingStatus();

    float getBmsCurrentBatterySocDisp();

    int getBreakTravel();

    int getBreakTravelValidateFlag();

    float getCarSpeed();

    int getCcsWorkError();

    int getChargeSpeedLevel();

    int getChargeStatus();

    float getChargingCompleteTime();

    int getChargingError();

    int getChargingGunStatus();

    int[] getChargingMaxSoc();

    boolean getColdWarningTips();

    float getDCChargingCurrent();

    float getDCChargingVolt();

    int getDriveMode();

    int getDriveTravel();

    int getDriveTravelValidateFlag();

    int getDriverOverride();

    int[] getDtcPageAndEdvBhvilop();

    int getEbsBatterySoc();

    float getElectricityPercent();

    int getEnergyRecycle();

    int getGearLever();

    int getGearWarningInfo();

    float getHvacConsume();

    int getIpuStateGearLevel();

    int getMainPowerRelayState();

    int getMainRelayCloseRequest();

    int getMaxMileage(int socLimit);

    int getMileageNumber();

    int getPureDriveModeFeedback();

    float getRawCarSpeed();

    int getRealGearLevel();

    float getSOH();

    @Deprecated
    int getStallState();

    int getSystemReady();

    int[] getTcmFailReason();

    int getVcuErhDebubInfo();

    int getVcuSupDebugInfo();

    boolean isAgsError();

    boolean isBatteryOverheadtingWarning();

    boolean isBatteryOverheating();

    boolean isBmsError();

    boolean isBmsScoLow();

    boolean isDcdcError();

    boolean isEbsError();

    boolean isElectricMotorSystemOverheating();

    boolean isElectricVacuumPumpError();

    boolean isHvCutoff();

    boolean isHvRelayAdhesion();

    boolean isLowBatteryVoltage();

    boolean isPowerSystemErrorLampOn();

    void setBestCharging();

    void setChargingLimit(int limit);

    void setEnergyRecycle(int level);

    void setFullyCharging();

    void startCharge(int chargeSoc);

    void stopACCharge(int chargeSoc);

    void stopDCCharging();
}
