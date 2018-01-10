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
    
    
    public AABRR randomAABRR(int nbnoeud, int min, int max){
        nbnoeud--;
        int m = 0;
        int M = 0;
        Random r = new Random();
        try {
            if(min == max){
                m = min;
                M = max;
            }
                
            else{
                m = min + r.nextInt(max - min);
                M = m + r.nextInt(max - m);
            }    
            
        } catch (Exception e) {
            System.err.println(e);
        }
       
        ABRR abrr = new ABRR(m);
        
        AABRR a = new AABRR(m, M, abrr);
        System.out.println(min+" "+max + " " +nbnoeud);
        System.out.println(m+" "+M);
        System.out.println("-------------------------");
        
        if(nbnoeud > 0){
            int random = 0 + r.nextInt(2 - 0);

            if(random == 0){
                System.out.println("SAG");
                a.setGauche(randomAABRR(nbnoeud, min, m));
            }
            if(random == 1){
                System.out.println("SAD");
                a.setDroit(randomAABRR(nbnoeud, M, max));
            }
        }
        return a;
    }
    
    
    public AABRR GenererAABRRAleatoire(int nbNoeuds, int min, int max) {
        ArrayList<Integer> values = new ArrayList<>();
        Vector<Vector<Integer>> AABRR_vector = new Vector<>();
        Vector<Vector<Integer>> AABRR_vector_random = new Vector<>();
        Random r = new Random();
        
        for (int i = 1; i <= nbNoeuds ;i++) {
            values.add(min + r.nextInt(max - min));
        }
        Collections.sort(values);
        int arbreMin = 0;
        ArrayList<AABRR> sousArbres = new ArrayList<AABRR>();
        for (Integer arbreMax: values) {
            arbreMin = arbreMin + 1;
            Vector<Integer> noeud = new Vector<>();
            noeud.add(arbreMin);
            noeud.add(arbreMax);
            AABRR_vector.add(noeud);
            arbreMin = arbreMax + 1;
        }
        
        
        for (Vector<Integer> vector : AABRR_vector) {
            if(r.nextBoolean()){
                AABRR_vector_random.add(0 ,vector);
            }
            else{
                AABRR_vector_random.add(AABRR_vector_random.size() ,vector);
            }
        }
        Vector<Integer> finish = new Vector<>();
        finish.add(0);
        finish.add(0);
        AABRR_vector_random.add(finish);
        
    

        return inserrerAABRR(AABRR_vector_random, 0);
    }

    
    
    
    public AABRR inserrerAABRR(Vector<Vector<Integer>> vector, int rang){
        
        if(rang < vector.size()-1){
            
            AABRR a = new AABRR(vector.get(rang).get(0), vector.get(rang).get(1),new ABRR(vector.get(rang).get(0)));
                 
            if(a.getm() >= vector.get(rang+1).get(0))
                a.setGauche(inserrerAABRR(vector,rang+1));

            if(a.getM() < vector.get(rang+1).get(1))
                a.setDroit(inserrerAABRR(vector,rang+1));
            
            
            
            return a;
            
        }
        return null;
        
    }
    
    public ABRR insertionABRR(ABRR a, int i) {
        if(a == null){
            System.out.println("Insertion réalisée");
            a = new ABRR(i);
            return a;
        }
        else{
            if(a.getValeur() >= i)
                a.setGauche(insertionABRR(a.getGauche(), i));
            else
                a.setDroit(insertionABRR(a.getDroit(), i));
        }
        return a;
    }


    
    
}
