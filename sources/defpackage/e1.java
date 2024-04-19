package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayDeque;
import java.util.Deque;
import org.xmlpull.v1.XmlPullParser;
/* compiled from: LayoutIncludeDetector.java */
/* renamed from: e1  reason: default package */
/* loaded from: classes.dex */
public class e1 {
    public final Deque<WeakReference<XmlPullParser>> a = new ArrayDeque();

    /* JADX WARN: Removed duplicated region for block: B:19:0x0037 A[LOOP:0: B:7:0x0010->B:19:0x0037, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x003c A[EDGE_INSN: B:39:0x003c->B:21:0x003c ?: BREAK  , SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean a(android.util.AttributeSet r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof org.xmlpull.v1.XmlPullParser
            r1 = 0
            if (r0 == 0) goto L60
            org.xmlpull.v1.XmlPullParser r7 = (org.xmlpull.v1.XmlPullParser) r7
            int r0 = r7.getDepth()
            r2 = 1
            if (r0 != r2) goto L60
            java.util.Deque<java.lang.ref.WeakReference<org.xmlpull.v1.XmlPullParser>> r0 = r6.a
        L10:
            boolean r3 = r0.isEmpty()
            if (r3 != 0) goto L3b
            java.lang.Object r3 = r0.peek()
            java.lang.ref.WeakReference r3 = (java.lang.ref.WeakReference) r3
            java.lang.Object r3 = r3.get()
            org.xmlpull.v1.XmlPullParser r3 = (org.xmlpull.v1.XmlPullParser) r3
            if (r3 == 0) goto L34
            int r4 = r3.getEventType()     // Catch: org.xmlpull.v1.XmlPullParserException -> L34
            r5 = 3
            if (r4 == r5) goto L34
            int r4 = r3.getEventType()     // Catch: org.xmlpull.v1.XmlPullParserException -> L34
            if (r4 != r2) goto L32
            goto L34
        L32:
            r4 = r1
            goto L35
        L34:
            r4 = r2
        L35:
            if (r4 == 0) goto L3c
            r0.pop()
            goto L10
        L3b:
            r3 = 0
        L3c:
            java.util.Deque<java.lang.ref.WeakReference<org.xmlpull.v1.XmlPullParser>> r0 = r6.a
            java.lang.ref.WeakReference r4 = new java.lang.ref.WeakReference
            r4.<init>(r7)
            r0.push(r4)
            if (r3 == 0) goto L5c
            if (r7 == r3) goto L5c
            int r7 = r3.getEventType()     // Catch: org.xmlpull.v1.XmlPullParserException -> L5c
            r0 = 2
            if (r7 != r0) goto L5c
            java.lang.String r7 = "include"
            java.lang.String r0 = r3.getName()     // Catch: org.xmlpull.v1.XmlPullParserException -> L5c
            boolean r7 = r7.equals(r0)     // Catch: org.xmlpull.v1.XmlPullParserException -> L5c
            goto L5d
        L5c:
            r7 = r1
        L5d:
            if (r7 == 0) goto L60
            return r2
        L60:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.e1.a(android.util.AttributeSet):boolean");
    }
}
