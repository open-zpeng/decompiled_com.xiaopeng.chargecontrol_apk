package defpackage;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
/* compiled from: CarControlManager.java */
/* renamed from: pb0  reason: default package */
/* loaded from: classes.dex */
public class pb0 extends ContentObserver {
    public final /* synthetic */ rb0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pb0(final rb0 this$0, Handler x0) {
        super(x0);
        this.a = this$0;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        if (uri == null) {
            return;
        }
        Log.d("CarControlManager", "onChange: " + uri);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return;
        }
        char c = 65535;
        switch (lastPathSegment.hashCode()) {
            case -2027240739:
                if (lastPathSegment.equals("hvac_blower_ctrl_type")) {
                    c = '\r';
                    break;
                }
                break;
            case -1975165933:
                if (lastPathSegment.equals("battery_percent")) {
                    c = 16;
                    break;
                }
                break;
            case -1967627652:
                if (lastPathSegment.equals("hvac_wind_level")) {
                    c = 6;
                    break;
                }
                break;
            case -1613760547:
                if (lastPathSegment.equals("charge_status")) {
                    c = 14;
                    break;
                }
                break;
            case -684943650:
                if (lastPathSegment.equals("hvac_auto")) {
                    c = 1;
                    break;
                }
                break;
            case -684506577:
                if (lastPathSegment.equals("hvac_pm25")) {
                    c = 7;
                    break;
                }
                break;
            case -681141809:
                if (lastPathSegment.equals("hvac_wind_mode_color")) {
                    c = 11;
                    break;
                }
                break;
            case -535149397:
                if (lastPathSegment.equals("available_distance")) {
                    c = 15;
                    break;
                }
                break;
            case -373706315:
                if (lastPathSegment.equals("central_lock")) {
                    c = 17;
                    break;
                }
                break;
            case 255260086:
                if (lastPathSegment.equals("hvac_power")) {
                    c = 0;
                    break;
                }
                break;
            case 498854741:
                if (lastPathSegment.equals("drv_occupied")) {
                    c = 18;
                    break;
                }
                break;
            case 577486648:
                if (lastPathSegment.equals("drive_mode")) {
                    c = 21;
                    break;
                }
                break;
            case 649261694:
                if (lastPathSegment.equals("hvac_front_defrost")) {
                    c = '\t';
                    break;
                }
                break;
            case 1132513595:
                if (lastPathSegment.equals("hvac_air_purge_mode")) {
                    c = '\f';
                    break;
                }
                break;
            case 1236238596:
                if (lastPathSegment.equals("cc_ready")) {
                    c = 20;
                    break;
                }
                break;
            case 1255743617:
                if (lastPathSegment.equals("hvac_drv_sync")) {
                    c = 3;
                    break;
                }
                break;
            case 1255754170:
                if (lastPathSegment.equals("hvac_drv_temp")) {
                    c = 2;
                    break;
                }
                break;
            case 1353101630:
                if (lastPathSegment.equals("hvac_psn_sync")) {
                    c = 5;
                    break;
                }
                break;
            case 1353112183:
                if (lastPathSegment.equals("hvac_psn_temp")) {
                    c = 4;
                    break;
                }
                break;
            case 1545300410:
                if (lastPathSegment.equals("hvac_back_defrost")) {
                    c = '\n';
                    break;
                }
                break;
            case 1557084116:
                if (lastPathSegment.equals("hvac_out_temp")) {
                    c = '\b';
                    break;
                }
                break;
            case 1823004050:
                if (lastPathSegment.equals("psn_occupied")) {
                    c = 19;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                rb0 rb0Var = this.a;
                rb0Var.k(rb0.a(rb0Var, lastPathSegment));
                return;
            case 1:
                rb0 rb0Var2 = this.a;
                rb0Var2.f(rb0.a(rb0Var2, lastPathSegment));
                return;
            case 2:
                float b = rb0.b(this.a, lastPathSegment);
                rb0 rb0Var3 = this.a;
                if (b < 18.0f) {
                    b = 18.0f;
                } else if (b > 32.0f) {
                    b = 32.0f;
                }
                rb0Var3.a(b);
                return;
            case 3:
                rb0 rb0Var4 = this.a;
                rb0Var4.i(rb0.a(rb0Var4, lastPathSegment));
                return;
            case 4:
                float b2 = rb0.b(this.a, lastPathSegment);
                rb0 rb0Var5 = this.a;
                if (b2 < 18.0f) {
                    b2 = 18.0f;
                } else if (b2 > 32.0f) {
                    b2 = 32.0f;
                }
                rb0Var5.c(b2);
                return;
            case 5:
                rb0 rb0Var6 = this.a;
                rb0Var6.l(rb0.a(rb0Var6, lastPathSegment));
                return;
            case 6:
                rb0 rb0Var7 = this.a;
                rb0Var7.f(rb0.c(rb0Var7, lastPathSegment));
                return;
            case 7:
                rb0 rb0Var8 = this.a;
                rb0Var8.e(rb0.c(rb0Var8, lastPathSegment));
                return;
            case '\b':
                rb0 rb0Var9 = this.a;
                rb0Var9.b(rb0.b(rb0Var9, lastPathSegment));
                return;
            case '\t':
                rb0 rb0Var10 = this.a;
                rb0Var10.j(rb0.a(rb0Var10, lastPathSegment));
                return;
            case '\n':
                rb0 rb0Var11 = this.a;
                rb0Var11.g(rb0.a(rb0Var11, lastPathSegment));
                return;
            case 11:
                rb0 rb0Var12 = this.a;
                rb0Var12.g(rb0.c(rb0Var12, lastPathSegment));
                return;
            case '\f':
                rb0 rb0Var13 = this.a;
                rb0Var13.e(rb0.a(rb0Var13, lastPathSegment));
                return;
            case '\r':
                rb0 rb0Var14 = this.a;
                rb0Var14.h(rb0.a(rb0Var14, lastPathSegment));
                return;
            case 14:
                rb0 rb0Var15 = this.a;
                rb0Var15.a(rb0.c(rb0Var15, lastPathSegment));
                return;
            case 15:
                rb0 rb0Var16 = this.a;
                rb0Var16.b(rb0.c(rb0Var16, lastPathSegment));
                return;
            case 16:
                rb0 rb0Var17 = this.a;
                rb0Var17.d(rb0.c(rb0Var17, lastPathSegment));
                return;
            case 17:
                rb0 rb0Var18 = this.a;
                rb0Var18.c(rb0.a(rb0Var18, lastPathSegment));
                return;
            case 18:
                rb0 rb0Var19 = this.a;
                rb0Var19.d(rb0.a(rb0Var19, lastPathSegment));
                return;
            case 19:
                rb0 rb0Var20 = this.a;
                rb0Var20.m(rb0.a(rb0Var20, lastPathSegment));
                return;
            case 20:
                rb0 rb0Var21 = this.a;
                rb0Var21.b(rb0.a(rb0Var21, lastPathSegment));
                return;
            case 21:
                rb0 rb0Var22 = this.a;
                rb0Var22.c(rb0.c(rb0Var22, lastPathSegment));
                return;
            default:
                return;
        }
    }
}
