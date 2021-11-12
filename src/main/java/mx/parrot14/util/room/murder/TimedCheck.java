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

    public TimedCheck(RoomManager manager, RoomKiller roomKiller){
        this.manager = manager;
        this.roomKiller = roomKiller;
    }

    @Override
    public void run() {
        Map<String, Room> rooms = manager.getBanks();
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
