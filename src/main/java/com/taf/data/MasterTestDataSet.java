package com.taf.data;

import java.util.List;
import java.util.Map;

public class MasterTestDataSet {

    private Map<String, List<TestDataSet>> masterTestDataSet;

    public Map<String, List<TestDataSet>> getMasterTestDataSet() {
        return masterTestDataSet;
    }

    @SuppressWarnings("unused")
    public void setMasterTestDataSet(Map<String, List<TestDataSet>> masterTestDataSet) {
        this.masterTestDataSet = masterTestDataSet;
    }

    @Override
    public String toString() {
        return "MasterTestDataSet{" +
                "masterTestDataSet=" + masterTestDataSet +
                '}';
    }

}
