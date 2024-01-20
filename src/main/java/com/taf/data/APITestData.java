package com.taf.data;

import java.util.Map;

public class APITestData extends TestRowData {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "APITestData [" +
                "id=" + id +
                ']';
    }
}
