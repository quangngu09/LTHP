/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.DataInputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Client {
    public static void main(String[] args) {
        try {
            
            Scanner scanner = new Scanner(System.in);
            
            int port;
            String address;
            
            System.out.print("Enter address server: ");
            address = scanner.nextLine();
            
            System.out.print("Enter port: ");
            port = scanner.nextInt();
            Socket socket = new Socket(address, port);
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            System.out.println("Current time: " + dataInputStream.readUTF());
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
