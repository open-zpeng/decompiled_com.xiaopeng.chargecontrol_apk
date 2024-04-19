package defpackage;

import android.app.ActivityThread;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.speech.vui.utils.LogUtils;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.fa0;
import defpackage.my;
import defpackage.r70;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: ChartStatisticsModel.java */
/* renamed from: c90  reason: default package */
/* loaded from: classes.dex */
public class c90 {
    public static final int l;
    public static final int m;
    public kh0 b;
    public kh0 c;
    public kh0 d;
    public Set<h90> e = new HashSet();
    public Set<h90> f = new HashSet();
    public Set<g90> g = new HashSet();
    public float h = -1.0f;
    public float i = 82.3f;
    public float j = 82.3f;
    public float k = 82.3f;
    public final k90 a = new k90(ActivityThread.currentApplication());

    /* compiled from: ChartStatisticsModel.java */
    /* renamed from: c90$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final c90 a = new c90(null);
    }

    static {
        l = a70.m() ? 2 : 0;
        m = a70.m() ? 0 : 2;
    }

    public c90() {
    }

    public static c90 h() {
        return b.a;
    }

    public /* synthetic */ void a(List list) {
        for (g90 g90Var : this.g) {
            g90Var.b(list);
        }
    }

    public /* synthetic */ void b(List list) {
        for (h90 h90Var : this.f) {
            h90Var.a(list);
        }
    }

    public /* synthetic */ void c(List list) {
        for (h90 h90Var : this.e) {
            h90Var.a(list);
        }
    }

    public float d() {
        return this.i;
    }

    public k90 e() {
        return this.a;
    }

    public void f() {
        LogUtils.i("ChartStatisticsModel", "register");
        if (iv.b(this)) {
            return;
        }
        iv.d(this);
    }

