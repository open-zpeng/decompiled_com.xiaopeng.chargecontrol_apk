package defpackage;
/* compiled from: JsonAdapterAnnotationTypeAdapterFactory.java */
/* renamed from: mw  reason: default package */
/* loaded from: classes.dex */
public final class mw implements cv {
    public final pv c;

    public mw(pv pvVar) {
        this.c = pvVar;
    }

    public bv<?> a(pv pvVar, lu luVar, fx<?> fxVar, ev evVar) {
        bv<?> vwVar;
        Object a = pvVar.a(new fx(evVar.value())).a();
        if (a instanceof bv) {
            vwVar = (bv) a;
        } else if (a instanceof cv) {
            vwVar = ((cv) a).a(luVar, fxVar);
        } else {
            boolean z = a instanceof yu;
            if (!z && !(a instanceof qu)) {
                StringBuilder a2 = jg.a("Invalid attempt to bind an instance of ");
                a2.append(a.getClass().getName());
                a2.append(" as a @JsonAdapter for ");
                a2.append(fxVar.toString());
                a2.append(". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
                throw new IllegalArgumentException(a2.toString());
            }
            vwVar = new vw<>(z ? (yu) a : null, a instanceof qu ? (qu) a : null, luVar, fxVar, null);
        }
        return (vwVar == null || !evVar.nullSafe()) ? vwVar : vwVar.nullSafe();
    }

    @Override // defpackage.cv
    public <T> bv<T> a(lu luVar, fx<T> fxVar) {
        ev evVar = (ev) fxVar.a.getAnnotation(ev.class);
        if (evVar == null) {
            return null;
        }
        return (bv<T>) a(this.c, luVar, fxVar, evVar);
    }
}
