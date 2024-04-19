package defpackage;

import defpackage.nl;
import java.io.InputStream;
import java.net.URL;
/* compiled from: UrlLoader.java */
/* renamed from: dm  reason: default package */
/* loaded from: classes.dex */
public class dm implements nl<URL, InputStream> {
    public final nl<gl, InputStream> a;

    /* compiled from: UrlLoader.java */
    /* renamed from: dm$a */
    /* loaded from: classes.dex */
    public static class a implements ol<URL, InputStream> {
        @Override // defpackage.ol
        public nl<URL, InputStream> a(rl rlVar) {
            return new dm(rlVar.a(gl.class, InputStream.class));
        }
    }

    public dm(nl<gl, InputStream> nlVar) {
        this.a = nlVar;
    }

    @Override // defpackage.nl
    public nl.a<InputStream> a(URL url, int i, int i2, bi biVar) {
        return this.a.a(new gl(url), i, i2, biVar);
    }

    @Override // defpackage.nl
    public boolean a(URL url) {
        return true;
    }
}
