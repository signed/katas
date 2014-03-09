package com.github.signed.kata.chronos;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.EditListener;

class SetMinuteListener implements EditListener {
    private final ChronosClockDisplay chronosClockDisplay;
    private final ChronosClock chronosClock;
    private final NumberParser numberParser = new NumberParser();

    public SetMinuteListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock) {
        this.chronosClockDisplay = chronosClockDisplay;
        this.chronosClock = chronosClock;
    }

    @Override
    public void edit() {
        String minutesAsString = chronosClockDisplay.minuteValueFromUser();
        numberParser.parseNumberFrom(minutesAsString, new NumberParser.ParseResult() {
            @Override
            public void parsed(int minutes) {
                if (minutes < 0 || minutes > 59) {
                    return;
                }
                chronosClock.setMinutesOfHour(minutes);
            }
        });
    }
}
