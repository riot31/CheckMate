package com.springapp.mvc.boot.board;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public enum Figure {
    PAWN(6, 1000, new int[]{
            //BLACK_PAWN
            0, 0, 0, 0, 0, 0, 0, 0,
            4, 4, 4, 0, 0, 4, 4, 4,
            6, 8, 2, 10, 10, 2, 8, 6,
            6, 8, 12, 16, 16, 12, 8, 6,
            8, 12, 16, 24, 24, 16, 12, 8,
            12, 16, 24, 32, 32, 24, 16, 12,
            12, 16, 24, 32, 32, 24, 16, 12,
            1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000
    }),
    BISHOP(5, 3 * PAWN.weight, new int[] {
            14, 14, 14, 14, 14, 14, 14, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 14, 14, 14, 14, 14, 14, 14
    }),
    KNIGHT(4, BISHOP.weight, new int[] {
            0, 0, -4, -10, -10, -4, 0, 0,
            -4, -4, -8, -12, -12, -8, -4, -4,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -4, -4, -8, -12, -12, -8, -4, -4,
            0, 0, -4, -10, -10, -4, 0, 0
    }),
    CASTLE(3, 5 * PAWN.weight, new int[] {
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0
    }),
    QUEEN(2, 9 * PAWN.weight, new int[] {
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0,
            0, 0, 0, 0, 0, 0, 0, 0
    }),
    KING(1, 12 * QUEEN.weight, new int[] {
            0, 0, -4, -10, -10, -4, 0, 0,
            -4, -4, -8, -12, -12, -8, -4, -4,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -4, -4, -8, -12, -12, -8, -4, -4,
            0, 0, -4, -10, -10, -4, 0, 0
    });

    private final Integer index;
    private final Integer weight;
    private final int[] strategiesEvaluation;

    Figure(Integer index, Integer weight, int[] strategiesEvaluation) {
        this.index = index;
        this.weight = weight;
        this.strategiesEvaluation = strategiesEvaluation;
    }

    public Integer getIndex() {
        return index;
    }

    public Integer getWeight() {
        return weight;
    }

    public int[] getStrategiesEvaluation() {
        return strategiesEvaluation;
    }

    public static Figure find(Integer index) {
        return values()[values().length - index];
    }
}
