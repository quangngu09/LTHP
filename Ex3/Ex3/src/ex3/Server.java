/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(1209);
            
            Socket socket = serverSocket.accept();
            
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            Scanner scanner = new Scanner(System.in);
            
            while (true) {                
                String[][] aStringses = {
                    {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
                    {"Khong" ,"Mot", "Hai", "Ba", "Bon", "Nam", "Sau", "Bay", "Tam", "Chin"}
                };
                while (true) {                    
                    String dataClient = dataInputStream.readUTF();
                    String dataSend = "";
                    boolean status = false;
                    for(int i = 0; i < 9; i++){
                        if (dataClient.equals(aStringses[0][i])) {
                            status = true;
                            break;
                        }
                    }
                    dataSend = status ? aStringses[1][Integer.parseInt(dataClient)] : "Khong phai so nguyen";
                    dataOutputStream.writeUTF(dataSend);
                    dataOutputStream.flush();
                }
                
                
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
