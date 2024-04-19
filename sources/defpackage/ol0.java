package defpackage;

import android.os.Looper;
/* compiled from: MainThreadSupport.java */
/* renamed from: ol0  reason: default package */
/* loaded from: classes.dex */
public interface ol0 {

    /* compiled from: MainThreadSupport.java */
    /* renamed from: ol0$a */
    /* loaded from: classes.dex */
    public static class a implements ol0 {
        public final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        public sl0 a(jl0 jl0Var) {
            return new ml0(jl0Var, this.a, 10);
        }
    }
}
