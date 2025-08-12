package com.fya.credit.fya_credit.exceptions;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ErrorMessage {
    private int status;
    private String message;
    private LocalDateTime timeStamp;

}
