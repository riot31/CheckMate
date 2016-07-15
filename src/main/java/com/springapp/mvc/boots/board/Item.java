package com.springapp.mvc.boots.board;

import com.springapp.mvc.boots.board.Figure;
import com.springapp.mvc.service.enums.Notations;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Item {
    private Figure figure;
    private int x;
    private int y;
    private boolean isBlack;

    public Item(Figure figure, int x, int y, boolean isBlack) {
        this.figure = figure;
        this.x = x;
        this.y = y;
        this.isBlack = isBlack;
    }

    public Item(Figure figure, int coords, boolean isBlack) {
        this.figure = figure;
        this.x = coords / 8;
        this.y = coords % 8;
        this.isBlack = isBlack;
    }

    public Item(Figure figure, Notations notations, boolean isBlack) {
        this(figure, Integer.parseInt(notations.getPosition()), isBlack);
    }

    public int getCoordinate() {
        return x * 8 + y;
    }

    public void changeCoordinate(Integer coordinate) {
        this.x = coordinate / 8;
        this.y = coordinate % 8;
    }

    public boolean equalsCoordinate(Integer coordinate) {
        int x = coordinate / 8;
        int y = coordinate % 8;
        return this.x == x && this.y == y;
    }

    public Figure getFigure() {
        return figure;
    }

    public void setFigure(Figure figure) {
        this.figure = figure;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public void setIsBlack(boolean isBlack) {
        this.isBlack = isBlack;
    }
}
