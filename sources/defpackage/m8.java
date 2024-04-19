package defpackage;

import android.os.Build;
import android.os.CancellationSignal;
/* compiled from: CancellationSignal.java */
/* renamed from: m8  reason: default package */
/* loaded from: classes.dex */
public final class m8 {
    public boolean a;
    public a b;
    public Object c;
    public boolean d;

    /* compiled from: CancellationSignal.java */
    /* renamed from: m8$a */
    /* loaded from: classes.dex */
    public interface a {
        void a();
    }

    public void a() {
        synchronized (this) {
            if (this.a) {
                return;
            }
            this.a = true;
            this.d = true;
            a aVar = this.b;
            Object obj = this.c;
            if (aVar != null) {
                try {
                    aVar.a();
                } catch (Throwable th) {
                    synchronized (this) {
                        this.d = false;
                        notifyAll();
                        throw th;
                    }
                }
            }
            if (obj != null) {
                int i = Build.VERSION.SDK_INT;
                ((CancellationSignal) obj).cancel();
            }
            synchronized (this) {
                this.d = false;
                notifyAll();
            }
        }
    }

    public boolean b() {
        boolean z;
        synchronized (this) {
            z = this.a;
        }
        return z;
    }

    public void a(a aVar) {
        synchronized (this) {
            while (this.d) {
                try {
                    wait();
                } catch (InterruptedException unused) {
                }
            }
            if (this.b == aVar) {
                return;
            }
            this.b = aVar;
            if (this.a && aVar != null) {
                aVar.a();
            }
        }
    }
}
