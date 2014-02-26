package com.github.signed.kata.chronos;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChronosClockDisplay {
    private final JPanel component = new JPanel();
    private final JLabel hours = new JLabel();
    private final JLabel minutes = new JLabel();

    public ChronosClockDisplay() {
        component.add(hours);
        component.add(minutes);
    }

    public void displayHours(String hours){
        this.hours.setText(hours);
    }

    public void displayMinutes(String minutes){
        this.minutes.setText(minutes);
    }

    public JComponent component(){
        return component;
    }
}
