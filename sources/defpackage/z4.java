package defpackage;

import java.util.Map;
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ArraySet.java */
/* renamed from: z4  reason: default package */
/* loaded from: classes.dex */
public class z4<E> extends e5<E, E> {
    public final /* synthetic */ a5 d;

    public z4(a5 a5Var) {
        this.d = a5Var;
    }

    @Override // defpackage.e5
    public Object a(int i, int i2) {
        return this.d.d[i];
    }

    @Override // defpackage.e5
    public int b(Object obj) {
        return this.d.a(obj);
    }

    @Override // defpackage.e5
    public int c() {
        return this.d.e;
    }

    @Override // defpackage.e5
    public int a(Object obj) {
        return this.d.a(obj);
    }

    @Override // defpackage.e5
    public Map<E, E> b() {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // defpackage.e5
    public void a(E e, E e2) {
        this.d.add(e);
    }

    @Override // defpackage.e5
    public E a(int i, E e) {
        throw new UnsupportedOperationException("not a map");
    }

    @Override // defpackage.e5
    public void a(int i) {
        this.d.b(i);
    }

    @Override // defpackage.e5
    public void a() {
        this.d.clear();
    }
}
