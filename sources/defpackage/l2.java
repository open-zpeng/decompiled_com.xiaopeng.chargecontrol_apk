package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.z1;
/* compiled from: SubMenuBuilder.java */
/* renamed from: l2  reason: default package */
/* loaded from: classes.dex */
public class l2 extends z1 implements SubMenu {
    public z1 B;
    public c2 C;

    public l2(Context context, z1 z1Var, c2 c2Var) {
        super(context);
        this.B = z1Var;
        this.C = c2Var;
    }

    @Override // defpackage.z1
    public void a(z1.a aVar) {
        this.B.a(aVar);
    }

    @Override // defpackage.z1
    public boolean b(c2 c2Var) {
        return this.B.b(c2Var);
    }

    @Override // defpackage.z1
    public z1 c() {
        return this.B.c();
    }

    @Override // defpackage.z1
    public boolean e() {
        return this.B.e();
    }

    @Override // defpackage.z1
    public boolean f() {
        return this.B.f();
    }

    @Override // defpackage.z1
    public boolean g() {
        return this.B.g();
    }

    @Override // android.view.SubMenu
    public MenuItem getItem() {
        return this.C;
    }

    @Override // defpackage.z1, android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.B.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(Drawable drawable) {
        a(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(CharSequence charSequence) {
        a(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderView(View view) {
        a(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(Drawable drawable) {
        this.C.setIcon(drawable);
        return this;
    }

    @Override // defpackage.z1, android.view.Menu
    public void setQwertyMode(boolean z) {
        this.B.setQwertyMode(z);
    }

    @Override // defpackage.z1
    public boolean a(z1 z1Var, MenuItem menuItem) {
        return super.a(z1Var, menuItem) || this.B.a(z1Var, menuItem);
    }

    @Override // defpackage.z1
    public String b() {
        c2 c2Var = this.C;
        int i = c2Var != null ? c2Var.a : 0;
        if (i == 0) {
            return null;
        }
        return "android:menu:actionviewstates:" + i;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderIcon(int i) {
        a(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setHeaderTitle(int i) {
        a(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public SubMenu setIcon(int i) {
        this.C.setIcon(i);
        return this;
    }

    @Override // defpackage.z1
    public boolean a(c2 c2Var) {
        return this.B.a(c2Var);
    }
}
