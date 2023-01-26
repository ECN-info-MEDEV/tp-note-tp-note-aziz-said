package org.ecn;

import org.ecn.version2.Game;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game("Ahmad SAID", "Aziz ABID",
                new Scanner(System.in), System.out);
        game.play();
    }
}
