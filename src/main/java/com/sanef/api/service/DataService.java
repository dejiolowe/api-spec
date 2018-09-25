package com.sanef.api.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;

@Service
@Slf4j
public class DataService {

    @Value("${SANEF_HOME:}")
    private String SANEF_HOME;

    @Autowired
    protected ApplicationEventPublisher eventPublisher;

    private ObjectMapper objectMapper;


    private File getOBNDataFile(String dataFile) throws Exception {
        if (StringUtils.isEmpty(SANEF_HOME)) {
            ClassPathResource classPathResource = new ClassPathResource(String.format("SANEF_HOME/data/%s", dataFile));
            return classPathResource.getFile();
        } else {
            return new File(SANEF_HOME);
        }
    }

    protected <T> T getData(String fileName, Class<T> type) {
        try {
            return this.objectMapper.readValue(getOBNDataFile(fileName), type);
        } catch (Exception e) {
            log.warn("Cannot convert json data for {} using file {}", type, fileName);
            log.error(null, e);
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
