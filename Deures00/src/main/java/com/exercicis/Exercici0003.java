package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0003 {
    public static double calcularPreuFinal(double preuBase, double iva, double descompte) {
        double preuAmbIva = preuBase + (preuBase * iva / 100);
        return preuAmbIva - (preuAmbIva * descompte / 100);
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Locale localeUS = Locale.US;

        System.out.print("Intrdueix el preu base: ");
        Double preuBase = scanner.nextDouble();

        System.out.print("Introdueix l'IVA (%): ");
        Double iva = scanner.nextDouble();

        System.out.print("Introdueix el descompte (%): ");
        Double descompte = scanner.nextDouble();

        double preuAmbIva = preuBase + (preuBase * iva / 100);
        double preuFinal = preuAmbIva - (preuAmbIva * descompte / 100);

        System.out.printf(localeUS, "El valor de %.2f€ són %.2f$%n" + preuFinal);
        
        scanner.close();
    }
}
