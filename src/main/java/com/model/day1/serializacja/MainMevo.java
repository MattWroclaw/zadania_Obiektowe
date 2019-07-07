package com.model.day1.serializacja;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class MainMevo {

    public static void main(String[] args) {
        Rower bmx= new Rower(26, true);
        Rower xmb = new Rower(14 , false);

        StacjaMevo stacjaKoloMojegoDomu = new StacjaMevo(Arrays.asList(bmx,xmb));


        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("zajezdnia.txt"));
        outputStream.writeObject(stacjaKoloMojegoDomu);
        } catch (IOException e) {
            e.printStackTrace();
        }

        stacjaKoloMojegoDomu = null;

        try {
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("zajezdnia.txt"));
            stacjaKoloMojegoDomu = (StacjaMevo) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(stacjaKoloMojegoDomu);
    }
}
