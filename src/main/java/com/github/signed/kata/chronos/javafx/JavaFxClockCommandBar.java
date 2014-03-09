package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.gui.ClockCommandBar;
import com.github.signed.kata.chronos.gui.ReverseTimeListener;
import com.github.signed.kata.chronos.gui.SwitchNumberSystemListener;
import com.github.signed.kata.chronos.gui.ToggleTimeProgression;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class JavaFxClockCommandBar implements ClockCommandBar {
    private final VBox content = new VBox();
    private final Button stopTimeButton = new Button();
    private final Button reverseTime = new Button("reverse time");
    private final Button switchNumberSystem = new Button("switch number system");

    public JavaFxClockCommandBar() {
        ObservableList<Node> children = content.getChildren();
        children.add(stopTimeButton);
        children.add(reverseTime);
        children.add(switchNumberSystem);
    }

    @Override
    public void displayStopTimeButton() {
        stopTimeButton.setText("Stop time");
    }

    @Override
    public void displayStartTimeButton() {
        stopTimeButton.setText("Start time");
    }

    @Override
    public void addTimeToggleListener(final ToggleTimeProgression toggleTimeProgression) {
        stopTimeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                toggleTimeProgression.toggle();
            }
        });
    }

    @Override
    public void addReverseTimeListener(final ReverseTimeListener reverseTimeListener) {
        reverseTime.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                reverseTimeListener.reverseTime();
            }
        });
    }

    @Override
    public void addSwitchNumberSystemListener(final SwitchNumberSystemListener switchNumberSystemListener) {
        switchNumberSystem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                switchNumberSystemListener.switchNumberSystem();
            }
        });
    }

    public Node node() {
        return content;
    }
}
