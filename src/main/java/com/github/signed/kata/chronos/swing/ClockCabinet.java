package com.github.signed.kata.chronos.swing;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class ClockCabinet {
    private final JPanel clockCabinet = new JPanel();
    private final ClockCommandBar clockCommandBar = new ClockCommandBar();

    public ClockCabinet() {
        clockCabinet.add(clockCommandBar.component());
    }

    public HoursAndMinutes hourMinuteDisplay() {
        HoursAndMinutes hoursAndMinutes = new HoursAndMinutes();
        clockCabinet.add(hoursAndMinutes.component());
        return hoursAndMinutes;
    }

    public StockExchangeDisplay stockExchangeClock() {
        StockExchangeDisplay stockExchangeDisplay = new StockExchangeDisplay();
        this.clockCabinet.add(stockExchangeDisplay.component());
        return stockExchangeDisplay;
    }

    public void add(JComponent clock){
        clockCabinet.add(clock);
    }

    public ClockCommandBar commandBar(){
        return clockCommandBar;
    }

    public JComponent component(){
        return clockCabinet;
    }
}
