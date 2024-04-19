package defpackage;

import android.text.TextUtils;
import java.security.MessageDigest;
/* compiled from: Option.java */
/* renamed from: ai  reason: default package */
/* loaded from: classes.dex */
public final class ai<T> {
    public static final b<Object> e = new a();
    public final T a;
    public final b<T> b;
    public final String c;
    public volatile byte[] d;

    /* compiled from: Option.java */
    /* renamed from: ai$a */
    /* loaded from: classes.dex */
    public class a implements b<Object> {
        @Override // defpackage.ai.b
        public void a(byte[] bArr, Object obj, MessageDigest messageDigest) {
        }
    }

    /* compiled from: Option.java */
    /* renamed from: ai$b */
    /* loaded from: classes.dex */
    public interface b<T> {
        void a(byte[] bArr, T t, MessageDigest messageDigest);
    }

    public ai(String str, T t, b<T> bVar) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.a = t;
            defpackage.a.a(bVar, "Argument must not be null");
            this.b = bVar;
            return;
        }
        throw new IllegalArgumentException("Must not be null or empty");
    }

    public static <T> ai<T> a(String str, T t) {
        return new ai<>(str, t, e);
    }

    public boolean equals(Object obj) {
        if (obj instanceof ai) {
            return this.c.equals(((ai) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder a2 = jg.a("Option{key='");
        a2.append(this.c);
        a2.append('\'');
        a2.append('}');
        return a2.toString();
    }

    public static <T> b<T> a() {
        return (b<T>) e;
    }
}
