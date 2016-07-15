package com.springapp.mvc.boots.board;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Move {
    private Item predator;
    private Item victim;
    private int stroke;

    public Move() {

    }

    public Move(Item predator, Item victim) {
        this.predator = predator;
        this.victim = victim;
    }

    public Move(Item predator, int stroke) {
        this.predator = predator;
        this.stroke = stroke;
    }

    public Move(Item predator) {
        this.predator = predator;
    }

    public Item getPredator() {
        return predator;
    }

    public void setPredator(Item predator) {
        this.predator = predator;
    }

    public Item getVictim() {
        return victim;
    }

    public void setVictim(Item victim) {
        this.victim = victim;
    }

    public int getStroke() {
        if (victim == null) {
            return stroke;
        } else {
            return victim.getCoordinate();
        }
    }

    public void setStroke(Integer stroke) {
        if (victim == null) {
            this.stroke = stroke;
        } else {
            victim.changeCoordinate(stroke);
        }
    }
}
