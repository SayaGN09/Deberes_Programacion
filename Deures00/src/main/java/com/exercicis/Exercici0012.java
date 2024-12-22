package com.exercicis;

import java.util.*;

public class Exercici0012 {

    public static HashMap<String, Object> createWonder(String name, String location, int age) {

        HashMap<String, Object> wonder = new HashMap<>();
        wonder.put("name", name);
        wonder.put("location", location);
        wonder.put("age", age);
        return wonder;

    }

    public static void showInformation(ArrayList<HashMap<String, Object>> wonders) {

        for (HashMap<String, Object> wonder : wonders) {
            System.out.println("Name: "+wonder.get("name"));
            System.out.println("Location: " + wonder.get("location"));
            System.out.println("Age: "+ wonder.get("age")+" years");
        }

    }

    public static ArrayList<HashMap<String, Object>> sortWondersByName(ArrayList<HashMap<String, Object>> wonders) {
        Collections.sort(wonders, new Comparator<HashMap<String, Object>>() {
            public int compare(HashMap<String, Object> wonder1, HashMap<String, Object> wonder2) {
                return ((String) wonder1.get("name")).compareTo((String) wonder2.get("name"));
            }
        });
        return wonders;
    }
    
  
    public static ArrayList<HashMap<String, Object>> getSortedWondersByName(ArrayList<HashMap<String, Object>> wonders, int quantity) {

        ArrayList<HashMap<String, Object>> sortedWonders = sortWondersByName(wonders);
        ArrayList<HashMap<String, Object>> result = new ArrayList<>();

        for (int i = 0; i < quantity && i < sortedWonders.size(); i++) {
            result.add(sortedWonders.get(i));
        }

        return result;
    }
   
    public static ArrayList<String> sortNames(ArrayList<HashMap<String, Object>> wonders) {

        ArrayList<String> names = new ArrayList<>();

        for (HashMap<String, Object> wonder : wonders) {
            names.add((String) wonder.get("name"));

        }

        Collections.sort(names);

        return names;
    }

    public static ArrayList<HashMap<String, Object>> getOlder(ArrayList<HashMap<String, Object>> wonders, int quantity) {

        Collections.sort(wonders, new Comparator<HashMap<String, Object>>() {
            public int compare(HashMap<String, Object> wonder1, HashMap<String, Object> wonder2) {
                return Integer.compare((int) wonder2.get("age"), (int) wonder1.get("age"));
            }
        });

        return new ArrayList<>(wonders.subList(0, Math.min(quantity, wonders.size())));
    }
   
    public static ArrayList<HashMap<String, Object>> getRegion(ArrayList<HashMap<String, Object>> wonders, String region) {

        ArrayList<HashMap<String, Object>> regionWonders = new ArrayList<>();
        for (HashMap<String, Object> wonder : wonders) {
            if (((String) wonder.get("location")).contains(region)) {
                regionWonders.add(wonder);
            }
        }

        return regionWonders;
    }

    public static void main(String[] args) {

        ArrayList<HashMap<String, Object>> wonders = new ArrayList<>();
        wonders.add(createWonder("Great Pyramid of Giza", "Egypt", 4500));
        wonders.add(createWonder("Hanging Gardens of Babylon", "Babylon, Mesopotamia", 2500));
        wonders.add(createWonder("Statue of Zeus at Olympia", "Olympia, Greece", 2500));
        wonders.add(createWonder("Temple of Artemis at Ephesus", "Ephesus, Turkey", 2400));
        wonders.add(createWonder("Mausoleum at Halicarnassus", "Halicarnassus, Turkey", 2300));
        wonders.add(createWonder("Colossus of Rhodes", "Island of Rhodes, Greece", 2300));
        wonders.add(createWonder("Lighthouse of Alexandria", "Alexandria, Egypt", 2200));

        System.out.println("All wonders:");
        showInformation(wonders);
        System.out.println("-".repeat(25));

        System.out.println("Sorted Names: ");
        ArrayList<String> sortedNames = sortNames(wonders);
        System.out.println(sortedNames);
        System.out.println("-".repeat(25));

        System.out.println("Top 3 Oldest Wonders: ");
        ArrayList<HashMap<String, Object>> oldestWonders = getOlder(wonders, 3);
        System.out.println(oldestWonders);
        System.out.println("-".repeat(25));


        System.out.println("Wonders in Turkey: ");
        ArrayList<HashMap<String, Object>> turkeyWonders = getRegion(wonders, "Turkey");
        System.out.println(turkeyWonders);
        System.out.println("-".repeat(25));


    }
}
