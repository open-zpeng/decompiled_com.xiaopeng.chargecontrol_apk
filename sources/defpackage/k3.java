package defpackage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.app.AlertController;
import defpackage.q0;
/* compiled from: AppCompatSpinner.java */
/* renamed from: k3  reason: default package */
/* loaded from: classes.dex */
public class k3 extends Spinner implements x9 {
    public static final int[] k = {16843505};
    public final r2 c;
    public final Context d;
    public w3 e;
    public SpinnerAdapter f;
    public final boolean g;
    public f h;
    public int i;
    public final Rect j;

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$a */
    /* loaded from: classes.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!k3.this.getInternalPopup().b()) {
                k3.this.a();
            }
            ViewTreeObserver viewTreeObserver = k3.this.getViewTreeObserver();
            if (viewTreeObserver != null) {
                int i = Build.VERSION.SDK_INT;
                viewTreeObserver.removeOnGlobalLayoutListener(this);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$b */
    /* loaded from: classes.dex */
    public class b implements f, DialogInterface.OnClickListener {
        public q0 c;
        public ListAdapter d;
        public CharSequence e;

        public b() {
        }

        @Override // defpackage.k3.f
        public int a() {
            return 0;
        }

        @Override // defpackage.k3.f
        public void a(ListAdapter listAdapter) {
            this.d = listAdapter;
        }

        @Override // defpackage.k3.f
        public boolean b() {
            q0 q0Var = this.c;
            if (q0Var != null) {
                return q0Var.isShowing();
            }
            return false;
        }

        @Override // defpackage.k3.f
        public void c(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal offset for MODE_DIALOG, ignoring");
        }

        @Override // defpackage.k3.f
        public Drawable d() {
            return null;
        }

        @Override // defpackage.k3.f
        public void dismiss() {
            q0 q0Var = this.c;
            if (q0Var != null) {
                q0Var.dismiss();
                this.c = null;
            }
        }

        @Override // defpackage.k3.f
        public int f() {
            return 0;
        }

        @Override // defpackage.k3.f
        public CharSequence g() {
            return this.e;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            k3.this.setSelection(i);
            if (k3.this.getOnItemClickListener() != null) {
                k3.this.performItemClick(null, i, this.d.getItemId(i));
            }
            dismiss();
        }

        @Override // defpackage.k3.f
        public void a(CharSequence charSequence) {
            this.e = charSequence;
        }

        @Override // defpackage.k3.f
        public void b(int i) {
            Log.e("AppCompatSpinner", "Cannot set horizontal (original) offset for MODE_DIALOG, ignoring");
        }

        @Override // defpackage.k3.f
        public void a(int i, int i2) {
            if (this.d == null) {
                return;
            }
            q0.a aVar = new q0.a(k3.this.getPopupContext());
            CharSequence charSequence = this.e;
            if (charSequence != null) {
                aVar.a.f = charSequence;
            }
            ListAdapter listAdapter = this.d;
            int selectedItemPosition = k3.this.getSelectedItemPosition();
            AlertController.b bVar = aVar.a;
            bVar.w = listAdapter;
            bVar.x = this;
            bVar.I = selectedItemPosition;
            bVar.H = true;
            this.c = aVar.a();
            ListView listView = this.c.e.g;
            int i3 = Build.VERSION.SDK_INT;
            listView.setTextDirection(i);
            listView.setTextAlignment(i2);
            this.c.show();
        }

        @Override // defpackage.k3.f
        public void a(Drawable drawable) {
            Log.e("AppCompatSpinner", "Cannot set popup background for MODE_DIALOG, ignoring");
        }

