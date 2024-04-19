package defpackage;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import defpackage.ie;
import defpackage.vd;
/* compiled from: ProcessLifecycleOwner.java */
/* renamed from: he  reason: default package */
/* loaded from: classes.dex */
public class he implements zd {
    public static final he k = new he();
    public Handler g;
    public int c = 0;
    public int d = 0;
    public boolean e = true;
    public boolean f = true;
    public final ae h = new ae(this);
    public Runnable i = new a();
    public ie.a j = new b();

    /* compiled from: ProcessLifecycleOwner.java */
    /* renamed from: he$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            he heVar = he.this;
            if (heVar.d == 0) {
                heVar.e = true;
                heVar.h.a(vd.a.ON_PAUSE);
            }
            he heVar2 = he.this;
            if (heVar2.c == 0 && heVar2.e) {
                heVar2.h.a(vd.a.ON_STOP);
                heVar2.f = true;
            }
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    /* renamed from: he$b */
    /* loaded from: classes.dex */
    public class b implements ie.a {
        public b() {
        }
    }

    /* compiled from: ProcessLifecycleOwner.java */
    /* renamed from: he$c */
    /* loaded from: classes.dex */
    public class c extends qd {

        /* compiled from: ProcessLifecycleOwner.java */
        /* renamed from: he$c$a */
        /* loaded from: classes.dex */
        public class a extends qd {
            public a() {
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostResumed(Activity activity) {
                he.this.a();
            }

            @Override // android.app.Application.ActivityLifecycleCallbacks
            public void onActivityPostStarted(Activity activity) {
                he.this.b();
            }
        }

        public c() {
        }

        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (Build.VERSION.SDK_INT < 29) {
                ie.a(activity).c = he.this.j;
            }
        }

        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            he heVar = he.this;
            heVar.d--;
            if (heVar.d == 0) {
                heVar.g.postDelayed(heVar.i, 700L);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPreCreated(Activity activity, Bundle bundle) {
            activity.registerActivityLifecycleCallbacks(new a());
        }

        @Override // defpackage.qd, android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            he heVar;
            heVar.c--;
            he.this.c();
        }
    }

    public void a() {
        this.d++;
        if (this.d == 1) {
            if (this.e) {
                this.h.a(vd.a.ON_RESUME);
                this.e = false;
                return;
            }
            this.g.removeCallbacks(this.i);
        }
    }

    public void b() {
        this.c++;
        if (this.c == 1 && this.f) {
            this.h.a(vd.a.ON_START);
            this.f = false;
        }
    }

    public void c() {
        if (this.c == 0 && this.e) {
            this.h.a(vd.a.ON_STOP);
            this.f = true;
        }
    }

    @Override // defpackage.zd
    public vd r() {
        return this.h;
    }

    public void a(Context context) {
        this.g = new Handler();
        this.h.a(vd.a.ON_CREATE);
        ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new c());
    }
}
