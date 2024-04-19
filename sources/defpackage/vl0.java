package defpackage;

import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: SubscriberMethod.java */
/* renamed from: vl0  reason: default package */
/* loaded from: classes.dex */
public class vl0 {
    public final Method a;
    public final ThreadMode b;
    public final Class<?> c;
    public final int d;
    public final boolean e;
    public String f;

    public vl0(Method method, Class<?> cls, ThreadMode threadMode, int i, boolean z) {
        this.a = method;
        this.b = threadMode;
        this.c = cls;
        this.d = i;
        this.e = z;
    }

    public final synchronized void a() {
        if (this.f == null) {
            StringBuilder sb = new StringBuilder(64);
            sb.append(this.a.getDeclaringClass().getName());
            sb.append('#');
            sb.append(this.a.getName());
            sb.append('(');
            sb.append(this.c.getName());
            this.f = sb.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof vl0) {
            a();
            vl0 vl0Var = (vl0) obj;
            vl0Var.a();
            return this.f.equals(vl0Var.f);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
