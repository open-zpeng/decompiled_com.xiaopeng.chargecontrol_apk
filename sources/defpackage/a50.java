package defpackage;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
/* compiled from: HelpContentHolder.java */
/* renamed from: a50  reason: default package */
/* loaded from: classes.dex */
public abstract class a50 extends x40 {
    public TextView c;

    @Override // defpackage.x40
    public void a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super.a(layoutInflater, viewGroup);
        this.c = (TextView) this.a.findViewById(o90.content);
        this.c.setText(e());
    }

    @Override // defpackage.x40
    public int b() {
        return q90.layout_help_content;
    }

    public abstract int e();
}
