package defpackage;

import defpackage.ji;
import defpackage.nl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: MultiModelLoader.java */
/* renamed from: ql  reason: default package */
/* loaded from: classes.dex */
public class ql<Model, Data> implements nl<Model, Data> {
    public final List<nl<Model, Data>> a;
    public final c9<List<Throwable>> b;

    public ql(List<nl<Model, Data>> list, c9<List<Throwable>> c9Var) {
        this.a = list;
        this.b = c9Var;
    }

    @Override // defpackage.nl
    public nl.a<Data> a(Model model, int i, int i2, bi biVar) {
        nl.a<Data> a2;
        int size = this.a.size();
        ArrayList arrayList = new ArrayList(size);
        zh zhVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            nl<Model, Data> nlVar = this.a.get(i3);
            if (nlVar.a(model) && (a2 = nlVar.a(model, i, i2, biVar)) != null) {
                zhVar = a2.a;
                arrayList.add(a2.c);
            }
        }
        if (arrayList.isEmpty() || zhVar == null) {
            return null;
        }
        return new nl.a<>(zhVar, new a(arrayList, this.b));
    }

    public String toString() {
        StringBuilder a2 = jg.a("MultiModelLoader{modelLoaders=");
        a2.append(Arrays.toString(this.a.toArray()));
        a2.append('}');
        return a2.toString();
    }

    /* compiled from: MultiModelLoader.java */
    /* renamed from: ql$a */
    /* loaded from: classes.dex */
    public static class a<Data> implements ji<Data>, ji.a<Data> {
        public final List<ji<Data>> c;
        public final c9<List<Throwable>> d;
        public int e;
        public qg f;
        public ji.a<? super Data> g;
        public List<Throwable> h;
        public boolean i;

        public a(List<ji<Data>> list, c9<List<Throwable>> c9Var) {
            this.d = c9Var;
            if (!list.isEmpty()) {
                this.c = list;
                this.e = 0;
                return;
            }
            throw new IllegalArgumentException("Must not be empty.");
        }

        @Override // defpackage.ji
        public void a(qg qgVar, ji.a<? super Data> aVar) {
            this.f = qgVar;
            this.g = aVar;
            this.h = this.d.a();
            this.c.get(this.e).a(qgVar, this);
            if (this.i) {
                cancel();
            }
        }

        @Override // defpackage.ji
        public void b() {
            List<Throwable> list = this.h;
            if (list != null) {
                this.d.a(list);
            }
            this.h = null;
            for (ji<Data> jiVar : this.c) {
                jiVar.b();
            }
        }

        @Override // defpackage.ji
        public uh c() {
            return this.c.get(0).c();
        }

        @Override // defpackage.ji
        public void cancel() {
            this.i = true;
            for (ji<Data> jiVar : this.c) {
                jiVar.cancel();
            }
        }

        public final void d() {
            if (this.i) {
                return;
            }
            if (this.e < this.c.size() - 1) {
                this.e++;
                a(this.f, this.g);
                return;
            }
            defpackage.a.a(this.h, "Argument must not be null");
            this.g.a((Exception) new qj("Fetch failed", new ArrayList(this.h)));
        }

        @Override // defpackage.ji
        public Class<Data> a() {
            return this.c.get(0).a();
        }

        @Override // defpackage.ji.a
        public void a(Data data) {
            if (data != null) {
                this.g.a((ji.a<? super Data>) data);
            } else {
                d();
            }
        }

        @Override // defpackage.ji.a
        public void a(Exception exc) {
            List<Throwable> list = this.h;
            defpackage.a.a(list, "Argument must not be null");
            list.add(exc);
            d();
        }
    }

    @Override // defpackage.nl
    public boolean a(Model model) {
        for (nl<Model, Data> nlVar : this.a) {
            if (nlVar.a(model)) {
                return true;
            }
        }
        return false;
    }
}
