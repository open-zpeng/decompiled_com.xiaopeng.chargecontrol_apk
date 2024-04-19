package defpackage;

import com.xiaopeng.speech.vui.utils.LogUtils;
import defpackage.ly;
import java.util.Arrays;
import org.greenrobot.eventbus.ThreadMode;
/* compiled from: ChargeAppointmentPresenter.java */
/* renamed from: f20  reason: default package */
/* loaded from: classes.dex */
public class f20 extends i10<g20> {
    public int[] b = new int[3];

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(g20 g20Var) {
        this.a = g20Var;
        iv.d(this);
    }

    public void b() {
        int[] iArr = this.b;
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        if (1 == copyOf[0]) {
            copyOf[0] = 0;
        }
        LogUtils.i("CarHelper", "setChargeAppointmentTime");
        ((mz) x90.q()).c(copyOf);
        jb0.a(1, null, new Runnable() { // from class: d20
            @Override // java.lang.Runnable
            public final void run() {
                x90.y();
            }
        }, null, false, 500L);
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void handleChargeAppointmentTime(ly.b bVar) {
        Integer[] numArr = (Integer[]) bVar.a;
        int intValue = numArr[0].intValue();
        int intValue2 = numArr[1].intValue();
        int intValue3 = numArr[2].intValue();
        int[] iArr = this.b;
        iArr[0] = intValue;
        iArr[1] = intValue2;
        iArr[2] = intValue3;
        ((g20) this.a).a(intValue, intValue2, intValue3);
    }

    @Override // defpackage.i10
    public void a() {
        iv.e(this);
        this.a = null;
    }
}
