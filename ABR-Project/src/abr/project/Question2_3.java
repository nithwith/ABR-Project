/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

/**
 *
 * @author theo
 */
public class Question2_3 {

    public boolean insertionAABRR(AABRR a, int i) {
        if(a != null){
            if(a.getm() <= i && a.getM() >= i){
                System.out.println("Dans interval M m : " + a.getm()+ " "+ a.getM());
                System.out.println("lancement insertion");
                insertionABRR(a.getArbreBinaire(), i);
                return true;
            }
            
            else{
                if(a.getm() > i){
                    return insertionAABRR(a.getGauche(), i);
                }
                if(a.getM() < i){
                    return insertionAABRR(a.getDroit(), i);
                }
            }
            
        }
        return false;
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
