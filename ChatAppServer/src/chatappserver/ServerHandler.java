/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author inc07hp
 */
public class ServerHandler extends Thread{

    private final ServerSocket server;
    
    public ServerHandler(ServerSocket server) {
        this.server = server;
    }
    
    @Override
    public void run(){
        while(true){
             //обработкаподключающихся клиентов
            try {
               Socket client = server.accept();
               ClientHandler handler = new ClientHandler(client);
               handler.start();
               ChatAppServer.handlers.put(client, handler);
            } catch (SocketException ex) {
                return;
            } catch (IOException ex){
                ex.printStackTrace();
            }
            try {               
                Thread.sleep(10);
            } catch (InterruptedException ex) {
               
            }
        }
    }
    
}
