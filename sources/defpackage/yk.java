package defpackage;

import defpackage.tq;
import defpackage.wq;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/* compiled from: SafeKeyGenerator.java */
/* renamed from: yk  reason: default package */
/* loaded from: classes.dex */
public class yk {
    public final pq<zh, String> a = new pq<>(1000);
    public final c9<b> b = tq.a(10, new a(this));

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: yk$a */
    /* loaded from: classes.dex */
    public class a implements tq.b<b> {
        public a(yk ykVar) {
        }

        @Override // defpackage.tq.b
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /* compiled from: SafeKeyGenerator.java */
    /* renamed from: yk$b */
    /* loaded from: classes.dex */
    public static final class b implements tq.d {
        public final MessageDigest c;
        public final wq d = new wq.b();

        public b(MessageDigest messageDigest) {
            this.c = messageDigest;
        }

        @Override // defpackage.tq.d
        public wq e() {
            return this.d;
        }
    }

    public String a(zh zhVar) {
        String a2;
        synchronized (this.a) {
            a2 = this.a.a((pq<zh, String>) zhVar);
        }
        if (a2 == null) {
            b a3 = this.b.a();
            defpackage.a.a(a3, "Argument must not be null");
            b bVar = a3;
            try {
                zhVar.a(bVar.c);
                a2 = sq.a(bVar.c.digest());
            } finally {
                this.b.a(bVar);
            }
        }
        synchronized (this.a) {
            this.a.b(zhVar, a2);
        }
        return a2;
    }
}
