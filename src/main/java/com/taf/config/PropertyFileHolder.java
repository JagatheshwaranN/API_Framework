package com.taf.config;

import java.util.Map;

public class PropertyFileHolder {

    private Map<String, String> propMap;

    public Map<String, String> getPropMap() {
        return propMap;
    }

    public void setPropMap(Map<String, String> propMap) {
        this.propMap = propMap;
    }

    @Override
    public String toString() {
        return "PropertyFileHolder [" +
                "propMap=" + propMap +
                ']';
    }
}
