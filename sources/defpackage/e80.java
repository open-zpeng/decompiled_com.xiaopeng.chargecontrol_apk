package defpackage;

import android.util.Log;
import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.fa0;
import defpackage.iy;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: IcmConnectTask.java */
/* renamed from: e80  reason: default package */
/* loaded from: classes.dex */
public class e80 implements i80 {
    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    private void SendElectricityMode(ey eyVar) {
        if (eyVar.a) {
            x90.d(fa0.b.a.c());
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onIcmConnected(iy.a aVar) {
        StringBuilder a = jg.a("onIcmConnected: ");
        a.append(aVar.a);
        Log.d("IcmConnectTask", a.toString());
        if (((Integer) aVar.a).intValue() == 1) {
            x90.d(fa0.b.a.c());
        }
    }

    @Override // defpackage.i80
    public void start() {
        LogUtils.i("IcmConnectTask", "start()");
        iv.d(this);
    }

    @Override // defpackage.i80
    public void stop() {
        LogUtils.i("IcmConnectTask", "stop()");
        iv.e(this);
    }
}
