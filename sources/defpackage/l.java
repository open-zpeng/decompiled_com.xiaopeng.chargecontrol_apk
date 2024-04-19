package defpackage;

import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: OnBackPressedCallback.java */
/* renamed from: l  reason: default package */
/* loaded from: classes.dex */
public abstract class l {
    public boolean a;
    public CopyOnWriteArrayList<k> b = new CopyOnWriteArrayList<>();

    public l(boolean z) {
        this.a = z;
    }

    public void a(k kVar) {
        this.b.add(kVar);
    }
}
