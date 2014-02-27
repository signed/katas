package com.github.signed.kata.chronos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChronosClockUpdater {

    private final ChronosClock chronosClock;

    public ChronosClockUpdater(ChronosClock chronosClock) {
        this.chronosClock = chronosClock;
    }

    public void startUpdating() {
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                chronosClock.determineNow();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }
}
