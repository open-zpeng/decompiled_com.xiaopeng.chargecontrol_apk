package defpackage;

import android.os.Bundle;
import android.view.View;
import java.util.Collections;
import java.util.List;
/* compiled from: VuiPanelActivity.java */
/* renamed from: ja0  reason: default package */
/* loaded from: classes.dex */
public abstract class ja0 extends a10 implements jc0, ka0 {
    public boolean b(View view, tc0 tc0Var) {
        if (view != null) {
            z90.a(view, 0);
        }
        return false;
    }

    @Override // defpackage.jc0
    public void c(View view, tc0 tc0Var) {
    }

    public boolean isMainScene() {
        return true;
    }

    @Override // defpackage.jc0
    public void onBuildScene() {
        z90.b().buildScene(getSceneId(), w(), isMainScene());
        z90.a((ka0) this);
    }

    @Override // defpackage.a10, defpackage.nd0, defpackage.bc, androidx.activity.ComponentActivity, defpackage.g7, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        z90.b().addVuiSceneListener(getSceneId(), findViewById(16908290), this);
    }

    @Override // defpackage.a10, defpackage.t0, defpackage.bc, android.app.Activity
    public void onDestroy() {
        z90.b().removeVuiSceneListener(getSceneId());
        super.onDestroy();
    }

    @Override // defpackage.a10, defpackage.nd0, defpackage.bc, android.app.Activity
    public void onPause() {
        super.onPause();
        if (isMainScene()) {
            z90.b().exitScene(getSceneId());
        }
    }

    @Override // defpackage.a10, defpackage.nd0, defpackage.bc, android.app.Activity
    public void onResume() {
        super.onResume();
        if (isMainScene()) {
            z90.b().enterScene(getSceneId());
        }
    }

    public List<View> w() {
        return Collections.singletonList(findViewById(16908290));
    }
}
