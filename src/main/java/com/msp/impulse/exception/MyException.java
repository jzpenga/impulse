package com.msp.impulse.exception;

public class MyException extends RuntimeException{
    private  String message;
    private  String code;

    public MyException() {
    }

    public MyException(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
