package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
/* compiled from: ContextThemeWrapper.java */
/* renamed from: n1  reason: default package */
/* loaded from: classes.dex */
public class n1 extends ContextWrapper {
    public int a;
    public Resources.Theme b;
    public LayoutInflater c;
    public Configuration d;
    public Resources e;

    public n1() {
        super(null);
    }

    public void a(Configuration configuration) {
        if (this.e == null) {
            if (this.d == null) {
                this.d = new Configuration(configuration);
                return;
            }
            throw new IllegalStateException("Override configuration has already been set");
        }
        throw new IllegalStateException("getResources() or getAssets() has already been called");
    }

    @Override // android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return getResources().getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (this.e == null) {
            Configuration configuration = this.d;
            if (configuration == null) {
                this.e = super.getResources();
            } else {
                int i = Build.VERSION.SDK_INT;
                this.e = createConfigurationContext(configuration).getResources();
            }
        }
        return this.e;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.c == null) {
                this.c = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            }
            return this.c;
        }
        return getBaseContext().getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.b;
        if (theme != null) {
            return theme;
        }
        if (this.a == 0) {
            this.a = h0.Theme_AppCompat_Light;
        }
        a();
        return this.b;
    }

    public int getThemeResId() {
        return this.a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i) {
        if (this.a != i) {
            this.a = i;
            a();
        }
    }

    public n1(Context context, int i) {
        super(context);
        this.a = i;
    }

    public n1(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    public final void a() {
        if (this.b == null) {
            this.b = getResources().newTheme();
            Resources.Theme theme = getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.b.applyStyle(this.a, true);
    }
}
