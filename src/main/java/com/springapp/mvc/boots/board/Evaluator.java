package com.springapp.mvc.boots.board;

import java.util.List;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Evaluator {
    //TODO: generate table queen
    private static final int[] QUEEN = {28, 28, 28, 28, 28, 28, 28, 28,
            28, 44, 36, 36, 36, 36, 44, 28,
            28, 36, 44, 44, 44, 44, 36, 28,
            28, 36, 44, 44, 44, 44, 36, 28,
            28, 36, 44, 44, 44, 44, 36, 28,
            28, 36, 44, 44, 44, 44, 36, 28,
            28, 44, 36, 36, 36, 36, 44, 28,
            28, 28, 28, 28, 28, 28, 28, 28};
    private static final int[] CASTLE = {14, 14, 14, 14, 14, 14, 14, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 14, 14, 14, 14, 14, 14, 14};

    private static final int[] BLACK_PAWN = {0, 0, 0, 0, 0, 0, 0, 0,
            4, 4, 4, 0, 0, 4, 4, 4,
            6, 8, 2, 10, 10, 2, 8, 6,
            6, 8, 12, 16, 16, 12, 8, 6,
            8, 12, 16, 24, 24, 16, 12, 8,
            12, 16, 24, 32, 32, 24, 16, 12,
            12, 16, 24, 32, 32, 24, 16, 12,
            8000, 8000, 8000, 8000, 8000, 8000, 8000, 8000};

    private static final int[] WHITE_PAWN = {8000, 8000, 8000, 8000, 8000, 8000, 8000, 8000,
            12, 16, 24, 32, 32, 24, 16, 12,
            12, 16, 24, 32, 32, 24, 16, 12,
            8, 12, 16, 24, 24, 16, 12, 8,
            6, 8, 12, 16, 16, 12, 8, 6,
            6, 8, 2, 10, 10, 2, 8, 6,
            4, 4, 4, 0, 0, 4, 4, 4,
            0, 0, 0, 0, 0, 0, 0, 0};

    private static final int[] KING = {0, 0, -4, -10, -10, -4, 0, 0,
            -4, -4, -8, -12, -12, -8, -4, -4,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -16, -20, -24, -24, -24, -24, -20, -16,
            -12, -16, -20, -20, -20, -20, -16, -12,
            -4, -4, -8, -12, -12, -8, -4, -4,
            0, 0, -4, -10, -10, -4, 0, 0};

    private static final int[] KNIGHT = {0, 4, 8, 10, 10, 8, 4, 0,
            4, 8, 16, 20, 20, 16, 8, 4,
            8, 16, 24, 28, 28, 24, 16, 8,
            10, 20, 28, 32, 32, 28, 20, 10,
            10, 20, 28, 32, 32, 28, 20, 10,
            8, 16, 24, 28, 28, 24, 16, 8,
            4, 8, 16, 20, 20, 16, 8, 4,
            0, 4, 8, 10, 10, 8, 4, 0};

    private static final int[] BISHOP = {14, 14, 14, 14, 14, 14, 14, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 18, 22, 22, 22, 22, 18, 14,
            14, 22, 18, 18, 18, 18, 22, 14,
            14, 14, 14, 14, 14, 14, 14, 14};

    public static int consider(Board board) {
        return getMaterial(board.getItems()) + getStrategies(board.getItems());
    }

    private static int getMaterial(List<Item> itemList) {
        int result = 0;
        for (Item item : itemList) {
            if (item.isBlack()) {
                result += WeightFigure.getWeightFigure(item.getFigure());
            } else {
                result -= WeightFigure.getWeightFigure(item.getFigure());
            }
        }
        return result;
    }

    private static int getStrategies(List<Item> itemList) {
        int result = 0;
        for (Item item : itemList) {
            if (item.isBlack()) {
                if (item.getFigure().equals(Figure.PAWN)) {
                    result += BLACK_PAWN[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.BISHOP)) {
                    result += BISHOP[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.KING)) {
                    result += KING[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.KNIGHT)) {
                    result += KNIGHT[item.getCoordinate()];
                }
            } else {
                if (item.getFigure().equals(Figure.PAWN)) {
                    result -= WHITE_PAWN[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.BISHOP)) {
                    result -= BISHOP[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.KING)) {
                    result -= KING[item.getCoordinate()];
                }
                if (item.getFigure().equals(Figure.KNIGHT)) {
                    result -= KNIGHT[item.getCoordinate()];
                }
            }
        }
        return result;
    }

    public static int[] getEvaluatorTable(Item item) {
        if (item.getFigure().equals(Figure.BISHOP)) {
            return BISHOP;
        } else if (item.getFigure().equals(Figure.KING)) {
            return KING;
        } else if (item.getFigure().equals(Figure.QUEEN)) {
            return QUEEN;
        } else if (item.getFigure().equals(Figure.KNIGHT)) {
            return KNIGHT;
        } else if (item.getFigure().equals(Figure.CASTLE)) {
            return CASTLE;
        } else {
            if (item.isBlack()) {
                return BLACK_PAWN;
            } else {
                return WHITE_PAWN;
            }
        }
    }
}