    public void g() {
        LogUtils.i("ChartStatisticsModel", "unregister");
        if (iv.b(this)) {
            iv.e(this);
        }
        this.a.a();
        this.a.b();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onConsumptionAverageChanged(my.p pVar) {
        this.h = ((Float) pVar.a).floatValue();
        float floatValue = ((Float) pVar.a).floatValue();
        for (g90 g90Var : this.g) {
            g90Var.a(floatValue);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onConsumptionAverage_last100_Changed(my.q qVar) {
        this.k = ((Float) qVar.a).floatValue();
        for (g90 g90Var : this.g) {
            g90Var.a(((Float) qVar.a).floatValue(), m);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onConsumptionAverage_last20_Changed(my.r rVar) {
        this.j = ((Float) rVar.a).floatValue();
        for (g90 g90Var : this.g) {
            g90Var.a(((Float) rVar.a).floatValue(), 1);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onConsumptionAverage_last2_5_Changed(my.s sVar) {
        this.i = ((Float) sVar.a).floatValue();
        for (g90 g90Var : this.g) {
            g90Var.a(((Float) sVar.a).floatValue(), l);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.BACKGROUND)
    public void onConsumptionPer100MChanged(my.t tVar) {
        float floatValue = ((Float) tVar.a).floatValue();
        if (floatValue > 60.0f) {
            floatValue = 60.0f;
        } else if (floatValue < -20.0f) {
            floatValue = -20.0f;
        }
        z90.a(this.d);
        this.a.c.a((d90) Float.valueOf(floatValue));
        this.d = this.a.d().a().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: s80
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                c90.this.a((List) obj);
            }
        });
    }

    @tl0(threadMode = ThreadMode.BACKGROUND)
    public void onSocChanged(my.m0 m0Var) {
        float f;
        float f2;
        j90 j90Var;
        StringBuilder a2 = jg.a("onSocChanged soc =");
        a2.append(m0Var.a);
        LogUtils.i("ChartStatisticsModel", a2.toString());
        int b2 = r70.b.a.b();
        if (b2 != 2) {
            if (b2 == 7) {
                int intValue = ((Integer) m0Var.a).intValue();
                float g = a70.l() ? ((oz) CarApi.e().d()).g(XToggleDrawable.LIGHT_RADIUS_DEFAULT) : (((oz) CarApi.e().d()).a(XToggleDrawable.LIGHT_RADIUS_DEFAULT) * ((oz) CarApi.e().d()).b(XToggleDrawable.LIGHT_RADIUS_DEFAULT)) / 1000.0f;
                if (g <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    return;
                }
                z90.a(this.b);
                this.a.b(new j90(intValue, g));
                this.b = this.a.e().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: t80
                    @Override // defpackage.rh0
                    public final void accept(Object obj) {
                        c90.this.c((List) obj);
                    }
                });
                return;
            }
            return;
        }
        int intValue2 = ((Integer) m0Var.a).intValue();
        LogUtils.i("ChartStatisticsModel", "handleSocChangedWhenCharging soc =" + intValue2);
        int f3 = x90.f();
        if (2 == f3) {
            f = x90.i();
            f2 = x90.j();
        } else if (1 == f3) {
            f = x90.a();
            f2 = x90.b();
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        if (a70.l()) {
            float g2 = ((oz) x90.s()).g(-1.0f);
            LogUtils.i("ChartStatisticsModel", "current = " + f + " , volt= " + f2 + "power= " + g2);
            if (g2 > XToggleDrawable.LIGHT_RADIUS_DEFAULT && g2 < 1638.0f) {
                j90Var = new j90(intValue2, g2);
            } else {
                LogUtils.e("ChartStatisticsModel", "power <= 0");
                j90Var = new j90(intValue2, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
            }
        } else {
            LogUtils.i("ChartStatisticsModel", "current = " + f + " , volt= " + f2);
            if (f != -1.0f && f2 != -1.0f) {
                float a3 = x90.a(f, f2);
                if (a3 <= XToggleDrawable.LIGHT_RADIUS_DEFAULT) {
                    LogUtils.e("ChartStatisticsModel", "power <= 0");
                    return;
                }
                j90Var = new j90(intValue2, a3);
            } else {
                LogUtils.e("ChartStatisticsModel", "get data error！current =" + f + "，volt =" + f2);
                return;
            }
        }
        z90.a(this.c);
        this.a.a(j90Var);
        this.c = this.a.c().b(mk0.b()).a(hh0.a()).a(new rh0() { // from class: u80
            @Override // defpackage.rh0
            public final void accept(Object obj) {
                c90.this.b((List) obj);
            }
        });
    }

    @tl0(priority = 2, sticky = true, threadMode = ThreadMode.MAIN)
    public void onStateChanged(q70 q70Var) {
        int i = q70Var.a;
        LogUtils.i("ChartStatisticsModel", "LocalChargeStateEvent state = " + i);
        if (i == 2) {
            StringBuilder a2 = jg.a("StartChargingSoc = ");
            a2.append(x90.p());
            LogUtils.i("ChartStatisticsModel", a2.toString());
            fa0.b.a.a(x90.p());
        } else if (i == 7 && fa0.b.a.a.getInt("previous_charge_status", 0) != 7) {
            fa0 fa0Var = fa0.b.a;
            fa0Var.a.edit().putInt("KEY_START2DISCHARGE_ELEC", x90.p()).apply();
        }
        if (i != 2 && i != 3 && i != 4) {
            LogUtils.i("ChartStatisticsModel", "clearChargeData");
            this.a.a();
            fa0.b.a.a(-1);
        }
        if (i == 7 || i == 8 || i == 9) {
            return;
        }
        LogUtils.i("ChartStatisticsModel", "clearDischargeData");
        this.a.b();
        fa0.b.a.a.edit().putInt("KEY_START2DISCHARGE_ELEC", -1).apply();
    }

    public void d(h90 h90Var) {
        this.e.remove(h90Var);
    }

    public float a() {
        return this.h;
    }

    public float b() {
        return this.k;
    }

    public float c() {
        return this.j;
    }

    public void a(h90 h90Var) {
        this.f.add(h90Var);
    }

    public void b(h90 h90Var) {
        this.e.add(h90Var);
    }

    public void c(h90 h90Var) {
        this.f.remove(h90Var);
    }

    public void a(g90 g90Var) {
        this.g.add(g90Var);
    }

    public void b(g90 g90Var) {
        this.g.remove(g90Var);
    }

    public /* synthetic */ c90(a aVar) {
    }
}
