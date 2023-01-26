package org.ecn.version2;

import lombok.Data;

import java.io.PrintStream;
import java.util.Scanner;

@Data
class Player {
    private String playerName;
    private int score;
    private String guess;

    public Player(String playerName) {
        this.playerName = playerName;
        this.score = 0;
        this.guess = "";
    }

    public void guessCombination(PrintStream printStream, Scanner inputScanner) {
        printStream.println("Guess a combination of 4 colors (y, b, r, g, w, k):");
        this.guess = inputScanner.nextLine();
    }

    public String getGuess() {
        return this.guess;
    }

    public void addScore(int score) {
        this.score+= score;
    }
}