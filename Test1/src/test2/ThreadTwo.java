/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test2;

/**
 *
 * @author Admin
 */
public class ThreadTwo extends Thread{

    public ThreadOne threadOne;
    
    public ThreadTwo(ThreadOne threadOne) {
        this.threadOne = threadOne;
    }
    
    @Override
    public void run() {
        while (true) {            
            try {
                switch (this.threadOne.number){
                    case 0:
                        System.out.println("Khong");
                        break;
                    case 1:
                        System.out.println("Mot");
                        break;
                    case 2:
                        System.out.println("Hai");
                        break;
                    case 3:
                        System.out.println("Ba");
                        break;
                    case 4:
                        System.out.println("Bon");
                        break;
                    case 5:
                        System.out.println("Nam");
                        break;
                    case 6:
                        System.out.println("Sau");
                        break;
                    case 7:
                        System.out.println("Bay");
                        break;
                    case 8:
                        System.out.println("Tam");
                        break;
                    case 9:
                        System.out.println("Chin");
                        break;
                    default:
                        System.out.println("Falied");
                        break;
                        
                }
                Thread.sleep(1000);
            } catch (Exception e) {
                    System.err.println("sleep failed");
            }
        }
    }
    
}
