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
public class Question3 {
    public void AABRRToFile (String filepath, AABRR a) throws IOException{
        try {
            FileWriter fstream = new FileWriter("export.txt");
            BufferedWriter export = new BufferedWriter(fstream);
            
            export.write(a.exportAABRRVersFichier(a));
            System.out.println("Export Realisé");
            export.close();
        } catch (IOException e) {
          System.err.println("Error: " + e.getMessage());
        }
    }
}
