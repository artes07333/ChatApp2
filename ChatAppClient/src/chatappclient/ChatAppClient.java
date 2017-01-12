/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappclient;

import chatappclient.packet.OPacket;
import chatappclient.packet.PacketAuthorize;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
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
        readChat();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
        }
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
    
    private static void readChat(){
        Scanner scan = new Scanner(System.in);
        while(true){
            if(scan.hasNextLine()){
                String line = scan.nextLine();
                System.out.println(line);
                
            }else
                try{
                    Thread.sleep(10);
                }catch(InterruptedException ex){}
        }
    }
    
    private static void end(){
        try {
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
