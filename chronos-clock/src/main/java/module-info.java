module kata.chronos {
    requires guava;
    requires joda.time;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    opens kata.chronos.javafx to javafx.base, javafx.controls, javafx.graphics;
}
