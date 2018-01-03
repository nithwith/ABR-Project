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
    
    
    
    
    public AABRR Question1 (String filepath) throws IOException{
        Question1 q1 = new Question1();
        return q1.AABRRfromFile(filepath);
    }
    
    public void Question2(AABRR a){
        Question2 q2 = new Question2();
        q2.DisplayAABRR(a);
    }

    public void Question3 (String filepath, AABRR a) throws IOException{
        Question3 q3 = new Question3();
        q3.AABRRToFile(filepath, a);
    }
    
    public AABRR Question4(){
        Question4 q4 = new Question4();
        return q4.randomAABRR();
    }
    
    public boolean Question5(AABRR a){
        Question5 q5 = new Question5();
        return q5.verifABR(a) && q5.intervalmMDisjoint(a) && q5.ABRRDansInterval(a);
    }
    

    
    public static void  display() throws IOException{
        ABRProject project = new ABRProject();
        
        Scanner input = new Scanner(System.in);
        System.out.println("-- Actions --");
        System.out.println(
                "Sélectionner une option: \n" +
                        "  1) Ficher vers AABRR\n" +
                        "  2) AABRR vers fichier\n" +
                        "  3) Affichage à l'écran\n" +
                        "  4) AABRR aléatoire\n " +
                        "  5) Vérification\n " +
                        "  6) Quitter\n "
        );
        System.out.print("Rentrez votre choix: ");
        int selection = input.nextInt();
        input.nextLine();
        switch (selection) {
            case 1:
                System.out.println("Fichier vers AABRR");
                System.out.println("Emplacement du fichier (jeu de données : AB_import)");
                project.Question1("AB_import");
                break;
            case 2:
                System.out.println("AABRR vers fichier");
                AABRR a = project.Question1("AB_import");
                project.Question3("AB_import",a);
                break;
            case 3:
                System.out.println("Affichage à l'écran");
                AABRR b = project.Question1("AB_import");
                project.Question2(b);
                break;
            case 4:
                System.out.println("AABRR aléatoire");
                AABRR c = project.Question4();
                project.Question2(c);
                break;
            case 5:
                System.out.println("Vérification");
                AABRR d = project.Question1("AB_import");
                project.Question5(d);
                break;
            case 6:
                System.out.println("Exiting...");
                System.exit(1);
                break;
            default:
                System.out.println("Aucune correspondance.");
                break;
        }
    }


}
