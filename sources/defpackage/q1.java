package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import defpackage.d2;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
/* compiled from: SupportMenuInflater.java */
/* renamed from: q1  reason: default package */
/* loaded from: classes.dex */
public class q1 extends MenuInflater {
    public static final Class<?>[] e = {Context.class};
    public static final Class<?>[] f = e;
    public final Object[] a;
    public final Object[] b;
    public Context c;
    public Object d;

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: q1$a */
    /* loaded from: classes.dex */
    public static class a implements MenuItem.OnMenuItemClickListener {
        public static final Class<?>[] c = {MenuItem.class};
        public Object a;
        public Method b;

        public a(Object obj, String str) {
            this.a = obj;
            Class<?> cls = obj.getClass();
            try {
                this.b = cls.getMethod(str, c);
            } catch (Exception e) {
                StringBuilder a = jg.a("Couldn't resolve menu item onClick handler ", str, " in class ");
                a.append(cls.getName());
                InflateException inflateException = new InflateException(a.toString());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        @Override // android.view.MenuItem.OnMenuItemClickListener
        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.b.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.b.invoke(this.a, menuItem)).booleanValue();
                }
                this.b.invoke(this.a, menuItem);
                return true;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public q1(Context context) {
        super(context);
        this.c = context;
        this.a = new Object[]{context};
        this.b = this.a;
    }

