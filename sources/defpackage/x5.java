package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
/* compiled from: HelperWidget.java */
/* renamed from: x5  reason: default package */
/* loaded from: classes.dex */
public class x5 extends t5 implements w5 {
    public t5[] u0 = new t5[4];
    public int v0 = 0;

    public void a(t5 t5Var) {
        if (t5Var == this || t5Var == null) {
            return;
        }
        int i = this.v0 + 1;
        t5[] t5VarArr = this.u0;
        if (i > t5VarArr.length) {
            this.u0 = (t5[]) Arrays.copyOf(t5VarArr, t5VarArr.length * 2);
        }
        t5[] t5VarArr2 = this.u0;
        int i2 = this.v0;
        t5VarArr2[i2] = t5Var;
        this.v0 = i2 + 1;
    }

    @Override // defpackage.w5
    public void a(u5 u5Var) {
    }

    public void a(ArrayList<o6> arrayList, int i, o6 o6Var) {
        for (int i2 = 0; i2 < this.v0; i2++) {
            o6Var.a(this.u0[i2]);
        }
        for (int i3 = 0; i3 < this.v0; i3++) {
            a.a(this.u0[i3], i, arrayList, o6Var);
        }
    }
}
