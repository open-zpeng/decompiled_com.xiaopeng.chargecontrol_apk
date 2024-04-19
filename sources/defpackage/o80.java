package defpackage;

import android.app.ActivityThread;
import android.net.Uri;
import android.util.Log;
import defpackage.f10;
import defpackage.r70;
import defpackage.w90;
import defpackage.y60;
/* compiled from: ChargeSpeechModel.java */
/* renamed from: o80  reason: default package */
/* loaded from: classes.dex */
public class o80 {

    /* compiled from: ChargeSpeechModel.java */
    /* renamed from: o80$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final o80 a = new o80(null);
    }

    public /* synthetic */ o80(a aVar) {
    }

    public void A() {
        Log.i("ChargeSpeechModel", "语音 开始充电");
        x90.y();
    }

    public void B() {
        Log.i("ChargeSpeechModel", "语音 停止充电");
        x90.z();
    }

    public void C() {
        Log.i("ChargeSpeechModel", "语音 关闭充电管理界面");
        if (a70.m() || !w90.b.a.b()) {
            return;
        }
        f10.b.a.a(h10.c.buildUpon().build());
    }

    public void D() {
        Log.i("ChargeSpeechModel", "语音 打开充电管理界面");
        f10.b.a.a(h10.a.buildUpon().appendQueryParameter("from", "speech").build());
    }

    public int a() {
        if (r70.b.a.c()) {
            return 1;
        }
        return r70.b.a.e() ? 2 : 0;
    }

    public void b(int i) {
        Log.i("ChargeSpeechModel", "setDischargeLimit() called with: limit = [" + i + "]");
        x90.f(i);
    }

    public int c() {
        return y60.a.b;
    }

    public int d() {
        return y60.a.a;
    }

    public int e() {
        return x90.p() - 1;
    }

    public int f() {
        return 20;
    }

    public int g() {
        return !x90.v() ? 2 : 4;
    }

    public int h() {
        int a2 = ((qz) x90.u()).a(-1);
        if (a2 != -1) {
            return a2;
        }
        return 2;
    }

    public int i() {
        if (x90.v()) {
            if (x90.g() == 3) {
                return 4;
            }
            if (x90.g() == 4) {
                return 6;
            }
            if (x90.w()) {
                return x90.w() ? 5 : 0;
            }
            return 3;
        }
        return 2;
    }

    public int j() {
        if (x90.v()) {
            return !x90.w() ? 3 : 1;
        }
        return 2;
    }

    public int k() {
        return x90.r();
    }

    public int l() {
        if (x90.o() < 40) {
            return 2;
        }
        return x90.r() == 2 ? 1 : 0;
    }

    public boolean m() {
        return a70.a();
    }

    public boolean n() {
        return a70.b();
    }

    public void o() {
        ActivityThread.currentApplication();
        Log.i("ChargeSpeechModel", "SpeechClient int()");
    }

    public boolean p() {
        return r70.b.a.b() == 1;
    }

    public boolean q() {
        return false;
    }

    public boolean r() {
        return true;
    }

    public boolean s() {
        return a70.k();
    }

    public boolean t() {
        return false;
    }

    public void u() {
        Log.i("ChargeSpeechModel", "语音 设置充满 ");
        x90.e(y60.a.b);
    }

    public void v() {
        Log.i("ChargeSpeechModel", "语音 关闭最佳充电");
        x90.e(y60.a.b);
    }

    public void w() {
        Log.i("ChargeSpeechModel", "语音 关闭最佳充电");
        x90.e(y60.a.b);
    }

    public void x() {
        Log.i("ChargeSpeechModel", "语音 设置最佳充电 ");
        x90.e(y60.a.c);
    }

    public void y() {
        if (!a70.c()) {
            Log.i("ChargeSpeechModel", "语音 打开充电口");
            ((bz) x90.c()).b(true);
            ((bz) x90.c()).b(false);
            return;
        }
        Log.w("ChargeSpeechModel", "The platform does not support open charging port by voice command");
    }

    public void z() {
        Log.e("ChargeSpeechModel", "不支持语音重新开始充电");
    }

    public void c(String str) {
        int i;
        if ("WLTP".equals(str)) {
            i = 1;
        } else if ("CLTC".equals(str)) {
            i = 2;
        } else {
            i = "Dynamic".equals(str) ? 3 : 0;
        }
        x90.g(i);
    }

    public void d(int i) {
        Log.i("ChargeSpeechModel", "语音 设置智能充电盖 status = " + i);
        ((qz) x90.u()).b(i);
    }

    public int b(String str) {
        Log.i("ChargeSpeechModel", "getUnityPageOpenState pageUrl= " + str);
        return 0;
    }

    public int b() {
        return x90.l() == 0 ? 2 : 1;
    }

    public int a(String str) {
        return f10.b.a.a(Uri.parse(str));
    }

    public void c(int i) {
        Log.i("ChargeSpeechModel", "语音   setElectricityMode  " + i);
        x90.d(i);
    }

    public void a(int i) {
        Log.i("ChargeSpeechModel", "语音 onModePercent target = " + i);
        x90.e(i);
    }

    public void a(boolean z) {
        Log.i("ChargeSpeechModel", "语音 后备箱电源控制开关 on = " + z);
        if (z) {
            if (x90.o() < 40 || x90.x()) {
                return;
            }
            x90.b(true);
            return;
        }
        x90.b(false);
    }
}
