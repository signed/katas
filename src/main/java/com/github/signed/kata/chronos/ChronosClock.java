package com.github.signed.kata.chronos;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.util.TimeZone;

public class ChronosClock {

    public static void main(String [] args){
        TimeZone athens = TimeZone.getTimeZone("Europe/Athens");
        DateTimeZone zone = DateTimeZone.forTimeZone(athens);
        final DateTime dateTime = new DateTime(Long.valueOf(args[0]),zone);
        System.out.println(dateTime);
    }


}
