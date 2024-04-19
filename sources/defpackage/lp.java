package defpackage;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.lp;
import java.util.Map;
/* compiled from: BaseRequestOptions.java */
/* renamed from: lp  reason: default package */
/* loaded from: classes.dex */
public abstract class lp<T extends lp<T>> implements Cloneable {
    public boolean B;
    public int c;
    public Drawable g;
    public int h;
    public Drawable i;
    public int j;
    public boolean o;
    public Drawable q;
    public int r;
    public boolean v;
    public Resources.Theme w;
    public boolean x;
    public boolean y;
    public boolean z;
    public float d = 1.0f;
    public jj e = jj.c;
    public qg f = qg.NORMAL;
    public boolean k = true;
    public int l = -1;
    public int m = -1;
    public zh n = hq.b;
    public boolean p = true;
    public bi s = new bi();
    public Map<Class<?>, fi<?>> t = new kq();
    public Class<?> u = Object.class;
    public boolean A = true;

    public static boolean b(int i, int i2) {
        return (i & i2) != 0;
    }

    public T a(float f) {
        if (this.x) {
            return (T) clone().a(f);
        }
        if (f >= XToggleDrawable.LIGHT_RADIUS_DEFAULT && f <= 1.0f) {
            this.d = f;
            this.c |= 2;
            e();
            return this;
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public T b(boolean z) {
        if (this.x) {
            return (T) clone().b(z);
        }
        this.B = z;
        this.c |= 1048576;
        e();
        return this;
    }

    public T c() {
        T a = a(rm.b, new pm());
        a.A = true;
        return a;
    }

    public T d() {
        T a = a(rm.a, new wm());
        a.A = true;
        return a;
    }

    public final T e() {
        if (this.v) {
            throw new IllegalStateException("You cannot modify locked T, consider clone()");
        }
        return this;
    }

    public boolean equals(Object obj) {
        if (obj instanceof lp) {
            lp lpVar = (lp) obj;
            return Float.compare(lpVar.d, this.d) == 0 && this.h == lpVar.h && sq.b(this.g, lpVar.g) && this.j == lpVar.j && sq.b(this.i, lpVar.i) && this.r == lpVar.r && sq.b(this.q, lpVar.q) && this.k == lpVar.k && this.l == lpVar.l && this.m == lpVar.m && this.o == lpVar.o && this.p == lpVar.p && this.y == lpVar.y && this.z == lpVar.z && this.e.equals(lpVar.e) && this.f == lpVar.f && this.s.equals(lpVar.s) && this.t.equals(lpVar.t) && this.u.equals(lpVar.u) && sq.b(this.n, lpVar.n) && sq.b(this.w, lpVar.w);
        }
        return false;
    }

    public int hashCode() {
        return sq.a(this.w, sq.a(this.n, sq.a(this.u, sq.a(this.t, sq.a(this.s, sq.a(this.f, sq.a(this.e, (((((((((((((sq.a(this.q, (sq.a(this.i, (sq.a(this.g, (sq.a(this.d) * 31) + this.h) * 31) + this.j) * 31) + this.r) * 31) + (this.k ? 1 : 0)) * 31) + this.l) * 31) + this.m) * 31) + (this.o ? 1 : 0)) * 31) + (this.p ? 1 : 0)) * 31) + (this.y ? 1 : 0)) * 31) + (this.z ? 1 : 0))))))));
    }

    @Override // 
    public T clone() {
        try {
            T t = (T) super.clone();
            t.s = new bi();
            t.s.a(this.s);
            t.t = new kq();
            t.t.putAll(this.t);
            t.v = false;
            t.x = false;
            return t;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public T b() {
        return a(rm.c, new om());
    }

    public T a(jj jjVar) {
        if (this.x) {
            return (T) clone().a(jjVar);
        }
        a.a(jjVar, "Argument must not be null");
        this.e = jjVar;
        this.c |= 4;
        e();
        return this;
    }

    public T a(qg qgVar) {
        if (this.x) {
            return (T) clone().a(qgVar);
        }
        a.a(qgVar, "Argument must not be null");
        this.f = qgVar;
        this.c |= 8;
        e();
        return this;
    }

    public T a(boolean z) {
        if (this.x) {
            return (T) clone().a(true);
        }
        this.k = !z;
        this.c |= IRadioController.TEF663x_PCHANNEL;
        e();
        return this;
    }

    public T a(int i, int i2) {
        if (this.x) {
            return (T) clone().a(i, i2);
        }
        this.m = i;
        this.l = i2;
        this.c |= IInputController.KEYCODE_BACK_BUTTON;
        e();
        return this;
    }

    public T a(zh zhVar) {
        if (this.x) {
            return (T) clone().a(zhVar);
        }
        a.a(zhVar, "Argument must not be null");
        this.n = zhVar;
        this.c |= 1024;
        e();
        return this;
    }

    public <Y> T a(ai<Y> aiVar, Y y) {
        if (this.x) {
            return (T) clone().a(aiVar, y);
        }
        a.a(aiVar, "Argument must not be null");
        a.a(y, "Argument must not be null");
        this.s.b.put(aiVar, y);
        e();
        return this;
    }

    public T a(Class<?> cls) {
        if (this.x) {
            return (T) clone().a(cls);
        }
        a.a(cls, "Argument must not be null");
        this.u = cls;
        this.c |= 4096;
        e();
        return this;
    }

    public final T a(rm rmVar, fi<Bitmap> fiVar) {
        if (this.x) {
            return (T) clone().a(rmVar, fiVar);
        }
        ai aiVar = rm.f;
        a.a(rmVar, "Argument must not be null");
        a((ai<ai>) aiVar, (ai) rmVar);
        return a(fiVar, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T a(fi<Bitmap> fiVar, boolean z) {
        if (this.x) {
            return (T) clone().a(fiVar, z);
        }
        um umVar = new um(fiVar, z);
        a(Bitmap.class, fiVar, z);
        a(Drawable.class, umVar, z);
        a(BitmapDrawable.class, umVar, z);
        a(un.class, new xn(fiVar), z);
        e();
        return this;
    }

    public <Y> T a(Class<Y> cls, fi<Y> fiVar, boolean z) {
        if (this.x) {
            return (T) clone().a(cls, fiVar, z);
        }
        a.a(cls, "Argument must not be null");
        a.a(fiVar, "Argument must not be null");
        this.t.put(cls, fiVar);
        this.c |= 2048;
        this.p = true;
        this.c |= 65536;
        this.A = false;
        if (z) {
            this.c |= 131072;
            this.o = true;
        }
        e();
        return this;
    }

    public T a(lp<?> lpVar) {
        if (this.x) {
            return (T) clone().a(lpVar);
        }
        if (b(lpVar.c, 2)) {
            this.d = lpVar.d;
        }
        if (b(lpVar.c, 262144)) {
            this.y = lpVar.y;
        }
        if (b(lpVar.c, 1048576)) {
            this.B = lpVar.B;
        }
        if (b(lpVar.c, 4)) {
            this.e = lpVar.e;
        }
        if (b(lpVar.c, 8)) {
            this.f = lpVar.f;
        }
        if (b(lpVar.c, 16)) {
            this.g = lpVar.g;
            this.h = 0;
            this.c &= -33;
        }
        if (b(lpVar.c, 32)) {
            this.h = lpVar.h;
            this.g = null;
            this.c &= -17;
        }
        if (b(lpVar.c, 64)) {
            this.i = lpVar.i;
            this.j = 0;
            this.c &= -129;
        }
        if (b(lpVar.c, 128)) {
            this.j = lpVar.j;
            this.i = null;
            this.c &= -65;
        }
        if (b(lpVar.c, IRadioController.TEF663x_PCHANNEL)) {
            this.k = lpVar.k;
        }
        if (b(lpVar.c, IInputController.KEYCODE_BACK_BUTTON)) {
            this.m = lpVar.m;
            this.l = lpVar.l;
        }
        if (b(lpVar.c, 1024)) {
            this.n = lpVar.n;
        }
        if (b(lpVar.c, 4096)) {
            this.u = lpVar.u;
        }
        if (b(lpVar.c, WebpBitmapFactory.IN_TEMP_BUFFER_SIZE)) {
            this.q = lpVar.q;
            this.r = 0;
            this.c &= -16385;
        }
        if (b(lpVar.c, 16384)) {
            this.r = lpVar.r;
            this.q = null;
            this.c &= -8193;
        }
        if (b(lpVar.c, 32768)) {
            this.w = lpVar.w;
        }
        if (b(lpVar.c, 65536)) {
            this.p = lpVar.p;
        }
        if (b(lpVar.c, 131072)) {
            this.o = lpVar.o;
        }
        if (b(lpVar.c, 2048)) {
            this.t.putAll(lpVar.t);
            this.A = lpVar.A;
        }
        if (b(lpVar.c, 524288)) {
            this.z = lpVar.z;
        }
        if (!this.p) {
            this.t.clear();
            this.c &= -2049;
            this.o = false;
            this.c &= -131073;
            this.A = true;
        }
        this.c |= lpVar.c;
        this.s.a(lpVar.s);
        e();
        return this;
    }

    public final boolean a() {
        return this.k;
    }
}
