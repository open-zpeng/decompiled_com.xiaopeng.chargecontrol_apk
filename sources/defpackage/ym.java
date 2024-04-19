package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* compiled from: ImageReader.java */
/* renamed from: ym  reason: default package */
/* loaded from: classes.dex */
public interface ym {

    /* compiled from: ImageReader.java */
    /* renamed from: ym$a */
    /* loaded from: classes.dex */
    public static final class a implements ym {
        public final qi a;
        public final ck b;
        public final List<ImageHeaderParser> c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, ck ckVar) {
            defpackage.a.a(ckVar, "Argument must not be null");
            this.b = ckVar;
            defpackage.a.a(list, "Argument must not be null");
            this.c = list;
            this.a = new qi(inputStream, ckVar);
        }

        @Override // defpackage.ym
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeStream(this.a.a(), null, options);
        }

        @Override // defpackage.ym
        public int b() {
            return defpackage.a.a(this.c, this.a.a(), this.b);
        }

        @Override // defpackage.ym
        public ImageHeaderParser.ImageType c() {
            return defpackage.a.b(this.c, this.a.a(), this.b);
        }

        @Override // defpackage.ym
        public void a() {
            this.a.a.a();
        }
    }

    /* compiled from: ImageReader.java */
    /* renamed from: ym$b */
    /* loaded from: classes.dex */
    public static final class b implements ym {
        public final ck a;
        public final List<ImageHeaderParser> b;
        public final si c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, ck ckVar) {
            defpackage.a.a(ckVar, "Argument must not be null");
            this.a = ckVar;
            defpackage.a.a(list, "Argument must not be null");
            this.b = list;
            this.c = new si(parcelFileDescriptor);
        }

        @Override // defpackage.ym
        public Bitmap a(BitmapFactory.Options options) {
            return BitmapFactory.decodeFileDescriptor(this.c.a().getFileDescriptor(), null, options);
        }

        @Override // defpackage.ym
        public void a() {
        }

        @Override // defpackage.ym
        public int b() {
            List<ImageHeaderParser> list = this.b;
            si siVar = this.c;
            ck ckVar = this.a;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageHeaderParser imageHeaderParser = list.get(i);
                cn cnVar = null;
                try {
                    cn cnVar2 = new cn(new FileInputStream(siVar.a().getFileDescriptor()), ckVar);
                    try {
                        int a = imageHeaderParser.a(cnVar2, ckVar);
                        try {
                            cnVar2.close();
                        } catch (IOException unused) {
                        }
                        siVar.a();
                        if (a != -1) {
                            return a;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cnVar = cnVar2;
                        if (cnVar != null) {
                            try {
                                cnVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        siVar.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return -1;
        }

        @Override // defpackage.ym
        public ImageHeaderParser.ImageType c() {
            List<ImageHeaderParser> list = this.b;
            si siVar = this.c;
            ck ckVar = this.a;
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ImageHeaderParser imageHeaderParser = list.get(i);
                cn cnVar = null;
                try {
                    cn cnVar2 = new cn(new FileInputStream(siVar.a().getFileDescriptor()), ckVar);
                    try {
                        ImageHeaderParser.ImageType a = imageHeaderParser.a(cnVar2);
                        try {
                            cnVar2.close();
                        } catch (IOException unused) {
                        }
                        siVar.a();
                        if (a != ImageHeaderParser.ImageType.UNKNOWN) {
                            return a;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cnVar = cnVar2;
                        if (cnVar != null) {
                            try {
                                cnVar.close();
                            } catch (IOException unused2) {
                            }
                        }
                        siVar.a();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
    }

    Bitmap a(BitmapFactory.Options options);

    void a();

    int b();

    ImageHeaderParser.ImageType c();
}
