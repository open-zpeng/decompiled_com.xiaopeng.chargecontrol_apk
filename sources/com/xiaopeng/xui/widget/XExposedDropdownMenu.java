package com.xiaopeng.xui.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.xiaopeng.libtheme.ThemeManager;
/* loaded from: classes.dex */
public class XExposedDropdownMenu extends XTextView implements AdapterView.OnItemClickListener {
    public PopupWindow i;
    public ListView j;
    public ArrayAdapter<String> k;
    public a l;
    public final int m;
    public final int n;
    public int o;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str);
    }

    public XExposedDropdownMenu(Context context) {
        this(context, null);
    }

    private void setDropdownHeight(int i) {
        int i2;
        if (i > 5) {
            i2 = ee0.a(408.0f);
        } else if (i > 0) {
            i2 = ee0.a(((i - 1) * 2) + (i * 80));
        } else {
            i2 = 0;
        }
        this.i.setHeight(i2);
    }

    public String b(int i) {
        return (i < 0 || i >= this.k.getCount()) ? "" : this.k.getItem(i);
    }

    public int getSelection() {
        return this.o;
    }

    public String getSelectionTitle() {
        return b(getSelection());
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        w();
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (ThemeManager.isThemeChanged(configuration)) {
            w();
        }
    }

    @Override // com.xiaopeng.xui.widget.XTextView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        setSelection(i);
        String b = b(i);
        a aVar = this.l;
        if (aVar != null) {
            aVar.a(i, b);
        }
        if (this.i.isShowing()) {
            this.i.dismiss();
        }
    }

    public void setEntries(String[] strArr) {
        this.k.clear();
        if (strArr != null && strArr.length > 0) {
            this.k.addAll(strArr);
            setSelection(0);
        }
        setDropdownHeight(this.k.getCount());
    }

    public void setOnItemClickListener(a aVar) {
        this.l = aVar;
    }

    public void setSelection(int i) {
        if (i < 0 || i >= this.k.getCount()) {
            return;
        }
        this.o = i;
        setText(b(i));
    }

    public final void w() {
        ListView listView = this.j;
        if (listView != null) {
            listView.setBackground(getContext().getDrawable(xc0.x_exposed_dropdown_menu_list_bg));
            this.j.setDivider(getContext().getDrawable(xc0.x_exposed_dropdown_menu_divider));
        }
    }

    public XExposedDropdownMenu(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public XExposedDropdownMenu(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, 0);
        this.m = ee0.a(16.0f) - getResources().getDimensionPixelOffset(wc0.x_exposed_dropdown_menu_inset_vertical);
        this.n = getResources().getDimensionPixelOffset(wc0.x_exposed_dropdown_menu_inset_horizontal);
        this.o = 0;
        TypedArray obtainAttributes = getResources().obtainAttributes(attributeSet, dd0.XExposedDropdownMenu);
        CharSequence[] textArray = obtainAttributes.getTextArray(dd0.XExposedDropdownMenu_edmDropdownEntries);
        int integer = obtainAttributes.getInteger(dd0.XExposedDropdownMenu_edmDropdownSelection, 0);
        this.k = new ArrayAdapter<>(getContext(), ad0.x_exposed_dropdown_menu_item);
        this.i = new PopupWindow(getContext());
        View inflate = LayoutInflater.from(getContext()).inflate(ad0.x_exposed_dropdown_menu_list, (ViewGroup) null);
        this.i.setContentView(inflate);
        this.j = (ListView) inflate.findViewById(yc0.list_view);
        this.i.setBackgroundDrawable(new ColorDrawable(0));
        this.i.setOutsideTouchable(true);
        this.i.setClippingEnabled(false);
        this.j.setAdapter((ListAdapter) this.k);
        this.j.setOnItemClickListener(this);
        setEntries(textArray);
        setSelection(integer);
        setOnClickListener(new pf0(this));
        obtainAttributes.recycle();
    }

    public void setEntries(CharSequence[] charSequenceArr) {
        this.k.clear();
        if (charSequenceArr != null && charSequenceArr.length > 0) {
            for (CharSequence charSequence : charSequenceArr) {
                this.k.add(charSequence.toString());
            }
            setSelection(0);
        }
        setDropdownHeight(this.k.getCount());
    }
}
