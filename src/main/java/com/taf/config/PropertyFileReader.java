package com.taf.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class PropertyFileReader {

    public static PropertyFileHolder getPropertyData(){
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        PropertyFileHolder propertyFileHolder;
        try{
            File file = new File(TestConstant.PROPERTY_FILE_PATH.getValue());
            propertyFileHolder = objectMapper.readValue(file, PropertyFileHolder.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return propertyFileHolder;
    }

}
