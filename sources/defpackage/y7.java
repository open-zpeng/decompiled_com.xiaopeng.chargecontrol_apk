package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Build;
import defpackage.m3;
/* compiled from: TypefaceCompat.java */
@SuppressLint({"NewApi"})
/* renamed from: y7  reason: default package */
/* loaded from: classes.dex */
public class y7 {
    public static final d8 a;
    public static final d5<String, Typeface> b;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            a = new c8();
        } else {
            a = new b8();
        }
        b = new d5<>(16);
    }

    public static String a(Resources resources, int i, int i2) {
        return resources.getResourcePackageName(i) + "-" + i + "-" + i2;
    }

    /* compiled from: TypefaceCompat.java */
    /* renamed from: y7$a */
    /* loaded from: classes.dex */
    public static class a extends x8 {
        public u7 a;

        public a(u7 u7Var) {
            this.a = u7Var;
        }

        @Override // defpackage.x8
        public void a(Typeface typeface) {
            u7 u7Var = this.a;
            if (u7Var != null) {
                u7Var.a(typeface);
            }
        }

        @Override // defpackage.x8
        public void a(int i) {
            u7 u7Var = this.a;
            if (u7Var != null) {
                m3.a aVar = (m3.a) u7Var;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0024, code lost:
        if (r0.equals(r4) == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Typeface a(android.content.Context r5, defpackage.q7 r6, android.content.res.Resources r7, int r8, int r9, defpackage.u7 r10, android.os.Handler r11, boolean r12) {
        /*
            Method dump skipped, instructions count: 217
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.y7.a(android.content.Context, q7, android.content.res.Resources, int, int, u7, android.os.Handler, boolean):android.graphics.Typeface");
    }

    public static Typeface a(Context context, Resources resources, int i, String str, int i2) {
        Typeface a2 = a.a(context, resources, i, str, i2);
        if (a2 != null) {
            b.a(a(resources, i, i2), a2);
        }
        return a2;
    }

    public static Typeface a(Context context, Typeface typeface, int i) {
        if (context != null) {
            int i2 = Build.VERSION.SDK_INT;
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }
}
