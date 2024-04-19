package defpackage;

import android.os.Looper;
import android.view.View;
/* compiled from: ViewClickObservable.java */
/* renamed from: lx  reason: default package */
/* loaded from: classes.dex */
public final class lx extends ah0<Object> {
    public final View c;

    /* compiled from: ViewClickObservable.java */
    /* renamed from: lx$a */
    /* loaded from: classes.dex */
    public static final class a extends gh0 implements View.OnClickListener {
        public final View d;
        public final ch0<? super Object> e;

        public a(View view, ch0<? super Object> ch0Var) {
            this.d = view;
            this.e = ch0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (b()) {
                return;
            }
            this.e.onNext(kx.INSTANCE);
        }
    }

    public lx(View view) {
        this.c = view;
    }

    @Override // defpackage.ah0
    public void b(ch0<? super Object> ch0Var) {
        boolean z;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            ch0Var.onSubscribe(z90.a());
            StringBuilder a2 = jg.a("Expected to be called on the main thread but was ");
            a2.append(Thread.currentThread().getName());
            ch0Var.onError(new IllegalStateException(a2.toString()));
            z = false;
        } else {
            z = true;
        }
        if (z) {
            a aVar = new a(this.c, ch0Var);
            ch0Var.onSubscribe(aVar);
            this.c.setOnClickListener(aVar);
        }
    }
}
