package defpackage;

import android.os.Build;
import android.util.Log;
import java.io.File;
/* compiled from: HardwareConfigState.java */
/* renamed from: xm  reason: default package */
/* loaded from: classes.dex */
public final class xm {
    public static final File f = new File("/proc/self/fd");
    public static volatile xm g;
    public final boolean a;
    public final int b;
    public final int c;
    public int d;
    public boolean e = true;

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public xm() {
        char c;
        String str = Build.MODEL;
        if (str != null && str.length() >= 7) {
            String substring = Build.MODEL.substring(0, 7);
            switch (substring.hashCode()) {
                case -1398613787:
                    if (substring.equals("SM-A520")) {
                        c = 6;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398431166:
                    if (substring.equals("SM-G930")) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398431161:
                    if (substring.equals("SM-G935")) {
                        c = 4;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398431073:
                    if (substring.equals("SM-G960")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398431068:
                    if (substring.equals("SM-G965")) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398343746:
                    if (substring.equals("SM-J720")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case -1398222624:
                    if (substring.equals("SM-N935")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    int i = Build.VERSION.SDK_INT;
                    break;
            }
        }
        this.a = true;
        int i2 = Build.VERSION.SDK_INT;
        this.b = 20000;
        this.c = 0;
    }

    public static xm b() {
        if (g == null) {
            synchronized (xm.class) {
                if (g == null) {
                    g = new xm();
                }
            }
        }
        return g;
    }

    public boolean a(int i, int i2, boolean z, boolean z2) {
        int i3;
        if (z && this.a) {
            int i4 = Build.VERSION.SDK_INT;
            return !z2 && i >= (i3 = this.c) && i2 >= i3 && a();
        }
        return false;
    }

    public final synchronized boolean a() {
        int i = this.d + 1;
        this.d = i;
        if (i >= 50) {
            this.d = 0;
            int length = f.list().length;
            this.e = length < this.b;
            if (!this.e && Log.isLoggable("Downsampler", 5)) {
                Log.w("Downsampler", "Excluding HARDWARE bitmap config because we're over the file descriptor limit, file descriptors " + length + ", limit " + this.b);
            }
        }
        return this.e;
    }
}
