package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import androidx.appcompat.app.AlertController;
/* compiled from: AlertController.java */
/* renamed from: n0  reason: default package */
/* loaded from: classes.dex */
public class n0 extends CursorAdapter {
    public final int c;
    public final int d;
    public final /* synthetic */ AlertController.RecycleListView e;
    public final /* synthetic */ AlertController f;
    public final /* synthetic */ AlertController.b g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n0(AlertController.b bVar, Context context, Cursor cursor, boolean z, AlertController.RecycleListView recycleListView, AlertController alertController) {
        super(context, cursor, z);
        this.g = bVar;
        this.e = recycleListView;
        this.f = alertController;
        Cursor cursor2 = getCursor();
        this.c = cursor2.getColumnIndexOrThrow(this.g.L);
        this.d = cursor2.getColumnIndexOrThrow(this.g.M);
    }

    @Override // android.widget.CursorAdapter
    public void bindView(View view, Context context, Cursor cursor) {
        ((CheckedTextView) view.findViewById(16908308)).setText(cursor.getString(this.c));
        this.e.setItemChecked(cursor.getPosition(), cursor.getInt(this.d) == 1);
    }

    @Override // android.widget.CursorAdapter
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.g.b.inflate(this.f.M, viewGroup, false);
    }
}
