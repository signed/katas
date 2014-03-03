package com.github.signed.kata.chronos.swing;

import com.github.signed.kata.chronos.ChronosClock;
import com.github.signed.kata.chronos.ChronosClockPresenter;
import com.github.signed.kata.chronos.ChronosClockUpdater;
import com.github.signed.kata.chronos.ClockCommandBarPresenter;
import com.github.signed.kata.chronos.NumberSystem;
import com.github.signed.kata.chronos.NumberSystemModel;
import com.github.signed.kata.chronos.PresenterConfiguration;
import com.github.signed.kata.chronos.swing.ClockCabinet;
import com.github.signed.kata.chronos.swing.StockExchangeDisplay;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ChronosClockLauncher {

    public static void main(String[] args) {
        final DateTime dateTime = parseTimeArgument(args[0]);

        final ChronosClock chronosClock = new ChronosClock(dateTime);
        final NumberSystemModel numberSystemModel = new NumberSystemModel(NumberSystem.Arabic);

        final ClockCabinet clockCabinet = new ClockCabinet();
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.NewYork(), "NewYork", numberSystemModel);
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.London(), "London", numberSystemModel);
        new ChronosClockPresenter(chronosClock, clockCabinet.hourMinuteDisplay(), numberSystemModel, new PresenterConfiguration(PresenterConfiguration.Athens(), "Olympus"));
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.Tokyo(), "Tokyo", numberSystemModel);
        new ClockCommandBarPresenter(chronosClock, clockCabinet.commandBar(), numberSystemModel);


        new ChronosClockUpdater(chronosClock).startUpdating();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI(clockCabinet.component());
            }
        });
    }

    private static void presentStockExchangeClock(ChronosClock chronosClock, StockExchangeDisplay newYorkDisplay, DateTimeZone timeZone, String city, NumberSystemModel numberSystemModel) {
        new ChronosClockPresenter(chronosClock, newYorkDisplay, numberSystemModel, new PresenterConfiguration(timeZone, city));
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
