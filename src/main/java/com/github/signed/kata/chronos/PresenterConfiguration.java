package com.github.signed.kata.chronos;

import org.joda.time.DateTimeZone;

import java.util.TimeZone;

public class PresenterConfiguration {

    public static DateTimeZone Athens() {
        return dateTimeZoneFor("Europe/Athens");
    }

    public static DateTimeZone NewYork(){
        return dateTimeZoneFor("America/New_York");
    }

    public static DateTimeZone London(){
        return dateTimeZoneFor("Europe/London");
    }

    public static DateTimeZone Tokyo(){
        return dateTimeZoneFor("Asia/Tokyo");
    }

    private static DateTimeZone dateTimeZoneFor(String timeZone) {
        TimeZone athens = TimeZone.getTimeZone(timeZone);
        return DateTimeZone.forTimeZone(athens);
    }

    public final DateTimeZone timeZone;
    public final String city;

    public PresenterConfiguration(DateTimeZone timeZone, String city) {
        this.timeZone = timeZone;
        this.city = city;
    }
}
