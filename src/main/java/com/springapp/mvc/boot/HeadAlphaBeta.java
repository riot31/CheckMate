package com.springapp.mvc.boot;

import com.springapp.mvc.boot.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * Created by o.lutsevich on 19.7.16.
 */
@Component
public class HeadAlphaBeta extends HeadBoot {
    private Boots boot = Boots.ALPHA_BETA;
    private static final int DIFFERENCE_COLOR = 10;

    private static final boolean IS_BLACK = true;

    private Move strokeResult;

    private final Integer depthStart = 7;

    @Autowired
    private BoardService boardService;

    private Board getGame(String gameUuid) {
        return boardService.getBoard(gameUuid);
    }

    public String getName() {
        return boot.getBootName();
    }

    public Move brain(String gameUuid) {
        Board board = getGame(gameUuid);
        strokeResult = null;
        int tmp = alphaBeta(-WeightFigure.INFINITY.getWeight(), WeightFigure.INFINITY.getWeight(), board, IS_BLACK, depthStart);
        if (!checkCheater(board, strokeResult)) {
            return null;
        }
        return strokeResult;
    }

    private int alphaBeta(int alpha, int beta, Board board, boolean isBlack, int depth) {
        if (depth == 0) {
            return isBlack ? Evaluator.consider(board) : -Evaluator.consider(board);
        }
        int score = -WeightFigure.INFINITY.getWeight();
        for (Move stroke : generateMoves(board, isBlack)) {
            if (strokeResult == null) {
                strokeResult = stroke;
            }
            if (stroke.getVictim() != null && Figure.KING.getIndex().equals(stroke.getVictim().getValue() % DIFFERENCE_COLOR) ) {
                return WeightFigure.INFINITY.getWeight();
            }
            board.moveItem(stroke);
            int tmp = -alphaBeta(-beta, -alpha, board, !isBlack, depth - 1);
            board.unMoveItem(stroke);

            if (tmp > score) {
                score = tmp;
            }
            if (score > alpha) {
                alpha = score;
                if (depthStart.equals(depth)) {
                    strokeResult = stroke;
                }
            }
            if (alpha >= beta) {
                if (depthStart.equals(depth)) {
                    strokeResult = stroke;
                }
                return alpha;
            }
        }
        return score;
    }


    private boolean checkCheater(Board board, Move stroke) {
        if (stroke == null) {
            return false;
        }
        int[] strokes = MoveUtil.moveItem(board.getItems(), stroke.getPredator());
        for (int potentialStroke : strokes) {
            if (stroke.getStroke() == potentialStroke) {
                return true;
            }
        }
        return false;
    }

    private List<Move> generateMoves(Board board, boolean isBlack) {
        List<Move> strokes = new ArrayList<Move>();
        List<Move> result = new ArrayList<Move>();
        List<Item> predators = new ArrayList<Item>();
        List<Item> victims = new ArrayList<Item>();
        divideEnemies(board.getItems(), predators, victims, isBlack);

        for (Item predator : predators) {
            for (int move : MoveUtil.moveItem(board.getItems(), predator)) {
                if (move == -1) {
                    break;
                }
                strokes.add(new Move(predator, move));
            }
        }

        for (Iterator<Move> iterator = strokes.iterator(); iterator.hasNext(); ) {
            Move move = iterator.next();
            for (Item victim : victims) {
                if (victim.getPosition() == move.getStroke()) {
                    result.add(new Move(move.getPredator(), victim));
                    iterator.remove();
                }
            }
        }
        if (!result.isEmpty()) {
            sortSafe(result);
        }
        result.addAll(sortMoves(strokes));
        return result;
    }

    private void divideEnemies(int[] items, List<Item> predators, List<Item> victims, boolean isBlack) {
        for (int i = 0; i < items.length; i++) {
            if (isBlack) {
                if (items[i] > DIFFERENCE_COLOR) {
                    predators.add(new Item(items[i], i));
                } else {
                    if (items[i] != 0) {
                        victims.add(new Item(items[i], i));
                    }
                }
            } else {
                if (items[i] > 0 && items[i] < 7) {
                    predators.add(new Item(items[i], i));
                } else {
                    if (items[i] > DIFFERENCE_COLOR) {
                        victims.add(new Item(items[i], i));
                    }
                }
            }
        }
    }

    private List<Move> sortSafe(List<Move> strokes) {
        Collections.sort(strokes, new Comparator<Move>() {
            @Override
            public int compare(Move move, Move t1) {
                if (move.getVictim().getValue() == t1.getVictim().getValue()) {
                    return 0;
                }
                return move.getVictim().getValue() > t1.getVictim().getValue() ? 1 : -1;
            }
        });
        return strokes;
    }

    private List<Move> sortMoves(List<Move> strokes) {
        Collections.sort(strokes, new Comparator<Move>() {
            @Override
            public int compare(Move move, Move t1) {
                if (move.getPredator().getValue() == t1.getPredator().getValue()) {
                    return 0;
                }
                return move.getPredator().getValue() > t1.getPredator().getValue() ? 1 : -1;
            }
        });
        return strokes;
    }
}
