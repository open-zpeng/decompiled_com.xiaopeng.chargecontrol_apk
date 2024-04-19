package defpackage;

import android.database.Cursor;
import android.widget.Filter;
/* compiled from: CursorFilter.java */
/* renamed from: hb  reason: default package */
/* loaded from: classes.dex */
public class hb extends Filter {
    public a a;

    /* compiled from: CursorFilter.java */
    /* renamed from: hb$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    public hb(a aVar) {
        this.a = aVar;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return ((h4) this.a).b((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor a2 = ((h4) this.a).a(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (a2 != null) {
            filterResults.count = a2.getCount();
            filterResults.values = a2;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        a aVar = this.a;
        Cursor cursor = ((gb) aVar).e;
        Object obj = filterResults.values;
        if (obj == null || obj == cursor) {
            return;
        }
        ((h4) aVar).a((Cursor) obj);
    }
}
