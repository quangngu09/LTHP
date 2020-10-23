/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final02;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Admin
 */
public class Final02 {
    
    public static String st = "";
    
    public static Timer timerSetData;
    
    public static Timer timerGetData;
    
    public static void setData(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter string: ");
        st = scanner.nextLine();
    }
    
    public static void getData(){
        System.out.println("String: " + st);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        timerGetData = new Timer("Timer get Data");
        timerSetData = new Timer("Timer set Data");
        
        timerSetData.schedule(new TimerTask() {
            @Override
            public void run() {
                setData();
                if (st.equals("quit")) {
                    timerSetData.cancel();
                    timerSetData.purge();
                }
            }
        }, 0, 51);
        
        timerGetData.schedule( new TimerTask() {
            @Override
            public void run() {
                if (st.equals("quit")) {
                    timerGetData.cancel();
                    timerGetData.purge();
                }
                                getData();

            }
        } , 0, 3000);
        
        
    }
    
}
