package com.exercicis;

import java.util.Locale;
import java.util.Scanner;

public class Exercici0006 {

    public static double calculaEntrada(int numeroAdults, int numNens, int numGrans, String dia) {

        double estandar = 10;
        double entradaNens = 5;
        double gentGran = 6;

        double totalA = (numeroAdults * estandar);
        double totalN = (numNens * entradaNens);
        double totalG = (numGrans * gentGran);

        double total = totalA + totalG + totalN;

        if (dia.equalsIgnoreCase("dimarts")) {
            total *= 0.2;
        } else if (dia.equalsIgnoreCase("dijous") && estandar <= 1 && entradaNens <= 1) {
            total -= entradaNens * 0.5;
            total -= entradaNens - 1;
        }

        return total;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println( String.format(Locale.US, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(1, 5, 1, "dijous")));
        System.out.println( String.format(Locale.US, "Cas 2 (1 adult,  2 nens, 0 grans): ", calculaEntrada(1, 5, 1, "dijous")));
        System.out.println( String.format(Locale.US, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(1, 5, 1, "dijous")));
        System.out.println( String.format(Locale.US, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(1, 5, 1, "dijous")));
        System.out.println( String.format(Locale.US, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(1, 5, 1, "dijous")));
        System.out.println( String.format(Locale.US, "Cas 1 (2 adults, 2 nens, 1 gran): ", calculaEntrada(1, 5, 1, "dijous")));

        scanner.close();
    }
}
