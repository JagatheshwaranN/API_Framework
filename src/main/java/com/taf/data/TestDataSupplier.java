package com.taf.data;

import com.taf.config.PropertyFileReader;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.List;
import java.util.stream.Collectors;

import com.taf.data.MasterTestDataSet;

public class TestDataSupplier {

    private static final String TESTDATA_PATH = "src/main/resources/testdata/master-testdata.yaml";

    @DataProvider(name="test_data_supplier")
    public Object[][] getTestDataFromYamlFile(Method method) {

        Yaml yaml = new Yaml();
        MasterTestDataSet masterTestDataSet = null;

        try {
            masterTestDataSet = yaml.loadAs(new FileReader(new File(TESTDATA_PATH)), MasterTestDataSet.class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        String testCaseName = method.getName();

        List<TestCategoryData> testCategoryDataList = masterTestDataSet.getMasterTestDataSetMap().get(testCaseName);

        String testCaseToRun = PropertyFileReader.getPropertyData().getPropMap().get("testcases_to_be_run");

        System.out.println("=============== TestCase To Be Run From Category " + testCaseToRun + " ===============");

        testCategoryDataList = testCategoryDataList.stream()
                .filter(data -> data.getTestCategory().contains(testCaseToRun))
                .collect(Collectors.toList());

        Object[][] data = new Object[testCategoryDataList.size()][1];

        for(int i = 0; i < testCategoryDataList.size(); i++){
            data[i][0] = testCategoryDataList.get(i);
        }
        return data;
    }

}
