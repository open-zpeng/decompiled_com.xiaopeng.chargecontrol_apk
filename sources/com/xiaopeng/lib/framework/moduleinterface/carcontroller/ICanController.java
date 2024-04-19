package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public interface ICanController extends ILifeCycle {

    /* loaded from: classes.dex */
    public static class CanDiagnoseEventMsg extends AbstractEventMsg<String> {
    }

    /* loaded from: classes.dex */
    public static class CanRawDataEventMsg extends AbstractEventMsg<int[]> {
    }

    byte[] getCanRawData();

    void sendCanDataSync();

    void setAdasMeta(byte[] metaValues);

    void setAdasPosition(byte[] positionValues);

    void setAdasProfLong(byte[] profLongValues);

    void setAdasProfShort(byte[] profShortValues);

    void setAdasSegment(byte[] segmentValues);

    void setAdasStub(byte[] stubValues);
}
