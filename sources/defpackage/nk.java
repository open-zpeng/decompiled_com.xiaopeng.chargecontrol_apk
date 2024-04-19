package defpackage;

import android.graphics.Bitmap;
import android.os.Build;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
/* compiled from: SizeConfigStrategy.java */
/* renamed from: nk  reason: default package */
/* loaded from: classes.dex */
public class nk implements lk {
    public static final Bitmap.Config[] d;
    public static final Bitmap.Config[] e;
    public static final Bitmap.Config[] f;
    public static final Bitmap.Config[] g;
    public static final Bitmap.Config[] h;
    public final c a = new c();
    public final hk<b, Bitmap> b = new hk<>();
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> c = new HashMap();

    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: nk$a */
    /* loaded from: classes.dex */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a = new int[Bitmap.Config.values().length];

        static {
            try {
                a[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: nk$b */
    /* loaded from: classes.dex */
    public static final class b implements mk {
        public final c a;
        public int b;
        public Bitmap.Config c;

        public b(c cVar) {
            this.a = cVar;
        }

        @Override // defpackage.mk
        public void a() {
            this.a.a(this);
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return this.b == bVar.b && sq.b(this.c, bVar.c);
            }
            return false;
        }

        public int hashCode() {
            int i = this.b * 31;
            Bitmap.Config config = this.c;
            return i + (config != null ? config.hashCode() : 0);
        }

        public String toString() {
            return nk.a(this.b, this.c);
        }
    }

    static {
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        int i = Build.VERSION.SDK_INT;
        Bitmap.Config[] configArr2 = (Bitmap.Config[]) Arrays.copyOf(configArr, configArr.length + 1);
        configArr2[configArr2.length - 1] = Bitmap.Config.RGBA_F16;
        d = configArr2;
        e = d;
        f = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        g = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        h = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    @Override // defpackage.lk
    public void a(Bitmap bitmap) {
        b a2 = this.a.a(sq.a(bitmap), bitmap.getConfig());
        this.b.a(a2, bitmap);
        NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
        Integer num = (Integer) a3.get(Integer.valueOf(a2.b));
        a3.put(Integer.valueOf(a2.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // defpackage.lk
    public String b(int i, int i2, Bitmap.Config config) {
        return a(sq.a(i, i2, config), config);
    }

    @Override // defpackage.lk
    public String c(Bitmap bitmap) {
        return a(sq.a(bitmap), bitmap.getConfig());
    }

    public String toString() {
        StringBuilder a2 = jg.a("SizeConfigStrategy{groupedMap=");
        a2.append(this.b);
        a2.append(", sortedSizes=(");
        for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.c.entrySet()) {
            a2.append(entry.getKey());
            a2.append('[');
            a2.append(entry.getValue());
            a2.append("], ");
        }
        if (!this.c.isEmpty()) {
            a2.replace(a2.length() - 2, a2.length(), "");
        }
        a2.append(")}");
        return a2.toString();
    }

    /* compiled from: SizeConfigStrategy.java */
    /* renamed from: nk$c */
    /* loaded from: classes.dex */
    public static class c extends dk<b> {
        public b a(int i, Bitmap.Config config) {
            b b = b();
            b.b = i;
            b.c = config;
            return b;
        }

        @Override // defpackage.dk
        public b a() {
            return new b(this);
        }
    }

    @Override // defpackage.lk
    public int b(Bitmap bitmap) {
        return sq.a(bitmap);
    }

    @Override // defpackage.lk
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        Bitmap.Config[] configArr;
        int a2 = sq.a(i, i2, config);
        b b2 = this.a.b();
        b2.b = a2;
        b2.c = config;
        int i3 = Build.VERSION.SDK_INT;
        int i4 = 0;
        if (Bitmap.Config.RGBA_F16.equals(config)) {
            configArr = e;
        } else {
            int i5 = a.a[config.ordinal()];
            if (i5 == 1) {
                configArr = d;
            } else if (i5 == 2) {
                configArr = f;
            } else if (i5 != 3) {
                configArr = i5 != 4 ? new Bitmap.Config[]{config} : h;
            } else {
                configArr = g;
            }
        }
        int length = configArr.length;
        while (true) {
            if (i4 >= length) {
                break;
            }
            Bitmap.Config config2 = configArr[i4];
            Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(a2));
            if (ceilingKey == null || ceilingKey.intValue() > a2 * 8) {
                i4++;
            } else if (ceilingKey.intValue() != a2 || (config2 != null ? !config2.equals(config) : config != null)) {
                this.a.a(b2);
                b2 = this.a.a(ceilingKey.intValue(), config2);
            }
        }
        Bitmap a3 = this.b.a((hk<b, Bitmap>) b2);
        if (a3 != null) {
            a(Integer.valueOf(b2.b), a3);
            a3.reconfigure(i, i2, config);
        }
        return a3;
    }

    @Override // defpackage.lk
    public Bitmap a() {
        Bitmap a2 = this.b.a();
        if (a2 != null) {
            a(Integer.valueOf(sq.a(a2)), a2);
        }
        return a2;
    }

    public final void a(Integer num, Bitmap bitmap) {
        NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
        Integer num2 = (Integer) a2.get(num);
        if (num2 != null) {
            if (num2.intValue() == 1) {
                a2.remove(num);
                return;
            } else {
                a2.put(num, Integer.valueOf(num2.intValue() - 1));
                return;
            }
        }
        throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + c(bitmap) + ", this: " + this);
    }

    public final NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        NavigableMap<Integer, Integer> navigableMap = this.c.get(config);
        if (navigableMap == null) {
            TreeMap treeMap = new TreeMap();
            this.c.put(config, treeMap);
            return treeMap;
        }
        return navigableMap;
    }

    public static String a(int i, Bitmap.Config config) {
        return "[" + i + "](" + config + ")";
    }
}
