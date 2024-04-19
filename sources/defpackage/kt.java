package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.drawable.Drawable;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.gt;
import defpackage.xr;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
/* compiled from: LineChartRenderer.java */
/* renamed from: kt  reason: default package */
/* loaded from: classes.dex */
public class kt extends lt {
    public ps h;
    public Paint i;
    public WeakReference<Bitmap> j;
    public Canvas k;
    public Bitmap.Config l;
    public Path m;
    public Path n;
    public float[] o;
    public Path p;
    public HashMap<ts, b> q;
    public float[] r;

    /* compiled from: LineChartRenderer.java */
    /* renamed from: kt$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = new int[xr.a.values().length];

        static {
            try {
                a[xr.a.LINEAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[xr.a.STEPPED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[xr.a.CUBIC_BEZIER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[xr.a.HORIZONTAL_BEZIER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: LineChartRenderer.java */
    /* renamed from: kt$b */
    /* loaded from: classes.dex */
    public class b {
        public Path a = new Path();
        public Bitmap[] b;

        public /* synthetic */ b(a aVar) {
        }

        public boolean a(us usVar) {
            int size = ((xr) usVar).I.size();
            Bitmap[] bitmapArr = this.b;
            if (bitmapArr == null) {
                this.b = new Bitmap[size];
                return true;
            } else if (bitmapArr.length != size) {
                this.b = new Bitmap[size];
                return true;
            } else {
                return false;
            }
        }
    }

    public kt(ps psVar, xq xqVar, au auVar) {
        super(xqVar, auVar);
        this.l = Bitmap.Config.ARGB_8888;
        this.m = new Path();
        this.n = new Path();
        this.o = new float[4];
        this.p = new Path();
        this.q = new HashMap<>();
        this.r = new float[2];
        this.h = psVar;
        this.i = new Paint(1);
        this.i.setStyle(Paint.Style.FILL);
        this.i.setColor(-1);
    }

    @Override // defpackage.ht
    public void a() {
    }

