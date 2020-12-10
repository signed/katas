module com.github.signed.kata.chronos {
    requires guava;
    requires joda.time;
    requires javafx.graphics;
    requires javafx.controls;
    requires java.desktop;
    opens com.github.signed.kata.chronos.javafx to javafx.base, javafx.controls, javafx.graphics;
    opens kata.chronos.javafx to javafx.base, javafx.controls, javafx.graphics;
}
