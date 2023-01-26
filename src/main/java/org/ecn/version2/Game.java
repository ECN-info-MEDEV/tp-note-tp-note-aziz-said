package org.ecn.version2;

class Game {
    private Plateau plateau;
    private Combination combination;
    private int round;
    private int coderScore;
    private int decoderScore;
    private boolean won;

    public Game() {
        this.plateau = new Plateau();
        this.combination = new Combination();
        this.round = 0;
        this.coderScore = 0;
        this.decoderScore = 0;
        this.won = false;
    }
    public void play() {
        while (!won) {
            if (round % 2 == 0) {
                System.out.println("Coder's turn to choose combination:");
                combination.chooseCombination();
                while (round < 12) {
                    System.out.println("Decoder's turn to guess combination:");
                    Player decoder = new Player();
                    decoder.guessCombination();
                    String markers = combination.checkCombination(decoder.getGuess());
                    plateau.addRow(decoder.getGuess(), markers);
                    plateau.display();
                    if (markers.equals("bbbb")) {
                        System.out.println("Decoder won!");
                        decoderScore++;
                        won = true;
                        break;
                    }
                    round++;
                }
                if (!won) {
                    System.out.println("Coder won!");
                    coderScore++;
                }
            } else {
                System.out.println("Decoder's turn to choose combination:");
                combination.chooseCombination();
                while (round < 12) {
                    System.out.println("Coder's turn to guess combination:");
                    Player coder = newPlayer();
                    coder.guessCombination();
                    String markers = combination.checkCombination(coder.getGuess());
                    plateau.addRow(coder.getGuess(), markers);
                    plateau.display();
                    if (markers.equals("bbbb")) {
                        System.out.println("Coder won!");
                        coderScore++;
                        won = true;
                        break;
                    }
                    round++;
                }
                if (!won) {
                    System.out.println("Decoder won!");
                    decoderScore++;
                }
            }
            round++;
            won = false;
            combination.reset();
            plateau.reset();
        }
    }
}
