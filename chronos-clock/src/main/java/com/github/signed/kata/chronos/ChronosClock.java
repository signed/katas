package com.github.signed.kata.chronos;

import com.google.common.collect.Sets;
import org.joda.time.DateTime;

import java.util.Set;

public class ChronosClock {

    private final Set<TimeProgressionListener> progressionListeners = Sets.newHashSet();
    private final Set<TimeChangedListener> timeChangedListeners = Sets.newHashSet();
    private final SystemTimeClock systemTimeClock = new SystemTimeClock();
    private boolean timeStopped = false;
    private boolean reverseTime = false;
    private DateTime lastUpdated;
    private DateTime now;

    public ChronosClock(DateTime dateTime) {
        this.now = dateTime;
        this.lastUpdated = systemTimeClock.now();
    }

    public void setHoursOfDayTo(int hours) {
        now = now.withHourOfDay(hours);
        fireTimeChanged();
    }

    public void setMinutesOfHour(int seconds) {
        now = now.withMinuteOfHour(seconds);
        fireTimeChanged();
    }

    public void setSecondsOfHourTo(int seconds) {
        now = now.withSecondOfMinute(seconds);
        fireTimeChanged();
    }


    public void determineNow() {
        if (timeStopped) {
            return;
        }
        DateTime systemTime = systemTimeClock.now();
        long timePassedSinceLastUpdate = systemTime.getMillis() - lastUpdated.getMillis();
        if (reverseTime) {
            now = now.minusMillis(Long.valueOf(timePassedSinceLastUpdate).intValue());
        } else {
            now = now.plusMillis(Long.valueOf(timePassedSinceLastUpdate).intValue());
        }
        lastUpdated = systemTime;
        fireTimeChanged();
    }

    public DateTime now() {
        return now;
    }

    public void toggleTimeProgression() {
        if (timeStopped) {
            timeStopped = false;
            lastUpdated = systemTimeClock.now();
        } else {
            determineNow();
            timeStopped = true;
        }
        notifyProgressionListeners();
    }

    public void reverseTime() {
        determineNow();
        reverseTime = !reverseTime;
    }

    public void stopTime() {
        determineNow();
        timeStopped = true;
        notifyProgressionListeners();
    }

    private void startTime() {
        timeStopped = false;
        lastUpdated = systemTimeClock.now();
        notifyProgressionListeners();
    }

    public void addTimeProgressionListener(TimeProgressionListener timeProgressionListener) {
        this.progressionListeners.add(timeProgressionListener);
        fire(timeProgressionListener);
    }

    public void addTimeChangedListener(TimeChangedListener timeChangedListener) {
        this.timeChangedListeners.add(timeChangedListener);
    }

    private void notifyProgressionListeners() {
        for (TimeProgressionListener progressionListener : progressionListeners) {
            fire(progressionListener);
        }
    }

    private void fire(TimeProgressionListener progressionListener) {
        if (timeStopped) {
            progressionListener.stopped();
        } else {
            progressionListener.progresses();
        }
    }

    private void fireTimeChanged() {
        for (TimeChangedListener timeChangedListener : timeChangedListeners) {
            timeChangedListener.timeChanged();
        }
    }
}
