package com.springapp.mvc.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by o.lutsevich on 4.7.16.
 */
@Entity
@Table(name = "offers")
public class Offer {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Integer id;

    @Column(name = "message")
    private String message;

    @Column(name = "status")
    private String status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner")
    private User user;

    @OneToMany(targetEntity = Evaluation.class, mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    private List<Evaluation> evaluationList = new ArrayList<Evaluation>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Evaluation> getEvaluationList() {
        return evaluationList;
    }

    public void setEvaluationList(List<Evaluation> evaluationList) {
        this.evaluationList = evaluationList;
    }

    public int getEvaluation() {
        int result = 0;
        for (Evaluation evaluation : evaluationList) {
            result += evaluation.getValue();
        }
        return result;
    }
}
