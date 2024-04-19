package defpackage;

import android.content.res.Configuration;
import android.util.AttributeSet;
import android.view.View;
import com.xiaopeng.libtheme.ThemeViewModel;
import java.util.ArrayList;
import java.util.Iterator;
/* compiled from: XViewDelegateImpl.java */
/* renamed from: ge0  reason: default package */
/* loaded from: classes.dex */
public class ge0 extends fe0 {
    public View a;
    public ThemeViewModel b;
    public je0 c;
    public ArrayList<ie0> d = new ArrayList<>();

    public ge0(View view, AttributeSet attributeSet, int i, int i2, Object obj) {
        this.a = view;
        if (view.isInEditMode()) {
            return;
        }
        this.b = ThemeViewModel.create(view.getContext(), attributeSet, i, i2, obj);
    }

    @Override // defpackage.fe0
    public void a(Configuration configuration) {
        Iterator<ie0> it = this.d.iterator();
        while (it.hasNext()) {
            ((he0) it.next()).a(configuration);
        }
        ThemeViewModel themeViewModel = this.b;
        if (themeViewModel != null) {
            themeViewModel.onConfigurationChanged(this.a, configuration);
        }
        je0 je0Var = this.c;
        if (je0Var != null) {
            je0Var.a(configuration);
        }
    }

    @Override // defpackage.fe0
    public void b() {
        Iterator<ie0> it = this.d.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
        ThemeViewModel themeViewModel = this.b;
        if (themeViewModel != null) {
            themeViewModel.onDetachedFromWindow(this.a);
        }
    }

    @Override // defpackage.fe0
    public void a() {
        Iterator<ie0> it = this.d.iterator();
        while (it.hasNext()) {
            he0 he0Var = (he0) it.next();
            he0Var.a(he0Var.a.getResources().getConfiguration());
        }
        ThemeViewModel themeViewModel = this.b;
        if (themeViewModel != null) {
            themeViewModel.onAttachedToWindow(this.a);
        }
        je0 je0Var = this.c;
        if (je0Var != null) {
            je0Var.a(je0Var.a.getResources().getConfiguration());
        }
    }
}
