package com.exercicis;

import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class Exercici0014 {

    public static String getMovePC() {
        
        String[] movimientos = {"PEDRA", "PAPER", "TISORES"};
        return movimientos[new Random().nextInt(movimientos.length)];
    }

    public static String getPlayerMove(Scanner scanner) {

        String move = scanner.nextLine().trim().toUpperCase();
        if (move.equals("SORTIR")) return null;
        if (!move.equals("PEDRA") && !move.equals("PAPER") && !move.equals("TISORES")) {
            System.out.println("No es valid, torna a provar.");
            return getPlayerMove(scanner);
        }

        return move;
    }

    public static String getWinner(String playerMove, String pcMove) {

        if (playerMove.equals(pcMove)) return "DRAW";
        if ((playerMove.equals("PEDRA") && pcMove.equals("TISORES")) ||
        (playerMove.equals("PAPER") && pcMove.equals("PEDRA")) ||
        (playerMove.equals("TISORES") && pcMove.equals("PAPER"))) {
            return "PLAYER";
        }
        return "PC";
    }

    public static String getScoreMessage(int playerScore, int pcScore) {

        return String.format("Marcador -> JUGADOR %d - PC: %d\n", playerScore, pcScore);
    }

    public static String getWinnerMessage(boolean playerWon) {
        return playerWon ? "Felicitats! Has guanyat la partida!" : "Ho sento! El PC ha guanyat la partida!";

        }

    public static void updateStats(HashMap<String, Integer> stats, String move, boolean win) {

        String countKey = move + "_COUNT";
        String winKey = move + "_WINS";
        stats.put(countKey, stats.getOrDefault(countKey, 0) + 1);
        if (win) stats.put(winKey, stats.getOrDefault(winKey, 0) + 1);

    }

    public static String getMessage(String winner, String playerMove, String pcMove) {

        if (winner.equals("DRAW")) {
            return "Empat! Els dos heu triat " + playerMove + "!";
        } else if (winner.equals("PLAYER")) {
            return "Molt bé! " + playerMove + " guanya a " + pcMove + "!";

        } else {
            return "Ho sento! " + pcMove + " guanya a " + playerMove + "!";
        }
    }

    public static void showStats(HashMap<String, Integer> stats) {
        int totalGames = stats.getOrDefault("PEDRA_COUNT", 0) + 
                         stats.getOrDefault("PAPER_COUNT", 0) + 
                         stats.getOrDefault("TISORES_COUNT", 0);
    
        int totalWins = stats.getOrDefault("PEDRA_WINS", 0) + 
                        stats.getOrDefault("PAPER_WINS", 0) +
                        stats.getOrDefault("TISORES_WINS", 0);
        double winPercentage = totalGames > 0 ? (totalWins * 100.0 / totalGames) : 0;
        
        String mostUsedMove = "PEDRA";
        int mostUsedCount = stats.getOrDefault("PEDRA_COUNT", 0);
        for (String move : new String[]{"PAPER", "TISORES"}) {
            if (stats.getOrDefault(move + "_COUNT", 0) > mostUsedCount) {
                mostUsedMove = move;
                mostUsedCount = stats.get(move + "_COUNT");
            }
        }
    
        String mostVictoriousMove = "PEDRA";
        double highestWinRate = stats.getOrDefault("PEDRA_COUNT", 0) > 0 ? 
                                 (stats.getOrDefault("PEDRA_WINS", 0) * 100.0 / stats.get("PEDRA_COUNT")) : 0;
        for (String move : new String[]{"PAPER", "TISORES"}) {
            double winRate = stats.getOrDefault(move + "_COUNT", 0) > 0 ? 
                             (stats.getOrDefault(move + "_WINS", 0) * 100.0 / stats.get(move + "_COUNT")) : 0;
            if (winRate > highestWinRate) {
                mostVictoriousMove = move;
                highestWinRate = winRate;
            }
        }
    
        System.out.println("Estadístiques finals:"); 
        System.out.println("------------------");
        System.out.printf("Total partides: %d\n", totalGames);
        System.out.printf("Victòries: %.1f%%\n", winPercentage);
        System.out.printf("Moviment més utilitzat: %s (%d vegades)\n", mostUsedMove, mostUsedCount);
        System.out.printf("Moviment més victoriós: %s (%.0f%% victòries)\n", mostVictoriousMove, highestWinRate);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 
        HashMap<String, Integer> stats = new HashMap<>();
        int playerScore = 0, pcScore = 0;

        System.out.println("Benvingut a Pedra, Paper o Tisores!");
        System.out.println("El primer en arribar a 3 victories guanya.");

        try {
            while (playerScore < 3 && pcScore <3) {
                System.out.println("Escriu el teu moviment (PEDRA, PAPER, TISORES) o SORTIR per acabar: ");
                String playerMove = getPlayerMove(scanner);
                if (playerMove == null) {
                    System.out.println("HAs decidit sortir del joc.");
                    break;
                }

                String pcMove = getMovePC();
                System.out.println("PC TIRA: " + pcMove);

                String winner = getWinner(playerMove, pcMove);
                System.out.println(getMessage(winner, playerMove, pcMove));

                if (winner.equals("PLAYER")) {
                    playerScore++;
                    
                } else if (winner.equals("PC")) {
                    pcScore++;
                }

                updateStats(stats, playerMove, winner.equals("PLAYER"));
                System.out.println(getScoreMessage(playerScore, pcScore));
            }

            if (playerScore == 3 || pcScore == 3) {
                System.out.println(getWinnerMessage(playerScore == 3));
            }

            showStats(stats);
            
        } finally {
            scanner.close();  // Tanquem l'scanner al final
        }
    }
}