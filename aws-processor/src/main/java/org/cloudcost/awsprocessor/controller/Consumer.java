package org.cloudcost.awsprocessor.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.cloudcost.awsprocessor.model.RequestProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    Logger logger = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private ObjectMapper objectMapper;

    @RabbitListener(queues = "aws.processing.request")
    public void consume(String requestProcess) throws JsonProcessingException {

        RequestProcess requestProcess1 = objectMapper.readValue(requestProcess, RequestProcess.class);

        logger.info(requestProcess.toString());

    }

}
