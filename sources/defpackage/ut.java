package defpackage;

import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.wt;
/* compiled from: MPPointD.java */
/* renamed from: ut  reason: default package */
/* loaded from: classes.dex */
public class ut extends wt.a {
    public static wt<ut> d = wt.a(64, new ut(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS));
    public double b;
    public double c;

    static {
        d.a(0.5f);
    }

    public ut(double d2, double d3) {
        this.b = d2;
        this.c = d3;
    }

    public static ut a(double d2, double d3) {
        ut a = d.a();
        a.b = d2;
        a.c = d3;
        return a;
    }

    public String toString() {
        StringBuilder a = jg.a("MPPointD, x: ");
        a.append(this.b);
        a.append(", y: ");
        a.append(this.c);
        return a.toString();
    }

    @Override // defpackage.wt.a
    public wt.a a() {
        return new ut(XLoadingDrawable.DEFAULT_RADIANS, XLoadingDrawable.DEFAULT_RADIANS);
    }
}