    public final void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException(jg.a("Expecting menu, got ", name));
                }
            } else {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            }
        }
        int i = eventType;
        String str = null;
        boolean z = false;
        boolean z2 = false;
        while (!z) {
            if (i != 1) {
                if (i != 2) {
                    if (i == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z2 && name2.equals(str)) {
                            str = null;
                            z2 = false;
                        } else if (name2.equals("group")) {
                            bVar.b = 0;
                            bVar.c = 0;
                            bVar.d = 0;
                            bVar.e = 0;
                            bVar.f = true;
                            bVar.g = true;
                        } else if (name2.equals("item")) {
                            if (!bVar.h) {
                                g9 g9Var = bVar.A;
                                if (g9Var != null && ((d2.a) g9Var).b.hasSubMenu()) {
                                    bVar.a();
                                } else {
                                    bVar.h = true;
                                    bVar.a(bVar.a.add(bVar.b, bVar.i, bVar.j, bVar.k));
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z = true;
                        }
                    }
                } else if (!z2) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        TypedArray obtainStyledAttributes = q1.this.c.obtainStyledAttributes(attributeSet, i0.MenuGroup);
                        bVar.b = obtainStyledAttributes.getResourceId(i0.MenuGroup_android_id, 0);
                        bVar.c = obtainStyledAttributes.getInt(i0.MenuGroup_android_menuCategory, 0);
                        bVar.d = obtainStyledAttributes.getInt(i0.MenuGroup_android_orderInCategory, 0);
                        bVar.e = obtainStyledAttributes.getInt(i0.MenuGroup_android_checkableBehavior, 0);
                        bVar.f = obtainStyledAttributes.getBoolean(i0.MenuGroup_android_visible, true);
                        bVar.g = obtainStyledAttributes.getBoolean(i0.MenuGroup_android_enabled, true);
                        obtainStyledAttributes.recycle();
                    } else if (name3.equals("item")) {
                        n4 a2 = n4.a(q1.this.c, attributeSet, i0.MenuItem);
                        bVar.i = a2.e(i0.MenuItem_android_id, 0);
                        bVar.j = (a2.c(i0.MenuItem_android_menuCategory, bVar.c) & (-65536)) | (a2.c(i0.MenuItem_android_orderInCategory, bVar.d) & 65535);
                        bVar.k = a2.e(i0.MenuItem_android_title);
                        bVar.l = a2.e(i0.MenuItem_android_titleCondensed);
                        bVar.m = a2.e(i0.MenuItem_android_icon, 0);
                        String d = a2.d(i0.MenuItem_android_alphabeticShortcut);
                        bVar.n = d == null ? (char) 0 : d.charAt(0);
                        bVar.o = a2.c(i0.MenuItem_alphabeticModifiers, 4096);
                        String d2 = a2.d(i0.MenuItem_android_numericShortcut);
                        bVar.p = d2 == null ? (char) 0 : d2.charAt(0);
                        bVar.q = a2.c(i0.MenuItem_numericModifiers, 4096);
                        if (a2.f(i0.MenuItem_android_checkable)) {
                            bVar.r = a2.a(i0.MenuItem_android_checkable, false) ? 1 : 0;
                        } else {
                            bVar.r = bVar.e;
                        }
                        bVar.s = a2.a(i0.MenuItem_android_checked, false);
                        bVar.t = a2.a(i0.MenuItem_android_visible, bVar.f);
                        bVar.u = a2.a(i0.MenuItem_android_enabled, bVar.g);
                        bVar.v = a2.c(i0.MenuItem_showAsAction, -1);
                        bVar.z = a2.d(i0.MenuItem_android_onClick);
                        bVar.w = a2.e(i0.MenuItem_actionLayout, 0);
                        bVar.x = a2.d(i0.MenuItem_actionViewClass);
                        bVar.y = a2.d(i0.MenuItem_actionProviderClass);
                        boolean z3 = bVar.y != null;
                        if (z3 && bVar.w == 0 && bVar.x == null) {
                            bVar.A = (g9) bVar.a(bVar.y, f, q1.this.b);
                        } else {
                            if (z3) {
                                Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                            }
                            bVar.A = null;
                        }
                        bVar.B = a2.e(i0.MenuItem_contentDescription);
                        bVar.C = a2.e(i0.MenuItem_tooltipText);
                        if (a2.f(i0.MenuItem_iconTintMode)) {
                            bVar.E = t3.a(a2.c(i0.MenuItem_iconTintMode, -1), bVar.E);
                        } else {
                            bVar.E = null;
                        }
                        if (a2.f(i0.MenuItem_iconTint)) {
                            bVar.D = a2.a(i0.MenuItem_iconTint);
                        } else {
                            bVar.D = null;
                        }
                        a2.b.recycle();
                        bVar.h = false;
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.a());
                    } else {
                        z2 = true;
                        str = name3;
                    }
                }
                i = xmlPullParser.next();
                z = z;
                z2 = z2;
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    @Override // android.view.MenuInflater
    public void inflate(int i, Menu menu) {
        if (!(menu instanceof j8)) {
            super.inflate(i, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            try {
                try {
                    xmlResourceParser = this.c.getResources().getLayout(i);
                    a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                    xmlResourceParser.close();
                } catch (XmlPullParserException e2) {
                    throw new InflateException("Error inflating menu XML", e2);
                }
            } catch (IOException e3) {
                throw new InflateException("Error inflating menu XML", e3);
            }
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }

    /* compiled from: SupportMenuInflater.java */
    /* renamed from: q1$b */
    /* loaded from: classes.dex */
    public class b {
        public g9 A;
        public CharSequence B;
        public CharSequence C;
        public Menu a;
        public boolean h;
        public int i;
        public int j;
        public CharSequence k;
        public CharSequence l;
        public int m;
        public char n;
        public int o;
        public char p;
        public int q;
        public int r;
        public boolean s;
        public boolean t;
        public boolean u;
        public int v;
        public int w;
        public String x;
        public String y;
        public String z;
        public ColorStateList D = null;
        public PorterDuff.Mode E = null;
        public int b = 0;
        public int c = 0;
        public int d = 0;
        public int e = 0;
        public boolean f = true;
        public boolean g = true;

        public b(Menu menu) {
            this.a = menu;
        }

        public final void a(MenuItem menuItem) {
            boolean z = false;
            menuItem.setChecked(this.s).setVisible(this.t).setEnabled(this.u).setCheckable(this.r >= 1).setTitleCondensed(this.l).setIcon(this.m);
            int i = this.v;
            if (i >= 0) {
                menuItem.setShowAsAction(i);
            }
            if (this.z != null) {
                if (!q1.this.c.isRestricted()) {
                    q1 q1Var = q1.this;
                    if (q1Var.d == null) {
                        q1Var.d = q1Var.a(q1Var.c);
                    }
                    menuItem.setOnMenuItemClickListener(new a(q1Var.d, this.z));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.r >= 2) {
                if (menuItem instanceof c2) {
                    c2 c2Var = (c2) menuItem;
                    c2Var.y = (c2Var.y & (-5)) | 4;
                } else if (menuItem instanceof d2) {
                    d2 d2Var = (d2) menuItem;
                    try {
                        if (d2Var.e == null) {
                            d2Var.e = d2Var.d.getClass().getDeclaredMethod("setExclusiveCheckable", Boolean.TYPE);
                        }
                        d2Var.e.invoke(d2Var.d, true);
                    } catch (Exception e) {
                        Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
                    }
                }
            }
            String str = this.x;
            if (str != null) {
                menuItem.setActionView((View) a(str, q1.e, q1.this.a));
                z = true;
            }
            int i2 = this.w;
            if (i2 > 0) {
                if (!z) {
                    menuItem.setActionView(i2);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            g9 g9Var = this.A;
            if (g9Var != null) {
                if (menuItem instanceof k8) {
                    ((k8) menuItem).a(g9Var);
                } else {
                    Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
                }
            }
            CharSequence charSequence = this.B;
            boolean z2 = menuItem instanceof k8;
            if (z2) {
                ((k8) menuItem).setContentDescription(charSequence);
            } else {
                int i3 = Build.VERSION.SDK_INT;
                menuItem.setContentDescription(charSequence);
            }
            CharSequence charSequence2 = this.C;
            if (z2) {
                ((k8) menuItem).setTooltipText(charSequence2);
            } else {
                int i4 = Build.VERSION.SDK_INT;
                menuItem.setTooltipText(charSequence2);
            }
            char c = this.n;
            int i5 = this.o;
            if (z2) {
                ((k8) menuItem).setAlphabeticShortcut(c, i5);
            } else {
                int i6 = Build.VERSION.SDK_INT;
                menuItem.setAlphabeticShortcut(c, i5);
            }
            char c2 = this.p;
            int i7 = this.q;
            if (z2) {
                ((k8) menuItem).setNumericShortcut(c2, i7);
            } else {
                int i8 = Build.VERSION.SDK_INT;
                menuItem.setNumericShortcut(c2, i7);
            }
            PorterDuff.Mode mode = this.E;
            if (mode != null) {
                if (z2) {
                    ((k8) menuItem).setIconTintMode(mode);
                } else {
                    int i9 = Build.VERSION.SDK_INT;
                    menuItem.setIconTintMode(mode);
                }
            }
            ColorStateList colorStateList = this.D;
            if (colorStateList != null) {
                if (z2) {
                    ((k8) menuItem).setIconTintList(colorStateList);
                    return;
                }
                int i10 = Build.VERSION.SDK_INT;
                menuItem.setIconTintList(colorStateList);
            }
        }

        public SubMenu a() {
            this.h = true;
            SubMenu addSubMenu = this.a.addSubMenu(this.b, this.i, this.j, this.k);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public final <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, q1.this.c.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return (T) constructor.newInstance(objArr);
            } catch (Exception e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public final Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }
}
