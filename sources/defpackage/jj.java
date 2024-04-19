package defpackage;
/* compiled from: DiskCacheStrategy.java */
/* renamed from: jj  reason: default package */
/* loaded from: classes.dex */
public abstract class jj {
    public static final jj a = new a();
    public static final jj b = new b();
    public static final jj c = new c();

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: jj$a */
    /* loaded from: classes.dex */
    public class a extends jj {
        @Override // defpackage.jj
        public boolean a() {
            return false;
        }

        @Override // defpackage.jj
        public boolean a(uh uhVar) {
            return false;
        }

        @Override // defpackage.jj
        public boolean a(boolean z, uh uhVar, wh whVar) {
            return false;
        }

        @Override // defpackage.jj
        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: jj$b */
    /* loaded from: classes.dex */
    public class b extends jj {
        @Override // defpackage.jj
        public boolean a() {
            return true;
        }

        @Override // defpackage.jj
        public boolean a(uh uhVar) {
            return (uhVar == uh.DATA_DISK_CACHE || uhVar == uh.MEMORY_CACHE) ? false : true;
        }

        @Override // defpackage.jj
        public boolean a(boolean z, uh uhVar, wh whVar) {
            return false;
        }

        @Override // defpackage.jj
        public boolean b() {
            return false;
        }
    }

    /* compiled from: DiskCacheStrategy.java */
    /* renamed from: jj$c */
    /* loaded from: classes.dex */
    public class c extends jj {
        @Override // defpackage.jj
        public boolean a() {
            return true;
        }

        @Override // defpackage.jj
        public boolean a(uh uhVar) {
            return uhVar == uh.REMOTE;
        }

        @Override // defpackage.jj
        public boolean b() {
            return true;
        }

        @Override // defpackage.jj
        public boolean a(boolean z, uh uhVar, wh whVar) {
            return ((z && uhVar == uh.DATA_DISK_CACHE) || uhVar == uh.LOCAL) && whVar == wh.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean a(uh uhVar);

    public abstract boolean a(boolean z, uh uhVar, wh whVar);

    public abstract boolean b();
}
