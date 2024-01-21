package com.taf.data;

import com.taf.config.PropertyFileReader;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

public class TestDataSupplier {

    private static final String TESTDATA_PATH = "src/main/resources/testdata/master-testdata.yaml";

    @DataProvider(name = "test_data_supplier")
    @SuppressWarnings("unchecked")
    public Object[][] getTestDataFromYamlFile(Method method) {
        Yaml yaml = new Yaml();
        MasterTestDataSet masterTestDataSet;
        try {
            masterTestDataSet = yaml.loadAs(new FileReader(TESTDATA_PATH), MasterTestDataSet.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String testCaseName = method.getName();
        List<TestDataSet> testCaseDataList = masterTestDataSet.getMasterTestDataSetMap().get(testCaseName);
        String testCaseToRun = PropertyFileReader.getPropertyData().getApi().get("testcases_to_be_run");
        System.out.println("=============== TestCase To Be Run From Category " + testCaseToRun + " ===============");
        List<Object> dataset = new ArrayList<>(testCaseDataList);
        List<Map<String, Object>> executionTestData = dataset.stream()
                .filter(element -> element instanceof Map)
                .map(element -> (Map<String, Object>) element)
                .filter(map -> testCaseToRun.equals(map.get("testCategory")))
                .toList();
        Object[][] data = new Object[executionTestData.size()][1];
        for (int i = 0; i < executionTestData.size(); i++) {
            Map<String, Object> map = executionTestData.get(i);
            data[i][0] = map;
        }
        return data;
    }

}
