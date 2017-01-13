package chatapp2server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author inc07hp
 */
public class ServerLoader {
    
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
        readChat();
    }
    
    private static void readChat(){
        Scanner scan = new Scanner(System.in);
        while(true){
        if(scan.hasNextLine()){
            String line = scan.nextLine();
            System.out.println(line);
            if(line.equals("/end"))
                end();
        }else
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {}
        }
    }
    
    public static ServerHandler getServerHandler(){
        return handler;
    }
    
    private static void start(){
        try{
            server = new ServerSocket(8888);
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    public static void end(){
        try {
            server.close();
        } catch (IOException ex) {
        ex.printStackTrace();
        }
        System.exit(0);
    }
    
    public static ClientHandler getHandler(Socket socket){
        return handlers.get(socket);
    }
    
    public static void invalidate(Socket socket){
        handlers.remove(socket);
    }
    
}
