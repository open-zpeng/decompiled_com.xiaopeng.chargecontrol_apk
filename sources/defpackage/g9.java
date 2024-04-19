package defpackage;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import defpackage.d2;
/* compiled from: ActionProvider.java */
/* renamed from: g9  reason: default package */
/* loaded from: classes.dex */
public abstract class g9 {
    public b a;

    /* compiled from: ActionProvider.java */
    /* renamed from: g9$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    /* compiled from: ActionProvider.java */
    /* renamed from: g9$b */
    /* loaded from: classes.dex */
    public interface b {
    }

    public g9(Context context) {
    }

    public View a(MenuItem menuItem) {
        return ((d2.a) this).b.onCreateActionView();
    }

    public boolean a() {
        return true;
    }

    public boolean b() {
        return false;
    }

    public void a(b bVar) {
        if (this.a != null && bVar != null) {
            StringBuilder a2 = jg.a("setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this ");
            a2.append(getClass().getSimpleName());
            a2.append(" instance while it is still in use somewhere else?");
            Log.w("ActionProvider(support)", a2.toString());
        }
        this.a = bVar;
    }
}
