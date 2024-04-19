package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: p0  reason: default package */
/* loaded from: classes.dex */
public class p0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController.RecycleListView c;
    public final /* synthetic */ AlertController d;
    public final /* synthetic */ AlertController.b e;

    public p0(AlertController.b bVar, AlertController.RecycleListView recycleListView, AlertController alertController) {
        this.e = bVar;
        this.c = recycleListView;
        this.d = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        boolean[] zArr = this.e.F;
        if (zArr != null) {
            zArr[i] = this.c.isItemChecked(i);
        }
        this.e.J.onClick(this.d.b, i, this.c.isItemChecked(i));
    }
}
