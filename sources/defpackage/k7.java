package defpackage;

import android.app.Person;
import androidx.core.graphics.drawable.IconCompat;
/* compiled from: Person.java */
/* renamed from: k7  reason: default package */
/* loaded from: classes.dex */
public class k7 {
    public CharSequence a;
    public IconCompat b;
    public String c;
    public String d;
    public boolean e;
    public boolean f;

    public Person a() {
        Person.Builder name = new Person.Builder().setName(this.a);
        IconCompat iconCompat = this.b;
        return name.setIcon(iconCompat != null ? iconCompat.e() : null).setUri(this.c).setKey(this.d).setBot(this.e).setImportant(this.f).build();
    }
}
