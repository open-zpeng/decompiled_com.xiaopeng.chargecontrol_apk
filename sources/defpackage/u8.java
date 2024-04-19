package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: FontRequestWorker.java */
/* renamed from: u8  reason: default package */
/* loaded from: classes.dex */
public class u8 {
    public static final d5<String, Typeface> a = new d5<>(16);
    public static final ExecutorService b;
    public static final Object c;
    public static final f5<String, ArrayList<b9<d>>> d;

    /* compiled from: FontRequestWorker.java */
    /* renamed from: u8$a */
    /* loaded from: classes.dex */
    public class a implements b9<d> {
        public final /* synthetic */ q8 a;

        public a(q8 q8Var) {
            this.a = q8Var;
        }

        @Override // defpackage.b9
        public void accept(d dVar) {
            this.a.a(dVar);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: u8$b */
    /* loaded from: classes.dex */
    public class b implements Callable<d> {
        public final /* synthetic */ String c;
        public final /* synthetic */ Context d;
        public final /* synthetic */ s8 e;
        public final /* synthetic */ int f;

        public b(String str, Context context, s8 s8Var, int i) {
            this.c = str;
            this.d = context;
            this.e = s8Var;
            this.f = i;
        }

        @Override // java.util.concurrent.Callable
        public d call() {
            return u8.a(this.c, this.d, this.e, this.f);
        }
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: u8$c */
    /* loaded from: classes.dex */
    public class c implements b9<d> {
        public final /* synthetic */ String a;

        public c(String str) {
            this.a = str;
        }

        @Override // defpackage.b9
        /* renamed from: a */
        public void accept(d dVar) {
            synchronized (u8.c) {
                ArrayList<b9<d>> arrayList = u8.d.get(this.a);
                if (arrayList == null) {
                    return;
                }
                u8.d.remove(this.a);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).accept(dVar);
                }
            }
        }
    }

    static {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), new y8("fonts-androidx", 10));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        b = threadPoolExecutor;
        c = new Object();
        d = new f5<>();
    }

    public static String a(s8 s8Var, int i) {
        return s8Var.f + "-" + i;
    }

    /* compiled from: FontRequestWorker.java */
    /* renamed from: u8$d */
    /* loaded from: classes.dex */
    public static final class d {
        public final Typeface a;
        public final int b;

        public d(int i) {
            this.a = null;
            this.b = i;
        }

        @SuppressLint({"WrongConstant"})
        public d(Typeface typeface) {
            this.a = typeface;
            this.b = 0;
        }
    }

    public static Typeface a(Context context, s8 s8Var, int i, Executor executor, q8 q8Var) {
        Handler handler;
        String str = s8Var.f + "-" + i;
        Typeface a2 = a.a((d5<String, Typeface>) str);
        if (a2 != null) {
            q8Var.a(new d(a2));
            return a2;
        }
        a aVar = new a(q8Var);
        synchronized (c) {
            ArrayList<b9<d>> orDefault = d.getOrDefault(str, null);
            if (orDefault != null) {
                orDefault.add(aVar);
                return null;
            }
            ArrayList<b9<d>> arrayList = new ArrayList<>();
            arrayList.add(aVar);
            d.put(str, arrayList);
            b bVar = new b(str, context, s8Var, i);
            if (executor == null) {
                executor = b;
            }
            c cVar = new c(str);
            if (Looper.myLooper() == null) {
                handler = new Handler(Looper.getMainLooper());
            } else {
                handler = new Handler();
            }
            executor.execute(new z8(handler, bVar, cVar));
            return null;
        }
    }

    public static d a(String str, Context context, s8 s8Var, int i) {
        int i2;
        Typeface a2 = a.a((d5<String, Typeface>) str);
        if (a2 != null) {
            return new d(a2);
        }
        try {
            v8 a3 = r8.a(context, s8Var, null);
            int i3 = a3.a;
            int i4 = 1;
            if (i3 != 0) {
                i2 = i3 != 1 ? -3 : -2;
            } else {
                w8[] w8VarArr = a3.b;
                if (w8VarArr != null && w8VarArr.length != 0) {
                    for (w8 w8Var : w8VarArr) {
                        int i5 = w8Var.e;
                        if (i5 != 0) {
                            if (i5 < 0) {
                                i5 = -3;
                            }
                            i2 = i5;
                        }
                    }
                    i4 = 0;
                }
                i2 = i4;
            }
            if (i2 != 0) {
                return new d(i2);
            }
            Typeface a4 = y7.a.a(context, (CancellationSignal) null, a3.b, i);
            if (a4 != null) {
                a.a(str, a4);
                return new d(a4);
            }
            return new d(-3);
        } catch (PackageManager.NameNotFoundException unused) {
            return new d(-1);
        }
    }
}
