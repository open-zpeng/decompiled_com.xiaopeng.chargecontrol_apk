package defpackage;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.savedstate.Recreator;
import java.util.Map;
/* compiled from: SavedStateRegistry.java */
@SuppressLint({"RestrictedApi"})
/* renamed from: uf  reason: default package */
/* loaded from: classes.dex */
public final class uf {
    public Bundle b;
    public boolean c;
    public Recreator.a d;
    public x4<String, b> a = new x4<>();
    public boolean e = true;

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: uf$a */
    /* loaded from: classes.dex */
    public interface a {
        void a(wf wfVar);
    }

    /* compiled from: SavedStateRegistry.java */
    /* renamed from: uf$b */
    /* loaded from: classes.dex */
    public interface b {
        Bundle a();
    }

    public Bundle a(String str) {
        if (this.c) {
            Bundle bundle = this.b;
            if (bundle != null) {
                Bundle bundle2 = bundle.getBundle(str);
                this.b.remove(str);
                if (this.b.isEmpty()) {
                    this.b = null;
                }
                return bundle2;
            }
            return null;
        }
        throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
    }

    public void a(String str, b bVar) {
        if (this.a.b(str, bVar) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public void a(Class<? extends a> cls) {
        if (this.e) {
            if (this.d == null) {
                this.d = new Recreator.a(this);
            }
            try {
                cls.getDeclaredConstructor(new Class[0]);
                Recreator.a aVar = this.d;
                aVar.a.add(cls.getName());
                return;
            } catch (NoSuchMethodException e) {
                StringBuilder a2 = jg.a("Class");
                a2.append(cls.getSimpleName());
                a2.append(" must have default constructor in order to be automatically recreated");
                throw new IllegalArgumentException(a2.toString(), e);
            }
        }
        throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }

    public void a(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = this.b;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        x4<String, b>.d a2 = this.a.a();
        while (a2.hasNext()) {
            Map.Entry next = a2.next();
            bundle2.putBundle((String) next.getKey(), ((b) next.getValue()).a());
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
