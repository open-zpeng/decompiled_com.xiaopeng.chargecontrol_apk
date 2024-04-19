package defpackage;

import defpackage.tq;
import java.util.List;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: FactoryPools.java */
/* renamed from: vq  reason: default package */
/* loaded from: classes.dex */
public class vq<T> implements tq.e<List<T>> {
    @Override // defpackage.tq.e
    public void a(Object obj) {
        ((List) obj).clear();
    }
}
