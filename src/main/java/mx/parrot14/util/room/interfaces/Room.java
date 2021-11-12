package mx.parrot14.util.room.interfaces;

import java.time.LocalDateTime;

public interface Room {
    public boolean letItDie();
    public LocalDateTime getExecutionSchedule();   
}
