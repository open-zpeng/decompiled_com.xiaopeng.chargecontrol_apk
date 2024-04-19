package defpackage;

import android.net.Uri;
import defpackage.nl;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: HttpUriLoader.java */
/* renamed from: zl  reason: default package */
/* loaded from: classes.dex */
public class zl implements nl<Uri, InputStream> {
    public static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    public final nl<gl, InputStream> a;

    /* compiled from: HttpUriLoader.java */
    /* renamed from: zl$a */
    /* loaded from: classes.dex */
    public static class a implements ol<Uri, InputStream> {
        @Override // defpackage.ol
        public nl<Uri, InputStream> a(rl rlVar) {
            return new zl(rlVar.a(gl.class, InputStream.class));
        }
    }

    public zl(nl<gl, InputStream> nlVar) {
        this.a = nlVar;
    }

    @Override // defpackage.nl
    public nl.a<InputStream> a(Uri uri, int i, int i2, bi biVar) {
        return this.a.a(new gl(uri.toString()), i, i2, biVar);
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        return b.contains(uri.getScheme());
    }
}
