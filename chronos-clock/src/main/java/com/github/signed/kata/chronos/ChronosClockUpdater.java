package com.github.signed.kata.chronos;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChronosClockUpdater {

    private final ChronosClock chronosClock;
    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    public ChronosClockUpdater(ChronosClock chronosClock) {
        this.chronosClock = chronosClock;
    }

    public void startUpdating() {
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                chronosClock.determineNow();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);
    }

    public void shutdown() {
        scheduler.shutdownNow();
    }
}
