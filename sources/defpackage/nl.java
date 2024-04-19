package defpackage;

import java.util.Collections;
import java.util.List;
/* compiled from: ModelLoader.java */
/* renamed from: nl  reason: default package */
/* loaded from: classes.dex */
public interface nl<Model, Data> {

    /* compiled from: ModelLoader.java */
    /* renamed from: nl$a */
    /* loaded from: classes.dex */
    public static class a<Data> {
        public final zh a;
        public final List<zh> b;
        public final ji<Data> c;

        public a(zh zhVar, ji<Data> jiVar) {
            List<zh> emptyList = Collections.emptyList();
            defpackage.a.a(zhVar, "Argument must not be null");
            this.a = zhVar;
            defpackage.a.a(emptyList, "Argument must not be null");
            this.b = emptyList;
            defpackage.a.a(jiVar, "Argument must not be null");
            this.c = jiVar;
        }
    }

    a<Data> a(Model model, int i, int i2, bi biVar);

    boolean a(Model model);
}
