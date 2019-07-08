package com.model.day1.game;

import java.util.Scanner;

public class WazAuto {

        private int wielkosc;
        private char[][] mapa;
        private Gracz gracz;
        private int[][] tabPoz;
//    konstruktor


        public WazAuto(int wielkosc, Gracz gracz) {
            this.wielkosc = wielkosc;
            this.mapa = new char[wielkosc][wielkosc];
            this.gracz = gracz;
        }

        public void emptyMap() {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa.length; j++) {
                    if (((i == 0) || i == (mapa.length - 1) || (j == 0) || (j == (mapa.length - 1)))) {
                        mapa[i][j] = '&';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
        }

        public void fillMap() {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa.length; j++) {
                    if (((i == 0) || i == (mapa.length - 1) || (j == 0) || (j == (mapa.length - 1)))) {
                        mapa[i][j] = '&';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
            // tutaj można dodawać pozycje!
//        mapa[1][1]='q';
//        mapa[2][2]='q';
//        mapa[3][3]='q';
            ustawPozPionka();
        }

        public void printMap() {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa.length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        }

        public void ustawPozPionka() {
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
        }

        public void ruchy() throws InterruptedException {

            Scanner input = new Scanner(System.in);
//      licznik ruchów
            int licznikRuchow = 1;
            int[][] tabPoz = new int[100][10];


//        pytanie użytkownika o ruch
            System.out.println("Ruch: \ngóra w\ndół s\nLewo a\nPrawo d\nWyjście x");
            String wybor = "";
            boolean flaga = false;
            String wyjscie;
            do {
                wybor = input.nextLine();

                switch (wybor) {

                    case "w":
                        do {

                            try {
                                gracz.setX(gracz.getX() - 1);

                                for (int i = 2; i <= licznikRuchow; i++) {
                                    if (
                                            mapa[tabPoz[i][0]][tabPoz[i][1]] == mapa[(gracz.getX())][gracz.getY()]) {
                                        System.out.println("Ugryzłeś się w zad! :P");

                                        wybor = "x";
                                        break;
                                    }

                                }

                                fillMap();

                            } catch (ArrayIndexOutOfBoundsException e) {
                                System.out.println("Wychodzisz poza planszę \n daję Cię na środek");
                                gracz.setX(5);
                                gracz.setY(5);
                            }
                            System.out.println("zapamiętanie do tabli");
//                    zapamiętanie pozcji do tabeli
                            tabPoz[licznikRuchow][0] = (gracz.getX());
                            tabPoz[licznikRuchow][1] = (gracz.getY());

                            fillMap();

                            System.out.println("pionek tu był");
//                   to są pozycje na których pionek już był
                            for (int i = 0; i <= licznikRuchow; i++) {
                                mapa[tabPoz[i][0]][tabPoz[i][1]] = gracz.getSymbol();
                            }

//                    ustawPozPionka();

                            System.out.println("d!");

                            System.out.println("przed print");
                            printMap();
                            Thread.sleep(1000);
                            wyjscie=input.nextLine();
                        }while (wyjscie==null);

                        break;

// *************** KONIEC RUCHU "w"  GÓRA ****************


                    case "s":
                        try {
                            gracz.setX(gracz.getX() + 1);
                            for (int i = 2; i <= licznikRuchow; i++) {
                                if (
                                        mapa[tabPoz[i][0]][tabPoz[i][1]] == mapa[(gracz.getX())][gracz.getY()]) {
                                    System.out.println("Ugryzłeś się w zad! :P");
                                    wybor="x";
                                    break;
                                }
                                break;
                            }
                            fillMap();

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Wychodzisz poza planszę \n daję Cię na środek");
                            gracz.setX(5);
                            gracz.setY(5);
                        }
                        tabPoz[licznikRuchow][0] = (gracz.getX()); //tapo[0][0]=5
                        tabPoz[licznikRuchow][1] = (gracz.getY());

                        fillMap();


                        for (int i = 0; i <= licznikRuchow; i++) {

                            mapa[tabPoz[i][0]][tabPoz[i][1]] = gracz.getSymbol();
                        }
//                    ustawPozPionka();
                        printMap();
                        break;
//                    ******************LEWO********************
                    case "a":
                        try {
                            gracz.setY(gracz.getY() - 1);
                            for (int i = 2; i <= licznikRuchow; i++) {
                                if (
                                        mapa[tabPoz[i][0]][tabPoz[i][1]] == mapa[(gracz.getX())][gracz.getY()]) {
                                    System.out.println("Ugryzłeś się w zad! :P");
                                    wybor="x";
                                    break;
                                }
                                break;
                            }
                            fillMap();

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Wychodzisz poza planszę \n daję Cię na środek");
                            gracz.setX(5);
                            gracz.setY(5);
                        }
                        tabPoz[licznikRuchow][0] = (gracz.getX()); //tapo[0][0]=5
                        tabPoz[licznikRuchow][1] = (gracz.getY());

                        fillMap();


                        for (int i = 0; i <= licznikRuchow; i++) {

                            mapa[tabPoz[i][0]][tabPoz[i][1]] = gracz.getSymbol();
                        }
//                    ustawPozPionka();
                        printMap();
                        break;
//                    *******************PRAWO******************************
                    case "d":
                        try {
                            gracz.setY(gracz.getY() + 1);
                            for (int i = 2; i <= licznikRuchow; i++) {
                                if (
                                        mapa[tabPoz[i][0]][tabPoz[i][1]] == mapa[(gracz.getX())][gracz.getY()]) // sprawdza, czy taka pozycja już wystąpiła
                                {
                                    System.out.println("Ugryzłeś się w zad! :P"); //komunikat jak weszło się na zajęte pole
                                    wybor="x";
                                    break;
                                }

                            }
                            fillMap();

                        } catch (ArrayIndexOutOfBoundsException e) {
                            System.out.println("Wychodzisz poza planszę \n daję Cię na środek");
                            gracz.setX(5);
                            gracz.setY(5);
                        }
                        tabPoz[licznikRuchow][0] = (gracz.getX()); //tapo[0][0]=5
                        tabPoz[licznikRuchow][1] = (gracz.getY());

                        fillMap();


                        for (int i = 0; i <= licznikRuchow; i++) {

                            mapa[tabPoz[i][0]][tabPoz[i][1]] = gracz.getSymbol();
                        }
//                    ustawPozPionka();
                        printMap();
                        break;
                }
                licznikRuchow++;


            } while (!wybor.equalsIgnoreCase("x"));

        }

        public static void main(String[] args) throws InterruptedException {
            Gracz gracz = new Gracz(5, 5, 'x');
            com.model.day1.game.Waz waz = new com.model.day1.game.Waz(10, gracz);
            waz.ruchy();
        }



}
