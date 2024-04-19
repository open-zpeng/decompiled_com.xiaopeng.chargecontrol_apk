package com.xiaopeng.xui.widget.quicksidebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XRelativeLayout;
import java.lang.ref.WeakReference;
/* loaded from: classes.dex */
public class XQuickSideBarTipsView extends XRelativeLayout {
    public lg0 d;
    public a e;
    public boolean f;

    /* loaded from: classes.dex */
    public static final class a extends Handler {
        public final WeakReference<XQuickSideBarTipsView> a;

        public a(XQuickSideBarTipsView xQuickSideBarTipsView) {
            this.a = new WeakReference<>(xQuickSideBarTipsView);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            XQuickSideBarTipsView xQuickSideBarTipsView = this.a.get();
            if (xQuickSideBarTipsView != null && message.what == 1) {
                if (xQuickSideBarTipsView.f) {
                    xQuickSideBarTipsView.animate().alpha(XToggleDrawable.LIGHT_RADIUS_DEFAULT).setDuration(200L).setListener(new mg0(xQuickSideBarTipsView));
                } else {
                    xQuickSideBarTipsView.setVisibility(4);
                }
                xQuickSideBarTipsView.e.removeMessages(1);
            }
        }
    }

    public XQuickSideBarTipsView(Context context) {
        this(context, null);
    }

    public void setAnimationHideTips(boolean z) {
        this.f = z;
    }

    public void setDelayedTime(long j) {
    }

    public void setText(String str) {
        lg0 lg0Var = this.d;
        lg0Var.f = str;
        Rect rect = new Rect();
        Paint paint = lg0Var.g;
        String str2 = lg0Var.f;
        paint.getTextBounds(str2, 0, str2.length(), rect);
        lg0Var.invalidate();
    }

    public XQuickSideBarTipsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XQuickSideBarTipsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = true;
        this.e = new a(this);
        if (attributeSet != null) {
            this.d = new lg0(context, attributeSet);
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dd0.XQuickSideBarView);
            obtainStyledAttributes.getInteger(dd0.XQuickSideBarView_sidebarTipsDelayTime, 500);
            obtainStyledAttributes.recycle();
            addView(this.d, new RelativeLayout.LayoutParams(-2, -2));
        }
    }
}
