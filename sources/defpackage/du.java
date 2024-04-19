package defpackage;

import java.lang.reflect.Field;
/* compiled from: FieldAttributes.java */
/* renamed from: du  reason: default package */
/* loaded from: classes.dex */
public final class du {
    public final Field a;

    public du(Field field) {
        if (field != null) {
            this.a = field;
            return;
        }
        throw new NullPointerException();
    }
}
