package com.model.day1.game;

import lombok.Data;

@Data
public class Gracz {
   private int x;
    private int y;
    private char symbol= 'p';


    public Gracz(int x, int y, char symbol) {
        this.x = x;
        this.y = y;
        this.symbol=symbol;
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

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }
}
