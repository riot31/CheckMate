package com.springapp.mvc.service.util;

/**
 * Created by o.lutsevich on 24.1.16.
 */
public final class Functions {
    private Functions() {
    }

    public static String getMessage(String key) {
        return MessageUtils.getMessage(key);
    }
}
