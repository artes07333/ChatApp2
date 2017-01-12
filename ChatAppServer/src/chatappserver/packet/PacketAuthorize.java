/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappserver.packet;

import chatappserver.ChatAppServer;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author inc07hp
 */
public class PacketAuthorize extends OPacket{

    private String nickname;
    
    public PacketAuthorize(){
        
    }

    public PacketAuthorize(String nickname) {
        this.nickname = nickname;
    }
    
    
    
    @Override
    public short getID() {
        return 1;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
       
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        nickname = dis.readUTF();
    }
    
    @Override
    public void handle(){
        ChatAppServer.getHandler(getSocket()).setNickname(nickname);
        System.out.println("My nickname is "+ nickname);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
        }
        ChatAppServer.end();
    }
    
}