    @Override // defpackage.ht
    public void a(Canvas canvas) {
        Bitmap bitmap;
        Iterator it;
        PathEffect pathEffect;
        ur urVar;
        int i;
        Canvas canvas2;
        boolean z;
        float f;
        char c;
        Canvas canvas3;
        int i2;
        xr xrVar;
        xr xrVar2;
        boolean z2;
        au auVar = this.a;
        int i3 = (int) auVar.c;
        int i4 = (int) auVar.d;
        WeakReference<Bitmap> weakReference = this.j;
        Bitmap bitmap2 = weakReference == null ? null : weakReference.get();
        if (bitmap2 == null || bitmap2.getWidth() != i3 || bitmap2.getHeight() != i4) {
            if (i3 <= 0 || i4 <= 0) {
                return;
            }
            bitmap2 = Bitmap.createBitmap(i3, i4, this.l);
            this.j = new WeakReference<>(bitmap2);
            this.k = new Canvas(bitmap2);
        }
        Bitmap bitmap3 = bitmap2;
        boolean z3 = false;
        bitmap3.eraseColor(0);
        Iterator it2 = this.h.getLineData().i.iterator();
        while (it2.hasNext()) {
            us usVar = (us) it2.next();
            if (((rr) usVar).r) {
                ur urVar2 = (ur) usVar;
                if (urVar2.n() >= 1) {
                    yr yrVar = (yr) usVar;
                    this.c.setStrokeWidth(yrVar.F);
                    xr xrVar3 = (xr) usVar;
                    this.c.setPathEffect(xrVar3.N);
                    int ordinal = xrVar3.H.ordinal();
                    if (ordinal == 2) {
                        bitmap = bitmap3;
                        it = it2;
                        float f2 = this.b.a;
                        rr rrVar = (rr) usVar;
                        xt a2 = this.h.a(rrVar.f);
                        this.f.a(this.h, usVar);
                        float f3 = xrVar3.M;
                        this.m.reset();
                        gt.a aVar = this.f;
                        if (aVar.c >= 1) {
                            int i5 = aVar.a + 1;
                            vr d = urVar2.d(Math.max(i5 - 2, 0));
                            vr d2 = urVar2.d(Math.max(i5 - 1, 0));
                            if (d2 != null) {
                                this.m.moveTo(d2.b(), d2.a() * f2);
                                int i6 = this.f.a + 1;
                                int i7 = -1;
                                vr vrVar = d2;
                                while (true) {
                                    gt.a aVar2 = this.f;
                                    if (i6 > aVar2.c + aVar2.a) {
                                        break;
                                    }
                                    if (i7 != i6) {
                                        d2 = urVar2.d(i6);
                                    }
                                    int i8 = i6 + 1;
                                    i7 = i8 < urVar2.n() ? i8 : i6;
                                    vr d3 = urVar2.d(i7);
                                    this.m.cubicTo(vrVar.b() + ((d2.b() - d.b()) * f3), (vrVar.a() + ((d2.a() - d.a()) * f3)) * f2, d2.b() - ((d3.b() - vrVar.b()) * f3), (d2.a() - ((d3.a() - vrVar.a()) * f3)) * f2, d2.b(), d2.a() * f2);
                                    d = vrVar;
                                    f3 = f3;
                                    vrVar = d2;
                                    d2 = d3;
                                    i6 = i8;
                                }
                            }
                        }
                        if (yrVar.G) {
                            this.n.reset();
                            this.n.addPath(this.m);
                            a(this.k, usVar, this.n, a2, this.f);
                        }
                        this.c.setColor(rrVar.j());
                        this.c.setStyle(Paint.Style.STROKE);
                        a2.a(this.m);
                        this.k.drawPath(this.m, this.c);
                        pathEffect = null;
                        this.c.setPathEffect(null);
                        this.c.setPathEffect(pathEffect);
                        it2 = it;
                        bitmap3 = bitmap;
                        z3 = false;
                    } else if (ordinal != 3) {
                        int n = urVar2.n();
                        boolean z4 = xrVar3.H == xr.a.STEPPED ? true : z3;
                        int i9 = z4 ? 4 : 2;
                        rr rrVar2 = (rr) usVar;
                        xt a3 = this.h.a(rrVar2.f);
                        float f4 = this.b.a;
                        this.c.setStyle(Paint.Style.STROKE);
                        Canvas canvas4 = xrVar3.N != null ? this.k : canvas;
                        it = it2;
                        this.f.a(this.h, usVar);
                        if (!yrVar.G || n <= 0) {
                            urVar = urVar2;
                            i = n;
                            canvas2 = canvas4;
                            bitmap = bitmap3;
                            z = z4;
                            f = f4;
                        } else {
                            gt.a aVar3 = this.f;
                            Path path = this.p;
                            int i10 = aVar3.a;
                            int i11 = aVar3.c + i10;
                            bitmap = bitmap3;
                            int i12 = 0;
                            while (true) {
                                i = n;
                                int i13 = (i12 * 128) + i10;
                                int i14 = i10;
                                int i15 = i13 + 128;
                                if (i15 > i11) {
                                    i15 = i11;
                                }
                                if (i13 <= i15) {
                                    i2 = i11;
                                    canvas2 = canvas4;
                                    float a4 = xrVar3.v().a(xrVar3, this.h);
                                    float f5 = this.b.a;
                                    z = z4;
                                    f = f4;
                                    boolean z5 = xrVar3.H == xr.a.STEPPED;
                                    path.reset();
                                    vr vrVar2 = (vr) xrVar3.s.get(i13);
                                    urVar = urVar2;
                                    path.moveTo(vrVar2.b(), a4);
                                    vr vrVar3 = vrVar2;
                                    path.lineTo(vrVar2.b(), vrVar2.a() * f5);
                                    int i16 = i13 + 1;
                                    vr vrVar4 = null;
                                    while (i16 <= i15) {
                                        vrVar4 = xrVar3.d(i16);
                                        if (z5) {
                                            z2 = z5;
                                            xrVar2 = xrVar3;
                                            path.lineTo(vrVar4.b(), vrVar3.a() * f5);
                                        } else {
                                            xrVar2 = xrVar3;
                                            z2 = z5;
                                        }
                                        path.lineTo(vrVar4.b(), vrVar4.a() * f5);
                                        i16++;
                                        vrVar3 = vrVar4;
                                        z5 = z2;
                                        xrVar3 = xrVar2;
                                    }
                                    xrVar = xrVar3;
                                    if (vrVar4 != null) {
                                        path.lineTo(vrVar4.b(), a4);
                                    }
                                    path.close();
                                    a3.a(path);
                                    Drawable r = yrVar.r();
                                    if (r != null) {
                                        a(canvas, path, r);
                                    } else {
                                        a(canvas, path, yrVar.q(), yrVar.p());
                                    }
                                } else {
                                    urVar = urVar2;
                                    i2 = i11;
                                    canvas2 = canvas4;
                                    xrVar = xrVar3;
                                    z = z4;
                                    f = f4;
                                }
                                i12++;
                                if (i13 > i15) {
                                    break;
                                }
                                n = i;
                                i10 = i14;
                                i11 = i2;
                                canvas4 = canvas2;
                                z4 = z;
                                f4 = f;
                                urVar2 = urVar;
                                xrVar3 = xrVar;
                            }
                        }
                        if (rrVar2.a.size() > 1) {
                            int i17 = i9 * 2;
                            if (this.o.length <= i17) {
                                this.o = new float[i9 * 4];
                            }
                            int i18 = this.f.a;
                            while (true) {
                                gt.a aVar4 = this.f;
                                if (i18 > aVar4.c + aVar4.a) {
                                    break;
                                }
                                ur urVar3 = urVar;
                                vr d4 = urVar3.d(i18);
                                if (d4 != null) {
                                    this.o[0] = d4.b();
                                    this.o[1] = d4.a() * f;
                                    if (i18 < this.f.b) {
                                        vr d5 = urVar3.d(i18 + 1);
                                        if (d5 == null) {
                                            break;
                                        }
                                        if (z) {
                                            this.o[2] = d5.b();
                                            float[] fArr = this.o;
                                            fArr[3] = fArr[1];
                                            fArr[4] = fArr[2];
                                            fArr[5] = fArr[3];
                                            fArr[6] = d5.b();
                                            this.o[7] = d5.a() * f;
                                        } else {
                                            this.o[2] = d5.b();
                                            this.o[3] = d5.a() * f;
                                        }
                                        c = 0;
                                    } else {
                                        float[] fArr2 = this.o;
                                        c = 0;
                                        fArr2[2] = fArr2[0];
                                        fArr2[3] = fArr2[1];
                                    }
                                    a3.b(this.o);
                                    if (!this.a.c(this.o[c])) {
                                        break;
                                    } else if (this.a.b(this.o[2])) {
                                        if (!this.a.d(this.o[1]) && !this.a.a(this.o[3])) {
                                            canvas3 = canvas2;
                                            i18++;
                                            urVar = urVar3;
                                            canvas2 = canvas3;
                                        }
                                        this.c.setColor(rrVar2.a(i18));
                                        canvas3 = canvas2;
                                        canvas3.drawLines(this.o, 0, i17, this.c);
                                        i18++;
                                        urVar = urVar3;
                                        canvas2 = canvas3;
                                    }
                                }
                                canvas3 = canvas2;
                                i18++;
                                urVar = urVar3;
                                canvas2 = canvas3;
                            }
                        } else {
                            Canvas canvas5 = canvas2;
                            ur urVar4 = urVar;
                            int i19 = i * i9;
                            if (this.o.length < Math.max(i19, i9) * 2) {
                                this.o = new float[Math.max(i19, i9) * 4];
                            }
                            if (urVar4.d(this.f.a) != null) {
                                int i20 = this.f.a;
                                int i21 = 0;
                                while (true) {
                                    gt.a aVar5 = this.f;
                                    if (i20 > aVar5.c + aVar5.a) {
                                        break;
                                    }
                                    vr d6 = urVar4.d(i20 == 0 ? 0 : i20 - 1);
                                    vr d7 = urVar4.d(i20);
                                    if (d6 != null && d7 != null) {
                                        int i22 = i21 + 1;
                                        this.o[i21] = d6.b();
                                        int i23 = i22 + 1;
                                        this.o[i22] = d6.a() * f;
                                        if (z) {
                                            int i24 = i23 + 1;
                                            this.o[i23] = d7.b();
                                            int i25 = i24 + 1;
                                            this.o[i24] = d6.a() * f;
                                            int i26 = i25 + 1;
                                            this.o[i25] = d7.b();
                                            i23 = i26 + 1;
                                            this.o[i26] = d6.a() * f;
                                        }
                                        int i27 = i23 + 1;
                                        this.o[i23] = d7.b();
                                        this.o[i27] = d7.a() * f;
                                        i21 = i27 + 1;
                                    }
                                    i20++;
                                }
                                if (i21 > 0) {
                                    a3.b(this.o);
                                    this.c.setColor(rrVar2.j());
                                    canvas5.drawLines(this.o, 0, Math.max((this.f.c + 1) * i9, i9) * 2, this.c);
                                }
                            }
                        }
                        this.c.setPathEffect(null);
                    } else {
                        bitmap = bitmap3;
                        it = it2;
                        float f6 = this.b.a;
                        rr rrVar3 = (rr) usVar;
                        xt a5 = this.h.a(rrVar3.f);
                        this.f.a(this.h, usVar);
                        this.m.reset();
                        gt.a aVar6 = this.f;
                        if (aVar6.c >= 1) {
                            vr d8 = urVar2.d(aVar6.a);
                            this.m.moveTo(d8.b(), d8.a() * f6);
                            int i28 = this.f.a + 1;
                            while (true) {
                                gt.a aVar7 = this.f;
                                if (i28 > aVar7.c + aVar7.a) {
                                    break;
                                }
                                vr d9 = urVar2.d(i28);
                                float b2 = ((d9.b() - d8.b()) / 2.0f) + d8.b();
                                this.m.cubicTo(b2, d8.a() * f6, b2, d9.a() * f6, d9.b(), d9.a() * f6);
                                i28++;
                                d8 = d9;
                            }
                        }
                        if (yrVar.G) {
                            this.n.reset();
                            this.n.addPath(this.m);
                            a(this.k, usVar, this.n, a5, this.f);
                        }
                        this.c.setColor(rrVar3.j());
                        this.c.setStyle(Paint.Style.STROKE);
                        a5.a(this.m);
                        this.k.drawPath(this.m, this.c);
                        this.c.setPathEffect(null);
                    }
                    pathEffect = null;
                    this.c.setPathEffect(pathEffect);
                    it2 = it;
                    bitmap3 = bitmap;
                    z3 = false;
                }
            }
            bitmap = bitmap3;
            it = it2;
            it2 = it;
            bitmap3 = bitmap;
            z3 = false;
        }
        canvas.drawBitmap(bitmap3, XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.c);
    }