        @Override // defpackage.k3.f
        public void a(int i) {
            Log.e("AppCompatSpinner", "Cannot set vertical offset for MODE_DIALOG, ignoring");
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$c */
    /* loaded from: classes.dex */
    public static class c implements ListAdapter, SpinnerAdapter {
        public SpinnerAdapter c;
        public ListAdapter d;

        public c(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.c = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.d = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                int i = Build.VERSION.SDK_INT;
                if (spinnerAdapter instanceof ThemedSpinnerAdapter) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                    }
                } else if (spinnerAdapter instanceof j4) {
                    j4 j4Var = (j4) spinnerAdapter;
                    if (j4Var.getDropDownViewTheme() == null) {
                        j4Var.setDropDownViewTheme(theme);
                    }
                }
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.d;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return 0;
            }
            return spinnerAdapter.getCount();
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return -1L;
            }
            return spinnerAdapter.getItemId(i);
        }

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter == null) {
                return null;
            }
            return spinnerAdapter.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            SpinnerAdapter spinnerAdapter = this.c;
            return spinnerAdapter != null && spinnerAdapter.hasStableIds();
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.d;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter != null) {
                spinnerAdapter.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            SpinnerAdapter spinnerAdapter = this.c;
            if (spinnerAdapter != null) {
                spinnerAdapter.unregisterDataSetObserver(dataSetObserver);
            }
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$d */
    /* loaded from: classes.dex */
    public class d extends a4 implements f {
        public CharSequence J;
        public ListAdapter K;
        public final Rect L;
        public int M;

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: k3$d$a */
        /* loaded from: classes.dex */
        public class a implements AdapterView.OnItemClickListener {
            public a(k3 k3Var) {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                k3.this.setSelection(i);
                if (k3.this.getOnItemClickListener() != null) {
                    d dVar = d.this;
                    k3.this.performItemClick(view, i, dVar.K.getItemId(i));
                }
                d.this.dismiss();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: k3$d$b */
        /* loaded from: classes.dex */
        public class b implements ViewTreeObserver.OnGlobalLayoutListener {
            public b() {
            }

            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                d dVar = d.this;
                if (!dVar.a(k3.this)) {
                    d.this.dismiss();
                    return;
                }
                d.this.h();
                d.super.c();
            }
        }

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: k3$d$c */
        /* loaded from: classes.dex */
        public class c implements PopupWindow.OnDismissListener {
            public final /* synthetic */ ViewTreeObserver.OnGlobalLayoutListener c;

            public c(ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
                this.c = onGlobalLayoutListener;
            }

            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                ViewTreeObserver viewTreeObserver = k3.this.getViewTreeObserver();
                if (viewTreeObserver != null) {
                    viewTreeObserver.removeGlobalOnLayoutListener(this.c);
                }
            }
        }

        public d(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i, 0);
            this.L = new Rect();
            this.u = k3.this;
            a(true);
            this.s = 0;
            this.w = new a(k3.this);
        }

        @Override // defpackage.k3.f
        public void b(int i) {
            this.M = i;
        }

        @Override // defpackage.k3.f
        public CharSequence g() {
            return this.J;
        }

        public void h() {
            int i;
            Drawable d = d();
            int i2 = 0;
            if (d != null) {
                d.getPadding(k3.this.j);
                i2 = r4.a(k3.this) ? k3.this.j.right : -k3.this.j.left;
            } else {
                Rect rect = k3.this.j;
                rect.right = 0;
                rect.left = 0;
            }
            int paddingLeft = k3.this.getPaddingLeft();
            int paddingRight = k3.this.getPaddingRight();
            int width = k3.this.getWidth();
            k3 k3Var = k3.this;
            int i3 = k3Var.i;
            if (i3 == -2) {
                int a2 = k3Var.a((SpinnerAdapter) this.K, d());
                int i4 = k3.this.getContext().getResources().getDisplayMetrics().widthPixels;
                Rect rect2 = k3.this.j;
                int i5 = (i4 - rect2.left) - rect2.right;
                if (a2 > i5) {
                    a2 = i5;
                }
                d(Math.max(a2, (width - paddingLeft) - paddingRight));
            } else if (i3 == -1) {
                d((width - paddingLeft) - paddingRight);
            } else {
                d(i3);
            }
            if (r4.a(k3.this)) {
                i = (((width - paddingRight) - this.g) - this.M) + i2;
            } else {
                i = this.M + paddingLeft + i2;
            }
            this.h = i;
        }

        @Override // defpackage.a4, defpackage.k3.f
        public void a(ListAdapter listAdapter) {
            super.a(listAdapter);
            this.K = listAdapter;
        }

        @Override // defpackage.k3.f
        public void a(CharSequence charSequence) {
            this.J = charSequence;
        }

        @Override // defpackage.k3.f
        public void a(int i, int i2) {
            ViewTreeObserver viewTreeObserver;
            boolean b2 = b();
            h();
            this.G.setInputMethodMode(2);
            super.c();
            u3 u3Var = this.e;
            u3Var.setChoiceMode(1);
            int i3 = Build.VERSION.SDK_INT;
            u3Var.setTextDirection(i);
            u3Var.setTextAlignment(i2);
            int selectedItemPosition = k3.this.getSelectedItemPosition();
            u3 u3Var2 = this.e;
            if (b() && u3Var2 != null) {
                u3Var2.setListSelectionHidden(false);
                u3Var2.setSelection(selectedItemPosition);
                if (u3Var2.getChoiceMode() != 0) {
                    u3Var2.setItemChecked(selectedItemPosition, true);
                }
            }
            if (b2 || (viewTreeObserver = k3.this.getViewTreeObserver()) == null) {
                return;
            }
            b bVar = new b();
            viewTreeObserver.addOnGlobalLayoutListener(bVar);
            this.G.setOnDismissListener(new c(bVar));
        }

        public boolean a(View view) {
            return y9.q(view) && view.getGlobalVisibleRect(this.L);
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$e */
    /* loaded from: classes.dex */
    public static class e extends View.BaseSavedState {
        public static final Parcelable.Creator<e> CREATOR = new a();
        public boolean c;

        /* compiled from: AppCompatSpinner.java */
        /* renamed from: k3$e$a */
        /* loaded from: classes.dex */
        public class a implements Parcelable.Creator<e> {
            @Override // android.os.Parcelable.Creator
            public e createFromParcel(Parcel parcel) {
                return new e(parcel);
            }

            @Override // android.os.Parcelable.Creator
            public e[] newArray(int i) {
                return new e[i];
            }
        }

        public e(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeByte(this.c ? (byte) 1 : (byte) 0);
        }

        public e(Parcel parcel) {
            super(parcel);
            this.c = parcel.readByte() != 0;
        }
    }

    /* compiled from: AppCompatSpinner.java */
    /* renamed from: k3$f */
    /* loaded from: classes.dex */
    public interface f {
        int a();

        void a(int i);

        void a(int i, int i2);

        void a(Drawable drawable);

        void a(ListAdapter listAdapter);

        void a(CharSequence charSequence);

        void b(int i);

        boolean b();

        void c(int i);

        Drawable d();

        void dismiss();

        int f();

        CharSequence g();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0057, code lost:
        if (r4 == null) goto L13;
     */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00da  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public k3(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            r8.<init>(r9, r10, r11)
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r8.j = r0
            android.content.Context r0 = r8.getContext()
            defpackage.i4.a(r8, r0)
            int[] r0 = defpackage.i0.Spinner
            r1 = 0
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r10, r0, r11, r1)
            r2 r2 = new r2
            r2.<init>(r8)
            r8.c = r2
            int r2 = defpackage.i0.Spinner_popupTheme
            int r2 = r0.getResourceId(r2, r1)
            if (r2 == 0) goto L2f
            n1 r3 = new n1
            r3.<init>(r9, r2)
            r8.d = r3
            goto L31
        L2f:
            r8.d = r9
        L31:
            r2 = 0
            r3 = -1
            int[] r4 = defpackage.k3.k     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            android.content.res.TypedArray r4 = r9.obtainStyledAttributes(r10, r4, r11, r1)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
            boolean r5 = r4.hasValue(r1)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            if (r5 == 0) goto L59
            int r3 = r4.getInt(r1, r1)     // Catch: java.lang.Throwable -> L44 java.lang.Exception -> L48
            goto L59
        L44:
            r9 = move-exception
            r2 = r4
            goto Ld8
        L48:
            r5 = move-exception
            goto L50
        L4a:
            r9 = move-exception
            goto Ld8
        L4d:
            r4 = move-exception
            r5 = r4
            r4 = r2
        L50:
            java.lang.String r6 = "AppCompatSpinner"
            java.lang.String r7 = "Could not read android:spinnerMode"
            android.util.Log.i(r6, r7, r5)     // Catch: java.lang.Throwable -> L44
            if (r4 == 0) goto L5c
        L59:
            r4.recycle()
        L5c:
            r4 = 1
            if (r3 == 0) goto L9a
            if (r3 == r4) goto L62
            goto Lac
        L62:
            k3$d r3 = new k3$d
            android.content.Context r5 = r8.d
            r3.<init>(r5, r10, r11)
            android.content.Context r5 = r8.d
            int[] r6 = defpackage.i0.Spinner
            n4 r1 = defpackage.n4.a(r5, r10, r6, r11, r1)
            int r5 = defpackage.i0.Spinner_android_dropDownWidth
            r6 = -2
            int r5 = r1.d(r5, r6)
            r8.i = r5
            int r5 = defpackage.i0.Spinner_android_popupBackground
            android.graphics.drawable.Drawable r5 = r1.b(r5)
            r3.a(r5)
            int r5 = defpackage.i0.Spinner_android_prompt
            java.lang.String r5 = r0.getString(r5)
            r3.J = r5
            android.content.res.TypedArray r1 = r1.b
            r1.recycle()
            r8.h = r3
            j3 r1 = new j3
            r1.<init>(r8, r8, r3)
            r8.e = r1
            goto Lac
        L9a:
            k3$b r1 = new k3$b
            r1.<init>()
            r8.h = r1
            k3$f r1 = r8.h
            int r3 = defpackage.i0.Spinner_android_prompt
            java.lang.String r3 = r0.getString(r3)
            r1.a(r3)
        Lac:
            int r1 = defpackage.i0.Spinner_android_entries
            java.lang.CharSequence[] r1 = r0.getTextArray(r1)
            if (r1 == 0) goto Lc4
            android.widget.ArrayAdapter r3 = new android.widget.ArrayAdapter
            r5 = 17367048(0x1090008, float:2.5162948E-38)
            r3.<init>(r9, r5, r1)
            int r9 = defpackage.f0.support_simple_spinner_dropdown_item
            r3.setDropDownViewResource(r9)
            r8.setAdapter(r3)
        Lc4:
            r0.recycle()
            r8.g = r4
            android.widget.SpinnerAdapter r9 = r8.f
            if (r9 == 0) goto Ld2
            r8.setAdapter(r9)
            r8.f = r2
        Ld2:
            r2 r9 = r8.c
            r9.a(r10, r11)
            return
        Ld8:
            if (r2 == 0) goto Ldd
            r2.recycle()
        Ldd:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.k3.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        int i2 = 0;
        View view = null;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i2 = Math.max(i2, view.getMeasuredWidth());
        }
        if (drawable != null) {
            drawable.getPadding(this.j);
            Rect rect = this.j;
            return i2 + rect.left + rect.right;
        }
        return i2;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        f fVar = this.h;
        if (fVar != null) {
            return fVar.a();
        }
        int i = Build.VERSION.SDK_INT;
        return super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        f fVar = this.h;
        if (fVar != null) {
            return fVar.f();
        }
        int i = Build.VERSION.SDK_INT;
        return super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.h != null) {
            return this.i;
        }
        int i = Build.VERSION.SDK_INT;
        return super.getDropDownWidth();
    }

    public final f getInternalPopup() {
        return this.h;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        f fVar = this.h;
        if (fVar != null) {
            return fVar.d();
        }
        int i = Build.VERSION.SDK_INT;
        return super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.d;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        f fVar = this.h;
        return fVar != null ? fVar.g() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.b();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        r2 r2Var = this.c;
        if (r2Var != null) {
            return r2Var.c();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        f fVar = this.h;
        if (fVar == null || !fVar.b()) {
            return;
        }
        this.h.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.h == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        e eVar = (e) parcelable;
        super.onRestoreInstanceState(eVar.getSuperState());
        if (!eVar.c || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new a());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public Parcelable onSaveInstanceState() {
        e eVar = new e(super.onSaveInstanceState());
        f fVar = this.h;
        eVar.c = fVar != null && fVar.b();
        return eVar;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        w3 w3Var = this.e;
        if (w3Var == null || !w3Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        f fVar = this.h;
        if (fVar != null) {
            if (fVar.b()) {
                return true;
            }
            a();
            return true;
        }
        return super.performClick();
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(i);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.b(i);
            this.h.c(i);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        super.setDropDownHorizontalOffset(i);
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a(i);
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        super.setDropDownVerticalOffset(i);
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.h != null) {
            this.i = i;
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        super.setDropDownWidth(i);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a(drawable);
            return;
        }
        int i = Build.VERSION.SDK_INT;
        super.setPopupBackgroundDrawable(drawable);
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(i1.b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        f fVar = this.h;
        if (fVar != null) {
            fVar.a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.b(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        r2 r2Var = this.c;
        if (r2Var != null) {
            r2Var.a(mode);
        }
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.g) {
            this.f = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.h != null) {
            Context context = this.d;
            if (context == null) {
                context = getContext();
            }
            this.h.a(new c(spinnerAdapter, context.getTheme()));
        }
    }

    public void a() {
        int i = Build.VERSION.SDK_INT;
        this.h.a(getTextDirection(), getTextAlignment());
    }
}
