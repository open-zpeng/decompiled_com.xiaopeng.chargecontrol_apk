package defpackage;

import defpackage.vg;
/* compiled from: TransitionOptions.java */
/* renamed from: vg  reason: default package */
/* loaded from: classes.dex */
public abstract class vg<CHILD extends vg<CHILD, TranscodeType>, TranscodeType> implements Cloneable {
    public gq<? super TranscodeType> c = (gq<? super TranscodeType>) eq.b;

    public final CHILD clone() {
        try {
            return (CHILD) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
