package defpackage;

import java.util.concurrent.atomic.AtomicReference;
/* compiled from: SequentialDisposable.java */
/* renamed from: yh0  reason: default package */
/* loaded from: classes.dex */
public final class yh0 extends AtomicReference<kh0> implements kh0 {
    public yh0() {
    }

    public boolean a(kh0 kh0Var) {
        return vh0.a((AtomicReference<kh0>) this, kh0Var);
    }

    @Override // defpackage.kh0
    public boolean b() {
        return vh0.a(get());
    }

    public yh0(kh0 kh0Var) {
        lazySet(kh0Var);
    }

    @Override // defpackage.kh0
    public void a() {
        vh0.a((AtomicReference<kh0>) this);
    }
}
