package defpackage;
/* compiled from: Gson.java */
/* renamed from: iu  reason: default package */
/* loaded from: classes.dex */
public class iu extends bv<Number> {
    @Override // defpackage.bv
    public Number read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        return Long.valueOf(gxVar.n());
    }

    @Override // defpackage.bv
    public void write(ix ixVar, Number number) {
        Number number2 = number;
        if (number2 == null) {
            ixVar.g();
        } else {
            ixVar.c(number2.toString());
        }
    }
}
