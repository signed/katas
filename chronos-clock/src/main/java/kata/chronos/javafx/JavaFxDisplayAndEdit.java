package kata.chronos.javafx;

import kata.chronos.gui.DisplayAndEdit;
import kata.chronos.gui.EditListener;
import com.google.common.collect.Sets;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

import java.util.Set;

public class JavaFxDisplayAndEdit implements DisplayAndEdit {

    private final Set<EditListener> editListeners = Sets.newHashSet();

    private final StackPane content = new StackPane();
    private final TextField edit = new TextField();
    private final Label display = new Label();

    public JavaFxDisplayAndEdit() {
        content.getChildren().addAll(edit, display);


        display.setStyle("-fx-border-width: 4;-fx-border-color: transparent;");

        edit.setVisible(false);
        edit.maxHeightProperty().bind(display.heightProperty());
        edit.prefHeightProperty().bind(display.heightProperty());
        edit.minHeightProperty().bind(display.heightProperty());
        edit.maxWidthProperty().bind(display.widthProperty());
        edit.prefWidthProperty().bind(display.widthProperty());
        edit.minWidthProperty().bind(display.widthProperty());
        display.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> edit());
        edit.addEventHandler(KeyEvent.KEY_PRESSED, keyEvent -> {
            if (KeyCode.ESCAPE == keyEvent.getCode()) {
                displayAndGrabFocus();
                keyEvent.consume();
            } else if (KeyCode.ENTER == keyEvent.getCode()) {
                notifyEditListener();
                displayAndGrabFocus();
                keyEvent.consume();
            }
        });
    }

    private void displayAndGrabFocus() {
        display();
        display.requestFocus();
    }

    private void notifyEditListener() {
        for (EditListener editListener : editListeners) {
            editListener.edit();
        }
    }

    @Override
    public void addEditListener(EditListener editListener) {
        editListeners.add(editListener);
    }

    @Override
    public void setText(String text) {
        display.setText(text);
    }

    @Override
    public String getUserEditedValue() {
        return edit.getText();
    }

    public Parent parent() {
        return content;
    }

    private void edit() {
        edit.setText(display.getText());
        display.setVisible(false);
        edit.setVisible(true);
        edit.focusedProperty().addListener(new ChangeListener<>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    observableValue.removeListener(this);
                    display();
                }
            }
        });
        edit.requestFocus();
    }

    private void display() {
        display.setVisible(true);
        edit.setVisible(false);
    }
}
