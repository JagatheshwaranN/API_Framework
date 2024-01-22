package com.taf.config;

public enum TestConstant {

    BASE_URL("base_url"),

    RESOURCE("resource"),

    TEST_CASE_RUN("testcases_to_be_run"),

    TEST_CATEGORY("testCategory"),

    PROPERTY_FILE_PATH("src/main/resources/propdata/properties.yaml"),

    TESTDATA_FILE_PATH("src/main/resources/testdata/master-testdata.yaml"),

    GET("get"),

    POST("post"),

    PUT("put"),

    DELETE("delete");

    private final String value;

    TestConstant(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
