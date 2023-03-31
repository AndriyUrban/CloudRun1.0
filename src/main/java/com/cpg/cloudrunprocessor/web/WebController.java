package com.cpg.cloudrunprocessor.web;

import com.cpg.cloudrunprocessor.dto.ProductEntity;
import com.cpg.cloudrunprocessor.service.ServiceRepo;
import com.cpg.cloudrunprocessor.service.ValidatorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/public")
public class WebController {

    private static final Logger logger = LoggerFactory.getLogger(WebController.class);

    public static final String ENDPOINT_WAS_SUCCESSFULLY_REACHED = "Endpoint was successfully reached";

    public static final String HEALTHY = "Healthy";

    @Autowired
    private ServiceRepo service;

    @Autowired
    private ValidatorService validator;

    @PostMapping("/buy")
    @ResponseBody
    public ResponseEntity<HttpStatus> createProduct(String incomingString) {
        logger.info(ENDPOINT_WAS_SUCCESSFULLY_REACHED);
        validator.validateIncomingMessage(incomingString);
        service.buyProduct(incomingString);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/alive")
    @ResponseBody
    public String healthCheck() {
        logger.info(ENDPOINT_WAS_SUCCESSFULLY_REACHED);
        return HEALTHY;
    }
}
