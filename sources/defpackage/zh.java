package defpackage;

import java.nio.charset.Charset;
import java.security.MessageDigest;
/* compiled from: Key.java */
/* renamed from: zh  reason: default package */
/* loaded from: classes.dex */
public interface zh {
    public static final Charset a = Charset.forName("UTF-8");

    void a(MessageDigest messageDigest);

    boolean equals(Object obj);

    int hashCode();
}
