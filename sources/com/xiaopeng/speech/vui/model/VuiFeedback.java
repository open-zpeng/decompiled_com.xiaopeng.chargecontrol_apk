package com.xiaopeng.speech.vui.model;
/* loaded from: classes.dex */
public class VuiFeedback {
    public VuiFeedbackCode code;
    public String content;
    public nc0 feedbackType;
    public String resourceName;
    public int state;

    /* loaded from: classes.dex */
    public static class Builder {
        public String content;
        public int state = -1;
        public VuiFeedbackCode code = VuiFeedbackCode.SUCCESS;
        public nc0 type = nc0.TTS;

        public VuiFeedback build() {
            return new VuiFeedback(this);
        }

        public Builder code(VuiFeedbackCode vuiFeedbackCode) {
            this.code = vuiFeedbackCode;
            return this;
        }

        public Builder content(String str) {
            this.content = str;
            return this;
        }

        public Builder state(int i) {
            this.state = i;
            return this;
        }

        public Builder type(nc0 nc0Var) {
            this.type = nc0Var;
            return this;
        }
    }

    public VuiFeedbackCode getCode() {
        return this.code;
    }

    public String getContent() {
        return this.content;
    }

    public nc0 getFeedbackType() {
        return this.feedbackType;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public int getState() {
        return this.state;
    }

    public void setCode(VuiFeedbackCode vuiFeedbackCode) {
        this.code = vuiFeedbackCode;
    }

    public void setContent(String str) {
        this.content = str;
    }

    public void setFeedbackType(nc0 nc0Var) {
        this.feedbackType = nc0Var;
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public void setState(int i) {
        this.state = i;
    }

    public String toString() {
        StringBuilder a = jg.a("VuiFeedback{code=");
        a.append(this.code.getFeedbackCode());
        a.append(", content='");
        jg.a(a, this.content, '\'', ", resourceName='");
        jg.a(a, this.resourceName, '\'', ", state=");
        a.append(this.state);
        a.append(", feedbackType=");
        a.append(this.feedbackType.c);
        a.append('}');
        return a.toString();
    }

    public VuiFeedback(Builder builder) {
        this.code = VuiFeedbackCode.SUCCESS;
        this.feedbackType = nc0.TTS;
        this.state = builder.state;
        this.content = builder.content;
        this.code = builder.code;
        this.feedbackType = builder.type;
    }
}
