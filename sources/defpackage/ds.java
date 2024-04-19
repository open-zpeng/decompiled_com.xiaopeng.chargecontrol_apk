package defpackage;

import java.text.DecimalFormat;
/* compiled from: DefaultValueFormatter.java */
/* renamed from: ds  reason: default package */
/* loaded from: classes.dex */
public class ds extends fs {
    public DecimalFormat a;

    public ds(int i) {
        a(i);
    }

    public void a(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 == 0) {
                stringBuffer.append(".");
            }
            stringBuffer.append("0");
        }
        StringBuilder a = jg.a("###,###,###,##0");
        a.append(stringBuffer.toString());
        this.a = new DecimalFormat(a.toString());
    }

    @Override // defpackage.fs
    public String a(float f) {
        return this.a.format(f);
    }
}
