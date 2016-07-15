package com.springapp.mvc.entity;

import javax.persistence.*;

/**
 * Created by o.lutsevich on 4.7.16.
 */
@Entity
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @ManyToOne(targetEntity = Offer.class)
    @JoinColumn(name = "offerId")
    private Offer offer;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "value")
    private Integer value;

    public Evaluation() {

    }

    public Evaluation(Offer offer, User user, Integer value) {
        this.offer = offer;
        this.user = user;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Offer getOffer() {
        return offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
}
