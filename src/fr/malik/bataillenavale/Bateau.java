package fr.malik.bataillenavale;

public class Bateau {
    private int taille;
    private Case[] cases;
    private boolean[] touches;

    public Bateau(int taille, Case[] cases) {
        this.taille = taille;
        this.cases = cases;
        this.touches = new boolean[taille];
    }

    public boolean contient(Case c) {
        for (Case cc : cases) {
            if (cc.getLigne() == c.getLigne() && cc.getColonne() == c.getColonne()) {
                return true;
            }
        }
        return false;
    }

    public void toucher(Case c) {
        for (int i = 0; i < cases.length; i++) {
            Case cc = cases[i];
            if (cc.getLigne() == c.getLigne() && cc.getColonne() == c.getColonne()) {
                touches[i] = true;
                return;
            }
        }
    }

    public boolean estCoule() {
        for (boolean t : touches) {
            if (!t) return false;
        }
        return true;
    }

    public int getTaille() {
        return taille;
    }

    public Case[] getCases() {
        return cases;
    }
}
