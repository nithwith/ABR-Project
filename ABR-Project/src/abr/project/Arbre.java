/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author theo
 */
public class Arbre {
    
    public void saveAABRR(String url, Noeud a) throws IOException{
        try {
            FileWriter fichier = new FileWriter(url);
            
            int val = a.getValeur();
            //int m = a.getm();
            //int M = a.getM();
            //fichier.write(m+":"+M+";");
            a.ParcoursPrefixe();
            if (a.getSousArbreGauche() != null)
                a.getSousArbreGauche().ParcoursPrefixe();
            if (a.getSousArbreDroit() != null)
                a.getSousArbreDroit().ParcoursPrefixe();

            
            fichier.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        
    }
    
}
