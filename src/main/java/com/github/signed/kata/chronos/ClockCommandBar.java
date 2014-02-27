package com.github.signed.kata.chronos;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockCommandBar {
    private final JPanel components = new JPanel();
    private final JButton timeToggleButton = new JButton();
    private final JButton reverseTime = new JButton("Reverse time");

    public ClockCommandBar() {
        components.setLayout(new BoxLayout(components, BoxLayout.Y_AXIS));

        layoutAndAdd(timeToggleButton);
        layoutAndAdd(reverseTime);
    }

    private void layoutAndAdd(JButton button) {
        button.setAlignmentX(Component.LEFT_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        components.add(button);
    }

    public void displayStopTimeButton(){
        timeToggleButton.setText("Stop time");
    }

    public void displayStartTimeButton(){
        timeToggleButton.setText("Start time");
    }

    public void addTimeToggleListener(final ToggleTimeProgression toggleTimeProgression) {
        timeToggleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleTimeProgression.toggle();
            }
        });
    }

    public void addReverseTimeListener(final ReverseTimeListener reverseTimeListener){
        reverseTime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reverseTimeListener.reverseTime();
            }
        });
    }

    public JComponent component(){
        return components;
    }
}
