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
public class PacketMessage extends OPacket{

    private String sender, message;

    public PacketMessage() {
    }

    public PacketMessage(String sender, String message) {
        this.sender = sender;
        this.message = message;
    }
          
    @Override
    public short getId() {
        return 2;
    }

    @Override
    public void write(DataOutputStream dos) throws IOException {
        dos.writeUTF(sender);
        dos.writeUTF(message);
    }

    @Override
    public void read(DataInputStream dis) throws IOException {
        message = dis.readUTF();
    }

    @Override
    public void handle() {
        sender = ServerLoader.getHandler(getSocket()).getNickname();
        ServerLoader.handlers.keySet().forEach(s -> ServerLoader.sendPacket(s, this));
        System.out.println(String.format("[%s] %s", sender, message));
    }
    
}
