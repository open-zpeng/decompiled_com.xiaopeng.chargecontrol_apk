package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: m0  reason: default package */
/* loaded from: classes.dex */
public class m0 extends ArrayAdapter<CharSequence> {
    public final /* synthetic */ AlertController.RecycleListView c;
    public final /* synthetic */ AlertController.b d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m0(AlertController.b bVar, Context context, int i, int i2, CharSequence[] charSequenceArr, AlertController.RecycleListView recycleListView) {
        super(context, i, i2, charSequenceArr);
        this.d = bVar;
        this.c = recycleListView;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View view2 = super.getView(i, view, viewGroup);
        boolean[] zArr = this.d.F;
        if (zArr != null && zArr[i]) {
            this.c.setItemChecked(i, true);
        }
        return view2;
    }
}
