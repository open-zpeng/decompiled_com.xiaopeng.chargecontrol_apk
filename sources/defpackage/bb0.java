package defpackage;

import android.os.RemoteException;
import defpackage.eb0;
/* compiled from: DataCollectorHelper.java */
/* renamed from: bb0  reason: default package */
/* loaded from: classes.dex */
public class bb0 implements Runnable {
    public final /* synthetic */ String c;
    public final /* synthetic */ ya0 d;

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: bb0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bb0 bb0Var = bb0.this;
            ya0 ya0Var = bb0Var.d;
            String str = bb0Var.c;
            eb0 eb0Var = ya0Var.a;
            if (eb0Var != null) {
                try {
                    ((eb0.a.C0005a) eb0Var).c(str);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public bb0(ya0 ya0Var, String str) {
        this.d = ya0Var;
        this.c = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.d.e()) {
            ya0 ya0Var = this.d;
            String str = this.c;
            eb0 eb0Var = ya0Var.a;
            if (eb0Var != null) {
                try {
                    ((eb0.a.C0005a) eb0Var).c(str);
                    return;
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return;
                }
            }
            return;
        }
        jb0.a(0, null, new a(), null, false, 1000L);
    }
}
