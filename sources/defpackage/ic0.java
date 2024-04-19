package defpackage;

import android.view.View;
import java.util.List;
/* compiled from: IVuiEngine.java */
/* renamed from: ic0  reason: default package */
/* loaded from: classes.dex */
public interface ic0 {
    void addVuiSceneListener(String str, View view, jc0 jc0Var);

    void addVuiSceneListener(String str, View view, jc0 jc0Var, gc0 gc0Var);

    void buildScene(String str, View view, List<Integer> list, hc0 hc0Var, String str2, jc0 jc0Var);

    void enterScene(String str, String str2);

    void exitScene(String str, String str2, jc0 jc0Var);

    void removeVuiSceneListener(String str, jc0 jc0Var);

    void updateElementAttribute(String str, View view);

    void updateScene(String str, View view);
}
