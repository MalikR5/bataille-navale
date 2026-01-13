package fr.malik.bataillenavale;

public class Grille {
    private final int taille = 10;

    private Bateau[] bateaux = new Bateau[5];
    private int nbBateaux = 0;

    private boolean[][] tirs = new boolean[taille][taille];

    public void ajouterBateau(Bateau b) {
        if (nbBateaux < bateaux.length) {
            bateaux[nbBateaux] = b;
            nbBateaux++;
        }
    }

    public void placementAutomatiqueSimple() {
        int[] tailles = {5, 4, 3, 3, 2};
        int ligne = 0;

        for (int tailleBateau : tailles) {
            Case[] cases = new Case[tailleBateau];

            // placement horizontal en commençant colonne 0
            for (int i = 0; i < tailleBateau; i++) {
                cases[i] = new Case(ligne, i);
            }

            Bateau b = new Bateau(tailleBateau, cases);
            ajouterBateau(b);

            ligne++; // ligne suivante => pas de chevauchement
        }
    }

    public ResultatTir recevoirTir(Case c) {
        int l = c.getLigne();
        int col = c.getColonne();

        // sécurité : hors grille => plouf (MVP)
        if (l < 0 || l >= taille || col < 0 || col >= taille) {
            return ResultatTir.PLOUF;
        }

        // déjà tiré
        if (tirs[l][col]) {
            return ResultatTir.PLOUF;
        }
        tirs[l][col] = true;

        // recherche bateau touché
        for (int i = 0; i < nbBateaux; i++) {
            Bateau b = bateaux[i];
            if (b.contient(c)) {
                b.toucher(c);
                if (b.estCoule()) return ResultatTir.COULE;
                return ResultatTir.TOUCHE;
            }
        }

        return ResultatTir.PLOUF;
    }

    public boolean tousCoules() {
        for (int i = 0; i < nbBateaux; i++) {
            if (!bateaux[i].estCoule()) return false;
        }
        return true;
    }

    public int getTaille() {
        return taille;
    }
}
