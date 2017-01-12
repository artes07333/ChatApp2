/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2server.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author inc07hp
 */
public abstract class OPacket {
    
    private Socket socket;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }
    
    
    
    public abstract short getId();
    
    public abstract void write(DataOutputStream dos) throws IOException;
    
    public abstract void read(DataInputStream dis) throws IOException;
    
    public abstract void handle();
    
}
