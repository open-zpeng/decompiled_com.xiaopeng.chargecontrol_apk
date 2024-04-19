package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import androidx.startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
/* compiled from: AppInitializer.java */
/* renamed from: xf  reason: default package */
/* loaded from: classes.dex */
public final class xf {
    public static volatile xf d;
    public static final Object e = new Object();
    public final Context c;
    public final Set<Class<? extends yf<?>>> b = new HashSet();
    public final Map<Class<?>, Object> a = new HashMap();

    public xf(Context context) {
        this.c = context.getApplicationContext();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void a() {
        try {
            try {
                int i = Build.VERSION.SDK_INT;
                Trace.beginSection("Startup");
                Bundle bundle = this.c.getPackageManager().getProviderInfo(new ComponentName(this.c.getPackageName(), InitializationProvider.class.getName()), 128).metaData;
                String string = this.c.getString(zf.androidx_startup);
                if (bundle != null) {
                    HashSet hashSet = new HashSet();
                    for (String str : bundle.keySet()) {
                        if (string.equals(bundle.getString(str, null))) {
                            Class<?> cls = Class.forName(str);
                            if (yf.class.isAssignableFrom(cls)) {
                                this.b.add(cls);
                                a(cls, hashSet);
                            }
                        }
                    }
                }
            } finally {
                int i2 = Build.VERSION.SDK_INT;
                Trace.endSection();
            }
        } catch (PackageManager.NameNotFoundException | ClassNotFoundException e2) {
            throw new ag(e2);
        }
    }

    public static xf a(Context context) {
        if (d == null) {
            synchronized (e) {
                if (d == null) {
                    d = new xf(context);
                }
            }
        }
        return d;
    }

    public <T> T a(Class<? extends yf<?>> cls, Set<Class<?>> set) {
        T t;
        synchronized (e) {
            if (a.a()) {
                String simpleName = cls.getSimpleName();
                int i = Build.VERSION.SDK_INT;
                Trace.beginSection(simpleName);
            }
            if (!set.contains(cls)) {
                if (!this.a.containsKey(cls)) {
                    set.add(cls);
                    yf<?> newInstance = cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                    List<Class<? extends yf<?>>> a = newInstance.a();
                    if (!a.isEmpty()) {
                        for (Class<? extends yf<?>> cls2 : a) {
                            if (!this.a.containsKey(cls2)) {
                                a(cls2, set);
                            }
                        }
                    }
                    t = (T) newInstance.a(this.c);
                    set.remove(cls);
                    this.a.put(cls, t);
                } else {
                    t = (T) this.a.get(cls);
                }
                int i2 = Build.VERSION.SDK_INT;
                Trace.endSection();
            } else {
                throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
            }
        }
        return t;
    }
}
