package com.xiaopeng.libconfig.ipc.bean;
/* loaded from: classes.dex */
public class OnlineAccountBean {
    public String accessToken;
    public int grade;
    public String name;
    public boolean onLine;
    public String phone;
    public String pic;
    public String refreshToken;
    public long uid;

    public int getGrade() {
        return this.grade;
    }

    public String getName() {
        return this.name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String getPic() {
        return this.pic;
    }

    public long getUid() {
        return this.uid;
    }

    public boolean isOnLine() {
        return this.onLine;
    }

    public void setGrade(int i) {
        this.grade = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOnLine(boolean z) {
        this.onLine = z;
    }

    public void setPhone(String str) {
        this.phone = str;
    }

    public void setPic(String str) {
        this.pic = str;
    }

    public void setUid(long j) {
        this.uid = j;
    }

    public String toString() {
        StringBuilder a = jg.a("OnlineAccountBean{uid='");
        a.append(this.uid);
        a.append('\'');
        a.append(", name='");
        jg.a(a, this.name, '\'', ", phone='");
        jg.a(a, this.phone, '\'', ", onLine=");
        a.append(this.onLine);
        a.append(", accessToken='");
        jg.a(a, this.accessToken, '\'', ", refreshToken='");
        jg.a(a, this.refreshToken, '\'', ", grade=");
        a.append(this.grade);
        a.append(", pic='");
        a.append(this.pic);
        a.append('\'');
        a.append('}');
        return a.toString();
    }
}
