package defpackage;

import android.os.SystemProperties;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import defpackage.g70;
/* compiled from: HelpMileageModeHolder.java */
/* renamed from: c50  reason: default package */
/* loaded from: classes.dex */
public class c50 extends x40 {
    @Override // defpackage.x40
    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i;
        super.a(layoutInflater, viewGroup);
        if (!g70.a.a.a()) {
            this.a.findViewById(o90.nedcTitle).setVisibility(8);
            this.a.findViewById(o90.nedcContent).setVisibility(8);
        }
        if (a70.h()) {
            try {
                i = Integer.parseInt(SystemProperties.get("persist.sys.xiaopeng.dstBatCfg", "0"));
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 1) {
                this.a.findViewById(o90.nedcTitle).setVisibility(8);
                this.a.findViewById(o90.nedcContent).setVisibility(8);
                this.a.findViewById(o90.cltcTitle).setVisibility(0);
                this.a.findViewById(o90.cltcContent).setVisibility(0);
                return;
            }
            this.a.findViewById(o90.nedcTitle).setVisibility(0);
            this.a.findViewById(o90.nedcContent).setVisibility(0);
            this.a.findViewById(o90.cltcTitle).setVisibility(8);
            this.a.findViewById(o90.cltcContent).setVisibility(8);
        }
    }

    @Override // defpackage.x40
    public int b() {
        return q90.layout_help_mileage_mode;
    }

    @Override // defpackage.x40
    public int c() {
        return r90.help_tab_mileage_mode;
    }

    @Override // defpackage.x40
    public int a() {
        if (a70.f()) {
            return n90.help_image_mileage_mode_d55a;
        }
        return n90.help_image_mileage_mode;
    }
}
