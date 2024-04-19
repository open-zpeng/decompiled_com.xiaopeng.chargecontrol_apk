package defpackage;

import android.text.TextUtils;
import com.xiaopeng.libconfig.ipc.cfc.CFCHelper;
import java.util.List;
import org.json.JSONObject;
/* compiled from: VuiElement.java */
/* renamed from: sc0  reason: default package */
/* loaded from: classes.dex */
public class sc0 implements Cloneable {
    public uu actions;
    public rc0 animation;
    public List<sc0> elements;
    public Boolean enabled;
    public String fatherElementId;
    public String fatherLabel;
    public String feedbackType;
    public String id;
    public String label;
    public Boolean layoutLoadable;
    public String mode;
    public int position;
    public int priority;
    public uu props;
    public String resourceName;
    public List<String> resultActions;
    public long timestamp;
    public String type;
    public Object values;
    public Boolean visible;

    /* compiled from: VuiElement.java */
    /* renamed from: sc0$a */
    /* loaded from: classes.dex */
    public static class a {
        public String a = null;
        public String b = "";
        public String c = null;
        public long d = System.currentTimeMillis();
        public uu e = null;
        public Boolean f = null;
        public Boolean g = null;
        public Object h = null;
        public uu i = null;
        public String j = null;

        public a a(String str) {
            this.e = sc0.getElementAction(str);
            return this;
        }
    }

    public sc0() {
        this.id = null;
        this.fatherElementId = null;
        this.label = "";
        this.fatherLabel = null;
        this.values = null;
        this.props = null;
        this.type = null;
        this.actions = null;
        this.layoutLoadable = null;
        this.resourceName = null;
        this.mode = null;
        this.resultActions = null;
        this.position = -1;
        this.visible = null;
        this.enabled = null;
        this.feedbackType = null;
        this.timestamp = -1L;
        this.priority = -1;
        this.elements = null;
    }

    public static uu getElementAction(String str) {
        if (str == null) {
            return null;
        }
        String[] split = str.split("\\|");
        JSONObject jSONObject = new JSONObject();
        List<String> a2 = lc0.a();
        List<String> a3 = kc0.a();
        for (int i = 0; i < split.length; i++) {
            if (split[i].contains(":")) {
                int indexOf = split[i].indexOf(":");
                String substring = split[i].substring(0, indexOf);
                if (a2.contains(substring)) {
                    String[] split2 = split[i].substring(indexOf + 1).split(CFCHelper.SIGNAL_CFC_SPLIT);
                    if (split2.length < 2) {
                        return null;
                    }
                    try {
                        if (a3.contains(split2[0])) {
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("actType", split2[0]);
                            jSONObject2.put("bizType", split2[1]);
                            jSONObject.put(substring, jSONObject2);
                        }
                    } catch (Exception unused) {
                    }
                }
                return null;
            } else if (!a2.contains(split[i])) {
                return null;
            } else {
                jSONObject.put(split[i], new JSONObject());
            }
        }
        return (uu) new lu().a(jSONObject.toString(), (Class<Object>) uu.class);
    }

    private boolean isEqualsOfBoolean(Boolean bool, Boolean bool2) {
        if (bool == null && bool2 == null) {
            return true;
        }
        return (bool == null || bool2 == null || bool.booleanValue() != bool2.booleanValue()) ? false : true;
    }

    private boolean isEqualsOfJson(Object obj, Object obj2) {
        if (obj == null && obj2 == null) {
            return true;
        }
        return (obj == null || obj2 == null || !obj.equals(obj2)) ? false : true;
    }

