package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
/* compiled from: CounterImpl.java */
/* renamed from: ta0  reason: default package */
/* loaded from: classes.dex */
public class ta0 implements ICounter, Handler.Callback {
    public final String c;
    public final long d;
    public final Map<String, AtomicInteger> e;
    public boolean f;
    public AtomicLong g;
    public Handler h;
    public final SharedPreferences i;
    public final SharedPreferences.Editor j;

    /* compiled from: CounterImpl.java */
    /* renamed from: ta0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public final /* synthetic */ Map c;
        public final /* synthetic */ long d;

        public a(Map map, long j) {
            this.c = map;
            this.d = j;
        }

        @Override // java.lang.Runnable
        public void run() {
            StringBuilder a = jg.a("[");
            a.append(ta0.this.c);
            a.append(" counter] send count event, name:");
            a.append(ta0.this.c);
            a.append(" values:");
            a.append(this.c);
            gb0.c("CounterImpl", a.toString());
            IDataLog iDataLog = (IDataLog) Module.get(oa0.class).get(IDataLog.class);
            IMoleEventBuilder event = iDataLog.buildMoleEvent().setPageId("P00012").setButtonId("B001").setEvent(ta0.this.c);
            for (String str : this.c.keySet()) {
                event.setProperty(str, (Number) this.c.get(str));
            }
            event.setProperty("time", Long.valueOf(this.d));
            IMoleEvent build = event.build();
            StringBuilder a2 = jg.a("start sendStatData:");
            a2.append(build.toJson());
            gb0.a("CounterImpl", a2.toString());
            iDataLog.sendStatData(build);
        }
    }

    public ta0(Context context, String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            this.c = str;
            this.d = j;
            this.e = new HashMap();
            this.i = PreferenceManager.getDefaultSharedPreferences(context);
            this.j = this.i.edit();
            this.g = new AtomicLong(this.i.getLong(a("time"), System.currentTimeMillis()));
            this.h = new Handler(jb0.a(0), this);
            Map<String, ?> all = this.i.getAll();
            gb0.a("CounterImpl", "initValuesFromPref prefMap:" + all);
            for (String str2 : all.keySet()) {
                String str3 = null;
                if (!TextUtils.isEmpty(str2)) {
                    String a2 = jg.a(new StringBuilder(), this.c, "_");
                    if (str2.startsWith(a2)) {
                        str3 = str2.substring(a2.length());
                    }
                }
                if (!TextUtils.isEmpty(str3) && !str3.equals("time")) {
                    Object obj = all.get(str2);
                    if (obj instanceof Integer) {
                        gb0.a("CounterImpl", "initValuesFromPref key:" + str3 + " value:" + obj);
                        this.e.put(str3, new AtomicInteger(((Integer) obj).intValue()));
                    }
                }
            }
            a(false);
            return;
        }
        throw new IllegalArgumentException("name can't be empty!");
    }

    public final String a(String str) {
        return this.c + "_" + str;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str) {
        return count(str, 1);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public void debug(boolean z) {
        this.f = z;
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            if (this.f) {
                gb0.a("CounterImpl", "mEditor.apply()");
            }
            this.j.apply();
        }
        return true;
    }

    public final void a(boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        long j = this.g.get();
        long j2 = this.d;
        if (j / j2 < currentTimeMillis / j2 || z) {
            HashMap hashMap = new HashMap();
            for (String str : this.e.keySet()) {
                AtomicInteger atomicInteger = this.e.get(str);
                hashMap.put(str, Integer.valueOf(atomicInteger.get()));
                atomicInteger.set(0);
                this.j.putInt(a(str), 0);
            }
            jb0.a(2, new a(hashMap, j));
            if (!this.h.hasMessages(1)) {
                this.h.sendEmptyMessageDelayed(1, 10000L);
            }
        }
        this.g.set(currentTimeMillis);
        this.j.putLong(a("time"), currentTimeMillis);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounter
    public synchronized int count(String str, int i) {
        int i2;
        int i3;
        AtomicInteger atomicInteger = this.e.get(str);
        String a2 = a(str);
        if (atomicInteger == null) {
            try {
                i2 = this.i.getInt(a2, 0);
            } catch (ClassCastException e) {
                gb0.a("CounterImpl", "mPreferences.getInt(" + a2 + ") error!", e);
                i2 = 0;
            }
            if (this.f) {
                gb0.d("CounterImpl", "count " + this.c + ", load key:" + a2 + " from pref, value is " + i2);
            }
            AtomicInteger atomicInteger2 = new AtomicInteger(i2);
            this.e.put(str, atomicInteger2);
            atomicInteger = atomicInteger2;
        }
        i3 = atomicInteger.get() + i;
        atomicInteger.set(i3);
        this.j.putInt(a2, i3);
        if (this.f) {
            gb0.d("CounterImpl", "count " + this.c + " " + str + ":" + i3 + ", cache is:" + this.e);
        }
        boolean z = true;
        if (!this.h.hasMessages(1)) {
            this.h.sendEmptyMessageDelayed(1, 10000L);
        }
        if (i3 != Integer.MAX_VALUE) {
            z = false;
        }
        a(z);
        return i3;
    }
}
