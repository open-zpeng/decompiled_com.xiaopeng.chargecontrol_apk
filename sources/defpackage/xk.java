package defpackage;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: MemorySizeCalculator.java */
/* renamed from: xk  reason: default package */
/* loaded from: classes.dex */
public final class xk {
    public final int a;
    public final int b;
    public final Context c;
    public final int d;

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: xk$a */
    /* loaded from: classes.dex */
    public static final class a {
        public static final int i;
        public final Context a;
        public ActivityManager b;
        public c c;
        public float e;
        public float d = 2.0f;
        public float f = 0.4f;
        public float g = 0.33f;
        public int h = 4194304;

        static {
            int i2 = Build.VERSION.SDK_INT;
            i = 1;
        }

        public a(Context context) {
            this.e = i;
            this.a = context;
            this.b = (ActivityManager) context.getSystemService("activity");
            this.c = new b(context.getResources().getDisplayMetrics());
            int i2 = Build.VERSION.SDK_INT;
            if (xk.a(this.b)) {
                this.e = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
            }
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: xk$b */
    /* loaded from: classes.dex */
    public static final class b implements c {
        public final DisplayMetrics a;

        public b(DisplayMetrics displayMetrics) {
            this.a = displayMetrics;
        }
    }

    /* compiled from: MemorySizeCalculator.java */
    /* renamed from: xk$c */
    /* loaded from: classes.dex */
    public interface c {
    }

    public xk(a aVar) {
        int i;
        ActivityManager activityManager;
        this.c = aVar.a;
        if (a(aVar.b)) {
            i = aVar.h / 2;
        } else {
            i = aVar.h;
        }
        this.d = i;
        int round = Math.round(activityManager.getMemoryClass() * 1024 * 1024 * (a(aVar.b) ? aVar.g : aVar.f));
        c cVar = aVar.c;
        float f = ((b) cVar).a.widthPixels * ((b) cVar).a.heightPixels * 4;
        int round2 = Math.round(aVar.e * f);
        int round3 = Math.round(f * aVar.d);
        int i2 = round - this.d;
        int i3 = round3 + round2;
        if (i3 <= i2) {
            this.b = round3;
            this.a = round2;
        } else {
            float f2 = i2;
            float f3 = aVar.e;
            float f4 = aVar.d;
            float f5 = f2 / (f3 + f4);
            this.b = Math.round(f4 * f5);
            this.a = Math.round(f5 * aVar.e);
        }
        if (Log.isLoggable("MemorySizeCalculator", 3)) {
            StringBuilder a2 = jg.a("Calculation complete, Calculated memory cache size: ");
            a2.append(a(this.b));
            a2.append(", pool size: ");
            a2.append(a(this.a));
            a2.append(", byte array size: ");
            a2.append(a(this.d));
            a2.append(", memory class limited? ");
            a2.append(i3 > round);
            a2.append(", max size: ");
            a2.append(a(round));
            a2.append(", memoryClass: ");
            a2.append(aVar.b.getMemoryClass());
            a2.append(", isLowMemoryDevice: ");
            a2.append(a(aVar.b));
            Log.d("MemorySizeCalculator", a2.toString());
        }
    }

    public final String a(int i) {
        return Formatter.formatFileSize(this.c, i);
    }

    @TargetApi(19)
    public static boolean a(ActivityManager activityManager) {
        int i = Build.VERSION.SDK_INT;
        return activityManager.isLowRamDevice();
    }
}
