package mx.parrot14.util;

import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankKiller {
    private final Timer timer;
    private final TimedCheck tcheck;
    private final ExecutorService executorService;

    ConcurrentHashMap<String, Bank> banks;

    public BankKiller(ConcurrentHashMap<String, Bank> banks){
        this.banks = banks;

        this.timer = new Timer(true);
        this.tcheck = new TimedCheck(banks,this);
        this.executorService = Executors.newFixedThreadPool(5);

        timer.schedule(tcheck, 12_0000L);
    }

    protected void submitKillingJob(ArrayList<String> murderList) {
        murderList.forEach((toKill)->{
            Bank b = banks.remove(toKill);
            executorService.execute(new ScheduledExecution(b));
        });
    }
}
