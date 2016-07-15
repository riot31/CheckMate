package com.springapp.mvc.boots.board;

import com.springapp.mvc.boots.board.Figure;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public enum WeightFigure {
    W_PAWN(1000),
    W_BISHOP(3 * W_PAWN.weight),
    W_KNIGHT(W_BISHOP.weight),
    W_CASTLE(5 * W_PAWN.weight),
    W_QUEEN(9 * W_PAWN.weight),
    W_KING(12 * W_QUEEN.weight),
    INFINITY(W_KING.weight);

    private Integer weight;

    WeightFigure(Integer weight) {
        this.weight = weight;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public static Integer getWeightFigure(Figure figure) {
        return values()[values().length - figure.getIndex()].getWeight();
    }
}
