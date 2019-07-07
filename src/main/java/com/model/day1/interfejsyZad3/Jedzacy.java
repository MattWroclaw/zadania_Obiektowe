package com.model.day1.interfejsyZad3;

public interface Jedzacy {
     void jedz(Pokarm pokarm);
     int ilePosilkowZjedzone();
    int ileGramowZjedzone();


    static int zwrocPIec(){
        return 5;
    }
    default void dajGlos(){
        System.out.println("Mam cos poweidziec, ale co?");
    }
}
