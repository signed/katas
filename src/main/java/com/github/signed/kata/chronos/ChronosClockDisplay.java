package com.github.signed.kata.chronos;

public interface ChronosClockDisplay {

    void displayHours(String hours);
    void addHourEditListener(EditListener editListener);
    String hourValueFromUser();

    void displayMinutes(String minutes);
    void addMinuteEditListener(EditListener editListener);
    String minuteValueFromUser();

    void displaySeconds(String seconds);
    void addSecondEditListener(EditListener editListener);
    String secondValueFromUser();

    void displayCity(String city);

}
