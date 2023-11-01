package com.dessafiocrud.Desafio.dto;

public class FieldMessage {
    public String fieldName;
    public String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }

}
