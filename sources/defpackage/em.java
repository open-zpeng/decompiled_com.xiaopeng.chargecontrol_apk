package defpackage;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
/* compiled from: ImageDecoderResourceDecoder.java */
/* renamed from: em  reason: default package */
/* loaded from: classes.dex */
public abstract class em<T> implements di<ImageDecoder.Source, T> {
    public final xm a = xm.b();

    /* compiled from: ImageDecoderResourceDecoder.java */
    /* renamed from: em$a */
    /* loaded from: classes.dex */
    public class a implements ImageDecoder.OnHeaderDecodedListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ int b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ vh d;
        public final /* synthetic */ rm e;
        public final /* synthetic */ ci f;

        /* compiled from: ImageDecoderResourceDecoder.java */
        /* renamed from: em$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0006a implements ImageDecoder.OnPartialImageListener {
            public C0006a(a aVar) {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        public a(int i, int i2, boolean z, vh vhVar, rm rmVar, ci ciVar) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = vhVar;
            this.e = rmVar;
            this.f = ciVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z = true;
            if (em.this.a.a(this.a, this.b, this.c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.d == vh.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0006a(this));
            Size size = imageInfo.getSize();
            int i = this.a;
            if (i == Integer.MIN_VALUE) {
                i = size.getWidth();
            }
            int i2 = this.b;
            if (i2 == Integer.MIN_VALUE) {
                i2 = size.getHeight();
            }
            float b = this.e.b(size.getWidth(), size.getHeight(), i, i2);
            int round = Math.round(size.getWidth() * b);
            int round2 = Math.round(size.getHeight() * b);
            if (Log.isLoggable("ImageDecoder", 2)) {
                StringBuilder a = jg.a("Resizing from [");
                a.append(size.getWidth());
                a.append("x");
                a.append(size.getHeight());
                a.append("] to [");
                a.append(round);
                a.append("x");
                a.append(round2);
                a.append("] scaleFactor: ");
                a.append(b);
                Log.v("ImageDecoder", a.toString());
            }
            imageDecoder.setTargetSize(round, round2);
            int i3 = Build.VERSION.SDK_INT;
            if (this.f != ci.DISPLAY_P3 || imageInfo.getColorSpace() == null || !imageInfo.getColorSpace().isWideGamut()) {
                z = false;
            }
            imageDecoder.setTargetColorSpace(ColorSpace.get(z ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
        }
    }

    @Override // defpackage.di
    public boolean a(ImageDecoder.Source source, bi biVar) {
        return true;
    }

    @Override // defpackage.di
    public final vj<T> a(ImageDecoder.Source source, int i, int i2, bi biVar) {
        jm jmVar = (jm) this;
        Bitmap decodeBitmap = ImageDecoder.decodeBitmap(source, new a(i, i2, biVar.a(sm.j) != null && ((Boolean) biVar.a(sm.j)).booleanValue(), (vh) biVar.a(sm.f), (rm) biVar.a(rm.f), (ci) biVar.a(sm.g)));
        if (Log.isLoggable("BitmapImageDecoder", 2)) {
            StringBuilder a2 = jg.a("Decoded [");
            a2.append(decodeBitmap.getWidth());
            a2.append("x");
            a2.append(decodeBitmap.getHeight());
            a2.append("] for [");
            a2.append(i);
            a2.append("x");
            a2.append(i2);
            a2.append("]");
            Log.v("BitmapImageDecoder", a2.toString());
        }
        return new km(decodeBitmap, jmVar.b);
    }
}
