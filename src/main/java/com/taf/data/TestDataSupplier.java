package com.taf.data;

import com.taf.config.PropertyFileReader;
import com.taf.config.TestConstant;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;

public class TestDataSupplier {



    @DataProvider(name = "test_data_supplier")
    @SuppressWarnings("unchecked")
    public Object[][] getTestDataFromYamlFile(Method method) {
        Yaml yaml = new Yaml();
        MasterTestDataSet masterTestDataSet;
        try {
            masterTestDataSet = yaml.loadAs(new FileReader(TestConstant.TESTDATA_FILE_PATH), MasterTestDataSet.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        String testCaseName = method.getName();
        List<TestDataSet> testCaseDataList = masterTestDataSet.getMasterTestDataSet().get(testCaseName);
        String testCaseToRun = PropertyFileReader.getPropertyData().getApiDetail().get(TestConstant.TEST_CASE_RUN);
        System.out.println("=============== TestCase To Be Run From Category " + testCaseToRun + " ===============");
        List<Object> dataset = new ArrayList<>(testCaseDataList);
        List<Map<String, Object>> executionTestData = dataset.stream()
                .filter(element -> element instanceof Map)
                .map(element -> (Map<String, Object>) element)
                .filter(map -> testCaseToRun.equals(map.get(TestConstant.TEST_CATEGORY)))
                .toList();
        Object[][] data = new Object[executionTestData.size()][1];
        for (int i = 0; i < executionTestData.size(); i++) {
            Map<String, Object> map = executionTestData.get(i);
            data[i][0] = map;
        }
        return data;
    }

}
