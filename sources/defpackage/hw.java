package defpackage;
/* compiled from: UnsafeAllocator.java */
/* renamed from: hw  reason: default package */
/* loaded from: classes.dex */
public class hw extends iw {
    @Override // defpackage.iw
    public <T> T a(Class<T> cls) {
        throw new UnsupportedOperationException("Cannot allocate " + cls);
    }
}
