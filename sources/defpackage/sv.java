package defpackage;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.EnumSet;
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: ConstructorConstructor.java */
/* renamed from: sv  reason: default package */
/* loaded from: classes.dex */
public class sv<T> implements cw<T> {
    public final /* synthetic */ Type a;

    public sv(pv pvVar, Type type) {
        this.a = type;
    }

    @Override // defpackage.cw
    public T a() {
        Type type = this.a;
        if (type instanceof ParameterizedType) {
            Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
            if (type2 instanceof Class) {
                return (T) EnumSet.noneOf((Class) type2);
            }
            StringBuilder a = jg.a("Invalid EnumSet type: ");
            a.append(this.a.toString());
            throw new su(a.toString());
        }
        StringBuilder a2 = jg.a("Invalid EnumSet type: ");
        a2.append(this.a.toString());
        throw new su(a2.toString());
    }
}
