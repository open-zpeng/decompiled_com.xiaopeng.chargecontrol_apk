package com.xiaopeng.chargecontrol;

import android.util.Log;
import androidx.annotation.Keep;
import com.xiaopeng.lib.apirouter.server.ApplicationId;
import com.xiaopeng.lib.apirouter.server.IServicePublisher;
import com.xiaopeng.lib.apirouter.server.Publish;
import defpackage.o80;
import org.json.JSONObject;
@Keep
@ApplicationId("com.xiaopeng.chargecontrol")
/* loaded from: classes.dex */
public class ChargecontrolSpeechObserver implements IServicePublisher {
    public static final String TAG = "SpeechObserver";

    /* JADX WARN: Can't wrap try/catch for region: R(11:6|7|8|(9:26|27|(1:29)(2:30|(1:32))|11|15|16|(1:18)|20|22)|10|11|15|16|(0)|20|22) */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
        r5 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x004e, code lost:
        r5.printStackTrace();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0047 A[Catch: JSONException -> 0x004d, RemoteException -> 0x0061, TRY_LEAVE, TryCatch #2 {JSONException -> 0x004d, blocks: (B:23:0x003d, B:25:0x0047), top: B:38:0x003d, outer: #0 }] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v2, types: [org.json.JSONObject] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0034 -> B:21:0x0037). Please submit an issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void reply(java.lang.String r5, java.lang.String r6, java.lang.Object r7) {
        /*
            r4 = this;
            java.lang.String r0 = "result"
            boolean r1 = android.text.TextUtils.isEmpty(r5)
            if (r1 != 0) goto L78
            boolean r1 = android.text.TextUtils.isEmpty(r6)
            if (r1 != 0) goto L78
            if (r7 != 0) goto L11
            goto L78
        L11:
            android.net.Uri r6 = android.net.Uri.parse(r6)     // Catch: android.os.RemoteException -> L61
            android.net.Uri$Builder r6 = r6.buildUpon()     // Catch: android.os.RemoteException -> L61
            r1 = 0
            if (r7 != 0) goto L1d
            goto L37
        L1d:
            boolean r2 = r7 instanceof int[]     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            if (r2 == 0) goto L28
            r1 = 1
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            r2.<init>(r7)     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            goto L38
        L28:
            boolean r2 = r7 instanceof float[]     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            if (r2 == 0) goto L37
            r1 = 2
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            r2.<init>(r7)     // Catch: org.json.JSONException -> L33 android.os.RemoteException -> L61
            goto L38
        L33:
            r2 = move-exception
            r2.printStackTrace()     // Catch: android.os.RemoteException -> L61
        L37:
            r2 = r7
        L38:
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch: android.os.RemoteException -> L61
            r7.<init>()     // Catch: android.os.RemoteException -> L61
            java.lang.String r3 = "event"
            r7.put(r3, r5)     // Catch: org.json.JSONException -> L4d android.os.RemoteException -> L61
            r7.put(r0, r2)     // Catch: org.json.JSONException -> L4d android.os.RemoteException -> L61
            if (r1 <= 0) goto L51
            java.lang.String r5 = "classType"
            r7.put(r5, r1)     // Catch: org.json.JSONException -> L4d android.os.RemoteException -> L61
            goto L51
        L4d:
            r5 = move-exception
            r5.printStackTrace()     // Catch: android.os.RemoteException -> L61
        L51:
            java.lang.String r5 = r7.toString()     // Catch: android.os.RemoteException -> L61
            android.net.Uri$Builder r5 = r6.appendQueryParameter(r0, r5)     // Catch: android.os.RemoteException -> L61
            android.net.Uri r5 = r5.build()     // Catch: android.os.RemoteException -> L61
            com.xiaopeng.lib.apirouter.ApiRouter.route(r5)     // Catch: android.os.RemoteException -> L61
            goto L78
        L61:
            r5 = move-exception
            java.lang.String r6 = "reply: "
            java.lang.StringBuilder r6 = defpackage.jg.a(r6)
            java.lang.String r5 = r5.getMessage()
            r6.append(r5)
            java.lang.String r5 = r6.toString()
            java.lang.String r6 = "SpeechObserver"
            android.util.Log.e(r6, r5)
        L78:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaopeng.chargecontrol.ChargecontrolSpeechObserver.reply(java.lang.String, java.lang.String, java.lang.Object):void");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Publish
    public void onEvent(String str, String str2) {
        char c;
        Log.d(TAG, "onEvent() called with: event = [" + str + "], data = [" + str2 + "]");
        int i = 0;
        switch (str.hashCode()) {
            case -2034226179:
                if (str.equals("command://charge.smartchargeport.close")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case -1965971708:
                if (str.equals("command://charge.restart")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1734769001:
                if (str.equals("command://charge.start")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case -1609014560:
                if (str.equals("command://charge.change.wltp.mileage")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case -1589279835:
                if (str.equals("command://charge.smartchargeport.open")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case -1237470650:
                if (str.equals("command://charge.trankpower.power.on")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -1025791187:
                if (str.equals("command://charge.stop")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -898173837:
                if (str.equals("command://charge.mode.smart.close")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            case -879718580:
                if (str.equals("command://charge.port.open")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case -41146710:
                if (str.equals("command://charge.mode.smart.off")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 189571877:
                if (str.equals("command://charge.mode.percent")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 277827503:
                if (str.equals("command://charge.mode.full")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 293115368:
                if (str.equals("command://charge.trankpower.power.off")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 511246920:
                if (str.equals("command://charge.change.dynamic.mileage")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 552862020:
                if (str.equals("command://charge.mode.smart.on")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case 653816242:
                if (str.equals("command://charge.battery.display.percentage")) {
                    c = 21;
                    break;
                }
                c = 65535;
                break;
            case 747198041:
                if (str.equals("command://charge.ui.open")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 885958241:
                if (str.equals("command://charge.battery.display.number")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 970243195:
                if (str.equals("command://charge.discharge.limit.value.set")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1677111241:
                if (str.equals("command://charge.ui.close")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 2089286213:
                if (str.equals("command://charge.change.nedc.mileage")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 2126369895:
                if (str.equals("command://charge.change.cltc.mileage")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                o80.b.a.y();
                return;
            case 1:
                o80.b.a.A();
                return;
            case 2:
                o80.b.a.z();
                return;
            case 3:
                o80.b.a.B();
                return;
            case 4:
                o80.b.a.D();
                return;
            case 5:
                o80.b.a.C();
                return;
            case 6:
                try {
                    i = Integer.parseInt(new JSONObject(str2).optString("target"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
                o80.b.a.a(i);
                return;
            case 7:
                o80.b.a.u();
                return;
            case '\b':
                o80.b.a.x();
                return;
            case '\t':
                o80.b.a.v();
                return;
            case '\n':
                o80.b.a.w();
                return;
            case 11:
                o80.b.a.c("WLTP");
                return;
            case '\f':
                o80.b.a.c("NEDC");
                return;
            case '\r':
                o80.b.a.c("CLTC");
                return;
            case 14:
                o80.b.a.c("Dynamic");
                return;
            case 15:
                o80.b.a.a(true);
                return;
            case 16:
                o80.b.a.a(false);
                return;
            case 17:
                try {
                    i = Integer.parseInt(new JSONObject(str2).optString("target"));
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                o80.b.a.b(i);
                return;
            case 18:
                o80.b.a.d(0);
                return;
            case 19:
                o80.b.a.d(1);
                return;
            case 20:
                o80.b.a.c(0);
                return;
            case 21:
                o80.b.a.c(1);
                return;
            default:
                return;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Publish
    public void onQuery(String str, String str2, String str3) {
        char c;
        Log.d(TAG, "onQuery() called with: event = [" + str + "], data = [" + str2 + "], callback = [" + str3 + "]");
        switch (str.hashCode()) {
            case -1573444385:
                if (str.equals("charge.has.charging.order")) {
                    c = '\b';
                    break;
                }
                c = 65535;
                break;
            case -1051995197:
                if (str.equals("charge.get.restart.status")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case -909786873:
                if (str.equals("charge.get.trunk.power.status")) {
                    c = 15;
                    break;
                }
                c = 65535;
                break;
            case -649353844:
                if (str.equals("charge.support.open.port")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 133650785:
                if (str.equals("charge.limits.adjust.max")) {
                    c = 6;
                    break;
                }
                c = 65535;
                break;
            case 133651023:
                if (str.equals("charge.limits.adjust.min")) {
                    c = 5;
                    break;
                }
                c = 65535;
                break;
            case 146588932:
                if (str.equals("charge.has.sun.roof")) {
                    c = 14;
                    break;
                }
                c = 65535;
                break;
            case 208008097:
                if (str.equals("charge.support.smart.mode")) {
                    c = 7;
                    break;
                }
                c = 65535;
                break;
            case 317374728:
                if (str.equals("charge.has.car.refrigerator")) {
                    c = '\r';
                    break;
                }
                c = 65535;
                break;
            case 420332312:
                if (str.equals("powercenter.charge.status")) {
                    c = '\n';
                    break;
                }
                c = 65535;
                break;
            case 665776654:
                if (str.equals("charge.discharge.limit.max.value")) {
                    c = 17;
                    break;
                }
                c = 65535;
                break;
            case 1164694924:
                if (str.equals("charge.get.stop.status")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 1352058264:
                if (str.equals("gui.page.open.status.charge")) {
                    c = 11;
                    break;
                }
                c = 65535;
                break;
            case 1418118058:
                if (str.equals("charge.battery.display.style")) {
                    c = 20;
                    break;
                }
                c = 65535;
                break;
            case 1438255228:
                if (str.equals("charge.discharge.limit.min.value")) {
                    c = 16;
                    break;
                }
                c = 65535;
                break;
            case 1499862672:
                if (str.equals("charge.get.start.status")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 1605959122:
                if (str.equals("unity.page.open.status.charge")) {
                    c = '\f';
                    break;
                }
                c = 65535;
                break;
            case 1811976348:
                if (str.equals("charge.smartchargeport.status")) {
                    c = 19;
                    break;
                }
                c = 65535;
                break;
            case 1865070220:
                if (str.equals("charge.support.limits.adjust")) {
                    c = 4;
                    break;
                }
                c = 65535;
                break;
            case 1890968681:
                if (str.equals("charge.trunk.power.status.open")) {
                    c = 18;
                    break;
                }
                c = 65535;
                break;
            case 2074342788:
                if (str.equals("charge.is.ready.page")) {
                    c = '\t';
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                reply(str, str3, Boolean.valueOf(o80.b.a.s()));
                return;
            case 1:
                reply(str, str3, Integer.valueOf(o80.b.a.i()));
                return;
            case 2:
                reply(str, str3, Integer.valueOf(o80.b.a.j()));
                return;
            case 3:
                reply(str, str3, Integer.valueOf(o80.b.a.g()));
                return;
            case 4:
                o80.b.a.r();
                reply(str, str3, true);
                return;
            case 5:
                reply(str, str3, Integer.valueOf(o80.b.a.d()));
                return;
            case 6:
                reply(str, str3, Integer.valueOf(o80.b.a.c()));
                return;
            case 7:
                o80.b.a.t();
                reply(str, str3, false);
                return;
            case '\b':
                o80.b.a.q();
                reply(str, str3, false);
                return;
            case '\t':
                reply(str, str3, Boolean.valueOf(o80.b.a.p()));
                return;
            case '\n':
                reply(str, str3, Integer.valueOf(o80.b.a.a()));
                return;
            case 11:
                reply(str, str3, Integer.valueOf(o80.b.a.a(str2)));
                return;
            case '\f':
                o80.b.a.b(str2);
                reply(str, str3, 0);
                return;
            case '\r':
                reply(str, str3, Boolean.valueOf(o80.b.a.m()));
                return;
            case 14:
                reply(str, str3, Boolean.valueOf(o80.b.a.n()));
                return;
            case 15:
                reply(str, str3, Integer.valueOf(o80.b.a.k()));
                return;
            case 16:
                o80.b.a.f();
                reply(str, str3, 20);
                return;
            case 17:
                reply(str, str3, Integer.valueOf(o80.b.a.e()));
                return;
            case 18:
                reply(str, str3, Integer.valueOf(o80.b.a.l()));
                return;
            case 19:
                reply(str, str3, Integer.valueOf(o80.b.a.h()));
                return;
            case 20:
                reply(str, str3, Integer.valueOf(o80.b.a.b()));
                return;
            default:
                return;
        }
    }
}
