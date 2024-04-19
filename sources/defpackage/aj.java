package defpackage;

import defpackage.zi;
/* compiled from: ActiveResources.java */
/* renamed from: aj  reason: default package */
/* loaded from: classes.dex */
public class aj implements Runnable {
    public final /* synthetic */ zi c;

    public aj(zi ziVar) {
        this.c = ziVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zi ziVar = this.c;
        while (!ziVar.e) {
            try {
                ziVar.a((zi.b) ziVar.c.remove());
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
