package com.taf.data;

import java.util.List;
import java.util.Map;

public class MasterTestDataSet {

    private Map<String, List<TestRowData>> masterTestDataSetMap;

    public Map<String, List<TestRowData>> getMasterTestDataSetMap() {
        return masterTestDataSetMap;
    }

    public void setMasterTestDataSetMap(Map<String, List<TestRowData>> masterTestDataSetMap) {
        this.masterTestDataSetMap = masterTestDataSetMap;
    }

    @Override
    public String toString() {
        return "MasterTestDataSet{" +
                "masterTestDataSetMap=" + masterTestDataSetMap +
                '}';
    }
}
