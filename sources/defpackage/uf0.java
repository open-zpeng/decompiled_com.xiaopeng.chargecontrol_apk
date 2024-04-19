package defpackage;

import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XTabLayout;
/* compiled from: XTabLayout.java */
/* renamed from: uf0  reason: default package */
/* loaded from: classes.dex */
public class uf0 implements ViewGroup.OnHierarchyChangeListener {
    public final /* synthetic */ XTabLayout c;

    public uf0(XTabLayout xTabLayout) {
        this.c = xTabLayout;
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        view2.setOnClickListener(this.c.T);
        XTabLayout xTabLayout = this.c;
        if (xTabLayout.K < 0) {
            xTabLayout.K = xTabLayout.indexOfChild(view2);
            view2.setSelected(true);
        }
        Object tag = view2.getTag();
        this.c.post(new tf0(this, tag == null ? false : ((Boolean) tag).booleanValue()));
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        view2.setOnClickListener(null);
        Object tag = view2.getTag();
        this.c.post(new tf0(this, tag == null ? false : ((Boolean) tag).booleanValue()));
    }
}
