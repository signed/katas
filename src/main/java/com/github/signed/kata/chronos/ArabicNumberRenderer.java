package com.github.signed.kata.chronos;

public class ArabicNumberRenderer implements NumberRenderer {

    @Override
    public String renderHoursOfDay(int hour) {
        return String.format("%02d", hour);
    }

    @Override
    public String renderSecondsOfMinute(int secondsOfMinute) {
        return String.format("%02d", secondsOfMinute);
    }

    @Override
    public String renderMinutesOfHour(int minutesOfHour) {
        return String.format("%02d", minutesOfHour);
    }
}
