package defpackage;

import java.util.ArrayList;
/* compiled from: ObjectTypeAdapter.java */
/* renamed from: qw  reason: default package */
/* loaded from: classes.dex */
public final class qw extends bv<Object> {
    public static final cv b = new a();
    public final lu a;

    /* compiled from: ObjectTypeAdapter.java */
    /* renamed from: qw$a */
    /* loaded from: classes.dex */
    public class a implements cv {
        @Override // defpackage.cv
        public <T> bv<T> a(lu luVar, fx<T> fxVar) {
            if (fxVar.a == Object.class) {
                return new qw(luVar);
            }
            return null;
        }
    }

    public qw(lu luVar) {
        this.a = luVar;
    }

    @Override // defpackage.bv
    public Object read(gx gxVar) {
        int ordinal = gxVar.s().ordinal();
        if (ordinal == 0) {
            ArrayList arrayList = new ArrayList();
            gxVar.a();
            while (gxVar.h()) {
                arrayList.add(read(gxVar));
            }
            gxVar.e();
            return arrayList;
        } else if (ordinal == 2) {
            bw bwVar = new bw();
            gxVar.b();
            while (gxVar.h()) {
                bwVar.put(gxVar.o(), read(gxVar));
            }
            gxVar.f();
            return bwVar;
        } else if (ordinal != 5) {
            if (ordinal != 6) {
                if (ordinal != 7) {
                    if (ordinal == 8) {
                        gxVar.p();
                        return null;
                    }
                    throw new IllegalStateException();
                }
                return Boolean.valueOf(gxVar.k());
            }
            return Double.valueOf(gxVar.l());
        } else {
            return gxVar.q();
        }
    }

    @Override // defpackage.bv
    public void write(ix ixVar, Object obj) {
        if (obj == null) {
            ixVar.g();
            return;
        }
        bv a2 = this.a.a((Class) obj.getClass());
        if (a2 instanceof qw) {
            ixVar.c();
            ixVar.e();
            return;
        }
        a2.write(ixVar, obj);
    }
}
