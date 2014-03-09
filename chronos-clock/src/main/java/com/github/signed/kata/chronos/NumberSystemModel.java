package com.github.signed.kata.chronos;

import com.google.common.collect.Sets;

import java.util.Set;

public class NumberSystemModel {
    private final Set<NumberSystemChangedListener> numberSystemChangedListeners = Sets.newHashSet();
    private NumberSystem numberSystem;

    public NumberSystemModel(NumberSystem numberSystem) {
        this.numberSystem = numberSystem;
    }

    public void toggleNumericSystem() {
        this.numberSystem = this.numberSystem.other();
        for (NumberSystemChangedListener numberSystemChangedListener : numberSystemChangedListeners) {
            numberSystemChangedListener.numberSystemChanged();
        }
    }

    public void add(NumberSystemChangedListener numberSystemChangedListener) {
        numberSystemChangedListeners.add(numberSystemChangedListener);
    }

    public NumberSystem current(){
        return numberSystem;
    }
}
