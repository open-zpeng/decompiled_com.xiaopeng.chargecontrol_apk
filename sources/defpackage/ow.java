package defpackage;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
/* compiled from: JsonTreeWriter.java */
/* renamed from: ow  reason: default package */
/* loaded from: classes.dex */
public final class ow extends ix {
    public static final Writer q = new a();
    public static final wu r = new wu("closed");
    public final List<ru> n;
    public String o;
    public ru p;

    /* compiled from: JsonTreeWriter.java */
    /* renamed from: ow$a */
    /* loaded from: classes.dex */
    public class a extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public ow() {
        super(q);
        this.n = new ArrayList();
        this.p = tu.a;
    }

    public final void a(ru ruVar) {
        if (this.o != null) {
            if (!ruVar.f() || this.k) {
                ((uu) h()).a(this.o, ruVar);
            }
            this.o = null;
        } else if (this.n.isEmpty()) {
            this.p = ruVar;
        } else {
            ru h = h();
            if (h instanceof ou) {
                ((ou) h).a(ruVar);
                return;
            }
            throw new IllegalStateException();
        }
    }

    @Override // defpackage.ix
    public ix b() {
        ou ouVar = new ou();
        a(ouVar);
        this.n.add(ouVar);
        return this;
    }

    @Override // defpackage.ix
    public ix c() {
        uu uuVar = new uu();
        a(uuVar);
        this.n.add(uuVar);
        return this;
    }

    @Override // defpackage.ix, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.n.isEmpty()) {
            this.n.add(r);
            return;
        }
        throw new IOException("Incomplete document");
    }

    @Override // defpackage.ix
    public ix d() {
        if (!this.n.isEmpty() && this.o == null) {
            if (h() instanceof ou) {
                List<ru> list = this.n;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.ix
    public ix e() {
        if (!this.n.isEmpty() && this.o == null) {
            if (h() instanceof uu) {
                List<ru> list = this.n;
                list.remove(list.size() - 1);
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.ix, java.io.Flushable
    public void flush() {
    }

    @Override // defpackage.ix
    public ix g() {
        a(tu.a);
        return this;
    }

    public final ru h() {
        List<ru> list = this.n;
        return list.get(list.size() - 1);
    }

    @Override // defpackage.ix
    public ix c(String str) {
        if (str == null) {
            a(tu.a);
            return this;
        }
        a(new wu(str));
        return this;
    }

    @Override // defpackage.ix
    public ix a(String str) {
        if (!this.n.isEmpty() && this.o == null) {
            if (h() instanceof uu) {
                this.o = str;
                return this;
            }
            throw new IllegalStateException();
        }
        throw new IllegalStateException();
    }

    @Override // defpackage.ix
    public ix a(Boolean bool) {
        if (bool == null) {
            a(tu.a);
            return this;
        }
        a(new wu(bool));
        return this;
    }

    @Override // defpackage.ix
    public ix a(Number number) {
        if (number == null) {
            a(tu.a);
            return this;
        }
        if (!this.h) {
            double doubleValue = number.doubleValue();
            if (Double.isNaN(doubleValue) || Double.isInfinite(doubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        a(new wu(number));
        return this;
    }

    @Override // defpackage.ix
    public ix a(boolean z) {
        a(new wu(Boolean.valueOf(z)));
        return this;
    }

    @Override // defpackage.ix
    public ix a(long j) {
        a(new wu(Long.valueOf(j)));
        return this;
    }
}
