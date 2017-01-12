/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2client.packet;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

/**
 *
 * @author inc07hp
 */
public abstract class OPacket {
    
    public abstract short getId();
    
    public abstract void write(DataOutputStream dos) throws IOException;
    
    public abstract void read(DataInputStream dis) throws IOException;
    
    public abstract void handle();
    
}
