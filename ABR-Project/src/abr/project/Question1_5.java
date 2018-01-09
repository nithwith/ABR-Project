/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.util.Stack;
import java.util.Vector;

/**
 *
 * @author Théo
 */
public class Question1_5 {
    
     //A est un ABR (sur les valeurs de m)
    public boolean verifABR(AABRR a){
        
        Vector<Integer> tab_infixe_m = new Vector<>();
        new Question1_5().tabInfixe_m(a, tab_infixe_m);
        
        for (int i = 0; i < tab_infixe_m.size()-1; i++) {
            if(tab_infixe_m.get(i) > tab_infixe_m.get(i+1))
                return false;
        }
        
        return true;
        
    }
    
    //Tous les intervalles [m;M] des nœuds de A sont disjoints
    public boolean intervalmMDisjoint(AABRR a){
        Vector<Integer> tab_infixe = new Vector<>();
        new Question1_5().tabInfixe_mM(a, tab_infixe);
        
        for (int i = 0; i < tab_infixe.size()-1; i++) {
            if(tab_infixe.get(i) > tab_infixe.get(i+1))
                return false;
        }
        
        return true;
        
    }
    
    //Tous les arbres A' des noeuds de 1 sont desABRR contenant des élements compris entre m et M
    public boolean ABRRDansInterval(AABRR a){
        
        
        if (a.getGauche() != null)
            ABRRDansInterval(a.getGauche());
        
        Vector<Integer> abrr_infixe = new Vector<>();
        new Question1_5().abrrToVector(a.getArbreBinaire(), abrr_infixe);
        
        for (Integer integer : abrr_infixe) {
            if(integer > a.getM() || integer < a.getm() )
                return false;
        }
        
        if (a.getDroit() != null)
            ABRRDansInterval(a.getDroit());
        
        return true;
    }
    
    
    public void tabInfixe_mM(AABRR a, Vector<Integer> tab){
        if (a.getGauche() != null)
            tabInfixe_mM(a.getGauche(),tab);
        
        tab.add(a.getm());
        tab.add(a.getM());
        
        if (a.getDroit() != null)
            tabInfixe_mM(a.getDroit(),tab);
        
    }
    
    public void tabInfixe_m(AABRR a, Vector<Integer> tab){
        if (a.getGauche() != null)
            tabInfixe_m(a.getGauche(),tab);
        
        tab.add(a.getm());
        
        if (a.getDroit() != null)
            tabInfixe_m(a.getDroit(),tab);
        
    }
    
    public void abrrToVector(ABRR a, Vector<Integer> tab){
        if (a.getGauche() != null)
            abrrToVector(a.getGauche(),tab);
        
        tab.add(a.getValeur());
        
        if (a.getDroit() != null)
            abrrToVector(a.getDroit(),tab);
        
    }
}