    @Override // defpackage.ht
    public void b(Canvas canvas) {
        List list;
        int i;
        int i2;
        b bVar;
        this.c.setStyle(Paint.Style.FILL);
        float f = this.b.a;
        float[] fArr = this.r;
        float f2 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        int i3 = 0;
        fArr[0] = 0.0f;
        int i4 = 1;
        fArr[1] = 0.0f;
        List list2 = this.h.getLineData().i;
        int i5 = 0;
        while (i5 < list2.size()) {
            us usVar = (us) list2.get(i5);
            rr rrVar = (rr) usVar;
            if (rrVar.r) {
                xr xrVar = (xr) usVar;
                if (xrVar.w()) {
                    ur urVar = (ur) usVar;
                    if (urVar.n() != 0) {
                        this.i.setColor(xrVar.t());
                        xt a2 = this.h.a(rrVar.f);
                        this.f.a(this.h, usVar);
                        float f3 = xrVar.K;
                        float u = xrVar.u();
                        int i6 = (!xrVar.Q || u >= f3 || u <= f2) ? i3 : i4;
                        int i7 = (i6 == 0 || xrVar.t() != 1122867) ? i3 : i4;
                        if (this.q.containsKey(usVar)) {
                            bVar = this.q.get(usVar);
                        } else {
                            bVar = new b(null);
                            this.q.put(usVar, bVar);
                        }
                        if (bVar.a(usVar)) {
                            int s = xrVar.s();
                            float f4 = xrVar.K;
                            float u2 = xrVar.u();
                            int i8 = i3;
                            while (i8 < s) {
                                List list3 = list2;
                                int i9 = s;
                                int i10 = (int) (f4 * 2.1d);
                                Bitmap createBitmap = Bitmap.createBitmap(i10, i10, Bitmap.Config.ARGB_4444);
                                Canvas canvas2 = new Canvas(createBitmap);
                                bVar.b[i8] = createBitmap;
                                kt.this.c.setColor(xrVar.I.get(i8).intValue());
                                if (i7 != 0) {
                                    bVar.a.reset();
                                    bVar.a.addCircle(f4, f4, f4, Path.Direction.CW);
                                    bVar.a.addCircle(f4, f4, u2, Path.Direction.CCW);
                                    canvas2.drawPath(bVar.a, kt.this.c);
                                } else {
                                    canvas2.drawCircle(f4, f4, f4, kt.this.c);
                                    if (i6 != 0) {
                                        canvas2.drawCircle(f4, f4, u2, kt.this.i);
                                    }
                                }
                                i8++;
                                list2 = list3;
                                s = i9;
                            }
                        }
                        list = list2;
                        gt.a aVar = this.f;
                        int i11 = aVar.c;
                        int i12 = aVar.a;
                        int i13 = i11 + i12;
                        while (i12 <= i13) {
                            vr d = urVar.d(i12);
                            if (d == null) {
                                break;
                            }
                            this.r[0] = d.b();
                            this.r[1] = d.a() * f;
                            a2.b(this.r);
                            if (!this.a.c(this.r[0])) {
                                i = 0;
                                break;
                            }
                            if (this.a.b(this.r[0]) && this.a.f(this.r[1])) {
                                Bitmap[] bitmapArr = bVar.b;
                                Bitmap bitmap = bitmapArr[i12 % bitmapArr.length];
                                if (bitmap != null) {
                                    float[] fArr2 = this.r;
                                    canvas.drawBitmap(bitmap, fArr2[0] - f3, fArr2[1] - f3, (Paint) null);
                                    i12++;
                                }
                            }
                            i12++;
                        }
                        i = 0;
                        i2 = 1;
                        i5++;
                        i3 = i;
                        i4 = i2;
                        list2 = list;
                        f2 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
                    }
                }
            }
            list = list2;
            i = i3;
            i2 = i4;
            i5++;
            i3 = i;
            i4 = i2;
            list2 = list;
            f2 = XToggleDrawable.LIGHT_RADIUS_DEFAULT;
        }
    }

