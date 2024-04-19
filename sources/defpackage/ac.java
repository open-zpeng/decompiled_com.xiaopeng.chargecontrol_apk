package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
/* compiled from: FragmentActivity.java */
/* renamed from: ac  reason: default package */
/* loaded from: classes.dex */
public class ac implements p {
    public final /* synthetic */ bc a;

    public ac(bc bcVar) {
        this.a = bcVar;
    }

    @Override // defpackage.p
    public void a(Context context) {
        lc<?> lcVar = this.a.k.a;
        lcVar.f.a(lcVar, lcVar, null);
        Bundle a = this.a.u().a("android:support:fragments");
        if (a != null) {
            Parcelable parcelable = a.getParcelable("android:support:fragments");
            lc<?> lcVar2 = this.a.k.a;
            if (lcVar2 instanceof oe) {
                lcVar2.f.a(parcelable);
                return;
            }
            throw new IllegalStateException("Your FragmentHostCallback must implement ViewModelStoreOwner to call restoreSaveState(). Call restoreAllState()  if you're still using retainNestedNonConfig().");
        }
    }
}
