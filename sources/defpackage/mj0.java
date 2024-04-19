package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscArrayQueue.java */
/* renamed from: mj0  reason: default package */
/* loaded from: classes.dex */
public final class mj0<E> extends AtomicReferenceArray<E> implements fi0<E> {
    public static final Integer h = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    public final int c;
    public final AtomicLong d;
    public long e;
    public final AtomicLong f;
    public final int g;

    public mj0(int i) {
        super(z90.c(i));
        this.c = length() - 1;
        this.d = new AtomicLong();
        this.f = new AtomicLong();
        this.g = Math.min(i / 4, h.intValue());
    }

    @Override // defpackage.gi0
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // defpackage.gi0
    public boolean isEmpty() {
        return this.d.get() == this.f.get();
    }

    @Override // defpackage.gi0
    public boolean offer(E e) {
        if (e != null) {
            int i = this.c;
            long j = this.d.get();
            int i2 = ((int) j) & i;
            if (j >= this.e) {
                long j2 = this.g + j;
                if (get(i & ((int) j2)) == null) {
                    this.e = j2;
                } else if (get(i2) != null) {
                    return false;
                }
            }
            lazySet(i2, e);
            this.d.lazySet(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // defpackage.fi0, defpackage.gi0
    public E poll() {
        long j = this.f.get();
        int i = ((int) j) & this.c;
        E e = get(i);
        if (e == null) {
            return null;
        }
        this.f.lazySet(j + 1);
        lazySet(i, null);
        return e;
    }
}
