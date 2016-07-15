package com.springapp.mvc.boots;

import com.springapp.mvc.boots.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o.lutsevich on 15.7.16.
 */
@Component
public class HeadNegaMax {
    private Boots boot = Boots.NEGAMAX;

    private static final boolean IS_BLACK = true;

    private Move strokeResult;

    @Autowired
    private BoardService boardService;

    public Board getGame(String gameUuid) {
        return boardService.getBoard(gameUuid);
    }

    public Move brain(String gameUuid) {
        Board board = getGame(gameUuid);

        int score = -WeightFigure.INFINITY.getWeight()  * 100;

        for (Move stroke : generateMoves(board, true)) {
            board.moveItem(stroke);
            int tmp = -bobik(board, false, 5);
            board.unMoveItem(stroke);
            if (tmp > score) {
                score = tmp;
                strokeResult = stroke;
            }
        }
        if (!checkCheater(board, strokeResult)) {
            return null;
        }
        return strokeResult;
    }

    private int bobik(Board board, boolean isBlack, int depth) {
        if (depth == 0) {
            return Evaluator.consider(board);
        }
        int score = -WeightFigure.INFINITY.getWeight() * 100;
        for (Move stroke : generateMoves(board, isBlack)) {
            board.moveItem(stroke);
            int tmp = -bobik(board, !isBlack, depth - 1);
            board.unMoveItem(stroke);
            if (tmp > score) {
                score = tmp;
            }
        }
        return score;
    }

    private boolean checkCheater(Board board, Move stroke) {
        int[] strokes = MoveUtil.moveItem(board.toArray(), stroke.getPredator());
        for (int potentialStroke : strokes) {
            if (stroke.getStroke() == potentialStroke) {
                return true;
            }
        }
        return false;
    }

    private List<Move> generateMoves(Board board, boolean isBlack) {
        List<Move> strokes = new ArrayList<Move>();
        List<Item> predators = board.getItems(isBlack);
        for (Item predator : predators) {
            for (int move : MoveUtil.moveItem(board.toArray(), predator)) {
                if (move == -1) {
                    break;
                }
                strokes.add(new Move(predator, move));
            }
        }
        return strokes;
    }
}
