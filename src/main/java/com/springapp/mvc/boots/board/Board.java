package com.springapp.mvc.boots.board;

import com.springapp.mvc.service.enums.Notations;

import java.util.*;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Board {
    private static final Integer BOARD_SIZE = 64;
    private static final int FIGURE_WHITE_FLAG = 1;
    private static final int FIGURE_BlACK_FLAG = 2;
    private static final int EMPTY_POLE_FLAG = 0;

    private List<Item> items = new ArrayList<Item>(32);
    private ArrayDeque<Item> removeItems = new ArrayDeque<Item>(32);
    private ArrayDeque<Boolean> logEight = new ArrayDeque<Boolean>();

    public Board() {
        items.add(new Item(Figure.CASTLE, Notations.A8, true));
        items.add(new Item(Figure.KNIGHT, Notations.B8, true));
        items.add(new Item(Figure.BISHOP, Notations.C8, true));
        items.add(new Item(Figure.QUEEN, Notations.D8, true));
        items.add(new Item(Figure.KING, Notations.E8, true));
        items.add(new Item(Figure.BISHOP, Notations.F8, true));
        items.add(new Item(Figure.KNIGHT, Notations.G8, true));
        items.add(new Item(Figure.CASTLE, Notations.H8, true));

        items.add(new Item(Figure.PAWN, Notations.A7, true));
        items.add(new Item(Figure.PAWN, Notations.B7, true));
        items.add(new Item(Figure.PAWN, Notations.C7, true));
        items.add(new Item(Figure.PAWN, Notations.D7, true));
        items.add(new Item(Figure.PAWN, Notations.E7, true));
        items.add(new Item(Figure.PAWN, Notations.F7, true));
        items.add(new Item(Figure.PAWN, Notations.G7, true));
        items.add(new Item(Figure.PAWN, Notations.H7, true));


        items.add(new Item(Figure.CASTLE, Notations.A1, false));
        items.add(new Item(Figure.KNIGHT, Notations.B1, false));
        items.add(new Item(Figure.BISHOP, Notations.C1, false));
        items.add(new Item(Figure.QUEEN, Notations.D1, false));
        items.add(new Item(Figure.KING, Notations.E1, false));
        items.add(new Item(Figure.BISHOP, Notations.F1, false));
        items.add(new Item(Figure.KNIGHT, Notations.G1, false));
        items.add(new Item(Figure.CASTLE, Notations.H1, false));

        items.add(new Item(Figure.PAWN, Notations.A2, false));
        items.add(new Item(Figure.PAWN, Notations.B2, false));
        items.add(new Item(Figure.PAWN, Notations.C2, false));
        items.add(new Item(Figure.PAWN, Notations.D2, false));
        items.add(new Item(Figure.PAWN, Notations.E2, false));
        items.add(new Item(Figure.PAWN, Notations.F2, false));
        items.add(new Item(Figure.PAWN, Notations.G2, false));
        items.add(new Item(Figure.PAWN, Notations.H2, false));
    }

    public void moveItem(Move move) {
        Integer temp = move.getPredator().getCoordinate();
        moveItem(move.getPredator().getCoordinate(), move.getStroke());
        move.setStroke(temp);
    }

    public void unMoveItem(Move move) {
        Integer tmp = move.getPredator().getCoordinate();
        unMoveItem(move.getStroke(), move.getPredator().getCoordinate());
        move.setStroke(tmp);
    }

    public void moveItem(Integer oldCoordinate, Integer newCoordinate) {
        boolean eightFlag = false;

        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            if (item.equalsCoordinate(newCoordinate)) {
                item.changeCoordinate(oldCoordinate);
                removeItems.push(item);
                iterator.remove();
                eightFlag = true;
                break;
            }
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

    public void revive(Integer newCoordinate) {
        Item item = removeItems.pop();
        item.changeCoordinate(newCoordinate);
        items.add(item);
    }

    public void takeItem(Integer oldCoordinate, Integer newCoordinate) {
        for (Iterator<Item> iterator = items.iterator(); iterator.hasNext();) {
            Item item = iterator.next();
            if (item.equalsCoordinate(newCoordinate)) {
                iterator.remove();
            }
        }
        changePositionItem(oldCoordinate, newCoordinate);
    }

    private void changePositionItem(Integer oldCoordinate, Integer newCoordinate) {
        for (Item item : items) {
            if (item.equalsCoordinate(oldCoordinate)) {
                item.changeCoordinate(newCoordinate);
            }
        }
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Item> getItems(boolean isBlack) {
        List<Item> result = new ArrayList<Item>(16);
        for (Item item : items) {
            if (item.isBlack() == isBlack) {
                result.add(item);
            }
        }
        return result;
    }

    public int[] toArray() {
        int [] result = new int[BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            result[i] = EMPTY_POLE_FLAG;
        }

        for (Item item : items) {
            if (item.isBlack()) {
                result[item.getCoordinate()] = FIGURE_BlACK_FLAG;
            } else  {
                result[item.getCoordinate()] = FIGURE_WHITE_FLAG;
            }
        }
        return result;
    }
}
