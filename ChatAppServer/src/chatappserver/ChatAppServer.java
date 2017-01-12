/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inc07hp
 */
public class ChatAppServer {

    private static ServerSocket server;
    
    public static void main(String[] args) {
        start();
        handle();
        end();
    }
    
    private static void handle(){
        while(true){
             //обработкаподключающихся клиентов
            try {
               Socket client= server.accept();
               new ClientHandler(client);
            } catch (IOException ex) {
                Logger.getLogger(ChatAppServer.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
               
                Thread.sleep(10);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
    private static void start(){
        try {
            server = new ServerSocket(8888);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private static void end(){
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
