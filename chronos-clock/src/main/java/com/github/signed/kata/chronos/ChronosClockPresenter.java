package com.github.signed.kata.chronos;

import com.github.signed.kata.chronos.gui.ChronosClockDisplay;
import com.google.common.collect.ImmutableMap;
import org.joda.time.DateTime;

import java.util.Map;

public class ChronosClockPresenter {

    private final ChronosClock chronosClock;
    private final NumberSystemModel numberSystemModel;
    private final PresenterConfiguration configuration;
    private final ChronosClockDisplay chronosClockDisplay;
    private final Map<NumberSystem, NumberRenderer> renders = ImmutableMap.of(NumberSystem.Arabic, new ArabicNumberRenderer(), NumberSystem.Roman, new RomanNumberRenderer());


    public ChronosClockPresenter(final ChronosClock chronosClock, final ChronosClockDisplay chronosClockDisplay, NumberSystemModel numberSystemModel, final PresenterConfiguration configuration) {
        this.numberSystemModel = numberSystemModel;
        this.configuration = configuration;
        this.chronosClock = chronosClock;
        this.chronosClockDisplay = chronosClockDisplay;
        chronosClock.addTimeChangedListener(new TimeChangedListener() {
            @Override
            public void timeChanged() {
                ChronosClockPresenter.this.present();
            }
        });
        chronosClockDisplay.addHourEditListener(new SetHourListener(chronosClockDisplay, chronosClock, configuration));
        chronosClockDisplay.addMinuteEditListener(new SetMinuteListener(chronosClockDisplay, chronosClock));
        chronosClockDisplay.addSecondEditListener(new SetSecondsListener(chronosClockDisplay, chronosClock));
    }

    public void present() {
        DateTime now = chronosClock.now().toDateTime(configuration.timeZone);
        chronosClockDisplay.displayCity(configuration.city);
        chronosClockDisplay.displayHours(numberRenderer().renderHoursOfDay(now.getHourOfDay()));
        chronosClockDisplay.displayMinutes(numberRenderer().renderMinutesOfHour(now.getMinuteOfHour()));
        chronosClockDisplay.displaySeconds(numberRenderer().renderSecondsOfMinute(now.getSecondOfMinute()));
    }

    private NumberRenderer numberRenderer() {
        return renders.get(numberSystemModel.current());
    }

}
