package com.taf.config;

import java.util.Map;

public class PropertyFileHolder {

    private Map<String, String> apiDetail;

    public Map<String, String> getApiDetail() {
        return apiDetail;
    }

    @SuppressWarnings("unused")
    public void setApiDetail(Map<String, String> apiDetail) {
        this.apiDetail = apiDetail;
    }

    @Override
    public String toString() {
        return "PropertyFileHolder{" +
                "apiDetail=" + apiDetail +
                '}';
    }

}
