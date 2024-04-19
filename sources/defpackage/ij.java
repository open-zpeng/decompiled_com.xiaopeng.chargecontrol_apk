package defpackage;

import android.util.Log;
import defpackage.hj;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/* compiled from: DecodePath.java */
/* renamed from: ij  reason: default package */
/* loaded from: classes.dex */
public class ij<DataType, ResourceType, Transcode> {
    public final Class<DataType> a;
    public final List<? extends di<DataType, ResourceType>> b;
    public final go<ResourceType, Transcode> c;
    public final c9<List<Throwable>> d;
    public final String e;

    /* compiled from: DecodePath.java */
    /* renamed from: ij$a */
    /* loaded from: classes.dex */
    public interface a<ResourceType> {
    }

    public ij(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends di<DataType, ResourceType>> list, go<ResourceType, Transcode> goVar, c9<List<Throwable>> c9Var) {
        this.a = cls;
        this.b = list;
        this.c = goVar;
        this.d = c9Var;
        StringBuilder a2 = jg.a("Failed DecodePath{");
        a2.append(cls.getSimpleName());
        a2.append("->");
        a2.append(cls2.getSimpleName());
        a2.append("->");
        a2.append(cls3.getSimpleName());
        a2.append("}");
        this.e = a2.toString();
    }

    public vj<Transcode> a(ki<DataType> kiVar, int i, int i2, bi biVar, a<ResourceType> aVar) {
        List<Throwable> a2 = this.d.a();
        defpackage.a.a(a2, "Argument must not be null");
        List<Throwable> list = a2;
        try {
            vj<ResourceType> a3 = a(kiVar, i, i2, biVar, list);
            this.d.a(list);
            hj.b bVar = (hj.b) aVar;
            return this.c.a(hj.this.a(bVar.a, a3), biVar);
        } catch (Throwable th) {
            this.d.a(list);
            throw th;
        }
    }

    public String toString() {
        StringBuilder a2 = jg.a("DecodePath{ dataClass=");
        a2.append(this.a);
        a2.append(", decoders=");
        a2.append(this.b);
        a2.append(", transcoder=");
        a2.append(this.c);
        a2.append('}');
        return a2.toString();
    }

    public final vj<ResourceType> a(ki<DataType> kiVar, int i, int i2, bi biVar, List<Throwable> list) {
        int size = this.b.size();
        vj<ResourceType> vjVar = null;
        for (int i3 = 0; i3 < size; i3++) {
            di<DataType, ResourceType> diVar = this.b.get(i3);
            try {
                if (diVar.a(kiVar.a(), biVar)) {
                    vjVar = diVar.a(kiVar.a(), i, i2, biVar);
                }
            } catch (IOException | OutOfMemoryError | RuntimeException e) {
                if (Log.isLoggable("DecodePath", 2)) {
                    Log.v("DecodePath", "Failed to decode data for " + diVar, e);
                }
                list.add(e);
            }
            if (vjVar != null) {
                break;
            }
        }
        if (vjVar != null) {
            return vjVar;
        }
        throw new qj(this.e, new ArrayList(list));
    }
}
