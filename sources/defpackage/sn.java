package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.un;
import defpackage.zg;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
/* compiled from: ByteBufferGifDecoder.java */
/* renamed from: sn  reason: default package */
/* loaded from: classes.dex */
public class sn implements di<ByteBuffer, un> {
    public static final a f = new a();
    public static final b g = new b();
    public final Context a;
    public final List<ImageHeaderParser> b;
    public final b c;
    public final a d;
    public final tn e;

    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: sn$a */
    /* loaded from: classes.dex */
    public static class a {
        public zg a(zg.a aVar, bh bhVar, ByteBuffer byteBuffer, int i) {
            return new dh(aVar, bhVar, byteBuffer, i);
        }
    }

    public sn(Context context, List<ImageHeaderParser> list, ek ekVar, ck ckVar) {
        b bVar = g;
        a aVar = f;
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new tn(ekVar, ckVar);
        this.c = bVar;
    }

    @Override // defpackage.di
    public vj<un> a(ByteBuffer byteBuffer, int i, int i2, bi biVar) {
        ByteBuffer byteBuffer2 = byteBuffer;
        ch a2 = this.c.a(byteBuffer2);
        try {
            return a(byteBuffer2, i, i2, a2, biVar);
        } finally {
            this.c.a(a2);
        }
    }

    /* compiled from: ByteBufferGifDecoder.java */
    /* renamed from: sn$b */
    /* loaded from: classes.dex */
    public static class b {
        public final Queue<ch> a = sq.a(0);

        public synchronized void a(ch chVar) {
            chVar.b = null;
            chVar.c = null;
            this.a.offer(chVar);
        }

        public synchronized ch a(ByteBuffer byteBuffer) {
            ch poll;
            poll = this.a.poll();
            if (poll == null) {
                poll = new ch();
            }
            poll.b = null;
            Arrays.fill(poll.a, (byte) 0);
            poll.c = new bh();
            poll.d = 0;
            poll.b = byteBuffer.asReadOnlyBuffer();
            poll.b.position(0);
            poll.b.order(ByteOrder.LITTLE_ENDIAN);
            return poll;
        }
    }

    @Override // defpackage.di
    public boolean a(ByteBuffer byteBuffer, bi biVar) {
        ImageHeaderParser.ImageType imageType;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (((Boolean) biVar.a(ao.b)).booleanValue()) {
            return false;
        }
        List<ImageHeaderParser> list = this.b;
        if (byteBuffer2 == null) {
            imageType = ImageHeaderParser.ImageType.UNKNOWN;
        } else {
            int size = list.size();
            int i = 0;
            while (true) {
                if (i < size) {
                    ImageHeaderParser.ImageType a2 = list.get(i).a(byteBuffer2);
                    if (a2 != ImageHeaderParser.ImageType.UNKNOWN) {
                        imageType = a2;
                        break;
                    }
                    i++;
                } else {
                    imageType = ImageHeaderParser.ImageType.UNKNOWN;
                    break;
                }
            }
        }
        return imageType == ImageHeaderParser.ImageType.GIF;
    }

    public static int a(bh bhVar, int i, int i2) {
        int min = Math.min(bhVar.g / i2, bhVar.f / i);
        int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
        if (Log.isLoggable("BufferGifDecoder", 2) && max > 1) {
            StringBuilder a2 = jg.a("Downsampling GIF, sampleSize: ", max, ", target dimens: [", i, "x");
            a2.append(i2);
            a2.append("], actual dimens: [");
            a2.append(bhVar.f);
            a2.append("x");
            a2.append(bhVar.g);
            a2.append("]");
            Log.v("BufferGifDecoder", a2.toString());
        }
        return max;
    }

    public final wn a(ByteBuffer byteBuffer, int i, int i2, ch chVar, bi biVar) {
        Bitmap.Config config;
        long a2 = oq.a();
        int i3 = 2;
        try {
            bh b2 = chVar.b();
            try {
                if (b2.c > 0 && b2.b == 0) {
                    if (biVar.a(ao.a) == vh.PREFER_RGB_565) {
                        config = Bitmap.Config.RGB_565;
                    } else {
                        config = Bitmap.Config.ARGB_8888;
                    }
                    zg a3 = this.d.a(this.e, b2, byteBuffer, a(b2, i, i2));
                    a3.a(config);
                    a3.c();
                    Bitmap b3 = a3.b();
                    if (b3 == null) {
                        if (Log.isLoggable("BufferGifDecoder", 2)) {
                            StringBuilder a4 = jg.a("Decoded GIF from stream in ");
                            a4.append(oq.a(a2));
                            Log.v("BufferGifDecoder", a4.toString());
                        }
                        return null;
                    }
                    wn wnVar = new wn(new un(new un.a(new yn(lg.a(this.a), a3, i, i2, (fm) fm.b, b3))));
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        StringBuilder a5 = jg.a("Decoded GIF from stream in ");
                        a5.append(oq.a(a2));
                        Log.v("BufferGifDecoder", a5.toString());
                    }
                    return wnVar;
                }
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    StringBuilder a6 = jg.a("Decoded GIF from stream in ");
                    a6.append(oq.a(a2));
                    Log.v("BufferGifDecoder", a6.toString());
                }
                return null;
            } catch (Throwable th) {
                th = th;
                i3 = 2;
                if (Log.isLoggable("BufferGifDecoder", i3)) {
                    StringBuilder a7 = jg.a("Decoded GIF from stream in ");
                    a7.append(oq.a(a2));
                    Log.v("BufferGifDecoder", a7.toString());
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
