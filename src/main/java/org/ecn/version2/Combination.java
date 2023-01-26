package org.ecn.version2;

class Combination {
    private String combination;

    public Combination() {
        this.combination = "";
    }

    public void chooseCombination() {
        Scanner input = new Scanner(System.in);
        System.out.println("Choose a combination of 4 colors (y, b, r, g, w, k):");
        this.combination = input.nextLine();
    }

    public void checkCombination(String guess) {
        String markers = "";
        for (int i = 0; i < 4; i++) {
            if (guess.charAt(i) == this.combination.charAt(i)) {
                markers += "b";
            } else if (this.combination.contains(Character.toString(guess.charAt(i)))) {
                markers += "w";
            } else {
                markers += " ";
            }
        }
        return markers;
    }
}