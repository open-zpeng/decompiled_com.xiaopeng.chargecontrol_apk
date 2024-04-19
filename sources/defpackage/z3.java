package defpackage;

import android.view.View;
import android.widget.AdapterView;
/* compiled from: ListPopupWindow.java */
/* renamed from: z3  reason: default package */
/* loaded from: classes.dex */
public class z3 implements AdapterView.OnItemSelectedListener {
    public final /* synthetic */ a4 c;

    public z3(a4 a4Var) {
        this.c = a4Var;
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        u3 u3Var;
        if (i == -1 || (u3Var = this.c.e) == null) {
            return;
        }
        u3Var.setListSelectionHidden(false);
    }

    @Override // android.widget.AdapterView.OnItemSelectedListener
    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
