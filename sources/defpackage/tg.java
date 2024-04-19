package defpackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
/* compiled from: RequestBuilder.java */
/* renamed from: tg  reason: default package */
/* loaded from: classes.dex */
public class tg<TranscodeType> extends lp<tg<TranscodeType>> implements Cloneable, pg<tg<TranscodeType>> {
    public final Context C;
    public final ug D;
    public final Class<TranscodeType> E;
    public final ng F;
    public vg<?, ? super TranscodeType> G;
    public Object H;
    public List<pp<TranscodeType>> I;
    public tg<TranscodeType> J;
    public tg<TranscodeType> K;
    public Float L;
    public boolean M = true;
    public boolean N;
    public boolean O;

    /* compiled from: RequestBuilder.java */
    /* renamed from: tg$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b = new int[qg.values().length];

        static {
            try {
                b[qg.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[qg.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[qg.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[qg.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            a = new int[ImageView.ScaleType.values().length];
            try {
                a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    static {
        new qp().a(jj.b).a(qg.LOW).a(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"CheckResult"})
    public tg(lg lgVar, ug ugVar, Class<TranscodeType> cls, Context context) {
        this.D = ugVar;
        this.E = cls;
        this.C = context;
        ng ngVar = ugVar.c.e;
        vg<?, ?> vgVar = ngVar.f.get(cls);
        if (vgVar == null) {
            for (Map.Entry<Class<?>, vg<?, ?>> entry : ngVar.f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    vgVar = (vg<?, ? super TranscodeType>) entry.getValue();
                }
            }
        }
        this.G = (vg<?, ? super TranscodeType>) (vgVar == null ? (vg<?, ? super TranscodeType>) ng.k : vgVar);
        this.F = lgVar.e;
        for (pp<Object> ppVar : ugVar.l) {
            if (ppVar != null) {
                if (this.I == null) {
                    this.I = new ArrayList();
                }
                this.I.add(ppVar);
            }
        }
        a((lp<?>) ugVar.e());
    }

    @Override // defpackage.lp
    public tg<TranscodeType> a(lp<?> lpVar) {
        defpackage.a.a(lpVar, "Argument must not be null");
        return (tg) super.a(lpVar);
    }

    public final tg<TranscodeType> b(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    @Override // defpackage.lp
    /* renamed from: clone */
    public lp mo2clone() {
        tg tgVar = (tg) super.clone();
        tgVar.G = (vg<?, ? super TranscodeType>) tgVar.G.clone();
        return tgVar;
    }

    public final <Y extends cq<TranscodeType>> Y a(Y y, pp<TranscodeType> ppVar, lp<?> lpVar, Executor executor) {
        defpackage.a.a(y, "Argument must not be null");
        if (this.N) {
            np a2 = a(new Object(), y, ppVar, (op) null, this.G, lpVar.f, lpVar.m, lpVar.l, lpVar, executor);
            np c = y.c();
            if (a2.a(c)) {
                if (!(!lpVar.a() && c.e())) {
                    defpackage.a.a(c, "Argument must not be null");
                    if (!c.isRunning()) {
                        c.d();
                    }
                    return y;
                }
            }
            this.D.a((cq<?>) y);
            y.a(a2);
            this.D.a(y, a2);
            return y;
        }
        throw new IllegalArgumentException("You must call #load() before calling #into()");
    }

    public final qg b(qg qgVar) {
        int ordinal = qgVar.ordinal();
        if (ordinal == 0 || ordinal == 1) {
            return qg.IMMEDIATE;
        }
        if (ordinal != 2) {
            if (ordinal == 3) {
                return qg.NORMAL;
            }
            StringBuilder a2 = jg.a("unknown priority: ");
            a2.append(this.f);
            throw new IllegalArgumentException(a2.toString());
        }
        return qg.HIGH;
    }

    @Override // defpackage.lp
    public Object clone() {
        tg tgVar = (tg) super.clone();
        tgVar.G = (vg<?, ? super TranscodeType>) tgVar.G.clone();
        return tgVar;
    }

    public <Y extends cq<TranscodeType>> Y a(Y y) {
        a(y, null, this, nq.a);
        return y;
    }

    @Override // defpackage.lp
    public /* bridge */ /* synthetic */ lp a(lp lpVar) {
        return a((lp<?>) lpVar);
    }

    public tg<TranscodeType> a(Object obj) {
        this.H = obj;
        this.N = true;
        return this;
    }

