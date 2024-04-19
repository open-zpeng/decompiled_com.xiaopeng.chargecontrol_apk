package defpackage;

import android.os.Build;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/* compiled from: WebpHeaderParser.java */
/* renamed from: fh  reason: default package */
/* loaded from: classes.dex */
public class fh {
    public static final boolean a;

    /* compiled from: WebpHeaderParser.java */
    /* renamed from: fh$a */
    /* loaded from: classes.dex */
    public static final class a implements c {
        public final byte[] a;
        public final int b;
        public final int c;
        public int d;

        public a(byte[] bArr, int i, int i2) {
            this.a = bArr;
            this.b = i;
            this.c = i2;
            this.d = i;
        }

        @Override // defpackage.fh.c
        public int a() {
            return ((b() << 8) & 65280) | (b() & XLoadingDrawable.ALPHA_MAX);
        }

        @Override // defpackage.fh.c
        public int b() {
            int i = this.d;
            if (i >= this.b + this.c) {
                return -1;
            }
            byte[] bArr = this.a;
            this.d = i + 1;
            return bArr[i];
        }

        @Override // defpackage.fh.c
        public long a(long j) {
            int min = (int) Math.min((this.b + this.c) - this.d, j);
            this.d += min;
            return min;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    /* renamed from: fh$b */
    /* loaded from: classes.dex */
    public static final class b implements c {
        public final ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // defpackage.fh.c
        public int a() {
            return ((b() << 8) & 65280) | (b() & XLoadingDrawable.ALPHA_MAX);
        }

        @Override // defpackage.fh.c
        public int b() {
            if (this.a.remaining() < 1) {
                return -1;
            }
            return this.a.get();
        }

        @Override // defpackage.fh.c
        public long a(long j) {
            int min = (int) Math.min(this.a.remaining(), j);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    /* renamed from: fh$c */
    /* loaded from: classes.dex */
    public interface c {
        int a();

        long a(long j);

        int b();
    }

    /* compiled from: WebpHeaderParser.java */
    /* renamed from: fh$d */
    /* loaded from: classes.dex */
    public static final class d implements c {
        public final InputStream a;

        public d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // defpackage.fh.c
        public int a() {
            return ((this.a.read() << 8) & 65280) | (this.a.read() & XLoadingDrawable.ALPHA_MAX);
        }

        @Override // defpackage.fh.c
        public int b() {
            return this.a.read();
        }

        @Override // defpackage.fh.c
        public long a(long j) {
            if (j < 0) {
                return 0L;
            }
            long j2 = j;
            while (j2 > 0) {
                long skip = this.a.skip(j2);
                if (skip <= 0) {
                    if (this.a.read() == -1) {
                        break;
                    }
                    skip = 1;
                }
                j2 -= skip;
            }
            return j - j2;
        }
    }

    /* compiled from: WebpHeaderParser.java */
    /* renamed from: fh$e */
    /* loaded from: classes.dex */
    public enum e {
        WEBP_SIMPLE(false, false),
        WEBP_LOSSLESS(false, false),
        WEBP_LOSSLESS_WITH_ALPHA(true, false),
        WEBP_EXTENDED(false, false),
        WEBP_EXTENDED_WITH_ALPHA(true, false),
        WEBP_EXTENDED_ANIMATED(false, true),
        NONE_WEBP(false, false);

        e(boolean z, boolean z2) {
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        a = true;
    }

    public static boolean a(e eVar) {
        return eVar == e.WEBP_EXTENDED_ANIMATED;
    }

    public static boolean b(e eVar) {
        return eVar == e.WEBP_SIMPLE || eVar == e.WEBP_LOSSLESS || eVar == e.WEBP_LOSSLESS_WITH_ALPHA || eVar == e.WEBP_EXTENDED || eVar == e.WEBP_EXTENDED_WITH_ALPHA;
    }

    public static e a(InputStream inputStream, ck ckVar) {
        if (inputStream == null) {
            return e.NONE_WEBP;
        }
        if (!inputStream.markSupported()) {
            inputStream = new cn(inputStream, ckVar);
        }
        inputStream.mark(21);
        try {
            defpackage.a.a(inputStream, "Argument must not be null");
            return a(new d(inputStream));
        } finally {
            inputStream.reset();
        }
    }

    public static e a(ByteBuffer byteBuffer) {
        if (byteBuffer == null) {
            return e.NONE_WEBP;
        }
        defpackage.a.a(byteBuffer, "Argument must not be null");
        return a(new b(byteBuffer));
    }

    public static e a(byte[] bArr, int i, int i2) {
        return a(new a(bArr, i, i2));
    }

    public static e a(c cVar) {
        if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535)) != 1380533830) {
            return e.NONE_WEBP;
        }
        cVar.a(4L);
        if ((((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535)) != 1464156752) {
            return e.NONE_WEBP;
        }
        int a2 = ((cVar.a() << 16) & (-65536)) | (cVar.a() & 65535);
        if (a2 == 1448097824) {
            return e.WEBP_SIMPLE;
        }
        if (a2 == 1448097868) {
            cVar.a(4L);
            return (cVar.b() & 8) != 0 ? e.WEBP_LOSSLESS_WITH_ALPHA : e.WEBP_LOSSLESS;
        } else if (a2 == 1448097880) {
            cVar.a(4L);
            int b2 = cVar.b();
            if ((b2 & 2) != 0) {
                return e.WEBP_EXTENDED_ANIMATED;
            }
            if ((b2 & 16) != 0) {
                return e.WEBP_EXTENDED_WITH_ALPHA;
            }
            return e.WEBP_EXTENDED;
        } else {
            return e.NONE_WEBP;
        }
    }
}
