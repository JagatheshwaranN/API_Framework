package com.taf.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.taf.config.PropertyFileReader;
import org.testng.annotations.DataProvider;
import org.yaml.snakeyaml.Yaml;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

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

        System.out.println(masterTestDataSet.toString());

        String testCaseName = method.getName();

        List<TestRowData> testRowDataList = masterTestDataSet.getMasterTestDataSetMap().get(testCaseName);
        System.out.println("testRowDataList : "+ testRowDataList);

        String testCaseToRun = PropertyFileReader.getPropertyData().getApi().get("testcases_to_be_run");

        System.out.println("=============== TestCase To Be Run From Category " + testCaseToRun + " ===============");

        List<Object> dataset = new ArrayList<>(testRowDataList);

//        for (Object element : dataset) {
//            if (element instanceof Map) {
//                @SuppressWarnings("unchecked")
//                Map<String, Object> castedMap = (Map<String, Object>) element;
//                System.out.println("Casted Map: " + castedMap);
//                System.out.println(castedMap.get("testCategory"));
//            } else {
//                System.out.println("One of the elements is not a Map");
//            }
//        }
        System.out.println(dataset);

        List<Map<String, Object>> regTests = dataset.stream()
                .filter(element -> element instanceof Map)
                .map(element -> (Map<String, Object>) element)
                .filter(map -> testCaseToRun.equals(map.get("testCategory")))
                .toList();

        System.out.println("Filtered Reg Tests: " + regTests);

        List<Object> extractedValues = regTests.stream()
                .map(Map::values) // Get the values of each map
                .flatMap(Collection::stream) // Flatten the stream of collections
                .toList();

        Object[][] data = new Object[extractedValues.size()][1];

        for(int i = 0; i < extractedValues.size(); i++){
            data[i][0] = extractedValues.get(i);
        }
        System.out.println("Data : "+ Arrays.deepToString(data));
        return data;
    }


}
