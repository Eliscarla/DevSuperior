package com.dessafiocrud.Desafio.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends CustomError{

    public List<FieldMessage> errors = new ArrayList<>();
    public ValidationError(Instant timeStamp, String error, Integer status, String path) {
        super(timeStamp, error, status, path);
    }

    public List<FieldMessage> getErrors() {
        return errors;
    }

    public void addError(String fieldname, String message ){
        errors.add(new FieldMessage(fieldname, message));
    }
}
