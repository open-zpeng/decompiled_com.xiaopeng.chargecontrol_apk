package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.io.FileNotFoundException;
/* compiled from: MediaStoreFileLoader.java */
/* renamed from: kl  reason: default package */
/* loaded from: classes.dex */
public final class kl implements nl<Uri, File> {
    public final Context a;

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: kl$a */
    /* loaded from: classes.dex */
    public static final class a implements ol<Uri, File> {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.ol
        public nl<Uri, File> a(rl rlVar) {
            return new kl(this.a);
        }
    }

    public kl(Context context) {
        this.a = context;
    }

    @Override // defpackage.nl
    public nl.a<File> a(Uri uri, int i, int i2, bi biVar) {
        Uri uri2 = uri;
        return new nl.a<>(new iq(uri2), new b(this.a, uri2));
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        return defpackage.a.a(uri);
    }

    /* compiled from: MediaStoreFileLoader.java */
    /* renamed from: kl$b */
    /* loaded from: classes.dex */
    public static class b implements ji<File> {
        public static final String[] e = {"_data"};
        public final Context c;
        public final Uri d;

        public b(Context context, Uri uri) {
            this.c = context;
            this.d = uri;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super File> aVar) {
            Cursor query = this.c.getContentResolver().query(this.d, e, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                StringBuilder a = jg.a("Failed to find file path for: ");
                a.append(this.d);
                aVar.a((Exception) new FileNotFoundException(a.toString()));
                return;
            }
            aVar.a((ji.a<? super File>) new File(r0));
        }

        @Override // defpackage.ji
        public void b() {
        }

        @Override // defpackage.ji
        public uh c() {
            return uh.LOCAL;
        }

        @Override // defpackage.ji
        public void cancel() {
        }

        @Override // defpackage.ji
        public Class<File> a() {
            return File.class;
        }
    }
}
