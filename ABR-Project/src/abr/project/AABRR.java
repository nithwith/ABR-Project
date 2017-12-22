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

    AABRR(Vector<Vector<Integer>> prefixe_tab, Vector<Vector<Integer>> infixe_tab,  int debp, int debi , int finp, int fini) {
        
        System.out.println("Nouvelle fonction de construction d'arbre recursive");
        
        System.out.println(debp + " "+ debi + " "+ finp + " "+ fini  );
        
        if(debi == fini){
            
            Vector<Integer> vector = prefixe_tab.get(debi);
            this.m = vector.get(0);
            this.M = vector.get(1);
            //Creation petit arbre
            
            this.droit =null;
            this.gauche =null;
            
            
        }
        else{
            System.out.println("hola ");
            Vector<Integer> racine = prefixe_tab.get(debp);
            int i = debi;
            while(infixe_tab.get(i) != racine){
                i++;
            }
            int li = i;
            int lp = debp + li - debi -1;
            
            Vector<Integer> vector_prefixe = prefixe_tab.get(debi);
            //PAs sur ???
            Vector<Integer> vector_infixe = infixe_tab.get(li);
            this.m = vector_prefixe.get(0);
            this.M = vector_prefixe.get(1);
            
            Vector<Integer> prefixe_petit_arbre = get_vect_petit_arbre(vector_prefixe);
            Vector<Integer> infixe_petit_arbre = get_vect_petit_arbre(vector_infixe);
            this.arbreBinaire = new ABRR(prefixe_petit_arbre, infixe_petit_arbre, debp, debi , finp, fini);
            
            
            this.gauche = new AABRR(prefixe_tab, infixe_tab, debp+1, lp, debi, li -1);
            this.droit =new AABRR(prefixe_tab, infixe_tab, lp+1, finp, li+1, fini);
            
            
        }
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
