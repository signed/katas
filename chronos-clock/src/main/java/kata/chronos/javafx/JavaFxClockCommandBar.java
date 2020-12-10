package kata.chronos.javafx;

import kata.chronos.gui.ClockCommandBar;
import kata.chronos.gui.ReverseTimeListener;
import kata.chronos.gui.SwitchNumberSystemListener;
import kata.chronos.gui.ToggleTimeProgression;
import javafx.collections.ObservableList;
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
        stopTimeButton.setOnAction(actionEvent -> toggleTimeProgression.toggle());
    }

    @Override
    public void addReverseTimeListener(final ReverseTimeListener reverseTimeListener) {
        reverseTime.setOnAction(actionEvent -> reverseTimeListener.reverseTime());
    }

    @Override
    public void addSwitchNumberSystemListener(final SwitchNumberSystemListener switchNumberSystemListener) {
        switchNumberSystem.setOnAction(actionEvent -> switchNumberSystemListener.switchNumberSystem());
    }

    public Node node() {
        return content;
    }
}
