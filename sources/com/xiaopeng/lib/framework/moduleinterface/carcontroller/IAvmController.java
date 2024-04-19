package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface IAvmController extends ILifeCycle, com.xiaopeng.lib.framework.moduleinterface.carcontroller.v2extend.IAvmController {

    /* loaded from: classes.dex */
    public static class CameraAngleEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class CameraDisplayModeEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CameraFrontRadarEventMsg extends AbstractEventMsg<byte[]> {
    }

    /* loaded from: classes.dex */
    public static class CameraHeightEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class CameraPanoEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class CameraRoofEventMsg extends AbstractEventMsg<Boolean> {
    }

    /* loaded from: classes.dex */
    public static class CameraRoofMoveStateEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CameraRoofPosEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CameraRoofStateEventMsg extends AbstractEventMsg<Integer> {
    }

    /* loaded from: classes.dex */
    public static class CameraSteerAngleEventMsg extends AbstractEventMsg<Float> {
    }

    /* loaded from: classes.dex */
    public static class CameraTailRadarEventMsg extends AbstractEventMsg<byte[]> {
    }

    int getCameraAngle();

    int getCameraDisplayMode();

    int[] getCameraFailInfo();

    boolean getCameraHeight();

    float[] getFrontRadarData();

    boolean getHasPanoCamera();

    boolean getHasRoofCamera();

    int getRoofCameraPosition();

    int getRoofCameraState();

    int getRoofMoveCameraState();

    float getSteerWheelRotationAngle();

    float[] getTailRadarData();

    void setCameraAngle(int targetAngle);

    void setCameraDisplayMode(int type);

    void setCameraHeight(boolean isUp);
}
