package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import com.xiaopeng.xui.widget.XLinearLayout;
/* compiled from: XGroupHeader.java */
/* renamed from: qf0  reason: default package */
/* loaded from: classes.dex */
public class qf0 extends XLinearLayout {
    public TextView d;
    public View e;
    public int f;

    private void setView(int i) {
        int i2 = this.f;
        if (i2 != 0) {
            if (i2 == 1) {
                this.e = LayoutInflater.from(getContext()).inflate(ad0.x_groupheader_action_icon, (ViewGroup) this, false);
                addView(this.e);
                if (i > 0) {
                    setIcon(i);
                }
            } else if (i2 == 2) {
                this.e = LayoutInflater.from(getContext()).inflate(ad0.x_groupheader_action_button, (ViewGroup) this, false);
                addView(this.e);
                if (i > 0) {
                    ((TextView) this.e).setText(i);
                }
            } else if (i2 == 3) {
                this.e = LayoutInflater.from(getContext()).inflate(ad0.x_groupheader_action_loading, (ViewGroup) this, false);
                addView(this.e);
            } else if (i2 == 4 && i > 0) {
                this.e = LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false);
                addView(this.e);
            }
        }
    }

    public View getRightView() {
        return this.e;
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (view != null) {
            view.setVisibility(4);
        }
        super.removeView(view);
    }

    public void setButtonText(int i) {
        if (this.f == 2) {
            ((TextView) this.e).setText(i);
            return;
        }
        this.f = 2;
        removeView(this.e);
        setView(i);
    }

    public void setCustom(int i) {
        this.f = 4;
        removeView(this.e);
        setView(i);
    }

    public void setIcon(int i) {
        if (this.f == 1) {
            ((ImageButton) this.e).setImageResource(i);
            return;
        }
        this.f = 1;
        removeView(this.e);
        setView(i);
    }

    public void setText(CharSequence charSequence) {
        this.d.setText(charSequence);
    }
}
