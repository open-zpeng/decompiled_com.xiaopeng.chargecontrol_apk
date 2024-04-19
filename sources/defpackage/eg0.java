package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.xiaopeng.libtheme.ThemeViewModel;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import com.xiaopeng.xui.drawable.XToggleDrawable;
import com.xiaopeng.xui.widget.XButton;
import com.xiaopeng.xui.widget.XImageButton;
import com.xiaopeng.xui.widget.XLinearLayout;
import com.xiaopeng.xui.widget.XScrollView;
import com.xiaopeng.xui.widget.XTextView;
import defpackage.zf0;
import org.json.JSONObject;
/* compiled from: XDialogViewDelegateImpl.java */
/* renamed from: eg0  reason: default package */
/* loaded from: classes.dex */
public class eg0 extends cg0 {
    public b c;
    public ViewGroup d;
    public TextView e;
    public ViewGroup f;
    public XButton g;
    public XButton h;
    public View i;
    public View j;
    public ag0 k;
    public XScrollView l;
    public ig0 m;
    public jg0 n;
    public kg0 o;
    public hg0 p;
    public hg0 q;
    public boolean r;
    public boolean s;
    public zf0 t;
    public View.OnClickListener u;

    /* compiled from: XDialogViewDelegateImpl.java */
    /* renamed from: eg0$a */
    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            eg0 eg0Var = eg0.this;
            boolean z = eg0Var.r;
            boolean z2 = eg0Var.s;
            if (id == yc0.x_dialog_button1) {
                if (eg0Var.p != null) {
                    eg0Var.a("onClick  positiveIntercept " + z + " , mPositiveListener " + eg0.this.p);
                    eg0 eg0Var2 = eg0.this;
                    eg0Var2.p.a(eg0Var2.a, -1);
                    if (z) {
                        return;
                    }
                } else {
                    eg0Var.a("onClick mPositiveListener is null");
                }
            } else if (id == yc0.x_dialog_button2) {
                if (eg0Var.q != null) {
                    eg0Var.a("onClick negativeIntercept " + z2 + " , mNegativeListener " + eg0.this.q);
                    eg0 eg0Var3 = eg0.this;
                    eg0Var3.q.a(eg0Var3.a, -2);
                    if (z2) {
                        return;
                    }
                } else {
                    eg0Var.a("onClick mNegativeListener is null");
                }
            } else if (id == yc0.x_dialog_close) {
                eg0Var.a("onClick close");
                ig0 ig0Var = eg0.this.m;
            } else {
                eg0Var.a("onClick invalid id " + id);
            }
            eg0 eg0Var4 = eg0.this;
            kg0 kg0Var = eg0Var4.o;
            if (kg0Var != null) {
                kg0Var.a(eg0Var4.a);
            }
        }
    }

    /* compiled from: XDialogViewDelegateImpl.java */
    /* renamed from: eg0$b */
    /* loaded from: classes.dex */
    public class b extends XLinearLayout {
        public int d;
        public int e;
        public int f;

        public b(Context context) {
            super(context, null);
            setOrientation(1);
            a(getResources().getString(bd0.vui_label_dialog));
        }

        @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            if (z) {
                eg0 eg0Var = eg0.this;
                StringBuilder a = jg.a("onLayout-w:");
                a.append(getWidth());
                a.append(",h:");
                a.append(getHeight());
                a.append(", mMaxHeight ");
                a.append(this.d);
                eg0Var.a(a.toString());
            }
        }

        @Override // android.widget.LinearLayout, android.view.View
        public void onMeasure(int i, int i2) {
            int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.e, 1073741824);
            int i3 = this.f;
            if (i3 <= 0) {
                int i4 = this.d;
                if (i4 > 0) {
                    super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i4, Integer.MIN_VALUE));
                    return;
                } else {
                    super.onMeasure(makeMeasureSpec, i2);
                    return;
                }
            }
            super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }

        @Override // android.view.View
        public void onWindowFocusChanged(boolean z) {
            ge0 ge0Var;
            ThemeViewModel themeViewModel;
            super.onWindowFocusChanged(z);
            eg0 eg0Var = eg0.this;
            eg0Var.a("hasWindowFocus " + z);
            fe0 fe0Var = this.c;
            if (fe0Var == null || (themeViewModel = (ge0Var = (ge0) fe0Var).b) == null) {
                return;
            }
            themeViewModel.onWindowFocusChanged(ge0Var.a, z);
        }
    }

    /* compiled from: XDialogViewDelegateImpl.java */
    /* renamed from: eg0$c */
    /* loaded from: classes.dex */
    public class c implements zf0.a {
        public TextView a;
        public int b;
        public String c;

        public c(TextView textView, int i) {
            this.a = textView;
            this.b = i;
            this.c = eg0.this.c().getString(bd0.x_countdown_tips);
        }
    }

    public eg0(bg0 bg0Var, Context context, int i) {
        super(bg0Var, context, i);
        this.u = new a();
        TypedArray obtainStyledAttributes = this.b.obtainStyledAttributes((AttributeSet) null, dd0.XDialog);
        int dimension = (int) obtainStyledAttributes.getDimension(dd0.XDialog_dialog_max_height, XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(dd0.XDialog_dialog_width, 0);
        int layoutDimension2 = obtainStyledAttributes.getLayoutDimension(dd0.XDialog_dialog_height, 0);
        obtainStyledAttributes.recycle();
        this.c = new b(this.b);
        b bVar = this.c;
        bVar.d = dimension;
        bVar.setMinimumHeight(this.b.getResources().getDimensionPixelSize(wc0.x_dialog_min_height));
        b bVar2 = this.c;
        bVar2.e = layoutDimension;
        bVar2.f = layoutDimension2;
        StringBuilder a2 = jg.a("maxHeight:", dimension, ",w:", layoutDimension, ", h ");
        a2.append(layoutDimension2);
        a(a2.toString());
        LayoutInflater.from(this.b).inflate(ad0.x_dialog, this.c);
        b bVar3 = this.c;
        this.d = (ViewGroup) bVar3.findViewById(yc0.x_dialog_title_layout);
        this.i = bVar3.findViewById(yc0.x_dialog_close);
        this.e = (TextView) bVar3.findViewById(yc0.x_dialog_title);
        this.f = (ViewGroup) bVar3.findViewById(yc0.x_dialog_content);
        this.g = (XButton) bVar3.findViewById(yc0.x_dialog_button1);
        this.h = (XButton) bVar3.findViewById(yc0.x_dialog_button2);
        this.j = bVar3.findViewById(yc0.x_dialog_has_buttons);
        this.i.setOnClickListener(this.u);
        this.g.setOnClickListener(this.u);
        this.h.setOnClickListener(this.u);
        this.c.addOnAttachStateChangeListener(new dg0(this));
    }

    @Override // defpackage.cg0
    public boolean a(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override // defpackage.cg0
    public void b(CharSequence charSequence) {
        this.g.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.g.setText(charSequence);
        e();
    }

    public final Context c() {
        return this.b;
    }

    public final void d() {
        if (this.k == null) {
            this.k = new ag0(this.b);
        }
        this.f.removeAllViews();
        this.f.addView(this.k);
    }

    public final void e() {
        if (this.g.getVisibility() != 0 && this.h.getVisibility() != 0) {
            this.j.setVisibility(8);
        } else {
            this.j.setVisibility(0);
        }
    }

    @Override // defpackage.cg0
    public void a(View view, boolean z) {
        this.f.removeAllViews();
        if (z) {
            if (this.l == null) {
                this.l = (XScrollView) LayoutInflater.from(this.b).inflate(ad0.x_dialog_scroll, this.f, false);
            }
            this.l.removeAllViews();
            this.f.addView(this.l);
            this.l.addView(view);
            return;
        }
        this.f.addView(view);
    }

    public final void b() {
        int[] iArr = {0, 20, 0, 0};
        ce0.a(this.g, this.c, iArr);
        ce0.a(this.h, this.c, iArr);
        int dimension = (int) this.i.getContext().getResources().getDimension(wc0.x_dialog_close_padding);
        ce0.a(this.i, this.c, new int[]{dimension, dimension, dimension, dimension});
    }

    public final void a(boolean z) {
        if (z) {
            int width = this.i.getWidth();
            int dimension = (int) this.b.getResources().getDimension(wc0.x_dialog_close_padding);
            ViewGroup.LayoutParams layoutParams = this.e.getLayoutParams();
            int i = layoutParams instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin : 0;
            int i2 = ((dimension * 2) + width) - i;
            this.e.setPadding(i2, 0, i2, 0);
            a(String.format("resetTitlePadding closeWidth: %s ,closeMargin: %s ,textMargin: %s ,padding: %s", Integer.valueOf(width), Integer.valueOf(dimension), Integer.valueOf(i), Integer.valueOf(i2)));
            return;
        }
        this.e.setPadding(0, 0, 0, 0);
    }

    @Override // defpackage.cg0
    public void a(CharSequence charSequence) {
        this.h.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
        this.h.setText(charSequence);
        e();
    }

    @Override // defpackage.cg0
    public void a() {
        try {
            CharSequence text = ((XTextView) this.c.findViewById(yc0.x_dialog_title)).getText();
            if (text != null) {
                String charSequence = text.toString();
                if (!TextUtils.isEmpty(charSequence)) {
                    String h = this.c.h();
                    if (TextUtils.isEmpty(h)) {
                        this.c.a(charSequence);
                    } else if (!h.contains(charSequence)) {
                        this.c.a(String.format("%s|%s", charSequence, h));
                    }
                }
            }
            XImageButton xImageButton = (XImageButton) this.c.findViewById(yc0.x_dialog_close);
            if (xImageButton != null) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(VuiConstants.PROPS_GENERALACT, VuiConstants.GENERALACT_CLOSE);
                jSONObject.put(VuiConstants.PROPS_VOICECONTROL, true);
                xImageButton.a(jSONObject);
            }
            XButton xButton = (XButton) this.c.findViewById(yc0.x_dialog_button1);
            if (xButton.getVisibility() == 0) {
                if (this.c.getContext().getString(bd0.vui_label_confirm).equals(xButton.getText().toString())) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put(VuiConstants.PROPS_GENERALACT, "System.Confirm");
                    xButton.a(jSONObject2);
                }
            } else {
                xButton.a(oc0.DISABLED);
            }
            XButton xButton2 = (XButton) this.c.findViewById(yc0.x_dialog_button2);
            if (xButton2.getVisibility() == 0) {
                if (this.c.getContext().getString(bd0.vui_label_cancel).equals(xButton2.getText().toString())) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put(VuiConstants.PROPS_GENERALACT, VuiConstants.GENERALACT_CANCEL);
                    xButton2.a(jSONObject3);
                    return;
                }
                return;
            }
            xButton2.a(oc0.DISABLED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(String str) {
        be0.c("xpui-XDialogView", str + "--hashcode " + this.a.hashCode());
    }
}
