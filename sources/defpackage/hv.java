package defpackage;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: Until.java */
@Target({ElementType.FIELD, ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: hv  reason: default package */
/* loaded from: classes.dex */
public @interface hv {
    double value();
}
