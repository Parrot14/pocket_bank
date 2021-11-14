package mx.parrot14.util.room.murder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.TimerTask;

import mx.parrot14.util.room.Room;
import mx.parrot14.util.room.RoomManager;

public class TimedCheck extends TimerTask {
    private final RoomManager manager;
    private final RoomKiller roomKiller;

    /**
     * Creates a timerTask used for the roomKiller to enlist rooms with
     * expired {@link mx.parrot14.util.room.Room#getExecutionSchedule() Room#getExecutionSchedule()}
     * @param manager Used to retrieve the room Info
     * @param roomKiller Used to submit killing jobs
     * @see RoomKiller#submitKillingJob(ArrayList) killing jobs
     */
    public TimedCheck(RoomManager manager, RoomKiller roomKiller){
        this.manager = manager;
        this.roomKiller = roomKiller;
    }

    /**
     * Check the {@code LocalDateTime} or "execution schedule" of the
     * retrieved rooms from {@code RoomManager}, if the "execution schedule"
     * is before to {@code LocalDateTime.now();} then the id of that room is added to the list
     * otherwise do nothing.
     * After the fact the list is submitted to {@link mx.parrot14.util.room.murder.RoomKiller#submitKillingJob(ArrayList) RoomKiller#submitKillingJob(ArrayList)}
     * @see LocalDateTime
     * @see RoomManager
     * @see RoomKiller
     */
    @Override
    public void run() {
        Map<String, Room> rooms = manager.getRooms();
        ArrayList<String> toKill = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();

        rooms.forEach((code, room) -> {
            LocalDateTime executionSchedule = room.getExecutionSchedule();
            if ( executionSchedule != null && now.isAfter(executionSchedule)) {
                toKill.add(code);
            }
        });

        roomKiller.submitKillingJob(toKill);
    }

}
