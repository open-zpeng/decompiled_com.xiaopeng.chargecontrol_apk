package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.UserHandle;
import com.xiaopeng.datalog.bean.LogEvent;
import defpackage.eb0;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
/* compiled from: DataCollectorHelper.java */
/* renamed from: ya0  reason: default package */
/* loaded from: classes.dex */
public class ya0 {
    public static volatile ya0 h;
    public static final String i;
    public static final String j;
    public eb0 a;
    public Context b;
    public final List<String> c = new CopyOnWriteArrayList();
    public final List<Map<String, Object>> d = new CopyOnWriteArrayList();
    public lu e = new lu();
    public Handler f = new Handler(jb0.a(0), new a());
    public ServiceConnection g = new b();

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: ya0$a */
    /* loaded from: classes.dex */
    public class a implements Handler.Callback {
        public a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 1) {
                gb0.d("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CAN");
                ya0.this.b();
            } else if (i == 2) {
                gb0.a("DataCollectorHelper", "handleMessage MESSAGE_DUMP_CDU");
                ya0.this.c();
            } else if (i == 3) {
                gb0.a("DataCollectorHelper", "handleMessage MESSAGE_CHECK_CONNECTION");
                ya0 ya0Var = ya0.this;
                if (ya0Var.a == null) {
                    ya0Var.a();
                }
            }
            return true;
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: ya0$b */
    /* loaded from: classes.dex */
    public class b implements ServiceConnection {

        /* compiled from: DataCollectorHelper.java */
        /* renamed from: ya0$b$a */
        /* loaded from: classes.dex */
        public class a implements IBinder.DeathRecipient {
            public a() {
            }

            @Override // android.os.IBinder.DeathRecipient
            public void binderDied() {
                eb0 eb0Var = ya0.this.a;
                if (eb0Var == null) {
                    return;
                }
                eb0Var.asBinder().unlinkToDeath(this, 0);
                ya0 ya0Var = ya0.this;
                ya0Var.a = null;
                ya0Var.a();
            }
        }

        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            gb0.a("DataCollectorHelper", "onServiceConnected");
            ya0.this.a = eb0.a.a(iBinder);
            a aVar = new a();
            try {
                if (ya0.this.a == null) {
                    return;
                }
                ya0.this.a.asBinder().linkToDeath(aVar, 0);
            } catch (RemoteException e) {
                gb0.a("DataCollectorHelper", "RemoteException occurs when reLink to Service, exception:", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            gb0.a("DataCollectorHelper", "onServiceDisconnected");
            ya0 ya0Var = ya0.this;
            ya0Var.a = null;
            ya0Var.a();
        }
    }

    /* compiled from: DataCollectorHelper.java */
    /* renamed from: ya0$c */
    /* loaded from: classes.dex */
    public class c extends fx<Map<String, Object>> {
        public c(ya0 ya0Var) {
        }
    }

    static {
        i = "4".equals(nb0.a()) ? "xp-log-local" : "xp-log";
        j = jg.a(jg.a("http://"), i, ".oss-cn-hangzhou.aliyuncs.com/");
    }

    public static ya0 f() {
        if (h == null) {
            synchronized (ya0.class) {
                if (h == null) {
                    h = new ya0();
                }
            }
        }
        return h;
    }

    public final void c() {
        if (this.d.isEmpty()) {
            gb0.a("DataCollectorHelper", "mCduDataCache.isEmpty(), return!");
        }
        LogEvent create = LogEvent.create(LogEvent.a.CDU);
        try {
            create.setV(Integer.valueOf(hb0.b()).intValue());
        } catch (Exception e) {
            gb0.a("DataCollectorHelper", "parse dbcVersion error!", e);
            create.setV(0);
        }
        ArrayList arrayList = new ArrayList(this.d);
        this.d.clear();
        create.setMsg(arrayList);
        ua0.a().a("cdudata", lb0.a(this.e.a(create)), this.b);
        this.f.removeMessages(2);
    }

