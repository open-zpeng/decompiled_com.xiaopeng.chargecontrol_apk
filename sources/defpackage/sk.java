package defpackage;

import android.util.Log;
import defpackage.ok;
import defpackage.wg;
import java.io.File;
import java.io.IOException;
/* compiled from: DiskLruCacheWrapper.java */
/* renamed from: sk  reason: default package */
/* loaded from: classes.dex */
public class sk implements ok {
    public final File b;
    public final long c;
    public wg e;
    public final qk d = new qk();
    public final yk a = new yk();

    @Deprecated
    public sk(File file, long j) {
        this.b = file;
        this.c = j;
    }

    public final synchronized wg a() {
        if (this.e == null) {
            this.e = wg.a(this.b, 1, 1, this.c);
        }
        return this.e;
    }

    @Override // defpackage.ok
    public File a(zh zhVar) {
        String a = this.a.a(zhVar);
        if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
            Log.v("DiskLruCacheWrapper", "Get: Obtained: " + a + " for for Key: " + zhVar);
        }
        try {
            wg.e a2 = a().a(a);
            if (a2 != null) {
                return a2.a[0];
            }
            return null;
        } catch (IOException e) {
            if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                Log.w("DiskLruCacheWrapper", "Unable to get from disk cache", e);
                return null;
            }
            return null;
        }
    }

    @Override // defpackage.ok
    public void a(zh zhVar, ok.b bVar) {
        boolean z;
        String a = this.a.a(zhVar);
        this.d.a(a);
        try {
            if (Log.isLoggable("DiskLruCacheWrapper", 2)) {
                Log.v("DiskLruCacheWrapper", "Put: Obtained: " + a + " for for Key: " + zhVar);
            }
            try {
                wg a2 = a();
                if (a2.a(a) == null) {
                    wg.c a3 = a2.a(a, -1L);
                    if (a3 != null) {
                        try {
                            ej ejVar = (ej) bVar;
                            if (ejVar.a.a(ejVar.b, a3.a(0), ejVar.c)) {
                                wg.this.a(a3, true);
                                a3.c = true;
                            }
                            if (!z) {
                                try {
                                    a3.a();
                                } catch (IOException unused) {
                                }
                            }
                        } finally {
                            if (!a3.c) {
                                try {
                                    a3.a();
                                } catch (IOException unused2) {
                                }
                            }
                        }
                    } else {
                        throw new IllegalStateException("Had two simultaneous puts for: " + a);
                    }
                }
            } catch (IOException e) {
                if (Log.isLoggable("DiskLruCacheWrapper", 5)) {
                    Log.w("DiskLruCacheWrapper", "Unable to put to disk cache", e);
                }
            }
        } finally {
            this.d.b(a);
        }
    }
}
