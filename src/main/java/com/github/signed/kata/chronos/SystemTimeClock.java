package com.github.signed.kata.chronos;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class SystemTimeClock {

    public DateTime now() {
        return new DateTime(DateTimeZone.UTC);
    }
}
