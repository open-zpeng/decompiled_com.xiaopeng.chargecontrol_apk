package defpackage;

import com.bumptech.glide.load.ImageHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/* compiled from: Registry.java */
/* renamed from: sg  reason: default package */
/* loaded from: classes.dex */
public class sg {
    public final ip h = new ip();
    public final hp i = new hp();
    public final c9<List<Throwable>> j = tq.a();
    public final pl a = new pl(this.j);
    public final fp b = new fp();
    public final jp c = new jp();
    public final kp d = new kp();
    public final li e = new li();
    public final ho f = new ho();
    public final gp g = new gp();

    /* compiled from: Registry.java */
    /* renamed from: sg$a */
    /* loaded from: classes.dex */
    public static class a extends RuntimeException {
        public a(String str) {
            super(str);
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: sg$b */
    /* loaded from: classes.dex */
    public static final class b extends a {
        public b() {
            super("Failed to find image header parser.");
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: sg$c */
    /* loaded from: classes.dex */
    public static class c extends a {
        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public c(java.lang.Object r2) {
            /*
                r1 = this;
                java.lang.String r0 = "Failed to find any ModelLoaders registered for model class: "
                java.lang.StringBuilder r0 = defpackage.jg.a(r0)
                java.lang.Class r2 = r2.getClass()
                r0.append(r2)
                java.lang.String r2 = r0.toString()
                r1.<init>(r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: defpackage.sg.c.<init>(java.lang.Object):void");
        }

        public <M> c(M m, List<nl<M, ?>> list) {
            super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m);
        }

        public c(Class<?> cls, Class<?> cls2) {
            super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: sg$d */
    /* loaded from: classes.dex */
    public static class d extends a {
        public d(Class<?> cls) {
            super("Failed to find result encoder for resource class: " + cls + ", you may need to consider registering a new Encoder for the requested type or DiskCacheStrategy.DATA/DiskCacheStrategy.NONE if caching your transformed resource is unnecessary.");
        }
    }

    /* compiled from: Registry.java */
    /* renamed from: sg$e */
    /* loaded from: classes.dex */
    public static class e extends a {
        public e(Class<?> cls) {
            super("Failed to find source encoder for data class: " + cls);
        }
    }

    public sg() {
        List asList = Arrays.asList("Gif", "Bitmap", "BitmapDrawable");
        ArrayList arrayList = new ArrayList(asList.size());
        arrayList.addAll(asList);
        arrayList.add(0, "legacy_prepend_all");
        arrayList.add("legacy_append");
        this.c.a(arrayList);
    }

    public List<ImageHeaderParser> a() {
        List<ImageHeaderParser> a2 = this.g.a();
        if (a2.isEmpty()) {
            throw new b();
        }
        return a2;
    }
}
