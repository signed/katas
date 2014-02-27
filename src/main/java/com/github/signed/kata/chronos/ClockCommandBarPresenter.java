package com.github.signed.kata.chronos;

public class ClockCommandBarPresenter {

    private final ChronosClock chronosClock;
    private final ClockCommandBar clockCommandBar;

    public ClockCommandBarPresenter(ChronosClock chronosClock, ClockCommandBar clockCommandBar) {
        this.chronosClock = chronosClock;
        this.clockCommandBar = clockCommandBar;
        chronosClock.addTimeProgressionListener(new TimeProgressionListener() {
            @Override
            public void stopped() {
                ClockCommandBarPresenter.this.clockCommandBar.displayStartTimeButton();
            }

            @Override
            public void progresses() {
                ClockCommandBarPresenter.this.clockCommandBar.displayStopTimeButton();
            }
        });
        clockCommandBar.addTimeToggleListener(new ToggleTimeProgression() {
            @Override
            public void toggle() {
                ClockCommandBarPresenter.this.chronosClock.toggleTimeProgression();
            }
        });

        clockCommandBar.addReverseTimeListener(new ReverseTimeListener() {
            @Override
            public void reverseTime() {
                ClockCommandBarPresenter.this.chronosClock.reverseTime();
            }
        });
    }

}
