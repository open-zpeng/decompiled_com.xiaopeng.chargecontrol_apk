package defpackage;

import android.graphics.DashPathEffect;
import defpackage.jr;
/* compiled from: LegendEntry.java */
/* renamed from: kr  reason: default package */
/* loaded from: classes.dex */
public class kr {
    public String a;
    public jr.b b;
    public float c;
    public float d;
    public DashPathEffect e;
    public int f;

    public kr() {
        this.b = jr.b.DEFAULT;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = null;
        this.f = 1122867;
    }

    public kr(String str, jr.b bVar, float f, float f2, DashPathEffect dashPathEffect, int i) {
        this.b = jr.b.DEFAULT;
        this.c = Float.NaN;
        this.d = Float.NaN;
        this.e = null;
        this.f = 1122867;
        this.a = str;
        this.b = bVar;
        this.c = f;
        this.d = f2;
        this.e = dashPathEffect;
        this.f = i;
    }
}
