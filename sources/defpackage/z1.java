package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.SparseArray;
import android.view.ContextMenu;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: MenuBuilder.java */
/* renamed from: z1  reason: default package */
/* loaded from: classes.dex */
public class z1 implements j8 {
    public static final int[] A = {1, 4, 5, 3, 2, 0};
    public final Context a;
    public final Resources b;
    public boolean c;
    public boolean d;
    public a e;
    public ContextMenu.ContextMenuInfo m;
    public CharSequence n;
    public Drawable o;
    public View p;
    public c2 x;
    public boolean z;
    public int l = 0;
    public boolean q = false;
    public boolean r = false;
    public boolean s = false;
    public boolean t = false;
    public boolean u = false;
    public ArrayList<c2> v = new ArrayList<>();
    public CopyOnWriteArrayList<WeakReference<g2>> w = new CopyOnWriteArrayList<>();
    public boolean y = false;
    public ArrayList<c2> f = new ArrayList<>();
    public ArrayList<c2> g = new ArrayList<>();
    public boolean h = true;
    public ArrayList<c2> i = new ArrayList<>();
    public ArrayList<c2> j = new ArrayList<>();
    public boolean k = true;

    /* compiled from: MenuBuilder.java */
    /* renamed from: z1$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(z1 z1Var);

        boolean a(z1 z1Var, MenuItem menuItem);
    }

    /* compiled from: MenuBuilder.java */
    /* renamed from: z1$b */
    /* loaded from: classes.dex */
    public interface b {
        boolean a(c2 c2Var);
    }

    public z1(Context context) {
        this.a = context;
        this.b = context.getResources();
        boolean z = true;
        this.d = (this.b.getConfiguration().keyboard == 1 || !ea.b(ViewConfiguration.get(this.a), this.a)) ? false : z;
    }

    public void a(g2 g2Var, Context context) {
        this.w.add(new WeakReference<>(g2Var));
        g2Var.a(context, this);
        this.k = true;
    }

    @Override // android.view.Menu
    public MenuItem add(CharSequence charSequence) {
        return a(0, 0, 0, charSequence);
    }

