/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ThreadOne extends Thread{
    
    public  static Integer number;
    @Override
    public void run() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter number (Limit 0 -> 0)");
            number = scanner.nextInt();
            if (number < 0 || number > 9) {
                this.stop();
            }
        }
    }
    
    
}
