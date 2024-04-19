package defpackage;

import android.os.Looper;
import defpackage.lx;
import java.util.concurrent.atomic.AtomicBoolean;
/* compiled from: MainThreadDisposable.java */
/* renamed from: gh0  reason: default package */
/* loaded from: classes.dex */
public abstract class gh0 implements kh0 {
    public final AtomicBoolean c = new AtomicBoolean();

    /* compiled from: MainThreadDisposable.java */
    /* renamed from: gh0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ((lx.a) gh0.this).d.setOnClickListener(null);
        }
    }

    @Override // defpackage.kh0
    public final void a() {
        if (this.c.compareAndSet(false, true)) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                ((lx.a) this).d.setOnClickListener(null);
            } else {
                hh0.a().a(new a());
            }
        }
    }

    @Override // defpackage.kh0
    public final boolean b() {
        return this.c.get();
    }
}
