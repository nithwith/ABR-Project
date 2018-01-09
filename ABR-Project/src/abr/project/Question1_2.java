/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

/**
 *
 * @author Théo
 */
public class Question1_2 {
    public void DisplayAABRR(AABRR a){
        System.out.println("-------------------------");
        System.out.println("m :"+ a.getm()+" M :"+a.getM());
        System.out.print("ABRR : ");
        new Question1_2().DisplayABRR(a.getArbreBinaire());
        
        System.out.println(" ");
        
        if (a.getGauche() != null) 
           new Question1_2().DisplayAABRR(a.getGauche());
        if (a.getDroit() != null)
            new Question1_2().DisplayAABRR(a.getDroit());
    }
    
    public void DisplayABRR(ABRR a){
        
        System.out.print(a.getValeur()+ " ");
        
        if (a.getGauche() != null)
            new Question1_2().DisplayABRR(a.getGauche());
        if (a.getDroit() != null)
            new Question1_2().DisplayABRR(a.getDroit());
    }
}
