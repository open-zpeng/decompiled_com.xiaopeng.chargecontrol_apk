package defpackage;

import android.content.Context;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.widget.ActionBarContextView;
import defpackage.l1;
import defpackage.z1;
import java.lang.ref.WeakReference;
/* compiled from: StandaloneActionMode.java */
/* renamed from: o1  reason: default package */
/* loaded from: classes.dex */
public class o1 extends l1 implements z1.a {
    public Context e;
    public ActionBarContextView f;
    public l1.a g;
    public WeakReference<View> h;
    public boolean i;
    public z1 j;

    public o1(Context context, ActionBarContextView actionBarContextView, l1.a aVar, boolean z) {
        this.e = context;
        this.f = actionBarContextView;
        this.g = aVar;
        z1 z1Var = new z1(actionBarContextView.getContext());
        z1Var.l = 1;
        this.j = z1Var;
        this.j.a(this);
    }

    @Override // defpackage.l1
    public void a(CharSequence charSequence) {
        this.f.setSubtitle(charSequence);
    }

    @Override // defpackage.l1
    public void b(CharSequence charSequence) {
        this.f.setTitle(charSequence);
    }

    @Override // defpackage.l1
    public Menu c() {
        return this.j;
    }

    @Override // defpackage.l1
    public MenuInflater d() {
        return new q1(this.f.getContext());
    }

    @Override // defpackage.l1
    public CharSequence e() {
        return this.f.getSubtitle();
    }

    @Override // defpackage.l1
    public CharSequence f() {
        return this.f.getTitle();
    }

    @Override // defpackage.l1
    public void g() {
        this.g.a(this, this.j);
    }

    @Override // defpackage.l1
    public boolean h() {
        return this.f.c();
    }

    @Override // defpackage.l1
    public void a(int i) {
        a(this.e.getString(i));
    }

    @Override // defpackage.l1
    public void b(int i) {
        b(this.e.getString(i));
    }

    @Override // defpackage.l1
    public void a(View view) {
        this.f.setCustomView(view);
        this.h = view != null ? new WeakReference<>(view) : null;
    }

    @Override // defpackage.l1
    public View b() {
        WeakReference<View> weakReference = this.h;
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    @Override // defpackage.l1
    public void a() {
        if (this.i) {
            return;
        }
        this.i = true;
        this.f.sendAccessibilityEvent(32);
        this.g.a(this);
    }

    @Override // defpackage.l1
    public void a(boolean z) {
        this.d = z;
        this.f.setTitleOptional(z);
    }

    @Override // defpackage.z1.a
    public boolean a(z1 z1Var, MenuItem menuItem) {
        return this.g.a(this, menuItem);
    }

    @Override // defpackage.z1.a
    public void a(z1 z1Var) {
        g();
        this.f.e();
    }
}
