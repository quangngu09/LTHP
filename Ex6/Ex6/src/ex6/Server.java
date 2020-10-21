/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Date;
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
            
            while (true) {                
                String option = dataInputStream.readUTF();
                
                Date date = new Date();
               
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(date);
                
                String dataSend;
               
                switch(option){
                  case "2":
                      dataSend = "Hour now: " + calendar.get(Calendar.HOUR);
                      break;
                  case "1":
                      dataSend = "Day now: " + calendar.get(Calendar.DAY_OF_MONTH);
                      break;
                  case "3":
                      dataSend = "Hour now: " + calendar.get(Calendar.HOUR) + ", Day now: " + calendar.get(Calendar.DAY_OF_MONTH);
                      break;
                  default:
                         dataSend= "Retry enter option !";
                }
                dataOutputStream.writeUTF(dataSend);
                dataOutputStream.flush();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
