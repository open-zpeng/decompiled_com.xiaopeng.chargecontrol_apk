package defpackage;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
/* compiled from: JsonTreeReader.java */
/* renamed from: nw  reason: default package */
/* loaded from: classes.dex */
public final class nw extends gx {
    public static final Reader w = new a();
    public static final Object x = new Object();
    public Object[] s;
    public int t;
    public String[] u;
    public int[] v;

    /* compiled from: JsonTreeReader.java */
    /* renamed from: nw$a */
    /* loaded from: classes.dex */
    public class a extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public nw(ru ruVar) {
        super(w);
        this.s = new Object[32];
        this.t = 0;
        this.u = new String[32];
        this.v = new int[32];
        a(ruVar);
    }

    private String j() {
        StringBuilder a2 = jg.a(" at path ");
        a2.append(g());
        return a2.toString();
    }

    @Override // defpackage.gx
    public void a() {
        a(hx.BEGIN_ARRAY);
        a(((ou) w()).iterator());
        this.v[this.t - 1] = 0;
    }

    @Override // defpackage.gx
    public void b() {
        a(hx.BEGIN_OBJECT);
        a(((uu) w()).h().iterator());
    }

    @Override // defpackage.gx, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.s = new Object[]{x};
        this.t = 1;
    }

    @Override // defpackage.gx
    public void e() {
        a(hx.END_ARRAY);
        x();
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.gx
    public void f() {
        a(hx.END_OBJECT);
        x();
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.gx
    public String g() {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i = 0;
        while (i < this.t) {
            Object[] objArr = this.s;
            if (objArr[i] instanceof ou) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('[');
                    sb.append(this.v[i]);
                    sb.append(']');
                }
            } else if (objArr[i] instanceof uu) {
                i++;
                if (objArr[i] instanceof Iterator) {
                    sb.append('.');
                    String[] strArr = this.u;
                    if (strArr[i] != null) {
                        sb.append(strArr[i]);
                    }
                }
            }
            i++;
        }
        return sb.toString();
    }

    @Override // defpackage.gx
    public boolean h() {
        hx s = s();
        return (s == hx.END_OBJECT || s == hx.END_ARRAY) ? false : true;
    }

    @Override // defpackage.gx
    public boolean k() {
        a(hx.BOOLEAN);
        boolean a2 = ((wu) x()).a();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return a2;
    }

    @Override // defpackage.gx
    public double l() {
        hx s = s();
        if (s != hx.NUMBER && s != hx.STRING) {
            StringBuilder a2 = jg.a("Expected ");
            a2.append(hx.NUMBER);
            a2.append(" but was ");
            a2.append(s);
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        wu wuVar = (wu) w();
        double doubleValue = wuVar.a instanceof Number ? wuVar.h().doubleValue() : Double.parseDouble(wuVar.d());
        if (!this.d && (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + doubleValue);
        }
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return doubleValue;
    }

    @Override // defpackage.gx
    public int m() {
        hx s = s();
        if (s != hx.NUMBER && s != hx.STRING) {
            StringBuilder a2 = jg.a("Expected ");
            a2.append(hx.NUMBER);
            a2.append(" but was ");
            a2.append(s);
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        int b = ((wu) w()).b();
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return b;
    }

    @Override // defpackage.gx
    public long n() {
        hx s = s();
        if (s != hx.NUMBER && s != hx.STRING) {
            StringBuilder a2 = jg.a("Expected ");
            a2.append(hx.NUMBER);
            a2.append(" but was ");
            a2.append(s);
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        wu wuVar = (wu) w();
        long longValue = wuVar.a instanceof Number ? wuVar.h().longValue() : Long.parseLong(wuVar.d());
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return longValue;
    }

    @Override // defpackage.gx
    public String o() {
        a(hx.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        String str = (String) entry.getKey();
        this.u[this.t - 1] = str;
        a(entry.getValue());
        return str;
    }

    @Override // defpackage.gx
    public void p() {
        a(hx.NULL);
        x();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // defpackage.gx
    public String q() {
        hx s = s();
        if (s != hx.STRING && s != hx.NUMBER) {
            StringBuilder a2 = jg.a("Expected ");
            a2.append(hx.STRING);
            a2.append(" but was ");
            a2.append(s);
            a2.append(j());
            throw new IllegalStateException(a2.toString());
        }
        String d = ((wu) x()).d();
        int i = this.t;
        if (i > 0) {
            int[] iArr = this.v;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return d;
    }

    @Override // defpackage.gx
    public hx s() {
        if (this.t == 0) {
            return hx.END_DOCUMENT;
        }
        Object w2 = w();
        if (w2 instanceof Iterator) {
            boolean z = this.s[this.t - 2] instanceof uu;
            Iterator it = (Iterator) w2;
            if (!it.hasNext()) {
                return z ? hx.END_OBJECT : hx.END_ARRAY;
            } else if (z) {
                return hx.NAME;
            } else {
                a(it.next());
                return s();
            }
        } else if (w2 instanceof uu) {
            return hx.BEGIN_OBJECT;
        } else {
            if (w2 instanceof ou) {
                return hx.BEGIN_ARRAY;
            }
            if (w2 instanceof wu) {
                Object obj = ((wu) w2).a;
                if (obj instanceof String) {
                    return hx.STRING;
                }
                if (obj instanceof Boolean) {
                    return hx.BOOLEAN;
                }
                if (obj instanceof Number) {
                    return hx.NUMBER;
                }
                throw new AssertionError();
            } else if (w2 instanceof tu) {
                return hx.NULL;
            } else {
                if (w2 == x) {
                    throw new IllegalStateException("JsonReader is closed");
                }
                throw new AssertionError();
            }
        }
    }

    @Override // defpackage.gx
    public String toString() {
        return nw.class.getSimpleName();
    }

    @Override // defpackage.gx
    public void v() {
        if (s() == hx.NAME) {
            o();
            this.u[this.t - 2] = "null";
        } else {
            x();
            int i = this.t;
            if (i > 0) {
                this.u[i - 1] = "null";
            }
        }
        int i2 = this.t;
        if (i2 > 0) {
            int[] iArr = this.v;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    public final Object w() {
        return this.s[this.t - 1];
    }

    public final Object x() {
        Object[] objArr = this.s;
        int i = this.t - 1;
        this.t = i;
        Object obj = objArr[i];
        objArr[this.t] = null;
        return obj;
    }

    public void y() {
        a(hx.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) w()).next();
        a(entry.getValue());
        a(new wu((String) entry.getKey()));
    }

    public final void a(hx hxVar) {
        if (s() == hxVar) {
            return;
        }
        throw new IllegalStateException("Expected " + hxVar + " but was " + s() + j());
    }

    public final void a(Object obj) {
        int i = this.t;
        Object[] objArr = this.s;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.s = Arrays.copyOf(objArr, i2);
            this.v = Arrays.copyOf(this.v, i2);
            this.u = (String[]) Arrays.copyOf(this.u, i2);
        }
        Object[] objArr2 = this.s;
        int i3 = this.t;
        this.t = i3 + 1;
        objArr2[i3] = obj;
    }
}
