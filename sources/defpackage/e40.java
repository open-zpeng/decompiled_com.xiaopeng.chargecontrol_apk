package defpackage;
/* compiled from: DischargePowerChart.java */
/* renamed from: e40  reason: default package */
/* loaded from: classes.dex */
public class e40 extends fs {
    public final /* synthetic */ f40 a;

    public e40(f40 f40Var) {
        this.a = f40Var;
    }

    @Override // defpackage.fs
    public String a(float f, fr frVar) {
        f40 f40Var = this.a;
        int i = f40Var.E;
        return Integer.toString((i * ((f40Var.F - 1) - ((((int) f) - 20) / i))) + 20);
    }
}
