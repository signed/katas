package com.github.signed.kata.chronos;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.ClockCabinet;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class CommonLauncher {

    private ChronosClockUpdater chronosClockUpdater;
    private ChronosClock chronosClock;
    private DateTime initialDateAndTime;
    private NumberSystemModel numberSystemModel;

    public static CommonLauncher BuildFrom(String[] args, ClockCabinet clockCabinet) {
        CommonLauncher commonLauncher = new CommonLauncher();
        commonLauncher.parseTimeArgument(args);
        commonLauncher.createModels();
        commonLauncher.createGui(clockCabinet);
        commonLauncher.startTime();
        return commonLauncher;
    }

    public void presentStockExchangeClock(ChronosClock chronosClock, ChronosClockDisplay stockExchangeDisplay, DateTimeZone timeZone, String city, NumberSystemModel numberSystemModel) {
        new ChronosClockPresenter(chronosClock, stockExchangeDisplay, numberSystemModel, new PresenterConfiguration(timeZone, city));
    }

    public DateTime parseTimeArgument(String[] args) {
        initialDateAndTime = new DateTime(attemptToParseMilliseconds(args[0]), DateTimeZone.UTC);
        return initialDateAndTime;
    }

    private Long attemptToParseMilliseconds(String arg) {
        try {
            return Long.valueOf(arg);
        } catch (RuntimeException exception) {
            return 0L;
        }
    }

    public void createModels() {
        chronosClock = new ChronosClock(initialDateAndTime);
        numberSystemModel = new NumberSystemModel(NumberSystem.Arabic);
        chronosClockUpdater = new ChronosClockUpdater(this.chronosClock);
    }

    public void startTime() {
        chronosClockUpdater.startUpdating();
    }

    public void stopTime() {
        chronosClockUpdater.shutdown();
    }

    public void createGui(ClockCabinet clockCabinet) {
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.NewYork(), "NewYork", numberSystemModel);
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.London(), "London", numberSystemModel);
        new ChronosClockPresenter(chronosClock, clockCabinet.hourMinuteDisplay(), numberSystemModel, new PresenterConfiguration(PresenterConfiguration.Athens(), "Olympus"));
        presentStockExchangeClock(chronosClock, clockCabinet.stockExchangeClock(), PresenterConfiguration.Tokyo(), "Tokyo", numberSystemModel);
        new ClockCommandBarPresenter(chronosClock, clockCabinet.commandBar(), numberSystemModel);
    }
}
