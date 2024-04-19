package defpackage;

import android.content.DialogInterface;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import defpackage.g2;
/* compiled from: MenuDialogHelper.java */
/* renamed from: a2  reason: default package */
/* loaded from: classes.dex */
public class a2 implements DialogInterface.OnKeyListener, DialogInterface.OnClickListener, DialogInterface.OnDismissListener, g2.a {
    public z1 c;
    public q0 d;
    public x1 e;
    public g2.a f;

    public a2(z1 z1Var) {
        this.c = z1Var;
    }

    @Override // defpackage.g2.a
    public void a(z1 z1Var, boolean z) {
        q0 q0Var;
        if ((z || z1Var == this.c) && (q0Var = this.d) != null) {
            q0Var.dismiss();
        }
        g2.a aVar = this.f;
        if (aVar != null) {
            aVar.a(z1Var, z);
        }
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        this.c.a((c2) this.e.b().getItem(i), 0);
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        this.e.a(this.c, true);
    }

    @Override // android.content.DialogInterface.OnKeyListener
    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        Window window;
        View decorView;
        KeyEvent.DispatcherState keyDispatcherState;
        View decorView2;
        KeyEvent.DispatcherState keyDispatcherState2;
        if (i == 82 || i == 4) {
            if (keyEvent.getAction() == 0 && keyEvent.getRepeatCount() == 0) {
                Window window2 = this.d.getWindow();
                if (window2 != null && (decorView2 = window2.getDecorView()) != null && (keyDispatcherState2 = decorView2.getKeyDispatcherState()) != null) {
                    keyDispatcherState2.startTracking(keyEvent, this);
                    return true;
                }
            } else if (keyEvent.getAction() == 1 && !keyEvent.isCanceled() && (window = this.d.getWindow()) != null && (decorView = window.getDecorView()) != null && (keyDispatcherState = decorView.getKeyDispatcherState()) != null && keyDispatcherState.isTracking(keyEvent)) {
                this.c.a(true);
                dialogInterface.dismiss();
                return true;
            }
        }
        return this.c.performShortcut(i, keyEvent, 0);
    }

    @Override // defpackage.g2.a
    public boolean a(z1 z1Var) {
        g2.a aVar = this.f;
        if (aVar != null) {
            return aVar.a(z1Var);
        }
        return false;
    }
}
