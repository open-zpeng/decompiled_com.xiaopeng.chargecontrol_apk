package defpackage;
/* compiled from: Gson.java */
/* renamed from: gu  reason: default package */
/* loaded from: classes.dex */
public class gu extends bv<Number> {
    public gu(lu luVar) {
    }

    @Override // defpackage.bv
    public Number read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        return Double.valueOf(gxVar.l());
    }

    @Override // defpackage.bv
    public void write(ix ixVar, Number number) {
        Number number2 = number;
        if (number2 == null) {
            ixVar.g();
            return;
        }
        lu.a(number2.doubleValue());
        ixVar.a(number2);
    }
}
