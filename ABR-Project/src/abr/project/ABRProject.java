/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author theo
 */
public class ABRProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        while(true) {
            display();
        }

    }
    
    
    public void fileToArbre (String filepath){
        String line;
        try {
            FileReader fr = new FileReader(filepath);
            BufferedReader br = new BufferedReader(fr);
            while ((line = br.readLine()) != null){
                    String[] arbre_from_string = line.split(";");
                    for (int i = 0; i<arbre_from_string.length; i++){

                        System.out.println(arbre_from_string[i]);
                    }
            }
        }
        catch(IOException e) {
            System.out.println(e);
        }

    }

    
    public void arbreToFile (String url, AABRR a) throws IOException{
        try {
            FileWriter fichier = new FileWriter(url);
            
            //int m = a.getm();
            //int M = a.getM();
            //fichier.write(m+":"+M+";");

            
            fichier.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }

    public static void  display(){
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
                break;
            case 2:
                System.out.println("AABRR vers fichier");
                break;
            case 3:
                System.out.println("Affichage à l'écran");
                break;
            case 4:
                System.out.println("AABRR aléatoire");
                break;
            case 5:
                System.out.println("Vérification");
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
