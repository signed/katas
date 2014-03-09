package com.github.signed.kata.chronos.gui;

public interface ClockCabinet {
    ChronosClockDisplay hourMinuteDisplay();

    ChronosClockDisplay stockExchangeClock();

    ClockCommandBar commandBar();
}
