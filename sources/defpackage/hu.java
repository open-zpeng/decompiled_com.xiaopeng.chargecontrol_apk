package defpackage;
/* compiled from: Gson.java */
/* renamed from: hu  reason: default package */
/* loaded from: classes.dex */
public class hu extends bv<Number> {
    public hu(lu luVar) {
    }

    @Override // defpackage.bv
    public Number read(gx gxVar) {
        if (gxVar.s() == hx.NULL) {
            gxVar.p();
            return null;
        }
        return Float.valueOf((float) gxVar.l());
    }

    @Override // defpackage.bv
    public void write(ix ixVar, Number number) {
        Number number2 = number;
        if (number2 == null) {
            ixVar.g();
            return;
        }
        lu.a(number2.floatValue());
        ixVar.a(number2);
    }
}
