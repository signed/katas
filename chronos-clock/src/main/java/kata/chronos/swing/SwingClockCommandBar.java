package kata.chronos.swing;

import kata.chronos.gui.ClockCommandBar;
import kata.chronos.gui.ReverseTimeListener;
import kata.chronos.gui.SwitchNumberSystemListener;
import kata.chronos.gui.ToggleTimeProgression;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingClockCommandBar implements ClockCommandBar {
    private final JPanel components = new JPanel();
    private final JButton timeToggleButton = new JButton();
    private final JButton reverseTime = new JButton("Reverse time");
    private final JButton switchNumberSystem = new JButton("Switch number system");

    public SwingClockCommandBar() {
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

    @Override
    public void displayStopTimeButton() {
        timeToggleButton.setText("Stop time");
    }

    @Override
    public void displayStartTimeButton() {
        timeToggleButton.setText("Start time");
    }

    @Override
    public void addTimeToggleListener(final ToggleTimeProgression toggleTimeProgression) {
        timeToggleButton.addActionListener(e -> toggleTimeProgression.toggle());
    }

    @Override
    public void addReverseTimeListener(final ReverseTimeListener reverseTimeListener) {
        reverseTime.addActionListener(e -> reverseTimeListener.reverseTime());
    }

    @Override
    public void addSwitchNumberSystemListener(final SwitchNumberSystemListener switchNumberSystemListener) {
        switchNumberSystem.addActionListener(e -> switchNumberSystemListener.switchNumberSystem());
    }

    public JComponent component() {
        return components;
    }
}
