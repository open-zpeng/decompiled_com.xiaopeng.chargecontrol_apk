package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: MenuWrapperICS.java */
/* renamed from: i2  reason: default package */
/* loaded from: classes.dex */
public class i2 extends v1 implements Menu {
    public final j8 d;

    public i2(Context context, j8 j8Var) {
        super(context);
        if (j8Var != null) {
            this.d = j8Var;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(this.d.add(charSequence));
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr != null ? new MenuItem[menuItemArr.length] : null;
        int addIntentOptions = this.d.addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return a(this.d.addSubMenu(charSequence));
    }

    @Override // android.view.Menu
    public void clear() {
        f5<k8, MenuItem> f5Var = this.b;
        if (f5Var != null) {
            f5Var.clear();
        }
        f5<l8, SubMenu> f5Var2 = this.c;
        if (f5Var2 != null) {
            f5Var2.clear();
        }
        this.d.clear();
    }

    @Override // android.view.Menu
    public void close() {
        this.d.close();
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        return a(this.d.findItem(i));
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return a(this.d.getItem(i));
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        return this.d.hasVisibleItems();
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return this.d.isShortcutKey(i, keyEvent);
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return this.d.performIdentifierAction(i, i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return this.d.performShortcut(i, keyEvent, i2);
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        if (this.b != null) {
            int i2 = 0;
            while (true) {
                f5<k8, MenuItem> f5Var = this.b;
                if (i2 >= f5Var.e) {
                    break;
                }
                if (f5Var.c(i2).getGroupId() == i) {
                    this.b.d(i2);
                    i2--;
                }
                i2++;
            }
        }
        this.d.removeGroup(i);
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        if (this.b != null) {
            int i2 = 0;
            while (true) {
                f5<k8, MenuItem> f5Var = this.b;
                if (i2 >= f5Var.e) {
                    break;
                } else if (f5Var.c(i2).getItemId() == i) {
                    this.b.d(i2);
                    break;
                } else {
                    i2++;
                }
            }
        }
        this.d.removeItem(i);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        this.d.setGroupCheckable(i, z, z2);
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        this.d.setGroupEnabled(i, z);
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        this.d.setGroupVisible(i, z);
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.d.setQwertyMode(z);
    }

    @Override // android.view.Menu
    public int size() {
        return this.d.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(this.d.add(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return a(this.d.addSubMenu(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.d.add(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return a(this.d.addSubMenu(i, i2, i3, charSequence));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(this.d.add(i, i2, i3, i4));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return a(this.d.addSubMenu(i, i2, i3, i4));
    }
}
