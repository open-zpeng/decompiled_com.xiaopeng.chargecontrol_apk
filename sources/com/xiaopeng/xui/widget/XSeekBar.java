package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;
import com.xiaopeng.xui.drawable.XLoadingDrawable;
import com.xiaopeng.xui.widget.XSeekBar;
/* loaded from: classes.dex */
public class XSeekBar extends h3 implements re0, hc0 {
    public fe0 d;
    public SeekBar.OnSeekBarChangeListener e;

    /* loaded from: classes.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = XSeekBar.this.e;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onProgressChanged(seekBar, i, z);
            }
            XSeekBar xSeekBar = XSeekBar.this;
            xSeekBar.a((View) xSeekBar);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = XSeekBar.this.e;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStartTrackingTouch(seekBar);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SeekBar.OnSeekBarChangeListener onSeekBarChangeListener = XSeekBar.this.e;
            if (onSeekBarChangeListener != null) {
                onSeekBarChangeListener.onStopTrackingTouch(seekBar);
            }
        }
    }

    public XSeekBar(Context context) {
        super(context);
        t();
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        return null;
    }

    @Override // defpackage.hc0
    public boolean a(final View view, tc0 tc0Var) {
        final Double d;
        d("SeekBar onVuiElementEvent");
        if (view == null || (d = (Double) tc0Var.getEventValue(tc0Var)) == null) {
            return false;
        }
        post(new Runnable() { // from class: hf0
            @Override // java.lang.Runnable
            public final void run() {
                XSeekBar.this.a(d, view);
            }
        });
        return true;
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        fe0 fe0Var = this.d;
        if (fe0Var != null) {
            fe0Var.a();
        }
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        fe0 fe0Var = this.d;
        if (fe0Var != null) {
            fe0Var.a(configuration);
        }
    }

    @Override // android.widget.ProgressBar, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        fe0 fe0Var = this.d;
        if (fe0Var != null) {
            fe0Var.b();
        }
    }

    @Override // android.widget.SeekBar
    public void setOnSeekBarChangeListener(SeekBar.OnSeekBarChangeListener onSeekBarChangeListener) {
        this.e = onSeekBarChangeListener;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        a(this, i);
    }

    public final void t() {
        super.setOnSeekBarChangeListener(new a());
    }

    public XSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.d = fe0.a(this, attributeSet);
        t();
        a(this, attributeSet);
    }

    public /* synthetic */ void a(Double d, View view) {
        if (d.doubleValue() >= XLoadingDrawable.DEFAULT_RADIANS && d.doubleValue() <= 100.0d) {
            setProgress(d.intValue());
        }
        z90.a(view, 0, (int) ((((getProgress() * 1.0f) / getMax()) - 0.5d) * getWidth()), 0);
    }

    public XSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.d = fe0.a(this, attributeSet, i, 0);
        t();
        a(this, attributeSet);
    }
}
