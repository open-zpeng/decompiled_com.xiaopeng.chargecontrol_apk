package defpackage;

import android.graphics.Typeface;
/* compiled from: ComponentBase.java */
/* renamed from: gr  reason: default package */
/* loaded from: classes.dex */
public abstract class gr {
    public boolean a = true;
    public float b = 5.0f;
    public float c = 5.0f;
    public Typeface d = null;
    public float e = zt.a(10.0f);
    public int f = -16777216;

    public void a(float f) {
        if (f > 24.0f) {
            f = 24.0f;
        }
        if (f < 6.0f) {
            f = 6.0f;
        }
        this.e = zt.a(f);
    }

    public void b(float f) {
        this.b = zt.a(f);
    }

    public void c(float f) {
        this.c = zt.a(f);
    }
}
