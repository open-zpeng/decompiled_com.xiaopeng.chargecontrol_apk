package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/* compiled from: LruBitmapPool.java */
/* renamed from: kk  reason: default package */
/* loaded from: classes.dex */
public class kk implements ek {
    public static final Bitmap.Config j = Bitmap.Config.ARGB_8888;
    public final lk a;
    public final Set<Bitmap.Config> b;
    public final a c;
    public long d;
    public long e;
    public int f;
    public int g;
    public int h;
    public int i;

    /* compiled from: LruBitmapPool.java */
    /* renamed from: kk$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: LruBitmapPool.java */
    /* renamed from: kk$b */
    /* loaded from: classes.dex */
    public static final class b implements a {
        public void a(Bitmap bitmap) {
        }

        public void b(Bitmap bitmap) {
        }
    }

    public kk(long j2) {
        int i = Build.VERSION.SDK_INT;
        nk nkVar = new nk();
        HashSet hashSet = new HashSet(Arrays.asList(Bitmap.Config.values()));
        int i2 = Build.VERSION.SDK_INT;
        hashSet.add(null);
        int i3 = Build.VERSION.SDK_INT;
        hashSet.remove(Bitmap.Config.HARDWARE);
        Set<Bitmap.Config> unmodifiableSet = Collections.unmodifiableSet(hashSet);
        this.d = j2;
        this.a = nkVar;
        this.b = unmodifiableSet;
        this.c = new b();
    }

    @Override // defpackage.ek
    public synchronized void a(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    if (bitmap.isMutable() && this.a.b(bitmap) <= this.d && this.b.contains(bitmap.getConfig())) {
                        int b2 = this.a.b(bitmap);
                        this.a.a(bitmap);
                        ((b) this.c).a(bitmap);
                        this.h++;
                        this.e += b2;
                        if (Log.isLoggable("LruBitmapPool", 2)) {
                            Log.v("LruBitmapPool", "Put bitmap in pool=" + this.a.c(bitmap));
                        }
                        b();
                        a(this.d);
                        return;
                    }
                    if (Log.isLoggable("LruBitmapPool", 2)) {
                        Log.v("LruBitmapPool", "Reject bitmap from pool, bitmap: " + this.a.c(bitmap) + ", is mutable: " + bitmap.isMutable() + ", is allowed config: " + this.b.contains(bitmap.getConfig()));
                    }
                    bitmap.recycle();
                    return;
                }
                throw new IllegalStateException("Cannot pool recycled bitmap");
            }
            throw new NullPointerException("Bitmap must not be null");
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.ek
    public Bitmap b(int i, int i2, Bitmap.Config config) {
        Bitmap c = c(i, i2, config);
        if (c == null) {
            if (config == null) {
                config = j;
            }
            return Bitmap.createBitmap(i, i2, config);
        }
        return c;
    }

    public final synchronized Bitmap c(int i, int i2, Bitmap.Config config) {
        Bitmap a2;
        int i3 = Build.VERSION.SDK_INT;
        if (config != Bitmap.Config.HARDWARE) {
            a2 = this.a.a(i, i2, config != null ? config : j);
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 3)) {
                    Log.d("LruBitmapPool", "Missing bitmap=" + this.a.b(i, i2, config));
                }
                this.g++;
            } else {
                this.f++;
                this.e -= this.a.b(a2);
                ((b) this.c).b(a2);
                a2.setHasAlpha(true);
                int i4 = Build.VERSION.SDK_INT;
                a2.setPremultiplied(true);
            }
            if (Log.isLoggable("LruBitmapPool", 2)) {
                Log.v("LruBitmapPool", "Get bitmap=" + this.a.b(i, i2, config));
            }
            b();
        } else {
            throw new IllegalArgumentException("Cannot create a mutable Bitmap with config: " + config + ". Consider setting Downsampler#ALLOW_HARDWARE_CONFIG to false in your RequestOptions and/or in GlideBuilder.setDefaultRequestOptions");
        }
        return a2;
    }

    public final void b() {
        if (Log.isLoggable("LruBitmapPool", 2)) {
            c();
        }
    }

    public final void c() {
        StringBuilder a2 = jg.a("Hits=");
        a2.append(this.f);
        a2.append(", misses=");
        a2.append(this.g);
        a2.append(", puts=");
        a2.append(this.h);
        a2.append(", evictions=");
        a2.append(this.i);
        a2.append(", currentSize=");
        a2.append(this.e);
        a2.append(", maxSize=");
        a2.append(this.d);
        a2.append("\nStrategy=");
        a2.append(this.a);
        Log.v("LruBitmapPool", a2.toString());
    }

    @Override // defpackage.ek
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap c = c(i, i2, config);
        if (c != null) {
            c.eraseColor(0);
            return c;
        }
        if (config == null) {
            config = j;
        }
        return Bitmap.createBitmap(i, i2, config);
    }

    @Override // defpackage.ek
    public void a() {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "clearMemory");
        }
        a(0L);
    }

    @Override // defpackage.ek
    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (Log.isLoggable("LruBitmapPool", 3)) {
            Log.d("LruBitmapPool", "trimMemory, level=" + i);
        }
        if (i < 40) {
            int i2 = Build.VERSION.SDK_INT;
            if (i < 20) {
                if (i >= 20 || i == 15) {
                    a(this.d / 2);
                    return;
                }
                return;
            }
        }
        a();
    }

    public final synchronized void a(long j2) {
        while (this.e > j2) {
            Bitmap a2 = this.a.a();
            if (a2 == null) {
                if (Log.isLoggable("LruBitmapPool", 5)) {
                    Log.w("LruBitmapPool", "Size mismatch, resetting");
                    c();
                }
                this.e = 0L;
                return;
            }
            ((b) this.c).b(a2);
            this.e -= this.a.b(a2);
            this.i++;
            if (Log.isLoggable("LruBitmapPool", 3)) {
                Log.d("LruBitmapPool", "Evicting bitmap=" + this.a.c(a2));
            }
            b();
            a2.recycle();
        }
    }
}
