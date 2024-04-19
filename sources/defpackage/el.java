package defpackage;

import android.util.Base64;
import defpackage.ji;
import defpackage.nl;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
/* compiled from: DataUrlLoader.java */
/* renamed from: el  reason: default package */
/* loaded from: classes.dex */
public final class el<Model, Data> implements nl<Model, Data> {
    public final a<Data> a;

    /* compiled from: DataUrlLoader.java */
    /* renamed from: el$a */
    /* loaded from: classes.dex */
    public interface a<Data> {
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: el$c */
    /* loaded from: classes.dex */
    public static final class c<Model> implements ol<Model, InputStream> {
        public final a<InputStream> a = new a(this);

        @Override // defpackage.ol
        public nl<Model, InputStream> a(rl rlVar) {
            return new el(this.a);
        }

        /* compiled from: DataUrlLoader.java */
        /* renamed from: el$c$a */
        /* loaded from: classes.dex */
        public class a implements a<InputStream> {
            public a(c cVar) {
            }

            public void a(Object obj) {
                ((InputStream) obj).close();
            }

            public Object a(String str) {
                if (str.startsWith("data:image")) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(";base64")) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }

            public Class<InputStream> a() {
                return InputStream.class;
            }
        }
    }

    public el(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // defpackage.nl
    public nl.a<Data> a(Model model, int i, int i2, bi biVar) {
        return new nl.a<>(new iq(model), new b(model.toString(), this.a));
    }

    /* compiled from: DataUrlLoader.java */
    /* renamed from: el$b */
    /* loaded from: classes.dex */
    public static final class b<Data> implements ji<Data> {
        public final String c;
        public final a<Data> d;
        public Data e;

        public b(String str, a<Data> aVar) {
            this.c = str;
            this.d = aVar;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super Data> aVar) {
            try {
                this.e = (Data) ((c.a) this.d).a(this.c);
                aVar.a((ji.a<? super Data>) ((Data) this.e));
            } catch (IllegalArgumentException e) {
                aVar.a((Exception) e);
            }
        }

        @Override // defpackage.ji
        public void b() {
            try {
                ((c.a) this.d).a(this.e);
            } catch (IOException unused) {
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
            return (Class<Data>) ((c.a) this.d).a();
        }
    }

    @Override // defpackage.nl
    public boolean a(Model model) {
        return model.toString().startsWith("data:image");
    }
}
