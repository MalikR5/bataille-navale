package fr.malik.bataillenavale;

public class Jeu {
    private Joueur joueur;
    private Grille grille;

    private int tirsRestants = 30;
    private boolean fini = false;

    public Jeu(Joueur joueur) {
        this.joueur = joueur;
        this.grille = new Grille();
    }

    public ResultatTir tirer(Case c) {
        if (fini || tirsRestants <= 0) {
            fini = true;
            return null;
        }

        tirsRestants--;

        ResultatTir resultat = grille.recevoirTir(c);

        if (grille.tousCoules() || tirsRestants == 0) {
            fini = true;
        }

        return resultat;
    }

    public Grille getGrille() {
        return grille;
    }

    public int getTirsRestants() {
        return tirsRestants;
    }

    public boolean isFini() {
        return fini;
    }

    public Joueur getJoueur() {
        return joueur;
    }
}
