package defpackage;

import java.util.ArrayList;
import java.util.List;
/* compiled from: VuiActType.java */
/* renamed from: kc0  reason: default package */
/* loaded from: classes.dex */
public enum kc0 {
    SEARCH("Search"),
    SELECT("Select"),
    EDIT("Edit"),
    OPEN("Open"),
    DELETE("Delete"),
    DETAIL("Detail"),
    EXPANDFOLD("ExpandFold"),
    ROLL("Roll"),
    TAB("Tab"),
    SELECTTAB("SelectTab"),
    SLIDE("Slide"),
    UP("Up"),
    DOWN("Down"),
    LEFT("Left"),
    RIGHT("Right"),
    SET("Set"),
    SORT("Sort"),
    EXPAND("Expand"),
    ADD("Add"),
    PLAY("Play"),
    NULL("Null");
    
    public String c;

    kc0(String str) {
        this.c = str;
    }

    public static List<String> a() {
        ArrayList arrayList = new ArrayList();
        for (kc0 kc0Var : values()) {
            arrayList.add(kc0Var.c);
        }
        return arrayList;
    }
}
