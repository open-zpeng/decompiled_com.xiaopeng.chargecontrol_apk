package defpackage;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import defpackage.bg;
import java.util.ArrayList;
import java.util.List;
/* compiled from: GifFrameLoader.java */
/* renamed from: yn  reason: default package */
/* loaded from: classes.dex */
public class yn {
    public final zg a;
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

    /* compiled from: GifFrameLoader.java */
    /* renamed from: yn$a */
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

    /* compiled from: GifFrameLoader.java */
    /* renamed from: yn$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    /* compiled from: GifFrameLoader.java */
    /* renamed from: yn$c */
    /* loaded from: classes.dex */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                yn.this.a((a) message.obj);
                return true;
            } else if (i == 2) {
                yn.this.d.a((a) message.obj);
                return false;
            } else {
                return false;
            }
        }
    }

    public yn(lg lgVar, zg zgVar, int i, int i2, fi<Bitmap> fiVar, Bitmap bitmap) {
        ek ekVar = lgVar.c;
        ug c2 = lg.c(lgVar.a());
        tg<Bitmap> a2 = lg.c(lgVar.a()).d().a((lp<?>) qp.b(jj.a).b(true).a(true).a(i, i2));
        this.c = new ArrayList();
        this.d = c2;
        Handler handler = new Handler(Looper.getMainLooper(), new c());
        this.e = ekVar;
        this.b = handler;
        this.i = a2;
        this.a = zgVar;
        a(fiVar, bitmap);
    }

    public void a(fi<Bitmap> fiVar, Bitmap bitmap) {
        defpackage.a.a(fiVar, "Argument must not be null");
        defpackage.a.a(bitmap, "Argument must not be null");
        this.m = bitmap;
        this.i = this.i.a((lp<?>) new qp().a(fiVar, true));
        this.o = sq.a(bitmap);
        this.p = bitmap.getWidth();
        this.q = bitmap.getHeight();
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

    public final void a() {
        if (!this.f || this.g) {
            return;
        }
        if (this.h) {
            defpackage.a.a(this.n == null, "Pending target must be null when starting from the first frame");
            this.a.g();
            this.h = false;
        }
        a aVar = this.n;
        if (aVar != null) {
            this.n = null;
            a(aVar);
            return;
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis() + this.a.e();
        this.a.c();
        this.l = new a(this.b, this.a.a(), uptimeMillis);
        tg<Bitmap> a2 = this.i.a((lp<?>) new qp().a(new iq(Double.valueOf(Math.random()))));
        a2.a(this.a);
        a2.a((tg<Bitmap>) this.l);
    }

    public void a(a aVar) {
        this.g = false;
        if (this.k) {
            this.b.obtainMessage(2, aVar).sendToTarget();
        } else if (!this.f) {
            this.n = aVar;
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
                    un unVar = (un) this.c.get(size);
                    Drawable.Callback callback = unVar.getCallback();
                    while (callback instanceof Drawable) {
                        callback = ((Drawable) callback).getCallback();
                    }
                    if (callback == null) {
                        unVar.stop();
                        unVar.invalidateSelf();
                    } else {
                        unVar.invalidateSelf();
                        a aVar3 = unVar.c.a.j;
                        if ((aVar3 != null ? aVar3.g : -1) == unVar.c.a.a.d() - 1) {
                            unVar.h++;
                        }
                        int i = unVar.i;
                        if (i != -1 && unVar.h >= i) {
                            List<bg.a> list = unVar.m;
                            if (list != null) {
                                int size2 = list.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    unVar.m.get(i2).a();
                                }
                            }
                            unVar.stop();
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
