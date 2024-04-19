package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
/* compiled from: TypefaceCompatBaseImpl.java */
/* renamed from: d8  reason: default package */
/* loaded from: classes.dex */
public class d8 {
    @SuppressLint({"BanConcurrentHashMap"})
    public ConcurrentHashMap<Long, r7> a = new ConcurrentHashMap<>();

    public Typeface a(Context context, CancellationSignal cancellationSignal, w8[] w8VarArr, int i) {
        throw null;
    }

    public Typeface a(Context context, r7 r7Var, Resources resources, int i) {
        throw null;
    }

    public w8 a(w8[] w8VarArr, int i) {
        int i2 = (i & 1) == 0 ? 400 : 700;
        boolean z = (i & 2) != 0;
        int i3 = Integer.MAX_VALUE;
        w8 w8Var = null;
        for (w8 w8Var2 : w8VarArr) {
            int abs = (Math.abs(w8Var2.c - i2) * 2) + (w8Var2.d == z ? 0 : 1);
            if (w8Var == null || i3 > abs) {
                w8Var = w8Var2;
                i3 = abs;
            }
        }
        return w8Var;
    }

    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        File a = a.a(context);
        if (a == null) {
            return null;
        }
        try {
            if (a.a(a, resources, i)) {
                return Typeface.createFromFile(a.getPath());
            }
            return null;
        } catch (RuntimeException unused) {
            return null;
        } finally {
            a.delete();
        }
    }
}
