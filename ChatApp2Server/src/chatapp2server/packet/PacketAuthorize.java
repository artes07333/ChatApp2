/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2server.packet;

import chatapp2server.ServerLoader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author inc07hp
 */
public class PacketAuthorize extends OPacket{

    private String nickname;

    public PacketAuthorize() {
    }

    public PacketAuthorize(String nickname) {
        this.nickname = nickname;
    }
    
    
    
    @Override
    public short getId() {
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
    public void handle() {
        ServerLoader.getHandler(getSocket()).setNickname(nickname);
        System.out.println("My nick is " + nickname);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {}
        ServerLoader.end();
    }
    
}
