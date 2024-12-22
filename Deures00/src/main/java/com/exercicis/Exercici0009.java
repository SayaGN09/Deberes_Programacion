package com.exercicis;

import java.util.Scanner;

public class Exercici0009 {

    public static void dibuixarRectangle(int ample, int alt) {

        if (ample < 2 || alt < 2) {
            System.out.println("L'ample i l'alt han de ser major o iguals a 2.");
            return;
        }

        String borde = "*".repeat(ample);
        String interior = "*"+"o".repeat(ample - 2)+"*";

        for (int i = 0; i < alt; i++) {
            if (i == 0 || i == alt - 1) {
                System.out.println(borde);
            } else {
                System.out.println(interior);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introdueix l'ample del rectangle: ");
        int ample = scanner.nextInt();

        System.out.print("Introdueix l'alt del rectangle: ");
        int alt = scanner.nextInt();

        scanner.close();

        System.out.println("Resultat: ");
        dibuixarRectangle(ample, alt);
    }
}
