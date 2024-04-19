package defpackage;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import com.xiaopeng.chargecontrol.R;
import defpackage.i10;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/* compiled from: CarBaseFragment.java */
/* renamed from: b10  reason: default package */
/* loaded from: classes.dex */
public abstract class b10<V, P extends i10<V>> extends ia0<V, P> implements jc0 {
    public ImageView b0;
    public ImageView c0;

    @Override // defpackage.ia0, defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        if (this.b0 == null || this.c0 == null || !a70.g()) {
            return;
        }
        this.b0.setImageResource(R.drawable.slow_port_normal);
        this.c0.setImageResource(R.drawable.fast_port_normal);
    }

    @Override // defpackage.ia0, defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        this.b0 = (ImageView) r1().findViewById(R.id.charge_port_slow);
        this.c0 = (ImageView) r1().findViewById(R.id.charge_port_fast);
        ImageView imageView = (ImageView) r1().findViewById(R.id.battery_anim);
    }

    @Override // defpackage.ia0
    public List<String> getSubSceneList() {
        if (a70.g()) {
            return Arrays.asList("Main", "MainBottom");
        }
        return Collections.singletonList("Main");
    }
}
