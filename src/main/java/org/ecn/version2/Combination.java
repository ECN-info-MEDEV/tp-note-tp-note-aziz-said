package org.ecn.version2;

import lombok.Data;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@Data
class Combination {
    private ArrayList<String> possibleColors = new ArrayList<>(Arrays.asList(
            "y", // yellow
            "b", // blue
            "r", // red
            "g", // green
            "w", // white
            "k" // black
    ));

    private static Random RANDOM;
    private String combination;

    public Combination() {
        this.combination = "";
    }

    private static Random getRandom() {
        if (RANDOM == null) {
            RANDOM = new Random();
        }
        return RANDOM;
    }

    /**
     * Generates a random combination of colors using the possibleColors ArrayList and the Random class.
     * The combination is stored as a String in the combination field {@link this#getCombination()}.
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
        this.setCombination(builder.toString());
    }

    /**
     * Allows the user to choose a combination of 4 colors (y, b, r, g, w, k)
     * by prompting the user for input using the Scanner class.
     * The chosen combination is stored as a String in the combination field.
     *
     * @param inputStream the input stream used to get character from user
     */
    public void chooseCombination(InputStream inputStream) {
        Scanner input = new Scanner(inputStream);
        System.out.println("Choose a combination of 4 colors (y, b, r, g, w, k):");
        this.combination = input.nextLine();
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
            if (guess.charAt(i) == this.combination.charAt(i)) {
                markers.append("b");
            } else if (this.combination.contains(Character.toString(guess.charAt(i)))) {
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
        this.setCombination("");
    }
}