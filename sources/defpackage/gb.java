package defpackage;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import defpackage.hb;
/* compiled from: CursorAdapter.java */
/* renamed from: gb  reason: default package */
/* loaded from: classes.dex */
public abstract class gb extends BaseAdapter implements Filterable, hb.a {
    public boolean c;
    public boolean d;
    public Cursor e;
    public Context f;
    public int g;
    public a h;
    public DataSetObserver i;
    public hb j;

    /* compiled from: CursorAdapter.java */
    /* renamed from: gb$a */
    /* loaded from: classes.dex */
    public class a extends ContentObserver {
        public a() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            Cursor cursor;
            gb gbVar = gb.this;
            if (!gbVar.d || (cursor = gbVar.e) == null || cursor.isClosed()) {
                return;
            }
            gbVar.c = gbVar.e.requery();
        }
    }

    /* compiled from: CursorAdapter.java */
    /* renamed from: gb$b */
    /* loaded from: classes.dex */
    public class b extends DataSetObserver {
        public b() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            gb gbVar = gb.this;
            gbVar.c = true;
            gbVar.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            gb gbVar = gb.this;
            gbVar.c = false;
            gbVar.notifyDataSetInvalidated();
        }
    }

    public gb(Context context, Cursor cursor, boolean z) {
        boolean z2 = z ? true : true;
        if (z2 & true) {
            z2 |= true;
            this.d = true;
        } else {
            this.d = false;
        }
        boolean z3 = cursor != null;
        this.e = cursor;
        this.c = z3;
        this.f = context;
        this.g = z3 ? cursor.getColumnIndexOrThrow("_id") : -1;
        if (z2 & true) {
            this.h = new a();
            this.i = new b();
        } else {
            this.h = null;
            this.i = null;
        }
        if (z3) {
            a aVar = this.h;
            if (aVar != null) {
                cursor.registerContentObserver(aVar);
            }
            DataSetObserver dataSetObserver = this.i;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    public abstract View a(Context context, Cursor cursor, ViewGroup viewGroup);

    public void a(Cursor cursor) {
        Cursor cursor2 = this.e;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.h;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                DataSetObserver dataSetObserver = this.i;
                if (dataSetObserver != null) {
                    cursor2.unregisterDataSetObserver(dataSetObserver);
                }
            }
            this.e = cursor;
            if (cursor != null) {
                a aVar2 = this.h;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                DataSetObserver dataSetObserver2 = this.i;
                if (dataSetObserver2 != null) {
                    cursor.registerDataSetObserver(dataSetObserver2);
                }
                this.g = cursor.getColumnIndexOrThrow("_id");
                this.c = true;
                notifyDataSetChanged();
            } else {
                this.g = -1;
                this.c = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract void a(View view, Context context, Cursor cursor);

    public abstract CharSequence b(Cursor cursor);

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.c || (cursor = this.e) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (this.c) {
            this.e.moveToPosition(i);
            if (view == null) {
                ib ibVar = (ib) this;
                view = ibVar.m.inflate(ibVar.l, viewGroup, false);
            }
            a(view, this.f, this.e);
            return view;
        }
        return null;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.j == null) {
            this.j = new hb(this);
        }
        return this.j;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.c || (cursor = this.e) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.e;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.c && (cursor = this.e) != null && cursor.moveToPosition(i)) {
            return this.e.getLong(this.g);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (this.c) {
            if (this.e.moveToPosition(i)) {
                if (view == null) {
                    view = a(this.f, this.e, viewGroup);
                }
                a(view, this.f, this.e);
                return view;
            }
            throw new IllegalStateException(jg.a("couldn't move cursor to position ", i));
        }
        throw new IllegalStateException("this should only be called when the cursor is valid");
    }
}
