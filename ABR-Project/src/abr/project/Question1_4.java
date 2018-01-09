/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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


    
    
}
