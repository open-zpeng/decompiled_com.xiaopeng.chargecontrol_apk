package defpackage;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.util.Log;
/* compiled from: CarControlManager.java */
/* renamed from: qb0  reason: default package */
/* loaded from: classes.dex */
public class qb0 extends ContentObserver {
    public final /* synthetic */ rb0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qb0(final rb0 this$0, Handler x0) {
        super(x0);
        this.a = this$0;
    }

    @Override // android.database.ContentObserver
    public void onChange(boolean selfChange, Uri uri) {
        boolean z;
        if (uri == null) {
            return;
        }
        Log.d("CarControlManager", "onChange: " + uri);
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            return;
        }
        int hashCode = lastPathSegment.hashCode();
        if (hashCode != -366343290) {
            if (hashCode == 1227141723 && lastPathSegment.equals("right_charge_port_state")) {
                z = true;
            }
            z = true;
        } else {
            if (lastPathSegment.equals("left_charge_port_state")) {
                z = false;
            }
            z = true;
        }
        if (!z) {
            rb0 rb0Var = this.a;
            rb0Var.a(true, h00.a(rb0Var.a.getContentResolver(), lastPathSegment, -1));
        } else if (!z) {
        } else {
            rb0 rb0Var2 = this.a;
            rb0Var2.a(false, h00.a(rb0Var2.a.getContentResolver(), lastPathSegment, -1));
        }
    }
}
