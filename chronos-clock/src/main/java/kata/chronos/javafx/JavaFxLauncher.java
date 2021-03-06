package kata.chronos.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFxLauncher extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() {
        for (String parameter : getParameters().getRaw()) {
            System.out.println(parameter);
        }
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("application name");
        stage.setScene(new Scene(createContent()));
        stage.setWidth(640);
        stage.show();
    }

    private Pane createContent() {
        Label label = new Label("hello world");
        final TextField textField = new TextField();
        final Button button = new Button("press me");

        listenToButtonPressAndRespond(textField, button);
        listenToTextInputAndUpdateButtonText(textField, button);

        HBox hBox = new HBox();
        hBox.getChildren().add(label);
        hBox.getChildren().add(button);
        hBox.getChildren().add(textField);

        return hBox;
    }

    private void listenToButtonPressAndRespond(final TextField textField, Button button) {
        button.addEventHandler(ActionEvent.ACTION, event -> textField.setText("Ouch, not so hard..."));
    }

    private void listenToTextInputAndUpdateButtonText(final TextField textField, final Button button) {
        textField.setOnAction(actionEvent -> button.setText(textField.getText()));
    }

    @Override
    public void stop() {
        System.out.println("executed on shutdown");
    }
}
