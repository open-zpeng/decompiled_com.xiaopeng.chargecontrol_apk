package defpackage;

import com.xiaopeng.speech.vui.utils.VuiUtils;
/* compiled from: BaseFeatureOption.java */
/* renamed from: g70  reason: default package */
/* loaded from: classes.dex */
public class g70 {

    /* compiled from: BaseFeatureOption.java */
    /* renamed from: g70$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final g70 a;

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        static {
            char c;
            g70 o70Var;
            String a2 = y90.a();
            int hashCode = a2.hashCode();
            if (hashCode == 2577) {
                if (a2.equals("QB")) {
                    c = 1;
                }
                c = 65535;
            } else if (hashCode != 79487) {
                switch (hashCode) {
                    case 2560:
                        if (a2.equals(VuiUtils.CAR_PLATFORM_Q1)) {
                            c = 4;
                            break;
                        }
                        c = 65535;
                        break;
                    case 2561:
                        if (a2.equals(VuiUtils.CAR_PLATFORM_Q2)) {
                            c = '\b';
                            break;
                        }
                        c = 65535;
                        break;
                    case 2562:
                        if (a2.equals(VuiUtils.CAR_PLATFORM_Q3)) {
                            c = 5;
                            break;
                        }
                        c = 65535;
                        break;
                    default:
                        switch (hashCode) {
                            case 2565:
                                if (a2.equals(VuiUtils.CAR_PLATFORM_Q6)) {
                                    c = 6;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2566:
                                if (a2.equals(VuiUtils.CAR_PLATFORM_Q7)) {
                                    c = 2;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2567:
                                if (a2.equals(VuiUtils.CAR_PLATFORM_Q8)) {
                                    c = 3;
                                    break;
                                }
                                c = 65535;
                                break;
                            case 2568:
                                if (a2.equals("Q9")) {
                                    c = 0;
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
                if (a2.equals("Q3A")) {
                    c = 7;
                }
                c = 65535;
            }
            switch (c) {
                case 0:
                    o70Var = new o70();
                    break;
                case 1:
                    o70Var = new p70();
                    break;
                case 2:
                    o70Var = new n70();
                    break;
                case 3:
                    o70Var = new l70();
                    break;
                case 4:
                    o70Var = new m70();
                    break;
                case 5:
                    o70Var = new j70();
                    break;
                case 6:
                    o70Var = new i70();
                    break;
                case 7:
                    o70Var = new k70();
                    break;
                default:
                    o70Var = new h70();
                    break;
            }
            a = o70Var;
        }
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public boolean c() {
        return false;
    }
}
