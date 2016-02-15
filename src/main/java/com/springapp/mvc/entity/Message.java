package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Created by o.lutsevich on 9.2.16.
 */
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue
    @Column(name = "messageId")
    private String messageId;

    @Column(name = "username")
    private String username;

    @Column(name = "message")
    private String message;

    @Column(name = "type")
    private String type;

    @ManyToOne(targetEntity = Game.class)
    @JoinColumn(name = "gameUuid")
    private Game game;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
