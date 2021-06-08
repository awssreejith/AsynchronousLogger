package com.sreejith.AsyncLogging.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.Date;

@RestController
public class MyController {

    @Autowired
    private LoggerProxy loggerProxy;

    Logger logger = LoggerFactory.getLogger(MyController.class);


    @GetMapping("/getSomething")
    public ResponseEntity <String> helloGetter()
    {
        Date date = new Date();

        //Do an info log
        LoggerConsumer loggerConsumer = () -> logger.info(new Timestamp(date.getTime()).toString());
        loggerProxy.doSomeLoggingWork(loggerConsumer);

        //do  warning log
        loggerConsumer = () -> logger.warn(new Timestamp(date.getTime()).toString());
        loggerProxy.doSomeLoggingWork(loggerConsumer);

        //do  error log
        loggerConsumer = () -> logger.error(new Timestamp(date.getTime()).toString());
        loggerProxy.doSomeLoggingWork(loggerConsumer);

        //do an debug log
        loggerConsumer = () -> logger.debug(new Timestamp(date.getTime()).toString());
        loggerProxy.doSomeLoggingWork(loggerConsumer);

        return  ResponseEntity.status(HttpStatus.OK).body("Hello World");
    }
}

