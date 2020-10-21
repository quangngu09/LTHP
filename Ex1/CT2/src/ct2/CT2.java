/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ct2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class CT2 extends Thread{
    
    @Override
    public void run() {
        try {
            File file = new File("C:/Users/Admin/Desktop/LTHT_CODE/Ex1/document.TXT");
            
            InputStream inputStream = new FileInputStream(file);
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            
            flag:
            while (true) {
                String lineString;
                while ((lineString = bufferedReader.readLine()) != null) {                    
                    System.out.println(lineString);
                    if (lineString.contains("!")) {
                        break flag;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CT2 ct2 = new CT2();
        ct2.start();
        
    }
    
}