    private boolean isEqualsOfString(String str, String str2) {
        if (TextUtils.isEmpty(str) && TextUtils.isEmpty(str2)) {
            return true;
        }
        return (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !str.equals(str2)) ? false : true;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof sc0) {
            sc0 sc0Var = (sc0) obj;
            if (isEqualsOfString(this.type, sc0Var.getType()) && isEqualsOfString(this.label, sc0Var.getLabel()) && isEqualsOfString(this.fatherElementId, sc0Var.getFatherElementId()) && isEqualsOfString(this.fatherLabel, sc0Var.getFatherLabel()) && isEqualsOfString(this.mode, sc0Var.getMode()) && isEqualsOfString(this.resourceName, sc0Var.getResourceName()) && this.position == sc0Var.getPosition() && this.priority == sc0Var.getPriority() && isEqualsOfBoolean(this.layoutLoadable, sc0Var.layoutLoadable) && isEqualsOfBoolean(this.visible, sc0Var.visible) && isEqualsOfJson(this.actions, sc0Var.actions) && isEqualsOfJson(this.props, sc0Var.props) && isEqualsOfJson(this.values, sc0Var.values)) {
                if (this.elements == null && sc0Var.getElements() == null) {
                    return true;
                }
                if (this.elements == null || sc0Var.getElements() == null || this.elements.size() != sc0Var.getElements().size()) {
                    return false;
                }
                for (int i = 0; i < this.elements.size(); i++) {
                    if (!this.elements.get(i).equals(sc0Var.elements.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public uu getActions() {
        return this.actions;
    }

    public rc0 getAnimation() {
        return null;
    }

    public List<sc0> getElements() {
        return this.elements;
    }

    public String getFatherElementId() {
        return this.fatherElementId;
    }

    public String getFatherLabel() {
        return this.fatherLabel;
    }

    public String getFeedbackType() {
        return this.feedbackType;
    }

    public String getId() {
        return this.id;
    }

    public String getLabel() {
        return this.label;
    }

    public String getMode() {
        return this.mode;
    }

    public int getPosition() {
        return this.position;
    }

    public int getPriority() {
        return this.priority;
    }

    public uu getProps() {
        return this.props;
    }

    public String getResourceName() {
        return this.resourceName;
    }

    public List<String> getResultActions() {
        return this.resultActions;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getType() {
        return this.type;
    }

    public Object getValues() {
        return this.values;
    }

    public Boolean isEnabled() {
        return this.enabled;
    }

    public Boolean isLayoutLoadable() {
        return this.layoutLoadable;
    }

    public Boolean isVisible() {
        return this.visible;
    }

    public void setActions(String str) {
        this.actions = getElementAction(str);
    }

    public void setAnimation(rc0 rc0Var) {
    }

    public void setElements(List<sc0> list) {
        this.elements = list;
    }

    public void setEnabled(Boolean bool) {
        this.enabled = bool;
    }

    public void setFatherElementId(String str) {
        this.fatherElementId = str;
    }

    public void setFatherLabel(String str) {
        this.fatherLabel = str;
    }

    public void setFeedbackType(String str) {
        this.feedbackType = str;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLabel(String str) {
        this.label = str;
    }

    public void setLayoutLoadable(Boolean bool) {
        this.layoutLoadable = bool;
    }

    public void setMode(String str) {
        this.mode = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public void setProps(uu uuVar) {
        this.props = uuVar;
    }

    public void setResourceName(String str) {
        this.resourceName = str;
    }

    public void setResultActions(List<String> list) {
        this.resultActions = list;
    }

    public void setTimestamp(long j) {
        this.timestamp = j;
    }

    public void setType(String str) {
        this.type = str;
    }

    public void setValues(Object obj) {
        this.values = obj;
    }

    public void setVisible(Boolean bool) {
        this.visible = bool;
    }

    public String toString() {
        StringBuilder a2 = jg.a("VuiElement{id='");
        jg.a(a2, this.id, '\'', ", fatherElementId='");
        jg.a(a2, this.fatherElementId, '\'', ", label='");
        jg.a(a2, this.label, '\'', ", fatherLabel='");
        jg.a(a2, this.fatherLabel, '\'', ", values=");
        a2.append(this.values);
        a2.append(", props=");
        a2.append(this.props);
        a2.append(", type='");
        jg.a(a2, this.type, '\'', ", actions=");
        a2.append(this.actions);
        a2.append(", layoutLoadable=");
        a2.append(this.layoutLoadable);
        a2.append(", resourceName='");
        jg.a(a2, this.resourceName, '\'', ", mode='");
        jg.a(a2, this.mode, '\'', ", resultActions=");
        a2.append(this.resultActions);
        a2.append(", animation=");
        a2.append("");
        a2.append(", position=");
        a2.append(this.position);
        a2.append(", visible=");
        a2.append(this.visible);
        a2.append(", enabled=");
        a2.append(this.enabled);
        a2.append(", feedbackType='");
        jg.a(a2, this.feedbackType, '\'', ", timestamp=");
        a2.append(this.timestamp);
        a2.append(", priority=");
        a2.append(this.priority);
        a2.append(", elements=");
        a2.append(this.elements);
        a2.append('}');
        return a2.toString();
    }

    public sc0 clone() {
        try {
            return (sc0) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public sc0(a aVar) {
        this.id = null;
        this.fatherElementId = null;
        this.label = "";
        this.fatherLabel = null;
        this.values = null;
        this.props = null;
        this.type = null;
        this.actions = null;
        this.layoutLoadable = null;
        this.resourceName = null;
        this.mode = null;
        this.resultActions = null;
        this.position = -1;
        this.visible = null;
        this.enabled = null;
        this.feedbackType = null;
        this.timestamp = -1L;
        this.priority = -1;
        this.elements = null;
        this.type = aVar.a;
        this.label = aVar.b;
        this.id = aVar.c;
        this.timestamp = aVar.d;
        this.actions = aVar.e;
        this.visible = aVar.f;
        this.enabled = aVar.g;
        this.props = aVar.i;
        this.values = aVar.h;
        this.resourceName = aVar.j;
    }
}
