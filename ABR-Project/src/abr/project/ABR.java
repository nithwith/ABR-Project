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
public class ABR {
    private int valeur;
    private ABR gauche, droit;

    public ABR(int valeur, ABR gauche, ABR droit) {
        this.valeur = valeur;
        this.gauche = gauche;
        this.droit = droit;
    }

    public ABR() {
    }
    
    

    public ABR(int valeur) {
        this.valeur = valeur;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public ABR getGauche() {
        return gauche;
    }

    public void setGauche(ABR gauche) {
        this.gauche = gauche;
    }

    public ABR getDroit() {
        return droit;
    }

    public void setDroit(ABR droit) {
        this.droit = droit;
    }
    
    
    
    
}
