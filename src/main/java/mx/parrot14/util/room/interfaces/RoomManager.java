package mx.parrot14.util.room.interfaces;

import java.util.Map;

public interface RoomManager {
    
    public Room removeRoom(String code);
    public Map<String,Room> getBanks();
}
