package org.ecn.version2;

class Player {
    private String guess;

    public Player() {
        this.guess = "";
    }

    public void guessCombination() {
        Scanner input = new Scanner(System.in);
        System.out.println("Guess a combination of 4 colors (y, b, r, g, w, k):");
        this.guess = input.nextLine();
    }

    public String getGuess() {
        return this.guess;
    }
}