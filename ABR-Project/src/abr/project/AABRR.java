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
    private ABRR arbreBinaire;
    private AABRR gauche, droit;

    // CONSTRUCTEURS
    
    public AABRR() {}

    public AABRR(int m, int M, ABRR arbreBinaire, AABRR gauche, AABRR droit) {
        this.m = m;
        this.M = M;
        this.arbreBinaire = arbreBinaire;
        this.gauche = gauche;
        this.droit = droit;
    }

    public AABRR(int m, int M, ABRR arbreBinaire) {
        this.m = m;
        this.M = M;
        this.arbreBinaire = arbreBinaire;
    }

    public AABRR constructeurAABRR(Vector<Vector<Integer>> prefixe_tab,  int debutPrefixe, int finPrefixe ,Vector<Vector<Integer>> infixe_tab, int debutInfixe, int finInfixe) {
        
        System.out.println("Nouvelle fonction de construction d'arbre recursive");
        
        AABRR noeud = new AABRR();
        
        int IndiceRacineInfixe = debutInfixe;
        
        while(infixe_tab.get(IndiceRacineInfixe).get(0) != prefixe_tab.get(debutPrefixe).get(0))
		IndiceRacineInfixe++;
        
        Vector<Integer> prefixe = prefixe_tab.get(debutInfixe);
        Vector<Integer> infixe = infixe_tab.get(debutInfixe);

	noeud.m = prefixe.get(0);
        noeud.M = prefixe.get(1);
        noeud.arbreBinaire = new ABRR();
        noeud.arbreBinaire.constructionABRR(prefixe, 2, prefixe.size(), infixe, 2, infixe.size());
        
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
    
    public Vector<Integer> get_vect_petit_arbre(Vector<Integer> vect){
        Vector<Integer> vect_petit_arbre= new Vector<>();
        for (int i=2;i<vect.size();i++) {
            vect_petit_arbre.add(vect.get(i));
        }
        return vect_petit_arbre;
    }
    
    public Vector<String> convertStringToVectorSplit(String tab_string ,String charactereSplit){
        String[] tab = tab_string.split(charactereSplit);
        Vector<String> vector = new Vector<>();
        vector.addAll(Arrays.asList(tab));
        
        return vector;
    }
    
    public AABRR (Vector<String> grand_arbre_tab){
        
        //Construction Noeud
        
        int m = 0;
        int M = 0;
        int next_M = 0;
        int next_m = 0;

        Vector<String>AABRR_vector = convertStringToVectorSplit(grand_arbre_tab.get(0),";");
        Vector<String>next_AABRR_vector = convertStringToVectorSplit(grand_arbre_tab.get(1),";");
        Vector<String>next_mM_vector = convertStringToVectorSplit(next_AABRR_vector.get(0),":");
        Vector<String>mM_vector = convertStringToVectorSplit(AABRR_vector.get(0),":");
        Vector<String>petit_arbre_vector = convertStringToVectorSplit(AABRR_vector.get(1),":");
        
        System.out.println("");
        System.out.println(grand_arbre_tab.get(0));

        if(mM_vector.get(0) != ";" && mM_vector.get(0) != ":"){
            m = Integer.parseInt(mM_vector.get(0));
        }
        if(mM_vector.get(1) != ";" && mM_vector.get(1) != ":"){   
            M = Integer.parseInt(mM_vector.get(1));
        }
        
        
        
        System.out.print(m +":"+ M + " ; ");
        
        ABRR petit_arbre = new ABRR(petit_arbre_vector);
        
        
        System.out.println("");
        
        AABRR arbre = new AABRR(m,M,petit_arbre);
        

        //Construction sous arbres
        
        if(next_mM_vector.get(0) != ";" && next_mM_vector.get(0) != ":"){   
            next_m = Integer.parseInt(next_mM_vector.get(0));
        }
        if(next_mM_vector.get(1) != ";" && next_mM_vector.get(1) != ":"){   
            next_M = Integer.parseInt(next_mM_vector.get(1));
        }

        
        grand_arbre_tab.remove(0);
        System.out.println(m +" "+ M);
        System.out.println(next_m +" "+ next_M);
        
        if( m > next_M ){
            AABRR sous_arbre = new AABRR(grand_arbre_tab);
            arbre.setGauche(sous_arbre);
        }
        
        if( M < next_m ){
            AABRR sous_arbre = new AABRR(grand_arbre_tab);
            arbre.setDroit(sous_arbre);
        }
        
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
        return arbreBinaire;
    }

    public void setArbreBinaire(ABRR arbreBinaire) {
        this.arbreBinaire = arbreBinaire;
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

 }
