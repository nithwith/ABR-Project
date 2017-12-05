/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.Arrays;

/**
 *
 * @author theo
 */
public class ABRR {
    private int valeur;
    private ABRR gauche, droit;

    public ABRR(int valeur, ABRR gauche, ABRR droit) {
        this.valeur = valeur;
        this.gauche = gauche;
        this.droit = droit;
    }

    public ABRR(int valeur) {
        this.valeur = valeur;
    }

    ABRR() {
    }
    
    public ABRR (String[] petit_arbre_tab) {
        ABRR arbre = new ABRR(Integer.parseInt(petit_arbre_tab[0]));
        
        int val = Integer.parseInt(petit_arbre_tab[0]);
        int next_val = Integer.parseInt(petit_arbre_tab[1]);
        
        if( val > next_val ){
            String sous_arbre_tab[] = null;
            System.arraycopy(petit_arbre_tab,1,sous_arbre_tab,0,petit_arbre_tab.length);
            System.out.println(sous_arbre_tab);
            ABRR sous_arbre = new ABRR(sous_arbre_tab);
            arbre.setGauche(sous_arbre);
        }
        
        else if(val < next_val){
            String sous_arbre_tab[] = null;
            System.arraycopy(petit_arbre_tab,1,sous_arbre_tab,0,petit_arbre_tab.length);
            System.out.println(sous_arbre_tab);
            ABRR sous_arbre = new ABRR(sous_arbre_tab);
            arbre.setDroit(sous_arbre);
        }
    }

    public int getValeur() {
        return valeur;
    }

    public ABRR getGauche() {
        return gauche;
    }

    public ABRR getDroit() {
        return droit;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public void setGauche(ABRR gauche) {
        this.gauche = gauche;
    }

    public void setDroit(ABRR droit) {
        this.droit = droit;
    }
    
    /**
     * Affiche l'arbre selon un parcours prefixe
     */
    public void ParcoursPrefixe() {
        System.out.println(getValeur());
        if (getGauche() != null)
            getGauche().ParcoursPrefixe();
        if (getDroit() != null)
            getDroit().ParcoursPrefixe();
    }


    /**
     * Affiche l'arbre selon un parcours infixe
     */
    public void ParcoursInfixe() {
        if (getGauche() != null)
            getGauche().ParcoursInfixe();
        System.out.println(getValeur());
        if (getDroit() != null)
            getDroit().ParcoursInfixe();
    }

    /**
     * Affiche l'arbre selon un parcours postfixe
     */
    public void ParcoursPostfixe() {
        if (getGauche() != null)
            getGauche().ParcoursPostfixe();
        if (getDroit() != null)
            getDroit().ParcoursPostfixe();
        System.out.println(getValeur());
    }
}
