package defpackage;
/* compiled from: ChargePortState.java */
/* renamed from: sb0  reason: default package */
/* loaded from: classes.dex */
public enum sb0 {
    OPENED,
    MIDDLE,
    CLOSED,
    FAULT,
    UNKNOWN;

    public static sb0 a(int value) {
        if (value != 0) {
            if (value != 1) {
                if (value != 2) {
                    if (value != 3) {
                        return UNKNOWN;
                    }
                    return FAULT;
                }
                return CLOSED;
            }
            return MIDDLE;
        }
        return OPENED;
    }
}
