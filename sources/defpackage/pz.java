package defpackage;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeWrapper;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.d00;
import defpackage.my;
import java.util.Map;
/* compiled from: CarVcuControllerCompat.java */
/* renamed from: pz  reason: default package */
/* loaded from: classes.dex */
public class pz extends oz {
    public pz(Context context) {
        super(context);
    }

    @Override // defpackage.oz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        super.a(map);
        map.put(557847080, d00.a(new my.j(), new wy(new int[]{0, 1, 2, 3, 4, 5})));
        map.put(557847081, d00.a(new my.l(), new wy(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 15})));
        map.put(557847059, d00.b(new my.m()).a());
        map.put(559944302, d00.b(new my.c0()).a());
        d00.b b = d00.b(new my.b0());
        b.d = true;
        map.put(557847052, b.a());
        map.put(559944196, d00.a(new my.a()));
        map.put(559944195, d00.a(new my.b()));
        map.put(559944198, d00.a(new my.v()));
        map.put(559944199, d00.a(new my.y()));
        map.put(559944337, d00.a(new my.j0(), c00.e, ThemeWrapper.TIMEOUT));
        d00.b b2 = d00.b(new my.e0());
        b2.d = true;
        map.put(557847127, b2.a());
        map.put(559944315, d00.a(new my.p0(), new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1638.3f)));
        map.put(559944314, d00.a(new my.o(), new xy(XToggleDrawable.LIGHT_RADIUS_DEFAULT, 1638.3f)));
        map.put(557847123, d00.a(new my.d()));
        map.put(557847141, d00.a(new my.i0()));
        map.put(557847146, d00.a(new my.x()));
        map.put(557847148, d00.a(new my.w()));
        map.put(557847160, d00.a(new my.z()));
        map.put(557847166, d00.a(new my.n0()));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static oz a(Context context) {
        char c;
        String a = y90.a();
        int hashCode = a.hashCode();
        if (hashCode == 2577) {
            if (a.equals("QB")) {
                c = '\t';
            }
            c = 65535;
        } else if (hashCode != 79487) {
            switch (hashCode) {
                case 2560:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q1)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2561:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q2)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2562:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q3)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 2564:
                            if (a.equals(VuiUtils.CAR_PLATFORM_Q5)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2565:
                            if (a.equals(VuiUtils.CAR_PLATFORM_Q6)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2566:
                            if (a.equals(VuiUtils.CAR_PLATFORM_Q7)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2567:
                            if (a.equals(VuiUtils.CAR_PLATFORM_Q8)) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2568:
                            if (a.equals("Q9")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
        } else {
            if (a.equals("Q3A")) {
                c = 4;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
            case 1:
                return new sz(context);
            case 2:
                return new tz(context);
            case 3:
            case 4:
                return new wz(context);
            case 5:
                return new xz(context);
            case 6:
                return new zz(context);
            case 7:
                return new yz(context);
            case '\b':
                return new b00(context);
            default:
                return new pz(context);
        }
    }
}
