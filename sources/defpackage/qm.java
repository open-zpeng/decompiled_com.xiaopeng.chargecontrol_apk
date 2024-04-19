package defpackage;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
/* compiled from: DefaultImageHeaderParser.java */
/* renamed from: qm  reason: default package */
/* loaded from: classes.dex */
public final class qm implements ImageHeaderParser {
    public static final byte[] a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));
    public static final int[] b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: qm$a */
    /* loaded from: classes.dex */
    public static final class a implements c {
        public final ByteBuffer a;

        public a(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
            byteBuffer.order(ByteOrder.BIG_ENDIAN);
        }

        @Override // defpackage.qm.c
        public int a() {
            return (b() << 8) | b();
        }

        @Override // defpackage.qm.c
        public short b() {
            if (this.a.remaining() >= 1) {
                return (short) (this.a.get() & 255);
            }
            throw new c.a();
        }

        @Override // defpackage.qm.c
        public int a(byte[] bArr, int i) {
            int min = Math.min(i, this.a.remaining());
            if (min == 0) {
                return -1;
            }
            this.a.get(bArr, 0, min);
            return min;
        }

        @Override // defpackage.qm.c
        public long a(long j) {
            int min = (int) Math.min(this.a.remaining(), j);
            ByteBuffer byteBuffer = this.a;
            byteBuffer.position(byteBuffer.position() + min);
            return min;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: qm$b */
    /* loaded from: classes.dex */
    public static final class b {
        public final ByteBuffer a;

        public b(byte[] bArr, int i) {
            this.a = (ByteBuffer) ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN).limit(i);
        }

        public int a() {
            return this.a.remaining();
        }

        public int b(int i) {
            if (this.a.remaining() - i >= 4) {
                return this.a.getInt(i);
            }
            return -1;
        }

        public short a(int i) {
            if (this.a.remaining() - i >= 2) {
                return this.a.getShort(i);
            }
            return (short) -1;
        }
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: qm$c */
    /* loaded from: classes.dex */
    public interface c {

        /* compiled from: DefaultImageHeaderParser.java */
        /* renamed from: qm$c$a */
        /* loaded from: classes.dex */
        public static final class a extends IOException {
            public a() {
                super("Unexpectedly reached end of a file");
            }
        }

        int a();

        int a(byte[] bArr, int i);

        long a(long j);

        short b();
    }

    /* compiled from: DefaultImageHeaderParser.java */
    /* renamed from: qm$d */
    /* loaded from: classes.dex */
    public static final class d implements c {
        public final InputStream a;

        public d(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // defpackage.qm.c
        public int a() {
            return (b() << 8) | b();
        }

        @Override // defpackage.qm.c
        public short b() {
            int read = this.a.read();
            if (read != -1) {
                return (short) read;
            }
            throw new c.a();
        }

        @Override // defpackage.qm.c
        public int a(byte[] bArr, int i) {
            int i2 = 0;
            int i3 = 0;
            while (i2 < i && (i3 = this.a.read(bArr, i2, i - i2)) != -1) {
                i2 += i3;
            }
            if (i2 == 0 && i3 == -1) {
                throw new c.a();
            }
            return i2;
        }

        @Override // defpackage.qm.c
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

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(InputStream inputStream) {
        defpackage.a.a(inputStream, "Argument must not be null");
        return a(new d(inputStream));
    }

    public final int b(c cVar) {
        short b2;
        short b3;
        int a2;
        long j;
        long a3;
        do {
            if (cVar.b() != 255) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown segmentId=" + ((int) b2));
                }
                return -1;
            }
            b3 = cVar.b();
            if (b3 == 218) {
                return -1;
            }
            if (b3 == 217) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Found MARKER_EOI in exif segment");
                }
                return -1;
            }
            a2 = cVar.a() - 2;
            if (b3 == 225) {
                return a2;
            }
            j = a2;
            a3 = cVar.a(j);
        } while (a3 == j);
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            StringBuilder a4 = jg.a("Unable to skip enough data, type: ", b3, ", wanted to skip: ", a2, ", but actually skipped: ");
            a4.append(a3);
            Log.d("DfltImageHeaderParser", a4.toString());
        }
        return -1;
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public ImageHeaderParser.ImageType a(ByteBuffer byteBuffer) {
        defpackage.a.a(byteBuffer, "Argument must not be null");
        return a(new a(byteBuffer));
    }

    @Override // com.bumptech.glide.load.ImageHeaderParser
    public int a(InputStream inputStream, ck ckVar) {
        defpackage.a.a(inputStream, "Argument must not be null");
        d dVar = new d(inputStream);
        defpackage.a.a(ckVar, "Argument must not be null");
        int i = -1;
        try {
            int a2 = dVar.a();
            if (!((a2 & 65496) == 65496 || a2 == 19789 || a2 == 18761)) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Parser doesn't handle magic number: " + a2);
                }
            } else {
                int b2 = b(dVar);
                if (b2 == -1) {
                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Failed to parse exif segment length, or exif segment not found");
                    }
                } else {
                    jk jkVar = (jk) ckVar;
                    byte[] bArr = (byte[]) jkVar.b(b2, byte[].class);
                    int a3 = a(dVar, bArr, b2);
                    jkVar.a((jk) bArr);
                    i = a3;
                }
            }
        } catch (c.a unused) {
        }
        return i;
    }

    public final ImageHeaderParser.ImageType a(c cVar) {
        try {
            int a2 = cVar.a();
            if (a2 == 65496) {
                return ImageHeaderParser.ImageType.JPEG;
            }
            int b2 = (a2 << 8) | cVar.b();
            if (b2 == 4671814) {
                return ImageHeaderParser.ImageType.GIF;
            }
            int b3 = (b2 << 8) | cVar.b();
            if (b3 == -1991225785) {
                cVar.a(21L);
                try {
                    return cVar.b() >= 3 ? ImageHeaderParser.ImageType.PNG_A : ImageHeaderParser.ImageType.PNG;
                } catch (c.a unused) {
                    return ImageHeaderParser.ImageType.PNG;
                }
            } else if (b3 != 1380533830) {
                return ImageHeaderParser.ImageType.UNKNOWN;
            } else {
                cVar.a(4L);
                if (((cVar.a() << 16) | cVar.a()) != 1464156752) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int a3 = (cVar.a() << 16) | cVar.a();
                if ((a3 & (-256)) != 1448097792) {
                    return ImageHeaderParser.ImageType.UNKNOWN;
                }
                int i = a3 & XLoadingDrawable.ALPHA_MAX;
                if (i == 88) {
                    cVar.a(4L);
                    return (cVar.b() & 16) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else if (i == 76) {
                    cVar.a(4L);
                    return (cVar.b() & 8) != 0 ? ImageHeaderParser.ImageType.WEBP_A : ImageHeaderParser.ImageType.WEBP;
                } else {
                    return ImageHeaderParser.ImageType.WEBP;
                }
            }
        } catch (c.a unused2) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    public final int a(c cVar, byte[] bArr, int i) {
        ByteOrder byteOrder;
        int a2 = cVar.a(bArr, i);
        if (a2 != i) {
            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                Log.d("DfltImageHeaderParser", "Unable to read exif segment data, length: " + i + ", actually read: " + a2);
            }
            return -1;
        }
        boolean z = bArr != null && i > a.length;
        if (z) {
            int i2 = 0;
            while (true) {
                byte[] bArr2 = a;
                if (i2 >= bArr2.length) {
                    break;
                } else if (bArr[i2] != bArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
        }
        if (z) {
            b bVar = new b(bArr, i);
            short a3 = bVar.a(6);
            if (a3 == 18761) {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            } else if (a3 != 19789) {
                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                    Log.d("DfltImageHeaderParser", "Unknown endianness = " + ((int) a3));
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.BIG_ENDIAN;
            }
            bVar.a.order(byteOrder);
            int b2 = bVar.b(10) + 6;
            short a4 = bVar.a(b2);
            for (int i3 = 0; i3 < a4; i3++) {
                int i4 = (i3 * 12) + b2 + 2;
                short a5 = bVar.a(i4);
                if (a5 == 274) {
                    short a6 = bVar.a(i4 + 2);
                    if (a6 >= 1 && a6 <= 12) {
                        int b3 = bVar.b(i4 + 4);
                        if (b3 < 0) {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                Log.d("DfltImageHeaderParser", "Negative tiff component count");
                            }
                        } else {
                            if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                StringBuilder a7 = jg.a("Got tagIndex=", i3, " tagType=", a5, " formatCode=");
                                a7.append((int) a6);
                                a7.append(" componentCount=");
                                a7.append(b3);
                                Log.d("DfltImageHeaderParser", a7.toString());
                            }
                            int i5 = b3 + b[a6];
                            if (i5 > 4) {
                                if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Got byte count > 4, not orientation, continuing, formatCode=" + ((int) a6));
                                }
                            } else {
                                int i6 = i4 + 8;
                                if (i6 >= 0 && i6 <= bVar.a()) {
                                    if (i5 >= 0 && i5 + i6 <= bVar.a()) {
                                        return bVar.a(i6);
                                    }
                                    if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                        Log.d("DfltImageHeaderParser", "Illegal number of bytes for TI tag data tagType=" + ((int) a5));
                                    }
                                } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                                    Log.d("DfltImageHeaderParser", "Illegal tagValueOffset=" + i6 + " tagType=" + ((int) a5));
                                }
                            }
                        }
                    } else if (Log.isLoggable("DfltImageHeaderParser", 3)) {
                        Log.d("DfltImageHeaderParser", "Got invalid format code = " + ((int) a6));
                    }
                }
            }
            return -1;
        }
        if (Log.isLoggable("DfltImageHeaderParser", 3)) {
            Log.d("DfltImageHeaderParser", "Missing jpeg exif preamble");
        }
        return -1;
    }
}
