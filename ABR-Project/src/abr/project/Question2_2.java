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
public class Question2_2 {

    void suppresionABR(ABRR a, int i) {
        int y = i;
        if(a != null){
            if(i > a.getValeur()){
                suppresionABR(a.getGauche(), i);
            }
            if(i < a.getValeur()){
                suppresionABR(a.getDroit(), i);
            }
            if(i == a.getValeur()){
                System.out.println("Valeur supprimée");
                if(a.getDroit() != null){
                    a.setValeur(a.getDroit().getValeur());
                    a.setDroit(null);
                    a.setGauche(null);}
                if(a.getGauche() != null){
                    a.setValeur(a.getGauche().getValeur());
                    a.setDroit(null);
                    a.setGauche(null);}
            }
        }
    }
    
    public boolean testSuppressABR(AABRR a, int i){
        if(a != null){
            if(a.getm() <= i && a.getM() >= i){
                System.out.println("Dans l'intervalle M m : " + a.getm()+ " "+ a.getM());
                
                //Si la valeur existe, je lance la fonction de suppression
                if(rechercherABRR(a.getArbreBinaire(), i)){
                    suppresionABR(a.getArbreBinaire(), i);
                }
                return true;
            }
            
            else{
                if(a.getm() > i){
                    return testSuppressABR(a.getGauche(), i);
                }
                if(a.getM() < i){
                    return testSuppressABR(a.getDroit(), i);
                }
            }
            
        }
        return false;
    }
    
    public Boolean rechercherABRR(ABRR a, int i){
        if(a != null){
            if(a.getValeur() == i)
                return true;
            else{
                if(a.getValeur()> i)
                    return rechercherABRR(a.getGauche(), i);
                if(a.getValeur()< i)
                    return rechercherABRR(a.getDroit(), i);
            }
        }
        return false;
    }

    //Utilisée dans des versions antérieures pour supprimer un noeud possédant 2 fils
    private void suppriMax(ABRR a, int y) {
        if(a.getDroit() == null){
            y = a.getValeur();
            a.setValeur(a.getGauche().getValeur());
        }
        else{
            suppriMax(a.getDroit(), y);
        }
    }
    
}
