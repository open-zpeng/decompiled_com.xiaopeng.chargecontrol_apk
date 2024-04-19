package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.xiaopeng.libtheme.ThemeViewModel;
import defpackage.eg0;
/* compiled from: XDialog.java */
/* renamed from: ld0  reason: default package */
/* loaded from: classes.dex */
public class ld0 implements pe0 {
    public static int m;
    public Context c;
    public bg0 d;
    public Dialog e;
    public int f;
    public hg0 g;
    public hg0 h;
    public md0 i;
    public md0 j;
    public DialogInterface.OnKeyListener k;
    public int l;

    /* compiled from: XDialog.java */
    /* renamed from: ld0$a */
    /* loaded from: classes.dex */
    public static class a {
        public int a;
        public boolean b = false;

        public static a a() {
            return new a();
        }
    }

    public ld0(Context context, int i, a aVar) {
        ThemeViewModel themeViewModel;
        Dialog dialog;
        this.d = new bg0(context, i);
        this.c = context;
        aVar = aVar == null ? new a() : aVar;
        int i2 = aVar.a;
        if (i2 != 0) {
            this.e = new Dialog(context, i2);
        } else {
            this.e = new Dialog(context, cd0.XAppTheme_XDialog);
        }
        if (aVar.b && (dialog = this.e) != null && dialog.getWindow() != null) {
            dialog.getWindow().requestFeature(15);
        }
        this.e.setContentView(this.d.b());
        this.f = (int) this.c.getResources().getDimension(wc0.x_dialog_system_offset_y);
        bg0 bg0Var = this.d;
        ((eg0) bg0Var.m).o = new kg0() { // from class: fd0
            @Override // defpackage.kg0
            public final void a(bg0 bg0Var2) {
                ld0.this.a(bg0Var2);
            }
        };
        ThemeViewModel.OnCallback onCallback = new ThemeViewModel.OnCallback() { // from class: id0
            @Override // com.xiaopeng.libtheme.ThemeViewModel.OnCallback
            public final void onThemeChanged() {
                ld0.this.d();
            }
        };
        fe0 fe0Var = ((eg0) bg0Var.m).c.c;
        if (fe0Var != null && (themeViewModel = ((ge0) fe0Var).b) != null) {
            themeViewModel.setCallback(onCallback);
        }
        this.d.n = new kd0(this);
        this.e.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: hd0
            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i3, KeyEvent keyEvent) {
                return ld0.this.a(dialogInterface, i3, keyEvent);
            }
        });
        TypedArray obtainStyledAttributes = this.e.getContext().obtainStyledAttributes(new int[]{16842836});
        this.l = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        m++;
    }

    public /* synthetic */ void a(bg0 bg0Var) {
        a();
    }

    public /* synthetic */ void b(bg0 bg0Var, int i) {
        md0 md0Var = this.i;
        if (md0Var != null) {
            md0Var.a(this, i);
        }
    }

    public ld0 c(int i) {
        if (this.e.getWindow() != null) {
            this.e.getWindow().setType(i);
        }
        return this;
    }

    public /* synthetic */ void d() {
        StringBuilder a2 = jg.a("onThemeChanged, mWindowBackgroundId ");
        a2.append(this.l);
        a(a2.toString());
        if (this.l == 0) {
            this.l = xc0.x_bg_dialog;
        }
        if (this.e.getWindow() == null || this.l <= 0) {
            return;
        }
        this.e.getWindow().setBackgroundDrawableResource(this.l);
    }

    public void e() {
        a(0, 0);
    }

    public void finalize() {
        super.finalize();
        m--;
        StringBuilder a2 = jg.a(" finalize object size ");
        a2.append(m);
        a(a2.toString());
    }

    public /* synthetic */ boolean a(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        DialogInterface.OnKeyListener onKeyListener = this.k;
        if (onKeyListener != null && onKeyListener.onKey(dialogInterface, i, keyEvent)) {
            a("custom key listener return true  keyCode : " + i + ", event " + keyEvent.getAction());
            return true;
        }
        this.d.m.a(i, keyEvent);
        return false;
    }

    public ViewGroup b() {
        return this.d.b();
    }

    public int c() {
        Dialog dialog = this.e;
        int i = 0;
        if (dialog == null) {
            return 0;
        }
        try {
            i = ((Integer) Dialog.class.getDeclaredMethod("getScreenId", new Class[0]).invoke(dialog, new Object[0])).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        a("getVuiDisplayLocation   value:  " + i);
        return i;
    }

    @Deprecated
    public ld0 b(boolean z) {
        ((eg0) this.d.m).d.setVisibility(z ? 0 : 8);
        return this;
    }

    public /* synthetic */ void a(bg0 bg0Var, int i) {
        md0 md0Var = this.j;
        if (md0Var != null) {
            md0Var.a(this, i);
        }
    }

    public ld0 d(int i) {
        ((eg0) this.d.m).e.setText(i);
        return this;
    }

    public ld0 b(int i) {
        eg0 eg0Var = (eg0) this.d.m;
        if (i == 0) {
            eg0Var.b(null);
        } else {
            eg0Var.b(eg0Var.b.getText(i));
        }
        return this;
    }

    public ld0 a(int i, boolean z) {
        eg0 eg0Var = (eg0) this.d.m;
        eg0Var.a(LayoutInflater.from(eg0Var.c()).inflate(i, eg0Var.f, false), z);
        return this;
    }

    public ld0 b(CharSequence charSequence) {
        this.d.m.b(charSequence);
        return this;
    }

    public ld0 a(boolean z) {
        eg0 eg0Var = (eg0) this.d.m;
        eg0Var.i.setVisibility(z ? 0 : 4);
        if (eg0Var.i.getWidth() > 0) {
            eg0Var.a(z);
        } else {
            eg0Var.i.getViewTreeObserver().addOnPreDrawListener(new fg0(eg0Var, z));
        }
        return this;
    }

    public void a(ThemeViewModel.OnCallback onCallback) {
        ThemeViewModel themeViewModel;
        fe0 fe0Var = ((eg0) this.d.m).c.c;
        if (fe0Var == null || (themeViewModel = ((ge0) fe0Var).b) == null) {
            return;
        }
        themeViewModel.setCallback(onCallback);
    }

    public ld0 a(md0 md0Var) {
        this.i = md0Var;
        if (md0Var != null && this.g == null) {
            this.g = new hg0() { // from class: ed0
                @Override // defpackage.hg0
                public final void a(bg0 bg0Var, int i) {
                    ld0.this.b(bg0Var, i);
                }
            };
        }
        ((eg0) this.d.m).p = this.g;
        return this;
    }

    public ld0 a(int i, md0 md0Var) {
        b(i);
        a(md0Var);
        return this;
    }

    public ld0 a(int i) {
        eg0 eg0Var = (eg0) this.d.m;
        if (i == 0) {
            eg0Var.a((CharSequence) null);
        } else {
            eg0Var.a(eg0Var.b.getText(i));
        }
        return this;
    }

    public ld0 a(CharSequence charSequence) {
        this.d.m.a(charSequence);
        return this;
    }

    public void a(int i, int i2) {
        a("show");
        if (i > 0 && i2 == 0) {
            eg0 eg0Var = (eg0) this.d.m;
            zf0 zf0Var = eg0Var.t;
            if (zf0Var != null) {
                zf0Var.a();
            }
            if (eg0Var.g.getVisibility() == 0 && i > 0) {
                eg0Var.t = new zf0(new eg0.c(eg0Var.g, -1));
                eg0Var.t.a(eg0Var.g.getText().toString(), i);
            }
        }
        if (i2 > 0 && i == 0) {
            eg0 eg0Var2 = (eg0) this.d.m;
            zf0 zf0Var2 = eg0Var2.t;
            if (zf0Var2 != null) {
                zf0Var2.a();
            }
            if (eg0Var2.h.getVisibility() == 0 && i2 > 0) {
                eg0Var2.t = new zf0(new eg0.c(eg0Var2.h, -2));
                eg0Var2.t.a(eg0Var2.h.getText().toString(), i2);
            }
        }
        if (this.e.getWindow() != null) {
            WindowManager.LayoutParams attributes = this.e.getWindow().getAttributes();
            attributes.gravity = 17;
            attributes.y = attributes.type != 9 ? this.f : 0;
            this.e.getWindow().setAttributes(attributes);
        }
        this.e.show();
    }

    public void a() {
        a("dismiss");
        this.e.dismiss();
    }

    public void a(hc0 hc0Var) {
        this.d.e = hc0Var;
    }

    public void a(String str, ic0 ic0Var) {
        bg0 bg0Var = this.d;
        bg0Var.d = str;
        bg0Var.c = ic0Var;
        bg0Var.l = true;
    }

    public final void a(String str) {
        be0.c("XDialog", str + "--hashcode " + hashCode());
    }
}
