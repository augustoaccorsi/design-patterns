package com.augustoaccorsi.chapter2.decorator;

import com.augustoaccorsi.chapter2.decorator.logger.LogMessage;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.json.bind.JsonbBuilder;

@Priority(20)
@Decorator
public abstract class LogMessageJSONFormatter implements LogMessage {
    @Any
    @Delegate
    @Inject
    @ComplexMessage
    private LogMessage logMessage;

    @Override
    public void printMessage() {
        String message = logMessage.getMessage();
        String jsonMessage = JsonbBuilder.create().toJson(message);
        logMessage.setMessage(jsonMessage);
    }
}
