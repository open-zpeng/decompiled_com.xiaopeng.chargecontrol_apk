package defpackage;

import android.content.Context;
import android.graphics.Rect;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
/* compiled from: MenuPopup.java */
/* renamed from: e2  reason: default package */
/* loaded from: classes.dex */
public abstract class e2 implements j2, g2, AdapterView.OnItemClickListener {
    public Rect c;

    public static int a(ListAdapter listAdapter, ViewGroup viewGroup, Context context, int i) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        ViewGroup viewGroup2 = viewGroup;
        int i2 = 0;
        int i3 = 0;
        View view = null;
        for (int i4 = 0; i4 < count; i4++) {
            int itemViewType = listAdapter.getItemViewType(i4);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            if (viewGroup2 == null) {
                viewGroup2 = new FrameLayout(context);
            }
            view = listAdapter.getView(i4, view, viewGroup2);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            int measuredWidth = view.getMeasuredWidth();
            if (measuredWidth >= i) {
                return i;
            }
            if (measuredWidth > i2) {
                i2 = measuredWidth;
            }
        }
        return i2;
    }

    public static boolean b(z1 z1Var) {
        int size = z1Var.size();
        for (int i = 0; i < size; i++) {
            MenuItem item = z1Var.getItem(i);
            if (item.isVisible() && item.getIcon() != null) {
                return true;
            }
        }
        return false;
    }

    public abstract void a(int i);

    @Override // defpackage.g2
    public void a(Context context, z1 z1Var) {
    }

    public abstract void a(View view);

    public abstract void a(PopupWindow.OnDismissListener onDismissListener);

    public abstract void a(z1 z1Var);

    @Override // defpackage.g2
    public boolean a(z1 z1Var, c2 c2Var) {
        return false;
    }

    public abstract void b(int i);

    public abstract void b(boolean z);

    @Override // defpackage.g2
    public boolean b(z1 z1Var, c2 c2Var) {
        return false;
    }

    public abstract void c(int i);

    public abstract void c(boolean z);

    public boolean d() {
        return true;
    }

    public Rect f() {
        return this.c;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        y1 y1Var;
        ListAdapter listAdapter = (ListAdapter) adapterView.getAdapter();
        if (listAdapter instanceof HeaderViewListAdapter) {
            y1Var = (y1) ((HeaderViewListAdapter) listAdapter).getWrappedAdapter();
        } else {
            y1Var = (y1) listAdapter;
        }
        y1Var.c.a((MenuItem) listAdapter.getItem(i), this, d() ? 0 : 4);
    }
}
