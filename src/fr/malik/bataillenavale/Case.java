package fr.malik.bataillenavale;

public class Case {
    private int ligne;   // 0..9
    private int colonne; // 0..9

    // Constructeur existant
    public Case(int ligne, int colonne) {
        this.ligne = ligne;
        this.colonne = colonne;
    }

    // NOUVEAU constructeur (coordonnées type A5)
    public Case(String coord) {
        coord = coord.toUpperCase().trim();

        char lettre = coord.charAt(0);           // ex: 'A'
        int chiffre = Integer.parseInt(coord.substring(1)); // ex: "5"

        this.ligne = lettre - 'A';   // 'A' -> 0
        this.colonne = chiffre - 1;  // 1 -> 0
    }

    public boolean estValide() {
        return ligne >= 0 && ligne < 10 && colonne >= 0 && colonne < 10;
    }

    public int getLigne() {
        return ligne;
    }

    public int getColonne() {
        return colonne;
    }
}
