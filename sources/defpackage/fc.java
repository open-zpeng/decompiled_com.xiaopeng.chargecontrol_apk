package defpackage;

import android.animation.Animator;
import android.view.animation.Animation;
/* compiled from: FragmentAnim.java */
/* renamed from: fc  reason: default package */
/* loaded from: classes.dex */
public class fc {
    public final Animation a;
    public final Animator b;

    public fc(Animation animation) {
        this.a = animation;
        this.b = null;
        if (animation == null) {
            throw new IllegalStateException("Animation cannot be null");
        }
    }

    public fc(Animator animator) {
        this.a = null;
        this.b = animator;
        if (animator == null) {
            throw new IllegalStateException("Animator cannot be null");
        }
    }
}
