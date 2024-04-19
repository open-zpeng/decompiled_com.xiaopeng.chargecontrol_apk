package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IScuController extends ILifeCycle, com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IScuController {
    public static final int ASSLINE_CHANGED_DISABLE = 1;
    public static final int ASSLINE_CHANGED_ENABLE = 2;
    public static final int ASSLINE_CHANGED_INVALID = 0;
    public static final int DMS_MODE_EXTENDED = 1;
    public static final int DMS_MODE_NORMAL = 0;
    public static final int DOOR_OPEN_WARNING_OFF = 1;
    public static final int DOOR_OPEN_WARNING_ON = 2;
    public static final int RESPONSE_SCU_ACTIVE = 3;
    public static final int RESPONSE_SCU_NO_FAULT = 0;
    public static final int RESPONSE_SCU_PERMANENT_ERROR = 2;
    public static final int RESPONSE_SCU_TEMPORARY_ERROR = 1;
    public static final int ROAD_ATTR_ROAD_FASTWAY_IN_CITY = 2;
    public static final int ROAD_ATTR_ROAD_HIGHWAY = 1;
    public static final int SCU_AUTO_PARK_CMD_RESET = 0;
    public static final int SCU_AUTO_PARK_IN_CANCLE = 2;
    public static final int SCU_AUTO_PARK_IN_CONTINUE = 4;
    public static final int SCU_AUTO_PARK_IN_START = 1;
    public static final int SCU_AUTO_PARK_OUT_CANCLE = 2;
    public static final int SCU_AUTO_PARK_OUT_CONTINUE = 4;
    public static final int SCU_AUTO_PARK_OUT_START = 3;
    public static final int SCU_BLIND_AREA_DETECTION_WARNING_DISABLE = 0;
    public static final int SCU_BLIND_AREA_DETECTION_WARNING_ENABLE = 1;
    public static final int SCU_BUTTON_OFF = 0;
    public static final int SCU_BUTTON_ON = 1;
    public static final int SCU_FRONT_COLLISION_DISABLE = 0;
    public static final int SCU_FRONT_COLLISION_ENABLE = 1;
    public static final int SCU_INTELLIGENT_SPEED_LIMIT_DISABLE = 0;
    public static final int SCU_INTELLIGENT_SPEED_LIMIT_ENABLE = 1;
    public static final int SCU_LANE_CHANGE_ASSIST_DISABLE = 0;
    public static final int SCU_LANE_CHANGE_ASSIST_ENABLE = 1;
    public static final int SCU_LANE_DEPARTURE_WARNING_DISABLE = 0;
    public static final int SCU_LANE_DEPARTURE_WARNING_ENABLE = 1;
    public static final int SCU_LANE_MIDDLE_ASSIST_DISABLE = 0;
    public static final int SCU_LANE_MIDDLE_ASSIST_ENABLE = 1;
    public static final int SCU_OTA_TAG_0 = 0;
    public static final int SCU_OTA_TAG_1 = 1;
    public static final int SCU_OTA_TAG_2 = 2;
    public static final int SCU_OTA_TAG_3 = 3;
    public static final int SCU_PHONEPKBUTTON_APIN = 1;
    public static final int SCU_PHONEPKBUTTON_APOUT = 2;
    public static final int SCU_PHONEPKBUTTON_CANCEL = 5;
    public static final int SCU_PHONEPKBUTTON_CONTINUE = 4;
    public static final int SCU_PHONEPKBUTTON_INVALID = 0;
    public static final int SCU_PHONEPKBUTTON_SUSPENG = 3;
    public static final int SCU_PHONESMBUTTON_CALLBACKWORK = 3;
    public static final int SCU_PHONESMBUTTON_CALLENTER = 1;
    public static final int SCU_PHONESMBUTTON_CALLFORWARD = 2;
    public static final int SCU_PHONESMBUTTON_EXITMODE = 4;
    public static final int SCU_PHONESMBUTTON_INVALID = 0;
    public static final int SCU_REVERSING_DISPLAY_ACTIVE_NO = 0;
    public static final int SCU_REVERSING_DISPLAY_ACTIVE_YES = 1;
    public static final int SCU_ROAD_ATTR_HOME_PARKING = 6;
    public static final int SCU_ROAD_ATTR_NOT_DEFINED = 0;
    public static final int SCU_ROAD_ATTR_PARKING_TOWER = 4;
    public static final int SCU_ROAD_ATTR_PRIVATE_ROAD = 2;
    public static final int SCU_ROAD_ATTR_PUBLIC_ROAD = 1;
    public static final int SCU_ROAD_ATTR_ROAD_PARKING = 5;
    public static final int SCU_ROAD_ATTR_UNDERGROUND_PARKING = 3;
    public static final int SCU_SIDE_REVERSING_WARNING_DISABLE = 0;
    public static final int SCU_SIDE_REVERSING_WARNING_ENABLE = 1;
    public static final int SCU_STEER_WARNING_Lvl1 = 1;
    public static final int SCU_STEER_WARNING_Lvl2 = 2;
    public static final int SCU_STEER_WARNING_Lvl3 = 3;
    public static final int SCU_SUPER_PARK_ACTIVE_NO = 0;
    public static final int SCU_SUPER_PARK_ACTIVE_YES = 1;
    public static final int SEATBELTREQ_FASTEN = 1;
    public static final int SEATBELTREQ_NONE = 0;

    /* loaded from: classes.dex */
    public static class AccLKAWarningEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class AltimeterEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class AssLineChangedEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class AutoParkEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class BlindAreaDetectionWarningEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class FactoryScuTest322EventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class FactoryScuTest3FDEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class FactoryScuTest3FEEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class FrontCollisionSecurityEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class IntelligentSpeedLimitEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class KeyParkEventMsg extends AbstractEventMsg<Boolean> {
    }

    @Deprecated
    /* loaded from: classes.dex */
    public static class LaneChangeAssistEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class LaneDepartureWarningEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ParkingProcessPathEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class RadarWarningVoiceStatusEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class RearMirrorCtrl extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuAebAlarmSwitchStateEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuAutoParkErrorCodeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuAutoRoadTipsAddEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuAvmBox1UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuAvmBox2UpdateEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuBSDWarningEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuFrontMinDistanceEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuFrontRadarFaultStEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuFrontRadarLevelEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuLDWWarningEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuLKAWarningEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuLocation2UpdateEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuLocationUpdateEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuModeIndexEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuNearestEnableRadarEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuOperationTipUpdateEventMsg extends AbstractEventMsg<Integer> {

        /* loaded from: classes.dex */
        public static class Error extends AbsError {
        }
    }

    /* loaded from: classes.dex */
    public static class ScuRCTAWarningEventMsg extends AbstractEventMsg<int[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuRearMinDistanceEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuReversingDisplayActiveEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuRoadAttributesEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuRoadVoiceTipsEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuSensorFeature1UpdateEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSensorFeature2UpdateEventMsg extends AbstractEventMsg<float[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSlot1UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSlot2UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSlot3UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSlot4UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSlot5UpdateEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuSteerWaringLvlEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class ScuSuperParkActiveResponeEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class ScuTailRadarFaultStEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class ScuTailRadarLevelEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class SideReversingWarningEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class SlotThetaEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class TargetParkingPositionEventMsg extends AbstractEventMsg<byte[]> {
    }

    int getAccExitReason();

    int getAccLkaWarning();

    int getAebAlarmSwitchState();

    byte[] getAltimeter();

    boolean getAssLineChanged();

    int getAutoParkErrorCode();

    int getAutoParkSwitch();

    int getAutoRoadTips();

    int getBlindAreaDetectionWarning();

    int[] getFrontCameraFault();

    int getFrontCollisionSecurity();

    int getFrontMmRadarFault();

    float[] getFrontRadarData();

    int[] getFrontRadarFaultSt();

    int[] getFrontRadarLevel();

    int getIcmAlarmFaultState();

    int getIntelligentSpeedLimit();

    boolean getKeyPark();

    @Deprecated
    int getLaneChangeAssist();

    int getLaneDepartureWarning();

    int getLccExitReason();

    float[] getMileageExtraParams();

    int getModeIndex();

    int getNearestEnableRadar();

    int getParkStatus();

    int getParkingOperationTips();

    float[] getParkingProcessPath();

    boolean getRadarWarningVoiceStatus();

    int[] getRearMmRadarFault();

    int getRoadVoiceTips();

    int[] getScu322LogData();

    int[] getScu3FDExtendLogData();

    int getScuFrontMinDistance();

    int getScuModeIndex();

    int getScuRearMinDistance();

    int getScuSteerWaringLvl();

    int getSideReversingWarning();

    byte[] getSlotTheta();

    float[] getTailRadarData();

    int[] getTailRadarFaultSt();

    int[] getTailRadarLevel();

    byte[] getTargetParkingPosition();

    void setAssLineChanged(int type);

    void setAutoParkInState(int state);

    void setAutoParkOutState(int state);

    void setAutoParkSwitch(int enable);

    void setAutoPilotLocationInfo(float latitude, float longitude, float altitude, float bearing, float accuracy, float gpsSpeed, long gpsTime);

    void setBlindAreaDetectionWarning(int type);

    void setComonHomeSlotId(int value);

    void setDetailRoadClass(int roadClass);

    void setDoorOpenWarningSwitch(int value);

    void setFactoryScuTest(int cmd);

    void setFreeParking1Data(float rx, float ry, float rtheta, int state, int attr, float ds, float r);

    void setFreeParking2Data(float rx, float ry, float rtheta, int state, int attr, float ds, float r);

    void setFrontCollisionSecurity(int type);

    void setIntelligentSpeedLimit(int type);

    void setKeyPark(boolean enable);

    void setLaneChangeAssist(int type);

    void setLaneDepartureWarning(int type);

    void setLaneMiddleAssist(int enable);

    void setLocalWeather(int network, int temperature, int humidity, int weather);

    void setLocationInfo(float latitude, float longitude, float altitude, float bearing, float accuracy, long gpsTime);

    void setParkLotChoseIndex2Scu(int index);

    void setParkLotRecvIndex2Scu(int index);

    void setPhoneAPButton(int action);

    void setPhoneSMButton(int mode);

    void setRadarWarningVoiceStatus(boolean enable);

    void setRoadAttributes(int parking, int road);

    void setScuDmsMode(int mode);

    void setScuOtaTagStatus(int tag);

    void setScuRoadAttr(int attr);

    void setSeatBeltReq(int req);

    void setSideReversingWarning(int type);

    void setSuperParkMode(boolean active);
}
