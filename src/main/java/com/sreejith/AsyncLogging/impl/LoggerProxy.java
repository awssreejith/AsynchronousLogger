package com.sreejith.AsyncLogging.impl;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LoggerProxy  {

    @Async
    public void doSomeLoggingWork(LoggerConsumer loggerConsumer)
    {
        loggerConsumer.printLog();
    }

}
