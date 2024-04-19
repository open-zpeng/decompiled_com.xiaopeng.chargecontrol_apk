package defpackage;

import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
/* compiled from: BaseMenuWrapper.java */
/* renamed from: v1  reason: default package */
/* loaded from: classes.dex */
public abstract class v1 {
    public final Context a;
    public f5<k8, MenuItem> b;
    public f5<l8, SubMenu> c;

    public v1(Context context) {
        this.a = context;
    }

    public final MenuItem a(MenuItem menuItem) {
        if (menuItem instanceof k8) {
            k8 k8Var = (k8) menuItem;
            if (this.b == null) {
                this.b = new f5<>();
            }
            MenuItem orDefault = this.b.getOrDefault(menuItem, null);
            if (orDefault == null) {
                d2 d2Var = new d2(this.a, k8Var);
                this.b.put(k8Var, d2Var);
                return d2Var;
            }
            return orDefault;
        }
        return menuItem;
    }

    public final SubMenu a(SubMenu subMenu) {
        if (subMenu instanceof l8) {
            l8 l8Var = (l8) subMenu;
            if (this.c == null) {
                this.c = new f5<>();
            }
            SubMenu subMenu2 = this.c.get(l8Var);
            if (subMenu2 == null) {
                m2 m2Var = new m2(this.a, l8Var);
                this.c.put(l8Var, m2Var);
                return m2Var;
            }
            return subMenu2;
        }
        return subMenu;
    }
}
