package defpackage;
/* compiled from: NotificationCompat.java */
/* renamed from: i7  reason: default package */
/* loaded from: classes.dex */
public class i7 {
    public static CharSequence a(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }
}
