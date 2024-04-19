package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.Log;
import android.util.LruCache;
import com.bumptech.glide.integration.webp.WebpFrame;
import com.bumptech.glide.integration.webp.WebpImage;
import defpackage.sh;
import defpackage.zg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
/* compiled from: WebpDecoder.java */
/* renamed from: nh  reason: default package */
/* loaded from: classes.dex */
public class nh implements zg {
    public ByteBuffer a;
    public WebpImage b;
    public final zg.a c;
    public final int[] e;
    public final eh[] f;
    public int g;
    public int h;
    public int i;
    public final Paint j;
    public sh k;
    public final LruCache<Integer, Bitmap> m;
    public int d = -1;
    public Bitmap.Config l = Bitmap.Config.ARGB_8888;

    /* compiled from: WebpDecoder.java */
    /* renamed from: nh$a */
    /* loaded from: classes.dex */
    public class a extends LruCache<Integer, Bitmap> {
        public a(int i) {
            super(i);
        }

        @Override // android.util.LruCache
        public void entryRemoved(boolean z, Integer num, Bitmap bitmap, Bitmap bitmap2) {
            Bitmap bitmap3 = bitmap;
            if (bitmap3 != null) {
                ((tn) nh.this.c).a.a(bitmap3);
            }
        }
    }

    public nh(zg.a aVar, WebpImage webpImage, ByteBuffer byteBuffer, int i, sh shVar) {
        int max;
        this.c = aVar;
        this.b = webpImage;
        this.e = webpImage.getFrameDurations();
        this.f = new eh[webpImage.getFrameCount()];
        for (int i2 = 0; i2 < this.b.getFrameCount(); i2++) {
            this.f[i2] = this.b.getFrameInfo(i2);
            if (Log.isLoggable("WebpDecoder", 3)) {
                StringBuilder a2 = jg.a("mFrameInfos: ");
                a2.append(this.f[i2].toString());
                Log.d("WebpDecoder", a2.toString());
            }
        }
        this.k = shVar;
        this.j = new Paint();
        this.j.setColor(0);
        this.j.setStyle(Paint.Style.FILL);
        this.j.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        if (this.k.a == sh.c.CACHE_ALL) {
            max = webpImage.getFrameCount();
        } else {
            max = Math.max(5, this.k.b);
        }
        this.m = new a(max);
        new ArrayList();
        if (i > 0) {
            int highestOneBit = Integer.highestOneBit(i);
            this.a = byteBuffer.asReadOnlyBuffer();
            this.a.position(0);
            this.g = highestOneBit;
            this.i = this.b.getWidth() / highestOneBit;
            this.h = this.b.getHeight() / highestOneBit;
            return;
        }
        throw new IllegalArgumentException(jg.a("Sample size must be >=0, not: ", i));
    }

    @Override // defpackage.zg
    public int a() {
        return this.d;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x00a7, code lost:
        r4 = r4 + 1;
     */
    @Override // defpackage.zg
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.graphics.Bitmap b() {
        /*
            Method dump skipped, instructions count: 405
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nh.b():android.graphics.Bitmap");
    }

    @Override // defpackage.zg
    public void c() {
        this.d = (this.d + 1) % this.b.getFrameCount();
    }

    @Override // defpackage.zg
    public void clear() {
        this.b.dispose();
        this.b = null;
        this.m.evictAll();
        this.a = null;
    }

    @Override // defpackage.zg
    public int d() {
        return this.b.getFrameCount();
    }

    @Override // defpackage.zg
    public int e() {
        int i;
        int[] iArr = this.e;
        if (iArr.length == 0 || (i = this.d) < 0) {
            return 0;
        }
        if (i < 0 || i >= iArr.length) {
            return -1;
        }
        return iArr[i];
    }

    @Override // defpackage.zg
    public int f() {
        return this.b.getSizeInBytes();
    }

    @Override // defpackage.zg
    public void g() {
        this.d = -1;
    }

    @Override // defpackage.zg
    public ByteBuffer getData() {
        return this.a;
    }

    @Override // defpackage.zg
    public void a(Bitmap.Config config) {
        if (config == Bitmap.Config.ARGB_8888) {
            this.l = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + Bitmap.Config.ARGB_8888);
    }

    public final void a(int i, Canvas canvas) {
        eh ehVar = this.f[i];
        int i2 = ehVar.d;
        int i3 = this.g;
        int i4 = i2 / i3;
        int i5 = ehVar.e / i3;
        int i6 = ehVar.b / i3;
        int i7 = ehVar.c / i3;
        WebpFrame frame = this.b.getFrame(i);
        try {
            try {
                Bitmap a2 = ((tn) this.c).a(i4, i5, this.l);
                a2.eraseColor(0);
                a2.setDensity(canvas.getDensity());
                frame.renderFrame(i4, i5, a2);
                canvas.drawBitmap(a2, i6, i7, (Paint) null);
                ((tn) this.c).a.a(a2);
            } catch (IllegalStateException unused) {
                Log.e("WebpDecoder", "Rendering of frame failed. Frame number: " + i);
            }
        } finally {
            frame.dispose();
        }
    }

    public final void a(Canvas canvas, eh ehVar) {
        int i = ehVar.b;
        int i2 = this.g;
        int i3 = ehVar.c;
        canvas.drawRect(i / i2, i3 / i2, (i + ehVar.d) / i2, (i3 + ehVar.e) / i2, this.j);
    }

    public final boolean a(int i) {
        if (i == 0) {
            return true;
        }
        eh[] ehVarArr = this.f;
        eh ehVar = ehVarArr[i];
        eh ehVar2 = ehVarArr[i - 1];
        if (ehVar.g || !a(ehVar)) {
            return ehVar2.h && a(ehVar2);
        }
        return true;
    }

    public final boolean a(eh ehVar) {
        return ehVar.b == 0 && ehVar.c == 0 && ehVar.d == this.b.getWidth() && ehVar.e == this.b.getHeight();
    }
}
