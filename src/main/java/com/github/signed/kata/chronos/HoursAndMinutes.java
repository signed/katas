package com.github.signed.kata.chronos;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HoursAndMinutes implements ChronosClockDisplay {
    private final JPanel component = new JPanel();
    private final JLabel hours = new JLabel();
    private final JLabel minutes = new JLabel();

    public HoursAndMinutes() {
        component.add(hours);
        component.add(minutes);
    }

    @Override
    public void displayHours(String hours){
        this.hours.setText(hours);
    }

    @Override
    public void displayMinutes(String minutes){
        this.minutes.setText(minutes);
    }

    @Override
    public void displaySeconds(String seconds) {
        //do nothing
    }

    @Override
    public void displayCity(String city) {

    }

    public JComponent component(){
        return component;
    }
}
