package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Exercici0011 {

    public static ArrayList<String> escullNomsAleatoris(ArrayList<String> noms, int quantitat) {

        Random random = new Random();
        ArrayList<String> nomsEscollits = new ArrayList<>();

        while (nomsEscollits.size() < quantitat) {
            String nom = noms.get(random.nextInt(noms.size()));
            if (!nomsEscollits.contains(nom)) {
                nomsEscollits.add(nom);
            }
        }

        return nomsEscollits;
    }
   
    public static ArrayList<String> nomsAcabenVocal(ArrayList<String> noms) {

        ArrayList<String> nomsAcabenVocal = new ArrayList<>();
        for (String nom : noms) {
            char ultimaLletra = nom.charAt(nom.length() - 1);
            if ("aeiouAEIOU".indexOf(ultimaLletra) != -1) {
                nomsAcabenVocal.add(nom);
            }
        }

        return nomsAcabenVocal;
    }

    public static ArrayList<String> nomsCompostos(ArrayList<String> noms) {

        ArrayList<String> nomsCompostos = new ArrayList<>();
        for (String nom : noms) {
            if (nom.contains(" ")) {
                nomsCompostos.add(nom);
            }
        }

        return nomsCompostos;
    }

    public static void main(String[] args) {

        ArrayList<String> noms = new ArrayList<>(Arrays.asList(
            "Mario", "Princess Peach", "Wario", "Luigi", "Iggy Koopa", "Toad", "Yoshi", "Donkey Kong", "Birdo"
        ));

        ArrayList<String> nomsAleatoris = escullNomsAleatoris(noms, 5);
        System.out.println("5 noms Aleatoris escollits: " + nomsAleatoris);

        ArrayList<String> nomsAcabenEnVocal = nomsAcabenVocal(noms);
        System.out.println("Noms que acabenamb vocal : " + nomsAcabenEnVocal);

        ArrayList<String> nomsCompostos = nomsCompostos(noms);
        System.out.println("Noms compostos: " + nomsCompostos);

        
    }
}
