package com.springapp.mvc.boot.board;

import org.apache.commons.lang.ArrayUtils;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Evaluator {
    private static final int DIFFERENCE_COLOR = 10;

    public static int consider(Board board) {
        return getMaterial(board.getItems()) + getStrategies(board.getItems());
    }

    private static int getMaterial(int[] items) {
        int result = 0;
        for (Integer item : items) {
            if (item > DIFFERENCE_COLOR) {
                result += Figure.find(item - DIFFERENCE_COLOR).getWeight();
            } else if (item > 0) {
                result -= Figure.find(item).getWeight();
            }
        }
        return result;
    }

    private static int getStrategies(int[] items) {
        int result = 0;
        for (int i = 0; i < items.length; i++) {

            if (items[i] > 0) {
                if (items[i] > DIFFERENCE_COLOR) {
                    result += Figure.find(items[i] - DIFFERENCE_COLOR).getStrategiesEvaluation()[i];
                } else {
                    if (items[i] == Figure.PAWN.getIndex()) {
                        int[] temp = Figure.PAWN.getStrategiesEvaluation();
                        ArrayUtils.reverse(temp);
                        result -= temp[i];
                    } else {
                        result -= Figure.find(items[i]).getStrategiesEvaluation()[i];
                    }
                }
            }
        }
        return result;
    }
}
