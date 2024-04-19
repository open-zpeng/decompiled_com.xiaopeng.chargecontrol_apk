package defpackage;

import com.xiaopeng.carapi.CarApi;
import defpackage.jy;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: IgStatusConverter.java */
/* renamed from: sy  reason: default package */
/* loaded from: classes.dex */
public class sy {
    public Runnable a = new Runnable() { // from class: py
        @Override // java.lang.Runnable
        public final void run() {
            sy.this.b();
        }
    };

    public void a() {
        iv.d(this);
    }

    public /* synthetic */ void b() {
        iv.c(new qy(((iz) CarApi.e().c()).a(0)));
    }

    @tl0(priority = 3, sticky = true, threadMode = ThreadMode.MAIN)
    public void onIgStatusChanged(jy.b bVar) {
        jb0.b(this.a);
        if (1 == ((Integer) bVar.a).intValue()) {
            jb0.a(1, null, this.a, null, false, 1000L);
        } else {
            iv.c(new qy(((Integer) bVar.a).intValue()));
        }
    }
}
