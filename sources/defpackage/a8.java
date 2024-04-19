package defpackage;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.fonts.FontVariationAxis;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: TypefaceCompatApi26Impl.java */
/* renamed from: a8  reason: default package */
/* loaded from: classes.dex */
public class a8 extends z7 {
    public final Class<?> g;
    public final Constructor<?> h;
    public final Method i;
    public final Method j;
    public final Method k;
    public final Method l;
    public final Method m;

    public a8() {
        Class<?> cls;
        Method method;
        Method method2;
        Method method3;
        Method method4;
        Method method5;
        Constructor<?> constructor = null;
        try {
            cls = Class.forName("android.graphics.FontFamily");
            Constructor<?> constructor2 = cls.getConstructor(new Class[0]);
            method3 = a(cls);
            method4 = b(cls);
            method5 = cls.getMethod("freeze", new Class[0]);
            method = cls.getMethod("abortCreation", new Class[0]);
            method2 = c(cls);
            constructor = constructor2;
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            StringBuilder a = jg.a("Unable to collect necessary methods for class ");
            a.append(e.getClass().getName());
            Log.e("TypefaceCompatApi26Impl", a.toString(), e);
            cls = null;
            method = null;
            method2 = null;
            method3 = null;
            method4 = null;
            method5 = null;
        }
        this.g = cls;
        this.h = constructor;
        this.i = method3;
        this.j = method4;
        this.k = method5;
        this.l = method;
        this.m = method2;
    }

    private Object c() {
        try {
            return this.h.newInstance(new Object[0]);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    public final boolean a(Context context, Object obj, String str, int i, int i2, int i3, FontVariationAxis[] fontVariationAxisArr) {
        try {
            return ((Boolean) this.i.invoke(obj, context.getAssets(), str, 0, false, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), fontVariationAxisArr)).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Typeface b(Object obj) {
        throw null;
    }

    public final boolean b() {
        if (this.i == null) {
            Log.w("TypefaceCompatApi26Impl", "Unable to collect necessary private methods. Fallback to legacy implementation.");
        }
        return this.i != null;
    }

    public Method c(Class<?> cls) {
        throw null;
    }

    public final boolean c(Object obj) {
        try {
            return ((Boolean) this.k.invoke(obj, new Object[0])).booleanValue();
        } catch (IllegalAccessException | InvocationTargetException unused) {
            return false;
        }
    }

    public Method b(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromBuffer", ByteBuffer.class, cls2, FontVariationAxis[].class, cls2, cls2);
    }

    public final void a(Object obj) {
        try {
            this.l.invoke(obj, new Object[0]);
        } catch (IllegalAccessException | InvocationTargetException unused) {
        }
    }

    @Override // defpackage.z7, defpackage.d8
    public Typeface a(Context context, r7 r7Var, Resources resources, int i) {
        s7[] s7VarArr;
        if (!b()) {
            return super.a(context, r7Var, resources, i);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        for (s7 s7Var : r7Var.a) {
            if (!a(context, c, s7Var.a, s7Var.e, s7Var.b, s7Var.c ? 1 : 0, FontVariationAxis.fromFontVariationSettings(s7Var.d))) {
                a(c);
                return null;
            }
        }
        if (c(c)) {
            return b(c);
        }
        return null;
    }

    @Override // defpackage.d8
    public Typeface a(Context context, CancellationSignal cancellationSignal, w8[] w8VarArr, int i) {
        Typeface b;
        boolean z;
        if (w8VarArr.length < 1) {
            return null;
        }
        if (!b()) {
            w8 a = a(w8VarArr, i);
            try {
                ParcelFileDescriptor openFileDescriptor = context.getContentResolver().openFileDescriptor(a.a, "r", cancellationSignal);
                if (openFileDescriptor == null) {
                    if (openFileDescriptor != null) {
                        openFileDescriptor.close();
                    }
                    return null;
                }
                Typeface build = new Typeface.Builder(openFileDescriptor.getFileDescriptor()).setWeight(a.c).setItalic(a.d).build();
                openFileDescriptor.close();
                return build;
            } catch (IOException unused) {
                return null;
            }
        }
        HashMap hashMap = new HashMap();
        for (w8 w8Var : w8VarArr) {
            if (w8Var.a() == 0) {
                Uri uri = w8Var.a;
                if (!hashMap.containsKey(uri)) {
                    hashMap.put(uri, a.a(context, cancellationSignal, uri));
                }
            }
        }
        Map unmodifiableMap = Collections.unmodifiableMap(hashMap);
        Object c = c();
        if (c == null) {
            return null;
        }
        int length = w8VarArr.length;
        int i2 = 0;
        boolean z2 = false;
        while (i2 < length) {
            w8 w8Var2 = w8VarArr[i2];
            ByteBuffer byteBuffer = (ByteBuffer) unmodifiableMap.get(w8Var2.a);
            if (byteBuffer != null) {
                try {
                    z = ((Boolean) this.j.invoke(c, byteBuffer, Integer.valueOf(w8Var2.b), null, Integer.valueOf(w8Var2.c), Integer.valueOf(w8Var2.d ? 1 : 0))).booleanValue();
                } catch (IllegalAccessException | InvocationTargetException unused2) {
                    z = false;
                }
                if (!z) {
                    a(c);
                    return null;
                }
                z2 = true;
            }
            i2++;
            z2 = z2;
        }
        if (!z2) {
            a(c);
            return null;
        } else if (c(c) && (b = b(c)) != null) {
            return Typeface.create(b, i);
        } else {
            return null;
        }
    }

    @Override // defpackage.d8
    public Typeface a(Context context, Resources resources, int i, String str, int i2) {
        if (!b()) {
            return super.a(context, resources, i, str, i2);
        }
        Object c = c();
        if (c == null) {
            return null;
        }
        if (!a(context, c, str, 0, -1, -1, null)) {
            a(c);
            return null;
        } else if (c(c)) {
            return b(c);
        } else {
            return null;
        }
    }

    public Method a(Class<?> cls) {
        Class<?> cls2 = Integer.TYPE;
        return cls.getMethod("addFontFromAssetManager", AssetManager.class, String.class, Integer.TYPE, Boolean.TYPE, cls2, cls2, cls2, FontVariationAxis[].class);
    }
}
