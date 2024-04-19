package defpackage;

import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;
/* compiled from: VuiView.java */
/* renamed from: re0  reason: default package */
/* loaded from: classes.dex */
public interface re0 extends ec0 {
    public static final SparseArray<a> b = new SparseArray<>();

    /* compiled from: VuiView.java */
    /* renamed from: re0$a */
    /* loaded from: classes.dex */
    public static class a {
        public String a;
        public String c;
        public String d;
        public String e;
        public boolean f;
        public String h;
        public String j;
        public boolean l;
        public boolean n;
        public Object p;
        public volatile WeakReference<gc0> q;
        public int r;
        public boolean s = false;
        public mc0 b = z90.a(-1);
        public Integer k = -1;
        public oc0 g = oc0.NORMAL;
        public boolean o = false;
        public pc0 i = z90.b(2);
        public JSONObject m = null;
    }

    default void a(View view, AttributeSet attributeSet) {
        oc0 oc0Var;
        if (!z90.b || view == null || attributeSet == null) {
            return;
        }
        a aVar = new a();
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, dd0.vui);
        aVar.a = obtainStyledAttributes.getString(dd0.vui_vuiAction);
        aVar.b = z90.a(obtainStyledAttributes.getInteger(dd0.vui_vuiElementType, -1));
        if (aVar.b == mc0.UNKNOWN) {
            aVar.b = cf0.a(view);
        }
        aVar.k = Integer.valueOf(obtainStyledAttributes.getInteger(dd0.vui_vuiPosition, -1));
        aVar.c = obtainStyledAttributes.getString(dd0.vui_vuiFatherElementId);
        aVar.d = obtainStyledAttributes.getString(dd0.vui_vuiLabel);
        aVar.j = obtainStyledAttributes.getString(dd0.vui_vuiFatherLabel);
        aVar.e = obtainStyledAttributes.getString(dd0.vui_vuiElementId);
        aVar.f = obtainStyledAttributes.getBoolean(dd0.vui_vuiLayoutLoadable, false);
        int integer = obtainStyledAttributes.getInteger(dd0.vui_vuiMode, 4);
        if (integer == 1) {
            oc0Var = oc0.DISABLED;
        } else if (integer == 2) {
            oc0Var = oc0.SILENT;
        } else if (integer != 3) {
            oc0Var = oc0.NORMAL;
        } else {
            oc0Var = oc0.UNDERSTOOD;
        }
        aVar.g = oc0Var;
        aVar.h = obtainStyledAttributes.getString(dd0.vui_vuiBizId);
        aVar.i = z90.b(obtainStyledAttributes.getInt(dd0.vui_vuiPriority, 2));
        int integer2 = obtainStyledAttributes.getInteger(dd0.vui_vuiFeedbackType, 1);
        if (integer2 == 1) {
            nc0 nc0Var = nc0.SOUND;
        } else if (integer2 != 2) {
            nc0 nc0Var2 = nc0.SOUND;
        } else {
            nc0 nc0Var3 = nc0.TTS;
        }
        aVar.n = obtainStyledAttributes.getBoolean(dd0.vui_vuiDisableHitEffect, false);
        aVar.o = obtainStyledAttributes.getBoolean(dd0.vui_vuiEnableViewVuiMode, false);
        obtainStyledAttributes.recycle();
        aVar.r = view.getVisibility();
        aVar.s = view.isSelected();
        synchronized (b) {
            b.put(hashCode(), aVar);
        }
    }

    @Override // defpackage.ec0
    default String b() {
        return s().j;
    }

    @Override // defpackage.ec0
    default void c(String str) {
        s().a = str;
    }

    @Override // defpackage.ec0
    default gc0 d() {
        a s = s();
        if (s.q != null) {
            synchronized (b) {
                if (s.q != null) {
                    return s.q.get();
                }
                return null;
            }
        }
        return null;
    }

    @Override // defpackage.ec0
    default pc0 e() {
        return s().i;
    }

    @Override // defpackage.ec0
    default boolean f() {
        return s().f;
    }

    @Override // defpackage.ec0
    default String g() {
        return s().e;
    }

    @Override // defpackage.ec0
    default String h() {
        return s().d;
    }

    @Override // defpackage.ec0
    default boolean i() {
        return s().l;
    }

    @Override // defpackage.ec0
    default int j() {
        return s().k.intValue();
    }

    @Override // defpackage.ec0
    default oc0 k() {
        return s().g;
    }

    @Override // defpackage.ec0
    default String l() {
        return s().h;
    }

    @Override // defpackage.ec0
    default boolean m() {
        return s().o;
    }

    @Override // defpackage.ec0
    default Object n() {
        return s().p;
    }

    @Override // defpackage.ec0
    default String o() {
        return s().a;
    }

    @Override // defpackage.ec0
    default JSONObject p() {
        return s().m;
    }

    @Override // defpackage.ec0
    default String q() {
        return s().c;
    }

    default void r() {
        synchronized (b) {
            b.remove(hashCode());
        }
    }

    default a s() {
        a aVar;
        synchronized (b) {
            aVar = b.get(hashCode());
        }
        if (aVar == null) {
            d("xAttr is null");
            aVar = new a();
            if (aVar.b == mc0.UNKNOWN) {
                aVar.b = cf0.a(this);
            }
            synchronized (b) {
                b.put(hashCode(), aVar);
            }
        }
        return aVar;
    }

    @Override // defpackage.ec0
    default void b(String str) {
        s().e = str;
    }

    @Override // defpackage.ec0
    default mc0 c() {
        return s().b;
    }

    @Override // defpackage.ec0
    default void b(boolean z) {
        s().l = z;
    }

    default void d(String str) {
        Object[] objArr = {getClass().getSimpleName(), str, Integer.valueOf(hashCode())};
        if (be0.a(3)) {
            be0.a(3, "xpui", String.format("%s %s hashCode:%s", objArr), null, false);
        }
    }

    @Override // defpackage.ec0
    default void a(boolean z) {
        s().f = z;
    }

    @Override // defpackage.ec0
    default void a(pc0 pc0Var) {
        s().i = pc0Var;
    }

    @Override // defpackage.ec0
    default void a(mc0 mc0Var) {
        s().b = mc0Var;
    }

    @Override // defpackage.ec0
    default void a(String str) {
        s().d = str;
        if (f() && (this instanceof View)) {
            a((View) this);
        }
    }

    @Override // defpackage.ec0
    default void a(int i) {
        s().k = Integer.valueOf(i);
    }

    @Override // defpackage.ec0
    default void a(JSONObject jSONObject) {
        s().m = jSONObject;
    }

    default void a(oc0 oc0Var) {
        s().g = oc0Var;
    }

    @Override // defpackage.ec0
    default boolean a() {
        a s = s();
        if (s.n || !(lc0.SCROLLBYY.c.equals(s.a) || lc0.SCROLLBYX.c.equals(s.a))) {
            return s.n;
        }
        return true;
    }

    @Override // defpackage.ec0
    default void a(Object obj) {
        s().p = obj;
    }

    @Override // defpackage.ec0
    default void a(Object obj, View view) {
        s().p = obj;
        if (!mc0.STATEFULBUTTON.c.equals(c().c) || view == null) {
            return;
        }
        a(view);
    }

    @Override // defpackage.ec0
    default void a(gc0 gc0Var) {
        s().q = new WeakReference<>(gc0Var);
    }

    default void a(View view, int i) {
        a s = s();
        if (s.r != i) {
            if (be0.a(2)) {
                StringBuilder a2 = jg.a("setVuiVisibility; xAttr.mVuiVisibility : ");
                a2.append(ee0.a(s.r));
                a2.append(",visibility ");
                a2.append(ee0.a(i));
                d(a2.toString());
            }
            s.r = i;
            try {
                JSONObject p = p();
                if (p != null && p.has(VuiConstants.PROPS_VOICECONTROL)) {
                    if (p.getBoolean(VuiConstants.PROPS_VOICECONTROL)) {
                        return;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            a(view);
        }
    }

    default void a(View view, boolean z) {
        a s = s();
        if (s.s != z) {
            s.s = z;
            String str = c().c;
            if (mc0.CHECKBOX.c.equals(str) || mc0.SWITCH.c.equals(str) || mc0.RADIOBUTTON.c.equals(str)) {
                a(view);
            }
        }
    }

    default void a(View view) {
        a(view, qc0.UPDATE_VIEW_ATTRIBUTE);
    }

    default void a(View view, qc0 qc0Var) {
        gc0 d = d();
        if (d != null) {
            cf0.a(d, view, qc0Var);
        } else if (be0.a(2)) {
            d("listener is null");
        }
    }
}
