package com.taf.data;

public class APITestData extends TestCategoryData {

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
