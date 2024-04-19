package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.xiaopeng.libtheme.ThemeManager;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.view.XView;
/* compiled from: XQuickSideBarTipsItemView.java */
/* renamed from: lg0  reason: default package */
/* loaded from: classes.dex */
public class lg0 extends XView {
    public RectF d;
    public Paint e;
    public String f;
    public Paint g;
    public int h;
    public int i;
    public float j;
    public int k;
    public int l;

    public lg0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.d = new RectF();
        this.f = "";
        t();
        this.j = context.getResources().getDimension(wc0.x_sidebar_tips_textsize);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, dd0.XQuickSideBarView);
            this.k = obtainStyledAttributes.getColor(dd0.XQuickSideBarView_sidebarTextColor, this.k);
            this.l = obtainStyledAttributes.getColor(dd0.XQuickSideBarView_sidebarBackgroundColor, this.l);
            obtainStyledAttributes.recycle();
        }
        getResources();
        this.e = new Paint(1);
        this.g = new Paint(1);
        this.e.setColor(this.l);
        this.g.setColor(this.k);
        this.g.setTextSize(this.j);
        this.g.setStyle(Paint.Style.FILL);
        this.g.setTypeface(Typeface.create(getResources().getString(bd0.x_font_typeface_number_bold), 0));
        this.g.setTextAlign(Paint.Align.CENTER);
    }

    @Override // com.xiaopeng.xui.view.XView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            t();
            this.e.setColor(this.l);
            this.g.setColor(this.k);
            invalidate();
        }
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (TextUtils.isEmpty(this.f)) {
            return;
        }
        canvas.drawColor(getResources().getColor(17170445, null));
        this.d.set(XToggleDrawable.LIGHT_RADIUS_DEFAULT, XToggleDrawable.LIGHT_RADIUS_DEFAULT, this.h, this.i);
        canvas.drawRoundRect(this.d, 16.0f, 16.0f, this.e);
        Paint.FontMetrics fontMetrics = this.g.getFontMetrics();
        canvas.drawText(this.f, this.d.centerX(), (int) ((this.d.centerY() - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 8.0f)), this.g);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.h = getMeasuredWidth();
        this.i = this.h;
    }

    public final void t() {
        this.k = getResources().getColor(vc0.x_side_bar_tips_text_color, getContext().getTheme());
        this.l = getResources().getColor(vc0.x_side_bar_tips_bg_color, getContext().getTheme());
    }
}
