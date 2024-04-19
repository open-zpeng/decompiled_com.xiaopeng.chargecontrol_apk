package defpackage;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
/* compiled from: ActionMode.java */
/* renamed from: l1  reason: default package */
/* loaded from: classes.dex */
public abstract class l1 {
    public Object c;
    public boolean d;

    /* compiled from: ActionMode.java */
    /* renamed from: l1$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(l1 l1Var);

        boolean a(l1 l1Var, Menu menu);

        boolean a(l1 l1Var, MenuItem menuItem);

        boolean b(l1 l1Var, Menu menu);
    }

    public abstract void a();

    public abstract void a(int i);

    public abstract void a(View view);

    public abstract void a(CharSequence charSequence);

    public abstract void a(boolean z);

    public abstract View b();

    public abstract void b(int i);

    public abstract void b(CharSequence charSequence);

    public abstract Menu c();

    public abstract MenuInflater d();

    public abstract CharSequence e();

    public abstract CharSequence f();

    public abstract void g();

    public abstract boolean h();
}
