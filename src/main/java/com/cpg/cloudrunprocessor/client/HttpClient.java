package com.cpg.cloudrunprocessor.client;

import com.cpg.cloudrunprocessor.dto.ProductEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClient {

    private static final String URL = "URL_TO_CLOUD_RUN_TWO";

    private static final String LOG_MESSAGE = "Sending: {}";

    private static final Logger logger = LoggerFactory.getLogger(HttpClient.class);

    @Autowired
    private RestTemplate template;

    public void sendRequest(ProductEntity entity) {
        HttpHeaders headers = createHeaders();
        HttpEntity<ProductEntity> requestEntity = new HttpEntity<>(entity, headers);
        logger.info(LOG_MESSAGE,requestEntity);
        //template.postForEntity(URL, requestEntity, String.class);
    }

    private static HttpHeaders createHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setDate(System.currentTimeMillis());
        return headers;
    }

}
