package com.springapp.mvc.boot.board;

/**
 * Created by o.lutsevich on 6.7.16.
 */
public class Item {
    private int value;
    private int position;

    public Item(int value, int position) {
        this.value = value;
        this.position = position;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
