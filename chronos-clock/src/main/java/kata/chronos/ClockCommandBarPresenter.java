package kata.chronos;

import kata.chronos.gui.ClockCommandBar;

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
        clockCommandBar.addTimeToggleListener(ClockCommandBarPresenter.this.chronosClock::toggleTimeProgression);

        clockCommandBar.addReverseTimeListener(ClockCommandBarPresenter.this.chronosClock::reverseTime);
        clockCommandBar.addSwitchNumberSystemListener(ClockCommandBarPresenter.this.numberSystemModel::toggleNumericSystem);
    }

}
