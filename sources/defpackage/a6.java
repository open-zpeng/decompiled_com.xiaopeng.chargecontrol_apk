package defpackage;

import java.util.ArrayList;
/* compiled from: WidgetContainer.java */
/* renamed from: a6  reason: default package */
/* loaded from: classes.dex */
public class a6 extends t5 {
    public ArrayList<t5> u0 = new ArrayList<>();

    @Override // defpackage.t5
    public void a(j5 j5Var) {
        super.a(j5Var);
        int size = this.u0.size();
        for (int i = 0; i < size; i++) {
            this.u0.get(i).a(j5Var);
        }
    }

    @Override // defpackage.t5
    public void q() {
        this.u0.clear();
        super.q();
    }

    public void s() {
        ArrayList<t5> arrayList = this.u0;
        if (arrayList == null) {
            return;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            t5 t5Var = this.u0.get(i);
            if (t5Var instanceof a6) {
                ((a6) t5Var).s();
            }
        }
    }
}
