package com.xiaopeng.chargecontrol.speech;

import android.app.ActivityThread;
import android.app.Application;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Keep;
import com.xiaopeng.chargecontrol.speech.EmergencyTtsEngine;
import com.xiaopeng.xuimanager.XUIManager;
import com.xiaopeng.xuimanager.XUIServiceNotConnectedException;
import com.xiaopeng.xuimanager.smart.SmartManager;
/* loaded from: classes.dex */
public class EmergencyTtsEngine {
    public final Handler b;
    public SmartManager d;
    public volatile long g;
    public volatile long h;
    public volatile CharSequence i;
    public String j;
    public Runnable e = new a();
    public Runnable f = new Runnable() { // from class: l80
        @Override // java.lang.Runnable
        public final void run() {
            EmergencyTtsEngine.this.b();
        }
    };
    public final Application a = ActivityThread.currentApplication();
    public final XUIManager c = XUIManager.createXUIManager(this.a, new b());

    @Keep
    /* loaded from: classes.dex */
    public class TtsListener implements SmartManager.SmartCommonEventListener {
        public static final int EVENT_DONE = 1;
        public static final int EVENT_ERROR = 3;
        public static final int EVENT_START = 0;
        public static final int EVENT_STOP = 4;

        public TtsListener() {
        }

        public void onSpeechTtsEvent(int i, String str) {
            Log.d("EmergencyTtsEngine", "onSpeechTtsEvent() called with: type = [" + i + "], ttsId = [" + str + "]");
            String str2 = EmergencyTtsEngine.this.j;
            if (str2 == null || !str2.equals(str)) {
                return;
            }
            if (i == 1 || i == 3 || i == 4) {
                EmergencyTtsEngine emergencyTtsEngine = EmergencyTtsEngine.this;
                emergencyTtsEngine.b.removeCallbacks(emergencyTtsEngine.f);
                emergencyTtsEngine.b.postDelayed(emergencyTtsEngine.f, 200L);
            }
        }

        public /* synthetic */ TtsListener(EmergencyTtsEngine emergencyTtsEngine, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            EmergencyTtsEngine.this.a();
            EmergencyTtsEngine.this.b.postDelayed(this, 500L);
        }
    }

    /* loaded from: classes.dex */
    public class b implements ServiceConnection {
        public b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d("EmergencyTtsEngine", "onServiceConnected() called with: name = [" + componentName + "], service = [" + iBinder + "]");
            EmergencyTtsEngine emergencyTtsEngine = EmergencyTtsEngine.this;
            emergencyTtsEngine.b.removeCallbacks(emergencyTtsEngine.e);
            try {
                EmergencyTtsEngine.this.d = (SmartManager) EmergencyTtsEngine.this.c.getXUIServiceManager("smart");
                EmergencyTtsEngine.this.d.registerCommonListener(new TtsListener(EmergencyTtsEngine.this, null));
            } catch (XUIServiceNotConnectedException e) {
                Log.e("EmergencyTtsEngine", "onServiceConnected: ", e);
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.w("EmergencyTtsEngine", "onServiceDisconnected: ");
            EmergencyTtsEngine emergencyTtsEngine = EmergencyTtsEngine.this;
            emergencyTtsEngine.b.postDelayed(emergencyTtsEngine.e, 500L);
        }
    }

    public EmergencyTtsEngine(Handler handler) {
        this.b = handler;
    }

    public void a() {
        if (this.c.isConnected() || this.c.isConnecting()) {
            return;
        }
        this.c.connect();
    }

    public final void b() {
        if (SystemClock.uptimeMillis() - this.g >= this.h) {
            this.j = null;
        } else {
            a(this.i);
        }
    }

    public final void a(CharSequence charSequence) {
        try {
            this.j = this.d.speakByInstant(charSequence.toString(), false);
        } catch (Throwable unused) {
            this.b.removeCallbacks(this.f);
            this.b.postDelayed(this.f, 200L);
        }
    }
}
