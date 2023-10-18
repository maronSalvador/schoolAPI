package com.springboot.schoolAPI.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class IllegalArgumentException extends RuntimeException{

    public String[] paths;
    public String title;

    public IllegalArgumentException(String message) {
        super(message);
    }

    public IllegalArgumentException(String title, String message) {
        super(message);
        this.title = title;
    }

    public static IllegalArgumentException withMessageAndPath (String message, String... path) {
        final IllegalArgumentException exception = new IllegalArgumentException(message);
        exception.setPaths(path);
        return exception;
    }
}
