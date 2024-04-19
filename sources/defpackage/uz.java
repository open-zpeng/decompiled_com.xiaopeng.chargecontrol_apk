package defpackage;

import android.content.Context;
import com.xiaopeng.libtheme.ThemeWrapper;
import defpackage.hy;
import defpackage.my;
import java.util.Map;
/* compiled from: D2CarBmsControllerCompat.java */
/* renamed from: uz  reason: default package */
/* loaded from: classes.dex */
public class uz extends cz {
    public uz(Context context) {
        super(context);
    }

    @Override // defpackage.dz
    public void a(Map<Integer, d00<?>> map) {
        map.put(559950859, d00.a(new my.v(), c00.c, ThemeWrapper.TIMEOUT));
        map.put(559950858, d00.a(new my.y(), c00.d, ThemeWrapper.TIMEOUT));
        map.put(557853703, d00.a(new hy.e()));
        map.put(557853721, d00.a(new hy.a()));
        map.put(557853719, d00.a(new hy.b()));
    }

    @Override // defpackage.cz, defpackage.hy
    public boolean a(boolean z) {
        try {
            if (this.c.getDcChargeStopReason() != 1) {
                return this.c.getAcChargeStopReason() == 1;
            }
            return true;
        } catch (Exception e) {
            StringBuilder a = jg.a("isFullCharged error:");
            a.append(e.getMessage());
            gb0.b("CarBmsController", a.toString());
            return z;
        }
    }
}
