package defpackage;

import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Typeface;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import defpackage.jr;
import defpackage.nr;
import defpackage.vr;
import java.util.ArrayList;
import java.util.List;
/* compiled from: BaseDataSet.java */
/* renamed from: rr  reason: default package */
/* loaded from: classes.dex */
public abstract class rr<T extends vr> implements ts<T> {
    public List<Integer> a;
    public dt b;
    public List<dt> c;
    public List<Integer> d;
    public String e;
    public nr.a f;
    public boolean g;
    public transient fs h;
    public Typeface i;
    public jr.b j;
    public float k;
    public float l;
    public DashPathEffect m;
    public boolean n;
    public boolean o;
    public vt p;
    public float q;
    public boolean r;

    public rr() {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "DataSet";
        this.f = nr.a.LEFT;
        this.g = true;
        this.j = jr.b.DEFAULT;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = null;
        this.n = true;
        this.o = true;
        this.p = new vt();
        this.q = 17.0f;
        this.r = true;
        this.a = new ArrayList();
        this.d = new ArrayList();
        this.a.add(Integer.valueOf(Color.rgb(140, 234, (int) XLoadingDrawable.ALPHA_MAX)));
        this.d.add(-16777216);
    }

    public int a(int i) {
        List<Integer> list = this.a;
        return list.get(i % list.size()).intValue();
    }

    public int b(int i) {
        List<Integer> list = this.d;
        return list.get(i % list.size()).intValue();
    }

    public void c(int i) {
        if (this.a == null) {
            this.a = new ArrayList();
        }
        this.a.clear();
        this.a.add(Integer.valueOf(i));
    }

    public int j() {
        return this.a.get(0).intValue();
    }

    public fs k() {
        if (this.h == null) {
            return zt.g;
        }
        return this.h;
    }

    public void l() {
        ((ur) this).m();
    }

    public void a(float f) {
        this.l = f;
    }

    public void a(boolean z) {
        this.o = z;
    }

    public rr(String str) {
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = "DataSet";
        this.f = nr.a.LEFT;
        this.g = true;
        this.j = jr.b.DEFAULT;
        this.k = Float.NaN;
        this.l = Float.NaN;
        this.m = null;
        this.n = true;
        this.o = true;
        this.p = new vt();
        this.q = 17.0f;
        this.r = true;
        this.a = new ArrayList();
        this.d = new ArrayList();
        this.a.add(Integer.valueOf(Color.rgb(140, 234, (int) XLoadingDrawable.ALPHA_MAX)));
        this.d.add(-16777216);
        this.e = str;
    }
}
