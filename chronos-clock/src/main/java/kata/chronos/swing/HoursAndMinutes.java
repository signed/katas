package kata.chronos.swing;

import kata.chronos.gui.ChronosClockDisplay;
import kata.chronos.gui.EditListener;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;

public class HoursAndMinutes implements ChronosClockDisplay {
    private final JPanel component = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
    private final SwingDisplayAndEdit hours = new SwingDisplayAndEdit();
    private final JLabel separator = new JLabel(":");
    private final SwingDisplayAndEdit minutes = new SwingDisplayAndEdit();

    public HoursAndMinutes() {
        component.add(hours.component());
        component.add(separator);
        component.add(minutes.component());
    }

    @Override
    public void displayHours(String hours) {
        this.hours.setText(hours);
    }

    @Override
    public void addHourEditListener(EditListener editListener) {
        hours.addEditListener(editListener);
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
        //do nothing
    }

    @Override
    public void addSecondEditListener(EditListener editListener) {
        //do nothing
    }

    @Override
    public String secondValueFromUser() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void displayCity(String city) {

    }


    public JComponent component() {
        return component;
    }
}
