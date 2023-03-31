package com.cpg.cloudrunprocessor.service;

import com.cpg.cloudrunprocessor.client.HttpClient;
import com.cpg.cloudrunprocessor.dto.ProductEntity;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


/**
 * Main service, goal of which is to validate incoming JSON,
 * and execute http call to "CloudRun2.0" app
 */
@Service
public class ServiceRepo {

    private static final Logger logger = LoggerFactory.getLogger(ServiceRepo.class);

    private final HttpClient client;

    private final ObjectMapper mapper;

    @Autowired
    public ServiceRepo(HttpClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }


    public void buyProduct(String json) {
        client.sendRequest(mapToObj(json));
    }

    @SneakyThrows
    private ProductEntity mapToObj(String json) {
        ProductEntity entity = mapper.readValue(json, ProductEntity.class);
        logger.info("Mapped json-> {} to obj ->{}",json,entity);
        return entity;
    }

}
