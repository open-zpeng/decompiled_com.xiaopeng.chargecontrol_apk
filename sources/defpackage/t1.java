package defpackage;

import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
/* compiled from: ActionMenuItem.java */
/* renamed from: t1  reason: default package */
/* loaded from: classes.dex */
public class t1 implements k8 {
    public final int a;
    public final int b;
    public final int c;
    public CharSequence d;
    public CharSequence e;
    public Intent f;
    public char g;
    public char i;
    public Drawable k;
    public Context l;
    public CharSequence m;
    public CharSequence n;
    public int h = 4096;
    public int j = 4096;
    public ColorStateList o = null;
    public PorterDuff.Mode p = null;
    public boolean q = false;
    public boolean r = false;
    public int s = 16;

    public t1(Context context, int i, int i2, int i3, CharSequence charSequence) {
        this.l = context;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = charSequence;
    }

    @Override // defpackage.k8
    public g9 a() {
        return null;
    }

    @Override // defpackage.k8
    public k8 a(g9 g9Var) {
        throw new UnsupportedOperationException();
    }

    public final void b() {
        if (this.k != null) {
            if (this.q || this.r) {
                Drawable drawable = this.k;
                int i = Build.VERSION.SDK_INT;
                this.k = drawable;
                this.k = this.k.mutate();
                if (this.q) {
                    Drawable drawable2 = this.k;
                    ColorStateList colorStateList = this.o;
                    int i2 = Build.VERSION.SDK_INT;
                    drawable2.setTintList(colorStateList);
                }
                if (this.r) {
                    Drawable drawable3 = this.k;
                    PorterDuff.Mode mode = this.p;
                    int i3 = Build.VERSION.SDK_INT;
                    drawable3.setTintMode(mode);
                }
            }
        }
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean collapseActionView() {
        return false;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.k8, android.view.MenuItem
    public View getActionView() {
        return null;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.j;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.i;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.m;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        return this.k;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.o;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.p;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.f;
    }

    @Override // android.view.MenuItem
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public int getNumericModifiers() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.g;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitle() {
        return this.d;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.e;
        return charSequence != null ? charSequence : this.d;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.n;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return false;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.s & 1) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.s & 2) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.s & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        return (this.s & 8) == 0;
    }

    public boolean requiresActionButton() {
        return true;
    }

    public boolean requiresOverflow() {
        return false;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        this.i = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        this.s = (z ? 1 : 0) | (this.s & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        this.s = (z ? 2 : 0) | (this.s & (-3));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        this.s = (z ? 16 : 0) | (this.s & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.k = drawable;
        b();
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.o = colorStateList;
        this.q = true;
        b();
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.p = mode;
        this.r = true;
        b();
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.f = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        this.g = c;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.g = c;
        this.i = Character.toLowerCase(c2);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public void setShowAsAction(int i) {
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.e = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        this.s = (this.s & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        this.i = Character.toLowerCase(c);
        this.j = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public k8 setContentDescription(CharSequence charSequence) {
        this.m = charSequence;
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        this.g = c;
        this.h = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        this.d = this.l.getResources().getString(i);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public k8 setTooltipText(CharSequence charSequence) {
        this.n = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.k = o7.b(this.l, i);
        b();
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.g = c;
        this.h = KeyEvent.normalizeMetaState(i);
        this.i = Character.toLowerCase(c2);
        this.j = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
