package com.model.day1.interfejsyZad3;

public class Pokarm {
   private String nazwa;
   private TypPokarmu typPokarmu;
    private int waga;

    public Pokarm(String nazwa, TypPokarmu typPokarmu, int waga) {
        this.nazwa = nazwa;
        this.typPokarmu = typPokarmu;
        this.waga = waga;
    }

    public String getNazwa() {
        return nazwa;
    }

    public TypPokarmu getTypPokarmu() {
        return typPokarmu;
    }

    public int getWaga() {
        return waga;
    }
}
