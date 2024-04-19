package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.ym;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
/* compiled from: Downsampler.java */
/* renamed from: sm  reason: default package */
/* loaded from: classes.dex */
public final class sm {
    public static final ai<vh> f = ai.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", vh.e);
    public static final ai<ci> g = ai.a("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace", ci.SRGB);
    @Deprecated
    public static final ai<rm> h = rm.f;
    public static final ai<Boolean> i = ai.a("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", false);
    public static final ai<Boolean> j = ai.a("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", false);
    public static final Set<String> k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
    public static final b l = new a();
    public static final Set<ImageHeaderParser.ImageType> m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
    public static final Queue<BitmapFactory.Options> n = sq.a(0);
    public final ek a;
    public final DisplayMetrics b;
    public final ck c;
    public final List<ImageHeaderParser> d;
    public final xm e = xm.b();

    /* compiled from: Downsampler.java */
    /* renamed from: sm$a */
    /* loaded from: classes.dex */
    public class a implements b {
        @Override // defpackage.sm.b
        public void a() {
        }

        @Override // defpackage.sm.b
        public void a(ek ekVar, Bitmap bitmap) {
        }
    }

    /* compiled from: Downsampler.java */
    /* renamed from: sm$b */
    /* loaded from: classes.dex */
    public interface b {
        void a();

        void a(ek ekVar, Bitmap bitmap);
    }

    public sm(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, ek ekVar, ck ckVar) {
        this.d = list;
        defpackage.a.a(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        defpackage.a.a(ekVar, "Argument must not be null");
        this.a = ekVar;
        defpackage.a.a(ckVar, "Argument must not be null");
        this.c = ckVar;
    }

    public static boolean a(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static int b(double d) {
        return (int) (d + 0.5d);
    }

    public static int[] b(ym ymVar, BitmapFactory.Options options, b bVar, ek ekVar) {
        options.inJustDecodeBounds = true;
        a(ymVar, options, bVar, ekVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static synchronized BitmapFactory.Options d() {
        BitmapFactory.Options poll;
        synchronized (sm.class) {
            synchronized (n) {
                poll = n.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                b(poll);
            }
        }
        return poll;
    }

    public vj<Bitmap> a(InputStream inputStream, int i2, int i3, bi biVar, b bVar) {
        return a(new ym.a(inputStream, this.d, this.c), i2, i3, biVar, bVar);
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return true;
    }

    public boolean c() {
        int i2 = Build.VERSION.SDK_INT;
        return true;
    }

    public final vj<Bitmap> a(ym ymVar, int i2, int i3, bi biVar, b bVar) {
        byte[] bArr = (byte[]) ((jk) this.c).b(65536, byte[].class);
        BitmapFactory.Options d = d();
        d.inTempStorage = bArr;
        vh vhVar = (vh) biVar.a(f);
        ci ciVar = (ci) biVar.a(g);
        try {
            return km.a(a(ymVar, d, (rm) biVar.a(rm.f), vhVar, ciVar, biVar.a(j) != null && ((Boolean) biVar.a(j)).booleanValue(), i2, i3, ((Boolean) biVar.a(i)).booleanValue(), bVar), this.a);
        } finally {
            a(d);
            ((jk) this.c).a((jk) bArr);
        }
    }

    public static void b(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        int i2 = Build.VERSION.SDK_INT;
        options.inPreferredColorSpace = null;
        options.outColorSpace = null;
        options.outConfig = null;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0353 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0360  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0380  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0288  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap a(defpackage.ym r31, android.graphics.BitmapFactory.Options r32, defpackage.rm r33, defpackage.vh r34, defpackage.ci r35, boolean r36, int r37, int r38, boolean r39, defpackage.sm.b r40) {
        /*
            Method dump skipped, instructions count: 1106
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sm.a(ym, android.graphics.BitmapFactory$Options, rm, vh, ci, boolean, int, int, boolean, sm$b):android.graphics.Bitmap");
    }

    public static int a(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static Bitmap a(ym ymVar, BitmapFactory.Options options, b bVar, ek ekVar) {
        if (!options.inJustDecodeBounds) {
            bVar.a();
            ymVar.a();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        String str = options.outMimeType;
        fn.d.lock();
        try {
            try {
                Bitmap a2 = ymVar.a(options);
                fn.d.unlock();
                return a2;
            } catch (IllegalArgumentException e) {
                IOException a3 = a(e, i2, i3, str, options);
                if (Log.isLoggable("Downsampler", 3)) {
                    Log.d("Downsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a3);
                }
                Bitmap bitmap = options.inBitmap;
                if (bitmap != null) {
                    try {
                        ekVar.a(bitmap);
                        options.inBitmap = null;
                        Bitmap a4 = a(ymVar, options, bVar, ekVar);
                        fn.d.unlock();
                        return a4;
                    } catch (IOException unused) {
                        throw a3;
                    }
                }
                throw a3;
            }
        } catch (Throwable th) {
            fn.d.unlock();
            throw th;
        }
    }

    @TargetApi(19)
    public static String a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int i2 = Build.VERSION.SDK_INT;
        StringBuilder a2 = jg.a(" (");
        a2.append(bitmap.getAllocationByteCount());
        a2.append(")");
        String sb = a2.toString();
        StringBuilder a3 = jg.a("[");
        a3.append(bitmap.getWidth());
        a3.append("x");
        a3.append(bitmap.getHeight());
        a3.append("] ");
        a3.append(bitmap.getConfig());
        a3.append(sb);
        return a3.toString();
    }

    public static IOException a(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        StringBuilder a2 = jg.a("Exception decoding bitmap, outWidth: ", i2, ", outHeight: ", i3, ", outMimeType: ");
        a2.append(str);
        a2.append(", inBitmap: ");
        a2.append(a(options.inBitmap));
        return new IOException(a2.toString(), illegalArgumentException);
    }

    public static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (n) {
            n.offer(options);
        }
    }
}
