package mx.parrot14.util;

import java.time.LocalDateTime;

import mx.parrot14.util.room.interfaces.Room;

public class Bank implements Room{


    LocalDateTime executionSchedule;

    @Override
    public LocalDateTime getExecutionSchedule() {
        return executionSchedule;
    }

    @Override
    public boolean letItDie() {
        // TODO Auto-generated method stub
        return false;
    }
}