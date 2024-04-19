package defpackage;

import defpackage.ij;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: LoadPath.java */
/* renamed from: tj  reason: default package */
/* loaded from: classes.dex */
public class tj<Data, ResourceType, Transcode> {
    public final c9<List<Throwable>> a;
    public final List<? extends ij<Data, ResourceType, Transcode>> b;
    public final String c;

    public tj(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<ij<Data, ResourceType, Transcode>> list, c9<List<Throwable>> c9Var) {
        this.a = c9Var;
        if (!list.isEmpty()) {
            this.b = list;
            StringBuilder a = jg.a("Failed LoadPath{");
            a.append(cls.getSimpleName());
            a.append("->");
            a.append(cls2.getSimpleName());
            a.append("->");
            a.append(cls3.getSimpleName());
            a.append("}");
            this.c = a.toString();
            return;
        }
        throw new IllegalArgumentException("Must not be empty.");
    }

    public vj<Transcode> a(ki<Data> kiVar, bi biVar, int i, int i2, ij.a<ResourceType> aVar) {
        List<Throwable> a = this.a.a();
        a.a(a, "Argument must not be null");
        List<Throwable> list = a;
        try {
            int size = this.b.size();
            vj<Transcode> vjVar = null;
            for (int i3 = 0; i3 < size; i3++) {
                try {
                    vjVar = this.b.get(i3).a(kiVar, i, i2, biVar, aVar);
                } catch (qj e) {
                    list.add(e);
                }
                if (vjVar != null) {
                    break;
                }
            }
            if (vjVar != null) {
                return vjVar;
            }
            throw new qj(this.c, new ArrayList(list));
        } finally {
            this.a.a(list);
        }
    }

    public String toString() {
        StringBuilder a = jg.a("LoadPath{decodePaths=");
        a.append(Arrays.toString(this.b.toArray()));
        a.append('}');
        return a.toString();
    }
}
