package defpackage;
/* compiled from: LayoutState.java */
/* renamed from: hf  reason: default package */
/* loaded from: classes.dex */
public class hf {
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean h;
    public boolean i;
    public boolean a = true;
    public int f = 0;
    public int g = 0;

    public String toString() {
        StringBuilder a = jg.a("LayoutState{mAvailable=");
        a.append(this.b);
        a.append(", mCurrentPosition=");
        a.append(this.c);
        a.append(", mItemDirection=");
        a.append(this.d);
        a.append(", mLayoutDirection=");
        a.append(this.e);
        a.append(", mStartLine=");
        a.append(this.f);
        a.append(", mEndLine=");
        a.append(this.g);
        a.append('}');
        return a.toString();
    }
}
