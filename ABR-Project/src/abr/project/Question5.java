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
public class Question5 {
    
     //A est un ABR (sur les valeurs de m)
    public boolean verifABR(AABRR a){
        
        if (a.getGauche() != null)
            verifABR(a.getGauche());
        System.out.println(a.getm());
        if (a.getDroit() != null)
            verifABR(a.getDroit());
        
        return false;
    }
    
    //tous les intervalles [m;M] des nœuds de A sont disjoints
    public boolean intervalmMDisjoint(AABRR a){
        
        
        return false;
    }
    
    //Tous les arbres A' des noeuds de 1 sont desABRR contenant des élements compris entre m et M
    public boolean ABRRDansInterval(AABRR a){
        
        
        return false;
    }
}
