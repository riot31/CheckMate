package com.springapp.mvc.service.form;

/**
 * Created by o.lutsevich on 6.2.16.
 */
public class MessageForm {
    private String username;
    private String message;
    private String gameUuid;
    private String type;

    public MessageForm() {
    }

    public MessageForm(String username, String message, String gameUuid, String type) {
        this.username = username;
        this.message = message;
        this.gameUuid = gameUuid;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getGameUuid() {
        return gameUuid;
    }

    public void setGameUuid(String gameUuid) {
        this.gameUuid = gameUuid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
