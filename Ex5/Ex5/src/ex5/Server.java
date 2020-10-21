/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex5;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Admin
 */
public class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Address Server: localhost \n Port: 1209");
            
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Calendar calendar = Calendar.getInstance();
            String time =  dateFormat.format(calendar.getTime());
            
            ServerSocket serverSocket = new ServerSocket(1209);
            
            Socket socket = serverSocket.accept();
            
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            
            if (socket.isConnected()) {
               dataOutputStream.writeUTF(time);
               dataOutputStream.flush();
            }
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
