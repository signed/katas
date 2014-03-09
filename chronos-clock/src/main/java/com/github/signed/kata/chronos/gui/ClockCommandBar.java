package com.github.signed.kata.chronos.gui;

public interface ClockCommandBar {
    void displayStopTimeButton();

    void displayStartTimeButton();

    void addTimeToggleListener(ToggleTimeProgression toggleTimeProgression);

    void addReverseTimeListener(ReverseTimeListener reverseTimeListener);

    void addSwitchNumberSystemListener(SwitchNumberSystemListener switchNumberSystemListener);
}
