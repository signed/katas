package com.github.signed.kata.chronos;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChronosClock {
    public static void main(String[] args) {

        final DateTime dateTime = parseTimeArgument(args[0]);

        final ChronosClock chronosClock = new ChronosClock(dateTime);

        final ChronosClockDisplay chronosClockDisplay = new ChronosClockDisplay();
        final ChronosClockPresenter presenter = new ChronosClockPresenter(chronosClock, chronosClockDisplay);

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                chronosClock.determineNow();
                presenter.present();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(chronosClockDisplay);
            }
        });
    }

    private static DateTime parseTimeArgument(String arg) {
        return new DateTime(Long.valueOf(arg), DateTimeZone.UTC);
    }

    private static void createAndShowGUI(ChronosClockDisplay display) {
        //Create and set up the window.
        JFrame frame = new JFrame("Chronos Clock");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display.component());
        frame.pack();
        frame.setVisible(true);
    }

    private DateTime lastUpdated;
    private DateTime now;

    public ChronosClock(DateTime dateTime) {
        this.now = dateTime;
        this.lastUpdated = new DateTime(DateTimeZone.UTC);
    }

    public void determineNow(){
        DateTime systemTime = new DateTime(DateTimeZone.UTC);
        long timePassedSinceLastUpdate = systemTime.getMillis() - lastUpdated.getMillis();
        now = now.plusMillis(Long.valueOf(timePassedSinceLastUpdate).intValue());
        lastUpdated = systemTime;
    }

    public DateTime now() {
        return now;
    }
}
