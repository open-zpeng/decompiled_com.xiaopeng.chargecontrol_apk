package defpackage;

import defpackage.dh0;
import java.util.concurrent.ThreadFactory;
/* compiled from: NewThreadScheduler.java */
/* renamed from: sj0  reason: default package */
/* loaded from: classes.dex */
public final class sj0 extends dh0 {
    public static final vj0 c = new vj0("RxNewThreadScheduler", Math.max(1, Math.min(10, Integer.getInteger("rx2.newthread-priority", 5).intValue())));
    public final ThreadFactory b = c;

    @Override // defpackage.dh0
    public dh0.c a() {
        return new tj0(this.b);
    }
}
