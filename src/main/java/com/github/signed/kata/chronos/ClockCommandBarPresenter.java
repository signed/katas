package com.github.signed.kata.chronos;

import com.github.signed.kata.chronos.swing.ClockCommandBar;

public class ClockCommandBarPresenter {

    private final ChronosClock chronosClock;
    private final ClockCommandBar clockCommandBar;
    private final NumberSystemModel numberSystemModel;

    public ClockCommandBarPresenter(ChronosClock chronosClock, ClockCommandBar clockCommandBar, NumberSystemModel numberSystemModel) {
        this.chronosClock = chronosClock;
        this.clockCommandBar = clockCommandBar;
        this.numberSystemModel = numberSystemModel;
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
        clockCommandBar.addSwitchNumberSystemListener(new SwitchNumberSystemListener() {
            @Override
            public void switchNumberSystem() {
                ClockCommandBarPresenter.this.numberSystemModel.toggleNumericSystem();
            }
        });
    }

}
