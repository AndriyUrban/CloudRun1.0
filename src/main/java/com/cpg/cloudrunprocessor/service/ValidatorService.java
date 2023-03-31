package com.cpg.cloudrunprocessor.service;

import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {

    public static final String NONE_VALID = "NONE VALID INCOMING JSON-> {%s}";

    private static final Logger logger = LoggerFactory.getLogger(ValidatorService.class);

    @Autowired
    private JsonParser parser;

    public ValidatorService(JsonParser parser) {
        this.parser = parser;
    }

    public void validateIncomingMessage(String jsonString) {
        try {
            parser.parse(jsonString);
        } catch (JsonSyntaxException e) {
            logger.error(String.format(NONE_VALID, jsonString));
            throw new JsonSyntaxException(String
                    .format(NONE_VALID, jsonString), e);
        }
    }
}
