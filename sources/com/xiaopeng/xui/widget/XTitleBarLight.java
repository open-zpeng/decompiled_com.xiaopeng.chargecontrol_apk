package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import defpackage.b50;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class XTitleBarLight extends XRelativeLayout implements View.OnClickListener, hc0 {
    public XImageButton d;
    public XImageButton e;
    public TextView f;
    public ViewGroup g;
    public a h;
    public ViewGroup i;
    public int j;

    /* loaded from: classes.dex */
    public interface a {
    }

    public XTitleBarLight(Context context) {
        this(context, null);
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        try {
            if (this.e != null) {
                if (this.e.getVisibility() != 0) {
                    this.e.a(oc0.DISABLED);
                } else {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(VuiConstants.PROPS_GENERALACT, VuiConstants.GENERALACT_RETURN);
                    this.e.a(jSONObject);
                }
            }
            if (this.d != null) {
                if (this.d.getVisibility() != 0) {
                    this.d.a(oc0.DISABLED);
                    return null;
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(VuiConstants.PROPS_GENERALACT, VuiConstants.GENERALACT_CLOSE);
                this.d.a(jSONObject2);
                return null;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        return false;
    }

    @Override // com.xiaopeng.xui.widget.XRelativeLayout, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ce0.a(this.d, this.i);
        ce0.a(this.e, this.i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        a aVar;
        int id = view.getId();
        if (id == yc0.x_titlebar_btn_close) {
            a aVar2 = this.h;
            if (aVar2 != null) {
                b50.this.v1();
            }
        } else if (id != yc0.x_titlebar_btn_back || (aVar = this.h) == null) {
        } else {
            ((b50.b) aVar).a();
        }
    }

    public void setMainAction(int i) {
        if (i == -1) {
            this.e.setVisibility(4);
            this.d.setVisibility(4);
        } else if (i != 1) {
            this.d.setVisibility(0);
            this.e.setVisibility(4);
        } else {
            this.e.setVisibility(0);
            this.d.setVisibility(4);
        }
    }

    public void setOnTitleBarClickListener(a aVar) {
        this.h = aVar;
    }

    public void setRightAction(int i) {
        setRightAction(LayoutInflater.from(getContext()).inflate(i, this.g, false));
    }

    public void setTitle(int i) {
        this.f.setText(i);
    }

    public void setTitleType(int i) {
        if (i != 1) {
            TextView textView = this.f;
            textView.setPadding(0, textView.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
            return;
        }
        TextView textView2 = this.f;
        textView2.setPadding(this.j, textView2.getPaddingTop(), this.f.getPaddingRight(), this.f.getPaddingBottom());
    }

    public XTitleBarLight(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setTitle(CharSequence charSequence) {
        this.f.setText(charSequence);
    }

    public XTitleBarLight(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public void setRightAction(View view) {
        this.g.removeAllViews();
        this.g.addView(view);
        this.g.setVisibility(0);
    }

    public XTitleBarLight(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        LayoutInflater.from(context).inflate(ad0.x_titlebarlight, this);
        this.d = (XImageButton) findViewById(yc0.x_titlebar_btn_close);
        this.e = (XImageButton) findViewById(yc0.x_titlebar_btn_back);
        this.f = (TextView) findViewById(yc0.x_titlebar_tv_title);
        this.g = (ViewGroup) findViewById(yc0.x_titlebar_right_container);
        this.i = (ViewGroup) findViewById(yc0.x_titlebar_btn_close_lay);
        this.d.setOnClickListener(this);
        this.e.setOnClickListener(this);
        this.j = (int) getResources().getDimension(wc0.x_title_bar_light_sparse_padding);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, dd0.XTitleBarLight);
        setTitle(obtainStyledAttributes.getString(dd0.XTitleBarLight_title_text));
        setMainAction(obtainStyledAttributes.getInt(dd0.XTitleBarLight_title_main_action, 0));
        setTitleType(obtainStyledAttributes.getInt(dd0.XTitleBarLight_title_text_type, 0));
        int resourceId = obtainStyledAttributes.getResourceId(dd0.XTitleBarLight_title_right_action_layout, 0);
        if (resourceId > 0) {
            setRightAction(resourceId);
        }
        obtainStyledAttributes.recycle();
    }
}
