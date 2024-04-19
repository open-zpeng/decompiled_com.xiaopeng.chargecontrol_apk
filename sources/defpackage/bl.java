package defpackage;

import defpackage.ji;
import defpackage.nl;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
/* compiled from: ByteArrayLoader.java */
/* renamed from: bl  reason: default package */
/* loaded from: classes.dex */
public class bl<Data> implements nl<byte[], Data> {
    public final b<Data> a;

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: bl$a */
    /* loaded from: classes.dex */
    public static class a implements ol<byte[], ByteBuffer> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: bl$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0002a implements b<ByteBuffer> {
            public C0002a(a aVar) {
            }

            @Override // defpackage.bl.b
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // defpackage.bl.b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }
        }

        @Override // defpackage.ol
        public nl<byte[], ByteBuffer> a(rl rlVar) {
            return new bl(new C0002a(this));
        }
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: bl$b */
    /* loaded from: classes.dex */
    public interface b<Data> {
        Class<Data> a();

        Data a(byte[] bArr);
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: bl$d */
    /* loaded from: classes.dex */
    public static class d implements ol<byte[], InputStream> {

        /* compiled from: ByteArrayLoader.java */
        /* renamed from: bl$d$a */
        /* loaded from: classes.dex */
        public class a implements b<InputStream> {
            public a(d dVar) {
            }

            @Override // defpackage.bl.b
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // defpackage.bl.b
            public Class<InputStream> a() {
                return InputStream.class;
            }
        }

        @Override // defpackage.ol
        public nl<byte[], InputStream> a(rl rlVar) {
            return new bl(new a(this));
        }
    }

    public bl(b<Data> bVar) {
        this.a = bVar;
    }

    @Override // defpackage.nl
    public nl.a a(byte[] bArr, int i, int i2, bi biVar) {
        byte[] bArr2 = bArr;
        return new nl.a(new iq(bArr2), new c(bArr2, this.a));
    }

    /* compiled from: ByteArrayLoader.java */
    /* renamed from: bl$c */
    /* loaded from: classes.dex */
    public static class c<Data> implements ji<Data> {
        public final byte[] c;
        public final b<Data> d;

        public c(byte[] bArr, b<Data> bVar) {
            this.c = bArr;
            this.d = bVar;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super Data> aVar) {
            aVar.a((ji.a<? super Data>) ((Data) this.d.a(this.c)));
        }

        @Override // defpackage.ji
        public void b() {
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

    @Override // defpackage.nl
    public boolean a(byte[] bArr) {
        return true;
    }
}
