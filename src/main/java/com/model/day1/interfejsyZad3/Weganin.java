package com.model.day1.interfejsyZad3;

public class Weganin implements Jedzacy {

    int ileZjadlPokarmow ;
    int ileZjadlGramow;

    @Override
    public void jedz(Pokarm pokarm) {
        if (pokarm.getTypPokarmu().equals(TypPokarmu.MIESO)) {
            System.out.println("nie jem mięsa");
        } else {
            System.out.println("Nie jem tego!");
            ileZjadlPokarmow++;
            ileZjadlGramow +=pokarm.getWaga();
        }
    }

    @Override
    public int ilePosilkowZjedzone() {
        return ileZjadlPokarmow;
    }

    @Override
    public int ileGramowZjedzone() {
        return ileZjadlGramow;
    }


    @Override
    public void dajGlos() {

    }
}