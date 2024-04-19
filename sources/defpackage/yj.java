package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
/* compiled from: ResourceRecycler.java */
/* renamed from: yj  reason: default package */
/* loaded from: classes.dex */
public class yj {
    public boolean a;
    public final Handler b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    /* renamed from: yj$a */
    /* loaded from: classes.dex */
    public static final class a implements Handler.Callback {
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                ((vj) message.obj).d();
                return true;
            }
            return false;
        }
    }

    public synchronized void a(vj<?> vjVar, boolean z) {
        if (!this.a && !z) {
            this.a = true;
            vjVar.d();
            this.a = false;
        }
        this.b.obtainMessage(1, vjVar).sendToTarget();
    }
}
