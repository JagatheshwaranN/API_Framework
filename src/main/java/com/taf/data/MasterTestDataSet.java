package com.taf.data;

import java.util.List;
import java.util.Map;

public class MasterTestDataSet {

    private Map<String, List<TestDataSet>> masterTestDataSetMap;

    public Map<String, List<TestDataSet>> getMasterTestDataSetMap() {
        return masterTestDataSetMap;
    }

    @SuppressWarnings("unused")
    public void setMasterTestDataSetMap(Map<String, List<TestDataSet>> masterTestDataSetMap) {
        this.masterTestDataSetMap = masterTestDataSetMap;
    }

    @Override
    public String toString() {
        return "MasterTestDataSet{" +
                "masterTestDataSetMap=" + masterTestDataSetMap +
                '}';
    }
}
