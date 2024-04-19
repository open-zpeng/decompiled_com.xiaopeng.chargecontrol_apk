package defpackage;

import android.annotation.SuppressLint;
import defpackage.wk;
/* compiled from: LruResourceCache.java */
/* renamed from: vk  reason: default package */
/* loaded from: classes.dex */
public class vk extends pq<zh, vj<?>> implements wk {
    public wk.a d;

    public vk(long j) {
        super(j);
    }

    @Override // defpackage.pq
    public void a(zh zhVar, vj<?> vjVar) {
        vj<?> vjVar2 = vjVar;
        wk.a aVar = this.d;
        if (aVar == null || vjVar2 == null) {
            return;
        }
        ((kj) aVar).e.a(vjVar2, true);
    }

    @Override // defpackage.pq
    public int b(vj<?> vjVar) {
        vj<?> vjVar2 = vjVar;
        if (vjVar2 == null) {
            return 1;
        }
        return vjVar2.b();
    }

    /* renamed from: a  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ vj a2(zh zhVar, vj vjVar) {
        return (vj) super.b(zhVar, vjVar);
    }

    public /* bridge */ /* synthetic */ vj a(zh zhVar) {
        return (vj) super.c(zhVar);
    }

    @SuppressLint({"InlinedApi"})
    public void a(int i) {
        if (i >= 40) {
            a(0L);
        } else if (i >= 20 || i == 15) {
            a(b() / 2);
        }
    }
}
