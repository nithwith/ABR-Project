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
        Scanner input = new Scanner(System.in);
        
        while(true) {
            display();
            System.out.print("\nRevenir au menu, tapez sur espace: ");
            input.nextLine();
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }

    }
    
    public static void  display() throws IOException{
        ABRProject project = new ABRProject();
        
        Scanner input = new Scanner(System.in);
        Scanner inputString = new Scanner(System.in);
        
        System.out.println("  --- Application AABRR ---");
        System.out.println("  Théo MARTY & Théo LACROIX\n");

        System.out.println(
                        "  Génération et affichage d'AABRR \n " +
                        "  1) Ficher vers AABRR\n" +
                        "   2) AABRR vers fichier\n" +
                        "   3) Affichage à l'écran\n" +
                        "   4) AABRR aléatoire\n " +
                        "  5) Vérification\n\n " +
                        
                        "  Manipulation d'AABRR \n " +
                        "  6) Recherche d'un entier\n " +
                        "  7) Supression d'un entier\n " +
                        "  8) Insertion d'un entier\n " +
                        "  9) AABRR vers ABR\n " +
                        
                        "  10) Quitter\n "
        );
        System.out.print("Entrez votre choix: ");
        int selection = input.nextInt();
        input.nextLine();
        
        switch (selection) {
            case 1:
                System.out.println("Fichier vers AABRR");
                System.out.println("Entrer l'emplacement du fichier a importer :"
                        + "\n(jeu de données : AB_import)");
                String filepath = inputString.nextLine();
                AABRR u = project.Question1_1(filepath);
                System.out.println("\n...AABRR importé ...\n");
                project.Question1_3(u);
                break;
                
            case 2:
                System.out.println("AABRR vers fichier");
                AABRR a = project.Question1_1("AB_import");
                System.out.println("1. AABRR importé sélectionné");
                System.out.println("2. Entrer l'emplacement du fichier a exporter :");
                String filepath1 = inputString.nextLine();
                project.Question1_2(filepath1,a);
                System.out.println("3. AABRR exporté vers : "+ filepath1 +"\n");
                break;
                
            case 3:
                System.out.println("Affichage AABRR");
                AABRR b = project.Question1_1("AB_import");
                project.Question1_3(b);
                break;
                
            case 4:
                System.out.println("Construction AABRR");
                AABRR c = project.Question1_4();
                System.out.println("Affichage AABRR Aléatoire");
                project.Question1_3(c);

                break;
                
            case 5:
                System.out.println("Vérifications ABR\n");
                AABRR d = project.Question1_1("AB_import");
                project.Question1_5(d);
                
                break;
                
            case 6:
                System.out.println("Rechercher dans AABRR\n");
                AABRR f = project.Question1_1("AB_import");
                project.Question1_3(f);
                
                System.out.println("\nEntrer chiffre a rechercher :\n");
                selection = input.nextInt();
                
                input.nextLine();
                project.Question2_1(f,selection);
                break;
                
                
            case 7:
                System.out.println("Supprimer dans AABRR\n");
                AABRR e = project.Question1_1("AB_import");
                project.Question1_3(e);
                
                System.out.println("\nEntrer chiffre a supprimer :\n");
                selection = input.nextInt();
                
                input.nextLine();
                project.Question2_2(e,selection);
                project.Question1_3(e);

                break;
                
            case 8:
                System.out.println("Insérrer dans AABRR\n");
                AABRR g = project.Question1_1("AB_import");
                project.Question1_3(g);
                
                System.out.println("\nEntrer chiffre a insérrer :\n");
                selection = input.nextInt();
                
                input.nextLine();
                project.Question2_3(g,selection);
                
                project.Question1_3(g);
                break;
                
 
            
            case 9:
                System.out.println("Export AABRR vers ABR\n");
                AABRR t = project.Question1_1("AB_import");
                project.Question2_5(t);
                

                break;
                
            case 10:
                System.out.println("Exiting...");
                System.exit(1);
                break;
            default:
                System.out.println("Aucune correspondance.");
                break;
        }
    }   
    
    public AABRR Question1_1 (String filepath) throws IOException{
        Question1_1 q1 = new Question1_1();
        return q1.AABRRfromFile(filepath);
    }
    
    public void Question1_2(String filepath, AABRR a) throws IOException{
        Question1_2 q2 = new Question1_2();
        q2.AABRRToFile(filepath, a);
    }

    public void Question1_3 ( AABRR a) {
        Question1_3 q3 = new Question1_3();
        q3.DisplayAABRR(a);
        
    }
    
    public AABRR Question1_4(){
        Question1_4 q4 = new Question1_4();
        return q4.randomAABRR(5, 1, 100);
        //return q4.randomAABRR(5, 1, 100);
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
        System.out.println("---------------------------------------------");
        Question2_1 q1 = new Question2_1();
        if(q1.rechercherABR(a, i) == false){
            System.out.println("Le chiffre entré n'appartient pas à un interval de l'AABRR");
        };
        System.out.println("---------------------------------------------");
    }
    
    public void Question2_2 (AABRR a, int i) throws IOException{
        Question2_2 q2 = new Question2_2();
        q2.testSuppressABR(a,i);
    }
    
    public void Question2_3 (AABRR a, int i) throws IOException{
        Question2_3 q3 = new Question2_3();
        q3.insertionAABRR(a,i);
    }
    
    public void Question2_4 (AABRR a, int i){
        
    }
    
    public void Question2_5 (AABRR a){
        Question2_5 q5 = new Question2_5();
        Vector<Integer> abr_vector = new Vector<>();
        q5.parcoursAABRR(a,abr_vector);
        ABR abr = new ABR();
        for (Integer integer : abr_vector) {
            q5.insertionABR(abr, integer);
        }
        System.out.print("Affichage ABR exporté : ");
        q5.affichageABR(abr);
        System.out.print("\n");
        
    }

}
