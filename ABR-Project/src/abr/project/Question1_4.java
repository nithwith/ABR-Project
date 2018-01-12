/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 *
 * @author Théo
 */
public class Question1_4 {
    
  
    public AABRR randomAABRR(int nbNoeuds, int min, int max) {
        Vector<Integer> vector = new Vector<>();
        Vector<Vector<Integer>> AABRR_vector = new Vector<>();
        Vector<Vector<Integer>> AABRR_vector_random = new Vector<>();
        Random r = new Random();
        
        //Consctruction des noeuds du grand arbre
        for (int i = 1; i <= nbNoeuds ;i++) {
            vector.add(min + r.nextInt(max - min));
        }

        Collections.sort(vector);
        int arbreMin = 0;
        
        //Regroupement des paires m et M
        for (Integer arbreMax: vector) {
            arbreMin = arbreMin + 1;
            Vector<Integer> noeud = new Vector<>();
            noeud.add(arbreMin);
            noeud.add(arbreMax);
            AABRR_vector.add(noeud);
            arbreMin = arbreMax + 1;
        }
        
        //Répartition aléatoire des noeuds du grand arbres (pour ne pas avoir un arbre filiforme)
        for (Vector<Integer> vector1 : AABRR_vector) {
            if(r.nextBoolean()){
                AABRR_vector_random.add(0 ,vector1);
            }
            else{
                AABRR_vector_random.add(AABRR_vector_random.size() ,vector1);
            }
        }
        Vector<Integer> final_vector = new Vector<>();final_vector.add(0);final_vector.add(0);
        AABRR_vector_random.add(final_vector);
        
    

        return insertAABRRfromVector(AABRR_vector_random, 0);
    }

    
    
    
    public AABRR insertAABRRfromVector(Vector<Vector<Integer>> vector, int rang){
        
        if(rang < vector.size()-1){
            
            AABRR a = new AABRR(vector.get(rang).get(0), vector.get(rang).get(1),new ABRR(vector.get(rang).get(0)));
                 
            if(a.getm() >= vector.get(rang+1).get(0))
                a.setGauche(insertAABRRfromVector(vector,rang+1));

            if(a.getM() < vector.get(rang+1).get(1))
                a.setDroit(insertAABRRfromVector(vector,rang+1));
            
            
            
            return a;
            
        }
        return null;
        
    }
    
    public ABRR insertABRRfromVector(ABRR a, int i) {
        if(a == null){
            System.out.println("Insertion réalisée");
            a = new ABRR(i);
            return a;
        }
        else{
            if(a.getValeur() >= i)
                a.setGauche(insertABRRfromVector(a.getGauche(), i));
            else
                a.setDroit(insertABRRfromVector(a.getDroit(), i));
        }
        return a;
    }


    
    
}
