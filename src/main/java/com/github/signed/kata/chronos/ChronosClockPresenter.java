package com.github.signed.kata.chronos;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.TimeZone;

public class ChronosClockPresenter {
    private final ChronosClock chronosClock;
    private final ChronosClockDisplay chronosClockDisplay;

    public ChronosClockPresenter(ChronosClock chronosClock, ChronosClockDisplay chronosClockDisplay) {
        this.chronosClock = chronosClock;
        this.chronosClockDisplay = chronosClockDisplay;
    }

    public static DateTimeZone Athens() {
        TimeZone athens = TimeZone.getTimeZone("Europe/Athens");
        return DateTimeZone.forTimeZone(athens);
    }

    public void present() {
        DateTime now = chronosClock.now().toDateTime(Athens());

        chronosClockDisplay.displayHours(String.format("%02d",now.getHourOfDay()));
        chronosClockDisplay.displayMinutes(String.format("%02d", now.getMinuteOfHour()));
    }
}
