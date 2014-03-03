package com.github.signed.kata.chronos.swing;

import com.github.signed.kata.chronos.ReverseTimeListener;
import com.github.signed.kata.chronos.SwitchNumberSystemListener;
import com.github.signed.kata.chronos.ToggleTimeProgression;

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
    private final JButton switchNumberSystem = new JButton("Switch number system");

    public ClockCommandBar() {
        components.setLayout(new BoxLayout(components, BoxLayout.Y_AXIS));

        layoutAndAdd(timeToggleButton);
        layoutAndAdd(reverseTime);
        layoutAndAdd(switchNumberSystem);
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

    public void addSwitchNumberSystemListener(final SwitchNumberSystemListener switchNumberSystemListener){
        switchNumberSystem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchNumberSystemListener.switchNumberSystem();
            }
        });
    }

    public JComponent component(){
        return components;
    }
}
