/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
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
    
    
    public AABRR fileToArbre (String filepath) throws IOException{
        String line;
        BufferedReader br = null;
        
        try {
            FileReader fr = new FileReader(filepath);
            br = new BufferedReader(fr);
        }
        catch(IOException e) {
            System.err.println("Fichier non trouvé : " + e);
        }
        
        Vector<String> grand_arbre_tab = new Vector<String>();;
        int i=0;
        String chaine = null;
        
        String ligne;
	while ((ligne=br.readLine())!=null){
            grand_arbre_tab.add(i,ligne);
            i++;
	}
	br.close(); 
        
       
        
        AABRR grand_arbre = new AABRR(grand_arbre_tab);
        return grand_arbre;
        
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
                //String str = input.nextLine();
                project.fileToArbre("AB_import");
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
