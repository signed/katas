package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.EditListener;
import javafx.scene.Parent;

public class JavaFxHourAndMinutes implements ChronosClockDisplay {

    private final JavaFxTime time = JavaFxTime.HoursAndMinutes();


    @Override
    public void displayHours(String hours) {
        this.time.displayHours(hours);
    }

    @Override
    public void addHourEditListener(EditListener editListener) {
        time.addEditListener(JavaFxTime.Type.Hours, editListener);
    }

    @Override
    public String hourValueFromUser() {
        return time.valueFromUserFor(JavaFxTime.Type.Hours);
    }

    @Override
    public void displayMinutes(String minutes) {
        time.displayMinutes(minutes);
    }

    @Override
    public void addMinuteEditListener(EditListener editListener) {
        time.addEditListener(JavaFxTime.Type.Minutes, editListener);
    }

    @Override
    public String minuteValueFromUser() {
        return time.valueFromUserFor(JavaFxTime.Type.Minutes);
    }

    @Override
    public void displaySeconds(String seconds) {
        //nothing to do
    }

    @Override
    public void addSecondEditListener(EditListener editListener) {
        //nothing to do
    }

    @Override
    public String secondValueFromUser() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayCity(String city) {
        //do nothing
    }

    public Parent parent() {
        return time.parent();
    }
}
