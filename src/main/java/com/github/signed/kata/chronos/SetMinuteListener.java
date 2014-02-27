package com.github.signed.kata.chronos;

class SetMinuteListener implements EditListener {
    private final ChronosClockDisplay chronosClockDisplay;
    private final ChronosClock chronosClock;

    public SetMinuteListener(ChronosClockDisplay chronosClockDisplay, ChronosClock chronosClock) {
        this.chronosClockDisplay = chronosClockDisplay;
        this.chronosClock = chronosClock;
    }

    @Override
    public void edit() {
        String minutesAsString = chronosClockDisplay.minuteValueFromUser();
        try{
            int minutes = Integer.parseInt(minutesAsString);
            if( minutes < 0 || minutes > 59){
                return;
            }
            chronosClock.setMinutesOfHour(minutes);
        }catch (NumberFormatException ex){
            return;
        }
    }
}
