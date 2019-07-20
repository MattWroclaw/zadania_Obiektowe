package com.model.programowanie2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LiczbyPierwsze {

    public static boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void primeCheck() throws FileNotFoundException {
        File plikZLiczbami = new File("src\\main\\Resources\\numbers.txt");
        Scanner scanner = new Scanner(plikZLiczbami);

        int licznik = 0;
        while (scanner.hasNextLine()) {
            long number = scanner.nextLong();
            if (isPrime(number)) {

                licznik++;
//                System.out.println(number);
            }
        }
        System.out.println(licznik+" tyle jest liczb pierwszych");

    }

    public static void martacheck() throws FileNotFoundException {


        File file = new File("src\\main\\Resources\\numbers.txt");
        Scanner scanner = new Scanner(file);
        long counter = 0;
        while (scanner.hasNextLine()) {
            long number = Long.parseLong(scanner.nextLine());
            if (isPrime(number)) {
                counter++;
                System.out.println(number);
            }
        }
        System.out.println("W pliku są " + counter + " liczby pierwsze.");
    }

    public static void main(String[] args) throws FileNotFoundException {
        primeCheck();

//        martacheck();
    }
}
