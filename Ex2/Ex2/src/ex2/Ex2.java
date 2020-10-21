/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex2;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Admin
 */
public class Ex2 {
    static int number = -1;
    static Scanner scanner = new Scanner(System.in);
    
    static void getNumber(){
        if(number == -1){
            return;
        }
        System.out.println("Number: " + number);
    }
    
    static void setNumber(){
        System.out.print("Enter number");
        number = scanner.nextInt();
    }
    
    static TimerTask taskGetNumber = new TimerTask() {
        @Override
        public void run() {
            getNumber();
        }
    };
    
    static TimerTask tastSetNumber = new TimerTask() {
        @Override
        public void run() {
            setNumber();
        }
    };
              
        
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Timer timerSetNumber, timerGetNumber;
        long delayTask1 = 51, delayTask2 = 101;
        timerSetNumber = new Timer("Timer Set Number");
        timerGetNumber = new Timer("Timer Get Number");
        
        timerSetNumber.schedule(tastSetNumber,0,delayTask1);
        timerGetNumber.schedule(taskGetNumber,0,delayTask2);
        
        if(number == 0){
            timerSetNumber.cancel();
            timerSetNumber.purge();
            timerGetNumber.cancel();
            timerGetNumber.purge();
        }
    }
    
}
