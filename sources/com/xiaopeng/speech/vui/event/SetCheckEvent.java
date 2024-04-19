package com.xiaopeng.speech.vui.event;

import android.view.View;
import android.widget.Checkable;
import android.widget.CompoundButton;
import com.xiaopeng.speech.vui.utils.LogUtils;
import java.util.Map;
/* loaded from: classes.dex */
public class SetCheckEvent extends BaseEvent {
    private <T> T getSetCheck(sc0 sc0Var) {
        Map map;
        if (sc0Var != null && sc0Var.getResultActions() != null && !sc0Var.getResultActions().isEmpty()) {
            Object obj = (String) sc0Var.getResultActions().get(0);
            if ((sc0Var.getValues() instanceof bw) && (map = (Map) sc0Var.getValues()) != null) {
                if (map.get(obj) instanceof bw) {
                    Map map2 = (Map) map.get(obj);
                    if (map2 == null || map2.get("value") == null) {
                        return null;
                    }
                    return (T) map2.get("value");
                } else if (map.get(map) != null) {
                    return (T) map.get("value");
                }
            }
        }
        return null;
    }

    @Override // com.xiaopeng.speech.vui.event.IVuiEvent
    public <T extends View> T run(T t, sc0 sc0Var) {
        Boolean bool;
        if (t == null) {
            return null;
        }
        if (sc0Var != null && sc0Var.getResultActions() != null && !sc0Var.getResultActions().isEmpty() && (bool = (Boolean) getSetCheck(sc0Var)) != null) {
            if (t instanceof CompoundButton) {
                CompoundButton compoundButton = (CompoundButton) t;
                if ((!bool.booleanValue()) == compoundButton.isChecked()) {
                    LogUtils.d("SetCheckEvent run on CompoundButton");
                    boolean z = t instanceof ec0;
                    if (z) {
                        ((ec0) t).b(true);
                    }
                    compoundButton.setChecked(bool.booleanValue());
                    if (z) {
                        ((ec0) t).b(false);
                    }
                }
            } else if (t instanceof Checkable) {
                if ((!bool.booleanValue()) == ((Checkable) t).isChecked()) {
                    LogUtils.d("SetCheckEvent run on Checkable view");
                    boolean z2 = t instanceof ec0;
                    if (z2) {
                        ((ec0) t).b(true);
                    }
                    t.performClick();
                    if (z2) {
                        ((ec0) t).b(false);
                    }
                }
            } else if ((!bool.booleanValue()) == t.isSelected()) {
                LogUtils.d("SetCheckEvent run on setSelected view");
                boolean z3 = t instanceof ec0;
                if (z3) {
                    ((ec0) t).b(true);
                }
                t.performClick();
                if (z3) {
                    ((ec0) t).b(false);
                }
            }
        }
        return t;
    }
}
