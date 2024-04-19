package defpackage;

import android.os.Bundle;
import java.io.FileDescriptor;
import java.io.PrintWriter;
/* compiled from: LoaderManagerImpl.java */
/* renamed from: se  reason: default package */
/* loaded from: classes.dex */
public class se extends re {
    public final zd a;
    public final b b;

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: se$a */
    /* loaded from: classes.dex */
    public static class a<D> extends ee<D> implements te<D> {
        public final int k;
        public final Bundle l;
        public zd m;

        @Override // androidx.lifecycle.LiveData
        public void a() {
            throw null;
        }

        @Override // androidx.lifecycle.LiveData
        public void b() {
            throw null;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(64);
            sb.append("LoaderInfo{");
            sb.append(Integer.toHexString(System.identityHashCode(this)));
            sb.append(" #");
            sb.append(this.k);
            sb.append(" : ");
            defpackage.a.a((Object) null, sb);
            sb.append("}}");
            return sb.toString();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.lifecycle.LiveData
        public void a(fe<? super D> feVar) {
            super.a((fe) feVar);
            this.m = null;
        }

        /* JADX WARN: Incorrect return type in method signature: (Z)Ljava/lang/Object<TD;>; */
        public void a(boolean z) {
            throw null;
        }

        @Override // defpackage.ee, androidx.lifecycle.LiveData
        public void a(D d) {
            super.a((a<D>) d);
        }
    }

    /* compiled from: LoaderManagerImpl.java */
    /* renamed from: se$b */
    /* loaded from: classes.dex */
    public static class b extends je {
        public static final ke c = new a();
        public g5<a> b = new g5<>();

        /* compiled from: LoaderManagerImpl.java */
        /* renamed from: se$b$a */
        /* loaded from: classes.dex */
        public static class a implements ke {
            @Override // defpackage.ke
            public <T extends je> T a(Class<T> cls) {
                return new b();
            }
        }

        public void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.b.b() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                String str2 = str + "    ";
                if (this.b.b() <= 0) {
                    return;
                }
                a b = this.b.b(0);
                printWriter.print(str);
                printWriter.print("  #");
                g5<a> g5Var = this.b;
                if (g5Var.c) {
                    g5Var.a();
                }
                printWriter.print(g5Var.d[0]);
                printWriter.print(": ");
                printWriter.println(b.toString());
                printWriter.print(str2);
                printWriter.print("mId=");
                printWriter.print(b.k);
                printWriter.print(" mArgs=");
                printWriter.println(b.l);
                printWriter.print(str2);
                printWriter.print("mLoader=");
                printWriter.println((Object) null);
                String str3 = str2 + "  ";
                throw null;
            }
        }

        @Override // defpackage.je
        public void b() {
            if (this.b.b() <= 0) {
                g5<a> g5Var = this.b;
                int i = g5Var.f;
                Object[] objArr = g5Var.e;
                for (int i2 = 0; i2 < i; i2++) {
                    objArr[i2] = null;
                }
                g5Var.f = 0;
                g5Var.c = false;
                return;
            }
            this.b.b(0).a(true);
            throw null;
        }

        public void c() {
            int b = this.b.b();
            for (int i = 0; i < b; i++) {
                zd zdVar = this.b.b(i).m;
            }
        }
    }

    public se(zd zdVar, ne neVar) {
        je a2;
        this.a = zdVar;
        ke keVar = b.c;
        String canonicalName = b.class.getCanonicalName();
        if (canonicalName != null) {
            String str = "androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName;
            je a3 = neVar.a(str);
            if (b.class.isInstance(a3)) {
                if (keVar instanceof me) {
                    ((me) keVar).a();
                }
            } else {
                if (keVar instanceof le) {
                    a2 = ((le) keVar).a(str, b.class);
                } else {
                    a2 = keVar.a(b.class);
                }
                a3 = a2;
                je put = neVar.a.put(str, a3);
                if (put != null) {
                    put.b();
                }
            }
            this.b = (b) a3;
            return;
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        defpackage.a.a((Object) this.a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
