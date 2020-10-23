/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThreadWrite extends Thread{

    @Override
    public void run() {
        try {
            File file = new File("C:/Users/Admin/Desktop/LTHT_CODE/De01/file.TXT");
        
            OutputStream outputStream = new FileOutputStream(file, true);

            PrintStream printStream = new PrintStream(outputStream);
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {                
                System.out.print("Enter string: ");
                String data = scanner.nextLine();
                printStream.println(data);
                if (data.equals("quit")) {
                    this.stop();
                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
    
}
