/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatappserver.packet;

import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author inc07hp
 */
public class PacketManager {

    private final static Map<Short, Class<? extends OPacket>> packets = new HashMap<>();
    
    static {
        packets.put((short) 1, PacketAuthorize.class);
    }
    
    public static void read(short id, DataInputStream dis){
        try {
            OPacket packet = packets.get(id).newInstance();
            packet.read(dis);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
}
