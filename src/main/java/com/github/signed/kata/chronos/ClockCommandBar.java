package com.github.signed.kata.chronos;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockCommandBar {
    private final JPanel components = new JPanel();
    private final JButton timeToggleButton = new JButton();

    public ClockCommandBar() {
        new BoxLayout(components, BoxLayout.Y_AXIS);
        components.add(timeToggleButton);
    }

    public void displayStopTimeButton(){
        timeToggleButton.setText("Stop time");
    }

    public void displayStartTimeButton(){
        timeToggleButton.setText("Start time");
    }

    public JComponent component(){
        return components;
    }

    public void addTimeToggleListener(final ToggleTimeProgression toggleTimeProgression) {
        timeToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTimeProgression.toggle();
            }
        });
    }
}
