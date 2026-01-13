package fr.malik.bataillenavale;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Création du joueur et du jeu
        Joueur joueur = new Joueur("Malik");
        Jeu jeu = new Jeu(joueur);

        // Placement automatique simple des bateaux
        jeu.getGrille().placementAutomatiqueSimple();

        Scanner sc = new Scanner(System.in);

        System.out.println("=== BATAILLE NAVALE (MVP) ===");
        System.out.println("Joueur : " + joueur.getNom());
        System.out.println("Saisis des coordonnées type A5 (A-J / 1-10)");
        System.out.println("Tu as 30 tirs maximum.\n");

        // Boucle de jeu
        while (!jeu.isFini()) {

            System.out.println("Tirs restants : " + jeu.getTirsRestants());
            System.out.print("Coordonnée (ex: A5) : ");

            String saisie = sc.next();

            Case c = new Case(saisie);

            // Vérification de validité
            if (!c.estValide()) {
                System.out.println("❌ Coordonnée invalide. Réessaie.\n");
                continue;
            }

            ResultatTir resultat = jeu.tirer(c);

            if (resultat == null) {
                break;
            }

            System.out.println("➡️ Résultat : " + resultat + "\n");
        }

        // Fin de partie
        System.out.println("=== FIN DE PARTIE ===");

        if (jeu.getGrille().tousCoules()) {
            System.out.println("🎉 Bravo ! Tous les bateaux sont coulés.");
        } else {
            System.out.println("💥 Plus de tirs disponibles.");
        }

        sc.close();
    }
}
