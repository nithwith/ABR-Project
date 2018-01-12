/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.Vector;

/**
 *
 * @author theo
 */
public class Question2_5 {

    public void parcoursAABRR(AABRR a, Vector<Integer> abr_vector) {
        if (a.getGauche() != null)
            parcoursAABRR(a.getGauche(),abr_vector);
        parcoursABRR(a.getArbreBinaire(),abr_vector);
        if (a.getDroit() != null)
            parcoursAABRR(a.getDroit(),abr_vector);
    }
    
    public void parcoursABRR(ABRR a, Vector<Integer> abr_vector) {
        if (a.getGauche() != null)
            parcoursABRR(a.getGauche(), abr_vector);
        abr_vector.add(a.getValeur());
        if (a.getDroit() != null)
            parcoursABRR(a.getDroit(),abr_vector);
    }

    public ABR insertionABR(ABR a, int i) {
        if(a == null){
            a = new ABR(i);
            return a;
        }
        else{
            if(a.getValeur() >= i)
                a.setDroit(insertionABR(a.getDroit(), i));
            else
                a.setGauche(insertionABR(a.getGauche(), i));
        }
        return a;
        
    }
    
    public void affichageABR(ABR a) {
        if(a != null){
            System.out.print(a.getValeur()+ " ");
            
            if(a.getGauche() != null)
                affichageABR(a.getGauche());
            if(a.getDroit() != null)
                affichageABR(a.getDroit());
        }        
    }
    
    
}
