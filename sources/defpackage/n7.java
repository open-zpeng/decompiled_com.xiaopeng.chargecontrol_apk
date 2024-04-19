package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: TaskStackBuilder.java */
/* renamed from: n7  reason: default package */
/* loaded from: classes.dex */
public final class n7 implements Iterable<Intent> {
    public final ArrayList<Intent> c = new ArrayList<>();
    public final Context d;

    /* compiled from: TaskStackBuilder.java */
    /* renamed from: n7$a */
    /* loaded from: classes.dex */
    public interface a {
        Intent b();
    }

    public n7(Context context) {
        this.d = context;
    }

    public n7 a(Activity activity) {
        Intent b = activity instanceof a ? ((a) activity).b() : null;
        if (b == null) {
            b = defpackage.a.a(activity);
        }
        if (b != null) {
            ComponentName component = b.getComponent();
            if (component == null) {
                component = b.resolveActivity(this.d.getPackageManager());
            }
            int size = this.c.size();
            try {
                Intent a2 = defpackage.a.a(this.d, component);
                while (a2 != null) {
                    this.c.add(size, a2);
                    a2 = defpackage.a.a(this.d, a2.getComponent());
                }
                this.c.add(b);
            } catch (PackageManager.NameNotFoundException e) {
                Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
                throw new IllegalArgumentException(e);
            }
        }
        return this;
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.c.iterator();
    }
}
