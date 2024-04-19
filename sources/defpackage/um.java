package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;
/* compiled from: DrawableTransformation.java */
/* renamed from: um  reason: default package */
/* loaded from: classes.dex */
public class um implements fi<Drawable> {
    public final fi<Bitmap> b;
    public final boolean c;

    public um(fi<Bitmap> fiVar, boolean z) {
        this.b = fiVar;
        this.c = z;
    }

    @Override // defpackage.fi
    public vj<Drawable> a(Context context, vj<Drawable> vjVar, int i, int i2) {
        ek ekVar = lg.a(context).c;
        Drawable a = vjVar.a();
        vj<Bitmap> a2 = tm.a(ekVar, a, i, i2);
        if (a2 == null) {
            if (this.c) {
                throw new IllegalArgumentException("Unable to convert " + a + " to a Bitmap");
            }
            return vjVar;
        }
        vj<Bitmap> a3 = this.b.a(context, a2, i, i2);
        if (a3.equals(a2)) {
            a3.d();
            return vjVar;
        }
        return an.a(context.getResources(), a3);
    }

    @Override // defpackage.zh
    public boolean equals(Object obj) {
        if (obj instanceof um) {
            return this.b.equals(((um) obj).b);
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
