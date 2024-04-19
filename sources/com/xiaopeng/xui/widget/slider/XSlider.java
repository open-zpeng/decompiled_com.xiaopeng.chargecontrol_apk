package com.xiaopeng.xui.widget.slider;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.xui.widget.slider.XSlider;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XSlider extends rg0 {

    /* loaded from: classes.dex */
    public interface a {
    }

    /* loaded from: classes.dex */
    public interface b {
    }

    public XSlider(Context context) {
        this(context, null);
    }

    public final float a(MotionEvent motionEvent) {
        return getOrientation() == 0 ? motionEvent.getX() : getHeight() - motionEvent.getY();
    }

    public void b(final int i, final boolean z) {
        post(new Runnable() { // from class: og0
            @Override // java.lang.Runnable
            public final void run() {
                XSlider.this.a(i, z);
            }
        });
    }

    @Override // defpackage.rg0
    public float getIndicatorValue() {
        return (((float) a(this.q, this.k)) + this.h) * this.E;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                ViewGroup v = v();
                boolean z = (v != null && v.canScrollVertically(1)) || (v != null && v.canScrollVertically(-1));
                if (!(getOrientation() != 0 ? !((v != null && v.canScrollHorizontally(-1)) || (v != null && v.canScrollHorizontally(1))) : !z)) {
                    this.G = motionEvent.getX();
                    this.H = motionEvent.getY();
                } else {
                    this.I = true;
                    getParent().requestDisallowInterceptTouchEvent(true);
                    this.o = a(motionEvent);
                    a(true, false);
                    u();
                }
            } else if (action == 1) {
                if (this.I) {
                    this.I = false;
                }
                this.o = a(motionEvent);
                w();
                a(true, true);
                getParent().requestDisallowInterceptTouchEvent(false);
                u();
            } else if (action != 2) {
                if (action == 3) {
                    if (this.I) {
                        this.I = false;
                    }
                    u();
                }
            } else if (this.I) {
                this.o = a(motionEvent);
                a(true, false);
                u();
            } else {
                if (getOrientation() != 0 ? Math.abs(motionEvent.getY() - this.H) > this.J : Math.abs(motionEvent.getX() - this.G) > this.J) {
                    this.I = true;
                    this.o = a(motionEvent);
                    getParent().requestDisallowInterceptTouchEvent(true);
                    a(true, false);
                    u();
                }
            }
            return true;
        }
        return true;
    }

    @Override // defpackage.rg0
    public void setAccuracy(float f) {
        this.s = f;
    }

    public void setCurrentIndex(int i) {
        b(i, false);
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        if (!z) {
            this.I = false;
        }
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setEnabled(z);
        }
        setAlphaByEnable(z);
        invalidate();
    }

    public void setEndIndex(int i) {
        if (this.h != i) {
            this.j = i;
            post(new Runnable() { // from class: qg0
                @Override // java.lang.Runnable
                public final void run() {
                    XSlider.this.x();
                }
            });
            return;
        }
        throw new RuntimeException("startIndex = endIndex!!!");
    }

    public void setInitIndex(int i) {
        int i2 = this.j;
        if (i > i2) {
            this.i = i2;
            return;
        }
        int i3 = this.h;
        if (i < i3) {
            this.i = i3;
            return;
        }
        this.i = i;
        this.q = i - i3;
        invalidate();
    }

    public void setProgressChangeListener(a aVar) {
    }

    public void setSliderProgressListener(b bVar) {
    }

    public void setStartIndex(int i) {
        if (i != this.j) {
            this.h = i;
            post(new Runnable() { // from class: pg0
                @Override // java.lang.Runnable
                public final void run() {
                    XSlider.this.y();
                }
            });
            return;
        }
        throw new RuntimeException("startIndex = endIndex!!!");
    }

    public /* synthetic */ void x() {
        invalidate();
    }

    public /* synthetic */ void y() {
        sg0 sg0Var = this.P;
        if (sg0Var != null) {
            sg0Var.a(t(), getPopString(), getSliderLength());
        }
        invalidate();
    }

    public void z() {
        int heightExIndicator = (int) ((getHeightExIndicator() / 2.0f) - (getSliderThickness() / 2));
        int sliderLength = ((int) (getOrientation() == 1 ? getSliderLength() - getProgressViewLength() : getProgressViewLength())) - (getSliderLength() / 2);
        int i = getOrientation() == 1 ? sliderLength : heightExIndicator;
        if (getOrientation() != 1) {
            heightExIndicator = sliderLength;
        }
        z90.a(this, 0, heightExIndicator, i);
    }

    public XSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public final void a(boolean z, boolean z2) {
        float t = t();
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            vg0 vg0Var = (vg0) getChildAt(i);
            if ((vg0Var.getWidth() / 2.0f) + vg0Var.getX() <= t()) {
                if (!vg0Var.d) {
                    vg0Var.c(true);
                }
            } else {
                vg0Var.c(false);
            }
        }
        if (z) {
            this.q = ((t - 16.0f) / this.w) * (this.j - this.h);
            a(this.q, this.k);
        }
    }

    public XSlider(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, cd0.XSlider);
    }

    public XSlider(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public static double a(double d, int i) {
        if (i >= 0) {
            return BigDecimal.valueOf(d).setScale(i, RoundingMode.DOWN).doubleValue();
        }
        throw new IllegalArgumentException();
    }

    public /* synthetic */ void a(int i, boolean z) {
        be0.c("XSlider", "setCurrentIndex:" + i + ", fromUser:" + z);
        int i2 = this.h;
        this.o = ((((float) (i - i2)) / ((float) (this.j - i2))) * ((float) this.w)) + 16.0f;
        this.q = (float) (i - i2);
        invalidate();
        a(false, false);
        this.r = i;
        sg0 sg0Var = this.P;
        if (sg0Var != null) {
            sg0Var.a(t(), getPopString(), getSliderLength());
        }
        if (n() == null || ((Float) n()).floatValue() != getIndicatorValue()) {
            a((View) this);
        }
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        try {
            a(Float.valueOf(getIndicatorValue()));
        } catch (JSONException unused) {
        }
        if (p() != null && p().has(VuiConstants.PROPS_SETPROPS) && p().getBoolean(VuiConstants.PROPS_SETPROPS)) {
            return null;
        }
        JSONObject p = p();
        if (p == null) {
            p = new JSONObject();
        }
        p.put(VuiConstants.PROPS_MINVALUE, this.h);
        p.put(VuiConstants.PROPS_MAXVALUE, this.j);
        p.put(VuiConstants.PROPS_INTERVAL, (int) Math.ceil((this.j - this.h) / 10.0d));
        a(p);
        return null;
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        int round;
        d("slider onVuiElementEvent");
        boolean z = false;
        if (view == null) {
            return false;
        }
        Double d = (Double) tc0Var.getEventValue(tc0Var);
        if (d != null) {
            z = true;
            if (this.E == 1) {
                round = (int) Math.ceil(d.doubleValue());
            } else {
                round = (int) Math.round(d.doubleValue() / this.E);
            }
            if (round >= this.h && round <= this.j) {
                b(round, true);
                post(new Runnable() { // from class: ng0
                    @Override // java.lang.Runnable
                    public final void run() {
                        XSlider.this.z();
                    }
                });
            }
        }
        return z;
    }
}
