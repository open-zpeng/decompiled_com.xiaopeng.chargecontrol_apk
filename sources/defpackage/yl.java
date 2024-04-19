package defpackage;

import defpackage.nl;
import java.io.InputStream;
/* compiled from: HttpGlideUrlLoader.java */
/* renamed from: yl  reason: default package */
/* loaded from: classes.dex */
public class yl implements nl<gl, InputStream> {
    public static final ai<Integer> b = ai.a("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    public final ml<gl, gl> a;

    /* compiled from: HttpGlideUrlLoader.java */
    /* renamed from: yl$a */
    /* loaded from: classes.dex */
    public static class a implements ol<gl, InputStream> {
        public final ml<gl, gl> a = new ml<>(500);

        @Override // defpackage.ol
        public nl<gl, InputStream> a(rl rlVar) {
            return new yl(this.a);
        }
    }

    public yl(ml<gl, gl> mlVar) {
        this.a = mlVar;
    }

    @Override // defpackage.nl
    public nl.a<InputStream> a(gl glVar, int i, int i2, bi biVar) {
        gl glVar2 = glVar;
        ml<gl, gl> mlVar = this.a;
        if (mlVar != null) {
            gl a2 = mlVar.a(glVar2, 0, 0);
            if (a2 == null) {
                this.a.a(glVar2, 0, 0, glVar2);
            } else {
                glVar2 = a2;
            }
        }
        return new nl.a<>(glVar2, new pi(glVar2, ((Integer) biVar.a(b)).intValue()));
    }

    @Override // defpackage.nl
    public boolean a(gl glVar) {
        return true;
    }
}
