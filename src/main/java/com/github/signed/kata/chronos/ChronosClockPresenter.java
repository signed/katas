package com.github.signed.kata.chronos;

import org.joda.time.DateTime;

public class ChronosClockPresenter {

    private final ChronosClock chronosClock;
    private final PresenterConfiguration configuration;
    private final ChronosClockDisplay chronosClockDisplay;

    public ChronosClockPresenter(ChronosClock chronosClock, ChronosClockDisplay chronosClockDisplay, PresenterConfiguration configuration) {
        this.configuration = configuration;
        this.chronosClock = chronosClock;
        this.chronosClockDisplay = chronosClockDisplay;
        chronosClock.addTimeChangedListener(new TimeChangedListener() {
            @Override
            public void timeChanged() {
                ChronosClockPresenter.this.present();
            }
        });
    }

    public void present() {
        DateTime now = chronosClock.now().toDateTime(configuration.timeZone);
        chronosClockDisplay.displayHours(String.format("%02d",now.getHourOfDay()));
        chronosClockDisplay.displayMinutes(String.format("%02d", now.getMinuteOfHour()));
        chronosClockDisplay.displaySeconds(String.format("%02d", now.getSecondOfMinute()));
        chronosClockDisplay.displayCity(configuration.city);
    }
}
