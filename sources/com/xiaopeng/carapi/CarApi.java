package com.xiaopeng.carapi;

import android.car.Car;
import android.car.CarNotConnectedException;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import com.xiaopeng.carapi.CarApi;
import com.xiaopeng.speech.vui.utils.VuiUtils;
import defpackage.vd;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
/* loaded from: classes.dex */
public class CarApi {
    public static volatile CarApi g;
    public Context a;
    public Car b;
    public final Handler d;
    public Map<String, dz<?>> c = new HashMap();
    public final Handler.Callback e = new Handler.Callback() { // from class: zx
        @Override // android.os.Handler.Callback
        public final boolean handleMessage(Message message) {
            return CarApi.this.a(message);
        }
    };
    public pd f = new pd() { // from class: com.xiaopeng.carapi.CarApi.3
        @Override // defpackage.rd
        public void e(zd zdVar) {
            CarApi.this.c.values().forEach(new Consumer() { // from class: by
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((dz) obj).d();
                }
            });
        }

        @Override // defpackage.pd, defpackage.rd
        public void f(zd zdVar) {
            CarApi.this.c.values().forEach(new Consumer() { // from class: cy
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((dz) obj).b();
                }
            });
        }
    };

    /* loaded from: classes.dex */
    public class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.v("CarModel", "onServiceConnected() called with: name = [" + componentName + "]");
            CarApi carApi = CarApi.this;
            carApi.d.removeMessages(1);
            carApi.d.sendEmptyMessage(1);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.v("CarModel", "onServiceDisconnected() called with: name = [" + componentName + "]");
            CarApi carApi = CarApi.this;
            carApi.d.removeMessages(2);
            carApi.d.sendEmptyMessage(2);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public CarApi(Context context) {
        char c;
        dz<?> uzVar;
        this.a = context.getApplicationContext();
        HandlerThread handlerThread = new HandlerThread("CarEventDispatcherThread");
        handlerThread.start();
        this.d = new Handler(handlerThread.getLooper(), this.e);
        bz bzVar = new bz(this.a);
        this.c.put(bzVar.a(), bzVar);
        oz a2 = pz.a(this.a);
        this.c.put(a2.a(), a2);
        nz nzVar = new nz(this.a);
        this.c.put(nzVar.a(), nzVar);
        jz jzVar = new jz(this.a);
        this.c.put(jzVar.a(), jzVar);
        Context context2 = this.a;
        String a3 = y90.a();
        int hashCode = a3.hashCode();
        if (hashCode == 2577) {
            if (a3.equals("QB")) {
                c = '\t';
            }
            c = 65535;
        } else if (hashCode != 79487) {
            switch (hashCode) {
                case 2560:
                    if (a3.equals(VuiUtils.CAR_PLATFORM_Q1)) {
                        c = 5;
                        break;
                    }
                    c = 65535;
                    break;
                case 2561:
                    if (a3.equals(VuiUtils.CAR_PLATFORM_Q2)) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 2562:
                    if (a3.equals(VuiUtils.CAR_PLATFORM_Q3)) {
                        c = 3;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    switch (hashCode) {
                        case 2564:
                            if (a3.equals(VuiUtils.CAR_PLATFORM_Q5)) {
                                c = 0;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2565:
                            if (a3.equals(VuiUtils.CAR_PLATFORM_Q6)) {
                                c = 2;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2566:
                            if (a3.equals(VuiUtils.CAR_PLATFORM_Q7)) {
                                c = 6;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2567:
                            if (a3.equals(VuiUtils.CAR_PLATFORM_Q8)) {
                                c = 7;
                                break;
                            }
                            c = 65535;
                            break;
                        case 2568:
                            if (a3.equals("Q9")) {
                                c = '\b';
                                break;
                            }
                            c = 65535;
                            break;
                        default:
                            c = 65535;
                            break;
                    }
            }
        } else {
            if (a3.equals("Q3A")) {
                c = 4;
            }
            c = 65535;
        }
        switch (c) {
            case 0:
            case 1:
            case 2:
                uzVar = new uz(context2);
                break;
            case 3:
            case 4:
                uzVar = new vz(context2);
                break;
            case 5:
            case 6:
                uzVar = new a00(context2);
                break;
            default:
                uzVar = new cz(context2);
                break;
        }
        this.c.put(uzVar.a(), uzVar);
        fz fzVar = new fz(this.a);
        this.c.put(fzVar.a(), fzVar);
        lz lzVar = new lz(this.a);
        this.c.put(lzVar.a(), lzVar);
        dy dyVar = new dy(this, this.a);
        this.c.put(dyVar.a(), dyVar);
        rz rzVar = new rz(this.a);
        this.c.put(rzVar.a(), rzVar);
        new ty().a();
        new sy().a();
        this.b = Car.createCar(context, new a(), this.d);
        this.b.connect();
    }

    public static void a(Context context) {
        if (g == null) {
            synchronized (CarApi.class) {
                if (g == null) {
                    g = new CarApi(context);
                }
            }
        }
    }

    public static CarApi e() {
        if (g != null) {
            return g;
        }
        throw new IllegalStateException("You must call init(Context) first.");
    }

    public /* synthetic */ void b() {
        he.k.h.b(this.f);
        this.c.values().forEach(new Consumer() { // from class: wx
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((dz) obj).c();
            }
        });
        jl0.c().c(new ey(false));
    }

    public jy c() {
        return (jy) Objects.requireNonNull(this.c.get("xp_mcu"));
    }

    public my d() {
        return (my) Objects.requireNonNull(this.c.get("xp_vcu"));
    }

    public /* synthetic */ boolean a(Message message) {
        int i = message.what;
        if (i == 1) {
            jb0.a(1, new Runnable() { // from class: xx
                @Override // java.lang.Runnable
                public final void run() {
                    CarApi.this.a();
                }
            });
        } else if (i == 2) {
            jb0.a(1, new Runnable() { // from class: ay
                @Override // java.lang.Runnable
                public final void run() {
                    CarApi.this.b();
                }
            });
        }
        return true;
    }

    public /* synthetic */ void a() {
        this.c.values().forEach(new Consumer() { // from class: yx
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                CarApi.this.a((dz) obj);
            }
        });
        he.k.h.a(this.f);
        jl0.c().c(new ey(true));
    }

    public /* synthetic */ void a(dz dzVar) {
        try {
            dzVar.a(this.b, he.k.h.b.a(vd.b.STARTED));
        } catch (CarNotConnectedException e) {
            e.printStackTrace();
        }
    }
}
