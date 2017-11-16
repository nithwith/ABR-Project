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

/**
 * @author theo
 */
public class ABRProject {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("hello");


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

}
