package defpackage;

import defpackage.vd;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* compiled from: OnLifecycleEvent.java */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Deprecated
/* renamed from: ge  reason: default package */
/* loaded from: classes.dex */
public @interface ge {
    vd.a value();
}
