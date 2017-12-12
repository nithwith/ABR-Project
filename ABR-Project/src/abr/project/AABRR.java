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
    
    public Vector<String> convertStringToVectorSplit(String tab_string ,String charactereSplit){
        String[] tab = tab_string.split(charactereSplit);
        Vector<String> vector = new Vector<>();
        vector.addAll(Arrays.asList(tab));
        
        return vector;
    }
    
    public AABRR (Vector<String> grand_arbre_tab){
                
        //Construction Noeud

        Vector<String>AABRR_vector = convertStringToVectorSplit(grand_arbre_tab.get(0),";");
        Vector<String>mM_vector = convertStringToVectorSplit(AABRR_vector.get(0),":");
        Vector<String>petit_arbre_vector = convertStringToVectorSplit(AABRR_vector.get(1),":");
        System.out.println();

        
                
        int m = Integer.parseInt(mM_vector.get(0));
        int M = Integer.parseInt(mM_vector.get(1));
        ABRR petit_arbre = new ABRR(petit_arbre_vector);
        
        AABRR arbre = new AABRR(m,M,petit_arbre);
        
        //Construction sous arbres
        
        int self_m = (int)grand_arbre_tab.elementAt(0).charAt(0);
        int next_M = (int)grand_arbre_tab.elementAt(0).charAt(2);
        
        grand_arbre_tab.remove(0);
        
        if( self_m > next_M ){
            AABRR sous_arbre = new AABRR(grand_arbre_tab);
            arbre.setGauche(sous_arbre);
        }
        
        else if( self_m < next_M ){
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
