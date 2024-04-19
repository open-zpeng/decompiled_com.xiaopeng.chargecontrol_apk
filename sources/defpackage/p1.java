package defpackage;

import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import defpackage.l1;
import java.util.ArrayList;
/* compiled from: SupportActionModeWrapper.java */
/* renamed from: p1  reason: default package */
/* loaded from: classes.dex */
public class p1 extends ActionMode {
    public final Context a;
    public final l1 b;

    public p1(Context context, l1 l1Var) {
        this.a = context;
        this.b = l1Var;
    }

    @Override // android.view.ActionMode
    public void finish() {
        this.b.a();
    }

    @Override // android.view.ActionMode
    public View getCustomView() {
        return this.b.b();
    }

    @Override // android.view.ActionMode
    public Menu getMenu() {
        return new i2(this.a, (j8) this.b.c());
    }

    @Override // android.view.ActionMode
    public MenuInflater getMenuInflater() {
        return this.b.d();
    }

    @Override // android.view.ActionMode
    public CharSequence getSubtitle() {
        return this.b.e();
    }

    @Override // android.view.ActionMode
    public Object getTag() {
        return this.b.c;
    }

    @Override // android.view.ActionMode
    public CharSequence getTitle() {
        return this.b.f();
    }

    @Override // android.view.ActionMode
    public boolean getTitleOptionalHint() {
        return this.b.d;
    }

    @Override // android.view.ActionMode
    public void invalidate() {
        this.b.g();
    }

    @Override // android.view.ActionMode
    public boolean isTitleOptional() {
        return this.b.h();
    }

    @Override // android.view.ActionMode
    public void setCustomView(View view) {
        this.b.a(view);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(CharSequence charSequence) {
        this.b.a(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTag(Object obj) {
        this.b.c = obj;
    }

    @Override // android.view.ActionMode
    public void setTitle(CharSequence charSequence) {
        this.b.b(charSequence);
    }

    @Override // android.view.ActionMode
    public void setTitleOptionalHint(boolean z) {
        this.b.a(z);
    }

    @Override // android.view.ActionMode
    public void setSubtitle(int i) {
        this.b.a(i);
    }

    @Override // android.view.ActionMode
    public void setTitle(int i) {
        this.b.b(i);
    }

    /* compiled from: SupportActionModeWrapper.java */
    /* renamed from: p1$a */
    /* loaded from: classes.dex */
    public static class a implements l1.a {
        public final ActionMode.Callback a;
        public final Context b;
        public final ArrayList<p1> c = new ArrayList<>();
        public final f5<Menu, Menu> d = new f5<>();

        public a(Context context, ActionMode.Callback callback) {
            this.b = context;
            this.a = callback;
        }

        @Override // defpackage.l1.a
        public boolean a(l1 l1Var, Menu menu) {
            return this.a.onPrepareActionMode(b(l1Var), a(menu));
        }

        @Override // defpackage.l1.a
        public boolean b(l1 l1Var, Menu menu) {
            return this.a.onCreateActionMode(b(l1Var), a(menu));
        }

        @Override // defpackage.l1.a
        public boolean a(l1 l1Var, MenuItem menuItem) {
            return this.a.onActionItemClicked(b(l1Var), new d2(this.b, (k8) menuItem));
        }

        public ActionMode b(l1 l1Var) {
            int size = this.c.size();
            for (int i = 0; i < size; i++) {
                p1 p1Var = this.c.get(i);
                if (p1Var != null && p1Var.b == l1Var) {
                    return p1Var;
                }
            }
            p1 p1Var2 = new p1(this.b, l1Var);
            this.c.add(p1Var2);
            return p1Var2;
        }

        @Override // defpackage.l1.a
        public void a(l1 l1Var) {
            this.a.onDestroyActionMode(b(l1Var));
        }

        public final Menu a(Menu menu) {
            Menu orDefault = this.d.getOrDefault(menu, null);
            if (orDefault == null) {
                i2 i2Var = new i2(this.b, (j8) menu);
                this.d.put(menu, i2Var);
                return i2Var;
            }
            return orDefault;
        }
    }
}
