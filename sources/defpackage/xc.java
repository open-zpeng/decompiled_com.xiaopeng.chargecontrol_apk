package defpackage;

import androidx.fragment.app.Fragment;
import defpackage.vd;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
/* compiled from: FragmentTransaction.java */
/* renamed from: xc  reason: default package */
/* loaded from: classes.dex */
public abstract class xc {
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public String h;
    public int i;
    public CharSequence j;
    public int k;
    public CharSequence l;
    public ArrayList<String> m;
    public ArrayList<String> n;
    public ArrayList<Runnable> p;
    public ArrayList<a> a = new ArrayList<>();
    public boolean o = false;

    /* compiled from: FragmentTransaction.java */
    /* renamed from: xc$a */
    /* loaded from: classes.dex */
    public static final class a {
        public int a;
        public Fragment b;
        public int c;
        public int d;
        public int e;
        public int f;
        public vd.b g;
        public vd.b h;

        public a() {
        }

        public a(int i, Fragment fragment) {
            this.a = i;
            this.b = fragment;
            vd.b bVar = vd.b.RESUMED;
            this.g = bVar;
            this.h = bVar;
        }
    }

    public xc(kc kcVar, ClassLoader classLoader) {
    }

    public abstract int a();

    public void a(a aVar) {
        this.a.add(aVar);
        aVar.c = this.b;
        aVar.d = this.c;
        aVar.e = this.d;
        aVar.f = this.e;
    }

    public abstract void b();

    public xc c() {
        if (this.g) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        return this;
    }

    public void a(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (!cls.isAnonymousClass() && Modifier.isPublic(modifiers) && (!cls.isMemberClass() || Modifier.isStatic(modifiers))) {
            if (str != null) {
                String str2 = fragment.A;
                if (str2 != null && !str.equals(str2)) {
                    throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.A + " now " + str);
                }
                fragment.A = str;
            }
            if (i != 0) {
                if (i != -1) {
                    int i3 = fragment.y;
                    if (i3 != 0 && i3 != i) {
                        throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.y + " now " + i);
                    }
                    fragment.y = i;
                    fragment.z = i;
                } else {
                    throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
                }
            }
            a(new a(i2, fragment));
            return;
        }
        StringBuilder a2 = jg.a("Fragment ");
        a2.append(cls.getCanonicalName());
        a2.append(" must be a public static class to be  properly recreated from instance state.");
        throw new IllegalStateException(a2.toString());
    }

    public xc a(int i, Fragment fragment, String str) {
        if (i != 0) {
            a(i, fragment, str, 2);
            return this;
        }
        throw new IllegalArgumentException("Must use non-zero containerViewId");
    }

    public xc a(Fragment fragment) {
        a(new a(3, fragment));
        return this;
    }
}
