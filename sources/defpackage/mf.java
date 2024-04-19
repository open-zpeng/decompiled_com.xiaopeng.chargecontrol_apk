package defpackage;

import android.graphics.Rect;
import android.view.View;
import defpackage.nf;
/* compiled from: OrientationHelper.java */
/* renamed from: mf  reason: default package */
/* loaded from: classes.dex */
public abstract class mf {
    public final nf.n a;
    public int b = Integer.MIN_VALUE;
    public final Rect c = new Rect();

    public static mf a(nf.n nVar, int i) {
        if (i != 0) {
            if (i == 1) {
                return new lf(nVar);
            }
            throw new IllegalArgumentException("invalid orientation");
        }
        return new kf(nVar);
    }

    public abstract int a();

    public abstract int a(View view);

    public abstract void a(int i);

    public abstract int b();

    public abstract int b(View view);

    public abstract int c();

    public abstract int c(View view);

    public abstract int d();

    public abstract int d(View view);

    public abstract int e();

    public abstract int e(View view);

    public abstract int f();

    public abstract int f(View view);

    public abstract int g();

    public int h() {
        if (Integer.MIN_VALUE == this.b) {
            return 0;
        }
        return g() - this.b;
    }
}
