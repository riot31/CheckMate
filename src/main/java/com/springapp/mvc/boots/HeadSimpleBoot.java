package com.springapp.mvc.boots;

import com.springapp.mvc.boots.board.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by o.lutsevich on 6.7.16.
 */
@Component
public class HeadSimpleBoot {
    private Boots boot = Boots.SIMPLE_BOOT;

    private static final boolean IS_BLACK = true;

    private Move strokeResult;

    @Autowired
    private BoardService boardService;

    public Board getGame(String gameUuid) {
        return boardService.getBoard(gameUuid);
    }

    public Move brain3(String gameUuid) {
        Board board = getGame(gameUuid);

        int score = -WeightFigure.INFINITY.getWeight()  * 100;

        for (Move stroke : generateMovesV_3(board, true)) {
            board.moveItem(stroke);
            int tmp = -alphaBeta(-WeightFigure.INFINITY.getWeight(), WeightFigure.INFINITY.getWeight(), board, false, 5);
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

    private int alphaBeta(int alpha, int beta, Board board, boolean isBlack, int depth) {
        if (depth == 0) {
            return Evaluator.consider(board);
        }
        int score = -WeightFigure.INFINITY.getWeight() * 100;
        for (Move stroke : generateMovesV_3(board, isBlack)) {
            board.moveItem(stroke);
            int tmp = -alphaBeta(-beta, -alpha, board, !isBlack, depth - 1);
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

    private List<Move> generateMovesV_3(Board board, boolean isBlack) {
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



//
//
//
//    public Move brain(String gameUuid) {
//        Move stroke = null;
//        Board board = getGame(gameUuid);
//        Integer evaluation = null;
//        for (Move move : generateMoves(board, IS_BLACK)) {
//            board.moveItem(move);
//            Integer tempEvaluation = Evaluator.consider(board);
//            if (evaluation == null) {
//                evaluation = tempEvaluation;
//                stroke = move;
//            } else if (evaluation < tempEvaluation) {
//                evaluation = tempEvaluation;
//                stroke = move;
//            }
//            board.unMoveItem(move);
//        }
//        if (checkCheater(board, stroke)) {
//            return stroke;
//        }
//        return null;
//    }
//
//    //TODO: потом, возможно, добавлять все ходы, пока нет надобности дублировать 4 раза безопасные взятия
//    private List<Move> generateMoves(Board board, boolean isBlack) {
//        List<Item> victims = board.getItems(!isBlack);
//        List<Move> strokes = new ArrayList<Move>();
//
//        //taking "safe"
//        for (Item victim : victims) {
//            for (Item predator : sortTake(checkDangerAnItemAndFree(board, victim))) {
//                strokes.add(new Move(predator, victim));
//            }
//        }
//
//        //TODO ходить на те с которых можно что-то взять пасля
//        //moves "safe"
//        if (strokes.isEmpty()) {
//            strokes.addAll(generateSafeMove(board, isBlack));
//
//        }
//
//        //taking "dangerous"
//        if (strokes.isEmpty()) {
//            for (Item victim : victims) {
//                for (Item predator : sortTake(checkDangerAnItem(board, victim.getCoordinate(), victim.isBlack()))) {
//                    strokes.add(new Move(predator, victim));
//                }
//            }
//
//        }
//
//        //moves "dangerous"
//        if (strokes.isEmpty()) {
//            strokes.addAll(generateSimpleMove(board, isBlack));
//        }
//
//        return strokes;
//    }
//
//    private List<Move> generateMovesV_2(Board board, boolean isBlack) {
//        List<Move> strokes = new ArrayList<Move>();
//
//        List<Item> predators = board.getItems(isBlack);
//        List<Item> potentialVictims = board.getItems(!isBlack);
//
//        for (Item predator : predators) {
//            int [] targetMoves = MoveUtil.moveItem(board.toArray(), predator);
//            //taking
//            for (Item item : getVictims(targetMoves, potentialVictims)) {
//                strokes.add(new Move(predator, item));
//            }
//        }
//        return strokes;
//    }
//
//    //TODO: сделать "размен"
//    private List<Item> checkDangerAnItemAndFree(Board board, Item victim) {
//        List<Item> predators = checkDangerAnItem(board, victim.getCoordinate(), victim.isBlack());
//        List<Item> strokes = new ArrayList<Item>();
//        if (!predators.isEmpty()) {
//
//            List<Item> potentialPredators = board.getItems(victim.isBlack());
//
//            victim.setIsBlack(!victim.isBlack());
//            potentialPredators.remove(victim);
//            if (getPredators(board.toArray(), potentialPredators, victim.getCoordinate()).isEmpty()) {
//                victim.setIsBlack(!victim.isBlack());
//                potentialPredators.add(victim);
//                strokes.addAll(predators);
//            } else {
//                victim.setIsBlack(!victim.isBlack());
//                potentialPredators.add(victim);
//            }
//        }
//
//        return strokes;
//    }
//
//    private List<Item> checkDangerAnItem(Board board, Integer coordinate, boolean isBlack) {
//        List<Item> potentialPredators = board.getItems(!isBlack);
//        return getPredators(board.toArray(), potentialPredators, coordinate);
//    }
//
//    private List<Item> getPredators(int[] board, List<Item> potentialPredators, Integer coordinate) {
//        List<Item> predators = new ArrayList<Item>();
//        for (Item predator : potentialPredators) {
//            for (Integer potentialStroke : MoveUtil.moveItem(board, predator)) {
//                if (coordinate.equals(potentialStroke)) {
//                    predators.add(predator);
//                }
//            }
//        }
//        return predators;
//    }
//
//    private List<Move> generateSafeMove(Board board, boolean isBlack) {
//        List<Move> potentialStrokes = generateSimpleMove(board, isBlack);
//        List<Move> result = new ArrayList<Move>();
//        for (Move stroke : potentialStrokes) {
//            if (checkDangerAnItem(board, stroke.getStroke(), stroke.getPredator().isBlack()).isEmpty()) {
//                result.add(stroke);
//            }
//        }
//        return result;
//    }
//
//    private List<Move> generateSimpleMove(Board board, boolean isBlack) {
//        List<Item> items = board.getItems(isBlack);
//        List<Move> strokes = new ArrayList<Move>();
//        for (Item item : items) {
//            List<Move> temps = getMoveItem(board.toArray(), item);
//            for (Move temp : temps) {
//                if (temp.getStroke() != null) {
//                    strokes.add(temp);
//                }
//            }
//        }
//        return strokes;
//    }
//
//    private List<Move> getMoveItem(int[] board, Item item) {
//        List<Move> result = new ArrayList<Move>();
//        Move tempStroke = new Move(item);
//        int[] strokes = MoveUtil.moveItem(board, item);
//        int[] evaluator = Evaluator.getEvaluatorTable(item);
//        for (int stroke : strokes) {
//            if (stroke != -1) {
//                if (tempStroke.getStroke() == null) {
//                    tempStroke.setStroke(stroke);
//                } else {
//                    if (evaluator[tempStroke.getStroke()] < evaluator[stroke]) {
//                        tempStroke.setStroke(stroke);
//                    }
//                }
//            }
//        }
//        if (tempStroke.getStroke() != null) {
//            for (int stroke : strokes) {
//                if (stroke != -1) {
//                    if (evaluator[tempStroke.getStroke()] == evaluator[stroke]) {
//                        tempStroke.setStroke(stroke);
//                        result.add(tempStroke);
//                    }
//                }
//            }
//        }
//        return result;
//    }
//
//    private List<Item> sortTake(List<Item> predators) {
//        Collections.sort(predators, new Comparator<Item>() {
//            @Override
//            public int compare(Item item, Item t1) {
//                return item.getFigure().getIndex() < t1.getFigure().getIndex() ? 1 : -1;
//            }
//        });
//        return predators;
//    }
//
//    private List<Move> sortStrokes(List<Move> strokes) {
//        Collections.sort(strokes, new Comparator<Move>() {
//            @Override
//            public int compare(Move move, Move t1) {
//                return move.getVictim().getFigure().getIndex() > t1.getVictim().getFigure().getIndex() ? 1 : -1;
//            }
//        });
//        return strokes;
//    }

}
