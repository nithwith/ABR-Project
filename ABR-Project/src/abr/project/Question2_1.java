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
public class Question2_1 {
    public boolean rechercherABR(AABRR a, int i){
        if(a != null){
            if(a.getm() <= i && a.getM() >= i){
                System.out.println("Dans intervalle M m : " + a.getm()+ " "+ a.getM());
                rechercherABRR(a.getArbreBinaire(), i);
                return true;
            }
            
            else{
                if(a.getm() > i){
                    return rechercherABR(a.getGauche(), i);
                }
                if(a.getM() < i){
                    return rechercherABR(a.getDroit(), i);
                }
            }
            
        }
        return false;
    }
    
    public void rechercherABRR(ABRR a, int i){
        if(a != null){
            if(a.getValeur() == i){
                System.out.println("Valeur trouvée dans ABRR : " + a.getValeur());
            }
            
            else{
                if(a.getValeur()> i)
                    rechercherABRR(a.getGauche(), i);
                if(a.getValeur()< i)
                    rechercherABRR(a.getDroit(), i);
            }
            
        }
    }
}
