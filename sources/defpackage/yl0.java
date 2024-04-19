package defpackage;

import android.util.Log;
import java.util.logging.Level;
/* compiled from: AndroidLogger.java */
/* renamed from: yl0  reason: default package */
/* loaded from: classes.dex */
public class yl0 implements nl0 {
    public static final boolean b;
    public final String a;

    static {
        boolean z = false;
        try {
            if (Class.forName("android.util.Log") != null) {
                z = true;
            }
        } catch (ClassNotFoundException unused) {
        }
        b = z;
    }

    public yl0(String str) {
        this.a = str;
    }

    public static boolean a() {
        return b;
    }

    @Override // defpackage.nl0
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(a(level), this.a, str);
        }
    }

    @Override // defpackage.nl0
    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int a = a(level);
            String str2 = this.a;
            Log.println(a, str2, str + "\n" + Log.getStackTraceString(th));
        }
    }

    public final int a(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        } else if (intValue < 900) {
            return 4;
        } else {
            return intValue < 1000 ? 5 : 6;
        }
    }
}
