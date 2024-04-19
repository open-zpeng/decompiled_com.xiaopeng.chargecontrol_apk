package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IRadioController;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
/* compiled from: ExifInterface.java */
/* renamed from: kb  reason: default package */
/* loaded from: classes.dex */
public class kb {
    public static final c A;
    public static final c[] B;
    public static final c[] C;
    public static final c[] D;
    public static final c[] E;
    public static final c[][] F;
    public static final c[] G;
    public static final HashMap<Integer, c>[] H;
    public static final HashMap<String, c>[] I;
    public static final HashSet<String> J;
    public static final HashMap<Integer, Integer> K;
    public static final Charset L;
    public static final byte[] M;
    public static final int[] m;
    public static final int[] n;
    public static final byte[] o;
    public static final byte[] p;
    public static final byte[] q;
    public static SimpleDateFormat r;
    public static final String[] s;
    public static final int[] t;
    public static final byte[] u;
    public static final c[] v;
    public static final c[] w;
    public static final c[] x;
    public static final c[] y;
    public static final c[] z;
    public final String a;
    public final AssetManager.AssetInputStream b;
    public int c;
    public final HashMap<String, b>[] d;
    public Set<Integer> e;
    public ByteOrder f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;

    /* compiled from: ExifInterface.java */
    /* renamed from: kb$d */
    /* loaded from: classes.dex */
    public static class d {
        public final long a;
        public final long b;

        public d(long j, long j2) {
            if (j2 == 0) {
                this.a = 0L;
                this.b = 1L;
                return;
            }
            this.a = j;
            this.b = j2;
        }

        public String toString() {
            return this.a + "/" + this.b;
        }
    }

