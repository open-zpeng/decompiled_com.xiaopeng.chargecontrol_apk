package defpackage;
/* compiled from: AppendOnlyLinkedArrayList.java */
/* renamed from: dk0  reason: default package */
/* loaded from: classes.dex */
public class dk0<T> {
    public final int a;
    public final Object[] b;
    public Object[] c;
    public int d;

    public dk0(int i) {
        this.a = i;
        this.b = new Object[i + 1];
        this.c = this.b;
    }

    public void a(T t) {
        int i = this.a;
        int i2 = this.d;
        if (i2 == i) {
            Object[] objArr = new Object[i + 1];
            this.c[i] = objArr;
            this.c = objArr;
            i2 = 0;
        }
        this.c[i2] = t;
        this.d = i2 + 1;
    }
}
