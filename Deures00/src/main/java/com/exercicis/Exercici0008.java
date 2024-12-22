package com.exercicis;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercici0008 {

    public static ArrayList<Integer> generaImparells(int numero) {
        ArrayList<Integer> imparells = new ArrayList<>();
        
        for (int i = 3; i <= numero; i += 2) {
            imparells.add(i);
        } 
        return imparells;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introdueix un numero: ");
        int num1 = scanner.nextInt();

        scanner.close();

        ArrayList<Integer> imparells = generaImparells(num1);

        System.out.println("Nombre imparells entre 2 i "+num1+":"+imparells);
    }
}
