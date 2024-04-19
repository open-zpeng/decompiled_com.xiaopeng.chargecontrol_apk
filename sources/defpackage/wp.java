package defpackage;

import android.graphics.drawable.Drawable;
/* compiled from: CustomTarget.java */
/* renamed from: wp  reason: default package */
/* loaded from: classes.dex */
public abstract class wp<T> implements cq<T> {
    public final int c;
    public final int d;
    public np e;

    public wp() {
        if (sq.a(Integer.MIN_VALUE, Integer.MIN_VALUE)) {
            this.c = Integer.MIN_VALUE;
            this.d = Integer.MIN_VALUE;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: -2147483648 and height: -2147483648");
    }

    @Override // defpackage.ro
    public void a() {
    }

    @Override // defpackage.cq
    public void a(Drawable drawable) {
    }

    @Override // defpackage.cq
    public final void a(bq bqVar) {
    }

    @Override // defpackage.cq
    public final void a(np npVar) {
        this.e = npVar;
    }

    @Override // defpackage.ro
    public void b() {
    }

    @Override // defpackage.cq
    public void b(Drawable drawable) {
    }

    @Override // defpackage.cq
    public final void b(bq bqVar) {
        ((sp) bqVar).a(this.c, this.d);
    }

    @Override // defpackage.cq
    public final np c() {
        return this.e;
    }

    @Override // defpackage.ro
    public void onStart() {
    }
}
