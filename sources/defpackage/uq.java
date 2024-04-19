package defpackage;

import defpackage.tq;
import java.util.ArrayList;
import java.util.List;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FactoryPools.java */
/* renamed from: uq  reason: default package */
/* loaded from: classes.dex */
public class uq<T> implements tq.b<List<T>> {
    @Override // defpackage.tq.b
    public Object a() {
        return new ArrayList();
    }
}
