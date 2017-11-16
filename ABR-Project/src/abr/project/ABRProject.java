/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import static abr.project.Noeud.arbresEgaux;
import static abr.project.Noeud.estABR;
import static abr.project.Noeud.hauteur;
import java.io.File;

/**
 * @author theo
 */
public class ABRProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Noeud b = new Noeud(2,new Noeud(1),new Noeud(4,new Noeud(3),new Noeud(5)));

        Arbre a = new Arbre();
        Noeud noeudBaseImport =a.fileToArbre("../Fichiers/AB_import");


    }

}
