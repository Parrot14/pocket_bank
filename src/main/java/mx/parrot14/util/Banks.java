package mx.parrot14.util;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import mx.parrot14.util.room.interfaces.Room;
import mx.parrot14.util.room.interfaces.RoomManager;
import mx.parrot14.util.room.murder.RoomKiller;

public class Banks implements RoomManager {
    ConcurrentHashMap<String, Bank> banks;

    RoomKiller roomKiller;

    public Banks() {
        this.banks = new ConcurrentHashMap<>();
        this.roomKiller = new RoomKiller(this);
    }

    @Override
    public Room removeRoom(String code) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Map<String, Room> getBanks() {
        return Collections.unmodifiableMap(banks);
    }
}
