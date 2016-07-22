package com.springapp.mvc.boot.board;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public enum Figure {
    KING(1),
    QUEEN(2),
    CASTLE(3),
    KNIGHT(4),
    BISHOP(5),
    PAWN(6);

    private Integer index;

    Figure(Integer index) {
        this.index = index;
    }

    public Integer getIndex() {
        return index;
    }
}