    public dq<ImageView, TranscodeType> a(ImageView imageView) {
        tg<TranscodeType> tgVar;
        sq.a();
        defpackage.a.a(imageView, "Argument must not be null");
        if (!lp.b(this.c, 2048) && this.p && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    tg tgVar2 = (tg) super.clone();
                    tgVar2.G = (vg<?, ? super TranscodeType>) tgVar2.G.clone();
                    tgVar = tgVar2.b();
                    break;
                case 2:
                    tg tgVar3 = (tg) super.clone();
                    tgVar3.G = (vg<?, ? super TranscodeType>) tgVar3.G.clone();
                    tgVar = tgVar3.c();
                    break;
                case 3:
                case 4:
                case 5:
                    tg tgVar4 = (tg) super.clone();
                    tgVar4.G = (vg<?, ? super TranscodeType>) tgVar4.G.clone();
                    tgVar = tgVar4.d();
                    break;
                case 6:
                    tg tgVar5 = (tg) super.clone();
                    tgVar5.G = (vg<?, ? super TranscodeType>) tgVar5.G.clone();
                    tgVar = tgVar5.c();
                    break;
            }
            ng ngVar = this.F;
            dq<ImageView, TranscodeType> a2 = ngVar.c.a(imageView, this.E);
            a(a2, null, tgVar, nq.a);
            return a2;
        }
        tgVar = this;
        ng ngVar2 = this.F;
        dq<ImageView, TranscodeType> a22 = ngVar2.c.a(imageView, this.E);
        a(a22, null, tgVar, nq.a);
        return a22;
    }

    /* JADX WARN: Type inference failed for: r0v6, types: [lp] */
    public final np a(Object obj, cq<TranscodeType> cqVar, pp<TranscodeType> ppVar, op opVar, vg<?, ? super TranscodeType> vgVar, qg qgVar, int i, int i2, lp<?> lpVar, Executor executor) {
        mp mpVar;
        mp mpVar2;
        tp a2;
        int i3;
        int i4;
        qg b;
        int i5;
        int i6;
        if (this.K != null) {
            mp mpVar3 = new mp(obj, opVar);
            mpVar = mpVar3;
            mpVar2 = mpVar3;
        } else {
            mpVar = null;
            mpVar2 = opVar;
        }
        tg<TranscodeType> tgVar = this.J;
        if (tgVar != null) {
            if (!this.O) {
                vg<?, ? super TranscodeType> vgVar2 = tgVar.M ? vgVar : tgVar.G;
                if (lp.b(this.J.c, 8)) {
                    b = this.J.f;
                } else {
                    b = b(qgVar);
                }
                qg qgVar2 = b;
                tg<TranscodeType> tgVar2 = this.J;
                int i7 = tgVar2.m;
                int i8 = tgVar2.l;
                if (sq.a(i, i2)) {
                    tg<TranscodeType> tgVar3 = this.J;
                    if (!sq.a(tgVar3.m, tgVar3.l)) {
                        i6 = lpVar.m;
                        i5 = lpVar.l;
                        tp tpVar = new tp(obj, mpVar2);
                        tp tpVar2 = tpVar;
                        np a3 = a(obj, cqVar, ppVar, lpVar, tpVar, vgVar, qgVar, i, i2, executor);
                        this.O = true;
                        tg<TranscodeType> tgVar4 = this.J;
                        np a4 = tgVar4.a(obj, cqVar, ppVar, tpVar2, vgVar2, qgVar2, i6, i5, tgVar4, executor);
                        this.O = false;
                        tpVar2.c = a3;
                        tpVar2.d = a4;
                        a2 = tpVar2;
                    }
                }
                i5 = i8;
                i6 = i7;
                tp tpVar3 = new tp(obj, mpVar2);
                tp tpVar22 = tpVar3;
                np a32 = a(obj, cqVar, ppVar, lpVar, tpVar3, vgVar, qgVar, i, i2, executor);
                this.O = true;
                tg<TranscodeType> tgVar42 = this.J;
                np a42 = tgVar42.a(obj, cqVar, ppVar, tpVar22, vgVar2, qgVar2, i6, i5, tgVar42, executor);
                this.O = false;
                tpVar22.c = a32;
                tpVar22.d = a42;
                a2 = tpVar22;
            } else {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
        } else if (this.L != null) {
            tp tpVar4 = new tp(obj, mpVar2);
            np a5 = a(obj, cqVar, ppVar, lpVar, tpVar4, vgVar, qgVar, i, i2, executor);
            np a6 = a(obj, cqVar, ppVar, lpVar.clone().a(this.L.floatValue()), tpVar4, vgVar, b(qgVar), i, i2, executor);
            tpVar4.c = a5;
            tpVar4.d = a6;
            a2 = tpVar4;
        } else {
            a2 = a(obj, cqVar, ppVar, lpVar, mpVar2, vgVar, qgVar, i, i2, executor);
        }
        if (mpVar == null) {
            return a2;
        }
        tg<TranscodeType> tgVar5 = this.K;
        int i9 = tgVar5.m;
        int i10 = tgVar5.l;
        if (sq.a(i, i2)) {
            tg<TranscodeType> tgVar6 = this.K;
            if (!sq.a(tgVar6.m, tgVar6.l)) {
                i4 = lpVar.m;
                i3 = lpVar.l;
                tg<TranscodeType> tgVar7 = this.K;
                np a7 = tgVar7.a(obj, cqVar, ppVar, mpVar, tgVar7.G, tgVar7.f, i4, i3, tgVar7, executor);
                mpVar.c = a2;
                mpVar.d = a7;
                return mpVar;
            }
        }
        i3 = i10;
        i4 = i9;
        tg<TranscodeType> tgVar72 = this.K;
        np a72 = tgVar72.a(obj, cqVar, ppVar, mpVar, tgVar72.G, tgVar72.f, i4, i3, tgVar72, executor);
        mpVar.c = a2;
        mpVar.d = a72;
        return mpVar;
    }

    public final np a(Object obj, cq<TranscodeType> cqVar, pp<TranscodeType> ppVar, lp<?> lpVar, op opVar, vg<?, ? super TranscodeType> vgVar, qg qgVar, int i, int i2, Executor executor) {
        Context context = this.C;
        ng ngVar = this.F;
        return new sp(context, ngVar, obj, this.H, this.E, lpVar, i, i2, qgVar, cqVar, ppVar, this.I, opVar, ngVar.g, vgVar.c, executor);
    }
}
