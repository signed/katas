package com.github.signed.kata.chronos;

import com.google.common.collect.Sets;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import java.util.Set;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ChronosClock {

    public static void main(String[] args) {
        final DateTime dateTime = parseTimeArgument(args[0]);

        final ChronosClock chronosClock = new ChronosClock(dateTime);


        final JPanel clockCabinet = new JPanel();

        final HoursAndMinutes mountOlympusDisplay = new HoursAndMinutes();
        PresenterConfiguration olympusPresenter = new PresenterConfiguration(PresenterConfiguration.Athens(), "Olympus");
        final ChronosClockPresenter mountOlympusPresenter = new ChronosClockPresenter(chronosClock, mountOlympusDisplay, olympusPresenter);

        final StockExchangeDisplay newYorkDisplay = new StockExchangeDisplay();
        final ChronosClockPresenter newYorkPresenter = new ChronosClockPresenter(chronosClock, newYorkDisplay, new PresenterConfiguration(PresenterConfiguration.NewYork(), "NewYork"));

        final StockExchangeDisplay londonDisplay = new StockExchangeDisplay();
        final ChronosClockPresenter londonPresenter = new ChronosClockPresenter(chronosClock, londonDisplay, new PresenterConfiguration(PresenterConfiguration.London(), "London"));

        final StockExchangeDisplay tokyoDisplay = new StockExchangeDisplay();
        final ChronosClockPresenter tokyoPresenter = new ChronosClockPresenter(chronosClock, tokyoDisplay, new PresenterConfiguration(PresenterConfiguration.Tokyo(), "Tokyo"));

        ClockCommandBar clockCommandBar = new ClockCommandBar();
        ClockCommandBarPresenter clockCommandBarPresenter = new ClockCommandBarPresenter(chronosClock, clockCommandBar);

        clockCabinet.add(clockCommandBar.component());
        clockCabinet.add(newYorkDisplay.component());
        clockCabinet.add(londonDisplay.component());
        clockCabinet.add(mountOlympusDisplay.component());
        clockCabinet.add(tokyoDisplay.component());

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                chronosClock.determineNow();
                newYorkPresenter.present();
                londonPresenter.present();
                mountOlympusPresenter.present();
                tokyoPresenter.present();
            }
        }, 0, 50, TimeUnit.MILLISECONDS);


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(clockCabinet);
            }
        });
    }

    private static DateTime parseTimeArgument(String arg) {
        return new DateTime(Long.valueOf(arg), DateTimeZone.UTC);
    }

    private static void createAndShowGUI(JPanel display) {
        //Create and set up the window.
        JFrame frame = new JFrame("Chronos Clock");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }

    private final Set<TimeProgressionListener> progressionListeners = Sets.newHashSet();

    private DateTime lastUpdated;
    private DateTime now;
    private boolean timeStopped = false;
    private final SystemTimeClock systemTimeClock = new SystemTimeClock();
    public ChronosClock(DateTime dateTime) {
        this.now = dateTime;
        this.lastUpdated = systemTimeClock.now();
    }

    public void determineNow() {
        if (timeStopped) {
            return;
        }
        DateTime systemTime = systemTimeClock.now();
        long timePassedSinceLastUpdate = systemTime.getMillis() - lastUpdated.getMillis();
        now = now.plusMillis(Long.valueOf(timePassedSinceLastUpdate).intValue());
        lastUpdated = systemTime;
    }

    public void addTimeProgressionListener(TimeProgressionListener timeProgressionListener) {
        this.progressionListeners.add(timeProgressionListener);
        fire(timeProgressionListener);
    }

    public DateTime now() {
        return now;
    }

    public void stopTime() {
        determineNow();
        timeStopped = true;
        notifyProgressionListeners();
    }

    public void startTime() {
        timeStopped = false;
        lastUpdated = systemTimeClock.now();
        notifyProgressionListeners();
    }

    private void notifyProgressionListeners() {
        for (TimeProgressionListener progressionListener : progressionListeners) {
            fire(progressionListener);
        }
    }

    private void fire(TimeProgressionListener progressionListener) {
        if (timeStopped) {
            progressionListener.stopped();
        } else {
            progressionListener.progresses();
        }
    }

    public void toggleTimeProgression() {
        if(timeStopped){
            startTime();
        }else{
            stopTime();
        }
    }
}
