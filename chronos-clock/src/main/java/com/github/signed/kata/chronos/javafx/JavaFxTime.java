package com.github.signed.kata.chronos.javafx;

import com.github.signed.kata.chronos.gui.EditListener;
import com.google.common.base.Functions;
import com.google.common.collect.Maps;
import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.util.Map;

public class JavaFxTime {

    public static JavaFxTime HoursAndMinutes() {
        Map<Type, JavaFxDisplayAndEdit> nodes = Maps.newHashMap();
        nodes.put(Type.Hours, new JavaFxDisplayAndEdit());
        nodes.put(Type.Minutes, new JavaFxDisplayAndEdit());
        return new JavaFxTime(nodes);
    }

    public static JavaFxTime HoursMinutesAndSeconds() {
        Map<Type, JavaFxDisplayAndEdit> nodes = Maps.newHashMap();
        nodes.put(Type.Hours, new JavaFxDisplayAndEdit());
        nodes.put(Type.Minutes, new JavaFxDisplayAndEdit());
        nodes.put(Type.Seconds, new JavaFxDisplayAndEdit());
        return new JavaFxTime(nodes);
    }

    public void addEditListener(Type type, EditListener editListener) {
        nodes.get(type).addEditListener(editListener);
    }

    public String valueFromUserFor(Type type) {
        return nodes.get(type).getUserEditedValue();
    }

    public static enum Type {
        Hours,
        Minutes,
        Seconds,
    }

    private static Label separator() {
        return new Label(":");
    }

    private final JavaFxDisplayAndEdit dummy = new JavaFxDisplayAndEdit();
    private final HBox content = new HBox();
    private final Map<Type, JavaFxDisplayAndEdit> nodes;

    public JavaFxTime(Map<Type, JavaFxDisplayAndEdit> nodes) {
        this.nodes = nodes;
        for (Type type : Type.values()) {
            if (nodes.containsKey(type)) {
                content.getChildren().addAll(nodes.get(type).parent(), separator());
            }
        }
        content.getChildren().remove(content.getChildren().size() - 1);
    }

    public void displayHours(String hours) {
        set(Type.Hours, hours);
    }

    public void displayMinutes(String minutes) {
        set(Type.Minutes, minutes);
    }

    public void displaySeconds(String seconds) {
        set(Type.Seconds, seconds);
    }

    @SuppressWarnings("ConstantConditions")
    private void set(final Type type, final String value) {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                Functions.forMap(nodes, dummy).apply(type).setText(value);
            }
        });

    }

    public Parent parent() {
        return content;
    }
}
