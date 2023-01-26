package org.ecn.version2;

import lombok.Data;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

@Data
public class Game {
    private final Scanner inputScanner;
    private final PrintStream printStream;
    private Plateau plateau;
    private Combination combination;

    private Player firstPlayer;
    private Player secondPlayer;

    /**
     * Constructor for the Game class.
     *
     * @param firstPlayerName  The name of the first player.
     * @param secondPlayerName The name of the second player.
     * @param scanner          The scanner to use for input.
     * @param printStream      The print stream to use for output.
     */
    public Game(String firstPlayerName, String secondPlayerName, Scanner scanner, PrintStream printStream) {
        this.plateau = new Plateau();
        this.combination = new Combination();
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
        this.inputScanner = scanner;
        this.printStream = printStream;
    }

    /**
     * Plays one round of the game.
     *
     * @param printStream  The print stream to use for output.
     * @param inputScanner The scanner to use for input.
     * @param combination  The combination object to use for the game.
     * @param plateau      The plateau object to use for the game.
     * @param playerName   The name of the player.
     * @return RunResults      The results of the round that was played.
     */
    public static RunResults playOneRun(PrintStream printStream, Scanner inputScanner,
                                        Combination combination, Plateau plateau, Player player) {
        RunResults runResults = new RunResults();
        combination.reset();
        plateau.reset();
        printStream.println("You have to guess combination generated by computer.");
        combination.generateCombination();
        printStream.print("Printing combination for learning purpose: ");
        printStream.println(combination.getCombinationString());
        String playerName = player.getPlayerName();
        while (runResults.getRounds() < 12) {
            printStream.println(playerName + "'s turn to guess combination:");
            player.guessCombination(printStream, inputScanner);
            String markers = combination.checkCombination(player.getGuess());
            plateau.addRow(player.getGuess(), markers);
            if (markers.equals("bbbb")) {
                runResults.setSummaryInfo(playerName + " won!");
                runResults.incrementScore();
                runResults.setWin(true);
                break;
            }
            runResults.incrementRounds();
        }
        return runResults;
    }

    /**
     * The play() method plays the Mastermind game. It runs the game for a total of 100 rounds, where each round
     * consists of one run of the playOneRun() method. The playOneRun() method simulates a single run of the game
     * where a player attempts to guess the secret combination generated by the computer. The play() method
     * alternates between the two players and keeps track of their scores. At the end of each round, the current
     * score of each player is displayed.
     */
    public void play() {
        int round = 0;
        Player currentPlayer;
        RunResults runResults;
        int totalGame = 100;
        // play 100 total games currently
        // at anytime users could stop
        while (round < totalGame) {
            if (round % 2 == 0) {
                currentPlayer = this.getFirstPlayer();
            } else {
                currentPlayer = this.getSecondPlayer();
            }
            Combination.printColorLegend(printStream);
            Combination.printCheckCombinationLegend(printStream);
            runResults = playOneRun(this.getPrintStream(), this.getInputScanner(),
                    this.getCombination(), this.getPlateau(), currentPlayer);
            this.getPrintStream().println(runResults.getSummaryInfo());
            currentPlayer.addScore(runResults.getScore());

            round++;
            this.getPrintStream().println("Current score for " + this.getFirstPlayer().getPlayerName()
                    + " : " + this.getFirstPlayer().getScore());

            this.getPrintStream().println("Current score for " + this.getSecondPlayer().getPlayerName()
                    + " : " + this.getSecondPlayer().getScore());
        }
    }
}
