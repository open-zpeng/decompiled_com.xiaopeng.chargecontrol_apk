package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import androidx.appcompat.widget.Toolbar;
import com.xiaopeng.xui.drawable.XToggleDrawable;
/* compiled from: ToolbarWidgetWrapper.java */
/* renamed from: p4  reason: default package */
/* loaded from: classes.dex */
public class p4 implements s3 {
    public Toolbar a;
    public int b;
    public View c;
    public View d;
    public Drawable e;
    public Drawable f;
    public Drawable g;
    public boolean h;
    public CharSequence i;
    public CharSequence j;
    public CharSequence k;
    public Window.Callback l;
    public boolean m;
    public p2 n;
    public int o;
    public int p;
    public Drawable q;

    /* compiled from: ToolbarWidgetWrapper.java */
    /* renamed from: p4$a */
    /* loaded from: classes.dex */
    public class a extends ha {
        public boolean a = false;
        public final /* synthetic */ int b;

        public a(int i) {
            this.b = i;
        }

        @Override // defpackage.ha, defpackage.ga
        public void a(View view) {
            this.a = true;
        }

        @Override // defpackage.ga
        public void b(View view) {
            if (this.a) {
                return;
            }
            p4.this.a.setVisibility(this.b);
        }

        @Override // defpackage.ha, defpackage.ga
        public void c(View view) {
            p4.this.a.setVisibility(0);
        }
    }

    public p4(Toolbar toolbar, boolean z) {
        int i;
        Drawable drawable;
        int i2 = g0.abc_action_bar_up_description;
        this.o = 0;
        this.p = 0;
        this.a = toolbar;
        this.i = toolbar.getTitle();
        this.j = toolbar.getSubtitle();
        this.h = this.i != null;
        this.g = toolbar.getNavigationIcon();
        n4 a2 = n4.a(toolbar.getContext(), null, i0.ActionBar, z.actionBarStyle, 0);
        this.q = a2.b(i0.ActionBar_homeAsUpIndicator);
        if (z) {
            CharSequence e = a2.e(i0.ActionBar_title);
            if (!TextUtils.isEmpty(e)) {
                this.h = true;
                a(e);
            }
            CharSequence e2 = a2.e(i0.ActionBar_subtitle);
            if (!TextUtils.isEmpty(e2)) {
                this.j = e2;
                if ((this.b & 8) != 0) {
                    this.a.setSubtitle(e2);
                }
            }
            Drawable b = a2.b(i0.ActionBar_logo);
            if (b != null) {
                a(b);
            }
            Drawable b2 = a2.b(i0.ActionBar_icon);
            if (b2 != null) {
                this.e = b2;
                f();
            }
            if (this.g == null && (drawable = this.q) != null) {
                this.g = drawable;
                e();
            }
            a(a2.c(i0.ActionBar_displayOptions, 0));
            int e3 = a2.e(i0.ActionBar_customNavigationLayout, 0);
            if (e3 != 0) {
                View inflate = LayoutInflater.from(this.a.getContext()).inflate(e3, (ViewGroup) this.a, false);
                View view = this.d;
                if (view != null && (this.b & 16) != 0) {
                    this.a.removeView(view);
                }
                this.d = inflate;
                if (inflate != null && (this.b & 16) != 0) {
                    this.a.addView(this.d);
                }
                a(this.b | 16);
            }
            int d = a2.d(i0.ActionBar_height, 0);
            if (d > 0) {
                ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
                layoutParams.height = d;
                this.a.setLayoutParams(layoutParams);
            }
            int a3 = a2.a(i0.ActionBar_contentInsetStart, -1);
            int a4 = a2.a(i0.ActionBar_contentInsetEnd, -1);
            if (a3 >= 0 || a4 >= 0) {
                this.a.a(Math.max(a3, 0), Math.max(a4, 0));
            }
            int e4 = a2.e(i0.ActionBar_titleTextStyle, 0);
            if (e4 != 0) {
                Toolbar toolbar2 = this.a;
                toolbar2.b(toolbar2.getContext(), e4);
            }
            int e5 = a2.e(i0.ActionBar_subtitleTextStyle, 0);
            if (e5 != 0) {
                Toolbar toolbar3 = this.a;
                toolbar3.a(toolbar3.getContext(), e5);
            }
            int e6 = a2.e(i0.ActionBar_popupTheme, 0);
            if (e6 != 0) {
                this.a.setPopupTheme(e6);
            }
        } else {
            if (this.a.getNavigationIcon() != null) {
                i = 15;
                this.q = this.a.getNavigationIcon();
            } else {
                i = 11;
            }
            this.b = i;
        }
        a2.b.recycle();
        if (i2 != this.p) {
            this.p = i2;
            if (TextUtils.isEmpty(this.a.getNavigationContentDescription())) {
                int i3 = this.p;
                this.k = i3 != 0 ? a().getString(i3) : null;
                d();
            }
        }
        this.k = this.a.getNavigationContentDescription();
        this.a.setNavigationOnClickListener(new o4(this));
    }

