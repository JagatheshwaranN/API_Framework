package com.taf.config;

import java.util.Map;

public class PropertyFileHolder {

    private Map<String, String> api;

    public Map<String, String> getApi() {
        return api;
    }

    public void setApi(Map<String, String> api) {
        this.api = api;
    }

    @Override
    public String toString() {
        return "PropertyFileHolder{" +
                "api=" + api +
                '}';
    }

}
