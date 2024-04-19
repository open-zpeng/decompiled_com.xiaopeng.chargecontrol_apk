package defpackage;

import com.xiaopeng.xui.drawable.XToggleDrawable;
import defpackage.ur;
/* compiled from: BarLineScatterCandleBubbleRenderer.java */
/* renamed from: gt  reason: default package */
/* loaded from: classes.dex */
public abstract class gt extends ht {
    public a f;

    /* compiled from: BarLineScatterCandleBubbleRenderer.java */
    /* renamed from: gt$a */
    /* loaded from: classes.dex */
    public class a {
        public int a;
        public int b;
        public int c;

        public a() {
        }

        public void a(ns nsVar, rs rsVar) {
            float max = Math.max((float) XToggleDrawable.LIGHT_RADIUS_DEFAULT, Math.min(1.0f, gt.this.b.b));
            float lowestVisibleX = nsVar.getLowestVisibleX();
            float highestVisibleX = nsVar.getHighestVisibleX();
            vr a = ((ur) rsVar).a(lowestVisibleX, Float.NaN, ur.a.DOWN);
            ur urVar = (ur) rsVar;
            vr a2 = urVar.a(highestVisibleX, Float.NaN, ur.a.UP);
            this.a = a == null ? 0 : urVar.s.indexOf(a);
            this.b = a2 != null ? urVar.s.indexOf(a2) : 0;
            this.c = (int) ((this.b - this.a) * max);
        }
    }

    public gt(xq xqVar, au auVar) {
        super(xqVar, auVar);
        this.f = new a();
    }

    public boolean a(vr vrVar, rs rsVar) {
        return vrVar != null && ((float) ((ur) rsVar).s.indexOf(vrVar)) < ((float) ((ur) rsVar).n()) * this.b.b;
    }

    public boolean b(ts tsVar) {
        if (((rr) tsVar).r) {
            rr rrVar = (rr) tsVar;
            if (rrVar.n || rrVar.o) {
                return true;
            }
        }
        return false;
    }
}
