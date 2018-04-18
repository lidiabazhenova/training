package com.catalog.exception;

/**
 * Class for exceptions during load the carpark from the file
 */
public class LoaderException extends Exception {

    /**
     * Exception constructor.
     *
     * @param message exception message
     * @param cause   cause of the exception
     */
    public LoaderException(String message, Throwable cause) {
        super(message, cause);
    }
}
