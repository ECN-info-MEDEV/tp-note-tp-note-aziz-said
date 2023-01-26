package org.ecn.version2;

import java.io.PrintStream;
import java.util.Scanner;

class Player {
    private String guess;

    public Player() {
        this.guess = "";
    }

    public void guessCombination(PrintStream printStream, Scanner inputScanner) {
        printStream.println("Guess a combination of 4 colors (y, b, r, g, w, k):");
        this.guess = inputScanner.nextLine();
    }

    public String getGuess() {
        return this.guess;
    }
}