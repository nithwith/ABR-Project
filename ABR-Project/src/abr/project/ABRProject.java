/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author theo
 */
public class ABRProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        ABRProject project = new ABRProject();
        
        while(true) {
            display();
        }

    }
    
    
    
    
    public AABRR Question1_1 (String filepath) throws IOException{
        Question1_1 q1 = new Question1_1();
        return q1.AABRRfromFile(filepath);
    }
    
    public void Question1_2(AABRR a){
        Question1_2 q2 = new Question1_2();
        q2.DisplayAABRR(a);
    }

    public void Question1_3 (String filepath, AABRR a) throws IOException{
        Question1_3 q3 = new Question1_3();
        q3.AABRRToFile(filepath, a);
    }
    
    public AABRR Question1_4(){
        Question1_4 q4 = new Question1_4();
        return q4.randomAABRR(5, 1, 100);
    }
    
    public void Question1_5(AABRR a){
        Question1_5 q5 = new Question1_5();
        System.out.println("AABRR is ABR               : " + q5.verifABR(a));
        System.out.println("interval m et M Disjoint   : " + q5.intervalmMDisjoint(a));
        System.out.println("ABRR Dans Interval m M     : " + q5.ABRRDansInterval(a));
        System.out.print("\nCaractéristiques vérifiées : ");
        System.out.print(q5.verifABR(a) && q5.intervalmMDisjoint(a) && q5.ABRRDansInterval(a));
        System.out.println("\n\n");
    }
    
    public void Question2_1 (AABRR a, int i) throws IOException{
        Question2_1 q1 = new Question2_1();
        AABRR b = Question1_1("AB_import");
        q1.rechercherABR(b, 5);
    }
    
    public void Question2_2 (AABRR a, int i) throws IOException{
        Question2_2 q2 = new Question2_2();
        AABRR b = Question1_1("AB_import");
        q2.suppresionABR(b, 5);
    }
    
    public void Question2_3 (AABRR a, int i) throws IOException{
        Question2_3 q3 = new Question2_3();
        AABRR b = Question1_1("AB_import");
        q3.insertionABR(b, 80);
    }
    
    public void Question2_4 (AABRR a, int i){
        
    }
    
    public void Question2_5 (AABRR a, int i){
        
    }
            
         

    
    public static void  display() throws IOException{
        ABRProject project = new ABRProject();
        
        Scanner input = new Scanner(System.in);
        System.out.println("-- Actions --");
        System.out.println(
                "Sélectionner une option: \n" +
                        "  Génération et affichage d'AABRR \n " +
                        "  1) Ficher vers AABRR\n" +
                        "  2) AABRR vers fichier\n" +
                        "  3) Affichage à l'écran\n" +
                        "  4) AABRR aléatoire\n " +
                        "  5) Vérification\n\n " +
                        
                        "  Manipulation d'AABRR \n " +
                        "  6) Recherche d'un entier\n " +
                        "  7) Supression d'un entier\n " +
                        "  8) Insertion d'un entier\n " +
                        "  9) ABR vers AABRR\n " +
                        "  10) AABRR vers ABR\n " +
                        
                        "  11) Quitter\n "
        );
        System.out.print("Rentrez votre choix: ");
        int selection = input.nextInt();
        input.nextLine();
        switch (selection) {
            case 1:
                System.out.println("Fichier vers AABRR");
                System.out.println("Emplacement du fichier (jeu de données : AB_import)");
                project.Question1_1("AB_import");
                break;
                
            case 2:
                System.out.println("AABRR vers fichier");
                AABRR a = project.Question1_1("AB_import");
                project.Question1_3("AB_import",a);
                break;
                
            case 3:
                System.out.println("Affichage à l'écran");
                AABRR b = project.Question1_1("AB_import");
                project.Question1_2(b);
                break;
                
            case 4:
                System.out.println("CONSCTRUCTION AABRR");
                AABRR c = project.Question1_4();
                System.out.println("AFFICHAGE AABRR ALEATOIRE");
                project.Question1_2(c);
                break;
                
            case 5:
                System.out.println("Vérifications\n");
                AABRR d = project.Question1_1("AB_import");
                project.Question1_5(d);
                
                break;
                
            case 6:
                System.out.println("Rechercher dans ABR\n");
                AABRR f = project.Question1_1("AB_import");
                project.Question2_1(f,80);
                break;
                
                
            case 7:
                System.out.println("Exiting...");
                System.exit(1);
                break;
                
            case 8:
                System.out.println("Exiting...");
                System.exit(1);
                break;
                
            case 9:
                System.out.println("Exiting...");
                System.exit(1);
                break;
            
            case 10:
                System.out.println("Exiting...");
                System.exit(1);
                break;
                
            case 11:
                System.out.println("Exiting...");
                System.exit(1);
                break;
            default:
                System.out.println("Aucune correspondance.");
                break;
        }
    }


}
