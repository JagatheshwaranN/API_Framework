package com.taf.data;

import com.taf.config.PropertyFileReader;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.taf.data.MasterTestDataSet;
import org.yaml.snakeyaml.constructor.Constructor;

public class TestDataSupplier {

    private static final String TESTDATA_PATH = "src/main/resources/testdata/master-testdata.yaml";

    @DataProvider(name="test_data_supplier")
    public Object[][] getTestDataFromYamlFile(Method method) {

        Yaml yaml = new Yaml();
        MasterTestDataSet masterTestDataSet = null;

        try {
            masterTestDataSet = yaml.loadAs(new FileReader(TESTDATA_PATH), MasterTestDataSet.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String testCaseName = method.getName();

        List<TestCategoryData> testCategoryDataList = masterTestDataSet.getMasterTestDataSetMap().get(testCaseName);
        System.out.println("testCategoryDataList : "+testCategoryDataList);

        String testCaseToRun = PropertyFileReader.getPropertyData().getApi().get("testcases_to_be_run");

        System.out.println("=============== TestCase To Be Run From Category " + testCaseToRun + " ===============");

//        testCategoryDataList = testCategoryDataList.stream()
//                .filter(data -> data.getTestCategory().contains(testCaseToRun))
//                .collect(Collectors.toList());
        System.out.println(testCategoryDataList.get(0));
//        testCategoryDataList = testCategoryDataList.stream()
//                .filter(data ->
//                        data != null &&
//                                data.getTestCategory() != null &&
//                                data.getTestCategory().contains(testCaseToRun))
//                .collect(Collectors.toList());
//
//

        testCategoryDataList = new ArrayList<>(masterTestDataSet.getMasterTestDataSetMap().get(testCaseName));

        Object[][] data = new Object[testCategoryDataList.size()][1];

        for(int i = 0; i < testCategoryDataList.size(); i++){
            data[i][0] = testCategoryDataList.get(i);
        }
        System.out.println("Data : "+ Arrays.deepToString(data));
        System.out.println("Returned data from data provider:");
        for (Object[] data1 : data) {
            for (Object item : data1) {
                System.out.println(item);
            }
        }
        return data;
    }

    private static List<Object> retrieveValues(List<Map<String, Object>> listOfMaps) {
        List<Object> valuesList = new ArrayList<>();

        for (Map<String, Object> map : listOfMaps) {
            // Iterate through the values in each map and add them to the valuesList
            valuesList.addAll(map.values());
        }

        return valuesList;
    }

}
