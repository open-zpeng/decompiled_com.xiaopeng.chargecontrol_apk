package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import java.util.ArrayList;
import java.util.List;
/* compiled from: CarControlManager.java */
/* renamed from: rb0  reason: default package */
/* loaded from: classes.dex */
public final class rb0 {
    @SuppressLint({"StaticFieldLeak"})
    public static volatile rb0 g;
    public Context a;
    public Handler b;
    public ContentObserver c;
    public ContentObserver d;
    public final Object e = new Object();
    public final List<ob0> f = new ArrayList();

    public rb0(Context context) {
        Log.d("CarControlManager", "CarControlManager");
        this.a = context;
        HandlerThread handlerThread = new HandlerThread("CarControl-ContentObserver");
        handlerThread.start();
        this.b = new Handler(handlerThread.getLooper());
        if (this.c == null) {
            this.c = new pb0(this, this.b);
        }
        if (this.d == null) {
            this.d = new qb0(this, this.b);
        }
        try {
            this.a.getContentResolver().registerContentObserver(h00.a("left_charge_port_state"), false, this.d);
            this.a.getContentResolver().registerContentObserver(h00.a("right_charge_port_state"), false, this.d);
        } catch (Exception e) {
            Log.e("CarControlManager", "register ContentObserver ac/dc port failed", e);
        }
    }

    public static rb0 a(Context context) {
        if (g == null) {
            synchronized (rb0.class) {
                if (g == null) {
                    g = new rb0(context);
                }
            }
        }
        return g;
    }

    public void b(ob0 callback) {
        if (callback != null) {
            synchronized (this.e) {
                this.f.remove(callback);
            }
        }
    }

    public final void c(float temp) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.t();
            }
        }
    }

    public final void d(boolean occupied) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.g();
            }
        }
    }

    public final void e(boolean mode) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.a();
            }
        }
    }

    public final void f(boolean isAuto) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.i();
            }
        }
    }

    public final void g(boolean enabled) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.j();
            }
        }
    }

    public final void h(boolean isAuto) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.k();
            }
        }
    }

    public final void i(boolean isSync) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.l();
            }
        }
    }

    public final void j(boolean enabled) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.p();
            }
        }
    }

    public final void k(boolean isPowerOn) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.r();
            }
        }
    }

    public final void l(boolean isSync) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.s();
            }
        }
    }

    public final void m(boolean occupied) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.v();
            }
        }
    }

    public boolean n(boolean leftSide) {
        return h00.b(this.a.getContentResolver(), leftSide ? "left_charge_port" : "right_charge_port", 1);
    }

    public final void b(float temp) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.n();
            }
        }
    }

    public final void c(boolean locked) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.c();
            }
        }
    }

    public final void d(int percent) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.h();
            }
        }
    }

    public final void e(int aqValue) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.q();
            }
        }
    }

    public final void f(int level) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.o();
            }
        }
    }

    public final void g(int value) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.u();
            }
        }
    }

    public void a(ob0 callback) {
        if (callback != null) {
            synchronized (this.e) {
                this.f.add(callback);
            }
        }
    }

    public final void b(boolean isReady) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.b();
            }
        }
    }

    public final void c(int driveMode) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.f();
            }
        }
    }

    public sb0 a(boolean leftSide) {
        return sb0.a(h00.a(this.a.getContentResolver(), leftSide ? "left_charge_port_state" : "right_charge_port_state", -1));
    }

    public final void a(float temp) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.m();
            }
        }
    }

    public final void b(int distance) {
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.e();
            }
        }
    }

    public static /* synthetic */ int c(rb0 rb0Var, String str) {
        try {
            return Integer.parseInt(i00.a(rb0Var.a.getContentResolver(), str));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static /* synthetic */ float b(rb0 rb0Var, String str) {
        try {
            return Float.parseFloat(i00.a(rb0Var.a.getContentResolver(), str));
        } catch (NullPointerException | NumberFormatException unused) {
            return XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
    }

    public final void a(int status) {
        tb0.a(status);
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.d();
            }
        }
    }

    public final void a(boolean leftSide, int state) {
        sb0 a = sb0.a(state);
        synchronized (this.e) {
            for (ob0 ob0Var : this.f) {
                ob0Var.a(leftSide, a);
            }
        }
    }

    public static /* synthetic */ boolean a(rb0 rb0Var, String str) {
        try {
            return Integer.parseInt(i00.a(rb0Var.a.getContentResolver(), str)) == 1;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
