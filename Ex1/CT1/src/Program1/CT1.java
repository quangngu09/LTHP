/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Program1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class CT1 extends Thread{

    @Override
    public void run() {
        try {
            File file = new File("C:/Users/Admin/Desktop/LTHT_CODE/Ex1/document.TXT");
            
            OutputStream outputStream = new FileOutputStream(file, true);
            
            PrintStream printStream = new PrintStream(outputStream);
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {                
                String dataString;
                System.out.print("Enter string: ");
                dataString = scanner.nextLine();
                printStream.println(dataString);
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
        CT1 ct1 = new CT1();
        ct1.start();
    }
    
}
