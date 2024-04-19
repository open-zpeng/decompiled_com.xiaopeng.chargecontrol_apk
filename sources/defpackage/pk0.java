package defpackage;

import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* compiled from: ConnectionSpec.java */
/* renamed from: pk0  reason: default package */
/* loaded from: classes.dex */
public final class pk0 {
    public static final ok0[] e = {ok0.m, ok0.o, ok0.n, ok0.p, ok0.r, ok0.q, ok0.i, ok0.k, ok0.j, ok0.l, ok0.g, ok0.h, ok0.e, ok0.f, ok0.d};
    public static final pk0 f;
    public static final pk0 g;
    public final boolean a;
    public final boolean b;
    public final String[] c;
    public final String[] d;

    static {
        a aVar = new a(true);
        ok0[] ok0VarArr = e;
        if (aVar.a) {
            String[] strArr = new String[ok0VarArr.length];
            for (int i = 0; i < ok0VarArr.length; i++) {
                strArr[i] = ok0VarArr[i].a;
            }
            if (aVar.a) {
                if (strArr.length != 0) {
                    aVar.b = (String[]) strArr.clone();
                    aVar.a(wk0.TLS_1_3, wk0.TLS_1_2, wk0.TLS_1_1, wk0.TLS_1_0);
                    if (aVar.a) {
                        aVar.d = true;
                        f = new pk0(aVar);
                        a aVar2 = new a(f);
                        aVar2.a(wk0.TLS_1_0);
                        if (aVar2.a) {
                            aVar2.d = true;
                            new pk0(aVar2);
                            g = new pk0(new a(false));
                            return;
                        }
                        throw new IllegalStateException("no TLS extensions for cleartext connections");
                    }
                    throw new IllegalStateException("no TLS extensions for cleartext connections");
                }
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }
        throw new IllegalStateException("no cipher suites for cleartext connections");
    }

    public pk0(a aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.b = aVar.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof pk0) {
            if (obj == this) {
                return true;
            }
            pk0 pk0Var = (pk0) obj;
            boolean z = this.a;
            if (z != pk0Var.a) {
                return false;
            }
            return !z || (Arrays.equals(this.c, pk0Var.c) && Arrays.equals(this.d, pk0Var.d) && this.b == pk0Var.b);
        }
        return false;
    }

    public int hashCode() {
        if (this.a) {
            return ((((IInputController.KEYCODE_KNOB_TALKING_BOOK + Arrays.hashCode(this.c)) * 31) + Arrays.hashCode(this.d)) * 31) + (!this.b ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        String str;
        List list;
        if (this.a) {
            String[] strArr = this.c;
            String str2 = "[all enabled]";
            if (strArr != null) {
                if (strArr != null) {
                    ArrayList arrayList = new ArrayList(strArr.length);
                    for (String str3 : strArr) {
                        arrayList.add(ok0.a(str3));
                    }
                    list = Collections.unmodifiableList(arrayList);
                } else {
                    list = null;
                }
                str = list.toString();
            } else {
                str = "[all enabled]";
            }
            String[] strArr2 = this.d;
            if (strArr2 != null) {
                str2 = (strArr2 != null ? wk0.a(strArr2) : null).toString();
            }
            return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.b + ")";
        }
        return "ConnectionSpec()";
    }

    /* compiled from: ConnectionSpec.java */
    /* renamed from: pk0$a */
    /* loaded from: classes.dex */
    public static final class a {
        public boolean a;
        public String[] b;
        public String[] c;
        public boolean d;

        public a(boolean z) {
            this.a = z;
        }

        public a a(wk0... wk0VarArr) {
            if (this.a) {
                String[] strArr = new String[wk0VarArr.length];
                for (int i = 0; i < wk0VarArr.length; i++) {
                    strArr[i] = wk0VarArr[i].c;
                }
                if (this.a) {
                    if (strArr.length != 0) {
                        this.c = (String[]) strArr.clone();
                        return this;
                    }
                    throw new IllegalArgumentException("At least one TLS version is required");
                }
                throw new IllegalStateException("no TLS versions for cleartext connections");
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public a(pk0 pk0Var) {
            this.a = pk0Var.a;
            this.b = pk0Var.c;
            this.c = pk0Var.d;
            this.d = pk0Var.b;
        }
    }
}
