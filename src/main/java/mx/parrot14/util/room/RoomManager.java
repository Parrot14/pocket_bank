package mx.parrot14.util.room;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import mx.parrot14.util.Misc;
import mx.parrot14.util.room.murder.RoomKiller;

public abstract class RoomManager {
    private final ConcurrentHashMap<String, Room> rooms;
    private final RoomKiller roomKiller;

    /**
     * Creates a {@link RoomManager} instance, also contains a new instance of {@link RoomKiller}
     */
    public RoomManager(){
        this.rooms = new ConcurrentHashMap<String, Room>();
        this.roomKiller = new RoomKiller(this);
    }
    /**
     * Checks if the given {@code roomid} would accept a incoming
     * connection of a user with the given name.
     * 
     * @param roomId the room the user tries to join
     * @param name the name the user wants to use
     * @return {@code false}<p>
     *  if the given room does not exist, or<p>
     *  if the room is closed, or<p>
     *  if the room contains a user whit the given name but is online, or<p>
     *  if the room does not contains a user whit the given name but is static, <p>
     *  otherwise {@code true}<p>
     */
    public Boolean canJoin(String roomId, String name){
        if (rooms.containsKey(roomId)) {
            Room bank = rooms.get(roomId);
            if (bank.isClosed())
                return false;

            if (bank.containsUser(name)) {
                if (bank.isOnline(name))
                    return false;
                return true;
            }

            if (bank.isStatic())
                return false;

            return true;
        }
        return false;
    }

    /**
     * Logically equal to {@link #canJoin(String, String)},
     * only diference is, if the room is not static and the given user name
     * does not exist, then the room adds the given user
     * @param roomId
     * @param name
     * @return {@code true} or {@code false}
     * @see #canJoin(String, String)
     */
    public Boolean joinRoom(String roomId, String name) {
        if (rooms.containsKey(roomId)) {
            Room bank = rooms.get(roomId);
            if (bank.isClosed())
                return false;

            if (bank.containsUser(name)) {
                if (bank.isOnline(name))
                    return false;
                return true;
            }

            if (bank.isStatic())
                return false;

            bank.addUser(name);
            return true;
        }
        return false;
    }

    /**
     * Adds the given {@link Room} instance or child instance
     * with a random 6 characters random id using {@link Misc#generateRandomID(Integer)}
     * @param room a {@link Room} instance or child instance
     * @return 6 character random ID
     * @see Misc#generateRandomID(Integer)
     */
    public String addRoom(Room room) {
        String id;

        do {
            id = Misc.generateRandomID(6);
        } while (rooms.containsKey(id));

        rooms.put(id, room);

        return id;
    }

    /**
     * Removes the rooms from the list
     * @param code the code of the room to be removed
     * @return {@link Room} instance or child instance of the removed code
     */
    public Room removeRoom(String code) {
        return rooms.remove(code);
    }

    /**
     * @return READ-ONLY copy of the original rooms map
     */
    public Map<String, Room> getRooms() {
        return Collections.unmodifiableMap(rooms);
    }
}
