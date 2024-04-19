package defpackage;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import defpackage.dh0;
import java.util.concurrent.TimeUnit;
/* compiled from: HandlerScheduler.java */
/* renamed from: ih0  reason: default package */
/* loaded from: classes.dex */
public final class ih0 extends dh0 {
    public final Handler b;
    public final boolean c;

    /* compiled from: HandlerScheduler.java */
    /* renamed from: ih0$b */
    /* loaded from: classes.dex */
    public static final class b implements Runnable, kh0 {
        public final Handler c;
        public final Runnable d;
        public volatile boolean e;

        public b(Handler handler, Runnable runnable) {
            this.c = handler;
            this.d = runnable;
        }

        @Override // defpackage.kh0
        public void a() {
            this.c.removeCallbacks(this);
            this.e = true;
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.e;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.d.run();
            } catch (Throwable th) {
                z90.a(th);
            }
        }
    }

    public ih0(Handler handler, boolean z) {
        this.b = handler;
        this.c = z;
    }

    @Override // defpackage.dh0
    @SuppressLint({"NewApi"})
    public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable != null) {
            if (timeUnit != null) {
                b bVar = new b(this.b, z90.a(runnable));
                Message obtain = Message.obtain(this.b, bVar);
                if (this.c) {
                    obtain.setAsynchronous(true);
                }
                this.b.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                return bVar;
            }
            throw new NullPointerException("unit == null");
        }
        throw new NullPointerException("run == null");
    }

    @Override // defpackage.dh0
    public dh0.c a() {
        return new a(this.b, this.c);
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: ih0$a */
    /* loaded from: classes.dex */
    public static final class a extends dh0.c {
        public final Handler c;
        public final boolean d;
        public volatile boolean e;

        public a(Handler handler, boolean z) {
            this.c = handler;
            this.d = z;
        }

        @Override // defpackage.dh0.c
        @SuppressLint({"NewApi"})
        public kh0 a(Runnable runnable, long j, TimeUnit timeUnit) {
            if (runnable != null) {
                if (timeUnit != null) {
                    if (this.e) {
                        return wh0.INSTANCE;
                    }
                    b bVar = new b(this.c, z90.a(runnable));
                    Message obtain = Message.obtain(this.c, bVar);
                    obtain.obj = this;
                    if (this.d) {
                        obtain.setAsynchronous(true);
                    }
                    this.c.sendMessageDelayed(obtain, timeUnit.toMillis(j));
                    if (this.e) {
                        this.c.removeCallbacks(bVar);
                        return wh0.INSTANCE;
                    }
                    return bVar;
                }
                throw new NullPointerException("unit == null");
            }
            throw new NullPointerException("run == null");
        }

        @Override // defpackage.kh0
        public boolean b() {
            return this.e;
        }

        @Override // defpackage.kh0
        public void a() {
            this.e = true;
            this.c.removeCallbacksAndMessages(this);
        }
    }
}
