package com.xiaopeng.lib.framework.moduleinterface.demoservice;
/* loaded from: classes.dex */
public interface IDemoService {

    /* loaded from: classes.dex */
    public static class DemoMessageEvent {
        public String mEvent;
        public long mParam1;
        public String mParam2;
    }

    void fireMessageEventInMainThread();

    void fireMessageEventInWorkThread();

    void getPage(String URL, ICallback callback);

    ah0<String> getPageObservable(String URL);

    String getWelcomeMessage();
}
