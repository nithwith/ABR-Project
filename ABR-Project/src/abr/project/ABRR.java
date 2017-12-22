/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

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
    
    public ABRR (Vector<String> petit_arbre_tab) {
        //System.out.println("petit arbre");
        
        int val = Integer.parseInt(petit_arbre_tab.get(0));
        System.out.print(val+":");
        ABRR arbre = new ABRR(val);
        
        if(petit_arbre_tab.size()>1){
            int next_val = Integer.parseInt(petit_arbre_tab.get(1));
            petit_arbre_tab.remove(0);

            if( val > next_val ){
                ABRR sous_arbre = new ABRR(petit_arbre_tab);
                arbre.setGauche(sous_arbre);
            }

            else if( val < next_val ){
                ABRR sous_arbre = new ABRR(petit_arbre_tab);
                arbre.setDroit(sous_arbre);
                
            }
        }
        
        
    }

    ABRR(Vector<Integer> prefixe_petit_arbre, Vector<Integer> infixe_petit_arbre, int debp, int debi, int finp, int fini) {
        
        System.out.println("Nouvelle fonction de construction d'arbre recursive");
        
        System.out.println(debp + " "+ debi + " "+ finp + " "+ fini  );
        
        if(debi == fini){
            
            this.valeur = prefixe_petit_arbre.get(debi);
            
            this.droit =null;
            this.gauche =null;
            
            
        }
        else{
            int val = prefixe_petit_arbre.get(debp);
            int i = debi;
            while(infixe_petit_arbre.get(i) != val){
                i++;
            }
            int li = i;
            int lp = debp + li - debi -1;
            
            this.valeur = prefixe_petit_arbre.get(debi);
            
            
            this.gauche = new ABRR(prefixe_petit_arbre, infixe_petit_arbre, debp+1, lp, debi, li -1);
            this.droit =new ABRR(prefixe_petit_arbre, infixe_petit_arbre, lp+1, finp, li+1, fini);
            
            
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
