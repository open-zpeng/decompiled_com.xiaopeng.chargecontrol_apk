package defpackage;

import java.util.Collections;
import java.util.Set;
/* compiled from: PersistentTasks.java */
/* renamed from: g80  reason: default package */
/* loaded from: classes.dex */
public class g80 implements i80 {
    public final Set<i80> a = Collections.unmodifiableSet(c70.a);

    @Override // defpackage.i80
    public void start() {
        for (i80 i80Var : this.a) {
            i80Var.start();
        }
    }

    @Override // defpackage.i80
    public void stop() {
        for (i80 i80Var : this.a) {
            i80Var.stop();
        }
    }
}
