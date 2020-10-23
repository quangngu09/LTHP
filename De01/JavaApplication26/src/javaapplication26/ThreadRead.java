/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 *
 * @author Admin
 */
public class ThreadRead extends Thread{

    @Override
    public void run() {
        try {
            File file = new File("C:/Users/Admin/Desktop/LTHT_CODE/De01/file.TXT");
            
            InputStream inputStream = new FileInputStream(file);
            
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            flag:
            while (true) {
                String lineString;
                while ((lineString = bufferedReader.readLine()) != null) {                    
                    System.out.println(lineString);
                    if (lineString.contains("#")) {
                        break flag;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
