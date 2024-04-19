package defpackage;

import com.xiaopeng.libconfig.settings.SettingsUtil;
/* compiled from: VuiFeedbackType.java */
/* renamed from: nc0  reason: default package */
/* loaded from: classes.dex */
public enum nc0 {
    SOUND(SettingsUtil.PAGE_SOUND),
    TTS("Tts");
    
    public String c;

    nc0(String str) {
        this.c = str;
    }
}
