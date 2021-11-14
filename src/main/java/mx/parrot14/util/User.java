package mx.parrot14.util;

import java.util.UUID;

public abstract class User {
    private String transactionUUID;

    public abstract void die();

    public String getTransactionUUID(){
        return transactionUUID;
    }

    public String updateTransactionUUID(){
        transactionUUID = UUID.randomUUID().toString();
        return transactionUUID;
    }

    public boolean isOnline() {
        return false;
    }
}
