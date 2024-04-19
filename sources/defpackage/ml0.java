package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
/* compiled from: HandlerPoster.java */
/* renamed from: ml0  reason: default package */
/* loaded from: classes.dex */
public class ml0 extends Handler implements sl0 {
    public final rl0 c;
    public final int d;
    public final jl0 e;
    public boolean f;

    public ml0(jl0 jl0Var, Looper looper, int i) {
        super(looper);
        this.e = jl0Var;
        this.d = i;
        this.c = new rl0();
    }

    @Override // defpackage.sl0
    public void a(xl0 xl0Var, Object obj) {
        ql0 a = ql0.a(xl0Var, obj);
        synchronized (this) {
            this.c.a(a);
            if (!this.f) {
                this.f = true;
                if (!sendMessage(obtainMessage())) {
                    throw new ll0("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                ql0 a = this.c.a();
                if (a == null) {
                    synchronized (this) {
                        a = this.c.a();
                        if (a == null) {
                            this.f = false;
                            return;
                        }
                    }
                }
                this.e.a(a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.d);
            if (sendMessage(obtainMessage())) {
                this.f = true;
                return;
            }
            throw new ll0("Could not send handler message");
        } finally {
            this.f = false;
        }
    }
}
