package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: VuiAction.java */
/* renamed from: lc0  reason: default package */
/* loaded from: classes.dex */
public enum lc0 {
    CLICK("Click"),
    SETVALUE("SetValue"),
    SCROLLBYX("ScrollByX"),
    SCROLLBYY("ScrollByY"),
    SETCHECK("SetCheck"),
    ITEMCLICK("ItemClick"),
    SELECTTAB("SelectTab"),
    SCROLLTO("ScrollTo"),
    SETSELECTED("SetSelected");
    
    public String c;

    lc0(String str) {
        this.c = str;
    }

    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (lc0 lc0Var : values()) {
            arrayList.add(lc0Var.c);
        }
        return arrayList;
    }
}