    @Override // defpackage.ht
    public void c(Canvas canvas) {
        List list;
        List list2;
        if (a(this.h)) {
            List list3 = this.h.getLineData().i;
            int i = 0;
            while (i < list3.size()) {
                us usVar = (us) list3.get(i);
                if (b(usVar)) {
                    ur urVar = (ur) usVar;
                    if (urVar.n() >= 1) {
                        a(usVar);
                        rr rrVar = (rr) usVar;
                        xt a2 = this.h.a(rrVar.f);
                        xr xrVar = (xr) usVar;
                        int i2 = (int) (xrVar.K * 1.75f);
                        if (!xrVar.P) {
                            i2 /= 2;
                        }
                        this.f.a(this.h, usVar);
                        xq xqVar = this.b;
                        float f = xqVar.b;
                        float f2 = xqVar.a;
                        gt.a aVar = this.f;
                        int i3 = aVar.a;
                        int i4 = (((int) ((aVar.b - i3) * f)) + 1) * 2;
                        if (a2.d.length != i4) {
                            a2.d = new float[i4];
                        }
                        float[] fArr = a2.d;
                        for (int i5 = 0; i5 < i4; i5 += 2) {
                            vr d = urVar.d((i5 / 2) + i3);
                            if (d != null) {
                                fArr[i5] = d.b();
                                fArr[i5 + 1] = d.a() * f2;
                            } else {
                                fArr[i5] = 0.0f;
                                fArr[i5 + 1] = 0.0f;
                            }
                        }
                        a2.g.set(a2.a);
                        a2.g.postConcat(a2.c.a);
                        a2.g.postConcat(a2.b);
                        a2.g.mapPoints(fArr);
                        fs k = rrVar.k();
                        vt a3 = vt.a(rrVar.p);
                        a3.b = zt.a(a3.b);
                        a3.c = zt.a(a3.c);
                        int i6 = 0;
                        while (i6 < fArr.length) {
                            float f3 = fArr[i6];
                            float f4 = fArr[i6 + 1];
                            if (!this.a.c(f3)) {
                                break;
                            }
                            if (this.a.b(f3) && this.a.f(f4)) {
                                int i7 = i6 / 2;
                                vr d2 = urVar.d(this.f.a + i7);
                                if (rrVar.n) {
                                    list2 = list3;
                                    this.e.setColor(rrVar.b(i7));
                                    canvas.drawText(k.a(d2), f3, f4 - i2, this.e);
                                } else {
                                    list2 = list3;
                                }
                                Drawable drawable = d2.e;
                                if (drawable != null && rrVar.o) {
                                    zt.a(canvas, drawable, (int) (f3 + a3.b), (int) (f4 + a3.c), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                                }
                            } else {
                                list2 = list3;
                            }
                            i6 += 2;
                            list3 = list2;
                        }
                        list = list3;
                        vt.d.a((wt<vt>) a3);
                        i++;
                        list3 = list;
                    }
                }
                list = list3;
                i++;
                list3 = list;
            }
        }
    }

    public void a(Canvas canvas, us usVar, Path path, xt xtVar, gt.a aVar) {
        xr xrVar = (xr) usVar;
        float a2 = xrVar.O.a(xrVar, this.h);
        path.lineTo(xrVar.d(aVar.a + aVar.c).b(), a2);
        path.lineTo(xrVar.d(aVar.a).b(), a2);
        path.close();
        xtVar.a(path);
        Drawable drawable = xrVar.D;
        if (drawable != null) {
            a(canvas, path, drawable);
        } else {
            a(canvas, path, xrVar.C, xrVar.E);
        }
    }

    @Override // defpackage.ht
    public void a(Canvas canvas, is[] isVarArr) {
        wr lineData = this.h.getLineData();
        for (is isVar : isVarArr) {
            us usVar = (us) lineData.a(isVar.f);
            if (usVar != null) {
                rr rrVar = (rr) usVar;
                if (rrVar.g) {
                    vr a2 = ((ur) usVar).a(isVar.a, isVar.b);
                    if (a(a2, usVar)) {
                        ut a3 = this.h.a(rrVar.f).a(a2.b(), a2.a() * this.b.a);
                        double d = a3.b;
                        double d2 = a3.c;
                        isVar.i = (float) d;
                        isVar.j = (float) d2;
                        float f = (float) d;
                        float f2 = (float) d2;
                        zr zrVar = (zr) usVar;
                        this.d.setColor(zrVar.o());
                        this.d.setStrokeWidth(zrVar.A);
                        this.d.setPathEffect(zrVar.B);
                        if (zrVar.y) {
                            this.g.reset();
                            this.g.moveTo(f, this.a.b.top);
                            this.g.lineTo(f, this.a.b.bottom);
                            canvas.drawPath(this.g, this.d);
                        }
                        if (zrVar.z) {
                            this.g.reset();
                            this.g.moveTo(this.a.b.left, f2);
                            this.g.lineTo(this.a.b.right, f2);
                            canvas.drawPath(this.g, this.d);
                        }
                    }
                }
            }
        }
    }
}
