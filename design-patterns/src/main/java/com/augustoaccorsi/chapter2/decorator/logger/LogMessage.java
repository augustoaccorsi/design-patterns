package com.augustoaccorsi.chapter2.decorator.logger;

public interface LogMessage {
    void printMessage();
    String getMessage();
    void setMessage(String message);
}
