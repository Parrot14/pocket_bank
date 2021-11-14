package mx.parrot14.util;

import mx.parrot14.util.room.Room;

public class Bank extends Room {

    public Bank(String ownerName){
        super(ownerName,new User() {

            @Override
            public void die() {
                // TODO Auto-generated method stub
                
            }
            
        });
    }
}