package defpackage;

import android.content.Context;
import android.net.Uri;
import defpackage.nl;
import defpackage.wi;
import java.io.InputStream;
/* compiled from: MediaStoreImageThumbLoader.java */
/* renamed from: am  reason: default package */
/* loaded from: classes.dex */
public class am implements nl<Uri, InputStream> {
    public final Context a;

    /* compiled from: MediaStoreImageThumbLoader.java */
    /* renamed from: am$a */
    /* loaded from: classes.dex */
    public static class a implements ol<Uri, InputStream> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.ol
        public nl<Uri, InputStream> a(rl rlVar) {
            return new am(this.a);
        }
    }

    public am(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // defpackage.nl
    public nl.a<InputStream> a(Uri uri, int i, int i2, bi biVar) {
        Uri uri2 = uri;
        if (defpackage.a.b(i, i2)) {
            iq iqVar = new iq(uri2);
            Context context = this.a;
            return new nl.a<>(iqVar, wi.a(context, uri2, new wi.a(context.getContentResolver())));
        }
        return null;
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        Uri uri2 = uri;
        return defpackage.a.a(uri2) && !defpackage.a.b(uri2);
    }
}
