package defpackage;

import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.jy;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: SyncInfoToMcuTask.java */
/* renamed from: h80  reason: default package */
/* loaded from: classes.dex */
public class h80 implements i80 {
    public kh0 a;

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onMcuRequestInfo(jy.a aVar) {
        if (((Integer) aVar.a).intValue() == 3) {
            LogUtils.i("SyncInfoToMcuTask", "startSyncTask()");
            z90.a(this.a);
            if (0 + 39 <= 2147483647L) {
                this.a = z90.a(new cj0(0, 40)).a(new sh0() { // from class: y70
                    @Override // defpackage.sh0
                    public final Object apply(Object obj) {
                        bh0 a2;
                        Integer num = (Integer) obj;
                        a2 = ah0.a(1L, TimeUnit.SECONDS);
                        return a2;
                    }
                }).a(new th0() { // from class: w70
                    @Override // defpackage.th0
                    public final boolean test(Object obj) {
                        return h80.a((Long) obj);
                    }
                }).b(mk0.a()).a(hh0.a()).b(new rh0() { // from class: x70
                    @Override // defpackage.rh0
                    public final void accept(Object obj) {
                        Long l = (Long) obj;
                        ((iz) x90.m()).d(x90.e());
                    }
                });
                return;
            }
            throw new IllegalArgumentException("Integer overflow");
        }
    }

    @Override // defpackage.i80
    public void start() {
        LogUtils.i("SyncInfoToMcuTask", "start()");
        iv.d(this);
    }

    @Override // defpackage.i80
    public void stop() {
        LogUtils.i("SyncInfoToMcuTask", "stop()");
        iv.e(this);
        z90.a(this.a);
    }

    public static /* synthetic */ boolean a(Long l) {
        return 2 == x90.g();
    }
}
