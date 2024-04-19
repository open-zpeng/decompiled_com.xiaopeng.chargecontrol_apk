package defpackage;

import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import android.view.ViewGroup;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XEditText;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XImageView;
import com.xiaopeng.xui.widget.XRadioButton;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XScrollView;
import com.xiaopeng.xui.widget.XSeekBar;
import com.xiaopeng.xui.widget.XSwitch;
import com.xiaopeng.xui.widget.XTabLayout;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.slider.XSlider;
import com.xiaopeng.xui.widget.timepicker.XTimePicker;
/* compiled from: VuiViewUtils.java */
/* renamed from: cf0  reason: default package */
/* loaded from: classes.dex */
public class cf0 {
    public static HandlerThread a = new HandlerThread("VuiUpdate");
    public static Handler b;

    /* compiled from: VuiViewUtils.java */
    /* renamed from: cf0$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {
        public final /* synthetic */ gc0 c;
        public final /* synthetic */ View d;
        public final /* synthetic */ qc0 e;

        public a(gc0 gc0Var, View view, qc0 qc0Var) {
            this.c = gc0Var;
            this.d = view;
            this.e = qc0Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            View view;
            gc0 gc0Var = this.c;
            if (gc0Var == null || (view = this.d) == null) {
                return;
            }
            gc0Var.a(view, this.e);
        }
    }

    public static mc0 a(Object obj) {
        if (obj instanceof XImageView) {
            return mc0.IMAGEVIEW;
        }
        if (obj instanceof XImageButton) {
            return mc0.IMAGEBUTTON;
        }
        if (obj instanceof XButton) {
            return mc0.BUTTON;
        }
        if (obj instanceof XTextView) {
            return mc0.TEXTVIEW;
        }
        if (obj instanceof XRadioButton) {
            return mc0.RADIOBUTTON;
        }
        if (obj instanceof lf0) {
            return mc0.CHECKBOX;
        }
        if (obj instanceof XSwitch) {
            return mc0.SWITCH;
        }
        if (obj instanceof XRecyclerView) {
            return mc0.RECYCLEVIEW;
        }
        if (obj instanceof XScrollView) {
            return mc0.SCROLLVIEW;
        }
        if (obj instanceof XSlider) {
            return mc0.XSLIDER;
        }
        if (obj instanceof XTabLayout) {
            return mc0.XTABLAYOUT;
        }
        if (obj instanceof sf0) {
            return mc0.XTABLAYOUT;
        }
        if (obj instanceof rf0) {
            return mc0.RADIOGROUP;
        }
        if (obj instanceof XEditText) {
            return mc0.EDITTEXT;
        }
        if (obj instanceof qf0) {
            return mc0.XGROUPHEADER;
        }
        if (obj instanceof XSeekBar) {
            return mc0.SEEKBAR;
        }
        if (obj instanceof XTimePicker) {
            return mc0.TIMEPICKER;
        }
        if (obj instanceof wf0) {
            return mc0.VIEWPAGER;
        }
        if (obj instanceof ViewGroup) {
            return mc0.GROUP;
        }
        return mc0.UNKNOWN;
    }

    public static void a(gc0 gc0Var, View view, qc0 qc0Var) {
        try {
            if (b == null) {
                a.start();
                b = new Handler(a.getLooper());
            }
            if (b != null) {
                b.post(new a(gc0Var, view, qc0Var));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
