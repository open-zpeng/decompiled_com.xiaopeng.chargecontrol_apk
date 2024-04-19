package defpackage;

import android.os.Handler;
import defpackage.u8;
/* compiled from: CallbackWithHandler.java */
/* renamed from: q8  reason: default package */
/* loaded from: classes.dex */
public class q8 {
    public final x8 a;
    public final Handler b;

    public q8(x8 x8Var, Handler handler) {
        this.a = x8Var;
        this.b = handler;
    }

    public void a(u8.d dVar) {
        if (dVar.b == 0) {
            this.b.post(new o8(this, this.a, dVar.a));
            return;
        }
        this.b.post(new p8(this, this.a, dVar.b));
    }
}
