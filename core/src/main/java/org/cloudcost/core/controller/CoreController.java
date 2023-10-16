package org.cloudcost.core.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cloudcost.core.model.RequestProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class CoreController {

    Logger logger = LoggerFactory.getLogger(CoreController.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("request/aws/{id}")
    public String processDataAws(@PathVariable("id") Long id) throws JsonProcessingException {
        RequestProcess requestProcess = new RequestProcess();
        requestProcess.setId(id);
        requestProcess.setType("aws");
        requestProcess.setDate(LocalDateTime.now());

        String message = objectMapper.writeValueAsString(requestProcess);
        rabbitTemplate.convertAndSend("aws.processing.request", message);

        logger.info(requestProcess.toString() + " => enviada");
        return "OK";

    }

}
