package com.xiaopeng.lib.framework.moduleinterface.carcontroller;
/* loaded from: classes.dex */
public abstract class AbsError implements IError {
    public int code;

    @Override // com.xiaopeng.lib.framework.moduleinterface.carcontroller.IError
    public int getCode() {
        return this.code;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.carcontroller.IError
    public void setCode(int code) {
        this.code = code;
    }
}
