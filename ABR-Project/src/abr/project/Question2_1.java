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
    public void rechercherABR(AABRR a, int i){
        
        if(a != null){
            if(a.getm() > i && a.getM() < i){
                System.out.println("Dans interval M m");
            }
            else{
                if(a.getm() > i){
                    rechercherABR(a.getGauche(), i);
                }
                if(a.getM() < i){
                    rechercherABR(a.getDroit(), i);
                }
            }
            
        }
    }
}
