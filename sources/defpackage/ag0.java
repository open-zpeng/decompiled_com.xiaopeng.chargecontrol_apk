package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import android.widget.TextView;
import com.xiaopeng.xui.widget.XFrameLayout;
/* compiled from: XDialogMessage.java */
/* renamed from: ag0  reason: default package */
/* loaded from: classes.dex */
public class ag0 extends XFrameLayout {
    public TextView d;

    /* compiled from: XDialogMessage.java */
    /* renamed from: ag0$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnPreDrawListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            ag0.this.d.getViewTreeObserver().removeOnPreDrawListener(this);
            ag0.this.t();
            return true;
        }
    }

    public ag0(Context context) {
        super(context, null, 0, 0);
        LayoutInflater.from(context).inflate(ad0.x_dialog_message, this);
        this.d = (TextView) findViewById(yc0.x_dialog_message);
        ImageView imageView = (ImageView) findViewById(yc0.x_dialog_icon);
    }

    public final void t() {
        if (this.d.getLineCount() < 2) {
            this.d.setGravity(1);
        } else {
            this.d.setGravity(8388611);
        }
        this.d.setVisibility(0);
    }

    public final void u() {
        if (this.d.getWidth() > 0) {
            t();
        } else {
            this.d.getViewTreeObserver().addOnPreDrawListener(new a());
        }
    }
}
