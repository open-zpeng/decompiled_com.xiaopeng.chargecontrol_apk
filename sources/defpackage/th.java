package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import defpackage.bg;
import defpackage.sh;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;
/* compiled from: WebpFrameLoader.java */
/* renamed from: th  reason: default package */
/* loaded from: classes.dex */
public class th {
    public static final ai<sh> r = ai.a("com.bumptech.glide.integration.webp.decoder.WebpFrameLoader.CacheStrategy", sh.d);
    public final nh a;
    public final Handler b;
    public final List<b> c;
    public final ug d;
    public final ek e;
    public boolean f;
    public boolean g;
    public boolean h;
    public tg<Bitmap> i;
    public a j;
    public boolean k;
    public a l;
    public Bitmap m;
    public a n;
    public int o;
    public int p;
    public int q;

    /* compiled from: WebpFrameLoader.java */
    /* renamed from: th$a */
    /* loaded from: classes.dex */
    public static class a extends wp<Bitmap> {
        public final Handler f;
        public final int g;
        public final long h;
        public Bitmap i;

        public a(Handler handler, int i, long j) {
            this.f = handler;
            this.g = i;
            this.h = j;
        }

        @Override // defpackage.cq
        public void a(Object obj, fq fqVar) {
            this.i = (Bitmap) obj;
            this.f.sendMessageAtTime(this.f.obtainMessage(1, this), this.h);
        }

        @Override // defpackage.cq
        public void c(Drawable drawable) {
            this.i = null;
        }
    }

    /* compiled from: WebpFrameLoader.java */
    /* renamed from: th$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: WebpFrameLoader.java */
    /* renamed from: th$c */
    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                th.this.a((a) message.obj);
                return true;
            } else if (i == 2) {
                th.this.d.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    /* compiled from: WebpFrameLoader.java */
    /* renamed from: th$d */
    /* loaded from: classes.dex */
    public static class d implements zh {
        public final zh b;
        public final int c;

        public d(zh zhVar, int i) {
            this.b = zhVar;
            this.c = i;
        }

        @Override // defpackage.zh
        public void a(MessageDigest messageDigest) {
            messageDigest.update(ByteBuffer.allocate(12).putInt(this.c).array());
            this.b.a(messageDigest);
        }

        @Override // defpackage.zh
        public boolean equals(Object obj) {
            if (obj instanceof d) {
                d dVar = (d) obj;
                return this.b.equals(dVar.b) && this.c == dVar.c;
            }
            return false;
        }

        @Override // defpackage.zh
        public int hashCode() {
            return (this.b.hashCode() * 31) + this.c;
        }
    }

    public th(lg lgVar, nh nhVar, int i, int i2, fi<Bitmap> fiVar, Bitmap bitmap) {
        ek ekVar = lgVar.c;
        ug c2 = lg.c(lgVar.a());
        tg<Bitmap> a2 = lg.c(lgVar.a()).d().a((lp<?>) qp.b(jj.a).b(true).a(true).a(i, i2));
        this.c = new ArrayList();
        this.f = false;
        this.g = false;
        this.h = false;
        this.d = c2;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.e = ekVar;
        this.b = handler;
        this.i = a2;
        this.a = nhVar;
        defpackage.a.a(fiVar, "Argument must not be null");
        defpackage.a.a(bitmap, "Argument must not be null");
        this.m = bitmap;
        this.i = this.i.a((lp<?>) new qp().a(fiVar, true));
        this.o = sq.a(bitmap);
        this.p = bitmap.getWidth();
        this.q = bitmap.getHeight();
    }

    public final void a() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            defpackage.a.a(this.n == null, "Pending target must be null when starting from the first frame");
            this.a.d = -1;
            this.h = false;
        }
        a aVar = this.n;
        if (aVar != null) {
            this.n = null;
            a(aVar);
            return;
        }
        this.g = true;
        int e = this.a.e();
        this.a.c();
        int i = this.a.d;
        this.l = new a(this.b, i, SystemClock.uptimeMillis() + e);
        nh nhVar = this.a;
        sh shVar = nhVar.k;
        tg<Bitmap> a2 = this.i.a((lp<?>) new qp().a(new d(new iq(nhVar), i)).a(shVar.a == sh.c.CACHE_NONE));
        a2.a(this.a);
        a2.a((tg<Bitmap>) this.l);
    }

    public final void b() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.e.a(bitmap);
            this.m = null;
        }
    }

    public final void c() {
        this.f = false;
    }

    public void a(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f) {
            if (this.h) {
                this.b.obtainMessage(2, aVar).sendToTarget();
            } else {
                this.n = aVar;
            }
        } else {
            if (aVar.i != null) {
                Bitmap bitmap = this.m;
                if (bitmap != null) {
                    this.e.a(bitmap);
                    this.m = null;
                }
                a aVar2 = this.j;
                this.j = aVar;
                for (int size = this.c.size() - 1; size >= 0; size--) {
                    ph phVar = (ph) this.c.get(size);
                    Drawable.Callback callback = phVar.getCallback();
                    while (callback instanceof Drawable) {
                        callback = ((Drawable) callback).getCallback();
                    }
                    if (callback == null) {
                        phVar.stop();
                        phVar.invalidateSelf();
                    } else {
                        phVar.invalidateSelf();
                        a aVar3 = phVar.c.a.j;
                        if ((aVar3 != null ? aVar3.g : -1) == phVar.c.a.a.d() - 1) {
                            phVar.h++;
                        }
                        int i = phVar.i;
                        if (i != -1 && phVar.h >= i) {
                            phVar.stop();
                            List<bg.a> list = phVar.m;
                            if (list != null) {
                                int size2 = list.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    phVar.m.get(i2).a();
                                }
                            }
                        }
                    }
                }
                if (aVar2 != null) {
                    this.b.obtainMessage(2, aVar2).sendToTarget();
                }
            }
            a();
        }
    }
}
