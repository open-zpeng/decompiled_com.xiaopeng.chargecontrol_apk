package defpackage;

import android.view.GestureDetector;
import android.view.View;
import defpackage.cr;
/* compiled from: ChartTouchListener.java */
/* renamed from: zs  reason: default package */
/* loaded from: classes.dex */
public abstract class zs<T extends cr<?>> extends GestureDetector.SimpleOnGestureListener implements View.OnTouchListener {
    public a c = a.NONE;
    public int d = 0;
    public is e;
    public GestureDetector f;
    public T g;

    /* compiled from: ChartTouchListener.java */
    /* renamed from: zs$a */
    /* loaded from: classes.dex */
    public enum a {
        NONE,
        DRAG,
        X_ZOOM,
        Y_ZOOM,
        PINCH_ZOOM,
        ROTATE,
        SINGLE_TAP,
        DOUBLE_TAP,
        LONG_PRESS,
        FLING
    }

    public zs(T t) {
        this.g = t;
        this.f = new GestureDetector(t.getContext(), this);
    }
}
