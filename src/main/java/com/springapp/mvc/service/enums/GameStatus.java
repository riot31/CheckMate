package com.springapp.mvc.service.enums;

/**
 * Created by o.lutsevich on 7.2.16.
 */
public enum GameStatus {
    WAITING("ожидание"),
    START("начата"),
    OVER("завершена");

    private String status;

    GameStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
