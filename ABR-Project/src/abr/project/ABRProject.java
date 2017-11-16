/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import static abr.project.Arbre.arbresEgaux;
import static abr.project.Arbre.estABR;
import static abr.project.Arbre.hauteur;
import java.io.File;

/**
 * @author theo
 */
public class ABRProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Arbre a = new Arbre("/Users/teto/Documents/Cours M1 MIAGE/algo/ABR-Project/ABR-Project/src/Fichiers/AB_import");

        /**Arbre b = new Arbre(2,new Arbre(1),new Arbre(4,new Arbre(3),new Arbre(5)));
         Arbre c = new Arbre(10,new Arbre(8),new Arbre(12));
         Arbre a = new Arbre(6,b,c);

         System.out.println("L'arbre a est " + a);
         System.out.println("Le parcours infixe de l'arbre a donne :");
         a.ParcoursPrefixe();
         System.out.println("Le parcours infixe de l'arbre a donne :");
         a.ParcoursInfixe();
         System.out.println("Le parcours postfixe de l'arbre a donne :");
         a.ParcoursPostfixe();
         System.out.println("Le parcours en largeur de l'arbre a donne :");
         //a.ParcoursLargeur();
         System.out.println("L'arbre a est-il egal a lui-meme? " + arbresEgaux(a, a));
         System.out.println("Les arbres a et b sont-ils egaux? " + arbresEgaux(a, b));
         System.out.println("La hauteur de l'arbre a est " + hauteur(a));
         System.out.println("L'arbre a est-il un ABR? " + estABR(a));
         System.out.println("7 est-il present dans a? " + a.recherche(7));
         System.out.println("12 est-il present dans a? " + a.recherche(12));
         a.insertion(7);
         System.out.println("Le resultat de l'ajout de 7 dans a " + a);
         */

    }

}
