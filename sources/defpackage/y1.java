package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import defpackage.h2;
import java.util.ArrayList;
/* compiled from: MenuAdapter.java */
/* renamed from: y1  reason: default package */
/* loaded from: classes.dex */
public class y1 extends BaseAdapter {
    public z1 c;
    public int d = -1;
    public boolean e;
    public final boolean f;
    public final LayoutInflater g;
    public final int h;

    public y1(z1 z1Var, LayoutInflater layoutInflater, boolean z, int i) {
        this.f = z;
        this.g = layoutInflater;
        this.c = z1Var;
        this.h = i;
        a();
    }

    public void a() {
        z1 z1Var = this.c;
        c2 c2Var = z1Var.x;
        if (c2Var != null) {
            z1Var.a();
            ArrayList<c2> arrayList = z1Var.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (arrayList.get(i) == c2Var) {
                    this.d = i;
                    return;
                }
            }
        }
        this.d = -1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<c2> d;
        if (this.f) {
            z1 z1Var = this.c;
            z1Var.a();
            d = z1Var.j;
        } else {
            d = this.c.d();
        }
        if (this.d < 0) {
            return d.size();
        }
        return d.size() - 1;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.g.inflate(this.h, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        listMenuItemView.setGroupDividerEnabled(this.c.e() && i2 != (i3 >= 0 ? getItem(i3).b : i2));
        h2.a aVar = (h2.a) view;
        if (this.e) {
            listMenuItemView.setForceShowIcon(true);
        }
        aVar.a(getItem(i), 0);
        return view;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public c2 getItem(int i) {
        ArrayList<c2> d;
        if (this.f) {
            z1 z1Var = this.c;
            z1Var.a();
            d = z1Var.j;
        } else {
            d = this.c.d();
        }
        int i2 = this.d;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return d.get(i);
    }
}
