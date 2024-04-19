package defpackage;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.ji;
import defpackage.nl;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: FileLoader.java */
/* renamed from: fl  reason: default package */
/* loaded from: classes.dex */
public class fl<Data> implements nl<File, Data> {
    public final d<Data> a;

    /* compiled from: FileLoader.java */
    /* renamed from: fl$a */
    /* loaded from: classes.dex */
    public static class a<Data> implements ol<File, Data> {
        public final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // defpackage.ol
        public final nl<File, Data> a(rl rlVar) {
            return new fl(this.a);
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: fl$b */
    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {
        public b() {
            super(new a());
        }

        /* compiled from: FileLoader.java */
        /* renamed from: fl$b$a */
        /* loaded from: classes.dex */
        public class a implements d<ParcelFileDescriptor> {
            @Override // defpackage.fl.d
            public void a(ParcelFileDescriptor parcelFileDescriptor) {
                parcelFileDescriptor.close();
            }

            @Override // defpackage.fl.d
            public ParcelFileDescriptor a(File file) {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // defpackage.fl.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }
        }
    }

    /* compiled from: FileLoader.java */
    /* renamed from: fl$d */
    /* loaded from: classes.dex */
    public interface d<Data> {
        Class<Data> a();

        Data a(File file);

        void a(Data data);
    }

    /* compiled from: FileLoader.java */
    /* renamed from: fl$e */
    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {
        public e() {
            super(new a());
        }

        /* compiled from: FileLoader.java */
        /* renamed from: fl$e$a */
        /* loaded from: classes.dex */
        public class a implements d<InputStream> {
            @Override // defpackage.fl.d
            public void a(InputStream inputStream) {
                inputStream.close();
            }

            @Override // defpackage.fl.d
            public InputStream a(File file) {
                return new FileInputStream(file);
            }

            @Override // defpackage.fl.d
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }
    }

    public fl(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // defpackage.nl
    public nl.a a(File file, int i, int i2, bi biVar) {
        File file2 = file;
        return new nl.a(new iq(file2), new c(file2, this.a));
    }

    @Override // defpackage.nl
    public boolean a(File file) {
        return true;
    }

    /* compiled from: FileLoader.java */
    /* renamed from: fl$c */
    /* loaded from: classes.dex */
    public static final class c<Data> implements ji<Data> {
        public final File c;
        public final d<Data> d;
        public Data e;

        public c(File file, d<Data> dVar) {
            this.c = file;
            this.d = dVar;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super Data> aVar) {
            try {
                this.e = this.d.a(this.c);
                aVar.a((ji.a<? super Data>) ((Data) this.e));
            } catch (FileNotFoundException e) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e);
                }
                aVar.a((Exception) e);
            }
        }

        @Override // defpackage.ji
        public void b() {
            Data data = this.e;
            if (data != null) {
                try {
                    this.d.a((d<Data>) data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // defpackage.ji
        public uh c() {
            return uh.LOCAL;
        }

        @Override // defpackage.ji
        public void cancel() {
        }

        @Override // defpackage.ji
        public Class<Data> a() {
            return this.d.a();
        }
    }
}
