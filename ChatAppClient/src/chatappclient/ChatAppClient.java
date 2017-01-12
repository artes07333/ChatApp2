/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappclient;

import chatappclient.packet.OPacket;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inc07hp
 */
public class ChatAppClient {

    private static Socket socket;
    
    public static void main(String[] args) {
        connect();
        handle();
        end();
    }
    
    public static void sendPacket(OPacket packet){
        try{
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeShort(packet.getID());
            packet.write(dos);
            dos.flush();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private static void connect(){
        try {
            socket = new Socket("localhost", 8888);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }
    
    private static void handle(){
        
    }
    
    private static void end(){
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
