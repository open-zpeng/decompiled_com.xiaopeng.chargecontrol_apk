package defpackage;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.app.AlertController;
import androidx.appcompat.view.menu.ExpandedMenuView;
import defpackage.g2;
import defpackage.h2;
import defpackage.q0;
import java.util.ArrayList;
/* compiled from: ListMenuPresenter.java */
/* renamed from: x1  reason: default package */
/* loaded from: classes.dex */
public class x1 implements g2, AdapterView.OnItemClickListener {
    public Context c;
    public LayoutInflater d;
    public z1 e;
    public ExpandedMenuView f;
    public int g;
    public int h = 0;
    public int i;
    public g2.a j;
    public a k;

    /* compiled from: ListMenuPresenter.java */
    /* renamed from: x1$a */
    /* loaded from: classes.dex */
    public class a extends BaseAdapter {
        public int c = -1;

        public a() {
            a();
        }

        public void a() {
            z1 z1Var = x1.this.e;
            c2 c2Var = z1Var.x;
            if (c2Var != null) {
                z1Var.a();
                ArrayList<c2> arrayList = z1Var.j;
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (arrayList.get(i) == c2Var) {
                        this.c = i;
                        return;
                    }
                }
            }
            this.c = -1;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            z1 z1Var = x1.this.e;
            z1Var.a();
            int size = z1Var.j.size() - x1.this.g;
            return this.c < 0 ? size : size - 1;
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            return i;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                x1 x1Var = x1.this;
                view = x1Var.d.inflate(x1Var.i, viewGroup, false);
            }
            ((h2.a) view).a(getItem(i), 0);
            return view;
        }

        @Override // android.widget.BaseAdapter
        public void notifyDataSetChanged() {
            a();
            super.notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public c2 getItem(int i) {
            z1 z1Var = x1.this.e;
            z1Var.a();
            ArrayList<c2> arrayList = z1Var.j;
            int i2 = i + x1.this.g;
            int i3 = this.c;
            if (i3 >= 0 && i2 >= i3) {
                i2++;
            }
            return arrayList.get(i2);
        }
    }

    public x1(Context context, int i) {
        this.i = i;
        this.c = context;
        this.d = LayoutInflater.from(this.c);
    }

    @Override // defpackage.g2
    public void a(Context context, z1 z1Var) {
        int i = this.h;
        if (i != 0) {
            this.c = new ContextThemeWrapper(context, i);
            this.d = LayoutInflater.from(this.c);
        } else if (this.c != null) {
            this.c = context;
            if (this.d == null) {
                this.d = LayoutInflater.from(this.c);
            }
        }
        this.e = z1Var;
        a aVar = this.k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // defpackage.g2
    public boolean a() {
        return false;
    }

    @Override // defpackage.g2
    public boolean a(z1 z1Var, c2 c2Var) {
        return false;
    }

    public ListAdapter b() {
        if (this.k == null) {
            this.k = new a();
        }
        return this.k;
    }

    @Override // defpackage.g2
    public boolean b(z1 z1Var, c2 c2Var) {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.e.a(this.k.getItem(i), this, 0);
    }

    @Override // defpackage.g2
    public void a(boolean z) {
        a aVar = this.k;
        if (aVar != null) {
            aVar.notifyDataSetChanged();
        }
    }

    @Override // defpackage.g2
    public void a(g2.a aVar) {
        this.j = aVar;
    }

    @Override // defpackage.g2
    public boolean a(l2 l2Var) {
        if (l2Var.hasVisibleItems()) {
            a2 a2Var = new a2(l2Var);
            z1 z1Var = a2Var.c;
            q0.a aVar = new q0.a(z1Var.a);
            a2Var.e = new x1(aVar.a.a, f0.abc_list_menu_item_layout);
            x1 x1Var = a2Var.e;
            x1Var.j = a2Var;
            z1 z1Var2 = a2Var.c;
            z1Var2.a(x1Var, z1Var2.a);
            ListAdapter b = a2Var.e.b();
            AlertController.b bVar = aVar.a;
            bVar.w = b;
            bVar.x = a2Var;
            View view = z1Var.p;
            if (view != null) {
                bVar.g = view;
            } else {
                bVar.d = z1Var.o;
                aVar.a(z1Var.n);
            }
            aVar.a.u = a2Var;
            a2Var.d = aVar.a();
            a2Var.d.setOnDismissListener(a2Var);
            WindowManager.LayoutParams attributes = a2Var.d.getWindow().getAttributes();
            attributes.type = 1003;
            attributes.flags |= 131072;
            a2Var.d.show();
            g2.a aVar2 = this.j;
            if (aVar2 != null) {
                aVar2.a(l2Var);
                return true;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.g2
    public void a(z1 z1Var, boolean z) {
        g2.a aVar = this.j;
        if (aVar != null) {
            aVar.a(z1Var, z);
        }
    }
}
