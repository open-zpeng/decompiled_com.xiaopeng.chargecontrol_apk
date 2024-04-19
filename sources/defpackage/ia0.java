package defpackage;

import android.os.Bundle;
import android.view.View;
import defpackage.i10;
import java.util.Collections;
import java.util.List;
/* compiled from: VuiFragment.java */
/* renamed from: ia0  reason: default package */
/* loaded from: classes.dex */
public abstract class ia0<V, P extends i10<V>> extends z00<V, P> implements jc0, ka0 {
    @Override // defpackage.z00, androidx.fragment.app.Fragment
    public void Q0() {
        super.Q0();
        z90.b().removeVuiSceneListener(getSceneId());
    }

    @Override // androidx.fragment.app.Fragment
    public void X0() {
        super.X0();
        if (isMainScene()) {
            z90.b().exitScene(getSceneId());
        }
    }

    public boolean b(View view, tc0 tc0Var) {
        if (view != null) {
            z90.a(view, 0);
        }
        return false;
    }

    @Override // defpackage.jc0
    public void c(View view, tc0 tc0Var) {
    }

    @Override // androidx.fragment.app.Fragment
    public void c1() {
        super.c1();
        if (isMainScene()) {
            z90.b().enterScene(getSceneId());
        }
    }

    public List<String> getSubSceneList() {
        return Collections.emptyList();
    }

    public boolean isMainScene() {
        return true;
    }

    @Override // defpackage.jc0
    public void onBuildScene() {
        z90.b().buildScene(getSceneId(), w(), getSubSceneList(), isMainScene());
        z90.a(this);
    }

    @Override // defpackage.ka0
    public List<View> w() {
        return Collections.singletonList(w0());
    }

    @Override // defpackage.z00
    public void b(View view, Bundle bundle) {
        super.b(view, bundle);
        z90.b().addVuiSceneListener(getSceneId(), view, this);
    }
}
