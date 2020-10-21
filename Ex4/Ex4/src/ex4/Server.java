/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Admin
 */
public class Server {
    
   public static int fibonaci(int number){
       if (number == 1 || number == 2) {
           return 1;
       }
       return fibonaci(number - 1) + fibonaci(number - 2);
   }
    
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1209);
            
            Socket socket = serverSocket.accept();
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            while (true) {                
                String dataClient = dataInputStream.readUTF();
                String valueFibonaci = Integer.toString(fibonaci(Integer.parseInt(dataClient)));
                System.out.println("" + fibonaci(Integer.parseInt(dataClient)));
                dataOutputStream.writeUTF(valueFibonaci);
                dataOutputStream.flush();
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
