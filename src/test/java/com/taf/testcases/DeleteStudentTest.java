package com.taf.testcases;

import com.google.gson.JsonObject;
import com.taf.data.TestDataSupplier;
import com.taf.process.StudentProcess;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.util.Map;

public class DeleteStudentTest {

    private static final Logger log = LogManager.getFormatterLogger(DeleteStudentTest.class);

    @Test(dataProvider = "test_data_supplier", dataProviderClass = TestDataSupplier.class)
    public void testDeleteStudent(Map<String, Object> testData) {
        int id = (Integer) testData.get("id");
        JsonObject jsonObject = StudentProcess.deleteStudentDetail(id);
        log.info(jsonObject);
    }

}
