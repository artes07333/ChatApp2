/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2server;

import chatapp2server.packet.OPacket;
import chatapp2server.packet.PacketManager;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author inc07hp
 */
public class ClientHandler extends Thread{

    private final Socket client;
    private String nickname = "Anonymous";
    
    public ClientHandler(Socket client){
        this.client = client;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    
    
    @Override
    public void run(){
        while(true){
            if(!readData())
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {}
        }
    }
    
    private boolean readData(){
        try {
            DataInputStream dis = new DataInputStream(client.getInputStream());
            if(dis.available() <= 0)
                return false;
            short id = dis.readShort();
            OPacket packet = PacketManager.getPacket(id);
            packet.setSocket(client);
            packet.read(dis);
            packet.handle();
        } catch (IOException e) {
        e.printStackTrace();
        }
        return true;
    }
    
    public void invalidate(){
        ServerLoader.invalidate(client);
    }
    
}
