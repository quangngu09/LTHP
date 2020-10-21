/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 1209);
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {                
                System.out.print("Enter number (Limit 0 -> 9) : ");
                dataOutputStream.writeUTF(scanner.nextLine());
                dataOutputStream.flush();
                System.out.println("Convert to string: " + dataInputStream.readUTF());
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
