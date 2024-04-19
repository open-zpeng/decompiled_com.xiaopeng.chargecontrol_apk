package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
/* compiled from: ActivityResultRegistry.java */
/* renamed from: u  reason: default package */
/* loaded from: classes.dex */
public abstract class u {
    public Random a = new Random();
    public final Map<Integer, String> b = new HashMap();
    public final Map<String, Integer> c = new HashMap();
    public final Map<String, c> d = new HashMap();
    public ArrayList<String> e = new ArrayList<>();
    public final transient Map<String, b<?>> f = new HashMap();
    public final Map<String, Object> g = new HashMap();
    public final Bundle h = new Bundle();

    /* JADX INFO: Add missing generic type declarations: [I] */
    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: u$a */
    /* loaded from: classes.dex */
    public class a<I> extends t<I> {
        public final /* synthetic */ String a;

        public a(String str, int i, w wVar) {
            this.a = str;
        }

        @Override // defpackage.t
        public void a() {
            u.this.a(this.a);
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: u$b */
    /* loaded from: classes.dex */
    public static class b<O> {
        public final r<O> a;
        public final w<?, O> b;

        public b(r<O> rVar, w<?, O> wVar) {
            this.a = rVar;
            this.b = wVar;
        }
    }

    /* compiled from: ActivityResultRegistry.java */
    /* renamed from: u$c */
    /* loaded from: classes.dex */
    public static class c {
        public final vd a;
        public final ArrayList<xd> b;
    }

    public final void a(String str) {
        Integer remove;
        if (!this.e.contains(str) && (remove = this.c.remove(str)) != null) {
            this.b.remove(remove);
        }
        this.f.remove(str);
        if (this.g.containsKey(str)) {
            StringBuilder a2 = jg.a("Dropping pending result for request ", str, ": ");
            a2.append(this.g.get(str));
            Log.w("ActivityResultRegistry", a2.toString());
            this.g.remove(str);
        }
        if (this.h.containsKey(str)) {
            StringBuilder a3 = jg.a("Dropping pending result for request ", str, ": ");
            a3.append(this.h.getParcelable(str));
            Log.w("ActivityResultRegistry", a3.toString());
            this.h.remove(str);
        }
        c cVar = this.d.get(str);
        if (cVar != null) {
            Iterator<xd> it = cVar.b.iterator();
            while (it.hasNext()) {
                cVar.a.b(it.next());
            }
            cVar.b.clear();
            this.d.remove(str);
        }
    }

    public final void b(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.c.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.c.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.e));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.h.clone());
        bundle.putSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT", this.a);
    }

    public final void a(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.e = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.a = (Random) bundle.getSerializable("KEY_COMPONENT_ACTIVITY_RANDOM_OBJECT");
        this.h.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            if (this.c.containsKey(str)) {
                Integer remove = this.c.remove(str);
                if (!this.h.containsKey(str)) {
                    this.b.remove(remove);
                }
            }
            int intValue = integerArrayList.get(i).intValue();
            String str2 = stringArrayList.get(i);
            this.b.put(Integer.valueOf(intValue), str2);
            this.c.put(str2, Integer.valueOf(intValue));
        }
    }

    public final boolean a(int i, int i2, Intent intent) {
        r<?> rVar;
        String str = this.b.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        this.e.remove(str);
        b<?> bVar = this.f.get(str);
        if (bVar != null && (rVar = bVar.a) != null) {
            rVar.a(bVar.b.a(i2, intent));
            return true;
        }
        this.g.remove(str);
        this.h.putParcelable(str, new q(i2, intent));
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <I, O> t<I> a(String str, w<I, O> wVar, r<O> rVar) {
        int i;
        Integer num = this.c.get(str);
        if (num != null) {
            i = num.intValue();
        } else {
            int nextInt = this.a.nextInt(2147418112);
            while (true) {
                i = nextInt + 65536;
                if (!this.b.containsKey(Integer.valueOf(i))) {
                    break;
                }
                nextInt = this.a.nextInt(2147418112);
            }
            this.b.put(Integer.valueOf(i), str);
            this.c.put(str, Integer.valueOf(i));
        }
        this.f.put(str, new b<>(rVar, wVar));
        if (this.g.containsKey(str)) {
            Object obj = this.g.get(str);
            this.g.remove(str);
            rVar.a(obj);
        }
        q qVar = (q) this.h.getParcelable(str);
        if (qVar != null) {
            this.h.remove(str);
            rVar.a(wVar.a(qVar.c, qVar.d));
        }
        return new a(str, i, wVar);
    }
}
