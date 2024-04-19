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
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import defpackage.g9;
/* compiled from: MenuItemImpl.java */
/* renamed from: c2  reason: default package */
/* loaded from: classes.dex */
public final class c2 implements k8 {
    public View A;
    public g9 B;
    public MenuItem.OnActionExpandListener C;
    public ContextMenu.ContextMenuInfo E;
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public CharSequence e;
    public CharSequence f;
    public Intent g;
    public char h;
    public char j;
    public Drawable l;
    public z1 n;
    public l2 o;
    public Runnable p;
    public MenuItem.OnMenuItemClickListener q;
    public CharSequence r;
    public CharSequence s;
    public int z;
    public int i = 4096;
    public int k = 4096;
    public int m = 0;
    public ColorStateList t = null;
    public PorterDuff.Mode u = null;
    public boolean v = false;
    public boolean w = false;
    public boolean x = false;
    public int y = 16;
    public boolean D = false;

    /* compiled from: MenuItemImpl.java */
    /* renamed from: c2$a */
    /* loaded from: classes.dex */
    public class a implements g9.b {
        public a() {
        }
    }

    public c2(z1 z1Var, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.z = 0;
        this.n = z1Var;
        this.a = i2;
        this.b = i;
        this.c = i3;
        this.d = i4;
        this.e = charSequence;
        this.z = i5;
    }

    public static void a(StringBuilder sb, int i, int i2, String str) {
        if ((i & i2) == i2) {
            sb.append(str);
        }
    }

    public char b() {
        return this.n.f() ? this.j : this.h;
    }

    public boolean c(boolean z) {
        int i = this.y;
        this.y = (z ? 0 : 8) | (i & (-9));
        return i != this.y;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean collapseActionView() {
        if ((this.z & 8) == 0) {
            return false;
        }
        if (this.A == null) {
            return true;
        }
        MenuItem.OnActionExpandListener onActionExpandListener = this.C;
        if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionCollapse(this)) {
            return this.n.a(this);
        }
        return false;
    }

    public boolean d() {
        return (this.y & 32) == 32;
    }

