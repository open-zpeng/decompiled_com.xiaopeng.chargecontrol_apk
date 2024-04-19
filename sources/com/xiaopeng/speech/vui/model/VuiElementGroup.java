package com.xiaopeng.speech.vui.model;

import java.util.List;
/* loaded from: classes.dex */
public class VuiElementGroup extends sc0 {
    public boolean dynamic = false;
    public int position = -1;
    public List<sc0> elements = null;

    @Override // defpackage.sc0
    public List<sc0> getElements() {
        return this.elements;
    }

    @Override // defpackage.sc0
    public int getPosition() {
        return this.position;
    }

    public boolean isDynamic() {
        return this.dynamic;
    }

    public void setDynamic(boolean z) {
        this.dynamic = z;
    }

    @Override // defpackage.sc0
    public void setElements(List<sc0> list) {
        this.elements = list;
    }

    @Override // defpackage.sc0
    public void setPosition(int i) {
        this.position = i;
    }
}
