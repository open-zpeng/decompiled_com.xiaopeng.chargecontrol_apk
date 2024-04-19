package defpackage;

import defpackage.g6;
/* compiled from: DimensionDependency.java */
/* renamed from: h6  reason: default package */
/* loaded from: classes.dex */
public class h6 extends g6 {
    public int m;

    public h6(p6 p6Var) {
        super(p6Var);
        if (p6Var instanceof l6) {
            this.e = g6.a.HORIZONTAL_DIMENSION;
        } else {
            this.e = g6.a.VERTICAL_DIMENSION;
        }
    }

    @Override // defpackage.g6
    public void a(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        for (e6 e6Var : this.k) {
            e6Var.a(e6Var);
        }
    }
}