    public boolean e() {
        return (this.y & 4) != 0;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean expandActionView() {
        if (c()) {
            MenuItem.OnActionExpandListener onActionExpandListener = this.C;
            if (onActionExpandListener == null || onActionExpandListener.onMenuItemActionExpand(this)) {
                return this.n.b(this);
            }
            return false;
        }
        return false;
    }

    public boolean f() {
        return (this.z & 1) == 1;
    }

    public boolean g() {
        return this.n.g() && b() != 0;
    }

    @Override // android.view.MenuItem
    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    @Override // defpackage.k8, android.view.MenuItem
    public View getActionView() {
        View view = this.A;
        if (view != null) {
            return view;
        }
        g9 g9Var = this.B;
        if (g9Var != null) {
            this.A = g9Var.a(this);
            return this.A;
        }
        return null;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public int getAlphabeticModifiers() {
        return this.k;
    }

    @Override // android.view.MenuItem
    public char getAlphabeticShortcut() {
        return this.j;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public CharSequence getContentDescription() {
        return this.r;
    }

    @Override // android.view.MenuItem
    public int getGroupId() {
        return this.b;
    }

    @Override // android.view.MenuItem
    public Drawable getIcon() {
        Drawable drawable = this.l;
        if (drawable != null) {
            return a(drawable);
        }
        int i = this.m;
        if (i != 0) {
            Drawable b = i1.b(this.n.a, i);
            this.m = 0;
            this.l = b;
            return a(b);
        }
        return null;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public ColorStateList getIconTintList() {
        return this.t;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public PorterDuff.Mode getIconTintMode() {
        return this.u;
    }

    @Override // android.view.MenuItem
    public Intent getIntent() {
        return this.g;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public int getItemId() {
        return this.a;
    }

    @Override // android.view.MenuItem
    public ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.E;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public int getNumericModifiers() {
        return this.i;
    }

    @Override // android.view.MenuItem
    public char getNumericShortcut() {
        return this.h;
    }

    @Override // android.view.MenuItem
    public int getOrder() {
        return this.c;
    }

    @Override // android.view.MenuItem
    public SubMenu getSubMenu() {
        return this.o;
    }

    @Override // android.view.MenuItem
    @ViewDebug.CapturedViewProperty
    public CharSequence getTitle() {
        return this.e;
    }

    @Override // android.view.MenuItem
    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f;
        if (charSequence == null) {
            charSequence = this.e;
        }
        int i = Build.VERSION.SDK_INT;
        return charSequence;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public CharSequence getTooltipText() {
        return this.s;
    }

    @Override // android.view.MenuItem
    public boolean hasSubMenu() {
        return this.o != null;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public boolean isActionViewExpanded() {
        return this.D;
    }

    @Override // android.view.MenuItem
    public boolean isCheckable() {
        return (this.y & 1) == 1;
    }

    @Override // android.view.MenuItem
    public boolean isChecked() {
        return (this.y & 2) == 2;
    }

    @Override // android.view.MenuItem
    public boolean isEnabled() {
        return (this.y & 16) != 0;
    }

    @Override // android.view.MenuItem
    public boolean isVisible() {
        g9 g9Var = this.B;
        return (g9Var == null || !g9Var.b()) ? (this.y & 8) == 0 : (this.y & 8) == 0 && this.B.a();
    }

    public boolean requiresActionButton() {
        return (this.z & 2) == 2;
    }

    public boolean requiresOverflow() {
        return (requiresActionButton() || f()) ? false : true;
    }

    @Override // android.view.MenuItem
    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    @Override // defpackage.k8, android.view.MenuItem
    public /* bridge */ /* synthetic */ MenuItem setActionView(View view) {
        setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c) {
        if (this.j == c) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setCheckable(boolean z) {
        int i = this.y;
        this.y = (z ? 1 : 0) | (i & (-2));
        if (i != this.y) {
            this.n.b(false);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setChecked(boolean z) {
        if ((this.y & 4) != 0) {
            this.n.a((MenuItem) this);
        } else {
            a(z);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.y |= 16;
        } else {
            this.y &= -17;
        }
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(Drawable drawable) {
        this.m = 0;
        this.l = drawable;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setIconTintList(ColorStateList colorStateList) {
        this.t = colorStateList;
        this.v = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.u = mode;
        this.w = true;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIntent(Intent intent) {
        this.g = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setNumericShortcut(char c) {
        if (this.h == c) {
            return this;
        }
        this.h = c;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.C = onActionExpandListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.q = onMenuItemClickListener;
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setShortcut(char c, char c2) {
        this.h = c;
        this.j = Character.toLowerCase(c2);
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public void setShowAsAction(int i) {
        int i2 = i & 3;
        if (i2 != 0 && i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
        this.z = i;
        this.n.h();
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setShowAsActionFlags(int i) {
        setShowAsAction(i);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(CharSequence charSequence) {
        this.e = charSequence;
        this.n.b(false);
        l2 l2Var = this.o;
        if (l2Var != null) {
            l2Var.setHeaderTitle(charSequence);
        }
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setVisible(boolean z) {
        if (c(z)) {
            z1 z1Var = this.n;
            z1Var.h = true;
            z1Var.b(true);
        }
        return this;
    }

    public String toString() {
        CharSequence charSequence = this.e;
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    public final Drawable a(Drawable drawable) {
        if (drawable != null && this.x && (this.v || this.w)) {
            int i = Build.VERSION.SDK_INT;
            drawable = drawable.mutate();
            if (this.v) {
                ColorStateList colorStateList = this.t;
                int i2 = Build.VERSION.SDK_INT;
                drawable.setTintList(colorStateList);
            }
            if (this.w) {
                PorterDuff.Mode mode = this.u;
                int i3 = Build.VERSION.SDK_INT;
                drawable.setTintMode(mode);
            }
            this.x = false;
        }
        return drawable;
    }

    public void b(boolean z) {
        if (z) {
            this.y |= 32;
        } else {
            this.y &= -33;
        }
    }

    @Override // defpackage.k8, android.view.MenuItem
    public k8 setActionView(View view) {
        int i;
        this.A = view;
        this.B = null;
        if (view != null && view.getId() == -1 && (i = this.a) > 0) {
            view.setId(i);
        }
        this.n.h();
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public k8 setContentDescription(CharSequence charSequence) {
        this.r = charSequence;
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public k8 setTooltipText(CharSequence charSequence) {
        this.s = charSequence;
        this.n.b(false);
        return this;
    }

    public boolean c() {
        g9 g9Var;
        if ((this.z & 8) != 0) {
            if (this.A == null && (g9Var = this.B) != null) {
                this.A = g9Var.a(this);
            }
            return this.A != null;
        }
        return false;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setAlphabeticShortcut(char c, int i) {
        if (this.j == c && this.k == i) {
            return this;
        }
        this.j = Character.toLowerCase(c);
        this.k = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setNumericShortcut(char c, int i) {
        if (this.h == c && this.i == i) {
            return this;
        }
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.n.b(false);
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.h = c;
        this.i = KeyEvent.normalizeMetaState(i);
        this.j = Character.toLowerCase(c2);
        this.k = KeyEvent.normalizeMetaState(i2);
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setIcon(int i) {
        this.l = null;
        this.m = i;
        this.x = true;
        this.n.b(false);
        return this;
    }

    @Override // android.view.MenuItem
    public MenuItem setTitle(int i) {
        setTitle(this.n.a.getString(i));
        return this;
    }

    @Override // defpackage.k8, android.view.MenuItem
    public MenuItem setActionView(int i) {
        Context context = this.n.a;
        setActionView(LayoutInflater.from(context).inflate(i, (ViewGroup) new LinearLayout(context), false));
        return this;
    }

    public void a(boolean z) {
        int i = this.y;
        this.y = (z ? 2 : 0) | (i & (-3));
        if (i != this.y) {
            this.n.b(false);
        }
    }

    @Override // defpackage.k8
    public g9 a() {
        return this.B;
    }

    @Override // defpackage.k8
    public k8 a(g9 g9Var) {
        g9 g9Var2 = this.B;
        if (g9Var2 != null) {
            g9Var2.a = null;
        }
        this.A = null;
        this.B = g9Var;
        this.n.b(true);
        g9 g9Var3 = this.B;
        if (g9Var3 != null) {
            g9Var3.a(new a());
        }
        return this;
    }
}
