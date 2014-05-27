package org.example.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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

    private Parent createContent() {
        HBox hBox = new HBox();

        Label label = new Label("hello world");
        final TextField textField = new TextField();
        Button button = new Button("press me");

        button.addEventHandler(ActionEvent.ACTION, new EventHandler<Event>() {
            @Override
            public void handle(Event event) {
                textField.setText("Ouch, not so hard...");
            }
        });

        hBox.getChildren().addAll(label, button, textField);
        return hBox;
    }

    @Override
    public void stop() throws Exception {
        System.out.println("executed on shutdown");
    }
}
