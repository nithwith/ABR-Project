/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.*;
import java.util.ArrayList;

/**
 * @author theo
 */
public class AABRR {
    private int m, M;
    private ABRR arbreBinaire;
    private AABRR gauche, droit;

    // CONSTRUCTEURS

    public AABRR(int m, int M, ABRR arbreBinaire, AABRR gauche, AABRR droit) {
        this.m = m;
        this.M = M;
        this.arbreBinaire = arbreBinaire;
        this.gauche = gauche;
        this.droit = droit;
    }

    public AABRR(int m, int M, ABRR arbreBinaire) {
        this.m = m;
        this.M = M;
        this.arbreBinaire = arbreBinaire;
    }
    

    // ACCESSEURS

    public int getm() {
        return m;
    }

    public void setm(int m) {
        this.m = m;
    }

    public int getM() {
        return M;
    }

    public void setM(int M) {
        this.M = M;
    }

    public ABRR getArbreBinaire() {
        return arbreBinaire;
    }

    public void setArbreBinaire(ABRR arbreBinaire) {
        this.arbreBinaire = arbreBinaire;
    }

    public AABRR getGauche() {
        return gauche;
    }

    public void setGauche(AABRR gauche) {
        this.gauche = gauche;
    }

    public AABRR getDroit() {
        return droit;
    }

    public void setDroit(AABRR droit) {
        this.droit = droit;
    }

 }
