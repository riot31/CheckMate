package com.springapp.mvc.boot.board;

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

    public static Integer getWeightFigure(int index) {
        return values()[values().length - index - 1].getWeight();
    }
}
