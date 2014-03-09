package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.CommonLauncher;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class JavaFxLauncher extends Application {

    private final JavaFxClockCabinet clockCabinet = new JavaFxClockCabinet();
    private CommonLauncher commonLauncher;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() throws Exception {
        Parameters parameters = getParameters();
        commonLauncher = CommonLauncher.BuildFrom(parameters.getUnnamed().toArray(new String[1]), clockCabinet);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Chronos Clock");
        stage.setScene(new Scene(clockCabinet.parent()));
        stage.setWidth(640);
        stage.show();
    }

    @Override
    public void stop() throws Exception {
        commonLauncher.stopTime();
    }
}
