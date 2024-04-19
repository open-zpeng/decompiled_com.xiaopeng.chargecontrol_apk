package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: Filter.java */
/* renamed from: c00  reason: default package */
/* loaded from: classes.dex */
public class c00 {
    public static final e00<Float> a = new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 819.0f);
    public static final e00<Float> b = new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 819.0f);
    public static final e00<Float> c = new xy(-400.0f, 400.0f);
    public static final e00<Float> d = new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 750.0f);
    public static final e00<Float> e = new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1638.2f);

    public static /* synthetic */ boolean a(int i, int i2, Integer num) {
        return num.intValue() < i || num.intValue() > i2;
    }

    public static e00<Integer> a(int i, int i2) {
        return new vy(i, i2);
    }

    public static /* synthetic */ boolean a(float f, float f2, Float f3) {
        return f3.floatValue() < f || f3.floatValue() > f2;
    }

    public static /* synthetic */ boolean a(float f, Float f2) {
        return f2.floatValue() >= f;
    }

    public static /* synthetic */ boolean a(int[] iArr, Integer num) {
        for (int i : iArr) {
            if (i == num.intValue()) {
                return false;
            }
        }
        return true;
    }
}
