package defpackage;
/* compiled from: ObservableEmpty.java */
/* renamed from: wi0  reason: default package */
/* loaded from: classes.dex */
public final class wi0 extends ah0<Object> implements ei0<Object> {
    public static final ah0<Object> c = new wi0();

    @Override // defpackage.ah0
    public void b(ch0<? super Object> ch0Var) {
        ch0Var.onSubscribe(wh0.INSTANCE);
        ch0Var.onComplete();
    }

    @Override // defpackage.ei0, java.util.concurrent.Callable
    public Object call() {
        return null;
    }
}
