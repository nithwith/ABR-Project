/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abr.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Théo
 */
public class Question1_2 {
    
    public void AABRRToFile (String filepath, AABRR a) throws IOException{
        
        try {
            FileWriter fstream = new FileWriter(filepath);
            BufferedWriter export = new BufferedWriter(fstream);
            
            export.write(exportAABRRVersFichier(a));
            System.out.println("Export Realisé");
            export.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
    }
    
     public String exportAABRRVersFichier(AABRR a){
        String result = new String();
        result = a.getm()+ ":"+a.getM()+";"+ exportABRRVersFichier(a.getArbreBinaire(),true) +"\n";

        if (a.getGauche() != null)
            result = result + exportAABRRVersFichier(a.getGauche());
        if (a.getDroit() != null)
            result= result + exportAABRRVersFichier(a.getDroit());
        return result;
    }
     
     public String exportABRRVersFichier(ABRR a,boolean first){
        String result = new String();
        if (first)
            result = String.valueOf(a.getValeur()) ; 
        else
            result =":" + a.getValeur() ; 
        
        if (a.getGauche() != null)
            result = result + exportABRRVersFichier(a.getGauche(),false);
        if (a.getDroit() != null)
            result= result + exportABRRVersFichier(a.getDroit(),false);

        
        return result;
    }
    
}
