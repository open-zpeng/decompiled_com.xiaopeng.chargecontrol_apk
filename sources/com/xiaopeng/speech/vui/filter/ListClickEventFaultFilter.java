package com.xiaopeng.speech.vui.filter;

import android.text.TextUtils;
import java.util.Arrays;
/* loaded from: classes.dex */
public class ListClickEventFaultFilter extends BaseFaultFilter {
    @Override // com.xiaopeng.speech.vui.filter.IFilter
    public sc0 doFilter(sc0 sc0Var) {
        String[] split;
        if (sc0Var != null && !TextUtils.isEmpty(sc0Var.getId()) && sc0Var.getResultActions().contains("Click") && (split = sc0Var.getId().split("_")) != null && split.length > 0) {
            for (String str : split) {
                if (str.length() <= 4) {
                    sc0Var.setResultActions(Arrays.asList("listItemClick"));
                }
            }
        }
        return sc0Var;
    }
}
