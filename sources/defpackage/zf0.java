package defpackage;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import defpackage.eg0;
/* compiled from: XCountDown.java */
/* renamed from: zf0  reason: default package */
/* loaded from: classes.dex */
public class zf0 extends Handler {
    public a a;
    public int b;
    public int c;
    public String d;

    /* compiled from: XCountDown.java */
    /* renamed from: zf0$a */
    /* loaded from: classes.dex */
    public interface a {
    }

    public zf0(a aVar) {
        this.a = aVar;
    }

    public void a(String str, int i) {
        this.d = str;
        a();
        this.b = i;
        this.c = i;
        sendEmptyMessage(0);
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        a aVar;
        a aVar2 = this.a;
        if (aVar2 != null) {
            String str = this.d;
            eg0.c cVar = (eg0.c) aVar2;
            cVar.a.setText(String.format(cVar.c, str, Integer.valueOf(this.c)));
            TextView textView = cVar.a;
            if (textView instanceof re0) {
                ((re0) textView).a(str);
            }
        }
        if (this.c == 0 && (aVar = this.a) != null) {
            eg0.c cVar2 = (eg0.c) aVar;
            cVar2.a.setText(this.d);
            eg0.this.n;
            eg0.this.u.onClick(cVar2.a);
        }
        int i = this.c;
        if (i > 0) {
            this.c = i - 1;
            sendEmptyMessageDelayed(0, 1000L);
        }
    }

    public void a() {
        removeMessages(0);
        a aVar = this.a;
        if (aVar != null) {
            ((eg0.c) aVar).a.setText(this.d);
        }
    }
}
