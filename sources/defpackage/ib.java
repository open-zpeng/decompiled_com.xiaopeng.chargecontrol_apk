package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
/* compiled from: ResourceCursorAdapter.java */
/* renamed from: ib  reason: default package */
/* loaded from: classes.dex */
public abstract class ib extends gb {
    public int k;
    public int l;
    public LayoutInflater m;

    @Deprecated
    public ib(Context context, int i, Cursor cursor, boolean z) {
        super(context, cursor, z);
        this.l = i;
        this.k = i;
        this.m = (LayoutInflater) context.getSystemService("layout_inflater");
    }

    @Override // defpackage.gb
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        return this.m.inflate(this.k, viewGroup, false);
    }
}
