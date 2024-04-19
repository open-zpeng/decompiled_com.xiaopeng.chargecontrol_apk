package defpackage;

import android.net.Uri;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import com.xiaopeng.lib.apirouter.ApiRouter;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import com.xiaopeng.speech.vui.constants.OverallConstants;
import com.xiaopeng.speech.vui.utils.LogUtils;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONObject;
/* compiled from: OverallManager.java */
/* renamed from: ac0  reason: default package */
/* loaded from: classes.dex */
public class ac0 {
    public String a;
    public dc0 b;
    public Map<String, HashSet<dc0>> c = new ConcurrentHashMap();
    public Handler d;
    public HandlerThread e;
    public Handler f;
    public HashSet<String> g;
    public HashSet<String> h;
    public String i;
    public String j;
    public Runnable k;
    public String l;
    public String m;
    public String n;
    public Runnable o;

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public a(String str, String str2) {
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ac0.this.b.a(this.c, this.d);
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$b */
    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public b(String str, String str2) {
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ac0.this.b.a(this.c, this.d);
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$c */
    /* loaded from: classes.dex */
    public class c implements Runnable {
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;

        public c(String str, String str2) {
            this.c = str;
            this.d = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ac0.this.b.a(this.c, this.d);
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$d */
    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ dc0 c;
        public final /* synthetic */ String d;
        public final /* synthetic */ String e;

        public d(ac0 ac0Var, dc0 dc0Var, String str, String str2) {
            this.c = dc0Var;
            this.d = str;
            this.e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder a = jg.a("dispatchOverallEvent listener:");
            a.append(this.c);
            LogUtils.logInfo("OverallManager", a.toString());
            this.c.a(this.d, this.e);
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$e */
    /* loaded from: classes.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                ac0.this.f.removeCallbacks(ac0.this.k);
                if (TextUtils.isEmpty(ac0.this.i)) {
                    return;
                }
                ac0.this.a(ac0.this.i, ac0.this.j);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$f */
    /* loaded from: classes.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                LogUtils.logInfo("OverallManager", "mQueryRun:" + ac0.this.l + ",mQueryData:" + ac0.this.m);
                ac0.this.f.removeCallbacks(ac0.this.o);
                if (TextUtils.isEmpty(ac0.this.l)) {
                    return;
                }
                LogUtils.logInfo("OverallManager", "mQueryRun:" + ac0.this.l + ",mQueryData:" + ac0.this.m);
                ac0.this.a(ac0.this.l, ac0.this.m, ac0.this.n);
            } catch (Exception unused) {
            }
        }
    }

    /* compiled from: OverallManager.java */
    /* renamed from: ac0$g */
    /* loaded from: classes.dex */
    public static class g {
        public static final ac0 a = new ac0(null);
    }

    public /* synthetic */ ac0(bc0 bc0Var) {
        new ConcurrentHashMap();
        new ConcurrentHashMap();
        this.d = new Handler(Looper.getMainLooper());
        this.g = new HashSet<>();
        this.h = new HashSet<>();
        this.i = null;
        this.j = null;
        this.k = new e();
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = new f();
        if (this.e == null) {
            this.e = new HandlerThread("VuiEngine-overall");
            this.e.start();
            this.f = new Handler(this.e.getLooper());
        }
    }

    public static final ac0 b() {
        return g.a;
    }

    public void a(String str, String str2) {
        try {
            "xiaopeng.asr.result".equals(str);
            if (!TextUtils.isEmpty(this.a) && this.b != null) {
                String str3 = this.a;
                List asList = cc0.a.containsKey(str3) ? Arrays.asList(cc0.a.get(str3)) : null;
                if (asList != null) {
                    int indexOf = asList.indexOf(str);
                    if (indexOf != -1) {
                        String str4 = this.a;
                        String str5 = (String) (cc0.c.containsKey(str4) ? Arrays.asList(cc0.c.get(str4)) : null).get(indexOf);
                        LogUtils.logInfo("OverallManager", "dispatchOverallEvent eventStr:" + str5);
                        if (TextUtils.isEmpty(str5)) {
                            return;
                        }
                        if (!str5.contains("|")) {
                            this.d.post(new a(str5, str2));
                            return;
                        }
                        String[] split = str5.split("\\|");
                        for (String str6 : split[0].split(CFCHelper.SIGNAL_CFC_SPLIT)) {
                            String[] split2 = str6.split(":");
                            Object a2 = this.b.a(split2[0]);
                            LogUtils.logInfo("OverallManager", "dispatchOverallEvent eventStr:" + split2[1] + ",obj:" + a2);
                            if (a2 == null) {
                                return;
                            }
                            if (a2 instanceof Boolean) {
                                if ((!split2[1].equals("true") || !((Boolean) a2).booleanValue()) && (!split2[1].equals("false") || ((Boolean) a2).booleanValue())) {
                                    return;
                                }
                            } else if (a2 instanceof Integer) {
                                if (!Pattern.compile("[0-9]+(_[0-9]+)*").matcher(split2[1]).matches() || ((Integer) a2).intValue() != Integer.parseInt(split2[1])) {
                                    return;
                                }
                            } else if (!(a2 instanceof String) || !((String) a2).equals(split2[1])) {
                                return;
                            }
                        }
                        LogUtils.logInfo("OverallManager", "dispatchOverallEvent run:" + split[1] + ",data:" + str2);
                        this.d.post(new b(split[1], str2));
                        return;
                    }
                    int indexOf2 = cc0.b(this.a).indexOf(str);
                    if (indexOf2 != -1) {
                        String str7 = cc0.a(this.a).get(indexOf2);
                        if (TextUtils.isEmpty(str7)) {
                            return;
                        }
                        JSONObject jSONObject = new JSONObject();
                        if (str7.contains("|")) {
                            String[] split3 = str7.split("\\|");
                            for (int i = 0; i < split3.length; i++) {
                                Object a3 = this.b.a(split3[i]);
                                if (a3 != null) {
                                    jSONObject.put(split3[i], a3);
                                }
                            }
                        } else {
                            Object a4 = this.b.a(str7);
                            if (a4 != null) {
                                jSONObject.put(str, a4);
                            }
                        }
                        if (jSONObject.length() > 0) {
                            LogUtils.logInfo("OverallManager", "feedbackResult:" + jSONObject.toString());
                            ApiRouter.route(new Uri.Builder().authority(a()).path("feedbackResult").appendQueryParameter("event", str).appendQueryParameter("data", jSONObject.toString()).build());
                        }
                    }
                } else if (this.g != null && Arrays.asList(this.g).contains(str)) {
                    this.d.post(new c(str, str2));
                } else if (this.h != null && Arrays.asList(this.h).contains(str)) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(str, this.b.a(str));
                    ApiRouter.route(new Uri.Builder().authority(a()).path("feedbackResult").appendQueryParameter("event", str).appendQueryParameter("data", jSONObject2.toString()).build());
                }
            } else if (TextUtils.isEmpty(this.a) && this.b == null) {
                this.i = str;
                this.j = str2;
                this.f.postDelayed(this.k, 200);
            } else if (this.b == null) {
                LogUtils.logInfo("OverallManager", "dispatchOverallEvent mListeners:" + this.c);
                if (this.c.containsKey(str)) {
                    LogUtils.logInfo("OverallManager", "dispatchOverallEvent mListeners:" + this.c);
                    Iterator<dc0> it = this.c.get(str).iterator();
                    while (it.hasNext()) {
                        dc0 next = it.next();
                        if (this.g != null && this.g.contains(str)) {
                            this.d.post(new d(this, next, str, str2));
                        } else if (this.h != null && this.h.contains(str)) {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put(str, next.a(str));
                            ApiRouter.route(new Uri.Builder().authority(a()).path("feedbackResult").appendQueryParameter("event", str).appendQueryParameter("data", jSONObject3.toString()).build());
                        }
                    }
                } else if (this.c == null) {
                    this.i = str;
                    this.j = str2;
                    this.f.postDelayed(this.k, 200);
                } else if (cc0.b(this.a).indexOf(str) != -1) {
                    ApiRouter.route(new Uri.Builder().authority(a()).path("feedbackResult").appendQueryParameter("event", str).appendQueryParameter("data", new JSONObject().toString()).build());
                }
            }
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(10:18|(9:33|34|(3:44|45|46)(2:36|(2:38|39))|22|23|24|(1:26)|28|29)|20|21|22|23|24|(0)|28|29) */
    /* JADX WARN: Can't wrap try/catch for region: R(10:62|(9:76|77|(3:87|88|89)(2:79|(2:81|82))|66|67|68|(1:70)|72|73)|64|65|66|67|68|(0)|72|73) */
    /* JADX WARN: Can't wrap try/catch for region: R(12:124|125|(10:141|142|(3:153|154|155)(2:144|(3:146|147|148))|129|130|131|133|(1:135)|136|137)|127|128|129|130|131|133|(0)|136|137) */
    /* JADX WARN: Code restructure failed: missing block: B:124:0x01f1, code lost:
        r9 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01f2, code lost:
        r9.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008d, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x008e, code lost:
        r12.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00fd, code lost:
        r12 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00fe, code lost:
        r12.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:122:0x01ed A[Catch: Exception -> 0x0172, JSONException -> 0x01f1, TRY_LEAVE, TryCatch #7 {JSONException -> 0x01f1, blocks: (B:120:0x01e5, B:122:0x01ed), top: B:147:0x01e5, outer: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0089 A[Catch: JSONException -> 0x008d, Exception -> 0x0216, TRY_LEAVE, TryCatch #13 {JSONException -> 0x008d, blocks: (B:38:0x0081, B:40:0x0089), top: B:159:0x0081, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00f9 A[Catch: JSONException -> 0x00fd, Exception -> 0x0216, TRY_LEAVE, TryCatch #5 {JSONException -> 0x00fd, blocks: (B:71:0x00f1, B:73:0x00f9), top: B:143:0x00f1, outer: #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void a(java.lang.String r12, java.lang.String r13, java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 535
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ac0.a(java.lang.String, java.lang.String, java.lang.String):void");
    }

    public final String a() {
        return !zb0.a() ? OverallConstants.OVERAll_THIRD_AUTHORITY : OverallConstants.OVERAll_AUTHORITY;
    }
}
