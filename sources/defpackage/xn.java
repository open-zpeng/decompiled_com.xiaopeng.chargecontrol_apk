package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import java.security.MessageDigest;
/* compiled from: GifDrawableTransformation.java */
/* renamed from: xn  reason: default package */
/* loaded from: classes.dex */
public class xn implements fi<un> {
    public final fi<Bitmap> b;

    public xn(fi<Bitmap> fiVar) {
        a.a(fiVar, "Argument must not be null");
        this.b = fiVar;
    }

    @Override // defpackage.fi
    public vj<un> a(Context context, vj<un> vjVar, int i, int i2) {
        un a = vjVar.a();
        vj<Bitmap> kmVar = new km(a.b(), lg.a(context).c);
        vj<Bitmap> a2 = this.b.a(context, kmVar, i, i2);
        if (!kmVar.equals(a2)) {
            kmVar.d();
        }
        fi<Bitmap> fiVar = this.b;
        a.c.a.a(fiVar, a2.a());
        return vjVar;
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof xn) {
            return this.b.equals(((xn) obj).b);
        }
        return false;
    }

    @Override // defpackage.zh
    public int hashCode() {
        return this.b.hashCode();
    }

    @Override // defpackage.zh
    public void a(MessageDigest messageDigest) {
        this.b.a(messageDigest);
    }
}
