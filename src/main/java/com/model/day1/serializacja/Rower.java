package com.model.day1.serializacja;

import java.io.Serializable;

public class Rower implements Serializable {
    int wielkoscRamy;
    boolean czMaKola;


    public Rower(int wielkoscRamy, boolean czMaKola) {
        this.wielkoscRamy = wielkoscRamy;
        this.czMaKola = czMaKola;
    }
}
