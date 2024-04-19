package defpackage;

import defpackage.ji;
import defpackage.nl;
/* compiled from: UnitModelLoader.java */
/* renamed from: vl  reason: default package */
/* loaded from: classes.dex */
public class vl<Model> implements nl<Model, Model> {
    public static final vl<?> a = new vl<>();

    /* compiled from: UnitModelLoader.java */
    /* renamed from: vl$a */
    /* loaded from: classes.dex */
    public static class a<Model> implements ol<Model, Model> {
        public static final a<?> a = new a<>();

        @Override // defpackage.ol
        public nl<Model, Model> a(rl rlVar) {
            return vl.a;
        }
    }

    /* compiled from: UnitModelLoader.java */
    /* renamed from: vl$b */
    /* loaded from: classes.dex */
    public static class b<Model> implements ji<Model> {
        public final Model c;

        public b(Model model) {
            this.c = model;
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super Model> aVar) {
            aVar.a((ji.a<? super Model>) ((Model) this.c));
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
        public Class<Model> a() {
            return (Class<Model>) this.c.getClass();
        }
    }

    @Override // defpackage.nl
    public nl.a<Model> a(Model model, int i, int i2, bi biVar) {
        return new nl.a<>(new iq(model), new b(model));
    }

    @Override // defpackage.nl
    public boolean a(Model model) {
        return true;
    }
}
