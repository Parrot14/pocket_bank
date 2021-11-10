package mx.parrot14.util;

import java.util.concurrent.ConcurrentHashMap;

public class Banks {
    ConcurrentHashMap<String, Bank> banks;

    BankKiller bKiller;

    public Banks() {
        this.banks = new ConcurrentHashMap<>();
        this.bKiller = new BankKiller(banks);
    }
}
