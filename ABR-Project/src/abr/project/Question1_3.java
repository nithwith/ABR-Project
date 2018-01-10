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
public class Question1_3 {
    public void DisplayAABRR(AABRR a){
        if(a != null){
            System.out.print("m :"+ a.getm()+" M :"+a.getM());
            System.out.print("\t | ABRR : ");
            DisplayABRR(a.getArbreBinaire());

            System.out.println(" ");

            if (a.getGauche() != null) 
               DisplayAABRR(a.getGauche());
            if (a.getDroit() != null)
               DisplayAABRR(a.getDroit());
        }
    }
    
    public void DisplayABRR(ABRR a){
        System.out.print(a.getValeur()+ " ");
        
        if (a.getGauche() != null)
            DisplayABRR(a.getGauche());
        if (a.getDroit() != null)
            DisplayABRR(a.getDroit());
    }
}
