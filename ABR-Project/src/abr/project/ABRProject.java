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
    
    
    
    
    public void fileToArbre (String filepath) throws IOException{
        String line = null;
        BufferedReader br = null;
        
        try {
            FileReader fr = new FileReader(filepath);
            br = new BufferedReader(fr);
        }
        catch(IOException e) {
            System.err.println("Fichier non trouvé : " + e);
        }
        
        
        Vector<Vector<Integer>> prefixe_tab = new Vector<>();
        
        Vector<String> fichier_string = new Vector<>();
        
        String ligne = null;
	while ((ligne=br.readLine())!=null){
            fichier_string.add(ligne);
        }
        br.close(); 
        
        
        //Construction tab int brut
        String[] tab=null;
        int numNoeud=0;
        
        for (String string : fichier_string) {
            prefixe_tab.add(new Vector<>());
            tab = string.split(";");
            for (String string1 : tab) {
                String[] tab2 = string1.split(":");
                
                
                for (String string2 : tab2) {
                    prefixe_tab.get(numNoeud).add(Integer.parseInt(string2));
                }
            }
            numNoeud++;
        }
        
            

      
        
        //Tri tab prefixe pour obtenir tab infixe
        
        Vector<Vector<Integer>> infixe_tab = prefixe_tab;
        
        
        //Tri des noeuds des petits arbres
        int rang=0;
        for (Vector<Integer> vector : infixe_tab) {
            Vector<Integer>petit_arbre_trie=new Vector<>();
            
            for (int k = 2; k < vector.size(); k++) {
                petit_arbre_trie.add(vector.get(k));
            }
            
            Collections.sort(petit_arbre_trie);
            
            for (int k = 2; k < vector.size(); k++) {
                vector.remove(k);
                vector.add(k, petit_arbre_trie.get(k-2));
            }             
        }
        
        //Tri des noeuds des grand arbres
        boolean permut;
 
        do {
                permut = false;
                for (int i = 0; i < infixe_tab.size() - 1; i++) {
                        Vector<Integer> vector = infixe_tab.elementAt(i);
                        Vector<Integer> next_vector = infixe_tab.elementAt(i+1);
                        
                        if (vector.elementAt(0) > next_vector.elementAt(0)) {
                            infixe_tab.remove(vector);
                            infixe_tab.remove(next_vector);
                            infixe_tab.add(i,next_vector);
                            infixe_tab.add(i+1,vector);
                            permut = true;
                        }
                }
        } while (permut);
        
       AABRR grandAbre = new AABRR(prefixe_tab,infixe_tab, 0,0,prefixe_tab.size(),infixe_tab.size());
        
       
        
        
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
