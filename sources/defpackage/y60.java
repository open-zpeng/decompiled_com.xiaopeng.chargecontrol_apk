package defpackage;

import android.os.SystemProperties;
/* compiled from: Battery.java */
/* renamed from: y60  reason: default package */
/* loaded from: classes.dex */
public class y60 {
    public static final int a;

    /* compiled from: Battery.java */
    /* renamed from: y60$a */
    /* loaded from: classes.dex */
    public static class a {
        public static final int a;
        public static final int b;
        public static final int c;

        static {
            z60 e70Var;
            int i = y60.a;
            if (i == 1) {
                e70Var = new f70();
            } else if (i == 2) {
                e70Var = new d70();
            } else {
                e70Var = new e70();
            }
            a = 50;
            b = e70Var.b();
            c = e70Var.a();
        }
    }

    static {
        int i;
        if (a()) {
            i = 1;
        } else {
            i = "1".equals(SystemProperties.get("persist.sys.xiaopeng.batteryType", "0")) ? 2 : 0;
        }
        a = i;
    }

    public static boolean a() {
        return "1".equals(SystemProperties.get("persist.sys.xiaopeng.cfc_travel", "0"));
    }
}
