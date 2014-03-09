package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.github.signed.kata.chronos.gui.ClockCabinet;
import com.github.signed.kata.chronos.gui.ClockCommandBar;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class JavaFxClockCabinet implements ClockCabinet {
    private final BorderPane content = new BorderPane();
    private final HBox clocks = new HBox();
    private final JavaFxClockCommandBar commandBar = new JavaFxClockCommandBar();

    public JavaFxClockCabinet() {
        content.setLeft(commandBar.node());
        content.setCenter(clocks);
    }

    @Override
    public ChronosClockDisplay hourMinuteDisplay() {
        JavaFxHourAndMinutes hoursAndMinutes = new JavaFxHourAndMinutes();
        clocks.getChildren().add(hoursAndMinutes.parent());
        return hoursAndMinutes;
    }

    @Override
    public ChronosClockDisplay stockExchangeClock() {
        JavaFxStockExchangeDisplay javaFxStockExchangeDisplay = new JavaFxStockExchangeDisplay();
        clocks.getChildren().add(javaFxStockExchangeDisplay.parent());
        return javaFxStockExchangeDisplay;
    }

    @Override
    public ClockCommandBar commandBar() {
        return commandBar;
    }

    public Parent parent() {
        return content;
    }
}
