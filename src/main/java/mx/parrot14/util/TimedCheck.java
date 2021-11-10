package mx.parrot14.util;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;

public class TimedCheck extends TimerTask {
    private HashMap<String, Bank> t_banks = new HashMap<>();

    private final ConcurrentHashMap<String, Bank> banks;
    private final BankKiller killer;

    public TimedCheck(ConcurrentHashMap<String, Bank> banks, BankKiller killer){
        this.banks = banks;
        this.killer = killer;
    }

    @Override
    public void run() {
        ArrayList<String> toErase = new ArrayList<>();
        t_banks.clear();
        t_banks.putAll(banks);
        LocalDateTime now = LocalDateTime.now();
        t_banks.forEach((code, bank) -> {
            LocalDateTime executionSchedule = bank.getExecutionSchedule();
            if (now.isAfter(executionSchedule)) {
                toErase.add(code);
            }
        });
        killer.submitKillingJob(toErase);
    }

}
