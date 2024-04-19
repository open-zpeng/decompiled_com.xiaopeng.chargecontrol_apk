package defpackage;

import defpackage.ki;
import java.io.InputStream;
/* compiled from: InputStreamRewinder.java */
/* renamed from: qi  reason: default package */
/* loaded from: classes.dex */
public final class qi implements ki<InputStream> {
    public final cn a;

    public qi(InputStream inputStream, ck ckVar) {
        this.a = new cn(inputStream, ckVar);
        this.a.mark(5242880);
    }

    @Override // defpackage.ki
    public void b() {
        this.a.b();
    }

    /* compiled from: InputStreamRewinder.java */
    /* renamed from: qi$a */
    /* loaded from: classes.dex */
    public static final class a implements ki.a<InputStream> {
        public final ck a;

        public a(ck ckVar) {
            this.a = ckVar;
        }

        @Override // defpackage.ki.a
        public ki<InputStream> a(InputStream inputStream) {
            return new qi(inputStream, this.a);
        }

        @Override // defpackage.ki.a
        public Class<InputStream> a() {
            return InputStream.class;
        }
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // defpackage.ki
    public InputStream a() {
        this.a.reset();
        return this.a;
    }
}
