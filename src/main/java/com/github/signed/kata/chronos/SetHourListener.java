package com.github.signed.kata.chronos;

import org.joda.time.DateTimeZone;

class SetHourListener implements EditListener {
    private final ChronosClockDisplay chronosClockDisplay;
    private final ChronosClock chronosClock;
    private final PresenterConfiguration configuration;
    private final NumberParser numberParser = new NumberParser();

    public SetHourListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock, PresenterConfiguration configuration) {
        this.chronosClockDisplay = chronosClockDisplay;
        this.chronosClock = chronosClock;
        this.configuration = configuration;
    }

    @Override
    public void edit() {
        String userInput = chronosClockDisplay.hourValueFromUser();
        numberParser.parseNumberFrom(userInput, new NumberParser.ParseResult() {
            @Override
            public void parsed(int value) {
                updateModel(value);
            }
        });
    }

    private void updateModel(int hours) {
        if (hours < 0 || hours > 23) {
            return;
        }
        int hourOfDay = chronosClock.now().withZone(configuration.timeZone).withHourOfDay(hours).withZone(DateTimeZone.UTC).getHourOfDay();
        chronosClock.setHoursOfDayTo(hourOfDay);
    }
}
