package defpackage;

import android.content.Context;
import android.util.Log;
import com.xiaopeng.lib.framework.moduleinterface.carcontroller.IInputController;
import java.io.Closeable;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* compiled from: FileCache.java */
/* renamed from: f90  reason: default package */
/* loaded from: classes.dex */
public abstract class f90<E> {
    public final File a;
    public final File b;
    public final int c;
    public long h;
    public long i;
    public final Object d = new Object();
    public boolean e = false;
    public final Object f = new Object();
    public final CountDownLatch g = new CountDownLatch(1);
    public List<E> j = new ArrayList();
    public final Executor k = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new b(1));

    /* compiled from: FileCache.java */
    /* renamed from: f90$a */
    /* loaded from: classes.dex */
    public class a extends Thread {
        public a(String str) {
            super(str);
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            f90.this.d();
        }
    }

    public f90(Context context, String str, int i) {
        this.a = b(context, str);
        this.b = a(context, str);
        this.c = i;
        e();
    }

    public static File a(Context context, String str) {
        return b(context, str + ".bak");
    }

    public static File b(Context context, String str) {
        return new File(context.getFilesDir(), str);
    }

    public abstract E a(String str);

    public abstract String b(E e);

    public abstract boolean b(String str);

    public List<E> c() {
        List<E> list;
        synchronized (this.d) {
            a();
            list = this.j;
        }
        return new ArrayList(list);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a6  */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5, types: [java.io.Closeable] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.List<E>] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r7 = this;
            java.lang.Object r0 = r7.d
            monitor-enter(r0)
            boolean r1 = r7.e     // Catch: java.lang.Throwable -> Lc6
            if (r1 == 0) goto L9
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc6
            return
        L9:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc6
            java.io.File r0 = r7.a
            boolean r0 = r0.exists()
            if (r0 == 0) goto L33
            java.io.File r0 = r7.a
            boolean r0 = r0.canRead()
            if (r0 != 0) goto L33
            java.lang.String r0 = "Attempt to read preferences file "
            java.lang.StringBuilder r0 = defpackage.jg.a(r0)
            java.io.File r1 = r7.a
            r0.append(r1)
            java.lang.String r1 = " without permission"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "FileCache"
            android.util.Log.w(r1, r0)
        L33:
            java.io.File r0 = r7.a
            boolean r0 = r0.canRead()
            r1 = 0
            if (r0 == 0) goto La3
            java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.io.File r4 = r7.a     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r3 = 16384(0x4000, float:2.2959E-41)
            r0.<init>(r2, r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.util.stream.Stream r2 = r0.lines()     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            w80 r3 = new w80     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            java.util.stream.Stream r2 = r2.filter(r3)     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            a90 r3 = new a90     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            r3.<init>()     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            java.util.stream.Stream r2 = r2.map(r3)     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            java.util.stream.Collector r3 = java.util.stream.Collectors.toList()     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            java.lang.Object r2 = r2.collect(r3)     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Exception -> L74 java.lang.Throwable -> L9b
            defpackage.z90.a(r0)
            r1 = r2
            goto La3
        L74:
            r2 = move-exception
            goto L7b
        L76:
            r0 = move-exception
            goto L9f
        L78:
            r0 = move-exception
            r2 = r0
            r0 = r1
        L7b:
            java.lang.String r3 = "FileCache"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r4.<init>()     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = "Cannot read "
            r4.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.io.File r5 = r7.a     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L9b
            r4.append(r5)     // Catch: java.lang.Throwable -> L9b
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L9b
            android.util.Log.w(r3, r4, r2)     // Catch: java.lang.Throwable -> L9b
            defpackage.z90.a(r0)
            goto La3
        L9b:
            r1 = move-exception
            r6 = r1
            r1 = r0
            r0 = r6
        L9f:
            defpackage.z90.a(r1)
            throw r0
        La3:
            java.lang.Object r2 = r7.d
            monitor-enter(r2)
            r0 = 1
            r7.e = r0     // Catch: java.lang.Throwable -> Lc3
            if (r1 == 0) goto Lae
            r7.j = r1     // Catch: java.lang.Throwable -> Lbc
            goto Lb5
        Lae:
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch: java.lang.Throwable -> Lbc
            r0.<init>()     // Catch: java.lang.Throwable -> Lbc
            r7.j = r0     // Catch: java.lang.Throwable -> Lbc
        Lb5:
            java.lang.Object r0 = r7.d     // Catch: java.lang.Throwable -> Lc3
            r0.notifyAll()     // Catch: java.lang.Throwable -> Lc3
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc3
            return
        Lbc:
            r0 = move-exception
            java.lang.Object r1 = r7.d     // Catch: java.lang.Throwable -> Lc3
            r1.notifyAll()     // Catch: java.lang.Throwable -> Lc3
            throw r0     // Catch: java.lang.Throwable -> Lc3
        Lc3:
            r0 = move-exception
            monitor-exit(r2)     // Catch: java.lang.Throwable -> Lc3
            throw r0
        Lc6:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> Lc6
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f90.d():void");
    }

    public final void e() {
        synchronized (this.d) {
            this.e = false;
            if (this.b.exists()) {
                this.a.delete();
                this.b.renameTo(this.a);
            }
        }
        new a("FileCache-load").start();
    }

    /* compiled from: FileCache.java */
    /* renamed from: f90$b */
    /* loaded from: classes.dex */
    public static class b<E> extends LinkedBlockingQueue<E> {
        public b(int i) {
            super(i);
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(E e) {
            clear();
            return super.offer(e);
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public void put(E e) {
            clear();
            super.put(e);
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.concurrent.BlockingQueue
        public boolean offer(E e, long j, TimeUnit timeUnit) {
            clear();
            return super.offer(e, j, timeUnit);
        }
    }

    public final void a() {
        while (!this.e) {
            try {
                this.d.wait();
            } catch (InterruptedException unused) {
            }
        }
    }

    public void b() {
        synchronized (this.d) {
            a();
        }
        b((List) new ArrayList());
    }

    public void a(E e) {
        a((List) Collections.singletonList(e));
    }

    public void a(List<E> list) {
        List<E> arrayList;
        synchronized (this.d) {
            a();
            arrayList = new ArrayList<>(this.j);
            arrayList.addAll(list);
        }
        int size = arrayList.size();
        int i = this.c;
        if (size > i) {
            arrayList = arrayList.subList(size - i, size);
        }
        b((List) arrayList);
    }

    public final void b(final List<E> list) {
        final long j;
        synchronized (this.d) {
            this.j = list;
            this.h++;
            j = this.h;
        }
        this.k.execute(new Runnable() { // from class: x80
            @Override // java.lang.Runnable
            public final void run() {
                f90.this.a(list, j);
            }
        });
    }

    public /* synthetic */ void a(List list, long j) {
        synchronized (this.f) {
            b(list, j);
        }
        try {
            this.g.await();
        } catch (InterruptedException e) {
            StringBuilder a2 = jg.a("enqueueDiskWrite error:");
            a2.append(e.getMessage());
            Log.e("FileCache", a2.toString());
        }
    }

    public final void b(List<E> list, long j) {
        int i;
        boolean z;
        if (this.a.exists()) {
            if (this.i < j) {
                synchronized (this.d) {
                    z = this.h == j;
                }
            } else {
                z = false;
            }
            if (!z) {
                this.g.countDown();
                return;
            } else if (!this.b.exists()) {
                if (!this.a.renameTo(this.b)) {
                    StringBuilder a2 = jg.a("Couldn't rename file ");
                    a2.append(this.a);
                    a2.append(" to backup file ");
                    a2.append(this.b);
                    Log.e("FileCache", a2.toString());
                    this.g.countDown();
                    return;
                }
            } else {
                this.a.delete();
            }
        }
        try {
            try {
                FileWriter a3 = a(this.a);
                if (a3 == null) {
                    this.g.countDown();
                    z90.a(a3);
                    return;
                }
                StringBuilder sb = new StringBuilder();
                int i2 = 0;
                while (i2 < list.size()) {
                    sb.delete(0, sb.length());
                    int i3 = i2;
                    while (true) {
                        i = i2 + 1024;
                        if (i3 < i && i3 < list.size()) {
                            sb.append(b((f90<E>) list.get(i3)));
                            sb.append("\n");
                            i3++;
                        }
                    }
                    a3.write(sb.toString());
                    i2 = i;
                }
                a3.flush();
                System.currentTimeMillis();
                z90.a(this.a.getPath(), 432, -1, -1);
                this.b.delete();
                this.i = j;
                this.g.countDown();
                z90.a(a3);
            } catch (IOException e) {
                Log.w("FileCache", "writeToFile: Got exception:", e);
                z90.a((Closeable) null);
                if (this.a.exists() && !this.a.delete()) {
                    StringBuilder a4 = jg.a("Couldn't clean up partially-written file ");
                    a4.append(this.a);
                    Log.e("FileCache", a4.toString());
                }
                this.g.countDown();
            }
        } catch (Throwable th) {
            z90.a((Closeable) null);
            throw th;
        }
    }

    public static FileWriter a(File file) {
        try {
            return new FileWriter(file);
        } catch (IOException unused) {
            File parentFile = file.getParentFile();
            if (!parentFile.mkdir()) {
                Log.e("FileCache", "Couldn't create directory for data file " + file);
                return null;
            }
            z90.a(parentFile.getPath(), (int) IInputController.KEYCODE_KNOB_TEMP_DOWN, -1, -1);
            try {
                return new FileWriter(file);
            } catch (IOException e) {
                Log.e("FileCache", "Couldn't create data file " + file, e);
                return null;
            }
        }
    }
}
