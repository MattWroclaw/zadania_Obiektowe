package com.model.day1.game;

import lombok.Data;

@Data
public class Plansza {
    private int wielkosc;
    private char[][] mapa;
    private Gracz gracz;

    //tablica wyjściowych pozycji ogona węża, a następnie rozwijający się ogon węża
    int[][] tab4Poz = {{5, 5}, {5, 5}, {5, 5}, {5, 5}, {5, 5}};

    //    KONSTRUKTOR
    public Plansza(int wielkosc, Gracz gracz) {
        this.wielkosc = wielkosc;
        this.gracz = gracz;
        this.mapa = new char[wielkosc][wielkosc];
        zapelnijMape();
    }

    //    Buduje planszę (ramka+środek) + wrzuca pozycję pionka: dodajPozycjęGraczaNaMapie():
    public void zapelnijMape() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                    mapa[i][j] = '#';
                } else {
                    mapa[i][j] = '.';
                }
            }
        }
        dodajPozycjeGraczaNaMape();

    }

    //    Drukuje mapę (planszę) + pozycję piona
    public void wyrysujMape() {

        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[i].length; j++) {
                System.out.print(mapa[i][j]);
            }
            System.out.println();
        }
    }

    //    Ustawia pozycję pionka
    private void dodajPozycjeGraczaNaMape() {
        mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
    }

    //************************************
//    seria metod do przesuwania pionka (pojedyncze pole, char)
    public void idzD() {

        try {
            gracz.setX(gracz.getX() + 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
            zapelnijMape();
            wyrysujMape();
        }
    }

    public void idzG() {

        try {
            gracz.setX(gracz.getX() - 1);
            zapelnijMape();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Wszedłeś na ramkę, cofam Cię na środek");
            gracz.setX(5);
        } finally {
            zapelnijMape();
            wyrysujMape();
        }
    }

    public void idzL() {
        try {
            gracz.setY(gracz.getY() - 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wyszedłeś za daleko w Lewo");
            System.out.println("Daje cię na środek");
            gracz.setY(5);
        }
        zapelnijMape();
        wyrysujMape();
    }

    public void idzP() {
        try {
            gracz.setY(gracz.getY() + 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Wyszedłeś za daleko w Lewo");
            System.out.println("Daje cię na środek");
            gracz.setY(5);
        }
        zapelnijMape();
        wyrysujMape();
    }

    //************************************
// Seria metod do przesuwania pionka, który zostawia 1 ślad za sobą
    public void idzDSl() {
        try {
            gracz.setX(gracz.getX() + 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX() - 1][gracz.getY()] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        }
    }

    public void idzGSl() {
        try {
            gracz.setX(gracz.getX() - 1);
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX() + 1][gracz.getY()] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }

        }

    }

    public void idzLSl() {


        try {
            gracz.setY(gracz.getY() - 1);
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX()][gracz.getY() + 1] = gracz.getSymbol();
            mapa[4][3] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setY(5);

        }
//        odświeża mapę i czyści ze starych pozycji
        finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
        }
    }

    public void idzPSl() {
        try {
            gracz.setY(gracz.getY() + 1);
            zapelnijMape();
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX()][gracz.getY() - 1] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setY(5);
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        } finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
        }

    }

    //********************************
//    Seria metod przesuwania pionka - ślad typu wąż NOKIA

    public void idzDwaz() {

        int licznikWywolan;
        for (licznikWywolan = 0; licznikWywolan < 4; licznikWywolan++) {
            tab4Poz[licznikWywolan][0] = gracz.getX();
            tab4Poz[licznikWywolan][1] = gracz.getY();
        }

        try {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }

            for (licznikWywolan = 0; licznikWywolan < 4; licznikWywolan++) {

                    mapa[tab4Poz[licznikWywolan][0]][tab4Poz[licznikWywolan][1]] = gracz.getSymbol();
//            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            }
            gracz.setX(gracz.getX() + 1);
//rysowanie
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        }
//        finally {
//            for (int i = 0; i < mapa.length; i++) {
//                for (int j = 0; j < mapa[i].length; j++) {
//                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
//                        mapa[i][j] = '#';
//                    } else {
//                        mapa[i][j] = '.';
//                    }
//                }
//            }
//        }
        licznikWywolan++;
    }

    public void idzGwaz() {
        try {
            gracz.setX(gracz.getX() - 1);
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX() + 1][gracz.getY()] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
//            for (int i = 0; i < mapa.length; i++) {
//                for (int j = 0; j < mapa[i].length; j++) {
//                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
//                        mapa[i][j] = '#';
//                    } else {
//                        mapa[i][j] = '.';
//                    }
//                }
//            }


        }

    }

    public void idzLwaz() {
        try {
            gracz.setY(gracz.getY() - 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX()][gracz.getY() + 1] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        }

    }

    public void idzPwaz() {
        try {
            gracz.setY(gracz.getY() + 1);
            zapelnijMape();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Nie możesz wyjść poza pole");
            gracz.setX(5);
        } finally {
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    if (i == 0 || i == mapa.length - 1 || j == 0 || j == mapa.length - 1) {
                        mapa[i][j] = '#';
                    } else {
                        mapa[i][j] = '.';
                    }
                }
            }
            mapa[gracz.getX()][gracz.getY()] = gracz.getSymbol();
            mapa[gracz.getX()][gracz.getY() - 1] = gracz.getSymbol();
            for (int i = 0; i < mapa.length; i++) {
                for (int j = 0; j < mapa[i].length; j++) {
                    System.out.print(mapa[i][j]);
                }
                System.out.println();
            }
        }

    }

    public static void main(String[] args) {
        Gracz gracz = new Gracz(5, 5, 'x');
        Plansza plansza = new Plansza(10, gracz);

        gracz.setX(2);

        plansza.zapelnijMape();
        plansza.wyrysujMape();
    }
}