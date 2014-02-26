package com.github.signed.kata.chronos;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class StockExchangeDisplay implements ChronosClockDisplay{
    private final JPanel content = new JPanel(new BorderLayout());
    private final JLabel city = new JLabel();
    private final JLabel hours = new JLabel();
    private final JLabel minutes = new JLabel();
    private final JLabel seconds = new JLabel();

    public StockExchangeDisplay() {
        JPanel time = new JPanel();
        time.add(hours);
        time.add(minutes);
        time.add(seconds);

        content.add(city, BorderLayout.NORTH);
        content.add(time, BorderLayout.CENTER);
    }

    @Override
    public void displayHours(String hours) {
        this.hours.setText(hours);
    }

    @Override
    public void displayMinutes(String minutes) {
        this.minutes.setText(minutes);
    }

    @Override
    public void displaySeconds(String seconds) {
        this.seconds.setText(seconds);
    }

    @Override
    public void displayCity(String city) {
        this.city.setText(city);
    }

    public JPanel component(){
        return content;
    }
}
