/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Vector;

/**
 *
 * @author Théo
 */
public class Question1_1 {
    
    public AABRR AABRRfromFile(String filepath) throws IOException{
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
        Vector<Vector<Integer>> infixe_tab = new Vector<>();
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
            infixe_tab.add(new Vector<>());
            tab = string.split(";");
            for (String string1 : tab) {
                String[] tab2 = string1.split(":");
                for (String string2 : tab2) {
                    prefixe_tab.get(numNoeud).add(Integer.parseInt(string2));
                    infixe_tab.get(numNoeud).add(Integer.parseInt(string2));
                }
            }
            numNoeud++;
        }
        
        //Tri tab prefixe pour obtenir tab infixe
        
        
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
        
        //Tri des noeuds du grand arbres pour avoir le parcours infixe de l' AABRR
        boolean pivot;
        do {
                pivot = false;
                for (int i = 0; i < infixe_tab.size() - 1; i++) {
                        Vector<Integer> vector = infixe_tab.elementAt(i);
                        Vector<Integer> next_vector = infixe_tab.elementAt(i+1);
                        
                        if (vector.elementAt(0) > next_vector.elementAt(0)) {
                            infixe_tab.remove(vector);
                            infixe_tab.remove(next_vector);
                            infixe_tab.add(i,next_vector);
                            infixe_tab.add(i+1,vector);
                            pivot = true;
                        }
                }
        } while (pivot);
        
        
        AABRR a = new AABRR();
        return a.constructeurAABRR(prefixe_tab,0,prefixe_tab.size()-1,infixe_tab,0,infixe_tab.size()-1);

    }
}
