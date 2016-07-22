package com.springapp.mvc.boot.board;

import com.springapp.mvc.service.enums.Notations;

import java.util.ArrayDeque;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Board {
    private static final int BOARD_SIZE = 64;
    private static final int DIFFERENCE_COLOR = 10;

    private int[] items = new int[BOARD_SIZE];
    private ArrayDeque<Item> removeItems = new ArrayDeque<Item>(32);
    private ArrayDeque<Boolean> logEight = new ArrayDeque<Boolean>();

    public Board() {
        items[Integer.parseInt(Notations.A8.getPosition())] = Figure.CASTLE.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.B8.getPosition())] = Figure.KNIGHT.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.C8.getPosition())] = Figure.BISHOP.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.D8.getPosition())] = Figure.QUEEN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.E8.getPosition())] = Figure.KING.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.F8.getPosition())] = Figure.BISHOP.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.G8.getPosition())] = Figure.KNIGHT.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.H8.getPosition())] = Figure.CASTLE.getIndex() + DIFFERENCE_COLOR;

        items[Integer.parseInt(Notations.A7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.B7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.C7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.D7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.E7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.F7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.G7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;
        items[Integer.parseInt(Notations.H7.getPosition())] = Figure.PAWN.getIndex() + DIFFERENCE_COLOR;


        items[Integer.parseInt(Notations.A2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.B2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.C2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.D2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.E2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.F2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.G2.getPosition())] = Figure.PAWN.getIndex();
        items[Integer.parseInt(Notations.H2.getPosition())] = Figure.PAWN.getIndex();

        items[Integer.parseInt(Notations.A1.getPosition())] = Figure.CASTLE.getIndex();
        items[Integer.parseInt(Notations.B1.getPosition())] = Figure.KNIGHT.getIndex();
        items[Integer.parseInt(Notations.C1.getPosition())] = Figure.BISHOP.getIndex();
        items[Integer.parseInt(Notations.D1.getPosition())] = Figure.QUEEN.getIndex();
        items[Integer.parseInt(Notations.E1.getPosition())] = Figure.KING.getIndex();
        items[Integer.parseInt(Notations.F1.getPosition())] = Figure.BISHOP.getIndex();
        items[Integer.parseInt(Notations.G1.getPosition())] = Figure.KNIGHT.getIndex();
        items[Integer.parseInt(Notations.H1.getPosition())] = Figure.CASTLE.getIndex();
    }


    public void moveItem(Move move) {
        moveItem(move.getPredator().getPosition(), move.getStroke());
    }

    public void unMoveItem(Move move) {
        unMoveItem(move.getPredator().getPosition(), move.getStroke());
    }

    public void moveItem(Integer oldCoordinate, Integer newCoordinate) {
        boolean eightFlag = false;

        if (items[newCoordinate] != 0) {
            removeItems.push(new Item(items[newCoordinate], oldCoordinate));
            eightFlag = true;
        }

        changePositionItem(oldCoordinate, newCoordinate);
        logEight.push(eightFlag);
    }

    public void unMoveItem(Integer oldCoordinate, Integer newCoordinate) {
        changePositionItem(newCoordinate, oldCoordinate);
        if (logEight.pop()) {
            revive(newCoordinate);
        }
    }

    private void changePositionItem(Integer oldCoordinate, Integer newCoordinate) {
        items[newCoordinate] = items[oldCoordinate];
        items[oldCoordinate] = 0;
    }

    public void revive(Integer newCoordinate) {
        Item item = removeItems.pop();
        items[newCoordinate] = item.getValue();
    }

    public void takeItem(Integer oldCoordinate, Integer newCoordinate) {
        changePositionItem(oldCoordinate, newCoordinate);
    }


    public int[] getItems() {
        return items;
    }
}
