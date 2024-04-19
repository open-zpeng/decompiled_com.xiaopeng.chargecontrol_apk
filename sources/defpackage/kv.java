package defpackage;

import java.util.concurrent.ConcurrentHashMap;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: kv  reason: default package */
/* loaded from: classes.dex */
public class kv<T> implements cw<T> {
    public kv(pv pvVar) {
    }

    @Override // defpackage.cw
    public T a() {
        return (T) new ConcurrentHashMap();
    }
}
