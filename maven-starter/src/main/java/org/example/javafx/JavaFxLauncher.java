package org.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JavaFxLauncher extends Application {

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        for (String parameter : getParameters().getRaw()) {
            System.out.println(parameter);
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("application name");
        stage.setScene(new Scene(createContent()));
        stage.setWidth(640);
        stage.show();
    }

    private Pane createContent() {
        Label label = new Label("hello world");
        final TextField textField = new TextField();
        Button button = new Button("press me");

        button.addEventHandler(ActionEvent.ACTION, new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textField.setText("Ouch, not so hard...");
            }
        });

        HBox hBox = new HBox();
        hBox.getChildren().add(label);
        hBox.getChildren().add(button);
        hBox.getChildren().add(textField);

        return hBox;
    }

    @Override
    public void stop() throws Exception {
        System.out.println("executed on shutdown");
    }
}
