package com.xiaopeng.speech.vui.model;

import com.xiaopeng.speech.vui.utils.LogUtils;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class VuiEventImpl extends tc0 {
    public sc0 data;
    public String userQuery = null;
    public String eventName = null;
    public String props = null;

    public VuiEventImpl(sc0 sc0Var) {
        this.data = null;
        this.data = sc0Var;
    }

    private boolean isLeafNode(sc0 sc0Var) {
        return (sc0Var == null || sc0Var.getResultActions() == null || sc0Var.getResultActions().isEmpty()) ? false : true;
    }

    public String getEventName() {
        return this.eventName;
    }

    @Override // defpackage.tc0
    public <T> T getEventValue(tc0 tc0Var) {
        sc0 hitVuiElement;
        Map map;
        LogUtils.logDebug("getEventValue", new lu().a(tc0Var));
        if (tc0Var != null && (hitVuiElement = tc0Var.getHitVuiElement()) != null && hitVuiElement.getResultActions() != null && !hitVuiElement.getResultActions().isEmpty()) {
            Object obj = (String) hitVuiElement.getResultActions().get(0);
            if ((hitVuiElement.getValues() instanceof bw) && (map = (Map) hitVuiElement.getValues()) != null) {
                if (map.get(obj) instanceof bw) {
                    Map map2 = (Map) map.get(obj);
                    if (map2 != null) {
                        if (map2.containsKey("value")) {
                            if (map2.get("value") != null) {
                                return (T) map2.get("value");
                            }
                        } else if (map2.containsKey("index") && map2.get("index") != null) {
                            return (T) map2.get("index");
                        }
                    }
                } else if (map.get(map) != null) {
                    return (T) map.get("value");
                }
            }
        }
        return null;
    }

    @Override // defpackage.tc0
    public sc0 getHitVuiElement() {
        sc0 sc0Var = this.data;
        if (sc0Var != null) {
            if (sc0Var.getResultActions() != null && !this.data.getResultActions().isEmpty()) {
                return this.data;
            }
            List<sc0> hitVuiElements = getHitVuiElements(this.data.getElements());
            if (hitVuiElements == null || hitVuiElements.isEmpty()) {
                return null;
            }
            return hitVuiElements.get(0);
        }
        return null;
    }

    @Override // defpackage.tc0
    public List<sc0> getHitVuiElements(List<sc0> list) {
        if (list == null || list.isEmpty() || isLeafNode(list.get(0))) {
            return list;
        }
        if (list.get(0) == null) {
            return null;
        }
        return getHitVuiElements(list.get(0).getElements());
    }

    public sc0 getMetaData() {
        return this.data;
    }

    public String getProps() {
        return this.props;
    }

    public String getUserQuery() {
        return this.userQuery;
    }

    public void setData(sc0 sc0Var) {
        this.data = sc0Var;
    }

    public void setEventName(String str) {
        this.eventName = str;
    }

    public void setProps(String str) {
        this.props = str;
    }

    public void setUserQuery(String str) {
        this.userQuery = str;
    }
}
