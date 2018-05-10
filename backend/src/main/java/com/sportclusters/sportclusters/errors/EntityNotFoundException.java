package com.sportclusters.sportclusters.errors;

public class EntityNotFoundException extends Exception{

    public EntityNotFoundException(String message) {
        super(message);
    }

    public EntityNotFoundException(String msg, Throwable e){
        super(msg, e);
    }
}
