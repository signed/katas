package com.github.signed.kata.chronos;

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
        numberParser.parseNumberFrom(secondsAsString, new NumberParser.ParseResult() {
            @Override
            public void parsed(int seconds) {
                if( seconds < 0 || seconds > 59){
                    return;
                }
                chronosClock.setSecondsOfHourTo(seconds);
            }
        });
    }
}
