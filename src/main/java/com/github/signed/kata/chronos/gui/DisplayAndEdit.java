package com.github.signed.kata.chronos.gui;

public interface DisplayAndEdit {
    void addEditListener(EditListener editListener);

    String getUserEditedValue();

    void setText(String text);
}
