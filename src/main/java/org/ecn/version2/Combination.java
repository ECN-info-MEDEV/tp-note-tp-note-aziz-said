package org.ecn.version2;

import lombok.Data;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Data
class Combination {
    private static ArrayList<String> possibleColors = new ArrayList<>(Arrays.asList(
            "y", // yellow
            "b", // blue
            "r", // red
            "g", // green
            "w", // white
            "k" // black
    ));

    /**
     * Prints a legend of the possible colors and their corresponding letters.
     */
    public static void printColorLegend(PrintStream printStream) {
        printStream.println("Color Legend:");
        for (String possibleColor : possibleColors) {
            String colorName = "";
            switch (possibleColor) {
                case "y":
                    colorName = "Yellow";
                    break;
                case "b":
                    colorName = "Blue";
                    break;
                case "r":
                    colorName = "Red";
                    break;
                case "g":
                    colorName = "Green";
                    break;
                case "w":
                    colorName = "White";
                    break;
                case "k":
                    colorName = "Black";
                    break;
                default:
                    colorName = "Undefined Color";
            }
            printStream.println(possibleColor + " - " + colorName);
        }
    }


    private static Random random;
    private String combinationString;

    public Combination() {
        this.combinationString = "";
    }

    /**
     * Singleton pattern to get RANDOM variable
     *
     * @return random instance
     */
    private static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    /**
     * Generates a random combination of colors using the possibleColors ArrayList and the Random class.
     * The combination is stored as a String in the combination field {@link this#getCombinationString()}.
     */
    public void generateCombination() {
        // Génération de la combinaison secrète
        Random rand = getRandom();
        StringBuilder builder = new StringBuilder();
        int[] secret = new int[4];
        for (int i = 0; i < 4; i++) {
            secret[i] = rand.nextInt(possibleColors.size());
            builder.append(possibleColors.get(secret[i]));
        }
        this.setCombinationString(builder.toString());
    }

    /**
     * Allows the user to choose a combination of 4 colors (y, b, r, g, w, k)
     * by prompting the user for input using the Scanner class.
     * The chosen combination is stored as a String in the combination field.
     *
     * @param inputStream the input stream used to get character from user
     */
    public void chooseCombination(InputStream inputStream, PrintStream printStream) {
        Scanner input = new Scanner(inputStream);
        if (printStream != null){
            printStream.println("Choose a combination of 4 colors (y, b, r, g, w, k):");
        }
        this.combinationString = input.nextLine();
    }

    /**
     * Prints a legend of the markers used in the checkCombination method.
     */
    public static void printCheckCombinationLegend(PrintStream printStream) {
        printStream.println("Check Combination Legend:");
        printStream.println("b - Correct color and position");
        printStream.println("w - Correct color, wrong position");
        printStream.println("  - Incorrect color");
    }

    /**
     * Compares the given guess to the combination and returns a string of markers indicating the results of the comparison.
     * "b" represents a correct color in the correct position, "w" represents a correct color in the wrong position, and " " represents an incorrect color.
     *
     * @param guess the combination to check against the stored combination
     * @return a string of markers indicating the results of the comparison
     */
    public String checkCombination(String guess) {
        StringBuilder markers = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == this.combinationString.charAt(i)) {
                markers.append("b");
            } else if (this.combinationString.contains(Character.toString(guess.charAt(i)))) {
                markers.append("w");
            } else {
                markers.append(" ");
            }
        }
        return markers.toString();
    }

    /**
     * Resets the combination by setting it to an empty string.
     */
    public void reset() {
        this.setCombinationString("");
    }

    public ArrayList<String> getPossibleColors() {
        return possibleColors;
    }
}