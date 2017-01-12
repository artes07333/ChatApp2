/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2server.packet;

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
    
    static{
        packets.put((short) 1, PacketAuthorize.class);
    }
    
    public static OPacket getPacket(short id){
        try {
            return packets.get(id).newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
        ex.printStackTrace();
        return null;
        }
    }
    
}
