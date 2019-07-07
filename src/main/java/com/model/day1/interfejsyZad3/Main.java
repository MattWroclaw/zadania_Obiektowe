package com.model.day1.interfejsyZad3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Weganin weganin = new Weganin();
        Krokodyl krokodyl = new Krokodyl();
        Programista programista = new Programista();

        weganin.jedz(new Pokarm("Parówki", TypPokarmu.OWOCE, 5));

        Pokarm macDonald = new Pokarm("Makcziken", TypPokarmu.MIESO, 250);

        krokodyl.jedz(new Pokarm("Baba", TypPokarmu.MIESO, 15));
        programista.jedz(new Pokarm("Jogurt" ,TypPokarmu.NABIAL, 3));

        List<Jedzacy> jedzacyList = new ArrayList<>();
        jedzacyList.add(weganin);
        jedzacyList.add(krokodyl);
        jedzacyList.add(programista);

        weganin.ilePosilkowZjedzone();
        weganin.ilePosilkowZjedzone();

        Jedzacy [] jedzacy ={weganin};
       weganin.dajGlos();


    }
}
