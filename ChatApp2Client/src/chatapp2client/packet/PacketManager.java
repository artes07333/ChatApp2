/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatapp2client.packet;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author inc07hp
 */
public class PacketManager {
    
    private final static Map<Short, Class<? extends OPacket>> packets = new HashMap<>();
    
    static{
        packets.put((short) 1, PacketAuthorize.class);
        packets.put((short) 2, PacketMessage.class);
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
