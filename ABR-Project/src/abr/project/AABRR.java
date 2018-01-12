/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Vector;

/**
 * @author theo
 */
public class AABRR {
    private int m, M;
    private ABRR abrr;
    private AABRR gauche, droit;

    // CONSTRUCTEURS
    
    public AABRR() {}

    public AABRR(int m, int M, ABRR arbreBinaire, AABRR gauche, AABRR droit) {
        this.m = m;
        this.M = M;
        this.abrr = arbreBinaire;
        this.gauche = gauche;
        this.droit = droit;
    }

    public AABRR(int m, int M, ABRR arbreBinaire) {
        this.m = m;
        this.M = M;
        this.abrr = arbreBinaire;
    }
    
    public AABRR(int m, int M) {
        this.m = m;
        this.M = M;
    }

    public AABRR constructeurAABRR(Vector<Vector<Integer>> prefixe_tab,  int debutPrefixe, int finPrefixe ,Vector<Vector<Integer>> infixe_tab, int debutInfixe, int finInfixe) {
  
        AABRR noeud = new AABRR();
        
        int IndiceRacineInfixe = debutInfixe;
        
        while(infixe_tab.get(IndiceRacineInfixe).get(0) != prefixe_tab.get(debutPrefixe).get(0))
		IndiceRacineInfixe++;
        
        Vector<Integer> prefixe = prefixe_tab.get(debutPrefixe);
        Vector<Integer> infixe = infixe_tab.get(IndiceRacineInfixe);

	noeud.m = prefixe.get(0);
        noeud.M = prefixe.get(1);
        noeud.abrr = new ABRR().constructionABRR(prefixe, 2, prefixe.size()-1, infixe, 2, infixe.size()-1);
        
        
        
        if(debutInfixe != finInfixe)
	{
		int IndiceFinSAGPrefixe = debutPrefixe + IndiceRacineInfixe - debutInfixe;

		// Sous-arbre gauche
		if(debutPrefixe + 1 <= IndiceFinSAGPrefixe)
			noeud.gauche = constructeurAABRR(prefixe_tab, debutPrefixe + 1, IndiceFinSAGPrefixe, infixe_tab, debutInfixe, IndiceRacineInfixe - 1);

		// Sous-arbre droit
		if(IndiceFinSAGPrefixe + 1 <= finPrefixe)
			noeud.droit = constructeurAABRR(prefixe_tab, IndiceFinSAGPrefixe + 1, finPrefixe, infixe_tab, IndiceRacineInfixe + 1, finInfixe);
	}
	return noeud;
    }

    

    // ACCESSEURS

    public int getm() {
        return m;
    }

    public void setm(int m) {
        this.m = m;
    }

    public int getM() {
        return M;
    }

    public void setM(int M) {
        this.M = M;
    }

    public ABRR getArbreBinaire() {
        return abrr;
    }

    public void setArbreBinaire(ABRR arbreBinaire) {
        this.abrr = arbreBinaire;
    }

    public AABRR getGauche() {
        return gauche;
    }

    public void setGauche(AABRR gauche) {
        this.gauche = gauche;
    }

    public AABRR getDroit() {
        return droit;
    }

    public void setDroit(AABRR droit) {
        this.droit = droit;
    }
    
    
    public Boolean afils(AABRR a) {
        return false;
    }


 }
