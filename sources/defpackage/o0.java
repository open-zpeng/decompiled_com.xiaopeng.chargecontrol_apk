package defpackage;

import android.view.View;
import android.widget.AdapterView;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: o0  reason: default package */
/* loaded from: classes.dex */
public class o0 implements AdapterView.OnItemClickListener {
    public final /* synthetic */ AlertController c;
    public final /* synthetic */ AlertController.b d;

    public o0(AlertController.b bVar, AlertController alertController) {
        this.d = bVar;
        this.c = alertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.d.x.onClick(this.c.b, i);
        if (this.d.H) {
            return;
        }
        this.c.b.dismiss();
    }
}
