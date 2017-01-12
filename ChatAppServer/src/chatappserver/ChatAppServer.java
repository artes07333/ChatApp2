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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inc07hp
 */
public class ChatAppServer {

    private static ServerSocket server;
    private static ServerHandler handler;
    static Map<Socket, ClientHandler> handlers = new HashMap<>();
    
    public static void main(String[] args) {
        start();
        handle();
        end();
    }
    
    private static void handle(){
        handler = new ServerHandler(server);
        handler.start();
    }
    
    public static ServerHandler getServerHandler(){
        return handler;
    }
    
    private static void start(){
        try {
            server = new ServerSocket(8888);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static void end(){
        try {
            server.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public static ClientHandler getHandler(Socket socket){
        return handlers.get(socket);
    }
    
    public static void invalidate(Socket socket){
        handlers.remove(socket);
    }
            
}
