package defpackage;

import android.app.ActivityThread;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import com.xiaopeng.chargecontrol.speech.EmergencyTtsEngine;
import java.util.concurrent.atomic.AtomicInteger;
/* compiled from: TtsEngine.java */
/* renamed from: p80  reason: default package */
/* loaded from: classes.dex */
public class p80 {
    public volatile TextToSpeech a;
    public final Handler c;
    public EmergencyTtsEngine e;
    public AtomicInteger b = new AtomicInteger(0);
    public Runnable f = new Runnable() { // from class: n80
        @Override // java.lang.Runnable
        public final void run() {
            p80.this.a();
        }
    };
    public Application d = ActivityThread.currentApplication();

    /* compiled from: TtsEngine.java */
    /* renamed from: p80$b */
    /* loaded from: classes.dex */
    public static class b {
        public static final p80 a = new p80(null);
    }

    public /* synthetic */ p80(a aVar) {
        HandlerThread handlerThread = new HandlerThread("Tts");
        handlerThread.start();
        this.c = new Handler(handlerThread.getLooper());
        this.e = new EmergencyTtsEngine(this.c);
    }

    public void a() {
        this.a = new TextToSpeech(this.d, new TextToSpeech.OnInitListener() { // from class: m80
            @Override // android.speech.tts.TextToSpeech.OnInitListener
            public final void onInit(int i) {
                p80.this.a(i);
            }
        });
        this.e.a();
    }

    public /* synthetic */ void a(int i) {
        Log.i("TtsEngine", "init status = " + i);
        if (i == 0) {
            this.b.compareAndSet(0, 1);
        } else {
            this.c.postDelayed(this.f, 500L);
        }
    }
}
