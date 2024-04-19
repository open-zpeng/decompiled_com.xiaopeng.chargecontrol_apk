package defpackage;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.integration.webp.WebpBitmapFactory;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.fh;
import defpackage.sm;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* compiled from: WebpDownsampler.java */
/* renamed from: oh  reason: default package */
/* loaded from: classes.dex */
public final class oh {
    public static final ai<Boolean> e = ai.a("com.bumptech.glide.integration.webp.decoder.WebpDownsampler.DisableDecoder", false);
    public static final sm.b f = new a();
    public static final Queue<BitmapFactory.Options> g = sq.a(0);
    public final ek a;
    public final DisplayMetrics b;
    public final ck c;
    public final List<ImageHeaderParser> d;

    /* compiled from: WebpDownsampler.java */
    /* renamed from: oh$a */
    /* loaded from: classes.dex */
    public static class a implements sm.b {
        @Override // defpackage.sm.b
        public void a() {
        }

        @Override // defpackage.sm.b
        public void a(ek ekVar, Bitmap bitmap) {
        }
    }

    public oh(List<ImageHeaderParser> list, DisplayMetrics displayMetrics, ek ekVar, ck ckVar) {
        this.d = list;
        defpackage.a.a(displayMetrics, "Argument must not be null");
        this.b = displayMetrics;
        defpackage.a.a(ekVar, "Argument must not be null");
        this.a = ekVar;
        defpackage.a.a(ckVar, "Argument must not be null");
        this.c = ckVar;
    }

    public static int a(double d) {
        return (int) (d + 0.5d);
    }

    public static int[] b(InputStream inputStream, BitmapFactory.Options options, sm.b bVar, ek ekVar) {
        options.inJustDecodeBounds = true;
        a(inputStream, options, bVar, ekVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public boolean a(InputStream inputStream, bi biVar) {
        if (((Boolean) biVar.a(e)).booleanValue() || fh.a) {
            return false;
        }
        fh.e a2 = fh.a(inputStream, this.c);
        return fh.b(a2) && a2 != fh.e.WEBP_SIMPLE;
    }

    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        if (((Boolean) biVar.a(e)).booleanValue() || fh.a) {
            return false;
        }
        fh.e a2 = fh.a(byteBuffer);
        return fh.b(a2) && a2 != fh.e.WEBP_SIMPLE;
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
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public vj<Bitmap> a(InputStream inputStream, int i, int i2, bi biVar) {
        sm.b bVar = f;
        defpackage.a.a(inputStream.markSupported(), "You must provide an InputStream that supports mark()");
        byte[] bArr = (byte[]) ((jk) this.c).b(65536, byte[].class);
        BitmapFactory.Options a2 = a();
        a2.inTempStorage = bArr;
        vh vhVar = (vh) biVar.a(sm.f);
        try {
            return km.a(a(inputStream, a2, (rm) biVar.a(sm.h), vhVar, biVar.a(sm.j) != null && ((Boolean) biVar.a(sm.j)).booleanValue(), i, i2, ((Boolean) biVar.a(sm.i)).booleanValue(), bVar), this.a);
        } finally {
            a(a2);
            ((jk) this.c).a((jk) bArr, (Class<jk>) byte[].class);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.Bitmap a(java.io.InputStream r29, android.graphics.BitmapFactory.Options r30, defpackage.rm r31, defpackage.vh r32, boolean r33, int r34, int r35, boolean r36, defpackage.sm.b r37) {
        /*
            Method dump skipped, instructions count: 970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.oh.a(java.io.InputStream, android.graphics.BitmapFactory$Options, rm, vh, boolean, int, int, boolean, sm$b):android.graphics.Bitmap");
    }

    public static Bitmap a(InputStream inputStream, BitmapFactory.Options options, sm.b bVar, ek ekVar) {
        if (options.inJustDecodeBounds) {
            inputStream.mark(10485760);
        } else {
            bVar.a();
        }
        int i = options.outWidth;
        int i2 = options.outHeight;
        String str = options.outMimeType;
        fn.d.lock();
        try {
            try {
                Bitmap decodeStream = WebpBitmapFactory.decodeStream(inputStream, null, options);
                fn.d.unlock();
                if (options.inJustDecodeBounds) {
                    inputStream.reset();
                }
                return decodeStream;
            } catch (IllegalArgumentException e2) {
                IOException a2 = a(e2, i, i2, str, options);
                if (Log.isLoggable("WebpDownsampler", 3)) {
                    Log.d("WebpDownsampler", "Failed to decode with inBitmap, trying again without Bitmap re-use", a2);
                }
                if (options.inBitmap != null) {
                    try {
                        inputStream.reset();
                        ekVar.a(options.inBitmap);
                        options.inBitmap = null;
                        Bitmap a3 = a(inputStream, options, bVar, ekVar);
                        fn.d.unlock();
                        return a3;
                    } catch (IOException unused) {
                        throw a2;
                    }
                }
                throw a2;
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
        int i = Build.VERSION.SDK_INT;
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

    public static IOException a(IllegalArgumentException illegalArgumentException, int i, int i2, String str, BitmapFactory.Options options) {
        StringBuilder a2 = jg.a("Exception decoding bitmap, outWidth: ", i, ", outHeight: ", i2, ", outMimeType: ");
        a2.append(str);
        a2.append(", inBitmap: ");
        a2.append(a(options.inBitmap));
        return new IOException(a2.toString(), illegalArgumentException);
    }

    public static synchronized BitmapFactory.Options a() {
        BitmapFactory.Options poll;
        synchronized (oh.class) {
            synchronized (g) {
                poll = g.poll();
            }
            if (poll == null) {
                poll = new BitmapFactory.Options();
                b(poll);
            }
        }
        return poll;
    }

    public static void a(BitmapFactory.Options options) {
        b(options);
        synchronized (g) {
            g.offer(options);
        }
    }
}
