package com.dessafiocrud.Desafio.dto;

import java.time.Instant;

public class CustomError {
    private Instant timeStamp;
    private String error;
    private Integer status;
    private String path;

    public CustomError(Instant timeStamp, String error, Integer status, String path) {
        this.timeStamp = timeStamp;
        this.error = error;
        this.status = status;
        this.path = path;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public String getError() {
        return error;
    }

    public Integer getStatus() {
        return status;
    }

    public String getPath() {
        return path;
    }
}
