package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.xiaopeng.speech.vui.VuiEngine;
import com.xiaopeng.xui.widget.XRecyclerView;
import com.xiaopeng.xui.widget.XTextView;
import com.xiaopeng.xui.widget.XTitleBarLight;
import defpackage.b50;
import defpackage.nf;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* compiled from: HelpDialog.java */
/* renamed from: b50  reason: default package */
/* loaded from: classes.dex */
public class b50 extends m10 {
    public static final List<String> v0 = new ArrayList();
    public static final List<x40> w0 = new ArrayList();
    public XRecyclerView r0;
    public d s0;
    public ViewGroup t0;
    public int u0 = -1;

    /* compiled from: HelpDialog.java */
    /* renamed from: b50$a */
    /* loaded from: classes.dex */
    public class a extends e10 {
        public a(b50 b50Var, Context context, int i) {
            super(context, i);
        }

        @Override // defpackage.ld0
        public void a(int i, int i2) {
            super.a(i, i2);
            WindowManager.LayoutParams attributes = this.e.getWindow().getAttributes();
            attributes.width = f().getDimensionPixelSize(m90.help_dialog_width);
            attributes.height = f().getDimensionPixelSize(m90.help_dialog_height);
            attributes.y = f().getDimensionPixelSize(m90.panel_dialog_margin_top);
            attributes.x = f().getDimensionPixelSize(m90.panel_dialog_margin_start);
            attributes.gravity = 17;
            this.e.getWindow().setAttributes(attributes);
        }
    }

    /* compiled from: HelpDialog.java */
    /* renamed from: b50$b */
    /* loaded from: classes.dex */
    public class b implements XTitleBarLight.a {
        public b() {
        }

        public void a() {
        }
    }

    /* compiled from: HelpDialog.java */
    /* renamed from: b50$c */
    /* loaded from: classes.dex */
    public static class c extends nf.c0 {
        public XTextView u;

        public c(View view) {
            super(view);
            this.u = (XTextView) view.findViewById(o90.tab);
        }
    }

    static {
        a("tab_usage_normal", new d50());
        a("tab_usage_low_temp", new e50());
        a("tab_battery_keep_temp", new y40());
        a("tab_mileage_mode", new c50());
        a("tab_battery_temp_control", new z40());
    }

    public static void a(String str, x40 x40Var) {
        if (x40Var.d()) {
            v0.add(str);
            w0.add(x40Var);
        }
    }

    public static b50 f(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("tab", str);
        b50 b50Var = new b50();
        b50Var.k(bundle);
        return b50Var;
    }

    public void e(String str) {
        j(v0.indexOf(str));
    }

    public final void j(int i) {
        x40 x40Var;
        if (i < 0 || this.u0 == i || (x40Var = w0.get(i)) == null) {
            return;
        }
        this.u0 = i;
        d dVar = this.s0;
        dVar.g = i;
        nf nfVar = dVar.e;
        if (nfVar != null) {
            nfVar.g(dVar.g);
        }
        dVar.a.a();
        this.t0.removeAllViews();
        x40Var.a(e0(), this.t0);
    }

    @Override // defpackage.m10
    public e10 l(Bundle bundle) {
        a aVar = new a(this, s1(), s90.HelpDialogStyle);
        aVar.b("HelpDialog");
        e10 a2 = aVar.a(q90.dialog_help, false);
        a2.f(2008);
        return a2.b(false);
    }

    /* compiled from: HelpDialog.java */
    /* renamed from: b50$d */
    /* loaded from: classes.dex */
    public static class d extends nf.f<c> {
        public List<x40> d;
        public nf e;
        public a f;
        public int g = -1;
        public View.OnClickListener h = new View.OnClickListener() { // from class: w40
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b50.d.this.a(view);
            }
        };

        /* compiled from: HelpDialog.java */
        /* renamed from: b50$d$a */
        /* loaded from: classes.dex */
        public interface a {
            void a(View view, int i);
        }

        public d(List<x40> list) {
            this.d = list;
        }

        public /* synthetic */ void a(View view) {
            a aVar;
            int f = this.e.f(view);
            if (f == -1 || (aVar = this.f) == null) {
                return;
            }
            aVar.a(view, f);
        }

        @Override // defpackage.nf.f
        public void b(nf nfVar) {
            super.b(nfVar);
            this.e = null;
        }

        @Override // defpackage.nf.f
        public void a(nf nfVar) {
            super.a(nfVar);
            this.e = nfVar;
        }

        @Override // defpackage.nf.f
        public int a() {
            return this.d.size();
        }
    }

    public /* synthetic */ void a(View view, int i) {
        j(i);
    }

    @Override // androidx.fragment.app.Fragment
    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        iv.a("P00001", "B007");
        ((XTitleBarLight) h(o90.title_bar)).setOnTitleBarClickListener(new b());
        this.t0 = (ViewGroup) h(o90.content_container);
        this.r0 = (XRecyclerView) h(o90.tabs);
        this.r0.a("HelpDialog", VuiEngine.getInstance(U()));
        this.s0 = new d(Collections.unmodifiableList(w0));
        d dVar = this.s0;
        dVar.f = new d.a() { // from class: v40
            @Override // defpackage.b50.d.a
            public final void a(View view, int i) {
                b50.this.a(view, i);
            }
        };
        this.r0.setAdapter(dVar);
        j(S() != null ? Math.max(v0.indexOf(S().getString("tab")), 0) : 0);
        return null;
    }
}
