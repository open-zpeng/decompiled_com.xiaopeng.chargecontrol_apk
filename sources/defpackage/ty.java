package defpackage;

import android.util.Log;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.my;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: RemainingDistanceConverter.java */
/* renamed from: ty  reason: default package */
/* loaded from: classes.dex */
public class ty {
    public int a;

    public void a() {
        iv.d(this);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCltcRemainingDistanceChanged(my.n nVar) {
        StringBuilder a = jg.a("onCltcRemainingDistanceChanged event");
        a.append(nVar.a);
        Log.i("RemainingDistanceConverter", a.toString());
        if (this.a == 2) {
            iv.c(new uy(((Integer) nVar.a).intValue()));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Integer] */
    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onCltcRemainingDistanceFloatChanged(my.o oVar) {
        StringBuilder a = jg.a("onCltcRemainingDistanceFloatChanged event");
        a.append(oVar.a);
        Log.i("RemainingDistanceConverter", a.toString());
        if (a70.m()) {
            if (this.a == 2) {
                iv.c(new uy(((Float) oVar.a).intValue()));
                return;
            }
            return;
        }
        my.n nVar = new my.n();
        nVar.a = new Integer(((Float) oVar.a).intValue());
        iv.c(nVar);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDistanceDisplayModeChanged(my.e0 e0Var) {
        int p;
        float f;
        this.a = ((Integer) e0Var.a).intValue();
        int i = this.a;
        if (i == 1) {
            f = ((oz) CarApi.e().d()).h(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } else if (i == 2) {
            f = ((oz) CarApi.e().d()).c(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } else if (i == 3) {
            f = ((oz) CarApi.e().d()).f(XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        } else {
            p = ((oz) CarApi.e().d()).p(0);
            iv.c(new uy(p));
        }
        p = (int) f;
        iv.c(new uy(p));
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onDymanicRemainingDistanceFloatChanged(my.f0 f0Var) {
        StringBuilder a = jg.a("onDymanicRemainingDistanceFloatChanged event");
        a.append(f0Var.a);
        Log.i("RemainingDistanceConverter", a.toString());
        if (this.a == 3) {
            iv.c(new uy(new Integer(((Float) f0Var.a).intValue()).intValue()));
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onNedcRemainingDistanceChanged(my.h0 h0Var) {
        if (this.a == 0) {
            iv.c(new uy(((Integer) h0Var.a).intValue()));
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onWltpRemainingDistanceChanged(my.o0 o0Var) {
        StringBuilder a = jg.a("onWltpRemainingDistanceChanged event");
        a.append(o0Var.a);
        Log.i("RemainingDistanceConverter", a.toString());
        if (this.a == 1) {
            iv.c(new uy(((Integer) o0Var.a).intValue()));
        }
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [T, java.lang.Integer] */
    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onWltpRemainingDistanceFloatChanged(my.p0 p0Var) {
        StringBuilder a = jg.a("onWltpRemainingDistanceFloatChanged event");
        a.append(p0Var.a);
        Log.i("RemainingDistanceConverter", a.toString());
        if (a70.m()) {
            if (this.a == 1) {
                iv.c(new uy(((Float) p0Var.a).intValue()));
                return;
            }
            return;
        }
        my.o0 o0Var = new my.o0();
        o0Var.a = new Integer(((Float) p0Var.a).intValue());
        iv.c(o0Var);
    }
}
