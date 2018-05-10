package com.sportclusters.sportclusters.errors;


import org.springframework.http.HttpStatus;

import java.util.LinkedList;
import java.util.List;


public class ApiCustomException extends Exception {

    public enum LOGGSTATUS {
        INFO,
        DEBUG,
        ERROR,
        NOSTATUS
    }


    private HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    // if we should log error
    private LOGGSTATUS loggStatus = LOGGSTATUS.ERROR;

    //
    private List<String> errors = new LinkedList<>();

    public ApiCustomException(String msg, Throwable e){
        super(msg, e);
    }

    public ApiCustomException(String message, HttpStatus status, Throwable e) {
        super(message, e);
        this.status = status;
    }

    public ApiCustomException(String message, HttpStatus status, LOGGSTATUS loggStatus, Throwable e) {
        super(message, e);
        this.status = status;
        this.loggStatus = loggStatus;
    }

    public ApiCustomException(String message, HttpStatus status, LOGGSTATUS loggStatus, List<String> errors, Throwable e) {
        super(message, e);
        this.status = status;
        this.loggStatus = loggStatus;
        this.errors = errors;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LOGGSTATUS getLoggStatus() {
        return loggStatus;
    }

    public void setLoggStatus(LOGGSTATUS loggStatus) {
        this.loggStatus = loggStatus;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public String getLoggMessage(){
        String errors = "[" + String.join(",",getErrors()) +"]";
        return getMessage() + " -> " + errors;
    }
}
