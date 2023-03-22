package io.klvl.common;

public class SessionNotFoundException extends IllegalArgumentException {

    public SessionNotFoundException(String message) {
        super(message);
    }
}
