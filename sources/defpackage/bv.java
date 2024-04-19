package defpackage;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;
/* compiled from: TypeAdapter.java */
/* renamed from: bv  reason: default package */
/* loaded from: classes.dex */
public abstract class bv<T> {

    /* compiled from: TypeAdapter.java */
    /* renamed from: bv$a */
    /* loaded from: classes.dex */
    public class a extends bv<T> {
        public a() {
        }

        @Override // defpackage.bv
        public T read(gx gxVar) {
            if (gxVar.s() == hx.NULL) {
                gxVar.p();
                return null;
            }
            return (T) bv.this.read(gxVar);
        }

        @Override // defpackage.bv
        public void write(ix ixVar, T t) {
            if (t == null) {
                ixVar.g();
            } else {
                bv.this.write(ixVar, t);
            }
        }
    }

    public final T fromJson(Reader reader) {
        return read(new gx(reader));
    }

    public final T fromJsonTree(ru ruVar) {
        try {
            return read(new nw(ruVar));
        } catch (IOException e) {
            throw new su(e);
        }
    }

    public final bv<T> nullSafe() {
        return new a();
    }

    public abstract T read(gx gxVar);

    public final void toJson(Writer writer, T t) {
        write(new ix(writer), t);
    }

    public final ru toJsonTree(T t) {
        try {
            ow owVar = new ow();
            write(owVar, t);
            if (owVar.n.isEmpty()) {
                return owVar.p;
            }
            throw new IllegalStateException("Expected one JSON element but was " + owVar.n);
        } catch (IOException e) {
            throw new su(e);
        }
    }

    public abstract void write(ix ixVar, T t);

    public final T fromJson(String str) {
        return fromJson(new StringReader(str));
    }

    public final String toJson(T t) {
        StringWriter stringWriter = new StringWriter();
        try {
            toJson(stringWriter, t);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