    public Context a() {
        return this.a.getContext();
    }

    public void a(boolean z) {
    }

    public void b(CharSequence charSequence) {
        if (this.h) {
            return;
        }
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void c() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public final void d() {
        if ((this.b & 4) != 0) {
            if (TextUtils.isEmpty(this.k)) {
                this.a.setNavigationContentDescription(this.p);
            } else {
                this.a.setNavigationContentDescription(this.k);
            }
        }
    }

    public final void e() {
        if ((this.b & 4) != 0) {
            Toolbar toolbar = this.a;
            Drawable drawable = this.g;
            if (drawable == null) {
                drawable = this.q;
            }
            toolbar.setNavigationIcon(drawable);
            return;
        }
        this.a.setNavigationIcon((Drawable) null);
    }

    public final void f() {
        Drawable drawable;
        int i = this.b;
        if ((i & 2) == 0) {
            drawable = null;
        } else if ((i & 1) != 0) {
            drawable = this.f;
            if (drawable == null) {
                drawable = this.e;
            }
        } else {
            drawable = this.e;
        }
        this.a.setLogo(drawable);
    }

    public final void a(CharSequence charSequence) {
        this.i = charSequence;
        if ((this.b & 8) != 0) {
            this.a.setTitle(charSequence);
        }
    }

    public void a(Drawable drawable) {
        this.f = drawable;
        f();
    }

    public void b() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void a(int i) {
        View view;
        int i2 = this.b ^ i;
        this.b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    d();
                }
                e();
            }
            if ((i2 & 3) != 0) {
                f();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.a.setTitle(this.i);
                    this.a.setSubtitle(this.j);
                } else {
                    this.a.setTitle((CharSequence) null);
                    this.a.setSubtitle((CharSequence) null);
                }
            }
            if ((i2 & 16) == 0 || (view = this.d) == null) {
                return;
            }
            if ((i & 16) != 0) {
                this.a.addView(view);
            } else {
                this.a.removeView(view);
            }
        }
    }

    public void a(g4 g4Var) {
        View view = this.c;
        if (view != null) {
            ViewParent parent = view.getParent();
            Toolbar toolbar = this.a;
            if (parent == toolbar) {
                toolbar.removeView(this.c);
            }
        }
        this.c = g4Var;
        if (g4Var == null || this.o != 2) {
            return;
        }
        this.a.addView(this.c, 0);
        Toolbar.e eVar = (Toolbar.e) this.c.getLayoutParams();
        ((ViewGroup.MarginLayoutParams) eVar).width = -2;
        ((ViewGroup.MarginLayoutParams) eVar).height = -2;
        eVar.a = 8388691;
        g4Var.setAllowCollapse(true);
    }

    public fa a(int i, long j) {
        fa a2 = y9.a(this.a);
        a2.a(i == 0 ? 1.0f : XToggleDrawable.LIGHT_RADIUS_DEFAULT);
        a2.a(j);
        a2.a(new a(i));
        return a2;
    }
}
