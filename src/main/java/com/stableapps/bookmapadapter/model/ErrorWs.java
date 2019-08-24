package com.stableapps.bookmapadapter.model;

import lombok.Data;

@Data
public class ErrorWs extends Message{

    String event;
    String message;
    String errorCode;
}
