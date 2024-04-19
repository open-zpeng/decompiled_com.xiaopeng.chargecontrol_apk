package defpackage;

import java.util.concurrent.atomic.AtomicLong;
/* compiled from: Gson.java */
/* renamed from: ju  reason: default package */
/* loaded from: classes.dex */
public class ju extends bv<AtomicLong> {
    public final /* synthetic */ bv a;

    public ju(bv bvVar) {
        this.a = bvVar;
    }

    @Override // defpackage.bv
    public AtomicLong read(gx gxVar) {
        return new AtomicLong(((Number) this.a.read(gxVar)).longValue());
    }

    @Override // defpackage.bv
    public void write(ix ixVar, AtomicLong atomicLong) {
        this.a.write(ixVar, Long.valueOf(atomicLong.get()));
    }
}
