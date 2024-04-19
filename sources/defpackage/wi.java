package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import defpackage.ji;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: ThumbFetcher.java */
/* renamed from: wi  reason: default package */
/* loaded from: classes.dex */
public class wi implements ji<InputStream> {
    public final Uri c;
    public final yi d;
    public InputStream e;

    /* compiled from: ThumbFetcher.java */
    /* renamed from: wi$a */
    /* loaded from: classes.dex */
    public static class a implements xi {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.xi
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* compiled from: ThumbFetcher.java */
    /* renamed from: wi$b */
    /* loaded from: classes.dex */
    public static class b implements xi {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.xi
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public wi(Uri uri, yi yiVar) {
        this.c = uri;
        this.d = yiVar;
    }

    public static wi a(Context context, Uri uri, xi xiVar) {
        return new wi(uri, new yi(lg.a(context).f.a(), xiVar, lg.a(context).g, context.getContentResolver()));
    }

    @Override // defpackage.ji
    public void b() {
        InputStream inputStream = this.e;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.ji
    public uh c() {
        return uh.LOCAL;
    }

    @Override // defpackage.ji
    public void cancel() {
    }

    @Override // defpackage.ji
    public void a(qg qgVar, ji.a<? super InputStream> aVar) {
        try {
            InputStream b2 = this.d.b(this.c);
            int a2 = b2 != null ? this.d.a(this.c) : -1;
            if (a2 != -1) {
                b2 = new mi(b2, a2);
            }
            this.e = b2;
            aVar.a((ji.a<? super InputStream>) this.e);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.a((Exception) e);
        }
    }

    @Override // defpackage.ji
    public Class<InputStream> a() {
        return InputStream.class;
    }
}
