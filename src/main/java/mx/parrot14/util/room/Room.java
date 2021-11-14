package mx.parrot14.util.room;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.ConcurrentHashMap;

import mx.parrot14.util.User;

public abstract class Room {
    private final String ownerName;
    private final User owner;
    private Boolean isClosed;
    private Boolean isStatic;

    private final ConcurrentHashMap<String, User> users;

    private LocalDateTime executionSchedule = LocalDateTime.now().plus(1L, ChronoUnit.MINUTES);

    /**
     * Creates a room to be submitted to a {@link mx.parrot14.util.room.RoomManager RoomManager}
     * instance or child instance
     * @param ownerName the user name used for the owner
     * @param owner a {@link mx.parrot14.util.User User} instance representing the owner initial data
     * @see RoomManager
     */
    public Room(String ownerName, User owner) {
        this.ownerName = ownerName;
        this.owner = owner;

        this.users = new ConcurrentHashMap<String, User>();
        this.isClosed = false;
        this.isStatic = false;
    }

    /**
     * Get the actual scheduled time to destroy the room if the owner still absent
     * after the time.
     * @return {@link LocalDateTime} if the owner is absent, or {@code null} if the owner is no absent
     */
    public LocalDateTime getExecutionSchedule() {
        return executionSchedule;
    }

    /**
     * Set the {@link #isClosed()} value to {@code false} and execute the
     * method {@link User#die()} for every user of the room, includes the owner.
     * @return {@code true} always
     */
    public Boolean letItDie() {
        isClosed = true;
        owner.die();
        for (User user : users.values()) {
            user.die();
        }
        return true;
    }

    /**
     * Checks if the name exist on the room, includes owner
     * @param name the user name to check
     * @return {@code true} if the name exist, otherwise {@code false}
     */
    public Boolean containsUser(String name) {
        return name.equals(ownerName) ? true : users.containsKey(name);
    }

    /**
     * Checks if the givne name is the name of the owner
     * @param name the user name to check
     * @return {@code true} if the name is equal to the owner name, otherwise {@code false}
     */
    public Boolean isOwner(String name){
        return name.equals(ownerName);
    }

    /**
     * Returns the "close" state of the room, closed rooms shall not accept new users
     * nor connections
     * @return {@code true} if the room is closed, otherwise {@code false}
     */
    public Boolean isClosed(){
        return isClosed;
    }

    /**
     * Returns the "static" state of the room, static rooms shall not increase their user capacity
     * @return {@code true} if the room is static, otherwise {@code false}
     */
    public Boolean isStatic(){
        return isStatic;
    }

    /**
     * Checks if the user with the given name is online
     * @param name the user name to check
     * @return {@code true} if the user is online, otherwise {@code false}
     */
    public Boolean isOnline(String name) {
		return users.get(name).isOnline();
	}
    /**
     * TODO create documentation
     */
    public Boolean addUser(String name){
        // TODO Auto-generated method stub
        return false;
    }
}
