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


    protected static ABRR constructionABRR(Vector<Integer> prefixe_tab, int debutPrefixe, int finPrefixe, Vector<Integer> infixe_tab, int debutInfixe, int finInfixe){
	ABRR noeud = new ABRR();
        
	if(debutInfixe == finInfixe){
		noeud.valeur = prefixe_tab.get(debutPrefixe);
        }
	else
	{
            
            int IndiceRacineInfixe = debutInfixe;
            while(infixe_tab.get(IndiceRacineInfixe) != prefixe_tab.get(debutPrefixe))
                    IndiceRacineInfixe++;

            int IndiceFinSAGPrefixe = debutPrefixe + IndiceRacineInfixe - debutInfixe;

            noeud.valeur = prefixe_tab.get(debutPrefixe);

            if(debutPrefixe + 1 <= IndiceFinSAGPrefixe){
                noeud.gauche = constructionABRR(prefixe_tab, debutPrefixe + 1, IndiceFinSAGPrefixe, infixe_tab, debutInfixe, IndiceRacineInfixe - 1);
            }
            if(IndiceFinSAGPrefixe + 1 <= finPrefixe){
                noeud.droit = constructionABRR(prefixe_tab, IndiceFinSAGPrefixe + 1, finPrefixe, infixe_tab, IndiceRacineInfixe + 1, finInfixe);
            }
        }
	return noeud;
    }

    
    public String exportABRRVersFichier(ABRR a,boolean first){
        String result = new String();
        if (first)
            result = String.valueOf(a.valeur) ; 
        else
            result =":" + a.valeur ; 
        
        if (a.getGauche() != null)
            result = result + exportABRRVersFichier(a.getGauche(),false);
        if (a.getDroit() != null)
            result= result + exportABRRVersFichier(a.getDroit(),false);

        
        return result;
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
