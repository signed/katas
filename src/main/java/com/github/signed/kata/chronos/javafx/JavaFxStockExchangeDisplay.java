package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.EditListener;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class JavaFxStockExchangeDisplay implements ChronosClockDisplay {
    private final BorderPane content = new BorderPane();
    private final Label city = new Label();
    private final JavaFxTime time = JavaFxTime.HoursMinutesAndSeconds();

    public JavaFxStockExchangeDisplay() {
        content.setTop(city);
        content.setCenter(time.parent());
    }

    @Override
    public void displayHours(String hours) {
        time.displayHours(hours);
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
        time.displaySeconds(seconds);
    }

    @Override
    public void addSecondEditListener(EditListener editListener) {
        time.addEditListener(JavaFxTime.Type.Seconds, editListener);
    }

    @Override
    public String secondValueFromUser() {
        return time.valueFromUserFor(JavaFxTime.Type.Seconds);
    }

    @Override
    public void displayCity(String city) {
        this.city.setText(city);
    }

    public Parent parent() {
        return content;
    }
}
