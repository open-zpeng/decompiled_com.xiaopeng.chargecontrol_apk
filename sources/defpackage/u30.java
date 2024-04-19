package defpackage;

import android.os.Bundle;
import com.xiaopeng.xui.widget.XNumberPicker;
import defpackage.fa0;
/* compiled from: ChargeAppointmentDialog.java */
/* renamed from: u30  reason: default package */
/* loaded from: classes.dex */
public class u30 extends m10 {
    public /* synthetic */ String j(int i) {
        return f(i == 1 ? r90.only_one : r90.everyday);
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        final t30 t30Var = new t30(s1());
        t30Var.c(f(r90.charge_appointment_set_time_dialog_title));
        int[] b = ((mz) x90.q()).b(new int[3]);
        int i = b[0];
        if (i != 2 && i != 1) {
            i = fa0.b.a.b();
        }
        t30Var.q.setFirstMinValue(1);
        t30Var.q.setFirstMaxValue(2);
        t30Var.q.setFirstFormatter(new XNumberPicker.c() { // from class: p30
            @Override // com.xiaopeng.xui.widget.XNumberPicker.c
            public final String a(int i2) {
                return u30.this.j(i2);
            }
        });
        t30Var.q.a(i, b[1], b[2]);
        String f = f(r90.confirm);
        md0 md0Var = new md0() { // from class: q30
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i2) {
                x90.a(r0.q.getFirst(), r0.q.getSecond(), t30.this.q.getThird());
            }
        };
        t30Var.b((CharSequence) f);
        t30Var.a(md0Var);
        t30Var.a(f(r90.cancel), (md0) null);
        return t30Var;
    }
}