    public final String[] d() {
        String b2;
        int indexOf;
        int i2;
        int indexOf2;
        long currentTimeMillis = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("/log/");
        String a2 = nb0.a("ro.product.firmware");
        if ("unknown".equals(a2) && (indexOf = (b2 = nb0.b()).indexOf("_")) > 1 && (indexOf2 = b2.indexOf("_", (i2 = indexOf + 1))) > indexOf) {
            a2 = b2.substring(i2, indexOf2);
        }
        sb.append(a2);
        sb.append("/");
        sb.append(fb0.b(currentTimeMillis));
        sb.append("/");
        sb.append(hb0.e());
        String sb2 = sb.toString();
        String a3 = jg.a(new StringBuilder(), j, sb2.substring(sb2.indexOf("/") + 1) + "/" + currentTimeMillis + "_en.zip");
        String a4 = jg.a("/sdcard/Log/upload-zip/", sb2);
        File file = new File(a4);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new String[]{a3, a4 + "/" + currentTimeMillis + ".zip"};
    }

    public boolean e() {
        return this.a != null;
    }

    public final void b() {
        if (this.c.isEmpty()) {
            gb0.a("DataCollectorHelper", "mCanDataCache.isEmpty(), return!");
            return;
        }
        LogEvent create = LogEvent.create(LogEvent.a.CAN);
        try {
            create.setV(Integer.valueOf(hb0.b()).intValue());
        } catch (Exception e) {
            gb0.a("DataCollectorHelper", "parse dbcVersion error!", e);
            create.setV(0);
        }
        uu uuVar = new uu();
        uuVar.a("data", this.e.a(this.c));
        this.c.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.add(uuVar);
        create.setMsg(arrayList);
        String a2 = this.e.a(create);
        arrayList.clear();
        ua0.a().a("candata", lb0.a(a2), this.b);
        this.f.removeMessages(1);
    }

    public final void a() {
        Intent intent = new Intent("com.xiaopeng.service.DATA_SERVICE");
        intent.setPackage("com.xiaopeng.data.uploader");
        this.b.startServiceAsUser(intent, UserHandle.CURRENT);
        this.b.bindServiceAsUser(intent, this.g, 1, UserHandle.CURRENT);
        if (this.f.hasMessages(3)) {
            return;
        }
        this.f.sendEmptyMessageDelayed(3, 10000L);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r4) {
        /*
            r3 = this;
            eb0 r0 = r3.a
            if (r0 == 0) goto L1e
            eb0$a$a r0 = (defpackage.eb0.a.C0005a) r0
            r0.b(r4)     // Catch: android.os.RemoteException -> L16
            java.util.List<java.util.Map<java.lang.String, java.lang.Object>> r0 = r3.d     // Catch: android.os.RemoteException -> L16
            int r0 = r0.size()     // Catch: android.os.RemoteException -> L16
            if (r0 <= 0) goto L14
            r3.c()     // Catch: android.os.RemoteException -> L16
        L14:
            r0 = 1
            goto L1f
        L16:
            r0 = move-exception
            java.lang.String r1 = "DataCollectorHelper"
            java.lang.String r2 = "uploadCdu error!"
            defpackage.gb0.a(r1, r2, r0)
        L1e:
            r0 = 0
        L1f:
            if (r0 != 0) goto L33
            lu r0 = r3.e
            ya0$c r1 = new ya0$c
            r1.<init>(r3)
            java.lang.reflect.Type r1 = r1.b
            java.lang.Object r4 = r0.a(r4, r1)
            java.util.Map r4 = (java.util.Map) r4
            r3.a(r4)
        L33:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ya0.a(java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:48:0x0085, code lost:
        if (r0 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x0097, code lost:
        if (r0 == 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x0099, code lost:
        r0.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x009d, code lost:
        r7 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x009e, code lost:
        r7.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:109:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00a4 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.io.OutputStream] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(java.lang.String r7, java.util.List<java.lang.String> r8) {
        /*
            Method dump skipped, instructions count: 198
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ya0.a(java.lang.String, java.util.List):void");
    }

    public final void a(Map<String, Object> map) {
        this.d.add(map);
        if (this.d.size() >= 20) {
            c();
        } else if (this.f.hasMessages(2)) {
        } else {
            this.f.sendEmptyMessageDelayed(2, 60000L);
        }
    }
}
