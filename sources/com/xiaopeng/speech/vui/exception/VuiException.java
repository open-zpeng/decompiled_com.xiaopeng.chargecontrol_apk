package com.xiaopeng.speech.vui.exception;
/* loaded from: classes.dex */
public class VuiException extends RuntimeException {
    public final VuiErrorCode errorCode;

    public VuiException() {
        super(VuiErrorCode.UNSPECIFIED.getDescription());
        this.errorCode = VuiErrorCode.UNSPECIFIED;
    }

    public VuiErrorCode getErrorCode() {
        return this.errorCode;
    }

    public VuiException(VuiErrorCode vuiErrorCode) {
        super(vuiErrorCode.getDescription());
        this.errorCode = vuiErrorCode;
    }
}
