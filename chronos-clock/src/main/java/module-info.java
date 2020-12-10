module kata.chronos {
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    opens kata.chronos.javafx to javafx.base, javafx.controls, javafx.graphics;
}
