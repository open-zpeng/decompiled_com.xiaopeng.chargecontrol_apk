package defpackage;

import android.os.Bundle;
import com.xiaopeng.xui.widget.XNumberPicker;
import defpackage.fa0;
/* compiled from: KeepTempAppointmentDialog.java */
/* renamed from: v30  reason: default package */
/* loaded from: classes.dex */
public class v30 extends m10 {
    public /* synthetic */ String j(int i) {
        return f(i == 1 ? r90.only_one : r90.everyday);
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        final t30 t30Var = new t30(s1());
        t30Var.c(f(r90.keep_temp_set_time_dialog_title));
        int[] a = ((mz) x90.q()).a(new int[3]);
        int i = a[0];
        if (i != 1 && i != 2) {
            i = fa0.b.a.d();
        }
        t30Var.q.setFirstMinValue(1);
        t30Var.q.setFirstMaxValue(2);
        t30Var.q.setFirstFormatter(new XNumberPicker.c() { // from class: r30
            @Override // com.xiaopeng.xui.widget.XNumberPicker.c
            public final String a(int i2) {
                return v30.this.j(i2);
            }
        });
        t30Var.q.a(i, a[1], a[2]);
        String f = f(r90.confirm);
        md0 md0Var = new md0() { // from class: s30
            @Override // defpackage.md0
            public final void a(ld0 ld0Var, int i2) {
                x90.b(r0.q.getFirst(), r0.q.getSecond(), t30.this.q.getThird());
            }
        };
        t30Var.b((CharSequence) f);
        t30Var.a(md0Var);
        t30Var.a(f(r90.cancel), (md0) null);
        return t30Var;
    }
}
