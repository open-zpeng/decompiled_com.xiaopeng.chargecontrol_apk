package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* compiled from: QMediaStoreUriLoader.java */
/* renamed from: cm  reason: default package */
/* loaded from: classes.dex */
public final class cm<DataT> implements nl<Uri, DataT> {
    public final Context a;
    public final nl<File, DataT> b;
    public final nl<Uri, DataT> c;
    public final Class<DataT> d;

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: cm$a */
    /* loaded from: classes.dex */
    public static abstract class a<DataT> implements ol<Uri, DataT> {
        public final Context a;
        public final Class<DataT> b;

        public a(Context context, Class<DataT> cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // defpackage.ol
        public final nl<Uri, DataT> a(rl rlVar) {
            return new cm(this.a, rlVar.a(File.class, this.b), rlVar.a(Uri.class, this.b), this.b);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: cm$b */
    /* loaded from: classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: cm$c */
    /* loaded from: classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    public cm(Context context, nl<File, DataT> nlVar, nl<Uri, DataT> nlVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = nlVar;
        this.c = nlVar2;
        this.d = cls;
    }

    @Override // defpackage.nl
    public nl.a a(Uri uri, int i, int i2, bi biVar) {
        Uri uri2 = uri;
        return new nl.a(new iq(uri2), new d(this.a, this.b, this.c, uri2, i, i2, biVar, this.d));
    }

    @Override // defpackage.nl
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && defpackage.a.a(uri);
    }

    /* compiled from: QMediaStoreUriLoader.java */
    /* renamed from: cm$d */
    /* loaded from: classes.dex */
    public static final class d<DataT> implements ji<DataT> {
        public static final String[] m = {"_data"};
        public final Context c;
        public final nl<File, DataT> d;
        public final nl<Uri, DataT> e;
        public final Uri f;
        public final int g;
        public final int h;
        public final bi i;
        public final Class<DataT> j;
        public volatile boolean k;
        public volatile ji<DataT> l;

        public d(Context context, nl<File, DataT> nlVar, nl<Uri, DataT> nlVar2, Uri uri, int i, int i2, bi biVar, Class<DataT> cls) {
            this.c = context.getApplicationContext();
            this.d = nlVar;
            this.e = nlVar2;
            this.f = uri;
            this.g = i;
            this.h = i2;
            this.i = biVar;
            this.j = cls;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super DataT> aVar) {
            try {
                nl.a<DataT> d = d();
                ji<DataT> jiVar = d != null ? d.c : null;
                if (jiVar == null) {
                    aVar.a((Exception) new IllegalArgumentException("Failed to build fetcher for: " + this.f));
                    return;
                }
                this.l = jiVar;
                if (this.k) {
                    cancel();
                } else {
                    jiVar.a(qgVar, aVar);
                }
            } catch (FileNotFoundException e) {
                aVar.a((Exception) e);
            }
        }

        @Override // defpackage.ji
        public void b() {
            ji<DataT> jiVar = this.l;
            if (jiVar != null) {
                jiVar.b();
            }
        }

        @Override // defpackage.ji
        public uh c() {
            return uh.LOCAL;
        }

        @Override // defpackage.ji
        public void cancel() {
            this.k = true;
            ji<DataT> jiVar = this.l;
            if (jiVar != null) {
                jiVar.cancel();
            }
        }

        public final nl.a<DataT> d() {
            if (Environment.isExternalStorageLegacy()) {
                nl<File, DataT> nlVar = this.d;
                Uri uri = this.f;
                Cursor cursor = null;
                try {
                    Cursor query = this.c.getContentResolver().query(uri, m, null, null, null);
                    if (query != null && query.moveToFirst()) {
                        String string = query.getString(query.getColumnIndexOrThrow("_data"));
                        if (!TextUtils.isEmpty(string)) {
                            File file = new File(string);
                            query.close();
                            return nlVar.a(file, this.g, this.h, this.i);
                        }
                        throw new FileNotFoundException("File path was empty in media store for: " + uri);
                    }
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                } catch (Throwable th) {
                    if (0 != 0) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            return this.e.a(this.c.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0 ? MediaStore.setRequireOriginal(this.f) : this.f, this.g, this.h, this.i);
        }

        @Override // defpackage.ji
        public Class<DataT> a() {
            return this.j;
        }
    }
}
