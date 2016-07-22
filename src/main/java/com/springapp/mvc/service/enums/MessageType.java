package com.springapp.mvc.service.enums;

/**
 * Created by o.lutsevich on 15.2.16.
 */
public enum MessageType {
    MESSAGE("message"),
    STROKE("stroke"),
    PERFORMANCE("performance"),
    END("end");

    private String type;

    MessageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
