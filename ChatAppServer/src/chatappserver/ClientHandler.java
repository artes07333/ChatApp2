/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappserver;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author inc07hp
 */
public class ClientHandler extends Thread{
    
    private final Socket client;
    
    public ClientHandler(Socket client){
        this.client = client;
        start();
    }
    
    @Override
    public void run(){
        while(true){
            readData();
            try{
             Thread.sleep(10);
            }catch(InterruptedException ex){
            }
        }
    }
    
    private void readData(){
        try {
            DataInputStream dis =new DataInputStream(client.getInputStream());
            if(dis.available() <= 0)
                return;
            short id = dis.readShort();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
