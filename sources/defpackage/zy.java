package defpackage;
/* compiled from: AbstractEvent.java */
/* renamed from: zy  reason: default package */
/* loaded from: classes.dex */
public abstract class zy<T> implements fy<T> {
    public T a;

    @Override // defpackage.fy
    public T getData() {
        return this.a;
    }

    public String toString() {
        return getClass().getSimpleName() + " = " + this.a;
    }
}
