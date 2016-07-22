package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "userId")
    private Integer userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "email")
    private String email;

    @Column(name = "games")
    private Integer games = 0;

    @Column(name = "losses")
    private Integer losses = 0;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGames() {
        return games;
    }

    public void setGames(Integer games) {
        this.games = games;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    private void gamesIncrement() {
        this.games++;
    }

    private void lossesIncrement() {
        this.losses++;
    }

    public void lossGame() {
        gamesIncrement();
        lossesIncrement();
    }

    public void winGame() {
        gamesIncrement();
    }
}
