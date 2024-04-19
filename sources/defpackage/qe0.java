package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.xiaopeng.speech.vui.constants.VuiConstants;
import defpackage.nf;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* compiled from: VuiRecyclerView.java */
/* renamed from: qe0  reason: default package */
/* loaded from: classes.dex */
public class qe0 extends nf implements re0, hc0 {
    public boolean J0;
    public af0 K0;
    public bf0 L0;
    public ic0 M0;
    public Handler N0;
    public int O0;
    public Runnable P0;
    public String Q0;
    public boolean R0;
    public boolean S0;
    public final nf.h T0;
    public boolean U0;
    public boolean V0;
    public boolean W0;
    public int X0;
    public int Y0;
    public boolean Z0;
    public List<String[]> a1;

    /* compiled from: VuiRecyclerView.java */
    /* renamed from: qe0$a */
    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            qe0 qe0Var = qe0.this;
            if (qe0Var.M0 == null || TextUtils.isEmpty(qe0Var.Q0)) {
                return;
            }
            qe0 qe0Var2 = qe0.this;
            qe0Var2.M0.updateScene(qe0Var2.Q0, qe0Var2);
        }
    }

    /* compiled from: VuiRecyclerView.java */
    /* renamed from: qe0$b */
    /* loaded from: classes.dex */
    public class b extends nf.h {
        public b() {
        }

        @Override // defpackage.nf.h
        public void a() {
            af0 af0Var;
            qe0 qe0Var = qe0.this;
            if (!qe0Var.S0 || (af0Var = qe0Var.K0) == null) {
                return;
            }
            af0Var.c.incrementAndGet();
        }
    }

    public qe0(Context context) {
        super(context);
        this.J0 = true;
        this.N0 = new Handler(Looper.getMainLooper());
        this.O0 = 1000;
        this.P0 = new a();
        this.R0 = true;
        this.S0 = true;
        this.T0 = new b();
        this.U0 = false;
        this.V0 = false;
        this.W0 = false;
        this.X0 = 0;
        this.Y0 = -1;
        this.Z0 = false;
        this.a1 = null;
        b0();
    }

    public void a(String str, ic0 ic0Var) {
        this.Q0 = str;
        this.M0 = ic0Var;
    }

    @Override // defpackage.hc0
    public boolean a(View view, tc0 tc0Var) {
        return false;
    }

    public final void b0() {
        this.K0 = new af0(this);
        this.L0 = new bf0(this);
        a(true);
    }

    public void c0() {
        if (!TextUtils.isEmpty(this.Q0) && this.M0 != null) {
            this.N0.removeCallbacks(this.P0);
            this.N0.postDelayed(this.P0, this.O0);
            return;
        }
        d("updateVuiScene sceneid is empty");
    }

    public void finalize() {
        super.finalize();
        r();
    }

    @Override // defpackage.nf, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        bf0 bf0Var;
        super.onAttachedToWindow();
        StringBuilder a2 = jg.a("onAttachedToWindow:");
        a2.append(this.Q0);
        d(a2.toString());
        if (this.S0 && this.K0 != null) {
            getViewTreeObserver().addOnGlobalLayoutListener(this.K0);
        }
        if (!this.R0 || (bf0Var = this.L0) == null) {
            return;
        }
        a((nf.s) bf0Var);
    }

    @Override // defpackage.nf, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        bf0 bf0Var;
        super.onDetachedFromWindow();
        StringBuilder a2 = jg.a("onDetachedFromWindow:");
        a2.append(this.Q0);
        d(a2.toString());
        if (this.S0 && this.K0 != null) {
            getViewTreeObserver().removeOnGlobalLayoutListener(this.K0);
        }
        if (this.R0 && (bf0Var = this.L0) != null) {
            b(bf0Var);
        }
        this.N0.removeCallbacks(this.P0);
    }

    @Override // defpackage.nf
    public void setAdapter(nf.f fVar) {
        af0 af0Var;
        nf.f adapter = getAdapter();
        if (adapter != null) {
            adapter.a.unregisterObserver(this.T0);
        }
        super.setAdapter(fVar);
        if (fVar != null) {
            fVar.a.registerObserver(this.T0);
        }
        if (!this.S0 || (af0Var = this.K0) == null) {
            return;
        }
        af0Var.c.incrementAndGet();
    }

    public void setCanVuiScrollDown(boolean z) {
        this.U0 = z;
    }

    public void setCanVuiScrollRight(boolean z) {
        this.V0 = z;
    }

    public void setOrderState(boolean z) {
        this.Z0 = z;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (this.S0) {
            return;
        }
        c0();
    }

    public void setVuiCanControlScroll(boolean z) {
        this.J0 = z;
    }

    @Override // defpackage.hc0
    public sc0 a(String str, fc0 fc0Var) {
        JSONObject p;
        nf.n layoutManager;
        int i;
        int j;
        if (this.J0) {
            boolean canScrollVertically = canScrollVertically(-1);
            boolean z = true;
            boolean canScrollVertically2 = canScrollVertically(1);
            boolean canScrollHorizontally = canScrollHorizontally(-1);
            boolean canScrollHorizontally2 = canScrollHorizontally(1);
            if (!canScrollVertically && !canScrollVertically2 && !this.U0) {
                if (canScrollHorizontally || canScrollHorizontally2 || this.V0) {
                    c(lc0.SCROLLBYX.c);
                }
            } else {
                c(lc0.SCROLLBYY.c);
            }
            try {
                p = p();
                if (p == null) {
                    p = new JSONObject();
                }
                if (this.W0 && (layoutManager = getLayoutManager()) != null && (layoutManager instanceof LinearLayoutManager)) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    p.put(VuiConstants.PROPS_MINVALUE, this.X0);
                    if (this.Y0 != -1) {
                        i = this.X0;
                        j = this.Y0;
                    } else {
                        i = this.X0;
                        j = layoutManager.j();
                    }
                    int i2 = i + j;
                    p.put(VuiConstants.PROPS_MAXVALUE, i2);
                    p.put("displayStart", this.Z0 ? i2 - linearLayoutManager.R() : this.X0 + linearLayoutManager.O());
                    p.put("displayEnd", this.Z0 ? i2 - linearLayoutManager.O() : this.X0 + linearLayoutManager.R());
                    if (this.a1 != null && this.a1.size() > 0) {
                        p.put("supportVuiLabels", this.a1);
                    }
                    p.put("isReverse", this.Z0);
                }
            } catch (JSONException unused) {
            }
            if (o() == null) {
                return null;
            }
            if (o().equals(lc0.SCROLLBYY.c)) {
                p.put(VuiConstants.PROPS_SCROLLUP, canScrollVertically);
                if (!canScrollVertically2 && !this.U0) {
                    z = false;
                }
                p.put(VuiConstants.PROPS_SCROLLDOWN, z);
            } else {
                p.put(VuiConstants.PROPS_SCROLLLEFT, canScrollHorizontally);
                if (!canScrollHorizontally2 && !this.V0) {
                    z = false;
                }
                p.put(VuiConstants.PROPS_SCROLLRIGHT, z);
            }
            a(p);
            return null;
        }
        return null;
    }

    public qe0(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.J0 = true;
        this.N0 = new Handler(Looper.getMainLooper());
        this.O0 = 1000;
        this.P0 = new a();
        this.R0 = true;
        this.S0 = true;
        this.T0 = new b();
        this.U0 = false;
        this.V0 = false;
        this.W0 = false;
        this.X0 = 0;
        this.Y0 = -1;
        this.Z0 = false;
        this.a1 = null;
        a(this, attributeSet);
        b0();
    }

    public qe0(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.J0 = true;
        this.N0 = new Handler(Looper.getMainLooper());
        this.O0 = 1000;
        this.P0 = new a();
        this.R0 = true;
        this.S0 = true;
        this.T0 = new b();
        this.U0 = false;
        this.V0 = false;
        this.W0 = false;
        this.X0 = 0;
        this.Y0 = -1;
        this.Z0 = false;
        this.a1 = null;
        a(this, attributeSet);
        b0();
    }
}
