package com.xiaopeng.libconfig.ipc.event;
/* loaded from: classes.dex */
public class NavigationEvent {
    public int index;
    public boolean state;

    public int getIndex() {
        return this.index;
    }

    public boolean getState() {
        return this.state;
    }

    public NavigationEvent setIndex(int i) {
        this.index = i;
        return this;
    }

    public NavigationEvent setState(boolean z) {
        this.state = z;
        return this;
    }

    public String toString() {
        StringBuilder a = jg.a("{\"state\":");
        a.append(this.state);
        a.append(",\"index\":");
        a.append(this.index);
        a.append("}");
        return a.toString();
    }
}
