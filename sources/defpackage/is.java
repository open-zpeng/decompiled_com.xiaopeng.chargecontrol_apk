package defpackage;

import defpackage.nr;
/* compiled from: Highlight.java */
/* renamed from: is  reason: default package */
/* loaded from: classes.dex */
public class is {
    public float a;
    public float b;
    public float c;
    public float d;
    public int e;
    public int f;
    public int g;
    public nr.a h;
    public float i;
    public float j;

    public is(float f, float f2, float f3, float f4, int i, nr.a aVar) {
        this.a = Float.NaN;
        this.b = Float.NaN;
        this.e = -1;
        this.g = -1;
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = f4;
        this.f = i;
        this.h = aVar;
    }

    public float a() {
        return this.c;
    }

    public String toString() {
        StringBuilder a = jg.a("Highlight, x: ");
        a.append(this.a);
        a.append(", y: ");
        a.append(this.b);
        a.append(", dataSetIndex: ");
        a.append(this.f);
        a.append(", stackIndex (only stacked barentry): ");
        a.append(this.g);
        return a.toString();
    }

    public boolean a(is isVar) {
        return isVar != null && this.f == isVar.f && this.a == isVar.a && this.g == isVar.g && this.e == isVar.e;
    }

    public is(float f, float f2, float f3, float f4, int i, int i2, nr.a aVar) {
        this(f, f2, f3, f4, i, aVar);
        this.g = i2;
    }
}
