package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
/* compiled from: GlideUrl.java */
/* renamed from: gl  reason: default package */
/* loaded from: classes.dex */
public class gl implements zh {
    public final hl b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public gl(URL url) {
        hl hlVar = hl.a;
        a.a(url, "Argument must not be null");
        this.c = url;
        this.d = null;
        a.a(hlVar, "Argument must not be null");
        this.b = hlVar;
    }

    public String a() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        URL url = this.c;
        a.a(url, "Argument must not be null");
        return url.toString();
    }

    public URL b() {
        if (this.f == null) {
            if (TextUtils.isEmpty(this.e)) {
                String str = this.d;
                if (TextUtils.isEmpty(str)) {
                    URL url = this.c;
                    a.a(url, "Argument must not be null");
                    str = url.toString();
                }
                this.e = Uri.encode(str, "@#&=*+-_.,:!?()/~'%;$");
            }
            this.f = new URL(this.e);
        }
        return this.f;
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof gl) {
            gl glVar = (gl) obj;
            return a().equals(glVar.a()) && this.b.equals(glVar.b);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        if (this.h == 0) {
            this.h = a().hashCode();
            this.h = this.b.hashCode() + (this.h * 31);
        }
        return this.h;
    }

    public String toString() {
        return a();
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        if (this.g == null) {
            this.g = a().getBytes(zh.a);
        }
        messageDigest.update(this.g);
    }

    public gl(String str) {
        hl hlVar = hl.a;
        this.c = null;
        a.a(str);
        this.d = str;
        a.a(hlVar, "Argument must not be null");
        this.b = hlVar;
    }
}
