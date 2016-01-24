package com.springapp.mvc.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by o.lutsevich on 24.1.16.
 */
@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue
    @Column(name = "gameId")
    private Integer gameId;

    @Column(name = "member1")
    private String member1;

    @Column(name = "member2")
    private String member2;

    @Column(name = "status")
    private String status;

    @Column(name = "time")
    private Date time;

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getMember1() {
        return member1;
    }

    public void setMember1(String member1) {
        this.member1 = member1;
    }

    public String getMember2() {
        return member2;
    }

    public void setMember2(String member2) {
        this.member2 = member2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
