/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.*;
import java.util.ArrayList;

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
    
    public AABRR (String[] grand_arbre_tab){
        System.out.println("construct_grand_arbre");
        for (int i = 0; i < grand_arbre_tab.length; i++) {
            System.out.println(grand_arbre_tab[i]);
        }
        
        //Construction Noeud
        
        String[] AABRR_tab = grand_arbre_tab[0].split(";");
        String[] mM_tab = grand_arbre_tab[0].split(":");
        String[] petit_arbre_tab = AABRR_tab[1].split(":");
        
        for (int i = 0; i < petit_arbre_tab.length; i++) {
            System.out.println(petit_arbre_tab[i]);
        }
        
                
        int m = Integer.parseInt(mM_tab[0]);
        int M = Integer.parseInt(mM_tab[0]);
        
        ABRR petit_arbre = new ABRR(petit_arbre_tab);
        AABRR arbre = new AABRR(m,M,petit_arbre);
        
        //Construction sous arbres
        
        int self_m = (int)grand_arbre_tab[0].charAt(0);
        int next_M = (int)grand_arbre_tab[0].charAt(2);
        
        if( self_m > next_M ){
            String sous_arbre_tab[] = null;
            sous_arbre_tab = 
                    
            //Problème Copy TAB
            //System.arraycopy(grand_arbre_tab,1,sous_arbre_tab,0,grand_arbre_tab.length);
            //System.out.println(sous_arbre_tab);
            AABRR sous_arbre = new AABRR(sous_arbre_tab);
            arbre.setGauche(sous_arbre);
        }
        
        else if( self_m < next_M ){
            String sous_arbre_tab[] = null;
            System.arraycopy(grand_arbre_tab,1,sous_arbre_tab,0,grand_arbre_tab.length);
            //System.out.println(sous_arbre_tab);
            AABRR sous_arbre = new AABRR(sous_arbre_tab);
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
