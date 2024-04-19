package defpackage;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
/* compiled from: SpscLinkedArrayQueue.java */
/* renamed from: nj0  reason: default package */
/* loaded from: classes.dex */
public final class nj0<T> implements fi0<T> {
    public static final int k = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096).intValue();
    public static final Object l = new Object();
    public int d;
    public long e;
    public final int f;
    public AtomicReferenceArray<Object> g;
    public final int h;
    public AtomicReferenceArray<Object> i;
    public final AtomicLong c = new AtomicLong();
    public final AtomicLong j = new AtomicLong();

    public nj0(int i) {
        int c = z90.c(Math.max(8, i));
        int i2 = c - 1;
        AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(c + 1);
        this.g = atomicReferenceArray;
        this.f = i2;
        this.d = Math.min(c / 4, k);
        this.i = atomicReferenceArray;
        this.h = i2;
        this.e = i2 - 1;
        this.c.lazySet(0L);
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
        return this.c.get() == this.j.get();
    }

    @Override // defpackage.gi0
    public boolean offer(T t) {
        if (t != null) {
            AtomicReferenceArray<Object> atomicReferenceArray = this.g;
            long j = this.c.get();
            int i = this.f;
            int i2 = ((int) j) & i;
            if (j < this.e) {
                atomicReferenceArray.lazySet(i2, t);
                this.c.lazySet(j + 1);
                return true;
            }
            long j2 = this.d + j;
            if (atomicReferenceArray.get(((int) j2) & i) == null) {
                this.e = j2 - 1;
                atomicReferenceArray.lazySet(i2, t);
                this.c.lazySet(j + 1);
                return true;
            }
            long j3 = j + 1;
            if (atomicReferenceArray.get(((int) j3) & i) == null) {
                atomicReferenceArray.lazySet(i2, t);
                this.c.lazySet(j3);
                return true;
            }
            AtomicReferenceArray<Object> atomicReferenceArray2 = new AtomicReferenceArray<>(atomicReferenceArray.length());
            this.g = atomicReferenceArray2;
            this.e = (i + j) - 1;
            atomicReferenceArray2.lazySet(i2, t);
            atomicReferenceArray.lazySet(atomicReferenceArray.length() - 1, atomicReferenceArray2);
            atomicReferenceArray.lazySet(i2, l);
            this.c.lazySet(j3);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // defpackage.fi0, defpackage.gi0
    public T poll() {
        AtomicReferenceArray<Object> atomicReferenceArray = this.i;
        long j = this.j.get();
        int i = this.h;
        int i2 = ((int) j) & i;
        T t = (T) atomicReferenceArray.get(i2);
        boolean z = t == l;
        if (t != null && !z) {
            atomicReferenceArray.lazySet(i2, null);
            this.j.lazySet(j + 1);
            return t;
        } else if (z) {
            int i3 = i + 1;
            AtomicReferenceArray<Object> atomicReferenceArray2 = (AtomicReferenceArray) atomicReferenceArray.get(i3);
            atomicReferenceArray.lazySet(i3, null);
            this.i = atomicReferenceArray2;
            T t2 = (T) atomicReferenceArray2.get(i2);
            if (t2 != null) {
                atomicReferenceArray2.lazySet(i2, null);
                this.j.lazySet(j + 1);
            }
            return t2;
        } else {
            return null;
        }
    }
}
