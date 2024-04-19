package defpackage;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: JsonAdapter.java */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: ev  reason: default package */
/* loaded from: classes.dex */
public @interface ev {
    boolean nullSafe() default true;

    Class<?> value();
}
