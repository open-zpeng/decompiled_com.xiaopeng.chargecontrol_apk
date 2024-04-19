package defpackage;

import android.util.Log;
import com.xiaopeng.chargecontrol.app.bean.ChargePrepareBean;
import com.xiaopeng.lib.framework.moduleinterface.ipcmodule.IIpcService;
import com.xiaopeng.libconfig.ipc.IpcConfig;
import defpackage.hy;
import defpackage.my;
import java.util.concurrent.TimeUnit;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: ChargePreparePresenter.java */
/* renamed from: h30  reason: default package */
/* loaded from: classes.dex */
public class h30 extends i10<i30> {
    public kh0 b;
    public boolean c;
    public boolean d;
    public int e = -1;
    public long f = 0;
    public ChargePrepareBean g;

    public static /* synthetic */ boolean c(Long l) {
        return l.longValue() > 40;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.i10
    public void a(i30 i30Var) {
        this.a = i30Var;
        this.c = ((oz) x90.s()).b(0) == 1;
        this.d = ((oz) x90.s()).e(0) == 1;
        iv.d(this);
    }

    public /* synthetic */ void b(Long l) {
        ((i30) this.a).d(l.intValue());
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryCooling(my.c cVar) {
        this.c = ((Integer) cVar.a).intValue() == 1;
        b();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBatteryWarming(my.g gVar) {
        this.d = ((Integer) gVar.a).intValue() == 1;
        b();
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onBmsChargeMode(hy.d dVar) {
        if (((Integer) dVar.a).intValue() == 6) {
            ((i30) this.a).j(true);
            long j = this.f;
            if (j >= 40) {
                j = 0;
            }
            this.b = ah0.a(j, 40 - this.f, 1L, 1L, TimeUnit.SECONDS).a(new rh0() { // from class: d30
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    h30.this.a((Long) obj);
                }
            }).b(new th0() { // from class: f30
                @Override // defpackage.th0
                public final boolean test(Object obj) {
                    return h30.c((Long) obj);
                }
            }).a(hh0.a()).b(new rh0() { // from class: e30
                @Override // defpackage.rh0
                public final void accept(Object obj) {
                    h30.this.b((Long) obj);
                }
            });
        } else if (((Integer) dVar.a).intValue() == 9) {
            ((i30) this.a).j(false);
        }
    }

    @tl0(sticky = true, threadMode = ThreadMode.MAIN)
    public void onHeatManagementTimeChanged(my.g0 g0Var) {
        this.e = ((Integer) g0Var.a).intValue();
        b();
    }

    @tl0(threadMode = ThreadMode.MAIN)
    public void onIpcMessage(IIpcService.IpcMessageEvent ipcMessageEvent) {
        if (ipcMessageEvent.getMsgID() == 10010) {
            String string = ipcMessageEvent.getPayloadData().getString(IpcConfig.IPCKey.STRING_MSG);
            Log.i("ChargePreparePresenter", "onIpcMessage: " + string);
            try {
                a(string, new JSONObject(string).getInt("scene"));
            } catch (JSONException e) {
                StringBuilder a = jg.a("Json error: ");
                a.append(e.getMessage());
                Log.e("ChargePreparePresenter", a.toString());
                e.printStackTrace();
            }
        }
    }

    public final void b() {
        ((i30) this.a).e(this.c || this.d);
        ((i30) this.a).a(this.d, this.e);
    }

    @Override // defpackage.i10
    public void a() {
        z90.a(this.b);
        iv.e(this);
        this.a = null;
    }

    public /* synthetic */ void a(Long l) {
        this.f = l.longValue();
    }

    public final void a(String str, int i) {
        Log.i("ChargePreparePresenter", "updatePrepaseState scene = " + i);
        if (i == 5012 || i == 5011) {
            this.g = (ChargePrepareBean) ca0.a.a(str, (Class<Object>) ChargePrepareBean.class);
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("ChargePreparePresenter", "updatePrepaseState currentTime =" + currentTimeMillis + ", validEndTs = " + this.g.validEndTs + ", validStartTs= " + this.g.validStartTs);
            ChargePrepareBean chargePrepareBean = this.g;
            if (currentTimeMillis > chargePrepareBean.validEndTs || currentTimeMillis < chargePrepareBean.validStartTs) {
                return;
            }
            Log.i("ChargePreparePresenter", "SCENE_AMBIGUOUS_TRUNK_POWER_PREPASE_STATE SCENE_AMBIGUOUS_TRUNK_POWER_PREPASE_STATE");
            String str2 = this.g.content;
            if (str2 != null) {
                try {
                    JSONObject jSONObject = new JSONObject(str2);
                    String string = jSONObject.getString("title");
                    String string2 = jSONObject.getString("subtitle");
                    String string3 = jSONObject.getString("result");
                    ((i30) this.a).a(string, string2);
                    if ("00".equals(string3)) {
                        return;
                    }
                    z90.a(this.b);
                } catch (JSONException e) {
                    StringBuilder a = jg.a("Json error: ");
                    a.append(e.getMessage());
                    Log.e("ChargePreparePresenter", a.toString());
                    e.printStackTrace();
                }
            }
        }
    }
}
