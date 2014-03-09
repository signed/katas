package com.github.signed.kata.chronos.swing;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.EditListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

public class StockExchangeDisplay implements ChronosClockDisplay {

    private static JLabel separator() {
        return new JLabel(":");
    }

    private final JPanel content = new JPanel(new BorderLayout());
    private final JLabel city = new JLabel();
    private final SwingDisplayAndEdit hours = new SwingDisplayAndEdit();
    private final SwingDisplayAndEdit minutes = new SwingDisplayAndEdit();

    private final SwingDisplayAndEdit seconds = new SwingDisplayAndEdit();

    public StockExchangeDisplay() {
        JPanel time = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        time.add(hours.component());
        time.add(separator());
        time.add(minutes.component());
        time.add(separator());
        time.add(seconds.component());

        content.add(city, BorderLayout.NORTH);
        content.add(time, BorderLayout.CENTER);
    }

    @Override
    public void displayHours(String hours) {
        this.hours.setText(hours);
    }

    @Override
    public void addHourEditListener(EditListener editListener) {
        this.hours.addEditListener(editListener);
    }

    @Override
    public String hourValueFromUser() {
        return hours.getUserEditedValue();
    }

    @Override
    public void displayMinutes(String minutes) {
        this.minutes.setText(minutes);
    }

    @Override
    public void addMinuteEditListener(EditListener editListener) {
        this.minutes.addEditListener(editListener);
    }

    @Override
    public String minuteValueFromUser() {
        return this.minutes.getUserEditedValue();
    }

    @Override
    public void displaySeconds(String seconds) {
        this.seconds.setText(seconds);
    }

    @Override
    public void addSecondEditListener(EditListener editListener) {
        this.seconds.addEditListener(editListener);
    }

    @Override
    public String secondValueFromUser() {
        return this.seconds.getUserEditedValue();
    }

    @Override
    public void displayCity(String city) {
        this.city.setText(city);
    }

    public JPanel component() {
        return content;
    }
}
