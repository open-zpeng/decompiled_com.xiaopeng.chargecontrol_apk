package defpackage;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: SerializedName.java */
@Target({ElementType.FIELD, ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: fv  reason: default package */
/* loaded from: classes.dex */
public @interface fv {
    String[] alternate() default {};

    String value();
}
