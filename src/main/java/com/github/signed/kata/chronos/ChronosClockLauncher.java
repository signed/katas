package com.github.signed.kata.chronos;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ChronosClockLauncher {

    public static void main(String[] args) {
        final DateTime dateTime = parseTimeArgument(args[0]);

        final ChronosClock chronosClock = new ChronosClock(dateTime);
        final ClockCabinet clockCabinet = new ClockCabinet();
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.NewYork(), "NewYork");
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.London(), "London");
        new ChronosClockPresenter(chronosClock, clockCabinet.hourMinuteDisplay(), new PresenterConfiguration(PresenterConfiguration.Athens(), "Olympus"));
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.Tokyo(), "Tokyo");
        new ClockCommandBarPresenter(chronosClock, clockCabinet.commandBar());


        new ChronosClockUpdater(chronosClock).startUpdating();


        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(clockCabinet.component());
            }
        });
    }

    private static void presentStockExchangeClock(ChronosClock chronosClock, StockExchangeDisplay newYorkDisplay, DateTimeZone timeZone, String city) {
        new ChronosClockPresenter(chronosClock, newYorkDisplay, new PresenterConfiguration(timeZone, city));
    }

    private static DateTime parseTimeArgument(String arg) {
        return new DateTime(Long.valueOf(arg), DateTimeZone.UTC);
    }

    private static void createAndShowGUI(JComponent display) {
        //Create and set up the window.
        JFrame frame = new JFrame("Chronos Clock");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(display);
        frame.pack();
        frame.setVisible(true);
    }
}
