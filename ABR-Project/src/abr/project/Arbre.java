/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.*;

/**
 * @author theo
 */
public class Arbre {
    private int valeur, n, m;
    private Arbre gauche, droit;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public int getM() {
        return m;
    }

    public void setM(int m) {
        this.m = m;
    }

    // CONSTRUCTEURS
    public Arbre(int x) {
        this.valeur = x;
    }

    public Arbre(int n, int m, int x, Arbre g, Arbre d) {
        this.n = n;
        this.m = m;
        this.valeur = x;
        this.gauche = g;
        this.droit = d;
    }

    public Arbre (String filepath){
        String line;
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                    String[] arbre_from_string = line.split(";");
                    for (int i = 0; i<arbre_from_string.length; i++){

                        System.out.println(arbre_from_string[i]);
                    }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }

    }

    // ACCESSEURS
    public int getValeur() {
        return (valeur);
    }

    public Arbre getSousArbreGauche() {
        return (gauche);
    }

    public Arbre getSousArbreDroit() {
        return (droit);
    }

    // AFFICHAGE
    public String toString() {
        return toString("\t");
    }

    public String toString(String s) {
        if (gauche != null) {
            if (droit != null)
                return (s + valeur + "\n" + gauche.toString(s + "\t") + droit.toString(s + "\t"));
            else
                return (s + valeur + "\n" + gauche.toString(s + "\t") + "\n");
        } else if (droit != null)
            return (s + valeur + "\n\n" + droit.toString(s + "\t"));
        else
            return (s + valeur + "\n");
    }

    /**
     * Affiche l'arbre selon un parcours prefixe
     */
    public void ParcoursPrefixe() {
        System.out.println(getValeur());
        if (getSousArbreGauche() != null)
            getSousArbreGauche().ParcoursPrefixe();
        if (getSousArbreDroit() != null)
            getSousArbreDroit().ParcoursPrefixe();
    }

    /**
     * Affiche l'arbre selon un parcours infixe
     */
    public void ParcoursInfixe() {
        if (getSousArbreGauche() != null)
            getSousArbreGauche().ParcoursInfixe();
        System.out.println(getValeur());
        if (getSousArbreDroit() != null)
            getSousArbreDroit().ParcoursInfixe();
    }

    /**
     * Affiche l'arbre selon un parcours postfixe
     */
    public void ParcoursPostfixe() {
        if (getSousArbreGauche() != null)
            getSousArbreGauche().ParcoursPostfixe();
        if (getSousArbreDroit() != null)
            getSousArbreDroit().ParcoursPostfixe();
        System.out.println(getValeur());
    }

    /**
     * Teste si deux arbres sont egaux, meme valeurs et meme disposition
     *
     * @param a l'arbre a comparer a b
     * @param b l'arbre a comparer a a
     * @return un boolean indiquant si les arbres sont egaux
     */
    public static boolean arbresEgaux(Arbre a, Arbre b) {
        if ((a == null) && (b == null))
            return true;
        if ((a == null) && (b != null))
            return false;
        if ((a != null) && (b == null))
            return false;

        // A ce point, a et b != null, on peut acceder a leurs champs
        if (a.getValeur() != b.getValeur())
            return false;
        return (arbresEgaux(a.getSousArbreGauche(), b.getSousArbreGauche())
                && arbresEgaux(a.getSousArbreDroit(), b.getSousArbreDroit()));
    }

    /**
     * @param a un arbre
     * @return la hauteur de l'arbre a
     */
    public static int hauteur(Arbre a) {
        if (a == null)
            return 0;
        else
            return (1 + Math.max(hauteur(a.getSousArbreGauche()), hauteur(a.getSousArbreDroit())));
    }

    /**
     * Affiche l'arbre selon un parcours en largeur

     public void ParcoursLargeur() {
     //File file = new File();
     file.ajouter(this);

     Arbre a,b;
     while (!file.estVide()) {
     a = (Arbre) file.retirer();
     System.out.println(a.getValeur());
     b = a.getSousArbreGauche();
     if (b != null)
     file.ajouter(b);
     b = a.getSousArbreDroit();
     if (b != null)
     file.ajouter(b);
     }
     } */


    /**
     * @param a un arbre
     * @return un boolean indiquant si a est un arbre binaire de recherche
     */
    public static boolean estABR(Arbre a) {
        if (a == null)
            return true;
        if ((a.getSousArbreGauche() != null) && (a.getSousArbreGauche().getValeur() > a.getValeur()))
            return false;
        if ((a.getSousArbreDroit() != null) && (a.getValeur() > a.getSousArbreDroit().getValeur()))
            return false;
        return (estABR(a.getSousArbreGauche()) && estABR(a.getSousArbreDroit()));
    }

    /**
     * @param value la valeur a recherche dans l'arbre
     * @return un boolean indiquant si value a ete trouve ou non
     */
    public boolean recherche(int value) {
        if (value == getValeur())
            return true;
        if ((value < getValeur()) && (getSousArbreGauche() != null))
            return (getSousArbreGauche().recherche(value));
        if ((value > getValeur()) && (getSousArbreDroit() != null))
            return (getSousArbreDroit().recherche(value));
        return false;
    }

    /**
     * @param value la valeur a inserer dans l'arbre
     */
    public void insertion(int value) {
        if (value == getValeur())
            return;  // la valeur est deja dans l'arbre
        if (value < getValeur()) {
            if (getSousArbreGauche() != null)
                getSousArbreGauche().insertion(value);
            else
                gauche = new Arbre(value);
        }
        if (value > getValeur()) {
            if (getSousArbreDroit() != null)
                getSousArbreDroit().insertion(value);
            else
                droit = new Arbre(value);
        }
    }
    
    public void saveAABRR(String url, Arbre a){
        File fichier = null;
        try {
            fichier = new File(url);
        } catch (Exception e) {
            System.err.println(e);
        }
        //fichier.write ("Mon premier fichier, priere de m'aider!");
        //fichier.close()
        
    }




}
