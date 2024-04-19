package com.xiaopeng.libconfig.remotecontrol;
/* loaded from: classes.dex */
public class CommandItem {
    public int cmd_type;
    public float cmd_value;
    public String fileUrl;

    public int getCmd_type() {
        return this.cmd_type;
    }

    public float getCmd_value() {
        return this.cmd_value;
    }

    public String getFileUrl() {
        return this.fileUrl;
    }

    public void setCmd_type(int i) {
        this.cmd_type = i;
    }

    public void setCmd_value(float f) {
        this.cmd_value = f;
    }

    public void setFileUrl(String str) {
        this.fileUrl = str;
    }

    public String toString() {
        StringBuilder a = jg.a("CommandItem{cmd_type=");
        a.append(this.cmd_type);
        a.append(", cmd_value=");
        a.append(this.cmd_value);
        a.append(", fileUrl=");
        a.append(this.fileUrl);
        a.append('}');
        return a.toString();
    }
}
