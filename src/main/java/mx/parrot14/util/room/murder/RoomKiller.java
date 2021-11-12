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

    public RoomKiller(RoomManager manager){
        this.manager = manager;

        this.timer = new Timer(true);
        this.tcheck = new TimedCheck(manager,this);
        this.roomExecutor = Executors.newFixedThreadPool(5);

        timer.schedule(tcheck, 6_0000L);
    }

    protected void submitKillingJob(ArrayList<String> murderList) {
        murderList.forEach((toKill)->{
            Room r = manager.removeRoom(toKill);
            roomExecutor.execute(()->{
                r.letItDie();
            });
        });
    }
}
