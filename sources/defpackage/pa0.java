package defpackage;

import android.content.Context;
import android.text.TextUtils;
import com.xiaopeng.lib.framework.module.Module;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.ICounterFactory;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEvent;
import com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder;
import defpackage.sa0;
import java.util.List;
/* compiled from: DataLogService.java */
/* renamed from: pa0  reason: default package */
/* loaded from: classes.dex */
public class pa0 implements IDataLog {
    public Context a;

    /* compiled from: DataLogService.java */
    /* renamed from: pa0$b */
    /* loaded from: classes.dex */
    public class b implements IMoleEventBuilder {
        public qa0 a;

        public /* synthetic */ b(pa0 pa0Var, Context context, a aVar) {
            this.a = new qa0(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEvent build() {
            qa0 qa0Var = this.a;
            if (qa0Var.a.containsKey("page_id")) {
                if (qa0Var.a.containsKey("button_id")) {
                    if (qa0Var.a.containsKey(IStatEvent.CUSTOM_MODULE)) {
                        return this.a;
                    }
                    throw new IllegalArgumentException("Please call setModule() first");
                }
                throw new IllegalArgumentException("Please call setButtonId() first");
            }
            throw new IllegalArgumentException("Please call setPageId() first");
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setButtonId(String str) {
            this.a.a("button_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setEvent(String str) {
            this.a.a(IStatEvent.CUSTOM_MODULE, ra0.a(str));
            this.a.a(IStatEvent.CUSTOM_EVENT, str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setModule(String str) {
            this.a.a(IStatEvent.CUSTOM_MODULE, str);
            qa0 qa0Var = this.a;
            qa0Var.a(IStatEvent.CUSTOM_EVENT, str + "_page_button");
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setPageId(String str) {
            this.a.a("page_id", str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, String str2) {
            this.a.a(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, Number number) {
            this.a.a(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, boolean z) {
            this.a.a(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IMoleEventBuilder
        public IMoleEventBuilder setProperty(String str, char c) {
            this.a.a(str, Character.valueOf(c));
            return this;
        }
    }

    /* compiled from: DataLogService.java */
    /* renamed from: pa0$c */
    /* loaded from: classes.dex */
    public class c implements IStatEventBuilder {
        public IStatEvent a;

        public c(pa0 pa0Var, Context context) {
            this.a = new ra0(context);
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEvent build() {
            if (!TextUtils.isEmpty(this.a.getEventName())) {
                return this.a;
            }
            throw new IllegalStateException("Please call setEventName first!");
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setEventName(String str) {
            this.a.setEventName(str);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, String str2) {
            this.a.put(str, str2);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, Number number) {
            this.a.put(str, number);
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, boolean z) {
            this.a.put(str, Boolean.valueOf(z));
            return this;
        }

        @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IStatEventBuilder
        public IStatEventBuilder setProperty(String str, char c) {
            this.a.put(str, Character.valueOf(c));
            return this;
        }
    }

    public pa0(Context context) {
        cb0.b = new cb0(context);
        this.a = context;
        Module.register(oa0.class, new oa0(context));
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IMoleEventBuilder buildMoleEvent() {
        return new b(this, this.a, null);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public IStatEventBuilder buildStat() {
        return new c(this, this.a);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public ICounterFactory counterFactory() {
        return sa0.b.a;
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendCanData(String str) {
        cb0.a().a.a(str);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendFiles(List<String> list) {
        cb0.a().a.a(list);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public String sendRecentSystemLog() {
        return cb0.a().a.a();
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(String str, String str2) {
        cb0.a().a.a(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatOriginData(String str, String str2) {
        cb0.a().a.b(str, str2);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent) {
        cb0.a().a.a(iStatEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IMoleEvent iMoleEvent) {
        cb0.a().a.a(iMoleEvent);
    }

    @Override // com.xiaopeng.lib.framework.moduleinterface.datalogmodule.IDataLog
    public void sendStatData(IStatEvent iStatEvent, List<String> list) {
        cb0.a().a.a(iStatEvent, list);
    }
}
