package defpackage;
/* compiled from: CallbackWithHandler.java */
/* renamed from: p8  reason: default package */
/* loaded from: classes.dex */
public class p8 implements Runnable {
    public final /* synthetic */ x8 c;
    public final /* synthetic */ int d;

    public p8(q8 q8Var, x8 x8Var, int i) {
        this.c = x8Var;
        this.d = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.a(this.d);
    }
}
