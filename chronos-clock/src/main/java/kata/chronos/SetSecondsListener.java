package kata.chronos;

import kata.chronos.gui.ChronosClockDisplay;
import kata.chronos.gui.EditListener;

class SetSecondsListener implements EditListener {
    private final ChronosClockDisplay chronosClockDisplay;
    private final ChronosClock chronosClock;
    private final NumberParser numberParser = new NumberParser();

    public SetSecondsListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock) {
        this.chronosClockDisplay = chronosClockDisplay;
        this.chronosClock = chronosClock;
    }

    @Override
    public void edit() {
        String secondsAsString = chronosClockDisplay.secondValueFromUser();
        numberParser.parseNumberFrom(secondsAsString, seconds -> {
            if (seconds < 0 || seconds > 59) {
                return;
            }
            chronosClock.setSecondsOfHourTo(seconds);
        });
    }
}
