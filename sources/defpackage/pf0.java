package defpackage;

import android.view.View;
import com.xiaopeng.xui.widget.XExposedDropdownMenu;
/* compiled from: XExposedDropdownMenu.java */
/* renamed from: pf0  reason: default package */
/* loaded from: classes.dex */
public class pf0 implements View.OnClickListener {
    public final /* synthetic */ XExposedDropdownMenu c;

    public pf0(XExposedDropdownMenu xExposedDropdownMenu) {
        this.c = xExposedDropdownMenu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        XExposedDropdownMenu xExposedDropdownMenu = this.c;
        xExposedDropdownMenu.i.setWidth(xExposedDropdownMenu.getWidth() - (xExposedDropdownMenu.n * 2));
        int[] iArr = new int[2];
        xExposedDropdownMenu.getLocationOnScreen(iArr);
        int height = xExposedDropdownMenu.i.getHeight() + xExposedDropdownMenu.getHeight() + iArr[1] + xExposedDropdownMenu.m;
        int i = xExposedDropdownMenu.getContext().getResources().getDisplayMetrics().heightPixels;
        int i2 = xExposedDropdownMenu.m;
        if (height > i) {
            i2 = ((-xExposedDropdownMenu.getHeight()) - xExposedDropdownMenu.i.getHeight()) - xExposedDropdownMenu.m;
        }
        xExposedDropdownMenu.i.showAsDropDown(xExposedDropdownMenu, xExposedDropdownMenu.n, i2);
    }
}
