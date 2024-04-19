package defpackage;

import android.app.SearchableInfo;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.xiaopeng.lib.apirouter.ClientConstants;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;
/* compiled from: SuggestionsAdapter.java */
/* renamed from: h4  reason: default package */
/* loaded from: classes.dex */
public class h4 extends ib implements View.OnClickListener {
    public int A;
    public final SearchView n;
    public final SearchableInfo o;
    public final Context p;
    public final WeakHashMap<String, Drawable.ConstantState> q;
    public final int r;
    public boolean s;
    public int t;
    public ColorStateList u;
    public int v;
    public int w;
    public int x;
    public int y;
    public int z;

    /* compiled from: SuggestionsAdapter.java */
    /* renamed from: h4$a */
    /* loaded from: classes.dex */
    public static final class a {
        public final TextView a;
        public final TextView b;
        public final ImageView c;
        public final ImageView d;
        public final ImageView e;

        public a(View view) {
            this.a = (TextView) view.findViewById(16908308);
            this.b = (TextView) view.findViewById(16908309);
            this.c = (ImageView) view.findViewById(16908295);
            this.d = (ImageView) view.findViewById(16908296);
            this.e = (ImageView) view.findViewById(e0.edit_query);
        }
    }

    public h4(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.s = false;
        this.t = 1;
        this.v = -1;
        this.w = -1;
        this.x = -1;
        this.y = -1;
        this.z = -1;
        this.A = -1;
        this.n = searchView;
        this.o = searchableInfo;
        this.r = searchView.getSuggestionCommitIconResId();
        this.p = context;
        this.q = weakHashMap;
    }

    public void a(int i) {
        this.t = i;
    }

    @Override // defpackage.gb
    public CharSequence b(Cursor cursor) {
        String a2;
        String a3;
        if (cursor == null) {
            return null;
        }
        String a4 = a(cursor, cursor.getColumnIndex("suggest_intent_query"));
        if (a4 != null) {
            return a4;
        }
        if (!this.o.shouldRewriteQueryFromData() || (a3 = a(cursor, cursor.getColumnIndex("suggest_intent_data"))) == null) {
            if (!this.o.shouldRewriteQueryFromText() || (a2 = a(cursor, cursor.getColumnIndex("suggest_text_1"))) == null) {
                return null;
            }
            return a2;
        }
        return a3;
    }

    public final void c(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    @Override // defpackage.gb, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View inflate = this.m.inflate(this.l, viewGroup, false);
            if (inflate != null) {
                ((a) inflate.getTag()).a.setText(e.toString());
            }
            return inflate;
        }
    }

    @Override // defpackage.gb, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a2 = a(this.p, this.e, viewGroup);
            if (a2 != null) {
                ((a) a2.getTag()).a.setText(e.toString());
            }
            return a2;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        c(this.e);
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        c(this.e);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.n.a((CharSequence) tag);
        }
    }

    public Cursor a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.n.getVisibility() == 0 && this.n.getWindowVisibility() == 0) {
            try {
                Cursor a2 = a(this.o, charSequence2, 50);
                if (a2 != null) {
                    a2.getCount();
                    return a2;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // defpackage.gb
    public void a(Cursor cursor) {
        if (this.s) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.a(cursor);
            if (cursor != null) {
                this.v = cursor.getColumnIndex("suggest_text_1");
                this.w = cursor.getColumnIndex("suggest_text_2");
                this.x = cursor.getColumnIndex("suggest_text_2_url");
                this.y = cursor.getColumnIndex("suggest_icon_1");
                this.z = cursor.getColumnIndex("suggest_icon_2");
                this.A = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    @Override // defpackage.ib, defpackage.gb
    public View a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a2 = super.a(context, cursor, viewGroup);
        a2.setTag(new a(a2));
        ((ImageView) a2.findViewById(e0.edit_query)).setImageResource(this.r);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:59:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0151  */
    @Override // defpackage.gb
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(android.view.View r19, android.content.Context r20, android.database.Cursor r21) {
        /*
            Method dump skipped, instructions count: 456
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h4.a(android.view.View, android.content.Context, android.database.Cursor):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.drawable.Drawable a(java.lang.String r8) {
        /*
            Method dump skipped, instructions count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h4.a(java.lang.String):android.graphics.drawable.Drawable");
    }

    public static String a(Cursor cursor, String str) {
        return a(cursor, cursor.getColumnIndex(str));
    }

    public static String a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public Drawable a(Uri uri) {
        int parseInt;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.p.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            parseInt = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException(jg.a("Single path segment is not a resource ID: ", uri));
                        }
                    } else if (size == 2) {
                        parseInt = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException(jg.a("More than two path segments: ", uri));
                    }
                    if (parseInt != 0) {
                        return resourcesForApplication.getDrawable(parseInt);
                    }
                    throw new FileNotFoundException(jg.a("No resource found for: ", uri));
                }
                throw new FileNotFoundException(jg.a("No path: ", uri));
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException(jg.a("No package found for authority: ", uri));
            }
        }
        throw new FileNotFoundException(jg.a("No authority: ", uri));
    }

    public Cursor a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(ClientConstants.BINDER.SCHEME).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.p.getContentResolver().query(fragment.build(), null, suggestSelection, strArr2, null);
    }
}
