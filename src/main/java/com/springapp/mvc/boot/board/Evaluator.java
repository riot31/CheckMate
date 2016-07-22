package com.springapp.mvc.boot.board;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Evaluator {
    private static final int DIFFERENCE_COLOR = 10;

    private static final int[][] STRATEGIES_EVALUATION = {
            //KING
            {
                    0, 0, -4, -10, -10, -4, 0, 0,
                    -4, -4, -8, -12, -12, -8, -4, -4,
                    -12, -16, -20, -20, -20, -20, -16, -12,
                    -16, -20, -24, -24, -24, -24, -20, -16,
                    -16, -20, -24, -24, -24, -24, -20, -16,
                    -12, -16, -20, -20, -20, -20, -16, -12,
                    -4, -4, -8, -12, -12, -8, -4, -4,
                    0, 0, -4, -10, -10, -4, 0, 0
            },
            //QUEEN
            {
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0
            },
            //CASTLE
            {
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0,
                    0, 0, 0, 0, 0, 0, 0, 0
            },
            //KNIGHT
            {
                    0, 0, -4, -10, -10, -4, 0, 0,
                    -4, -4, -8, -12, -12, -8, -4, -4,
                    -12, -16, -20, -20, -20, -20, -16, -12,
                    -16, -20, -24, -24, -24, -24, -20, -16,
                    -16, -20, -24, -24, -24, -24, -20, -16,
                    -12, -16, -20, -20, -20, -20, -16, -12,
                    -4, -4, -8, -12, -12, -8, -4, -4,
                    0, 0, -4, -10, -10, -4, 0, 0
            },
            //BISHOP
            {
                    14, 14, 14, 14, 14, 14, 14, 14,
                    14, 22, 18, 18, 18, 18, 22, 14,
                    14, 18, 22, 22, 22, 22, 18, 14,
                    14, 18, 22, 22, 22, 22, 18, 14,
                    14, 18, 22, 22, 22, 22, 18, 14,
                    14, 18, 22, 22, 22, 22, 18, 14,
                    14, 22, 18, 18, 18, 18, 22, 14,
                    14, 14, 14, 14, 14, 14, 14, 14
            },
            //BLACK_PAWN
            {
                    0, 0, 0, 0, 0, 0, 0, 0,
                    4, 4, 4, 0, 0, 4, 4, 4,
                    6, 8, 2, 10, 10, 2, 8, 6,
                    6, 8, 12, 16, 16, 12, 8, 6,
                    8, 12, 16, 24, 24, 16, 12, 8,
                    12, 16, 24, 32, 32, 24, 16, 12,
                    12, 16, 24, 32, 32, 24, 16, 12,
                    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000
            },
            //WHITE_PAWN
            {
                    1000, 1000, 1000, 1000, 1000, 1000, 1000, 1000,
                    12, 16, 24, 32, 32, 24, 16, 12,
                    12, 16, 24, 32, 32, 24, 16, 12,
                    8, 12, 16, 24, 24, 16, 12, 8,
                    6, 8, 12, 16, 16, 12, 8, 6,
                    6, 8, 2, 10, 10, 2, 8, 6,
                    4, 4, 4, 0, 0, 4, 4, 4,
                    0, 0, 0, 0, 0, 0, 0, 0
            }

    };


    public static int consider(Board board) {
        return getMaterial(board.getItems()) + getStrategies(board.getItems());
    }

    private static int getMaterial(int[] items) {
        int result = 0;
        for (Integer item : items) {
            if (item > DIFFERENCE_COLOR) {
                result += WeightFigure.getWeightFigure(item - DIFFERENCE_COLOR);
            } else if (item > 0) {
                result -= WeightFigure.getWeightFigure(item);
            }
        }
        return result;
    }

    private static int getStrategies(int[] items) {
        int result = 0;
        for (int i = 0; i < items.length; i++) {

            if (items[i] > 0) {
                if (items[i] > DIFFERENCE_COLOR) {
                    result += STRATEGIES_EVALUATION[items[i] - DIFFERENCE_COLOR - 1][i];
                } else {
                    if (items[i] == Figure.PAWN.getIndex()) {
                        result -= STRATEGIES_EVALUATION[items[i]][i];
                    } else {
                        result -= STRATEGIES_EVALUATION[items[i] - 1][i];
                    }
                }
            }
        }
        return result;
    }
}
