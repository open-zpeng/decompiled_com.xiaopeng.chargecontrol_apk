package com.xiaopeng.lib.framework.moduleinterface.netchannelmodule.messaging;

import android.app.Application;
/* loaded from: classes.dex */
public interface IMessaging {
    public static final long DEFAULT_MESSAGE_ID = 0;

    /* loaded from: classes.dex */
    public enum CHANNEL {
        COMMUNICATION,
        REPORTING,
        TESTING
    }

    /* loaded from: classes.dex */
    public enum QOS {
        LEVEL_0(0),
        LEVEL_1(1),
        LEVEL_2(2);
        
        public int value;

        QOS(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }
    }

    boolean available();

    void initChannelWithContext(CHANNEL channel, Application application);

    long publish(String topic, String message);

    long publish(String topic, String message, QOS qosLevel);

    long publish(String topic, byte[] message);

    long publish(String topic, byte[] message, QOS qosLevel);

    void subscribe(String topic);
}
