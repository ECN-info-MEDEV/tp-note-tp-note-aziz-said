package org.ecn.version2;

import java.util.Scanner;

public class Mastermind {
    public static void main(String[] args) {
        // Création des objets pour les joueurs
        Player player1 = new Player();
        Player player2 = new Player();

        // Création de l'objet pour gérer le jeu
        Game game = new Game();

        // Boucle de jeu
        while (!game.isWon()) {
            // Demande de saisie des couleurs pour le joueur 1
            player1.chooseColors();

            // Demande de saisie des couleurs pour le joueur 2
            player2.chooseColors();

            // Vérification des couleurs saisies par les joueurs
            game.checkColors(player1.getColors(), player2.getColors());

            // Affichage des résultats
            game.displayResults();
        }

        // Affichage du message de victoire
        System.out.println("Les joueurs ont gagné !");
    }
}