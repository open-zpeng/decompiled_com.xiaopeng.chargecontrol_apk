package defpackage;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.ai;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
/* compiled from: VideoDecoder.java */
/* renamed from: hn  reason: default package */
/* loaded from: classes.dex */
public class hn<T> implements di<T, Bitmap> {
    public static final ai<Long> d = new ai<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final ai<Integer> e = new ai<>("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    public static final e f = new e();
    public final f<T> a;
    public final ek b;
    public final e c;

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$a */
    /* loaded from: classes.dex */
    public class a implements ai.b<Long> {
        public final ByteBuffer a = ByteBuffer.allocate(8);

        @Override // defpackage.ai.b
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$b */
    /* loaded from: classes.dex */
    public class b implements ai.b<Integer> {
        public final ByteBuffer a = ByteBuffer.allocate(4);

        @Override // defpackage.ai.b
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$c */
    /* loaded from: classes.dex */
    public static final class c implements f<AssetFileDescriptor> {
        public /* synthetic */ c(a aVar) {
        }

        @Override // defpackage.hn.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            AssetFileDescriptor assetFileDescriptor2 = assetFileDescriptor;
            mediaMetadataRetriever.setDataSource(assetFileDescriptor2.getFileDescriptor(), assetFileDescriptor2.getStartOffset(), assetFileDescriptor2.getLength());
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$d */
    /* loaded from: classes.dex */
    public static final class d implements f<ByteBuffer> {
        @Override // defpackage.hn.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(new in(this, byteBuffer));
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$e */
    /* loaded from: classes.dex */
    public static class e {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$f */
    /* loaded from: classes.dex */
    public interface f<T> {
        void a(MediaMetadataRetriever mediaMetadataRetriever, T t);
    }

    /* compiled from: VideoDecoder.java */
    /* renamed from: hn$g */
    /* loaded from: classes.dex */
    public static final class g implements f<ParcelFileDescriptor> {
        @Override // defpackage.hn.f
        public void a(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    public hn(ek ekVar, f<T> fVar) {
        e eVar = f;
        this.b = ekVar;
        this.a = fVar;
        this.c = eVar;
    }

    @Override // defpackage.di
    public vj<Bitmap> a(T t, int i, int i2, bi biVar) {
        long longValue = ((Long) biVar.a(d)).longValue();
        if (longValue < 0 && longValue != -1) {
            throw new IllegalArgumentException("Requested frame must be non-negative, or DEFAULT_FRAME, given: " + longValue);
        }
        Integer num = (Integer) biVar.a(e);
        if (num == null) {
            num = 2;
        }
        rm rmVar = (rm) biVar.a(rm.f);
        if (rmVar == null) {
            rmVar = rm.e;
        }
        rm rmVar2 = rmVar;
        MediaMetadataRetriever a2 = this.c.a();
        try {
            try {
                this.a.a(a2, t);
                Bitmap a3 = a(a2, longValue, num.intValue(), i, i2, rmVar2);
                a2.release();
                return km.a(a3, this.b);
            } catch (RuntimeException e2) {
                throw new IOException(e2);
            }
        } catch (Throwable th) {
            a2.release();
            throw th;
        }
    }

    @Override // defpackage.di
    public boolean a(T t, bi biVar) {
        return true;
    }

    public static Bitmap a(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, rm rmVar) {
        int i4 = Build.VERSION.SDK_INT;
        Bitmap bitmap = null;
        if (i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && rmVar != rm.d) {
            try {
                int parseInt = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                int parseInt2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                int parseInt3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                if (parseInt3 == 90 || parseInt3 == 270) {
                    parseInt2 = parseInt;
                    parseInt = parseInt2;
                }
                float b2 = rmVar.b(parseInt, parseInt2, i2, i3);
                bitmap = mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(parseInt * b2), Math.round(b2 * parseInt2));
            } catch (Throwable th) {
                if (Log.isLoggable("VideoDecoder", 3)) {
                    Log.d("VideoDecoder", "Exception trying to decode frame on oreo+", th);
                }
            }
        }
        return bitmap == null ? mediaMetadataRetriever.getFrameAtTime(j, i) : bitmap;
    }
}
