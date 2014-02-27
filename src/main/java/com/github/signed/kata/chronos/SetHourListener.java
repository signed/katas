package com.github.signed.kata.chronos;

import org.joda.time.DateTimeZone;

class SetHourListener implements EditListener {
    private final ChronosClockDisplay chronosClockDisplay;
    private final ChronosClock chronosClock;
    private final PresenterConfiguration configuration;

    public SetHourListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock, PresenterConfiguration configuration) {
        this.chronosClockDisplay = chronosClockDisplay;
        this.chronosClock = chronosClock;
        this.configuration = configuration;
    }

    @Override
    public void edit() {
        String userInput = chronosClockDisplay.hourValueFromUser();
        try {
            int hours = Integer.parseInt(userInput);
            if( hours < 0 || hours > 23 ){
                return;
            }
            int hourOfDay = chronosClock.now().withZone(configuration.timeZone).withHourOfDay(hours).withZone(DateTimeZone.UTC).getHourOfDay();
            chronosClock.setHoursOfDayTo(hourOfDay);
        } catch (NumberFormatException ex) {
            return;
        }
    }
}
