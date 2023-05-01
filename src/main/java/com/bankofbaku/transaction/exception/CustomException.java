package com.bankofbaku.transaction.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;
public abstract class CustomException extends RuntimeException{
    private org.springframework.http.HttpStatus status;
    private Map<String, String> params;
    public CustomException(String message, org.springframework.http.HttpStatus status){
        super(message);
        this.status=status;
    }

    public CustomException(String message, org.springframework.http.HttpStatus status, Map<String, String> params){
        super(message);
        this.status=status;
        this.params=params;
    }
    public HttpStatus getStatus(){
        return this.status;
    }
    public Map<String, String> getParams(){
        return params;
    }
}
