package defpackage;

import android.app.ActivityThread;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* compiled from: $Gson$Preconditions.java */
/* renamed from: iv  reason: default package */
/* loaded from: classes.dex */
public final class iv {
    public static Intent a(Intent intent) {
        return intent.putExtra("from", "gun");
    }

    public static void b() {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("xiaopeng://aiot/device/detail?type=fridge&from=powercenter"));
            intent.addFlags(268468224);
            ActivityThread.currentApplication().startActivity(intent);
        } catch (Exception e) {
            Log.e("FridgeUtil", "Failed to open fridge settings", e);
        }
    }

    public static void c(Object obj) {
        jl0.c().c(obj);
    }

    public static void d(Object obj) {
        jl0.c().d(obj);
    }

    public static void e(Object obj) {
        jl0.c().e(obj);
    }

    public static m10 a() {
        int i = y60.a;
        if (i == 1) {
            return new b20();
        }
        if (i == 2) {
            return new z10();
        }
        return new a20();
    }

    public static <T> T a(T t) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException();
    }

    public static DateFormat a(int i, int i2) {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder();
        if (i == 0) {
            str = "EEEE, MMMM d, yyyy";
        } else if (i == 1) {
            str = "MMMM d, yyyy";
        } else if (i == 2) {
            str = "MMM d, yyyy";
        } else if (i != 3) {
            throw new IllegalArgumentException(jg.a("Unknown DateFormat style: ", i));
        } else {
            str = "M/d/yy";
        }
        sb.append(str);
        sb.append(" ");
        if (i2 == 0 || i2 == 1) {
            str2 = "h:mm:ss a z";
        } else if (i2 == 2) {
            str2 = "h:mm:ss a";
        } else if (i2 != 3) {
            throw new IllegalArgumentException(jg.a("Unknown DateFormat style: ", i2));
        } else {
            str2 = "h:mm a";
        }
        sb.append(str2);
        return new SimpleDateFormat(sb.toString(), Locale.US);
    }

    public static boolean b(Object obj) {
        return jl0.c().a(obj);
    }

    public static void a(String str, String str2) {
        if (y90.b() || a70.m()) {
            return;
        }
        Log.i("ActionTracker", "tacking pageId = " + str + " buttonId = " + str2);
        IDataLog iDataLog = (IDataLog) Module.get(oa0.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildMoleEvent().setModule("energycenter").setPageId(str).setButtonId(str2).build());
    }

    public static void a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void a(String str, String str2, String str3, Number number) {
        if (y90.b() || a70.m()) {
            return;
        }
        Log.i("ActionTracker", "tacking pageId = " + str + " buttonId = " + str2 + " property = " + str3 + "val = " + number);
        IDataLog iDataLog = (IDataLog) Module.get(oa0.class).get(IDataLog.class);
        iDataLog.sendStatData(iDataLog.buildMoleEvent().setModule("energycenter").setPageId(str).setButtonId(str2).setProperty(str3, number).build());
    }

    public static Writer a(Appendable appendable) {
        return appendable instanceof Writer ? (Writer) appendable : new dw(appendable);
    }
}
