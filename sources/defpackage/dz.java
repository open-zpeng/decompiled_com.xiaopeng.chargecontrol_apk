package defpackage;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.car.hardware.CarEcuManager;
import android.car.hardware.CarPropertyValue;
import android.content.Context;
import android.os.SystemClock;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* compiled from: CarController.java */
/* renamed from: dz  reason: default package */
/* loaded from: classes.dex */
public abstract class dz<T extends CarEcuManager> {
    public final Map<Integer, d00<?>> a;
    public final Map<Integer, d00<?>> b;
    public volatile T c;
    public Context d;
    public final CarEcuManager.CarEcuEventCallback e = new a();

    /* compiled from: CarController.java */
    /* renamed from: dz$a */
    /* loaded from: classes.dex */
    public class a implements CarEcuManager.CarEcuEventCallback {
        public a() {
        }

        /* JADX WARN: Type inference failed for: r8v1, types: [T, java.lang.Object] */
        public void onChangeEvent(CarPropertyValue carPropertyValue) {
            if (carPropertyValue.getValue() == null) {
                return;
            }
            dz dzVar = dz.this;
            int propertyId = carPropertyValue.getPropertyId();
            d00<?> d00Var = dzVar.a.get(Integer.valueOf(propertyId));
            if (d00Var == null) {
                d00Var = dzVar.b.get(Integer.valueOf(propertyId));
            }
            if (d00Var == null) {
                return;
            }
            e00<?> e00Var = d00Var.b;
            if (e00Var != null && e00Var.a(carPropertyValue.getValue())) {
                Log.i("CarController", "onChangeEvent: filtered value [" + carPropertyValue + "], current = " + dz.this.a(d00Var.a));
                return;
            }
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime - d00Var.e >= d00Var.c) {
                d00Var.e = elapsedRealtime;
            }
            d00Var.a.a = carPropertyValue.getValue();
            iv.c(d00Var.a);
        }

        public void onErrorEvent(int i, int i2) {
            StringBuilder a = jg.a("onErrorEvent() called with: id = [");
            a.append(Integer.toHexString(i));
            a.append("], error = [");
            a.append(i2);
            a.append("]");
            Log.w("CarController", a.toString());
        }
    }

    public dz(Context context) {
        this.d = context;
        HashMap hashMap = new HashMap();
        a(hashMap);
        HashMap hashMap2 = new HashMap(hashMap.size());
        HashMap hashMap3 = new HashMap(hashMap.size() / 3);
        for (Map.Entry<Integer, d00<?>> entry : hashMap.entrySet()) {
            if (entry.getValue().d) {
                hashMap2.put(entry.getKey(), entry.getValue());
            } else {
                hashMap3.put(entry.getKey(), entry.getValue());
            }
        }
        this.a = Collections.unmodifiableMap(hashMap2);
        this.b = Collections.unmodifiableMap(hashMap3);
    }

    public abstract String a();

    public void a(Car car, boolean z) {
        this.c = (T) car.getCarManager(a());
        if (!this.a.isEmpty()) {
            this.c.registerPropCallback(this.a.keySet(), this.e);
        }
        if (!z || this.b.isEmpty()) {
            return;
        }
        this.c.registerPropCallback(this.b.keySet(), this.e);
    }

    public void a(Map<Integer, d00<?>> map) {
    }

    public void b() {
        if (this.c == null || this.b.isEmpty()) {
            return;
        }
        try {
            this.c.unregisterPropCallback(this.b.keySet(), this.e);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public void c() {
    }

    public void d() {
        if (this.c == null || this.b.isEmpty()) {
            return;
        }
        try {
            this.c.registerPropCallback(this.b.keySet(), this.e);
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }

    public <V> V a(Class<? extends zy<?>> cls) {
        V v;
        zy zyVar = (zy) jl0.c().a((Class<Object>) cls);
        if (zyVar == null || (v = (V) zyVar.a) == null) {
            throw new oy();
        }
        return v;
    }

    public final String a(fy<?> fyVar) {
        if (fyVar == null || fyVar.getData() == null) {
            return null;
        }
        Class<?> cls = fyVar.getData().getClass();
        if (cls.isArray()) {
            if (cls == byte[].class) {
                return Arrays.toString((byte[]) fyVar.getData());
            }
            return Arrays.toString((Object[]) fyVar.getData());
        }
        return fyVar.getData().toString();
    }
}
