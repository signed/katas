package com.github.signed.kata.chronos;

import org.joda.time.DateTime;

public class ChronosClockPresenter {

    private final ChronosClock chronosClock;
    private final PresenterConfiguration configuration;
    private final ChronosClockDisplay chronosClockDisplay;

    public ChronosClockPresenter(final ChronosClock chronosClock, final ChronosClockDisplay chronosClockDisplay, final PresenterConfiguration configuration) {
        this.configuration = configuration;
        this.chronosClock = chronosClock;
        this.chronosClockDisplay = chronosClockDisplay;
        chronosClock.addTimeChangedListener(new TimeChangedListener() {
            @Override
            public void timeChanged() {
                ChronosClockPresenter.this.present();
            }
        });
        chronosClockDisplay.addHourEditListener(new SetHourListener(chronosClockDisplay, chronosClock, configuration));
        chronosClockDisplay.addMinuteEditListener(new SetMinuteListener(chronosClockDisplay, chronosClock));
        chronosClockDisplay.addSecondEditListener(new SetSecondsListener(chronosClockDisplay, chronosClock));
    }

    public void present() {
        DateTime now = chronosClock.now().toDateTime(configuration.timeZone);
        chronosClockDisplay.displayHours(String.format("%02d", now.getHourOfDay()));
        chronosClockDisplay.displayMinutes(String.format("%02d", now.getMinuteOfHour()));
        chronosClockDisplay.displaySeconds(String.format("%02d", now.getSecondOfMinute()));
        chronosClockDisplay.displayCity(configuration.city);
    }

    private static class SetSecondsListener implements EditListener {
        private final ChronosClockDisplay chronosClockDisplay;
        private final ChronosClock chronosClock;

        public SetSecondsListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock) {
            this.chronosClockDisplay = chronosClockDisplay;
            this.chronosClock = chronosClock;
        }

        @Override
        public void edit() {
            String secondsAsString = chronosClockDisplay.secondValueFromUser();
            try{
                int seconds = Integer.parseInt(secondsAsString);
                if( seconds < 0 || seconds > 59){
                    return;
                }
                chronosClock.setSecondsOfHourTo(seconds);
            }catch(NumberFormatException ex){
                return;
            }
        }
    }
}
