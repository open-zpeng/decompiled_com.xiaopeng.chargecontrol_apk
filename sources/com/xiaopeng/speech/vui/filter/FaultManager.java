package com.xiaopeng.speech.vui.filter;
/* loaded from: classes.dex */
public class FaultManager {
    public static volatile FaultManager faultManager;
    public FaultFilterChain mFaultChain = new FaultFilterChain();

    public FaultManager() {
        init();
    }

    public static FaultManager getInstance() {
        if (faultManager == null) {
            synchronized (FaultManager.class) {
                if (faultManager == null) {
                    faultManager = new FaultManager();
                }
            }
        }
        return faultManager;
    }

    private void init() {
        this.mFaultChain.addFilter(new ListClickEventFaultFilter());
    }

    public void addFilter(IFilter iFilter) {
        if (iFilter != null) {
            this.mFaultChain.addFilter(iFilter);
        }
    }

    public void removeAllFilter() {
        this.mFaultChain.mFilters.clear();
    }

    public void removeFilter(IFilter iFilter) {
        this.mFaultChain.mFilters.remove(iFilter);
    }

    public sc0 startFault(sc0 sc0Var) {
        return this.mFaultChain.doFilter(sc0Var);
    }
}