    @Override // android.view.Menu
    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        int i5;
        PackageManager packageManager = this.a.getPackageManager();
        List<ResolveInfo> queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i6 = 0; i6 < size; i6++) {
            ResolveInfo resolveInfo = queryIntentActivityOptions.get(i6);
            int i7 = resolveInfo.specificIndex;
            Intent intent2 = new Intent(i7 < 0 ? intent : intentArr[i7]);
            intent2.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent3 = a(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent2);
            if (menuItemArr != null && (i5 = resolveInfo.specificIndex) >= 0) {
                menuItemArr[i5] = intent3;
            }
        }
        return size;
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public String b() {
        return "android:menu:actionviewstates";
    }

    public void b(Bundle bundle) {
        int size = size();
        SparseArray<? extends Parcelable> sparseArray = null;
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                actionView.saveHierarchyState(sparseArray);
                if (item.isActionViewExpanded()) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            if (item.hasSubMenu()) {
                ((l2) item.getSubMenu()).b(bundle);
            }
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(b(), sparseArray);
        }
    }

    public z1 c() {
        return this;
    }

    @Override // android.view.Menu
    public void clear() {
        c2 c2Var = this.x;
        if (c2Var != null) {
            a(c2Var);
        }
        this.f.clear();
        b(true);
    }

    public void clearHeader() {
        this.o = null;
        this.n = null;
        this.p = null;
        b(false);
    }

    @Override // android.view.Menu
    public void close() {
        a(true);
    }

    public ArrayList<c2> d() {
        if (this.h) {
            this.g.clear();
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                c2 c2Var = this.f.get(i);
                if (c2Var.isVisible()) {
                    this.g.add(c2Var);
                }
            }
            this.h = false;
            this.k = true;
            return this.g;
        }
        return this.g;
    }

    public boolean e() {
        return this.y;
    }

    public boolean f() {
        return this.c;
    }

    @Override // android.view.Menu
    public MenuItem findItem(int i) {
        MenuItem findItem;
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            c2 c2Var = this.f.get(i2);
            if (c2Var.a == i) {
                return c2Var;
            }
            if (c2Var.hasSubMenu() && (findItem = c2Var.o.findItem(i)) != null) {
                return findItem;
            }
        }
        return null;
    }

    public boolean g() {
        return this.d;
    }

    @Override // android.view.Menu
    public MenuItem getItem(int i) {
        return this.f.get(i);
    }

    public void h() {
        this.k = true;
        b(true);
    }

    @Override // android.view.Menu
    public boolean hasVisibleItems() {
        if (this.z) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (this.f.get(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public void i() {
        this.h = true;
        b(true);
    }

    @Override // android.view.Menu
    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return a(i, keyEvent) != null;
    }

    public void j() {
        this.q = false;
        if (this.r) {
            this.r = false;
            b(this.s);
        }
    }

    public void k() {
        if (this.q) {
            return;
        }
        this.q = true;
        this.r = false;
        this.s = false;
    }

    @Override // android.view.Menu
    public boolean performIdentifierAction(int i, int i2) {
        return a(findItem(i), i2);
    }

    @Override // android.view.Menu
    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        c2 a2 = a(i, keyEvent);
        boolean a3 = a2 != null ? a(a2, (g2) null, i2) : false;
        if ((i2 & 2) != 0) {
            a(true);
        }
        return a3;
    }

    @Override // android.view.Menu
    public void removeGroup(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.f.get(i2).b == i) {
                break;
            } else {
                i2++;
            }
        }
        if (i2 >= 0) {
            int size2 = this.f.size() - i2;
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                if (i3 >= size2 || this.f.get(i2).b != i) {
                    break;
                }
                a(i2, false);
                i3 = i4;
            }
            b(true);
        }
    }

    @Override // android.view.Menu
    public void removeItem(int i) {
        int size = size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                i2 = -1;
                break;
            } else if (this.f.get(i2).a == i) {
                break;
            } else {
                i2++;
            }
        }
        a(i2, true);
    }

    @Override // android.view.Menu
    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            c2 c2Var = this.f.get(i2);
            if (c2Var.b == i) {
                c2Var.y = (c2Var.y & (-5)) | (z2 ? 4 : 0);
                c2Var.setCheckable(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupDividerEnabled(boolean z) {
        this.y = z;
    }

    @Override // android.view.Menu
    public void setGroupEnabled(int i, boolean z) {
        int size = this.f.size();
        for (int i2 = 0; i2 < size; i2++) {
            c2 c2Var = this.f.get(i2);
            if (c2Var.b == i) {
                c2Var.setEnabled(z);
            }
        }
    }

    @Override // android.view.Menu
    public void setGroupVisible(int i, boolean z) {
        int size = this.f.size();
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            c2 c2Var = this.f.get(i2);
            if (c2Var.b == i && c2Var.c(z)) {
                z2 = true;
            }
        }
        if (z2) {
            b(true);
        }
    }

    @Override // android.view.Menu
    public void setQwertyMode(boolean z) {
        this.c = z;
        b(false);
    }

    @Override // android.view.Menu
    public int size() {
        return this.f.size();
    }

    @Override // android.view.Menu
    public MenuItem add(int i) {
        return a(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.b.getString(i));
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return a(i, i2, i3, charSequence);
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        c2 c2Var = (c2) a(i, i2, i3, charSequence);
        l2 l2Var = new l2(this.a, this, c2Var);
        c2Var.o = l2Var;
        l2Var.setHeaderTitle(c2Var.e);
        return l2Var;
    }

    public void a(g2 g2Var) {
        Iterator<WeakReference<g2>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<g2> next = it.next();
            g2 g2Var2 = next.get();
            if (g2Var2 == null || g2Var2 == g2Var) {
                this.w.remove(next);
            }
        }
    }

    @Override // android.view.Menu
    public MenuItem add(int i, int i2, int i3, int i4) {
        return a(i, i2, i3, this.b.getString(i4));
    }

    public void a(Bundle bundle) {
        MenuItem findItem;
        if (bundle == null) {
            return;
        }
        SparseArray<Parcelable> sparseParcelableArray = bundle.getSparseParcelableArray(b());
        int size = size();
        for (int i = 0; i < size; i++) {
            MenuItem item = getItem(i);
            View actionView = item.getActionView();
            if (actionView != null && actionView.getId() != -1) {
                actionView.restoreHierarchyState(sparseParcelableArray);
            }
            if (item.hasSubMenu()) {
                ((l2) item.getSubMenu()).a(bundle);
            }
        }
        int i2 = bundle.getInt("android:menu:expandedactionview");
        if (i2 <= 0 || (findItem = findItem(i2)) == null) {
            return;
        }
        findItem.expandActionView();
    }

    @Override // android.view.Menu
    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.b.getString(i4));
    }

    public void b(boolean z) {
        if (!this.q) {
            if (z) {
                this.h = true;
                this.k = true;
            }
            if (this.w.isEmpty()) {
                return;
            }
            k();
            Iterator<WeakReference<g2>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<g2> next = it.next();
                g2 g2Var = next.get();
                if (g2Var == null) {
                    this.w.remove(next);
                } else {
                    g2Var.a(z);
                }
            }
            j();
            return;
        }
        this.r = true;
        if (z) {
            this.s = true;
        }
    }

    public void a(a aVar) {
        this.e = aVar;
    }

    public final void a(int i, boolean z) {
        if (i < 0 || i >= this.f.size()) {
            return;
        }
        this.f.remove(i);
        if (z) {
            b(true);
        }
    }

    public void a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f.size();
        k();
        for (int i = 0; i < size; i++) {
            c2 c2Var = this.f.get(i);
            if (c2Var.b == groupId && c2Var.e() && c2Var.isCheckable()) {
                c2Var.a(c2Var == menuItem);
            }
        }
        j();
    }

    public boolean b(c2 c2Var) {
        boolean z = false;
        if (this.w.isEmpty()) {
            return false;
        }
        k();
        Iterator<WeakReference<g2>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<g2> next = it.next();
            g2 g2Var = next.get();
            if (g2Var == null) {
                this.w.remove(next);
            } else {
                z = g2Var.b(this, c2Var);
                if (z) {
                    break;
                }
            }
        }
        j();
        if (z) {
            this.x = c2Var;
        }
        return z;
    }

    public MenuItem a(int i, int i2, int i3, CharSequence charSequence) {
        int i4;
        int i5 = ((-65536) & i3) >> 16;
        if (i5 >= 0) {
            int[] iArr = A;
            if (i5 < iArr.length) {
                int i6 = (iArr[i5] << 16) | (65535 & i3);
                c2 c2Var = new c2(this, i, i2, i3, i6, charSequence, this.l);
                ContextMenu.ContextMenuInfo contextMenuInfo = this.m;
                if (contextMenuInfo != null) {
                    c2Var.E = contextMenuInfo;
                }
                ArrayList<c2> arrayList = this.f;
                int size = arrayList.size();
                while (true) {
                    size--;
                    if (size < 0) {
                        i4 = 0;
                        break;
                    } else if (arrayList.get(size).d <= i6) {
                        i4 = size + 1;
                        break;
                    }
                }
                arrayList.add(i4, c2Var);
                b(true);
                return c2Var;
            }
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    public final void a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources resources = this.b;
        if (view != null) {
            this.p = view;
            this.n = null;
            this.o = null;
        } else {
            if (i > 0) {
                this.n = resources.getText(i);
            } else if (charSequence != null) {
                this.n = charSequence;
            }
            if (i2 > 0) {
                this.o = o7.b(this.a, i2);
            } else if (drawable != null) {
                this.o = drawable;
            }
            this.p = null;
        }
        b(false);
    }

    public boolean a(z1 z1Var, MenuItem menuItem) {
        a aVar = this.e;
        return aVar != null && aVar.a(z1Var, menuItem);
    }

    public void a(List<c2> list, int i, KeyEvent keyEvent) {
        char c;
        int i2;
        boolean f = f();
        int modifiers = keyEvent.getModifiers();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f.size();
            for (int i3 = 0; i3 < size; i3++) {
                c2 c2Var = this.f.get(i3);
                if (c2Var.hasSubMenu()) {
                    c2Var.o.a(list, i, keyEvent);
                }
                if (f) {
                    c = c2Var.j;
                } else {
                    c = c2Var.h;
                }
                if (f) {
                    i2 = c2Var.k;
                } else {
                    i2 = c2Var.i;
                }
                if (((modifiers & 69647) == (i2 & 69647)) && c != 0) {
                    char[] cArr = keyData.meta;
                    if ((c == cArr[0] || c == cArr[2] || (f && c == '\b' && i == 67)) && c2Var.isEnabled()) {
                        list.add(c2Var);
                    }
                }
            }
        }
    }

    public c2 a(int i, KeyEvent keyEvent) {
        char c;
        ArrayList<c2> arrayList = this.v;
        arrayList.clear();
        a(arrayList, i, keyEvent);
        if (arrayList.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyCharacterMap.KeyData keyData = new KeyCharacterMap.KeyData();
        keyEvent.getKeyData(keyData);
        int size = arrayList.size();
        if (size == 1) {
            return arrayList.get(0);
        }
        boolean f = f();
        for (int i2 = 0; i2 < size; i2++) {
            c2 c2Var = arrayList.get(i2);
            if (f) {
                c = c2Var.j;
            } else {
                c = c2Var.h;
            }
            if ((c == keyData.meta[0] && (metaState & 2) == 0) || ((c == keyData.meta[2] && (metaState & 2) != 0) || (f && c == '\b' && i == 67))) {
                return c2Var;
            }
        }
        return null;
    }

    public boolean a(MenuItem menuItem, int i) {
        return a(menuItem, (g2) null, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.view.MenuItem r7, defpackage.g2 r8, int r9) {
        /*
            Method dump skipped, instructions count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.z1.a(android.view.MenuItem, g2, int):boolean");
    }

    public final void a(boolean z) {
        if (this.u) {
            return;
        }
        this.u = true;
        Iterator<WeakReference<g2>> it = this.w.iterator();
        while (it.hasNext()) {
            WeakReference<g2> next = it.next();
            g2 g2Var = next.get();
            if (g2Var == null) {
                this.w.remove(next);
            } else {
                g2Var.a(this, z);
            }
        }
        this.u = false;
    }

    public void a() {
        ArrayList<c2> d = d();
        if (this.k) {
            Iterator<WeakReference<g2>> it = this.w.iterator();
            boolean z = false;
            while (it.hasNext()) {
                WeakReference<g2> next = it.next();
                g2 g2Var = next.get();
                if (g2Var == null) {
                    this.w.remove(next);
                } else {
                    z |= g2Var.a();
                }
            }
            if (z) {
                this.i.clear();
                this.j.clear();
                int size = d.size();
                for (int i = 0; i < size; i++) {
                    c2 c2Var = d.get(i);
                    if (c2Var.d()) {
                        this.i.add(c2Var);
                    } else {
                        this.j.add(c2Var);
                    }
                }
            } else {
                this.i.clear();
                this.j.clear();
                this.j.addAll(d());
            }
            this.k = false;
        }
    }

    public boolean a(c2 c2Var) {
        boolean z = false;
        if (!this.w.isEmpty() && this.x == c2Var) {
            k();
            Iterator<WeakReference<g2>> it = this.w.iterator();
            while (it.hasNext()) {
                WeakReference<g2> next = it.next();
                g2 g2Var = next.get();
                if (g2Var == null) {
                    this.w.remove(next);
                } else {
                    z = g2Var.a(this, c2Var);
                    if (z) {
                        break;
                    }
                }
            }
            j();
            if (z) {
                this.x = null;
            }
        }
        return z;
    }
}