    static {
        c[] cVarArr;
        Arrays.asList(1, 6, 3, 8);
        Arrays.asList(2, 7, 4, 5);
        m = new int[]{8, 8, 8};
        new int[1][0] = 4;
        n = new int[]{8};
        o = new byte[]{-1, -40, -1};
        p = new byte[]{79, 76, 89, 77, 80, 0};
        q = new byte[]{79, 76, 89, 77, 80, 85, 83, 0, 73, 73};
        s = new String[]{"", "BYTE", "STRING", "USHORT", "ULONG", "URATIONAL", "SBYTE", "UNDEFINED", "SSHORT", "SLONG", "SRATIONAL", "SINGLE", "DOUBLE"};
        t = new int[]{0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8, 1};
        u = new byte[]{65, 83, 67, 73, 73, 0, 0, 0};
        v = new c[]{new c("NewSubfileType", 254, 4), new c("SubfileType", XLoadingDrawable.ALPHA_MAX, 4), new c("ImageWidth", IRadioController.TEF663x_PCHANNEL, 3, 4), new c("ImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("SensorTopBorder", 4, 4), new c("SensorLeftBorder", 5, 4), new c("SensorBottomBorder", 6, 4), new c("SensorRightBorder", 7, 4), new c("ISO", 23, 3), new c("JpgFromRaw", 46, 7)};
        w = new c[]{new c("ExposureTime", 33434, 5), new c("FNumber", 33437, 5), new c("ExposureProgram", 34850, 3), new c("SpectralSensitivity", 34852, 2), new c("PhotographicSensitivity", 34855, 3), new c("OECF", 34856, 7), new c("ExifVersion", 36864, 2), new c("DateTimeOriginal", 36867, 2), new c("DateTimeDigitized", 36868, 2), new c("ComponentsConfiguration", 37121, 7), new c("CompressedBitsPerPixel", 37122, 5), new c("ShutterSpeedValue", 37377, 10), new c("ApertureValue", 37378, 5), new c("BrightnessValue", 37379, 10), new c("ExposureBiasValue", 37380, 10), new c("MaxApertureValue", 37381, 5), new c("SubjectDistance", 37382, 5), new c("MeteringMode", 37383, 3), new c("LightSource", 37384, 3), new c("Flash", 37385, 3), new c("FocalLength", 37386, 5), new c("SubjectArea", 37396, 3), new c("MakerNote", 37500, 7), new c("UserComment", 37510, 7), new c("SubSecTime", 37520, 2), new c("SubSecTimeOriginal", 37521, 2), new c("SubSecTimeDigitized", 37522, 2), new c("FlashpixVersion", 40960, 7), new c("ColorSpace", 40961, 3), new c("PixelXDimension", 40962, 3, 4), new c("PixelYDimension", 40963, 3, 4), new c("RelatedSoundFile", 40964, 2), new c("InteroperabilityIFDPointer", 40965, 4), new c("FlashEnergy", 41483, 5), new c("SpatialFrequencyResponse", 41484, 7), new c("FocalPlaneXResolution", 41486, 5), new c("FocalPlaneYResolution", 41487, 5), new c("FocalPlaneResolutionUnit", 41488, 3), new c("SubjectLocation", 41492, 3), new c("ExposureIndex", 41493, 5), new c("SensingMethod", 41495, 3), new c("FileSource", 41728, 7), new c("SceneType", 41729, 7), new c("CFAPattern", 41730, 7), new c("CustomRendered", 41985, 3), new c("ExposureMode", 41986, 3), new c("WhiteBalance", 41987, 3), new c("DigitalZoomRatio", 41988, 5), new c("FocalLengthIn35mmFilm", 41989, 3), new c("SceneCaptureType", 41990, 3), new c("GainControl", 41991, 3), new c("Contrast", 41992, 3), new c("Saturation", 41993, 3), new c("Sharpness", 41994, 3), new c("DeviceSettingDescription", 41995, 7), new c("SubjectDistanceRange", 41996, 3), new c("ImageUniqueID", 42016, 2), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        x = new c[]{new c("GPSVersionID", 0, 1), new c("GPSLatitudeRef", 1, 2), new c("GPSLatitude", 2, 5), new c("GPSLongitudeRef", 3, 2), new c("GPSLongitude", 4, 5), new c("GPSAltitudeRef", 5, 1), new c("GPSAltitude", 6, 5), new c("GPSTimeStamp", 7, 5), new c("GPSSatellites", 8, 2), new c("GPSStatus", 9, 2), new c("GPSMeasureMode", 10, 2), new c("GPSDOP", 11, 5), new c("GPSSpeedRef", 12, 2), new c("GPSSpeed", 13, 5), new c("GPSTrackRef", 14, 2), new c("GPSTrack", 15, 5), new c("GPSImgDirectionRef", 16, 2), new c("GPSImgDirection", 17, 5), new c("GPSMapDatum", 18, 2), new c("GPSDestLatitudeRef", 19, 2), new c("GPSDestLatitude", 20, 5), new c("GPSDestLongitudeRef", 21, 2), new c("GPSDestLongitude", 22, 5), new c("GPSDestBearingRef", 23, 2), new c("GPSDestBearing", 24, 5), new c("GPSDestDistanceRef", 25, 2), new c("GPSDestDistance", 26, 5), new c("GPSProcessingMethod", 27, 7), new c("GPSAreaInformation", 28, 7), new c("GPSDateStamp", 29, 2), new c("GPSDifferential", 30, 3)};
        y = new c[]{new c("InteroperabilityIndex", 1, 2)};
        z = new c[]{new c("NewSubfileType", 254, 4), new c("SubfileType", XLoadingDrawable.ALPHA_MAX, 4), new c("ThumbnailImageWidth", IRadioController.TEF663x_PCHANNEL, 3, 4), new c("ThumbnailImageLength", 257, 3, 4), new c("BitsPerSample", 258, 3), new c("Compression", 259, 3), new c("PhotometricInterpretation", 262, 3), new c("ImageDescription", 270, 2), new c("Make", 271, 2), new c("Model", 272, 2), new c("StripOffsets", 273, 3, 4), new c("Orientation", 274, 3), new c("SamplesPerPixel", 277, 3), new c("RowsPerStrip", 278, 3, 4), new c("StripByteCounts", 279, 3, 4), new c("XResolution", 282, 5), new c("YResolution", 283, 5), new c("PlanarConfiguration", 284, 3), new c("ResolutionUnit", 296, 3), new c("TransferFunction", 301, 3), new c("Software", 305, 2), new c("DateTime", 306, 2), new c("Artist", 315, 2), new c("WhitePoint", 318, 5), new c("PrimaryChromaticities", 319, 5), new c("SubIFDPointer", 330, 4), new c("JPEGInterchangeFormat", 513, 4), new c("JPEGInterchangeFormatLength", 514, 4), new c("YCbCrCoefficients", 529, 5), new c("YCbCrSubSampling", 530, 3), new c("YCbCrPositioning", 531, 3), new c("ReferenceBlackWhite", 532, 5), new c("Copyright", 33432, 2), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("DNGVersion", 50706, 1), new c("DefaultCropSize", 50720, 3, 4)};
        A = new c("StripOffsets", 273, 3);
        B = new c[]{new c("ThumbnailImage", IRadioController.TEF663x_PCHANNEL, 7), new c("CameraSettingsIFDPointer", 8224, 4), new c("ImageProcessingIFDPointer", 8256, 4)};
        C = new c[]{new c("PreviewImageStart", 257, 4), new c("PreviewImageLength", 258, 4)};
        D = new c[]{new c("AspectFrame", 4371, 3)};
        E = new c[]{new c("ColorSpace", 55, 3)};
        c[] cVarArr2 = v;
        F = new c[][]{cVarArr2, w, x, y, z, cVarArr2, B, C, D, E};
        G = new c[]{new c("SubIFDPointer", 330, 4), new c("ExifIFDPointer", 34665, 4), new c("GPSInfoIFDPointer", 34853, 4), new c("InteroperabilityIFDPointer", 40965, 4), new c("CameraSettingsIFDPointer", 8224, 1), new c("ImageProcessingIFDPointer", 8256, 1)};
        c[][] cVarArr3 = F;
        H = new HashMap[cVarArr3.length];
        I = new HashMap[cVarArr3.length];
        J = new HashSet<>(Arrays.asList("FNumber", "DigitalZoomRatio", "ExposureTime", "SubjectDistance", "GPSTimeStamp"));
        K = new HashMap<>();
        L = Charset.forName("US-ASCII");
        M = "Exif\u0000\u0000".getBytes(L);
        r = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
        r.setTimeZone(TimeZone.getTimeZone("UTC"));
        for (int i = 0; i < F.length; i++) {
            H[i] = new HashMap<>();
            I[i] = new HashMap<>();
            for (c cVar : F[i]) {
                H[i].put(Integer.valueOf(cVar.a), cVar);
                I[i].put(cVar.b, cVar);
            }
        }
        K.put(Integer.valueOf(G[0].a), 5);
        K.put(Integer.valueOf(G[1].a), 1);
        K.put(Integer.valueOf(G[2].a), 2);
        K.put(Integer.valueOf(G[3].a), 3);
        K.put(Integer.valueOf(G[4].a), 7);
        K.put(Integer.valueOf(G[5].a), 8);
        Pattern.compile(".*[1-9].*");
        Pattern.compile("^([0-9][0-9]):([0-9][0-9]):([0-9][0-9])$");
    }

    public kb(InputStream inputStream) {
        c[][] cVarArr = F;
        this.d = new HashMap[cVarArr.length];
        this.e = new HashSet(cVarArr.length);
        this.f = ByteOrder.BIG_ENDIAN;
        if (inputStream != null) {
            this.a = null;
            if (inputStream instanceof AssetManager.AssetInputStream) {
                this.b = (AssetManager.AssetInputStream) inputStream;
            } else {
                this.b = null;
            }
            for (int i = 0; i < F.length; i++) {
                try {
                    this.d[i] = new HashMap<>();
                } catch (IOException unused) {
                } catch (Throwable th) {
                    a();
                    throw th;
                }
            }
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 5000);
            this.c = a(bufferedInputStream);
            a aVar = new a(bufferedInputStream);
            switch (this.c) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 5:
                case 6:
                case 8:
                case 11:
                    c(aVar);
                    break;
                case 4:
                    a(aVar, 0, 0);
                    break;
                case 7:
                    a(aVar);
                    break;
                case 9:
                    b(aVar);
                    break;
                case 10:
                    d(aVar);
                    break;
            }
            f(aVar);
            a();
            return;
        }
        throw new IllegalArgumentException("inputStream cannot be null");
    }

    public String a(String str) {
        b b2 = b(str);
        if (b2 != null) {
            if (!J.contains(str)) {
                return b2.c(this.f);
            }
            if (str.equals("GPSTimeStamp")) {
                int i = b2.a;
                if (i != 5 && i != 10) {
                    StringBuilder a2 = jg.a("GPS Timestamp format is not rational. format=");
                    a2.append(b2.a);
                    Log.w("ExifInterface", a2.toString());
                    return null;
                }
                d[] dVarArr = (d[]) b2.d(this.f);
                if (dVarArr != null && dVarArr.length == 3) {
                    return String.format("%02d:%02d:%02d", Integer.valueOf((int) (((float) dVarArr[0].a) / ((float) dVarArr[0].b))), Integer.valueOf((int) (((float) dVarArr[1].a) / ((float) dVarArr[1].b))), Integer.valueOf((int) (((float) dVarArr[2].a) / ((float) dVarArr[2].b))));
                }
                StringBuilder a3 = jg.a("Invalid GPS Timestamp array. array=");
                a3.append(Arrays.toString(dVarArr));
                Log.w("ExifInterface", a3.toString());
                return null;
            }
            try {
                return Double.toString(b2.a(this.f));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public final b b(String str) {
        if ("ISOSpeedRatings".equals(str)) {
            str = "PhotographicSensitivity";
        }
        for (int i = 0; i < F.length; i++) {
            b bVar = this.d[i].get(str);
            if (bVar != null) {
                return bVar;
            }
        }
        return null;
    }

    public final void c(a aVar) {
        b bVar;
        a(aVar, aVar.available());
        b(aVar, 0);
        c(aVar, 0);
        c(aVar, 5);
        c(aVar, 4);
        a(0, 5);
        a(0, 4);
        a(5, 4);
        b bVar2 = this.d[1].get("PixelXDimension");
        b bVar3 = this.d[1].get("PixelYDimension");
        if (bVar2 != null && bVar3 != null) {
            this.d[0].put("ImageWidth", bVar2);
            this.d[0].put("ImageLength", bVar3);
        }
        if (this.d[4].isEmpty() && a((HashMap) this.d[5])) {
            HashMap<String, b>[] hashMapArr = this.d;
            hashMapArr[4] = hashMapArr[5];
            hashMapArr[5] = new HashMap<>();
        }
        if (!a((HashMap) this.d[4])) {
            Log.d("ExifInterface", "No image meets the size requirements of a thumbnail image.");
        }
        if (this.c != 8 || (bVar = this.d[1].get("MakerNote")) == null) {
            return;
        }
        a aVar2 = new a(bVar.c);
        aVar2.d = this.f;
        aVar2.a(6L);
        b(aVar2, 9);
        b bVar4 = this.d[9].get("ColorSpace");
        if (bVar4 != null) {
            this.d[1].put("ColorSpace", bVar4);
        }
    }

    public final void d(a aVar) {
        c(aVar);
        if (this.d[0].get("JpgFromRaw") != null) {
            a(aVar, this.l, 5);
        }
        b bVar = this.d[0].get("ISO");
        b bVar2 = this.d[1].get("PhotographicSensitivity");
        if (bVar == null || bVar2 != null) {
            return;
        }
        this.d[1].put("PhotographicSensitivity", bVar);
    }

    public final ByteOrder e(a aVar) {
        short readShort = aVar.readShort();
        if (readShort != 18761) {
            if (readShort == 19789) {
                return ByteOrder.BIG_ENDIAN;
            }
            StringBuilder a2 = jg.a("Invalid byte order: ");
            a2.append(Integer.toHexString(readShort));
            throw new IOException(a2.toString());
        }
        return ByteOrder.LITTLE_ENDIAN;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0062, code lost:
        if (java.util.Arrays.equals(r1, defpackage.kb.n) != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x006c, code lost:
        if (java.util.Arrays.equals(r1, defpackage.kb.m) != false) goto L27;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(defpackage.kb.a r13) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kb.f(kb$a):void");
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: kb$a */
    /* loaded from: classes.dex */
    public static class a extends InputStream implements DataInput {
        public static final ByteOrder g = ByteOrder.LITTLE_ENDIAN;
        public static final ByteOrder h = ByteOrder.BIG_ENDIAN;
        public DataInputStream c;
        public ByteOrder d;
        public final int e;
        public int f;

        public a(InputStream inputStream) {
            this.d = ByteOrder.BIG_ENDIAN;
            this.c = new DataInputStream(inputStream);
            this.e = this.c.available();
            this.f = 0;
            this.c.mark(this.e);
        }

        public void a(long j) {
            int i = this.f;
            if (i > j) {
                this.f = 0;
                this.c.reset();
                this.c.mark(this.e);
            } else {
                j -= i;
            }
            int i2 = (int) j;
            if (skipBytes(i2) != i2) {
                throw new IOException("Couldn't seek up to the byteCount");
            }
        }

        @Override // java.io.InputStream
        public int available() {
            return this.c.available();
        }

        @Override // java.io.InputStream
        public int read() {
            this.f++;
            return this.c.read();
        }

        @Override // java.io.DataInput
        public boolean readBoolean() {
            this.f++;
            return this.c.readBoolean();
        }

        @Override // java.io.DataInput
        public byte readByte() {
            this.f++;
            if (this.f <= this.e) {
                int read = this.c.read();
                if (read >= 0) {
                    return (byte) read;
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public char readChar() {
            this.f += 2;
            return this.c.readChar();
        }

        @Override // java.io.DataInput
        public double readDouble() {
            return Double.longBitsToDouble(readLong());
        }

        @Override // java.io.DataInput
        public float readFloat() {
            return Float.intBitsToFloat(readInt());
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr, int i, int i2) {
            this.f += i2;
            if (this.f <= this.e) {
                if (this.c.read(bArr, i, i2) != i2) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int readInt() {
            this.f += 4;
            if (this.f <= this.e) {
                int read = this.c.read();
                int read2 = this.c.read();
                int read3 = this.c.read();
                int read4 = this.c.read();
                if ((read | read2 | read3 | read4) >= 0) {
                    ByteOrder byteOrder = this.d;
                    if (byteOrder == g) {
                        return (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == h) {
                        return (read << 24) + (read2 << 16) + (read3 << 8) + read4;
                    }
                    StringBuilder a = jg.a("Invalid byte order: ");
                    a.append(this.d);
                    throw new IOException(a.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readLine() {
            Log.d("ExifInterface", "Currently unsupported");
            return null;
        }

        @Override // java.io.DataInput
        public long readLong() {
            this.f += 8;
            if (this.f <= this.e) {
                int read = this.c.read();
                int read2 = this.c.read();
                int read3 = this.c.read();
                int read4 = this.c.read();
                int read5 = this.c.read();
                int read6 = this.c.read();
                int read7 = this.c.read();
                int read8 = this.c.read();
                if ((read | read2 | read3 | read4 | read5 | read6 | read7 | read8) >= 0) {
                    ByteOrder byteOrder = this.d;
                    if (byteOrder == g) {
                        return (read8 << 56) + (read7 << 48) + (read6 << 40) + (read5 << 32) + (read4 << 24) + (read3 << 16) + (read2 << 8) + read;
                    }
                    if (byteOrder == h) {
                        return (read << 56) + (read2 << 48) + (read3 << 40) + (read4 << 32) + (read5 << 24) + (read6 << 16) + (read7 << 8) + read8;
                    }
                    StringBuilder a = jg.a("Invalid byte order: ");
                    a.append(this.d);
                    throw new IOException(a.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public short readShort() {
            this.f += 2;
            if (this.f <= this.e) {
                int read = this.c.read();
                int read2 = this.c.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.d;
                    if (byteOrder == g) {
                        return (short) ((read2 << 8) + read);
                    }
                    if (byteOrder == h) {
                        return (short) ((read << 8) + read2);
                    }
                    StringBuilder a = jg.a("Invalid byte order: ");
                    a.append(this.d);
                    throw new IOException(a.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public String readUTF() {
            this.f += 2;
            return this.c.readUTF();
        }

        @Override // java.io.DataInput
        public int readUnsignedByte() {
            this.f++;
            return this.c.readUnsignedByte();
        }

        @Override // java.io.DataInput
        public int readUnsignedShort() {
            this.f += 2;
            if (this.f <= this.e) {
                int read = this.c.read();
                int read2 = this.c.read();
                if ((read | read2) >= 0) {
                    ByteOrder byteOrder = this.d;
                    if (byteOrder == g) {
                        return (read2 << 8) + read;
                    }
                    if (byteOrder == h) {
                        return (read << 8) + read2;
                    }
                    StringBuilder a = jg.a("Invalid byte order: ");
                    a.append(this.d);
                    throw new IOException(a.toString());
                }
                throw new EOFException();
            }
            throw new EOFException();
        }

        @Override // java.io.DataInput
        public int skipBytes(int i) {
            int min = Math.min(i, this.e - this.f);
            int i2 = 0;
            while (i2 < min) {
                i2 += this.c.skipBytes(min - i2);
            }
            this.f += i2;
            return i2;
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            int read = this.c.read(bArr, i, i2);
            this.f += read;
            return read;
        }

        @Override // java.io.DataInput
        public void readFully(byte[] bArr) {
            this.f += bArr.length;
            if (this.f <= this.e) {
                if (this.c.read(bArr, 0, bArr.length) != bArr.length) {
                    throw new IOException("Couldn't read up to the length of buffer");
                }
                return;
            }
            throw new EOFException();
        }

        public a(byte[] bArr) {
            this(new ByteArrayInputStream(bArr));
        }

        public long a() {
            return readInt() & 4294967295L;
        }
    }

    public final void b(a aVar) {
        aVar.skipBytes(84);
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[4];
        aVar.read(bArr);
        aVar.skipBytes(4);
        aVar.read(bArr2);
        int i = ByteBuffer.wrap(bArr).getInt();
        int i2 = ByteBuffer.wrap(bArr2).getInt();
        a(aVar, i, 5);
        aVar.a(i2);
        aVar.d = ByteOrder.BIG_ENDIAN;
        int readInt = aVar.readInt();
        for (int i3 = 0; i3 < readInt; i3++) {
            int readUnsignedShort = aVar.readUnsignedShort();
            int readUnsignedShort2 = aVar.readUnsignedShort();
            if (readUnsignedShort == A.a) {
                short readShort = aVar.readShort();
                short readShort2 = aVar.readShort();
                b a2 = b.a((int) readShort, this.f);
                b a3 = b.a((int) readShort2, this.f);
                this.d[0].put("ImageLength", a2);
                this.d[0].put("ImageWidth", a3);
                return;
            }
            aVar.skipBytes(readUnsignedShort2);
        }
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: kb$b */
    /* loaded from: classes.dex */
    public static class b {
        public final int a;
        public final int b;
        public final byte[] c;

        public b(int i, int i2, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = bArr;
        }

        public static b a(int i, ByteOrder byteOrder) {
            int[] iArr = {i};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[kb.t[3] * iArr.length]);
            wrap.order(byteOrder);
            for (int i2 : iArr) {
                wrap.putShort((short) i2);
            }
            return new b(3, iArr.length, wrap.array());
        }

        public int b(ByteOrder byteOrder) {
            Object d = d(byteOrder);
            if (d != null) {
                if (d instanceof String) {
                    return Integer.parseInt((String) d);
                }
                if (d instanceof long[]) {
                    long[] jArr = (long[]) d;
                    if (jArr.length == 1) {
                        return (int) jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof int[]) {
                    int[] iArr = (int[]) d;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a integer value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a integer value");
        }

        public String c(ByteOrder byteOrder) {
            Object d = d(byteOrder);
            if (d == null) {
                return null;
            }
            if (d instanceof String) {
                return (String) d;
            }
            StringBuilder sb = new StringBuilder();
            int i = 0;
            if (d instanceof long[]) {
                long[] jArr = (long[]) d;
                while (i < jArr.length) {
                    sb.append(jArr[i]);
                    i++;
                    if (i != jArr.length) {
                        sb.append(CFCHelper.SIGNAL_CFC_SPLIT);
                    }
                }
                return sb.toString();
            } else if (d instanceof int[]) {
                int[] iArr = (int[]) d;
                while (i < iArr.length) {
                    sb.append(iArr[i]);
                    i++;
                    if (i != iArr.length) {
                        sb.append(CFCHelper.SIGNAL_CFC_SPLIT);
                    }
                }
                return sb.toString();
            } else if (d instanceof double[]) {
                double[] dArr = (double[]) d;
                while (i < dArr.length) {
                    sb.append(dArr[i]);
                    i++;
                    if (i != dArr.length) {
                        sb.append(CFCHelper.SIGNAL_CFC_SPLIT);
                    }
                }
                return sb.toString();
            } else if (d instanceof d[]) {
                d[] dVarArr = (d[]) d;
                while (i < dVarArr.length) {
                    sb.append(dVarArr[i].a);
                    sb.append('/');
                    sb.append(dVarArr[i].b);
                    i++;
                    if (i != dVarArr.length) {
                        sb.append(CFCHelper.SIGNAL_CFC_SPLIT);
                    }
                }
                return sb.toString();
            } else {
                return null;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:164:0x01aa A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object d(java.nio.ByteOrder r11) {
            /*
                Method dump skipped, instructions count: 464
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.kb.b.d(java.nio.ByteOrder):java.lang.Object");
        }

        public String toString() {
            StringBuilder a = jg.a("(");
            a.append(kb.s[this.a]);
            a.append(", data length:");
            a.append(this.c.length);
            a.append(")");
            return a.toString();
        }

        public static b a(long j, ByteOrder byteOrder) {
            long[] jArr = {j};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[kb.t[4] * jArr.length]);
            wrap.order(byteOrder);
            for (long j2 : jArr) {
                wrap.putInt((int) j2);
            }
            return new b(4, jArr.length, wrap.array());
        }

        public static b a(String str) {
            byte[] bytes = (str + (char) 0).getBytes(kb.L);
            return new b(2, bytes.length, bytes);
        }

        public static b a(d dVar, ByteOrder byteOrder) {
            d[] dVarArr = {dVar};
            ByteBuffer wrap = ByteBuffer.wrap(new byte[kb.t[5] * dVarArr.length]);
            wrap.order(byteOrder);
            for (d dVar2 : dVarArr) {
                wrap.putInt((int) dVar2.a);
                wrap.putInt((int) dVar2.b);
            }
            return new b(5, dVarArr.length, wrap.array());
        }

        public double a(ByteOrder byteOrder) {
            Object d = d(byteOrder);
            if (d != null) {
                if (d instanceof String) {
                    return Double.parseDouble((String) d);
                }
                if (d instanceof long[]) {
                    long[] jArr = (long[]) d;
                    if (jArr.length == 1) {
                        return jArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof int[]) {
                    int[] iArr = (int[]) d;
                    if (iArr.length == 1) {
                        return iArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof double[]) {
                    double[] dArr = (double[]) d;
                    if (dArr.length == 1) {
                        return dArr[0];
                    }
                    throw new NumberFormatException("There are more than one component");
                } else if (d instanceof d[]) {
                    d[] dVarArr = (d[]) d;
                    if (dVarArr.length == 1) {
                        d dVar = dVarArr[0];
                        return dVar.a / dVar.b;
                    }
                    throw new NumberFormatException("There are more than one component");
                } else {
                    throw new NumberFormatException("Couldn't find a double value");
                }
            }
            throw new NumberFormatException("NULL can't be converted to a double value");
        }
    }

    /* compiled from: ExifInterface.java */
    /* renamed from: kb$c */
    /* loaded from: classes.dex */
    public static class c {
        public final int a;
        public final String b;
        public final int c;
        public final int d;

        public c(String str, int i, int i2) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = -1;
        }

        public c(String str, int i, int i2, int i3) {
            this.b = str;
            this.a = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public final int a(BufferedInputStream bufferedInputStream) {
        boolean z2;
        boolean z3;
        bufferedInputStream.mark(5000);
        byte[] bArr = new byte[5000];
        bufferedInputStream.read(bArr);
        bufferedInputStream.reset();
        int i = 0;
        while (true) {
            byte[] bArr2 = o;
            if (i >= bArr2.length) {
                z2 = true;
                break;
            } else if (bArr[i] != bArr2[i]) {
                z2 = false;
                break;
            } else {
                i++;
            }
        }
        if (z2) {
            return 4;
        }
        byte[] bytes = "FUJIFILMCCD-RAW".getBytes(Charset.defaultCharset());
        int i2 = 0;
        while (true) {
            if (i2 >= bytes.length) {
                z3 = true;
                break;
            } else if (bArr[i2] != bytes[i2]) {
                z3 = false;
                break;
            } else {
                i2++;
            }
        }
        if (z3) {
            return 9;
        }
        a aVar = new a(bArr);
        this.f = e(aVar);
        aVar.d = this.f;
        short readShort = aVar.readShort();
        aVar.close();
        if (readShort == 20306 || readShort == 21330) {
            return 7;
        }
        a aVar2 = new a(bArr);
        this.f = e(aVar2);
        aVar2.d = this.f;
        short readShort2 = aVar2.readShort();
        aVar2.close();
        return readShort2 == 85 ? 10 : 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:128:0x02d4, code lost:
        if (r4.b(r22.f) == 65535) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x02e4 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0121  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0128  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(defpackage.kb.a r23, int r24) {
        /*
            Method dump skipped, instructions count: 857
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kb.b(kb$a, int):void");
    }

    public final void c(a aVar, int i) {
        b bVar;
        b a2;
        b a3;
        b bVar2 = this.d[i].get("DefaultCropSize");
        b bVar3 = this.d[i].get("SensorTopBorder");
        b bVar4 = this.d[i].get("SensorLeftBorder");
        b bVar5 = this.d[i].get("SensorBottomBorder");
        b bVar6 = this.d[i].get("SensorRightBorder");
        if (bVar2 != null) {
            if (bVar2.a == 5) {
                d[] dVarArr = (d[]) bVar2.d(this.f);
                if (dVarArr != null && dVarArr.length == 2) {
                    a2 = b.a(dVarArr[0], this.f);
                    a3 = b.a(dVarArr[1], this.f);
                } else {
                    StringBuilder a4 = jg.a("Invalid crop size values. cropSize=");
                    a4.append(Arrays.toString(dVarArr));
                    Log.w("ExifInterface", a4.toString());
                    return;
                }
            } else {
                int[] iArr = (int[]) bVar2.d(this.f);
                if (iArr != null && iArr.length == 2) {
                    a2 = b.a(iArr[0], this.f);
                    a3 = b.a(iArr[1], this.f);
                } else {
                    StringBuilder a5 = jg.a("Invalid crop size values. cropSize=");
                    a5.append(Arrays.toString(iArr));
                    Log.w("ExifInterface", a5.toString());
                    return;
                }
            }
            this.d[i].put("ImageWidth", a2);
            this.d[i].put("ImageLength", a3);
        } else if (bVar3 != null && bVar4 != null && bVar5 != null && bVar6 != null) {
            int b2 = bVar3.b(this.f);
            int b3 = bVar5.b(this.f);
            int b4 = bVar6.b(this.f);
            int b5 = bVar4.b(this.f);
            if (b3 <= b2 || b4 <= b5) {
                return;
            }
            b a6 = b.a(b3 - b2, this.f);
            b a7 = b.a(b4 - b5, this.f);
            this.d[i].put("ImageLength", a6);
            this.d[i].put("ImageWidth", a7);
        } else {
            b bVar7 = this.d[i].get("ImageLength");
            b bVar8 = this.d[i].get("ImageWidth");
            if ((bVar7 == null || bVar8 == null) && (bVar = this.d[i].get("JPEGInterchangeFormat")) != null) {
                a(aVar, bVar.b(this.f), i);
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x011c, code lost:
        r10.d = r9.f;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0120, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0056 A[FALL_THROUGH] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.kb.a r10, int r11, int r12) {
        /*
            Method dump skipped, instructions count: 402
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kb.a(kb$a, int, int):void");
    }

    public final void a(a aVar) {
        c(aVar);
        b bVar = this.d[1].get("MakerNote");
        if (bVar != null) {
            a aVar2 = new a(bVar.c);
            aVar2.d = this.f;
            byte[] bArr = new byte[p.length];
            aVar2.readFully(bArr);
            aVar2.a(0L);
            byte[] bArr2 = new byte[q.length];
            aVar2.readFully(bArr2);
            if (Arrays.equals(bArr, p)) {
                aVar2.a(8L);
            } else if (Arrays.equals(bArr2, q)) {
                aVar2.a(12L);
            }
            b(aVar2, 6);
            b bVar2 = this.d[7].get("PreviewImageStart");
            b bVar3 = this.d[7].get("PreviewImageLength");
            if (bVar2 != null && bVar3 != null) {
                this.d[5].put("JPEGInterchangeFormat", bVar2);
                this.d[5].put("JPEGInterchangeFormatLength", bVar3);
            }
            b bVar4 = this.d[8].get("AspectFrame");
            if (bVar4 != null) {
                int[] iArr = (int[]) bVar4.d(this.f);
                if (iArr != null && iArr.length == 4) {
                    if (iArr[2] <= iArr[0] || iArr[3] <= iArr[1]) {
                        return;
                    }
                    int i = (iArr[2] - iArr[0]) + 1;
                    int i2 = (iArr[3] - iArr[1]) + 1;
                    if (i < i2) {
                        int i3 = i + i2;
                        i2 = i3 - i2;
                        i = i3 - i2;
                    }
                    b a2 = b.a(i, this.f);
                    b a3 = b.a(i2, this.f);
                    this.d[0].put("ImageWidth", a2);
                    this.d[0].put("ImageLength", a3);
                    return;
                }
                StringBuilder a4 = jg.a("Invalid aspect frame values. frame=");
                a4.append(Arrays.toString(iArr));
                Log.w("ExifInterface", a4.toString());
            }
        }
    }

    public final void a() {
        String a2 = a("DateTimeOriginal");
        if (a2 != null && a("DateTime") == null) {
            this.d[0].put("DateTime", b.a(a2));
        }
        if (a("ImageWidth") == null) {
            this.d[0].put("ImageWidth", b.a(0L, this.f));
        }
        if (a("ImageLength") == null) {
            this.d[0].put("ImageLength", b.a(0L, this.f));
        }
        if (a("Orientation") == null) {
            this.d[0].put("Orientation", b.a(0L, this.f));
        }
        if (a("LightSource") == null) {
            this.d[1].put("LightSource", b.a(0L, this.f));
        }
    }

    public final void a(a aVar, int i) {
        this.f = e(aVar);
        aVar.d = this.f;
        int readUnsignedShort = aVar.readUnsignedShort();
        int i2 = this.c;
        if (i2 != 7 && i2 != 10 && readUnsignedShort != 42) {
            StringBuilder a2 = jg.a("Invalid start code: ");
            a2.append(Integer.toHexString(readUnsignedShort));
            throw new IOException(a2.toString());
        }
        int readInt = aVar.readInt();
        if (readInt >= 8 && readInt < i) {
            int i3 = readInt - 8;
            if (i3 > 0 && aVar.skipBytes(i3) != i3) {
                throw new IOException(jg.a("Couldn't jump to first Ifd: ", i3));
            }
            return;
        }
        throw new IOException(jg.a("Invalid first Ifd offset: ", readInt));
    }

    public final void a(a aVar, HashMap hashMap) {
        int i;
        b bVar = (b) hashMap.get("JPEGInterchangeFormat");
        b bVar2 = (b) hashMap.get("JPEGInterchangeFormatLength");
        if (bVar == null || bVar2 == null) {
            return;
        }
        int b2 = bVar.b(this.f);
        int min = Math.min(bVar2.b(this.f), aVar.available() - b2);
        int i2 = this.c;
        if (i2 == 4 || i2 == 9 || i2 == 10) {
            i = this.h;
        } else {
            if (i2 == 7) {
                i = this.i;
            }
            if (b2 > 0 || min <= 0 || this.a != null || this.b != null) {
                return;
            }
            aVar.a(b2);
            aVar.readFully(new byte[min]);
            return;
        }
        b2 += i;
        if (b2 > 0) {
        }
    }

    public final boolean a(HashMap hashMap) {
        b bVar = (b) hashMap.get("ImageLength");
        b bVar2 = (b) hashMap.get("ImageWidth");
        if (bVar == null || bVar2 == null) {
            return false;
        }
        return bVar.b(this.f) <= 512 && bVar2.b(this.f) <= 512;
    }

    public final void a(int i, int i2) {
        if (this.d[i].isEmpty() || this.d[i2].isEmpty()) {
            return;
        }
        b bVar = this.d[i].get("ImageLength");
        b bVar2 = this.d[i].get("ImageWidth");
        b bVar3 = this.d[i2].get("ImageLength");
        b bVar4 = this.d[i2].get("ImageWidth");
        if (bVar == null || bVar2 == null || bVar3 == null || bVar4 == null) {
            return;
        }
        int b2 = bVar.b(this.f);
        int b3 = bVar2.b(this.f);
        int b4 = bVar3.b(this.f);
        int b5 = bVar4.b(this.f);
        if (b2 >= b4 || b3 >= b5) {
            return;
        }
        HashMap<String, b>[] hashMapArr = this.d;
        HashMap<String, b> hashMap = hashMapArr[i];
        hashMapArr[i] = hashMapArr[i2];
        hashMapArr[i2] = hashMap;
    }

    public static long[] a(Object obj) {
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            long[] jArr = new long[iArr.length];
            for (int i = 0; i < iArr.length; i++) {
                jArr[i] = iArr[i];
            }
            return jArr;
        } else if (obj instanceof long[]) {
            return (long[]) obj;
        } else {
            return null;
        }
    }
}
