package mx.parrot14.util.room.murder;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import mx.parrot14.util.room.Room;
import mx.parrot14.util.room.RoomManager;

public class RoomKiller {
    private final Timer timer;
    private final TimedCheck tcheck;
    private final ExecutorService roomExecutor;

    private final RoomManager manager;

    /**
     * Creates the process required to destroy rooms
     * after the owner absence, uses the method {@link mx.parrot14.util.room.Room#getExecutionSchedule()}
     * to check and try to kill the room,with precision on 1 minute
     * @param manager RoomManager or child
     * @see RoomManager
     * @see Timer
     * @see TimedCheck
     */
    public RoomKiller(RoomManager manager){
        this.manager = manager;

        this.timer = new Timer(true);
        this.tcheck = new TimedCheck(manager,this);
        this.roomExecutor = Executors.newFixedThreadPool(5);

        timer.schedule(tcheck, 6_0000L);
    }

    /**
     * Uses a list of {@code String} that contains the codes of the
     * rooms to kill, removes the room {@link mx.parrot14.util.room.RoomManager#removeRoom(String)}
     * and execute the method {@link mx.parrot14.util.room.Room#letItDie()} of every removed {@code Room}
     * instance
     * @param murderList list of the codes of the rooms to kill
     * @see Room
     */
    protected void submitKillingJob(ArrayList<String> murderList) {
        murderList.forEach((toKill)->{
            Room r = manager.removeRoom(toKill);
            roomExecutor.execute(()->{
                r.letItDie();
            });
        });
    }
}
