package defpackage;

import android.os.Build;
/* compiled from: DownsampleStrategy.java */
/* renamed from: rm  reason: default package */
/* loaded from: classes.dex */
public abstract class rm {
    public static final rm a = new c();
    public static final rm b = new a();
    public static final rm c = new b();
    public static final rm d = new d();
    public static final rm e = c;
    public static final ai<rm> f = ai.a("com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy", e);
    public static final boolean g;

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: rm$a */
    /* loaded from: classes.dex */
    public static class a extends rm {
        @Override // defpackage.rm
        public e a(int i, int i2, int i3, int i4) {
            if (b(i, i2, i3, i4) == 1.0f) {
                return e.QUALITY;
            }
            return rm.a.a(i, i2, i3, i4);
        }

        @Override // defpackage.rm
        public float b(int i, int i2, int i3, int i4) {
            return Math.min(1.0f, rm.a.b(i, i2, i3, i4));
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: rm$b */
    /* loaded from: classes.dex */
    public static class b extends rm {
        @Override // defpackage.rm
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.rm
        public float b(int i, int i2, int i3, int i4) {
            return Math.max(i3 / i, i4 / i2);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: rm$c */
    /* loaded from: classes.dex */
    public static class c extends rm {
        @Override // defpackage.rm
        public e a(int i, int i2, int i3, int i4) {
            if (rm.g) {
                return e.QUALITY;
            }
            return e.MEMORY;
        }

        @Override // defpackage.rm
        public float b(int i, int i2, int i3, int i4) {
            if (rm.g) {
                return Math.min(i3 / i, i4 / i2);
            }
            int max = Math.max(i2 / i4, i / i3);
            if (max == 0) {
                return 1.0f;
            }
            return 1.0f / Integer.highestOneBit(max);
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: rm$d */
    /* loaded from: classes.dex */
    public static class d extends rm {
        @Override // defpackage.rm
        public e a(int i, int i2, int i3, int i4) {
            return e.QUALITY;
        }

        @Override // defpackage.rm
        public float b(int i, int i2, int i3, int i4) {
            return 1.0f;
        }
    }

    /* compiled from: DownsampleStrategy.java */
    /* renamed from: rm$e */
    /* loaded from: classes.dex */
    public enum e {
        MEMORY,
        QUALITY
    }

    static {
        int i = Build.VERSION.SDK_INT;
        g = true;
    }

    public abstract e a(int i, int i2, int i3, int i4);

    public abstract float b(int i, int i2, int i3, int i4);
}
