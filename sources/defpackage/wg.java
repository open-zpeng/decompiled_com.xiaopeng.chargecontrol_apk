package defpackage;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.StrictMode;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: DiskLruCache.java */
/* renamed from: wg  reason: default package */
/* loaded from: classes.dex */
public final class wg implements Closeable {
    public final File c;
    public final File d;
    public final File e;
    public final File f;
    public final int g;
    public long h;
    public final int i;
    public Writer k;
    public int m;
    public long j = 0;
    public final LinkedHashMap<String, d> l = new LinkedHashMap<>(0, 0.75f, true);
    public long n = 0;
    public final ThreadPoolExecutor o = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(null));
    public final Callable<Void> p = new a();

    /* compiled from: DiskLruCache.java */
    /* renamed from: wg$a */
    /* loaded from: classes.dex */
    public class a implements Callable<Void> {
        public a() {
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Void call() {
            call2();
            return null;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Void call2() {
            synchronized (wg.this) {
                if (wg.this.k == null) {
                    return null;
                }
                wg.this.f();
                if (wg.this.b()) {
                    wg.this.e();
                    wg.this.m = 0;
                }
                return null;
            }
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: wg$b */
    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {
        public /* synthetic */ b(a aVar) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            thread = new Thread(runnable, "glide-disk-lru-cache-thread");
            thread.setPriority(1);
            return thread;
        }
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: wg$e */
    /* loaded from: classes.dex */
    public final class e {
        public final File[] a;

        public /* synthetic */ e(wg wgVar, String str, long j, File[] fileArr, long[] jArr, a aVar) {
            this.a = fileArr;
        }
    }

    public wg(File file, int i, int i2, long j) {
        this.c = file;
        this.g = i;
        this.d = new File(file, "journal");
        this.e = new File(file, "journal.tmp");
        this.f = new File(file, "journal.bkp");
        this.i = i2;
        this.h = j;
    }

    public final void b(String str) {
        String substring;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                substring = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.l.remove(substring);
                    return;
                }
            } else {
                substring = str.substring(i, indexOf2);
            }
            d dVar = this.l.get(substring);
            if (dVar == null) {
                dVar = new d(substring, null);
                this.l.put(substring, dVar);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                dVar.e = true;
                dVar.f = null;
                dVar.b(split);
                return;
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                dVar.f = new c(dVar, null);
                return;
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException(jg.a("unexpected journal line: ", str));
            } else {
                return;
            }
        }
        throw new IOException(jg.a("unexpected journal line: ", str));
    }

    public final void c() {
        a(this.e);
        Iterator<d> it = this.l.values().iterator();
        while (it.hasNext()) {
            d next = it.next();
            int i = 0;
            if (next.f == null) {
                while (i < this.i) {
                    this.j += next.b[i];
                    i++;
                }
            } else {
                next.f = null;
                while (i < this.i) {
                    a(next.c[i]);
                    a(next.d[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        if (this.k == null) {
            return;
        }
        Iterator it = new ArrayList(this.l.values()).iterator();
        while (it.hasNext()) {
            d dVar = (d) it.next();
            if (dVar.f != null) {
                dVar.f.a();
            }
        }
        f();
        a(this.k);
        this.k = null;
    }

    public final void d() {
        xg xgVar = new xg(new FileInputStream(this.d), yg.a);
        try {
            String b2 = xgVar.b();
            String b3 = xgVar.b();
            String b4 = xgVar.b();
            String b5 = xgVar.b();
            String b6 = xgVar.b();
            if (!"libcore.io.DiskLruCache".equals(b2) || !"1".equals(b3) || !Integer.toString(this.g).equals(b4) || !Integer.toString(this.i).equals(b5) || !"".equals(b6)) {
                throw new IOException("unexpected journal header: [" + b2 + ", " + b3 + ", " + b5 + ", " + b6 + "]");
            }
            int i = 0;
            while (true) {
                try {
                    b(xgVar.b());
                    i++;
                } catch (EOFException unused) {
                    this.m = i - this.l.size();
                    if (xgVar.g == -1) {
                        e();
                    } else {
                        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), yg.a));
                    }
                    try {
                        xgVar.close();
                        return;
                    } catch (RuntimeException e2) {
                        throw e2;
                    } catch (Exception unused2) {
                        return;
                    }
                }
            }
        } catch (Throwable th) {
            try {
                xgVar.close();
            } catch (RuntimeException e3) {
                throw e3;
            } catch (Exception unused3) {
            }
            throw th;
        }
    }

    public final synchronized void e() {
        if (this.k != null) {
            a(this.k);
        }
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.e), yg.a));
        bufferedWriter.write("libcore.io.DiskLruCache");
        bufferedWriter.write("\n");
        bufferedWriter.write("1");
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.g));
        bufferedWriter.write("\n");
        bufferedWriter.write(Integer.toString(this.i));
        bufferedWriter.write("\n");
        bufferedWriter.write("\n");
        for (d dVar : this.l.values()) {
            if (dVar.f != null) {
                bufferedWriter.write("DIRTY " + dVar.a + '\n');
            } else {
                bufferedWriter.write("CLEAN " + dVar.a + dVar.a() + '\n');
            }
        }
        a(bufferedWriter);
        if (this.d.exists()) {
            a(this.d, this.f, true);
        }
        a(this.e, this.d, false);
        this.f.delete();
        this.k = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.d, true), yg.a));
    }

    public final void f() {
        while (this.j > this.h) {
            c(this.l.entrySet().iterator().next().getKey());
        }
    }

    public static wg a(File file, int i, int i2, long j) {
        if (j > 0) {
            if (i2 > 0) {
                File file2 = new File(file, "journal.bkp");
                if (file2.exists()) {
                    File file3 = new File(file, "journal");
                    if (file3.exists()) {
                        file2.delete();
                    } else {
                        a(file2, file3, false);
                    }
                }
                wg wgVar = new wg(file, i, i2, j);
                if (wgVar.d.exists()) {
                    try {
                        wgVar.d();
                        wgVar.c();
                        return wgVar;
                    } catch (IOException e2) {
                        PrintStream printStream = System.out;
                        printStream.println("DiskLruCache " + file + " is corrupt: " + e2.getMessage() + ", removing");
                        wgVar.close();
                        yg.a(wgVar.c);
                    }
                }
                file.mkdirs();
                wg wgVar2 = new wg(file, i, i2, j);
                wgVar2.e();
                return wgVar2;
            }
            throw new IllegalArgumentException("valueCount <= 0");
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: wg$d */
    /* loaded from: classes.dex */
    public final class d {
        public final String a;
        public final long[] b;
        public File[] c;
        public File[] d;
        public boolean e;
        public c f;
        public long g;

        public /* synthetic */ d(String str, a aVar) {
            this.a = str;
            int i = wg.this.i;
            this.b = new long[i];
            this.c = new File[i];
            this.d = new File[i];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i2 = 0; i2 < wg.this.i; i2++) {
                sb.append(i2);
                this.c[i2] = new File(wg.this.c, sb.toString());
                sb.append(".tmp");
                this.d[i2] = new File(wg.this.c, sb.toString());
                sb.setLength(length);
            }
        }

        public String a() {
            long[] jArr;
            StringBuilder sb = new StringBuilder();
            for (long j : this.b) {
                sb.append(' ');
                sb.append(j);
            }
            return sb.toString();
        }

        public final void b(String[] strArr) {
            if (strArr.length == wg.this.i) {
                for (int i = 0; i < strArr.length; i++) {
                    try {
                        this.b[i] = Long.parseLong(strArr[i]);
                    } catch (NumberFormatException unused) {
                        a(strArr);
                        throw null;
                    }
                }
                return;
            }
            a(strArr);
            throw null;
        }

        public final IOException a(String[] strArr) {
            StringBuilder a = jg.a("unexpected journal line: ");
            a.append(Arrays.toString(strArr));
            throw new IOException(a.toString());
        }
    }

    public synchronized boolean c(String str) {
        a();
        d dVar = this.l.get(str);
        if (dVar != null && dVar.f == null) {
            for (int i = 0; i < this.i; i++) {
                File file = dVar.c[i];
                if (file.exists() && !file.delete()) {
                    throw new IOException("failed to delete " + file);
                }
                long j = this.j;
                long[] jArr = dVar.b;
                this.j = j - jArr[i];
                jArr[i] = 0;
            }
            this.m++;
            this.k.append((CharSequence) "REMOVE");
            this.k.append(' ');
            this.k.append((CharSequence) str);
            this.k.append('\n');
            this.l.remove(str);
            if (b()) {
                this.o.submit(this.p);
            }
            return true;
        }
        return false;
    }

    /* compiled from: DiskLruCache.java */
    /* renamed from: wg$c */
    /* loaded from: classes.dex */
    public final class c {
        public final d a;
        public final boolean[] b;
        public boolean c;

        public /* synthetic */ c(d dVar, a aVar) {
            this.a = dVar;
            this.b = dVar.e ? null : new boolean[wg.this.i];
        }

        public File a(int i) {
            File file;
            synchronized (wg.this) {
                if (this.a.f == this) {
                    if (!this.a.e) {
                        this.b[i] = true;
                    }
                    file = this.a.d[i];
                    if (!wg.this.c.exists()) {
                        wg.this.c.mkdirs();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }
            return file;
        }

        public void a() {
            wg.this.a(this, false);
        }
    }

    public final boolean b() {
        int i = this.m;
        return i >= 2000 && i >= this.l.size();
    }

    public static void a(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    @TargetApi(26)
    public static void b(Writer writer) {
        int i = Build.VERSION.SDK_INT;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void a(File file, File file2, boolean z) {
        if (z) {
            a(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public synchronized e a(String str) {
        a();
        d dVar = this.l.get(str);
        if (dVar == null) {
            return null;
        }
        if (dVar.e) {
            for (File file : dVar.c) {
                if (!file.exists()) {
                    return null;
                }
            }
            this.m++;
            this.k.append((CharSequence) "READ");
            this.k.append(' ');
            this.k.append((CharSequence) str);
            this.k.append('\n');
            if (b()) {
                this.o.submit(this.p);
            }
            return new e(this, str, dVar.g, dVar.c, dVar.b, null);
        }
        return null;
    }

    public final synchronized c a(String str, long j) {
        a();
        d dVar = this.l.get(str);
        if (j == -1 || (dVar != null && dVar.g == j)) {
            if (dVar == null) {
                dVar = new d(str, null);
                this.l.put(str, dVar);
            } else if (dVar.f != null) {
                return null;
            }
            c cVar = new c(dVar, null);
            dVar.f = cVar;
            this.k.append((CharSequence) "DIRTY");
            this.k.append(' ');
            this.k.append((CharSequence) str);
            this.k.append('\n');
            b(this.k);
            return cVar;
        }
        return null;
    }

    public final void a() {
        if (this.k == null) {
            throw new IllegalStateException("cache is closed");
        }
    }

    @TargetApi(26)
    public static void a(Writer writer) {
        int i = Build.VERSION.SDK_INT;
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final synchronized void a(c cVar, boolean z) {
        d dVar = cVar.a;
        if (dVar.f == cVar) {
            if (z && !dVar.e) {
                for (int i = 0; i < this.i; i++) {
                    if (cVar.b[i]) {
                        if (!dVar.d[i].exists()) {
                            cVar.a();
                            return;
                        }
                    } else {
                        cVar.a();
                        throw new IllegalStateException("Newly created entry didn't create value for index " + i);
                    }
                }
            }
            for (int i2 = 0; i2 < this.i; i2++) {
                File file = dVar.d[i2];
                if (z) {
                    if (file.exists()) {
                        File file2 = dVar.c[i2];
                        file.renameTo(file2);
                        long j = dVar.b[i2];
                        long length = file2.length();
                        dVar.b[i2] = length;
                        this.j = (this.j - j) + length;
                    }
                } else {
                    a(file);
                }
            }
            this.m++;
            dVar.f = null;
            if (dVar.e | z) {
                dVar.e = true;
                this.k.append((CharSequence) "CLEAN");
                this.k.append(' ');
                this.k.append((CharSequence) dVar.a);
                this.k.append((CharSequence) dVar.a());
                this.k.append('\n');
                if (z) {
                    long j2 = this.n;
                    this.n = 1 + j2;
                    dVar.g = j2;
                }
            } else {
                this.l.remove(dVar.a);
                this.k.append((CharSequence) "REMOVE");
                this.k.append(' ');
                this.k.append((CharSequence) dVar.a);
                this.k.append('\n');
            }
            b(this.k);
            if (this.j > this.h || b()) {
                this.o.submit(this.p);
            }
            return;
        }
        throw new IllegalStateException();
    }
}
