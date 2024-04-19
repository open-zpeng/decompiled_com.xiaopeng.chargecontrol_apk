package defpackage;

import android.content.Context;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import defpackage.jy;
import java.util.Map;
/* compiled from: CarMcuControllerCompat.java */
/* renamed from: jz  reason: default package */
/* loaded from: classes.dex */
public class jz extends iz {
    public jz(Context context) {
        super(context);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // defpackage.iz, defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        char c;
        super.a(map);
        String a = y90.a();
        int hashCode = a.hashCode();
        if (hashCode == 2577) {
            if (a.equals("QB")) {
                c = '\b';
            }
            c = 65535;
        } else if (hashCode != 79487) {
            switch (hashCode) {
                case 2560:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q1)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2561:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q2)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case 2562:
                    if (a.equals(VuiUtils.CAR_PLATFORM_Q3)) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
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
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2568:
                            if (a.equals("Q9")) {
                                c = 7;
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
                c = 5;
            }
            c = 65535;
        }
        if (c == 0 || c == 1) {
            return;
        }
        if (c != 2 && c != 3) {
            map.put(557847655, d00.a(new jy.e()));
            map.put(557847656, d00.a(new jy.d()));
            map.put(557847662, d00.a(new jy.c()));
            return;
        }
        map.put(557847638, d00.a(new jy.a()));
    }
}
