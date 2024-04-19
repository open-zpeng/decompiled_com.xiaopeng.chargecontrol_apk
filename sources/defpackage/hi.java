package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import defpackage.ji;
import java.io.IOException;
/* compiled from: AssetPathFetcher.java */
/* renamed from: hi  reason: default package */
/* loaded from: classes.dex */
public abstract class hi<T> implements ji<T> {
    public final String c;
    public final AssetManager d;
    public T e;

    public hi(AssetManager assetManager, String str) {
        this.d = assetManager;
        this.c = str;
    }

    public abstract T a(AssetManager assetManager, String str);

    public abstract void a(T t);

    @Override // defpackage.ji
    public void a(qg qgVar, ji.a<? super T> aVar) {
        try {
            this.e = a(this.d, this.c);
            aVar.a((ji.a<? super T>) ((T) this.e));
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.a((Exception) e);
        }
    }

    @Override // defpackage.ji
    public void b() {
        T t = this.e;
        if (t == null) {
            return;
        }
        try {
            a(t);
        } catch (IOException unused) {
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
