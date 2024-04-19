package defpackage;

import android.content.Context;
import android.view.WindowManager;
import com.xiaopeng.chargecontrol.R;
import com.xiaopeng.chargecontrol.app.SolarRoofDialogService;
/* compiled from: SolarRoofDialogService.java */
/* renamed from: j10  reason: default package */
/* loaded from: classes.dex */
public class j10 extends ld0 {
    public final /* synthetic */ SolarRoofDialogService n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j10(SolarRoofDialogService solarRoofDialogService, Context context, int i) {
        super(context, i, null);
        this.n = solarRoofDialogService;
    }

    @Override // defpackage.ld0
    public void a(int i, int i2) {
        super.a(i, i2);
        WindowManager.LayoutParams attributes = this.e.getWindow().getAttributes();
        attributes.width = this.n.getResources().getDimensionPixelSize(R.dimen.help_dialog_width);
        attributes.height = this.n.getResources().getDimensionPixelSize(R.dimen.help_dialog_height);
        attributes.y = this.n.getResources().getDimensionPixelSize(R.dimen.panel_dialog_margin_top);
        attributes.x = this.n.getResources().getDimensionPixelSize(R.dimen.panel_dialog_margin_start);
        attributes.gravity = 17;
        this.e.getWindow().setAttributes(attributes);
    }
}
