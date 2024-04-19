package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import defpackage.ji;
import java.io.FileNotFoundException;
import java.io.IOException;
/* compiled from: LocalUriFetcher.java */
/* renamed from: ri  reason: default package */
/* loaded from: classes.dex */
public abstract class ri<T> implements ji<T> {
    public final Uri c;
    public final ContentResolver d;
    public T e;

    public ri(ContentResolver contentResolver, Uri uri) {
        this.d = contentResolver;
        this.c = uri;
    }

    public abstract T a(Uri uri, ContentResolver contentResolver);

    public abstract void a(T t);

    @Override // defpackage.ji
    public final void a(qg qgVar, ji.a<? super T> aVar) {
        try {
            this.e = a(this.c, this.d);
            aVar.a((ji.a<? super T>) ((T) this.e));
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.a((Exception) e);
        }
    }

    @Override // defpackage.ji
    public void b() {
        T t = this.e;
        if (t != null) {
            try {
                a(t);
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
}
