package com.xiaopeng.speech.vui.filter;

import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class FaultFilterChain implements IFilter {
    public List<IFilter> mFilters = new ArrayList();

    public FaultFilterChain addFilter(IFilter iFilter) {
        this.mFilters.add(iFilter);
        return this;
    }

    @Override // com.xiaopeng.speech.vui.filter.IFilter
    public sc0 doFilter(sc0 sc0Var) {
        for (IFilter iFilter : this.mFilters) {
            sc0Var = iFilter.doFilter(sc0Var);
        }
        return sc0Var;
    }
}
