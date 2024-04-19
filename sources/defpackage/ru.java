package defpackage;

import java.io.IOException;
import java.io.StringWriter;
/* compiled from: JsonElement.java */
/* renamed from: ru  reason: default package */
/* loaded from: classes.dex */
public abstract class ru {
    public boolean a() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public int b() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public wu c() {
        if (this instanceof wu) {
            return (wu) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    public String d() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    public boolean e() {
        return this instanceof ou;
    }

    public boolean f() {
        return this instanceof tu;
    }

    public boolean g() {
        return this instanceof wu;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            ix ixVar = new ix(stringWriter);
            ixVar.h = true;
            xw.X.write(ixVar, this);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
