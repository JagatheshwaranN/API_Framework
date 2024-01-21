package com.taf.data;

public class TestDataSet {

    private String testCaseData;

    @SuppressWarnings("unused")
    public String getTestCaseData() {
        return testCaseData;
    }

    @SuppressWarnings("unused")
    public void setTestCaseData(String testCaseData) {
        this.testCaseData = testCaseData;
    }

    @Override
    public String toString() {
        return "TestDataSet{" +
                "testCaseData='" + testCaseData + '\'' +
                '}';
    }

}
