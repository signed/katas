package kata.chronos.swing;

import kata.chronos.gui.ChronosClockDisplay;
import kata.chronos.gui.ClockCabinet;
import kata.chronos.gui.ClockCommandBar;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class SwingClockCabinet implements ClockCabinet {
    private final JPanel clockCabinet = new JPanel();
    private final SwingClockCommandBar clockCommandBar = new SwingClockCommandBar();

    public SwingClockCabinet() {
        clockCabinet.add(clockCommandBar.component());
    }

    @Override
    public ChronosClockDisplay hourMinuteDisplay() {
        HoursAndMinutes hoursAndMinutes = new HoursAndMinutes();
        clockCabinet.add(hoursAndMinutes.component());
        return hoursAndMinutes;
    }

    @Override
    public ChronosClockDisplay stockExchangeClock() {
        StockExchangeDisplay stockExchangeDisplay = new StockExchangeDisplay();
        this.clockCabinet.add(stockExchangeDisplay.component());
        return stockExchangeDisplay;
    }

    @Override
    public ClockCommandBar commandBar() {
        return clockCommandBar;
    }

    public JComponent component() {
        return clockCabinet;
    }
}
