package defpackage;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLongArray;
/* compiled from: Gson.java */
/* renamed from: ku  reason: default package */
/* loaded from: classes.dex */
public class ku extends bv<AtomicLongArray> {
    public final /* synthetic */ bv a;

    public ku(bv bvVar) {
        this.a = bvVar;
    }

    @Override // defpackage.bv
    public AtomicLongArray read(gx gxVar) {
        ArrayList arrayList = new ArrayList();
        gxVar.a();
        while (gxVar.h()) {
            arrayList.add(Long.valueOf(((Number) this.a.read(gxVar)).longValue()));
        }
        gxVar.e();
        int size = arrayList.size();
        AtomicLongArray atomicLongArray = new AtomicLongArray(size);
        for (int i = 0; i < size; i++) {
            atomicLongArray.set(i, ((Long) arrayList.get(i)).longValue());
        }
        return atomicLongArray;
    }

    @Override // defpackage.bv
    public void write(ix ixVar, AtomicLongArray atomicLongArray) {
        AtomicLongArray atomicLongArray2 = atomicLongArray;
        ixVar.b();
        int length = atomicLongArray2.length();
        for (int i = 0; i < length; i++) {
            this.a.write(ixVar, Long.valueOf(atomicLongArray2.get(i)));
        }
        ixVar.d();
    }
}
