package defpackage;

import android.content.res.AssetFileDescriptor;
import android.media.AudioAttributes;
import android.media.SoundPool;
import android.util.AndroidRuntimeException;
import defpackage.zd0;
import java.io.IOException;
/* compiled from: SoundEffectPool.java */
/* renamed from: xd0  reason: default package */
/* loaded from: classes.dex */
public class xd0 extends vd0 {
    public int b;
    public SoundPool c;
    public zd0.a d;
    public boolean e;

    /* compiled from: SoundEffectPool.java */
    /* renamed from: xd0$b */
    /* loaded from: classes.dex */
    public class b implements zd0.a {
        public /* synthetic */ b(a aVar) {
        }

        @Override // defpackage.zd0.a
        public int a(yd0 yd0Var) {
            xd0 xd0Var = xd0.this;
            if (xd0Var.c != null) {
                AssetFileDescriptor assetFileDescriptor = null;
                try {
                    assetFileDescriptor = z90.c().getAssets().openFd(xd0.this.a.a);
                    xd0 xd0Var2 = xd0.this;
                    xd0Var2.a("LoaderAssets--resource:" + yd0Var + ",path:" + xd0.this.a.a + ", is success");
                } catch (IOException e) {
                    xd0 xd0Var3 = xd0.this;
                    xd0Var3.a("LoaderAssets--resource:" + yd0Var + ",path:" + xd0.this.a.a + ", is error");
                    e.printStackTrace();
                }
                try {
                    return xd0.this.c.load(assetFileDescriptor, 1);
                } catch (AndroidRuntimeException e2) {
                    e2.printStackTrace();
                    return 0;
                }
            }
            xd0Var.a("LoaderAssets--resource:" + yd0Var + ",mSoundPool is null");
            return 0;
        }
    }

    /* compiled from: SoundEffectPool.java */
    /* renamed from: xd0$c */
    /* loaded from: classes.dex */
    public class c implements zd0.a {
        public /* synthetic */ c(a aVar) {
        }

        @Override // defpackage.zd0.a
        public int a(yd0 yd0Var) {
            xd0 xd0Var = xd0.this;
            SoundPool soundPool = xd0Var.c;
            if (soundPool != null) {
                return soundPool.load(xd0Var.a.a, 1);
            }
            xd0Var.a("LoaderSystem--resource:" + yd0Var + ",mSoundPool is null");
            return 0;
        }
    }

    public xd0(yd0 yd0Var) {
        super(yd0Var);
        be0.a("xpui-SoundEffectPool", "constructor");
        int i = yd0Var.b;
        if (i == 0) {
            this.d = new b(null);
        } else if (i == 1) {
            this.d = new c(null);
        }
        a();
    }

    public /* synthetic */ void a(SoundPool soundPool, int i, int i2) {
        be0.a("xpui-SoundEffectPool", "load onLoadComplete--,sampleId:" + i + ",status:" + i2);
        if (this.e) {
            this.e = false;
            c();
        }
    }

    public final void b() {
        zd0.a aVar = this.d;
        if (aVar != null) {
            this.b = aVar.a(this.a);
            StringBuilder a2 = jg.a("load mSoundID : ");
            a2.append(this.b);
            be0.a("xpui-SoundEffectPool", a2.toString());
        } else {
            be0.a("xpui-SoundEffectPool", "load mISoundLoader is null");
        }
        this.c.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() { // from class: td0
            @Override // android.media.SoundPool.OnLoadCompleteListener
            public final void onLoadComplete(SoundPool soundPool, int i, int i2) {
                xd0.this.a(soundPool, i, i2);
            }
        });
    }

    public void c() {
        be0.a("xpui-SoundEffectPool", "play");
        SoundPool soundPool = this.c;
        if (soundPool != null) {
            this.e = true;
            int i = this.b;
            if (i == 0) {
                b();
                return;
            } else {
                soundPool.play(i, 1.0f, 1.0f, 1, 0, 1.0f);
                return;
            }
        }
        a();
    }

    public final void a() {
        be0.a("xpui-SoundEffectPool", "init");
        SoundPool.Builder builder = new SoundPool.Builder();
        builder.setMaxStreams(1);
        AudioAttributes.Builder builder2 = new AudioAttributes.Builder();
        builder2.setLegacyStreamType(this.a.a());
        be0.a("xpui-SoundEffectPool", "createSoundPool mSoundID : " + this.b + ",StreamType " + this.a.a());
        builder.setAudioAttributes(builder2.build());
        this.c = builder.build();
        b();
    }

    public final void a(String str) {
        be0.a("xpui-SoundEffectPool", str);
    }
}
