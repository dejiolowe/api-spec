package com.sanef.api.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
public class DataService {

    @Value("${OPB_HOME:}")
    private String OPB_HOME;

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    private ObjectMapper objectMapper;


    private File getOBNDataFile(String dataFile) throws Exception {
        if (StringUtils.isEmpty(OPB_HOME)) {
            ClassPathResource classPathResource = new ClassPathResource(String.format("OPB_HOME/data/%s", dataFile));
            return classPathResource.getFile();
        } else {
            return new File(OPB_HOME);
        }
    }

    protected <T> T getData(String fileName, Class<T> type) {
        try {
            return this.objectMapper.readValue(getOBNDataFile(fileName), type);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostConstruct
    protected void init() {
        this.objectMapper = new ObjectMapper();
        this.objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        this.objectMapper.disable(SerializationFeature.INDENT_OUTPUT);
        this.objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
