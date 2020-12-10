package kata.chronos.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kata.chronos.CommonLauncher;

public class JavaFxLauncher extends Application {

    private final JavaFxClockCabinet clockCabinet = new JavaFxClockCabinet();
    private CommonLauncher commonLauncher;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void init() {
        Parameters parameters = getParameters();
        String[] args = parameters.getUnnamed().toArray(new String[1]);
        commonLauncher = CommonLauncher.BuildFrom(args, clockCabinet);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Chronos Clock");
        stage.setScene(new Scene(clockCabinet.parent()));
        stage.setWidth(640);
        stage.show();
    }

    @Override
    public void stop() {
        commonLauncher.stopTime();
    }
}

